package com.wrr.dto;
import com.wrr.entity.Tag;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ArticleListDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String title;

    private String category;

    private List<String> tags;

    private Date createTime;

    private Date updateTime;

    private boolean isTop;
}
