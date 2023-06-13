package com.lenjoy.dao.impl;

import com.lenjoy.dao.BusinessInfoDao;
import com.lenjoy.entity.BusinessInfo;
import com.lenjoy.utils.BaseDao2;

public class BusinessInfoDaoImpl extends BaseDao2<BusinessInfo> implements BusinessInfoDao {
    @Override
    public int addBusinessInfo(BusinessInfo businessInfo) {
        String sql = "insert into t_business_info values(null,?,?,?,?,?,?,default,now(),default,default)";
        return executeUpdate(sql,
                businessInfo.getName(),
                businessInfo.getUserName(),
                businessInfo.getPassword(),
                businessInfo.getLxrName(),
                businessInfo.getTel(),
                businessInfo.getAddress()
                );
    }

    @Override
    public BusinessInfo getBusinessInfoByUserNameAndPassword(String userName, String password) {
        return selectOne("select * from t_business_info where user_name=? and `password` =?",
                BusinessInfo.class,
                userName,
                password
                );
    }
}
