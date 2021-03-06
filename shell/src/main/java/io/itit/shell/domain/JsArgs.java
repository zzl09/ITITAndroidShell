package io.itit.shell.domain;

import java.util.List;
import java.util.Map;

/**
 * Created by Lee_3do on 2017/12/25.
 */

public class JsArgs {
    /**
     * func : pushPage
     * args : {"path":"/index.html","query":"a=1&b=2","callback":null}
     */
    public String name;
    public String func;
    public ArgsBean args;

    public static class ArgsBean {
        /**
         * path : /index.html
         * query : a=1&b=2
         * callback : null
         */
        public int badge;
        public int duration;
        public Integer offset;
        public Integer length;
        public int width;
        public int height;
        public int x;
        public int y;
        public String id;
        public String body;
        public Boolean navigate;
        public Boolean visible;
        public Boolean enable;
        public Boolean nopresent;
        public int index;
        public int limit;
        public double quality;
        public double latitude;
        public double longitude;
        public int select;
        public String title;
        public Map<String,Object> data;
        public Map<String,Object> header;
        public String name;
        public String appId;
        public String appKey;
        public int scene;
        public String text;
        public List<String> titles;
        public String position;
        public String source;
        public String dest;
        public int timeInterval;
        public List<String> images;
        public List<String> contents;
        public String image;
        public String selectedColor;
        public String color;
        public String code;
        public String string;
        public String content;
        public String url;
        public String urls;
        public String format;
        public String path;
        public String fullpath;
        public String description;
        public String state;
        public String thumbPath;
        public String query;
        public String type;
        public String message;
        public String callback;
        public String finishCallback;
        public String orderString;
        public String key;
        public Object value;
        public Map<String,Object> args;
        public List<String> options;
        public List<String> items;
        public String mode;
        public String method;
        public Long date;

        public String partnerId;
        public String prepayId;
        public String nonceStr;
        public String timeStamp;
        public String sign;
        public String packageValue;

        public Integer rate;
    }
}
