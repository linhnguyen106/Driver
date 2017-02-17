package com.roadbull.driver;

import android.app.Application;

/**
 * Created by linhnguyenv1 on 2/6/2017.
 */

public class DriverApplication extends Application {
    AppComponent appComponent;
    NetworkComponent networkComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).networkModule(new NetworkModule()).build();
        networkComponent = DaggerNetworkComponent.builder().networkModule(new NetworkModule()).appModule(new AppModule(this)).build();

    }

    public NetworkComponent getNetworkComponent(){
     return  networkComponent;
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
