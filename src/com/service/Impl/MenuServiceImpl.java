package com.service.Impl;

import com.pojo.Btn;
import com.pojo.Menu;
import com.service.MenuService;
import com.util.IndexJson;
import com.util.InitJson;
import com.util.LayuiTable;
import com.util.TreeTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.util.Vessel.menuDao;

public class MenuServiceImpl implements MenuService {
    //获取所有权限目录
    @Override
    public LayuiTable<TreeTable> getMenus() {
        LayuiTable<TreeTable> layuiTable = new LayuiTable<>();
        List<Menu> menuList = menuDao.getMenuList();
        List<TreeTable> treeTableList = new ArrayList<>();
        for (Menu menu : menuList) {
            TreeTable treeTable = new TreeTable();
            treeTable.setAuthorityId(menu.getResId());
            treeTable.setAuthorityName(menu.getName());
            treeTable.setAuthority(menu.getResKey());
            treeTable.setIsMenu(menu.getType());
            treeTable.setChecked(true);
            treeTable.setOpen(true);
            if (menu.getType()==0) {
                treeTable.setParentId(menu.getParentId()-1);
            }else {
                treeTable.setParentId(menu.getParentId());
            }
            treeTableList.add(treeTable);
        }
        layuiTable.setMsg("");
        layuiTable.setCode(0);
        layuiTable.setCount(100);
        layuiTable.setData(treeTableList);
        return layuiTable;
    }

    ////查询所有菜单列表
    @Override
    public List<Menu> getMenuList() {
        return menuDao.getMenuList();
    }

    ////通过用户id与目录类型type查询用户目录(查询2级目录)
    /*@Override
    public InitJson getMenuList(int id) {

        //存放目录集合
        List<IndexJson> indexJsonList = new ArrayList<IndexJson>();
        //查询目录
        List<Menu> menuList = menuDao.getMenuList(id,0);
        for (Menu menu : menuList) {
            IndexJson indexJson = new IndexJson();
            indexJson.setTitle(menu.getName());
            indexJson.setImage("");
            indexJson.setTarget("");
            indexJson.setIcon(menu.getIcon());
            indexJson.setHref("");

            //存放菜单的集合
            List<IndexJson> indexJsonList1 = new ArrayList<>();
            List<Menu> menuList1 = menuDao.getMenuList(id,1);
            for(Menu menu1 : menuList1) {
                if (menu1.getParentId()==menu.getResId()){
                    IndexJson indexJson1 = new IndexJson();
                    indexJson1.setTitle(menu1.getName());
                    indexJson1.setImage("");
                    indexJson1.setTarget("_self");
                    indexJson1.setIcon(menu1.getIcon());
                    indexJson1.setHref(menu1.getResUrl() + "&&resId=" + menu1.getResId());
                    indexJsonList1.add(indexJson1);
                }
            }
            indexJson.setChild(indexJsonList1);
            indexJsonList.add(indexJson);
        }
        IndexJson logoInfo = new IndexJson("LAYUI MINI","","images/logo.png");
        IndexJson homeInfo = new IndexJson("首页","page/welcome-1.html?t=1");

        InitJson initJson = new InitJson();
        initJson.setLogoInfo(logoInfo);
        initJson.setHomeInfo(homeInfo);

        IndexJson menuInfo = new IndexJson("首页","page/welcome-1.html?t=1","","","",indexJsonList);
        List<IndexJson> list =new ArrayList<IndexJson>();
        list.add(menuInfo);

        initJson.setMenuInfo(list);

        return initJson;
    }*/

    @Override
    public InitJson getMenuList(int id) {

        //存放目录集合
        List<IndexJson> indexJsonList = new ArrayList<IndexJson>();
        //查询目录
        List<Menu> menuList = menuDao.getMenuList(id, 0);
        for (Menu menu : menuList) {
            IndexJson indexJson = new IndexJson();
            indexJson.setTitle(menu.getName());
            indexJson.setImage("");
            indexJson.setTarget("");
            indexJson.setIcon(menu.getIcon());
            indexJson.setHref("");

            //存放菜单的集合
            List<IndexJson> indexJsonList1 = new ArrayList<>();
            List<Menu> menuList1 = menuDao.getMenuList(id, 1);
            for (Menu menu1 : menuList1) {
                if (menu1.getParentId() == menu.getResId()) {
                    IndexJson indexJson1 = new IndexJson();
                    indexJson1.setTitle(menu1.getName());
                    indexJson1.setImage("");
                    indexJson1.setTarget("_self");
                    indexJson1.setIcon(menu1.getIcon());
                    indexJson1.setHref(menu1.getResUrl() + "&&resId=" + menu1.getResId());
                    indexJsonList1.add(indexJson1);
                }
            }
            indexJson.setChild(indexJsonList1);
            indexJsonList.add(indexJson);
        }

        IndexJson logoInfo = new IndexJson("LAYUI MINI", "", "images/logo.png");
        IndexJson homeInfo = new IndexJson("首页", "page/welcome-1.html?t=1");

        InitJson initJson = new InitJson();
        initJson.setLogoInfo(logoInfo);
        initJson.setHomeInfo(homeInfo);
        initJson.setMenuInfo(indexJsonList); // 直接设置 indexJsonList

        return initJson;
    }

    @Override
    public Menu getMenuById(int id) {
        return menuDao.getMenuById(id);
    }


    ////通过用户id与菜单的编号id获取用户所在菜单目录的按钮
    @Override
    public List<Menu> getMenuBtn(int id, int resId) {
        return menuDao.getMenuBtn(id,resId);
    }

    @Override
    public boolean isExist(String s) {
        Menu menu = menuDao.isExist(s);
        boolean isExist = true;
        if (menu.getResKey() == null){
            isExist = false;
        }
        return isExist;
    }

    @Override
    public int addMenu(Menu menu) {
        return menuDao.addMenu(menu);
    }

    @Override
    public int delMenu(int id) {
        return menuDao.delMenu(id);
    }

    @Override
    public int updateMenu(Menu menu) {
        return menuDao.updateMenu(menu);
    }

    @Override
    public List<Btn> getBtnAll() {
        List<Btn> btnList = menuDao.getBtnAll();
        return btnList;
    }

    @Override
    public List<Menu> getMenuByType(int type) {
        return menuDao.getMenuByType(type-2);
    }

    //根据目录id获取目录
    @Override
    public Menu allMenuById(Menu menu) {
        Menu menu2 = new Menu();
        for (Menu menu1 : menuDao.allMenuById(menu)) {
            menu2 = menu1;
        }
        Menu fatherMenu = getFatherName(menu2.getParentId());
        menu2.setFatherName(fatherMenu.getName());
        int type = menu2.getType() + 1;
        menu2.setType(type);
//        menu2.setResName(fatherMenu.getName());
        return menu2;
    }

    @Override
    public Menu getFatherName(int id) {
        Menu menu2 = new Menu();
        for (Menu menu1 : menuDao.getFatherName(id)) {
            menu2 = menu1;
        }
        return menu2;
    }

    //判断权限名是否存在
    @Override
    public int isMenuName(Menu menu) {
        return menuDao.isMenuName(menu);
    }

    //判断请求路径是否存在
    @Override
    public int isMenuUrl(Menu menu) {
        return menuDao.isMenuUrl(menu);
    }
}
