package com.bigzone.zuoyou.utils;

import com.google.gson.Gson;

/**
 * Created by 郝宏伟 on 2016-11-02.
 */

public class GsonUtils {
    // 将Json数据解析成相应的映射对象
    public static <T> T parseJsonWithGson(String jsonData, Class<T> type) {
        Gson gson = new Gson();
        T result = gson.fromJson(jsonData, type);
        return result;
    }


}
