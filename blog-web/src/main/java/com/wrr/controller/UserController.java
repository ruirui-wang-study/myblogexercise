package com.wrr.controller;


import com.wrr.Result;
import com.wrr.api.IUserService;
import com.wrr.dto.UserDTO;
import com.wrr.vo.UserQueryVO;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/getUserList")
    public Result getUserList(UserQueryVO userQueryVO){
        List<UserDTO> userList=userService.getUserByCondition(userQueryVO);

        System.out.println(userQueryVO);
        int count=userService.count();

        if(userList!=null){

            return Result.success().data("userList",userList).data("total",count);
        }
        return Result.error();
    }
}
