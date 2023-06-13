package com.lenjoy.dao;

import com.lenjoy.entity.SysUserInfo;

public interface SysUserInfoDao {
    /**
     * 根据账号密码获取系统用户对象
     * @param userName 用户名
     * @param password 密码
     * @return 系统用户对象
     */
    SysUserInfo getSysUserInfoByUserNameAndPassword(String userName,String password);

}
