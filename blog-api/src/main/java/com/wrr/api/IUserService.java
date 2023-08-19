package com.wrr.api;

import com.wrr.dto.UserDTO;
import com.wrr.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wrr.vo.UserQueryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wrr
 * @since 2021-05-24
 */
public interface IUserService extends IService<User> {

    List<String> getRoleByUserid(Integer id);

    List<UserDTO> getUserByCondition(UserQueryVO userQueryVO);
}
