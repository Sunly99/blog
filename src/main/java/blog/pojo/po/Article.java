package blog.pojo.po;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_article
 */
public class Article {
    /**
     * Database Column Remarks:
     *   文章id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_article.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   文章标签
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_article.tag
     *
     * @mbg.generated
     */
    private String tag;

    /**
     * Database Column Remarks:
     *   文章类别id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_article.category_id
     *
     * @mbg.generated
     */
    private Integer categoryId;

    /**
     * Database Column Remarks:
     *   文章标题
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_article.title
     *
     * @mbg.generated
     */
    private String title;

    /**
     * Database Column Remarks:
     *   文章简介
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_article.about
     *
     * @mbg.generated
     */
    private String about;

    /**
     * Database Column Remarks:
     *   文章封面
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_article.avatar
     *
     * @mbg.generated
     */
    private String avatar;

    /**
     * Database Column Remarks:
     *   排序值
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_article.article_order
     *
     * @mbg.generated
     */
    private Integer articleOrder;

    /**
     * Database Column Remarks:
     *   是否置顶
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_article.status_top
     *
     * @mbg.generated
     */
    private Boolean statusTop;

    /**
     * Database Column Remarks:
     *   是否热门
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_article.status_hot
     *
     * @mbg.generated
     */
    private Boolean statusHot;

    /**
     * Database Column Remarks:
     *   是否展示
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_article.status_show
     *
     * @mbg.generated
     */
    private Boolean statusShow;

    /**
     * Database Column Remarks:
     *   创建日期
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_article.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   修改日期
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_article.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     * Database Column Remarks:
     *   阅读数
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_article.counts
     *
     * @mbg.generated
     */
    private Integer counts;

    /**
     * Database Column Remarks:
     *   作者id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_article.author_id
     *
     * @mbg.generated
     */
    private Integer authorId;

    /**
     * Database Column Remarks:
     *   文章内容
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_article.content
     *
     * @mbg.generated
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_article.id
     *
     * @return the value of t_article.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_article.id
     *
     * @param id the value for t_article.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_article.tag
     *
     * @return the value of t_article.tag
     *
     * @mbg.generated
     */
    public String getTag() {
        return tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_article.tag
     *
     * @param tag the value for t_article.tag
     *
     * @mbg.generated
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_article.category_id
     *
     * @return the value of t_article.category_id
     *
     * @mbg.generated
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_article.category_id
     *
     * @param categoryId the value for t_article.category_id
     *
     * @mbg.generated
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_article.title
     *
     * @return the value of t_article.title
     *
     * @mbg.generated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_article.title
     *
     * @param title the value for t_article.title
     *
     * @mbg.generated
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_article.about
     *
     * @return the value of t_article.about
     *
     * @mbg.generated
     */
    public String getAbout() {
        return about;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_article.about
     *
     * @param about the value for t_article.about
     *
     * @mbg.generated
     */
    public void setAbout(String about) {
        this.about = about;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_article.avatar
     *
     * @return the value of t_article.avatar
     *
     * @mbg.generated
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_article.avatar
     *
     * @param avatar the value for t_article.avatar
     *
     * @mbg.generated
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_article.article_order
     *
     * @return the value of t_article.article_order
     *
     * @mbg.generated
     */
    public Integer getArticleOrder() {
        return articleOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_article.article_order
     *
     * @param articleOrder the value for t_article.article_order
     *
     * @mbg.generated
     */
    public void setArticleOrder(Integer articleOrder) {
        this.articleOrder = articleOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_article.status_top
     *
     * @return the value of t_article.status_top
     *
     * @mbg.generated
     */
    public Boolean getStatusTop() {
        return statusTop;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_article.status_top
     *
     * @param statusTop the value for t_article.status_top
     *
     * @mbg.generated
     */
    public void setStatusTop(Boolean statusTop) {
        this.statusTop = statusTop;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_article.status_hot
     *
     * @return the value of t_article.status_hot
     *
     * @mbg.generated
     */
    public Boolean getStatusHot() {
        return statusHot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_article.status_hot
     *
     * @param statusHot the value for t_article.status_hot
     *
     * @mbg.generated
     */
    public void setStatusHot(Boolean statusHot) {
        this.statusHot = statusHot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_article.status_show
     *
     * @return the value of t_article.status_show
     *
     * @mbg.generated
     */
    public Boolean getStatusShow() {
        return statusShow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_article.status_show
     *
     * @param statusShow the value for t_article.status_show
     *
     * @mbg.generated
     */
    public void setStatusShow(Boolean statusShow) {
        this.statusShow = statusShow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_article.create_time
     *
     * @return the value of t_article.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_article.create_time
     *
     * @param createTime the value for t_article.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_article.update_time
     *
     * @return the value of t_article.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_article.update_time
     *
     * @param updateTime the value for t_article.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_article.counts
     *
     * @return the value of t_article.counts
     *
     * @mbg.generated
     */
    public Integer getCounts() {
        return counts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_article.counts
     *
     * @param counts the value for t_article.counts
     *
     * @mbg.generated
     */
    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_article.author_id
     *
     * @return the value of t_article.author_id
     *
     * @mbg.generated
     */
    public Integer getAuthorId() {
        return authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_article.author_id
     *
     * @param authorId the value for t_article.author_id
     *
     * @mbg.generated
     */
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_article.content
     *
     * @return the value of t_article.content
     *
     * @mbg.generated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_article.content
     *
     * @param content the value for t_article.content
     *
     * @mbg.generated
     */
    public void setContent(String content) {
        this.content = content;
    }
}