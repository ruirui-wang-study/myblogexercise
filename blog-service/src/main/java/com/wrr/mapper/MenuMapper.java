package com.wrr.mapper;

import com.wrr.dto.MenuDTO;
import com.wrr.entity.Menu;
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
 * @since 2021-05-25
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getMenuListByUserRole(@Param("roleName") String roleName);
}
