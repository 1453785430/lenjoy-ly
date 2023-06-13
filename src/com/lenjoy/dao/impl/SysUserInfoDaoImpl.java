package com.lenjoy.dao.impl;

import com.lenjoy.dao.SysUserInfoDao;
import com.lenjoy.entity.SysUserInfo;
import com.lenjoy.utils.BaseDao2;

public class SysUserInfoDaoImpl extends BaseDao2<SysUserInfo> implements SysUserInfoDao {

    @Override
    public SysUserInfo getSysUserInfoByUserNameAndPassword(String userName, String password) {
        String sql = "select * from t_sys_user_info where user_name=? and `password`=?";
        return selectOne(sql, SysUserInfo.class, userName, password);
    }

}
