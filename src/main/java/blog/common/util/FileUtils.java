package blog.common.util;

import blog.common.enumeration.StatusCodeEnum;
import blog.common.except.BusinessException;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

/**
 * 文件上传工具类
 *
 * @author 水张哲
 * @date 2021年3月26日
 */
@Log4j2
@Component
public class FileUtils {
    /** 文件上传基础路径 */
    private final static String UPLOAD_PATH_PREFIX = "uploadFile/";

    /**
     * 批量上传文件
     *
     * @param file 文件集
     * @param filePath 文件存放目录
     * @author 水张哲
     * @date 2021年3月26日
     */
    @Transactional(rollbackFor = BusinessException.class)
    public void uploadFiles(MultipartFile[] file, String filePath){
        // 文件存放根目录
        String rootPath = "src/main/resources/" + UPLOAD_PATH_PREFIX + filePath;
        // 存放上传文件的文件夹
        File fileFolder = new File(rootPath);
        // 判断路径文件夹是否存在
        if(!fileFolder.exists()){
            // 递归生成文件夹
            boolean mkdirsStatus = fileFolder.mkdirs();
            // 应该创建文件夹的时候发生错误导致文件夹未创建成功
            if (!mkdirsStatus){
                throw new BusinessException(StatusCodeEnum.FILE_MKDIR_ERROR);
            }
        }
        // 检查路径合法性
        if(fileFolder.isDirectory()){
            for(MultipartFile f : file){
                // 获得文件基本资料（项目名称、类型、文件大小）
                String fileName = f.getOriginalFilename();
                // 获取文件完整URI
                String uri = rootPath + fileName;
                try{
                    // 文件上传
                    f.transferTo(Paths.get(uri));
                    log.info("URI:'" + filePath + fileName +" '上传成功!");
                }catch (Exception e){
                    throw new BusinessException(StatusCodeEnum.FILE_UPLOAD_ERROR, e, "上传文件[" + fileName + "]失败!");
                }
            }
        }else {
            throw new BusinessException(StatusCodeEnum.FILE_URI_ERROR);
        }
    }


    /**
     * 上传文件
     *
     * @param file 文件
     * @param filePath 文件存放目录
     * @author 水张哲
     * @date 2021年3月26日
     */
    @Transactional(rollbackFor = BusinessException.class)
    public void uploadFile(MultipartFile file, String filePath){
        // 文件存放根目录
        String rootPath = "src/main/resources/" + UPLOAD_PATH_PREFIX + filePath;
        // 存放上传文件的文件夹
        File fileFolder = new File(rootPath);
        // 判断路径文件夹是否存在
        if(!fileFolder.exists()){
            // 递归生成文件夹
            boolean mkdirsStatus = fileFolder.mkdirs();
            // 应该创建文件夹的时候发生错误导致文件夹未创建成功
            if (!mkdirsStatus){
                throw new BusinessException(StatusCodeEnum.FILE_MKDIR_ERROR);
            }
        }
        // 检查路径合法性
        if(fileFolder.isDirectory()){
            // 获得文件名称
            String fileName = file.getOriginalFilename();
            // 获取文件完整URI
            String uri = rootPath + fileName;
            try{
                // 文件上传
                file.transferTo(Paths.get(uri));
                log.info("URI:'" + filePath + fileName +" '上传成功!");
            }catch (Exception e){
                throw new BusinessException(StatusCodeEnum.FILE_UPLOAD_ERROR, e, "上传文件[" + fileName + "]失败!");
            }
        }else {
            throw new BusinessException(StatusCodeEnum.FILE_URI_ERROR);
        }
    }

    /**
     * 下载文件
     *
     * @param filePath 文件存放目录
     * @author 水张哲
     * @date 2021年3月26日
     */
    @Transactional(rollbackFor = BusinessException.class)
    public void downloadFile(String filePath, HttpServletResponse response){
        InputStream inputStream;
        OutputStream outputStream;
        String uri = "src/main/resources/" + UPLOAD_PATH_PREFIX + filePath;
        File file = new File(uri);
        if (file.exists()){
            try{
                String fileName = filePath.split("/")[filePath.split("/").length - 1];
                inputStream = new FileInputStream(uri);
                byte[] bytes = new byte[inputStream.available()];
                if(inputStream.read(bytes) >= 0){
                    response.reset();
                    response.setHeader("Access-Control-Expose-Headers","Content-Disposition");
                    response.setHeader("Access-Control-Allow-Origin", "*");
                    response.addHeader("Content-Length", "" + file.length());
                    response.setHeader("Content-Disposition", "attachment; filename="+java.net.URLEncoder.encode(fileName, "UTF-8"));
                    outputStream = response.getOutputStream();
                    outputStream.write(bytes);
                    outputStream.flush();
                    // 关闭
                    outputStream.close();
                    inputStream.close();
                }
            }catch (Exception e){
                throw new BusinessException(StatusCodeEnum.FILE_DOWNLOAD_ERROR);
            }
        }else {
            throw new BusinessException(StatusCodeEnum.NOT_FOUND);
        }
    }

    /**
     * 删除指定文件
     *
     * @param filePath 文件存放目录
     * @author 水张哲
     * @date 2021年3月29日
     */
    @Transactional(rollbackFor = BusinessException.class)
    public void dropFile(String filePath){

        String fileName = filePath.substring(filePath.lastIndexOf("/")+1);

        ApplicationHome applicationHome = new ApplicationHome(getClass());
        File jarFile = applicationHome.getSource();
        // 根据指定的文件名创建File对象
        String uri = jarFile.getParentFile().toString() + File.separator + UPLOAD_PATH_PREFIX + fileName;
        File file = new File(uri);
        // 文件不存在
        if (!file.exists()){
            throw new BusinessException(StatusCodeEnum.FILE_NO_EXISTS_ERROR);
        }else{
            if (file.isFile()){
                if(file.delete()){
                    log.info("文件:'"+ fileName + "' 删除成功!");
                }else {
                    throw new BusinessException(StatusCodeEnum.FILE_DELETE_ERROR);
                }
            }else {
                throw new BusinessException(StatusCodeEnum.FILE_TYPE_ERROR, "该对象不为文件!");
            }
        }
    }

    /**
     * 删除文件夹及内容
     *
     * ######################### 注  意 ############################
     * 1. 此操作为危险操作，使用前需要对 filePath 进行判断！
     * 2. 防止 filePath 为 "/" 导致 static 内文件全部被删除!
     * ############################################################
     *
     * @param filePath 文件存放目录
     * @author 水张哲
     * @date 2021年3月29日
     */
    @Transactional(rollbackFor = BusinessException.class)
    public void dropFolder(String filePath){
        // 根据指定的文件名创建File对象
        String uri = "src/main/resources/" + UPLOAD_PATH_PREFIX + filePath;
        File file = new File(uri);
        // 文件不存在
        if (!file.exists()){
            throw new BusinessException(StatusCodeEnum.FILE_NO_EXISTS_ERROR);
        }else{
            File[] fileArrays = file.listFiles();
            if(fileArrays!=null){
                for(File f: fileArrays){
                    dropFolder(filePath + "/" + f.getName());
                }
            }
            if(file.delete()){
                log.info("URI:'"+ filePath + "' 删除成功!");
            }else {
                throw new BusinessException(StatusCodeEnum.FILE_DELETE_ERROR);
            }
        }
    }
}