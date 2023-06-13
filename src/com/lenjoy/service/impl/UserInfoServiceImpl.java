package com.lenjoy.service.impl;

import com.lenjoy.dao.SysUserInfoDao;
import com.lenjoy.dao.UserInfoDao;
import com.lenjoy.dao.impl.SysUserInfoDaoImpl;
import com.lenjoy.dao.impl.UserInfoDaoImpl;
import com.lenjoy.entity.SysUserInfo;
import com.lenjoy.entity.UserInfo;
import com.lenjoy.service.MenuInfoService;
import com.lenjoy.service.UserInfoService;
import com.lenjoy.utils.MD5Utils;
import com.lenjoy.utils.TrendsSwitchUtil;

import java.util.Scanner;

public class UserInfoServiceImpl implements UserInfoService {
    private Scanner sc = new Scanner(System.in);
    private MenuInfoService menuInfoService = new MenuInfoServiceImpl();
    private UserInfoDao userInfoDao = new UserInfoDaoImpl();
    @Override
    public void showMenu() {
        System.out.println("用户版");
        menuInfoService.showMenu(2);
        TrendsSwitchUtil.invokeMethod();
    }

    @Override
    public void register() {
        UserInfo userInfo=new UserInfo();
        System.out.println("注册");
        System.out.println("请输入用户名:");
        String userName = sc.next();
        System.out.println("请输入密码:");
        String password = sc.next();
        System.out.println("请输入昵称:");
        String name = sc.next();
        System.out.println("请输入电话:");
        String tel = sc.next();
        System.out.println("请输入地址:");
        String adress = sc.next();
        System.out.println("请输入身份证号:");
        String idcard = sc.next();
        System.out.println("请输入状态:");
        String status = sc.next();
        userInfo.setUserName(userName);
        userInfo.setName(name);
        userInfo.setPassword(MD5Utils.encryptMD5(password));
        userInfo.setTel(tel);
        userInfo.setIdCard(idcard);
        userInfo.setStatus(Integer.valueOf(status));
        userInfo.setAddress(adress);
       boolean success = userInfoDao.registerUserInfo(userInfo);
       if (success){
           System.out.println("添加成功");
       }else {
           System.out.println("添加失败");
           TrendsSwitchUtil.invokeMethod();
       }
    }


}
