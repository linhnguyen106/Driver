package com.roadbull.driver.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.roadbull.driver.DriverApplication;
import com.roadbull.driver.R;
import com.roadbull.driver.adapters.MyJobRvAdapter;
import com.roadbull.driver.manager.PrefManager;
import com.roadbull.driver.models.Job;
import com.roadbull.driver.models.response.JobResponse;
import com.roadbull.driver.services.RoadBullService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by linhnguyenv1 on 2/8/2017.
 */

public class MyJobFragment extends BaseFragment implements Callback<JobResponse> {

    @BindView(R.id.timeTv)
    TextView todayTv;
    @BindView(R.id.remainingJobTv)
    TextView remainingJobTv;
    @BindView(R.id.myJobRv)
    RecyclerView myJobRv;
    @BindView(R.id.noItemTv)
    TextView noItemTv;

    @Inject
    Retrofit mRetrofit;
    @Inject
    SharedPreferences mSharedPreferences;
    PrefManager prefManager;

    private RoadBullService mRoadBullService;

    private RecyclerView.LayoutManager mLayoutManager;
    List<Job> jobList;
    MyJobRvAdapter myJobRvAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_job_layout,container,false);
        ButterKnife.bind(this,view);
        ((DriverApplication)getActivity().getApplication()).getNetworkComponent().inject(this);
        ((DriverApplication)getActivity().getApplication()).getAppComponent().inject(this);
        initView();
        return view;
    }

    private void initView(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String todayText = getResources().getString(R.string.today);
        todayTv.setText(Html.fromHtml(todayText +" <b>" + dateFormat.format(date) +"</b>"));
        prefManager = PrefManager.getInstance(mSharedPreferences);

        mLayoutManager = new LinearLayoutManager(getActivity());
        myJobRv.setHasFixedSize(true);
        myJobRv.setLayoutManager(mLayoutManager);
        loadJobs(true);
    }

    private void loadJobs(boolean showDialog){
        if(showDialog){
            showProgressDialog(showDialog);
        }

        if(mRoadBullService == null){
            mRoadBullService = mRetrofit.create(RoadBullService.class);
        }

        String token = prefManager.getToken();

        mRoadBullService.getMyJob(token).enqueue(this);

    }

    @Override
    public void onResponse(Call<JobResponse> call, Response<JobResponse> response) {
        if(!isAdded()){
            return;
        }
        showProgressDialog(false);
        jobList = response.body().getResult();
        if(jobList.isEmpty()){
            noItemTv.setVisibility(View.VISIBLE);
            myJobRv.setVisibility(View.GONE);
            return;
        }
        String remainingText = getResources().getString(R.string.remaining_job);

        remainingJobTv.setText(Html.fromHtml(remainingText +" <b>" + String.valueOf(jobList.size()) +"</b>"));

        noItemTv.setVisibility(View.GONE);
        myJobRv.setVisibility(View.VISIBLE);
        myJobRvAdapter = new MyJobRvAdapter(jobList,getActivity());
        myJobRv.setAdapter(myJobRvAdapter);

    }

    @Override
    public void onFailure(Call<JobResponse> call, Throwable t) {
        if(!isAdded()){
            return;
        }
        noItemTv.setVisibility(View.VISIBLE);
        myJobRv.setVisibility(View.GONE);
        showProgressDialog(false);
        Toast.makeText(getActivity(),t.getMessage(),Toast.LENGTH_LONG).show();
    }

}
