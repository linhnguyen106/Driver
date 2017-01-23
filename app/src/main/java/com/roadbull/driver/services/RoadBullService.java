package com.roadbull.driver.services;

import com.roadbull.driver.models.RegisterUser;
import com.roadbull.driver.models.RoadBullUser;
import com.roadbull.driver.models.response.JobResponse;
import com.roadbull.driver.models.response.LoginResponse;
import com.roadbull.driver.models.response.ProfileResponse;
import com.roadbull.driver.models.response.RBResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by linhnguyenv1 on 1/23/2017.
 */

public interface RoadBullService {
    final static String BASE_URL = "http://sandcds.roadbull.com/api/";


    @POST("accounts/login")
    Call<LoginResponse> login(@Body RoadBullUser user);

    @POST("accounts/profile")
    Call<List<ProfileResponse>> getUserProfileByToken(@Header("Authorization") String token);

    @POST("accounts/register")
    Call<RBResponse> registerUser(@Body RegisterUser user);

    @POST("jobs/jobs/myjobs")
    Call<JobResponse> getMyJob(@Header("Authorization") String token);





}
