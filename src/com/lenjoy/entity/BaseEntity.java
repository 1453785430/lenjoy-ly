package com.lenjoy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class BaseEntity {
    //菜单编号 主键自增
    private Integer id;
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
