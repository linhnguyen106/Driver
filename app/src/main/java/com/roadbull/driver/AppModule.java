package com.roadbull.driver;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by linhnguyenv1 on 2/6/2017.
 */
@Singleton
@Module
public class AppModule {
    Application mApplication;
    private String PREF_NAME ="driver_app";
    public AppModule(Application application){
        mApplication = application;
    }

    @Provides
    Application providesApplication(){
        return mApplication;
    }
    @Provides

    public SharedPreferences getAppPreferences(){
        return  mApplication.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }
}
