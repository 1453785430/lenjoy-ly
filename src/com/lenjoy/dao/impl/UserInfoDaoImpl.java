package com.lenjoy.dao.impl;

import com.lenjoy.dao.UserInfoDao;
import com.lenjoy.entity.SysUserInfo;
import com.lenjoy.entity.UserInfo;
import com.lenjoy.utils.BaseDao2;

public class UserInfoDaoImpl extends BaseDao2<UserInfo> implements UserInfoDao {

    @Override
    public boolean registerUserInfo(UserInfo userInfo) {
        String sql = "insert into t_user_info(name,user_name,password,tel,address,id_card,create_time) values(?,?,?,?,?,?,now())";
        int a = executeUpdate(sql,
                userInfo.getName(),
                userInfo.getUserName(),
                userInfo.getPassword(),
                userInfo.getTel(),
                userInfo.getAddress(),
                userInfo.getIdCard()
        );
        return a > 0;
    }
}
