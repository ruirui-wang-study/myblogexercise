package com.wrr.api;

import com.wrr.entity.Category;
import com.wrr.entity.Tag;
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
public interface ITagService extends IService<Tag> {

    List<Tag> listTagPage(Integer current, Integer size, String tagName);
}
