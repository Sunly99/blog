package blog.pojo.po;

import java.util.Date;

/**
 * Database Table Remarks:
 *   VIEW
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table v_article_simple
 */
public class ArticleSimpleView {
    /**
     * Database Column Remarks:
     *   文章id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_article_simple.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   文章标签
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_article_simple.tag
     *
     * @mbg.generated
     */
    private String tag;

    /**
     * Database Column Remarks:
     *   文章标题
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_article_simple.title
     *
     * @mbg.generated
     */
    private String title;

    /**
     * Database Column Remarks:
     *   文章封面
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_article_simple.avatar
     *
     * @mbg.generated
     */
    private String avatar;

    /**
     * Database Column Remarks:
     *   排序值
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_article_simple.articale_order
     *
     * @mbg.generated
     */
    private Integer articaleOrder;

    /**
     * Database Column Remarks:
     *   是否置顶
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_article_simple.status_top
     *
     * @mbg.generated
     */
    private Byte statusTop;

    /**
     * Database Column Remarks:
     *   是否热门
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_article_simple.status_hot
     *
     * @mbg.generated
     */
    private Byte statusHot;

    /**
     * Database Column Remarks:
     *   是否展示
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_article_simple.status_show
     *
     * @mbg.generated
     */
    private Byte statusShow;

    /**
     * Database Column Remarks:
     *   创建日期
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_article_simple.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   修改日期
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_article_simple.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     * Database Column Remarks:
     *   阅读数
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_article_simple.counts
     *
     * @mbg.generated
     */
    private Integer counts;

    /**
     * Database Column Remarks:
     *   作者id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_article_simple.author_id
     *
     * @mbg.generated
     */
    private Integer authorId;

    /**
     * Database Column Remarks:
     *   昵称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_article_simple.nick_name
     *
     * @mbg.generated
     */
    private String nickName;

    /**
     * Database Column Remarks:
     *   文章类别id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_article_simple.category_id
     *
     * @mbg.generated
     */
    private Integer categoryId;

    /**
     * Database Column Remarks:
     *   类别名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_article_simple.category_name
     *
     * @mbg.generated
     */
    private String categoryName;

    /**
     * Database Column Remarks:
     *   文章简介
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column v_article_simple.about
     *
     * @mbg.generated
     */
    private String about;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_article_simple.id
     *
     * @return the value of v_article_simple.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_article_simple.id
     *
     * @param id the value for v_article_simple.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_article_simple.tag
     *
     * @return the value of v_article_simple.tag
     *
     * @mbg.generated
     */
    public String getTag() {
        return tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_article_simple.tag
     *
     * @param tag the value for v_article_simple.tag
     *
     * @mbg.generated
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_article_simple.title
     *
     * @return the value of v_article_simple.title
     *
     * @mbg.generated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_article_simple.title
     *
     * @param title the value for v_article_simple.title
     *
     * @mbg.generated
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_article_simple.avatar
     *
     * @return the value of v_article_simple.avatar
     *
     * @mbg.generated
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_article_simple.avatar
     *
     * @param avatar the value for v_article_simple.avatar
     *
     * @mbg.generated
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_article_simple.articale_order
     *
     * @return the value of v_article_simple.articale_order
     *
     * @mbg.generated
     */
    public Integer getArticaleOrder() {
        return articaleOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_article_simple.articale_order
     *
     * @param articaleOrder the value for v_article_simple.articale_order
     *
     * @mbg.generated
     */
    public void setArticaleOrder(Integer articaleOrder) {
        this.articaleOrder = articaleOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_article_simple.status_top
     *
     * @return the value of v_article_simple.status_top
     *
     * @mbg.generated
     */
    public Byte getStatusTop() {
        return statusTop;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_article_simple.status_top
     *
     * @param statusTop the value for v_article_simple.status_top
     *
     * @mbg.generated
     */
    public void setStatusTop(Byte statusTop) {
        this.statusTop = statusTop;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_article_simple.status_hot
     *
     * @return the value of v_article_simple.status_hot
     *
     * @mbg.generated
     */
    public Byte getStatusHot() {
        return statusHot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_article_simple.status_hot
     *
     * @param statusHot the value for v_article_simple.status_hot
     *
     * @mbg.generated
     */
    public void setStatusHot(Byte statusHot) {
        this.statusHot = statusHot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_article_simple.status_show
     *
     * @return the value of v_article_simple.status_show
     *
     * @mbg.generated
     */
    public Byte getStatusShow() {
        return statusShow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_article_simple.status_show
     *
     * @param statusShow the value for v_article_simple.status_show
     *
     * @mbg.generated
     */
    public void setStatusShow(Byte statusShow) {
        this.statusShow = statusShow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_article_simple.create_time
     *
     * @return the value of v_article_simple.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_article_simple.create_time
     *
     * @param createTime the value for v_article_simple.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_article_simple.update_time
     *
     * @return the value of v_article_simple.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_article_simple.update_time
     *
     * @param updateTime the value for v_article_simple.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_article_simple.counts
     *
     * @return the value of v_article_simple.counts
     *
     * @mbg.generated
     */
    public Integer getCounts() {
        return counts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_article_simple.counts
     *
     * @param counts the value for v_article_simple.counts
     *
     * @mbg.generated
     */
    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_article_simple.author_id
     *
     * @return the value of v_article_simple.author_id
     *
     * @mbg.generated
     */
    public Integer getAuthorId() {
        return authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_article_simple.author_id
     *
     * @param authorId the value for v_article_simple.author_id
     *
     * @mbg.generated
     */
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_article_simple.nick_name
     *
     * @return the value of v_article_simple.nick_name
     *
     * @mbg.generated
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_article_simple.nick_name
     *
     * @param nickName the value for v_article_simple.nick_name
     *
     * @mbg.generated
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_article_simple.category_id
     *
     * @return the value of v_article_simple.category_id
     *
     * @mbg.generated
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_article_simple.category_id
     *
     * @param categoryId the value for v_article_simple.category_id
     *
     * @mbg.generated
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_article_simple.category_name
     *
     * @return the value of v_article_simple.category_name
     *
     * @mbg.generated
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_article_simple.category_name
     *
     * @param categoryName the value for v_article_simple.category_name
     *
     * @mbg.generated
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column v_article_simple.about
     *
     * @return the value of v_article_simple.about
     *
     * @mbg.generated
     */
    public String getAbout() {
        return about;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column v_article_simple.about
     *
     * @param about the value for v_article_simple.about
     *
     * @mbg.generated
     */
    public void setAbout(String about) {
        this.about = about;
    }
}