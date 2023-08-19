package com.wrr.service.impl;

import com.wrr.dto.ArticleDTO;
import com.wrr.dto.ArticleListDTO;
import com.wrr.entity.Article;
import com.wrr.mapper.ArticleMapper;
import com.wrr.api.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wrr.vo.ArticleAddVO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wrr
 * @since 2021-05-26
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    //涉及到增删改查可能会有事务问题
    @Override
    public int saveOrUpdateArticle(ArticleAddVO articleAddVO) {

        Date date=new Date();
        //拿到前端传过来的数据
        //新增或者修改文章
        Integer id=articleAddVO.getId();
        Article article=new Article(articleAddVO);

        if(id==null){
            //表示新增博客
            article.setCreateTime(date);
        }else {
            //更新博客
            article.setUpdateTime(date);
        }
        //先把文章保存
        boolean save=this.saveOrUpdate(article);
        if(!save){
            return -1;
        }

        // 然后设置文章标签关联表
        // 获取标签id
        List<Integer> tagIdList=articleAddVO.getTagIdList();
        //获取文章id
        Integer articleId=article.getId();
        //新增或修改关联表
        int i=this.baseMapper.saveOrUpdateArticleTag(articleId,tagIdList);
        if(i<0){
            return -1;
        }
        return i;
    }

    @Override
    public List<ArticleListDTO> listArticlePage(Integer current, Integer size, String title) {
        //分页转码处理
        current=(current-1)*size;
        List<ArticleListDTO> articleList=this.baseMapper.listArticlePage(current,size,title);

        System.out.println(title+articleList);
        if(articleList.size()<=0){
            return null;
        }

        return articleList;
    }

    @Override
    public List<ArticleDTO> listArticlePage(Integer current) {
        current=(current-1)*10;
        List<ArticleDTO> articleList=this.baseMapper.listArticle(current);

        System.out.println(articleList);
        if(articleList.size()<=0){
            return null;
        }

        return articleList;
    }

    @Override
    public ArticleDTO articlePage(Integer id) {
        ArticleDTO article =this.baseMapper.getArticleById(id);

        System.out.println(article);


        return article;
    }

    @Override
    public boolean deleteArticleById(Integer id) {
        Article article=this.getById(id);
        article.setIsDelete(true);
        //先把文章保存
        boolean save=this.saveOrUpdate(article);

        return save;
    }
}
