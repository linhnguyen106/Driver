package com.roadbull.driver;

import android.app.Application;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by linhnguyenv1 on 2/6/2017.
 */
@Singleton
@Module
public class NetworkModule {
    private final static String BASE_URL = "http://sandcds.roadbull.com/api/";
    private final static int TIME_OUT = 10;
    public NetworkModule(){

    }

    @Provides
    Cache provideOkHttpCache(Application application){
        int cacheSize = 10*1024*1024;//10 MiB
        Cache cache = new Cache(application.getCacheDir(),cacheSize);
        return  cache;
    }

    @Provides
    OkHttpClient provideOkHttpClient(Cache cache){
        OkHttpClient client =  new OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
       return client;
    }

    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build();

        return retrofit;
    }

}
