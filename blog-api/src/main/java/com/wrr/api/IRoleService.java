package com.wrr.api;

import com.wrr.dto.RoleListDTO;
import com.wrr.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wrr
 * @since 2021-05-24
 */
public interface IRoleService extends IService<Role> {

    List<RoleListDTO> getRoleList();

}
