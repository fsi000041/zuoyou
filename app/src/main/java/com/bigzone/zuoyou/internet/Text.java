package com.bigzone.zuoyou.internet;

import com.bigzone.zuoyou.billing.bean.TextBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sszz on 2017/10/17.
 */

public interface Text {
    @GET("crm/potcustomer/getAllAge" )
    Call<TextBean> test(

    );
}
