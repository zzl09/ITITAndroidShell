window.weixin={
    invoke:function(func,args){
        app.invoke('WeixinBridge',func,args);
    },
    //
    getInfo:function(obj){
        weixin.invoke('getInfo',{
            callback:nextInvokeCallback(obj?obj.callback:null)
        })
    },
    registerApp:function(obj){
        weixin.invoke('registerApp',{
            appId:obj.appId,
            callback:nextInvokeCallback(obj?obj.callback:null)
        })
    },
    openWXApp:function(obj){
        weixin.invoke('openWXApp',{
            callback:nextInvokeCallback(obj?obj.callback:null)
        })
    },
    /*
    WXSceneSession  = 0,        聊天界面
    WXSceneTimeline = 1,        朋友圈
    WXSceneFavorite = 2,        收藏
    */
    shareText:function(obj){
        weixin.invoke('shareText',{
            scene:obj.scene,
            text:obj.text,
            callback:nextInvokeCallback(obj?obj.callback:null)
        })
    },
    shareImage:function(obj){
        weixin.invoke('shareImage',{
            scene:obj.scene,
            path:obj.path,
            thumbPath:obj.thumbPath,
            callback:nextInvokeCallback(obj?obj.callback:null)
        })
    },
    shareURL:function(obj){
        weixin.invoke('shareURL',{
            scene:obj.scene,
            title:obj.title,
            description:obj.description,
            url:obj.url,
            thumbPath:obj.thumbPath,
            callback:nextInvokeCallback(obj?obj.callback:null)
        })
    },
    login:function(obj){
        weixin.invoke('login',{
            state:obj?obj.state:null,
            callback:nextInvokeCallback(obj?obj.callback:null)
        })
    },
    pay:function(obj){
        weixin.invoke('pay',{
            partnerId:obj.partnerId,
            prepayId:obj.prepayId,
            packageValue:obj.packageValue,
            nonceStr:obj.nonceStr,
            timeStamp:obj.timeStamp,
            sign:obj.sign,
            callback:nextInvokeCallback(obj?obj.callback:null)
        })
    },
}