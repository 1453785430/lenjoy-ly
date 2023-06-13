package com.lenjoy.controller;

import com.lenjoy.service.TicketInfoService;
import com.lenjoy.service.impl.TicketInfoServiceImpl;

public class TicketInfoController {
    private TicketInfoService ticketInfoService = new TicketInfoServiceImpl();
    public void showTicketList(){
        ticketInfoService.showTicketList();
    }

    public void addTicket(){
        ticketInfoService.addTicket();
    }
}
