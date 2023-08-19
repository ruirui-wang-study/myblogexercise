package com.wrr.service.impl;

import com.wrr.dto.UserDTO;
import com.wrr.entity.User;
import com.wrr.mapper.UserMapper;
import com.wrr.api.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wrr.vo.UserQueryVO;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public List<String> getRoleByUserid(Integer id) {
        return this.baseMapper.getRoleByUserid(id);
    }

    @Override
    public List<UserDTO> getUserByCondition(UserQueryVO userQueryVO) {
        System.out.println(userQueryVO);
        //页码转换
        userQueryVO.setCurrent((userQueryVO.getCurrent()-1)*userQueryVO.getSize());

        return this.baseMapper.getUserByCondition(userQueryVO);
    }
}
