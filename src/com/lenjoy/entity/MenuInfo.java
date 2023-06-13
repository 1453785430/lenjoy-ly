package com.lenjoy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuInfo /**extends BaseEntity*/{
    //菜单编号 主键自增
    private Integer id;
    //菜单名称
    private String name;
    //菜单url
    private String url;
    //菜单小图标
    private String icon;
    //菜单等级
    private Integer level;
    //父级ID
    private Integer pId;

    //菜单类型 0 商家  1 用户  2 代理商  3 管理系统  4 代理商管理系统
    private Integer type;
    //创建时间
    private Date createTime;
    //创建人
    private Integer createUser;
    //修改时间
    private Date updateTime;
    //修改人
    private Integer updateUser;
    //状态
    private Integer stetus;

}
