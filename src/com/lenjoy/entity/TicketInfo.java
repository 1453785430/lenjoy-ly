package com.lenjoy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketInfo {
    private Integer id;
    private String title;
    private Integer busId;
    private Integer type;
    private Double dikou;
    private Double zheKou;
    private Double man;
    private Double jian;
    private Double money;
    private String remark;
    private Date caeateTime;
    private Integer createUser;
    private Integer status;
}
