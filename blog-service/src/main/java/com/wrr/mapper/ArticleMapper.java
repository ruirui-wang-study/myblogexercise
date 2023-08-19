package com.wrr.mapper;

import com.wrr.dto.ArticleDTO;
import com.wrr.dto.ArticleListDTO;
import com.wrr.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wrr
 * @since 2021-05-26
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    int saveOrUpdateArticleTag(@Param("articleId") Integer articleId, @Param("tagIdList")List<Integer> tagIdList);

    List<ArticleListDTO> listArticlePage(@Param("current")Integer current,@Param("size")Integer size,@Param("title")String title);

    List<ArticleDTO> listArticle(@Param("current")Integer current);

    ArticleDTO getArticleById(@Param("id")Integer id);
}
