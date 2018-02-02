package io.itit.shell.wxapi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

import java.util.HashMap;
import java.util.Map;

import io.itit.shell.ShellApp;

/**
 * Created by ntop on 15/9/4.
 */
public class ShellWXPayEntryActivity extends Activity implements IWXAPIEventHandler {
    IWXAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = ShellApp.getWx(this);
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }


    @Override
    public void onReq(BaseReq req) {
        switch (req.getType()) {
            case ConstantsAPI.COMMAND_GETMESSAGE_FROM_WX:
                break;
            case ConstantsAPI.COMMAND_SHOWMESSAGE_FROM_WX:
                break;
            default:
                break;
        }
        finish();
    }

    @Override
    public void onResp(BaseResp resp) {
        int result = 0;
        String code = "";
        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            Map<String,String> resMap = new HashMap<>();
            resMap.put("funcName","weixinPay");
            resMap.put("errCode",resp.errCode+"");
           // UnityPlayer.UnitySendMessage("Canvas","callNativeResult", JSON.toJSONString(resMap));
            Log.d("ITIT", JSON.toJSONString(resp));
            switch (resp.errCode) {
                case BaseResp.ErrCode.ERR_OK:
                    Toast.makeText(getApplicationContext(), "支付成功！", Toast.LENGTH_SHORT).show();
                    break;
                case BaseResp.ErrCode.ERR_USER_CANCEL:
                    Toast.makeText(getApplicationContext(), "支付取消！", Toast.LENGTH_SHORT).show();
                    break;
                case BaseResp.ErrCode.ERR_AUTH_DENIED:
                    Toast.makeText(getApplicationContext(), "支付拒绝！", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(getApplicationContext(), "支付失败！", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        finish();
    }

}