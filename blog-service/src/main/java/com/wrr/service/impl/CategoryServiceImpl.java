package com.wrr.service.impl;

import com.wrr.dto.ArticleListDTO;
import com.wrr.entity.Category;
import com.wrr.mapper.CategoryMapper;
import com.wrr.api.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Override
    public List<Category> listCategoryPage(Integer current, Integer size, String categoryName) {
        //分页转码处理
        current=(current-1)*size;
        List<Category> categoryList=this.baseMapper.listCategoryPage(current,size,categoryName);

//        System.out.println(title+articleList);
        if(categoryList.size()<=0){
            return null;
        }

        return categoryList;
    }
}
