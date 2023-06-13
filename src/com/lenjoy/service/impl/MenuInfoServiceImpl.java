package com.lenjoy.service.impl;

import com.lenjoy.dao.MenuInfoDao;
import com.lenjoy.dao.impl.MenuInfoDaoImpl;
import com.lenjoy.entity.MenuInfo;
import com.lenjoy.service.MenuInfoService;
import com.lenjoy.service.SystemService;
import com.lenjoy.utils.SessionUtil;
import com.lenjoy.utils.TrendsSwitchUtil;

import java.util.List;
import java.util.Scanner;

public class MenuInfoServiceImpl implements MenuInfoService {
    private MenuInfoDao menuInfoDao = new MenuInfoDaoImpl();

    @Override
    public void showMainMenu() {
        System.out.println("============乐享洛阳============");
        showMenu(-1);
        TrendsSwitchUtil.invokeMethod();
    }

    @Override
    public void showMenu(Integer pId) {
        Scanner inpunt = new Scanner(System.in);
        //查询数据库,拿到一级菜单集合
        List<MenuInfo> menuInfoList = menuInfoDao.getMenuInfoListByPId(pId);
        //遍历菜单集合,生成菜单
        for (int i = 0; i < menuInfoList.size(); i++) {
            System.out.println("\t" + (i + 1) + ":" + menuInfoList.get(i).getName());
        }
        System.out.println(pId == -1 ? "\t[0|其他: 退出系统]" : "\t[0|其他]: 返回上一级");
        boolean flag = false;
        do {
            System.out.println("请选择菜单:");
            String menuIdStr = inpunt.next();
            int menuId = 0;
            //判断用户输入的编号是否是0
                if ("0".equals(menuIdStr)) {
                    //如果是,再判断pId是否为-1,如果是就退出系统
                    if (pId == -1){
                        System.exit(0);
                    }else {
                        //如果pId不等于-1,就执行返回上一级菜单的方法
                        TrendsSwitchUtil.rollbackMethod();
                    }
                }
                try {
                    //将字符串转换为数字
                    menuId = Integer.parseInt(menuIdStr);
                } catch (NumberFormatException e) {
                    //当字符串转换为数字出错时(用户选择了 其他 (退出系统|返回上一级))的处理逻辑
                    if (pId == -1){
                        System.exit(0);
                    }else {
                        TrendsSwitchUtil.rollbackMethod();
                    }
                }
            if (menuId > 0 && menuId <= menuInfoList.size()) {
                SessionUtil.menuInfo = menuInfoList.get(menuId - 1);
            } else {
                System.out.println("没有这个菜单,请重新选择:");
                flag = true;
            }
        } while (flag);
    }

    @Override
    public void addMenu() {
        Scanner input = new Scanner(System.in);
        Integer pId = getMenuInfoPid(-1);
        //如果pId为空,说明用户取消了添加菜单的操作
        if (pId != null) {
            MenuInfo menuInfo = new MenuInfo();
            System.out.print("请输入菜单名称：");
            menuInfo.setName(input.next());
            System.out.print("请输入菜单URL：");
            menuInfo.setUrl(input.next());
            System.out.print("请输入菜单小图标：");
            menuInfo.setIcon(input.next());
            System.out.print("请输入菜单序号：");
            menuInfo.setLevel(input.nextInt());
            System.out.print("请输入菜单类型：");
            menuInfo.setType(input.nextInt());
            menuInfo.setPId(pId);
            menuInfo.setCreateUser(SessionUtil.sysUserInfo.getId());
            menuInfo.setUpdateUser(SessionUtil.sysUserInfo.getId());
            int rows = menuInfoDao.addMenuInfo(menuInfo);
            System.out.println(rows > 0 ? "添加成功" : "添加失败");
        }
/**        SessionUtil.menuInfo = menuInfoDao.getMenuInfoById(SessionUtil.menuInfo.getPId());
 //返回菜单管理列表
 TrendsSwitchUtil.invokeMethod();*/
        TrendsSwitchUtil.rollbackMethod();
    }


    private Integer getMenuInfoPid(Integer pId) {
        System.out.println("\n-菜单管理-->添加菜单-->菜单列表------------");
        List<MenuInfo> menuInfoList = menuInfoDao.getMenuInfoListByPId(pId);
        for (int i = 0; i < menuInfoList.size(); i++) {
            System.out.println("\t" + (i + 1) + menuInfoList.get(i).getName());
        }

        System.out.println("[1]:添加菜单\t[2]:选择菜单添加子菜单 [其他]:取消");
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择编号:");
        String num = sc.next();
        switch (num) {
            case "1":
                return pId;
            case "2":
                System.out.println("请选择父级菜单:");
                int menuId = sc.nextInt();
                return getMenuInfoPid(menuInfoList.get(menuId - 1).getId());
            default:
                return null;
        }
    }
}
