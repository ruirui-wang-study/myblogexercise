package com.wrr.controller;


import com.wrr.Result;
import com.wrr.api.ITagService;
import com.wrr.entity.Category;
import com.wrr.entity.Tag;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private ITagService tagService;

    @ApiOperation("获取标签列表")
    @GetMapping("/getTagList")
    public Result getTagList(){
        List<Tag> tagList=tagService.list();
        int count=tagList.size();
        if(tagList.size()>0){
            return Result.success().data("data",tagList).data("count",count);
        }
        return Result.error();
    }

    @ApiOperation("分页查询博客列表")
    @GetMapping("/listTags")
    public Result listArticle(@RequestParam(value = "current",defaultValue = "1",required = true)Integer current,
                              @RequestParam(value = "size",defaultValue = "7",required = true) Integer size,
                              @RequestParam(value = "tagName",required = false)String tagName){

        System.out.println(current+" "+size+" "+tagName);
        //分页查询博客列表
        List<Tag> tagList=tagService.listTagPage(current,size,tagName);
        int total=tagService.count();
        System.out.println(tagList);
        return Result.success().data("data",tagList).data("total",total);

    }
}
