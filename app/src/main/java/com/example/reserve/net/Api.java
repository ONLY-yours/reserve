package com.example.reserve.net;


import com.example.reserve.bean.CurstomAddBean;
import com.example.reserve.bean.CurstomListBean;
import com.example.reserve.bean.HomeListBean;
import com.example.reserve.bean.LoginBean;
import com.example.reserve.bean.TBean;

import java.util.ArrayList;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
/**
 * @auther: lijunjie
 * @createDate: 2020/3/12  19:32
 * @purpose：
 */
public interface Api {

    //1.1登陆接口
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("app/user/login")
    Call<LoginBean>doLogin(
            @Body RequestBody json
    );

    //1.2注册
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("app/user/register")
    Call<LoginBean>doRegist(
            @Body RequestBody json
    );

    //1.3发送验证码
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("app/user/register/verify")
    Call<LoginBean>sedPhoneNumber(
            @Body RequestBody json
    );

    //2.3查询客户列表
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("hotel/customer/userInfo/getCustomerList")
    Call<CurstomListBean>getCurstomList(
            @Body RequestBody json
    );

    //2.4添加客户
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("hotel/customer/userInfo/insert")
    Call<CurstomAddBean>sendInsertCustom(
            @Body RequestBody json
    );

    //2.5修改信息
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("hotel/customer/userInfo/update")
    Call<TBean>updateCurstomMessage(
            @Body RequestBody json
    );


    //3.1获取房间类型
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("hotel/room/type/getListDetail")
    Call<HomeListBean>getHomeList(
            @Body RequestBody json
    );

}
