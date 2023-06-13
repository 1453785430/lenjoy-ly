package com.lenjoy.dao;

import com.lenjoy.entity.MenuInfo;

import java.util.List;

public interface MenuInfoDao {
    /**
     * 根据菜单父级ID和菜单类型获取菜单集合
     * @param pId 父级菜单ID
     * @return 菜单集合
     */
    List<MenuInfo> getMenuInfoListByPId(Integer pId);

    /**
     * 添加菜单
     * @param menuInfo 菜单对象
     * @return 受影响行数 (用来判断是否成功添加)
     */
    int addMenuInfo(MenuInfo menuInfo);

    /**
     * 根据菜单ID获取菜单对象
     * @param id 菜单Id
     * @return 菜单对象
     */
    MenuInfo getMenuInfoById(Integer id);
}
