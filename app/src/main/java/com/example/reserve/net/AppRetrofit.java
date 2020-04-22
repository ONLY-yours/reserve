package com.example.reserve.net;

import com.example.reserve.net.Client.HeaderTokenIntercept;
import com.example.reserve.net.Client.NetRepository;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @auther: lijunjie
 * @createDate: 2020/3/22  12:54
 * @purpose：
 */
public class AppRetrofit {

    private static Api netApi;


    public static Api getNetApi() {
        if (netApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(NetRepository.getClient().build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://121.199.77.184/hotel-ai-api/") // 设置网络请求baseUrl
                    .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析
                    .build();
            netApi = retrofit.create(Api.class);
        }
        return netApi;
    }




    /**
     * 公共参数
     *
     * @param service
     * @param action
     * @param page
     * @param pageSize
     * @return
     */
    public static HashMap<String, String> getBaseHeaders(String service, String action,
                                                         int page, int pageSize) {

        HashMap<String, String> param = new HashMap<>();
        //具体字段看项目
//        if (UserInfoManager.getInstance().getNowUser() != null) {
//            param.put("token", UserInfoManager.getInstance().getNowUser().getToken());
//        }

        //        param.put("Content-type", "application/wocai");
        return param;
    }

    public static HashMap<String, String> getBaseHeaders(String service, String action) {
        return getBaseHeaders(service, action, 1,10);
    }
}
