package blog.common.util;

import blog.common.enumeration.StatusCodeEnum;
import blog.common.except.BusinessException;
import blog.pojo.vo.common.JsonResponseVO;
import blog.pojo.vo.common.ResponseVO;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 参数封装工具
 *
 * @see ResponseVO
 * @see JsonResponseVO
 * @author sly
 */
public class ParameterWrapperUtils {

    /**
     * 异常堆栈跟踪转换成字符串
     *
     * @param e 异常
     * @return String
     * @author qzq
     */
    public static String getErrorInfoFromException(Exception e) {
        e.printStackTrace();
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String s = sw.toString();
            sw.close();
            pw.close();
            return "\r\n" + s + "\r\n";
        } catch (Exception ex) {
            return "获得Exception信息的工具类异常!";
        }
    }

    public static <T> ResponseVO<T> successAndRenderData(T data) {
        ResponseVO<T> res = new ResponseVO<>();
        putCode2ResponseVO(res, StatusCodeEnum.SUCCESS);
        res.setData(data);
        return res;
    }

    public static ResponseVO<Void> successAndRender() {
        ResponseVO<Void> res = new ResponseVO<>();
        putCode2ResponseVO(res, StatusCodeEnum.SUCCESS);
        return res;
    }


    public static <T> ResponseVO<T> putCode2ResponseVO(ResponseVO<T> vo, StatusCodeEnum sc, Exception e) {
        vo.setCode(sc.getCode());
        vo.setMsg(sc.getMsg());
        if (e != null) {
            vo.setStack(getErrorInfoFromException(e));
        }
        return vo;
    }

    public static <T> void putCode2ResponseVO(ResponseVO<T> vo, StatusCodeEnum sc) {
        putCode2ResponseVO(vo, sc, null);
    }

    public static <T> ResponseVO<T> putCode2ResponseVO(StatusCodeEnum sc, Exception e) {
        ResponseVO<T> res = new ResponseVO<>();
        return putCode2ResponseVO(res, sc, e);
    }

    public static ResponseVO<Void> putCode2ResponseVO(StatusCodeEnum sc) {
        return putCode2ResponseVO(sc, null);
    }

    public static <T> ResponseVO<T> putCode2ResponseVO(double code, String msg, Exception e) {
        ResponseVO<T> res = new ResponseVO<>();
        res.setCode(code);
        res.setMsg(msg);
        if (e != null) {
            res.setStack(getErrorInfoFromException(e));
        }
        return res;
    }

    public static <T> ResponseVO<T> putCode2ResponseVO(BusinessException e) {
        return putCode2ResponseVO(e.getCode(), e.getMsg(), e);
    }

    public static JsonResponseVO putCode2JsonResponseVO(ServletResponse response, StatusCodeEnum statusCodeEnum){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        JsonResponseVO jsonResponseVO = new JsonResponseVO();
        jsonResponseVO.setCode(statusCodeEnum.getCode());
        jsonResponseVO.setMsg(statusCodeEnum.getMsg());
        return jsonResponseVO;
    }

    public static JsonResponseVO putCode2JsonResponseVO(ServletResponse response,StatusCodeEnum statusCodeEnum, String data){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        JsonResponseVO jsonResponseVO = new JsonResponseVO();
        jsonResponseVO.setCode(statusCodeEnum.getCode());
        jsonResponseVO.setMsg(statusCodeEnum.getMsg());
        jsonResponseVO.setData(data);
        return jsonResponseVO;
    }

    /**
     *  转为新列表(对象属性名要相同)
     * @param originList 原列表
     * @param tClass 新列表类对象
     * @param <T> <T>
     * @return list
     */
    public static <T> List<T> list2OtherList(List<T> originList, Class<T> tClass){
        List<T> list = new ArrayList<>();
        for (Object info : originList) {
            T t = JSON.parseObject(JSON.toJSONString(info),tClass);
            list.add(t);
        }
        return list;
    }

    /**
     *  对象转列表
     * @param obj 对象
     * @param clazz 类
     * @param <T> <T>
     * @return list
     */
    public static <T> List<T> castList(Object obj, Class<T> clazz)
    {
        List<T> result = new ArrayList<T>();
        if(obj instanceof List<?>)
        {
            for (Object o : (List<?>) obj)
            {
                result.add(clazz.cast(o));
            }
            return result;
        }
        return null;
    }
}
