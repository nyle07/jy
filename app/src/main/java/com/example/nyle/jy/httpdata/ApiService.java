package com.example.nyle.jy.httpdata;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/10/23.
 */

public interface ApiService{
    @GET("startup/")
    Observable <String> getString(@Query("key")String key,@Query("num") String num,@Query("page") int page);

    @GET("startup/")
    Observable <NewsGson> getNewsData(@Query("key")String key,@Query("num") String num,@Query("page") int page);

    @GET("meinv/")
    Observable <MeiNvGson> getPictureData(@Query("key")String key,@Query("num") String num,@Query("page") int page);
}
