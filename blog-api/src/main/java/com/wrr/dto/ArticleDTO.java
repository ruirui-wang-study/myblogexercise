package com.wrr.dto;

import com.wrr.entity.Category;
import com.wrr.entity.Tag;
import lombok.Data;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Data
public class ArticleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String title;

    private String articleCover;

    private String articleContent;

    private Category category;

    private List<Tag> tags;

    private Date createTime;

    private Date updateTime;

    private boolean isTop;
}
