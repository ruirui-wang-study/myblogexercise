package com.wrr.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserQueryVO implements Serializable {

    private static final long serialVersionUID=1L;

    private String nickName;

    private String roleName;

    private int current;

    private int size;

}
