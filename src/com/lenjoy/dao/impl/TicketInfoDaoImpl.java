package com.lenjoy.dao.impl;

import com.lenjoy.dao.TicketInfoDao;
import com.lenjoy.entity.TicketInfo;
import com.lenjoy.utils.BaseDao2;

import java.util.List;

public class TicketInfoDaoImpl extends BaseDao2<TicketInfo> implements TicketInfoDao {
    @Override
    public List<TicketInfo> getTicketInfoListByBusinessId(Integer id) {
        return selectListForObject("select * from t_ticket_Info where bus_id = ?",TicketInfo.class,id);
    }

    @Override
    public int addTicketInfo(TicketInfo ticketInfo) {
        String sql = "insert into t_ticket_info values(null,?,?,?,?,?,?,?,?,?,now(),?,default)";
        return executeUpdate(sql,
                ticketInfo.getTitle(),
                ticketInfo.getBusId(),
                ticketInfo.getType(),
                ticketInfo.getDikou(),
                ticketInfo.getZheKou(),
                ticketInfo.getMan(),
                ticketInfo.getJian(),
                ticketInfo.getMoney(),
                ticketInfo.getRemark(),
                ticketInfo.getCreateUser()
                );
    }

}
