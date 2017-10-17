package com.bigzone.zuoyou.internet;

import com.bigzone.zuoyou.login.bean.LoginBean;

import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by caoyang
 * 接口类
 */

public interface Yukicom {

    /**
     * 取消退款  http://118.190.84.158:9191/zuoyou/v1/api/sys/lg/login?dealerid=zytest&user=admin&pwd=21232f297a57a5a743894a0e4a801fc3
     */
    @Headers("Content-Type:text/plain")
    @POST("sys/lg/login")
    Observable<LoginBean> delBackMoney(@Query("dealerid") String dealerid,
                                       @Query("user") String user,
                                       @Query("pwd") String pwd);

}


//http://118.190.84.158:9191/zuoyou/v1/api/crm/potcustomer/getAllAge

