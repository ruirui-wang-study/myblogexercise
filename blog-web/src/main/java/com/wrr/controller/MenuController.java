package com.wrr.controller;


import com.wrr.Result;
import com.wrr.ResultInfo;
import com.wrr.api.IMenuService;
import com.wrr.dto.MenuDTO;
import com.wrr.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wrr
 * @since 2021-05-25
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @GetMapping("/getMenuList")
    public Result getMenuListByUserRole(@RequestParam("roleName")String roleName){

        List<Menu> menuList = menuService.getMenuListByUserRole(roleName);
        if(menuList.size()>0){
            return Result.success().codeAndMessage(ResultInfo.SUCCESS).data("menuList",menuList);
        }else{
            return Result.error();
        }

    }

}
