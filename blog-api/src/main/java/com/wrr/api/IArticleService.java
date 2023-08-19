package com.wrr.api;

import com.wrr.dto.ArticleDTO;
import com.wrr.dto.ArticleListDTO;
import com.wrr.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wrr.vo.ArticleAddVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wrr
 * @since 2021-05-26
 */
public interface IArticleService extends IService<Article> {

    /**
     * 新增或修改博客
     * @param articleAddVO
     * @return
     */
    int saveOrUpdateArticle(ArticleAddVO articleAddVO);

    List<ArticleListDTO> listArticlePage(Integer current, Integer size, String title);

    List<ArticleDTO> listArticlePage(Integer current);

    ArticleDTO articlePage(Integer id);

    boolean deleteArticleById(Integer id);

}
