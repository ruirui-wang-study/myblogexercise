package com.wrr.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleListDTO implements Serializable {
    private String roleName;
    private Integer total;
}
