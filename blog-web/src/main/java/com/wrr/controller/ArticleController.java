package com.wrr.controller;


import com.wrr.Result;
import com.wrr.ResultInfo;
import com.wrr.api.IArticleService;
import com.wrr.api.IUserService;
import com.wrr.dto.ArticleDTO;
import com.wrr.dto.ArticleListDTO;
import com.wrr.entity.Article;
import com.wrr.vo.ArticleAddVO;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wrr
 * @since 2021-05-26
 */
@RestController
public class ArticleController {

    @Autowired
    private IArticleService articleService;


    @ApiOperation("/新增或者修改文章")
    @PostMapping("/article/saveOrUpdateArticle")
    public Result saveOrUpdateArticle(@RequestBody ArticleAddVO articleAddVO){

//        articleAddVO.setUserId(userService.get);
        System.out.println(articleAddVO);
        int i=articleService.saveOrUpdateArticle(articleAddVO);
        if(i==-1){
            return Result.error();
        }
        return Result.success().codeAndMessage(ResultInfo.SUCCESS);
    }

    @ApiOperation("分页查询博客列表")
    @GetMapping("/article/listArticle")
    public Result listArticle(@RequestParam(value = "current",defaultValue = "1",required = true)Integer current,
                              @RequestParam(value = "size",defaultValue = "7",required = true) Integer size,
                              @RequestParam(value = "articleTitle",required = false)String title){

        //分页查询博客列表
        List<ArticleListDTO> articleList=articleService.listArticlePage(current,size,title);

        System.out.println(articleList);
        int total=articleService.count();
        return Result.success().data("data",articleList).data("total",total);

    }

    @ApiOperation("根据id获取博客信息")
    @GetMapping("/article/getArticleById")
    public Result getArticleById(@Param("articleId")Integer articleId){
        Article article = articleService.getById(articleId);
        return Result.success().data("article",article);
    }


    @ApiOperation("查看首页文章 参数为当前页")
    @GetMapping("/article/articles")
    public Result articles(@RequestParam("current")Integer current){
        List<ArticleDTO> articleDTOList=articleService.listArticlePage(current);
        return Result.success().data("articles",articleDTOList);
    }

    //博客端根据博客id查询
    @GetMapping("/articles/{id}")
    public Result getArticlesById(@PathVariable("id")Integer id){
        ArticleDTO data=articleService.articlePage(id);

        return Result.success().data("data",data);
    }

    @ApiOperation("查看首页文章 参数为当前页")
    @GetMapping("/article/archives")
    public Result archives(@RequestParam("current")Integer current){
        List<ArticleDTO> articleDTOList=articleService.listArticlePage(current);
        int count=articleService.count();
        return Result.success().data("articles",articleDTOList).data("count",count);
    }

    @ApiOperation("逻辑删除文章")
    @PostMapping("/article/deleteArticleById")
    public Result deleteArticleById(@RequestParam("articleId")Integer articleId){
//        Article article=articleService.getById(articleId);
//        boolean count=articleService.saveOrUpdate(article);
//        return Result.success().data("count",count);
        boolean i=articleService.deleteArticleById(articleId);
        if(i){
            return Result.success();
        }
        return Result.error();
    }

}
