package com.wrr.api;

import com.wrr.dto.ArticleListDTO;
import com.wrr.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wrr
 * @since 2021-05-26
 */
public interface ICategoryService extends IService<Category> {

    List<Category> listCategoryPage(Integer current, Integer size, String categoryName);
}
