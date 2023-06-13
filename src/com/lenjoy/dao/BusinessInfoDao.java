package com.lenjoy.dao;

import com.lenjoy.entity.BusinessInfo;

public interface BusinessInfoDao {

    int addBusinessInfo(BusinessInfo businessInfo);

    BusinessInfo getBusinessInfoByUserNameAndPassword(String userName, String password);
}
