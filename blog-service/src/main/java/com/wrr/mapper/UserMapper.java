package com.wrr.mapper;

import com.wrr.dto.UserDTO;
import com.wrr.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wrr.vo.UserQueryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
public interface UserMapper extends BaseMapper<User> {

    List<String> getRoleByUserid(@Param("id")Integer id);

    List<UserDTO> getUserByCondition(@Param("userQueryVO")UserQueryVO userQueryVO);
}
