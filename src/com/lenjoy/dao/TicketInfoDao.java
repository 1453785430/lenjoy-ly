package com.lenjoy.dao;

import com.lenjoy.entity.TicketInfo;

import java.util.List;

public interface TicketInfoDao {
    List<TicketInfo> getTicketInfoListByBusinessId(Integer id);

    int addTicketInfo(TicketInfo ticketInfo);
}
