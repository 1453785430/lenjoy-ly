package com.lenjoy.service.impl;

import com.lenjoy.dao.TicketInfoDao;
import com.lenjoy.dao.impl.TicketInfoDaoImpl;
import com.lenjoy.entity.BusinessInfo;
import com.lenjoy.entity.TicketInfo;
import com.lenjoy.service.MenuInfoService;
import com.lenjoy.service.TicketInfoService;
import com.lenjoy.utils.SessionUtil;
import com.lenjoy.utils.TrendsSwitchUtil;

import java.util.List;
import java.util.Scanner;

public class TicketInfoServiceImpl implements TicketInfoService {
    private TicketInfoDao ticketInfoDao = new TicketInfoDaoImpl();
    private Scanner sc = new Scanner(System.in);

    @Override
    public void showTicketList() {
        BusinessInfo businessInfo = (BusinessInfo) SessionUtil.getAttribute("businessInfo");
        List<TicketInfo> ticketInfos = ticketInfoDao.getTicketInfoListByBusinessId(businessInfo.getId());
        showTickets(ticketInfos);
        MenuInfoService menuInfoService = new MenuInfoServiceImpl();
        menuInfoService.showMenu(SessionUtil.menuInfo.getId());
        TrendsSwitchUtil.invokeMethod();
    }

    @Override
    public void addTicket() {
        BusinessInfo businessInfo = (BusinessInfo) SessionUtil.getAttribute("businessInfo");
        System.out.println("-" + businessInfo.getName() + "--->发放优惠券\n");
        System.out.print("请输入优惠券的名字：");
        String title = sc.next();
        Integer type = switchTicketType();
        System.out.print("请输入优惠券金额：");
        Double money = sc.nextDouble();

        Double diKou = null;
        Double zheKou = null;
        Double man = null;
        Double jian = null;
        switch (type) {
            case 0:
                System.out.print("请输入优惠券抵扣金额：");
                diKou = sc.nextDouble();
                break;
            case 1:
                System.out.print("请输入优惠券折扣：");
                zheKou = sc.nextDouble();
                break;
            case 2:
                System.out.print("请输入优惠券满多少减：");
                man = sc.nextDouble();
                System.out.print("请输入优惠券减多少：");
                jian = sc.nextDouble();
                break;
            default:
                break;
        }
        System.out.print("请输入优惠券抵描述：");
        String remark = sc.next();

        //封装优惠券对象
        TicketInfo ticketInfo = new TicketInfo();
        ticketInfo.setTitle(title);
        ticketInfo.setBusId(businessInfo.getId());
        ticketInfo.setType(type);
        ticketInfo.setDikou(diKou);
        ticketInfo.setZheKou(zheKou);
        ticketInfo.setMan(man);
        ticketInfo.setJian(jian);
        ticketInfo.setMoney(money);
        ticketInfo.setRemark(remark);
        ticketInfo.setCreateUser(businessInfo.getId());
        //调用dao 完成新增
        int rows = ticketInfoDao.addTicketInfo(ticketInfo);
        System.out.println(rows > 0 ? "新增成功" : "新增失败");
        TrendsSwitchUtil.rollbackMethod();

    }

    private Integer switchTicketType() {
        System.out.println("优惠券类型: ");
        System.out.println("\t[1:抵扣券]\t[2:折扣券]\t[3:满减券]\t[4:套餐券]");
        System.out.println("请选择优惠券类型:");
        int ticketType = sc.nextInt();
        if (ticketType < 1 || ticketType > 4) {
            //返回上一级
            TrendsSwitchUtil.rollbackMethod();
        }
        return ticketType - 1;
    }

    private void showTickets(List<TicketInfo> ticketInfos) {
        System.out.println("|-编号-----优惠券名-------------价格-------------说明------------------------");
        if (ticketInfos != null && ticketInfos.size() > 0) {
            for (int i = 0; i < ticketInfos.size(); i++) {
                TicketInfo ticketInfo = ticketInfos.get(i);
                System.out.println("|-" + (i + 1) + "\t" + ticketInfo.getTitle() + "\t" + ticketInfo.getMoney() + "/元");
                System.out.println("|-\t" + ticketInfo.getRemark());
                System.out.println("---------------------------------------------------------");
            }
        } else {
            System.out.println("=========暂无数据========");
        }
    }
}