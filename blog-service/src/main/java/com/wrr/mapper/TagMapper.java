package com.wrr.mapper;

import com.wrr.entity.Category;
import com.wrr.entity.Tag;
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
public interface TagMapper extends BaseMapper<Tag> {

    List<Tag> listTagPage(@Param("current")Integer current, @Param("size")Integer size, @Param("tagName")String tagName);
}
