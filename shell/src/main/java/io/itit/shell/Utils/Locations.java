package io.itit.shell.Utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;

import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.Map;

import io.itit.shell.domain.JsArgs;

/**
 * 位置信息的Utils
 */
public class Locations  {
    public static Locations location = new Locations();
    static LocationManager locationManager;

    /**
     * 初始化位置信息
     *
     * @param context
     * @param webApp
     * @param args
     */
    public  void init(Activity context, WebApp webApp, JsArgs.ArgsBean args) {
        getLocation(context,webApp,args);
    }

    @SuppressLint("MissingPermission")
    private static void getLocation(Activity context, WebApp webApp, JsArgs.ArgsBean args) {
        Logger.d("init location");
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        LocationProvider gpsProvider = locationManager.getProvider(LocationManager.GPS_PROVIDER);
        LocationProvider netWorkProvider = locationManager.getProvider(LocationManager
                .NETWORK_PROVIDER);

        if (gpsProvider != null) {
            Logger.d("GPS_PROVIDER location");
            locationManager.requestSingleUpdate(LocationManager.GPS_PROVIDER, new
                    MyLocationListener(webApp, args), null);

        }
        if (netWorkProvider != null) {
            Logger.d("NETWORK_PROVIDER location");
            locationManager.requestSingleUpdate(LocationManager.NETWORK_PROVIDER, new
                    MyLocationListener(webApp, args), null);
        } else {
            Logger.e("failed location");
        }
    }

    public static class MyLocationListener implements LocationListener {
        private WebApp webApp;
        private JsArgs.ArgsBean args;

        public MyLocationListener(WebApp webApp, JsArgs.ArgsBean args) {
            this.webApp = webApp;
            this.args = args;
        }

        // Provider的状态在可用、暂时不可用和无服务三个状态直接切换时触发此函数
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        // Provider被enable时触发此函数，比如GPS被打开
        @Override
        public void onProviderEnabled(String provider) {

        }

        // Provider被disable时触发此函数，比如GPS被关闭
        @Override
        public void onProviderDisabled(String provider) {

        }

        // 当坐标改变时触发此函数，如果Provider传进相同的坐标，它就不会被触发
        @Override
        public void onLocationChanged(android.location.Location location) {
            if (location != null) {
                Map<String, Object> res = new HashMap<>();
                res.put("success", true);
                res.put("latitude", location.getLatitude());
                res.put("longitude", location.getLongitude());
                webApp.evalJs(args.callback, res);
                // Logger.d("onLocationChanged location:" + getLocation());
            }
        }
    }

}