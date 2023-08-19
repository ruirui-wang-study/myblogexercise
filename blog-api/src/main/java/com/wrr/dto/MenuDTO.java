package com.wrr.dto;

import com.wrr.entity.Menu;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MenuDTO {

    private Integer id;

    private String menuName;

    private String url;

    private String icon;

    private Integer parentId;

    private Boolean disabled;

    private List<MenuDTO> children=new ArrayList<>();

    public void isParent(Menu menu){
        this.id=menu.getId();
        this.menuName=menu.getMenuName();
        this.url=menu.getUrl();
        this.icon=menu.getIcon();
        this.parentId=menu.getParentId();
        this.disabled=menu.getDisabled();
    }

    public MenuDTO isChidren(Menu menu){
        this.id=menu.getId();
        this.menuName=menu.getMenuName();
        this.url=menu.getUrl();
        this.icon=menu.getIcon();
        this.parentId=menu.getParentId();
        this.disabled=menu.getDisabled();

        return this;
    }
}
