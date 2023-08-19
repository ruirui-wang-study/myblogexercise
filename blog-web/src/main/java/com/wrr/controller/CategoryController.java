package com.wrr.controller;


import com.wrr.Result;
import com.wrr.ResultInfo;
import com.wrr.api.ICategoryService;
import com.wrr.dto.ArticleListDTO;
import com.wrr.entity.Category;
import com.wrr.vo.ArticleAddVO;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @ApiOperation("获取分类列表")
    @GetMapping("/getCategoryList")
    public Result getCategoryList(){
        List<Category> categoryList=categoryService.list();
        int count=categoryList.size();
        if(categoryList.size()>0){
            return Result.success().data("data",categoryList).data("count",count);
        }
        return Result.error();
    }

    @ApiOperation("分页查询博客列表")
    @GetMapping("/listCategory")
    public Result listArticle(@RequestParam(value = "current",defaultValue = "1",required = true)Integer current,
                              @RequestParam(value = "size",defaultValue = "7",required = true) Integer size,
                              @RequestParam(value = "categoryName",required = false)String categoryName){



        //分页查询博客列表
        List<Category> categoryList=categoryService.listCategoryPage(current,size,categoryName);

        int total=categoryService.count();
        return Result.success().data("data",categoryList).data("total",total);

    }

    @ApiOperation("/新增或者修改分类")
    @PostMapping("/addOrEditCategory")
    public Result addOrEditCategory(@RequestParam Integer categoryId){

//        articleAddVO.setUserId(userService.get);
//        System.out.println(articleAddVO);
//        int i=categoryService.saveOrUpdateArticle(articleAddVO);
//        if(i==-1){
//            return Result.error();
//        }

        return Result.success().codeAndMessage(ResultInfo.SUCCESS);
    }
}
