package com.roadbull.driver;

import com.roadbull.driver.fragments.MyJobFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by linhnguyenv1 on 2/6/2017.
 */
@Singleton
@Component(modules = {NetworkModule.class,AppModule.class})
public interface NetworkComponent {
    void inject(LoginActivity loginActivity);
    void inject(MyJobFragment fragment);
    void inject(RouteActivity activity);

}
