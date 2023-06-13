package com.lenjoy.controller;

import com.lenjoy.service.BusinessInfoService;
import com.lenjoy.service.UserInfoService;
import com.lenjoy.service.impl.BusinessInfoServiceImpl;
import com.lenjoy.service.impl.UserInfoServiceImpl;

public class UserInfoController {
    private BusinessInfoService businessInfoService = new BusinessInfoServiceImpl();
    private UserInfoService userInfoService = new UserInfoServiceImpl();
    public void showMenu(){
        userInfoService.showMenu();
    }
    public void register(){
        userInfoService.register();
    }


}
