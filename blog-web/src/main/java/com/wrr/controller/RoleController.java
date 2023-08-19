package com.wrr.controller;


import com.wrr.Result;
import com.wrr.api.IRoleService;
import com.wrr.dto.RoleListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wrr
 * @since 2021-05-24
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @GetMapping("/getRoleList")
    public Result getRoleList(){
        List<RoleListDTO> roleList = roleService.getRoleList();
        //System.out.println(roleList);
        if(roleList.size()>0){
            return Result.success().data("roleList",roleList);
        }
        return Result.error();
    }

}
