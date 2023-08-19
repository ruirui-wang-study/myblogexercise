package com.wrr.mapper;

import com.wrr.dto.RoleListDTO;
import com.wrr.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wrr
 * @since 2021-05-24
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    List<RoleListDTO> getRoleList();
}
