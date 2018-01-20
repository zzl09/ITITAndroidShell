package io.itit.shell.domain;

import java.util.List;

/**
 * Created by Lee_3do on 2017/12/25.
 */

public class AppConfig {

    /**
     * debug : true
     * serverRoot1 : http://localhost:7005
     * version : 1.0
     * pageBackgroundColor : #555555
     * navigationBarBackgroundColor : #ffff00
     * navigationBarColor : #ff0000
     * tabBarTintColor : #ff684f
     * tabBarBackgroundColor : #33ff21
     * tabBarItems : [{"page":"/index.html","title":"首页","icon":"/tabbar-icon.png"},
     * {"page":"/index.html","title":"首页1","icon":"/tabbar-icon.png"},{"page":"/index.html",
     * "title":"首页2","icon":"/navbar-icon.png"}]
     */

    public boolean debug;
    public String serverRoot1;
    public String version;
    public String pageBackgroundColor;
    public String navigationBarBackgroundColor;
    public String navigationBarColor;
    public String tabBarTintColor;
    public String tabBarBackgroundColor;
    public List<TabBarItemsBean> tabBarItems;
    public List<Pages> pages;

    public static class TabBarItemsBean {
        /**
         * page : /index.html
         * title : 首页
         * icon : /tabbar-icon.png
         */

        public String page;
        public String title;
        public String icon;
    }

    public static class Pages {

        public String page;
        public String navigationBarBackgroundColor;
        public String navigationBarColor;
        public String pageBackgroundColor;
        public Boolean hideNavigationBar;
    }
}
