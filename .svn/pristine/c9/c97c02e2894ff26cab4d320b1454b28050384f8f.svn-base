package com.gmm.drp.utils;

import com.gmm.drp.vo.R;

public class ResultUtil {
    //
    public static R setOK(String msg){
        return new R(200,msg,null);
    }
    public static R setOK(String msg, Object data){
        return new R(200, msg, data);
    }
    public static R setERROR(String msg){
        return new R(400,msg,null);
    }
    public static R setRes(int count){
        if(count>0){
            return setOK("操作成功");
        }else {
            return setERROR("操作失败");
        }
    }

}
