package com.wrr.service.impl;

import com.wrr.dto.MenuDTO;
import com.wrr.entity.Menu;
import com.wrr.mapper.MenuMapper;
import com.wrr.api.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wrr
 * @since 2021-05-25
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Override
    public List<Menu> getMenuListByUserRole(String roleName) {
        //查出来所有的角色对应拥有的菜单
        List<Menu> menuList=this.baseMapper.getMenuListByUserRole(roleName);
        System.out.println(menuList);

        //对菜单进行处理 返回前端需要的菜单格式
        List<Menu> menuDTOList=new ArrayList<>();

        int lenth=menuList.size();
        //对菜单进行剪枝处理，保证每个菜单只出现一次
        int[] used=new int[lenth];
        //默认全都没用过
        Arrays.fill(used,0);
        for (int i = 0; i < lenth; i++) {
            if(menuList.get(i).getParentId()==null||menuList.get(i).getParentId()==0){
                used[i]=1;
                findChildren(menuList.get(i),menuList,used);
                menuDTOList.add(menuList.get(i));
            }
        }

        return menuDTOList;
    }

    //遍历递归子菜单
    private void findChildren(Menu menu,List<Menu> menuList,int[] used){
        for (int i = 0; i < menuList.size(); i++) {
            //如果已经用过就遍历下一个菜单
            if(used[i]==1)
                continue;
            if(menuList.get(i).getParentId()==menu.getId()){
                used[i]=1;
                menu.getChildren().add(menuList.get(i));
            }
        }

        //如果遍历完没有子菜单说明找完了
        if(menu.getChildren().size()==0){
            return;
        }
        //如果没有找完就继续遍历子菜单的子菜单
        for(Menu childrenMenu:menu.getChildren()){
            findChildren(childrenMenu,menuList,used);
        }
    }
}
