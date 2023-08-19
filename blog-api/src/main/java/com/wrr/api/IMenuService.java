package com.wrr.api;

import com.wrr.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wrr
 * @since 2021-05-25
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 通过角色名查找对应的菜单
     * @param roleName
     * @return
     */
    List<Menu> getMenuListByUserRole(String roleName);
}
