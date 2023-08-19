package com.wrr.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.wrr.vo.ArticleAddVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wrr
 * @since 2021-05-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_article")
@ApiModel(value="Article对象", description="")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "作者")
    private Integer userId;

    @ApiModelProperty(value = "文章分类")
    private Integer categoryId;

    @ApiModelProperty(value = "文章缩略图")
    private String articleCover;

    @ApiModelProperty(value = "标题")
    private String articleTitle;

    @ApiModelProperty(value = "内容")
    private String articleContent;

    @ApiModelProperty(value = "发表时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "是否置顶")
    private Boolean isTop;

    @ApiModelProperty(value = "是否为草稿")
    private Boolean isDraft;

    @ApiModelProperty(value = "是否删除")
    private Boolean isDelete;

    public Article(){

    }

    public Article(ArticleAddVO articleAddVO){
        this.id=articleAddVO.getId();
        this.articleTitle=articleAddVO.getArticleTitle();
        this.articleContent=articleAddVO.getArticleContent();
        this.articleCover=articleAddVO.getArticleCover();
        this.categoryId=articleAddVO.getCategoryId();
        this.isTop=articleAddVO.getIsTop();
        this.isDraft=articleAddVO.getIsDraft();
        this.userId=articleAddVO.getUserId();
    }

}
