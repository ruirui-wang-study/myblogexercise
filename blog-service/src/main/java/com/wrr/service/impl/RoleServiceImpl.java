package com.wrr.service.impl;

import com.wrr.dto.RoleListDTO;
import com.wrr.entity.Role;
import com.wrr.mapper.RoleMapper;
import com.wrr.api.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wrr
 * @since 2021-05-24
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {


    @Override
    public List<RoleListDTO> getRoleList() {
        List<RoleListDTO> roleList=this.baseMapper.getRoleList();
        return roleList;
    }
}
