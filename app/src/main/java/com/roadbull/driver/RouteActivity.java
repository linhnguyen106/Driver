package com.roadbull.driver;

import android.content.SharedPreferences;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.roadbull.driver.adapters.RouteRvAdapter;
import com.roadbull.driver.manager.PrefManager;
import com.roadbull.driver.models.Job;
import com.roadbull.driver.models.JobDetail;
import com.roadbull.driver.models.LocationItem;
import com.roadbull.driver.models.Order;
import com.roadbull.driver.models.RBLocation;
import com.roadbull.driver.models.RBRoute;
import com.roadbull.driver.models.Route;
import com.roadbull.driver.models.TimeSlot;
import com.roadbull.driver.models.response.JobResponse;
import com.roadbull.driver.services.RoadBullService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RouteActivity extends AppCompatActivity {
    public final static String EXTRA_JOB_ID = "extra_job_id";
    @BindView(R.id.routeRv)
    RecyclerView mRecyclerView;


    @Inject
    Retrofit mRetrofit;
    @Inject
    SharedPreferences mSharedPreferences;

    PrefManager mPrefManager;
    private String mCurrentJobId;
    private List<JobDetail> mJobDetails;
    private List<LocationItem> mPins;
    private RecyclerView.LayoutManager mLayoutManager;
    RouteRvAdapter routeRvAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        mCurrentJobId = getIntent().getExtras().getString(EXTRA_JOB_ID,"0");
        ButterKnife.bind(this);
        ((DriverApplication)getApplication()).getNetworkComponent().inject(this);
        ((DriverApplication)getApplication()).getAppComponent().inject(this);
        mPrefManager = PrefManager.getInstance(mSharedPreferences);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        loadJob("");
    }

    private void loadJob(String searchString){
        RoadBullService roadBullService = mRetrofit.create(RoadBullService.class);
        roadBullService.findJobById(mPrefManager.getToken(),mCurrentJobId).enqueue(new Callback<JobResponse>() {
            @Override
            public void onResponse(Call<JobResponse> call, Response<JobResponse> response) {
                if(response.isSuccessful() && response.body().getCode() == 0){
                    List<Job> jobs = response.body().getResult();
                    if(jobs == null || jobs.isEmpty()){
                        // no job found
                        noJobFound();
                        return;
                    }

                    parseJobDetail(jobs.get(0),response.body().getTimeslots());

                }
            }

            @Override
            public void onFailure(Call<JobResponse> call, Throwable t) {

            }
        });

    }
    private void parseJobDetail(Job job, List<TimeSlot> timeSlots){
        mJobDetails = new ArrayList<>();
        mPins = new ArrayList<>();
        Route route = job.getRoutes().getRoute();
        List<RBLocation> rbLocations = job.getRoutes().getLocations();
        int jobId = job.getId();
        List<LocationItem> footSteps = route.getFootSteps();
        for(int i = 1 ; i< route.getStops(); i++ ){
            int index = route.getSteps().get(i) - 1;

            RBLocation rbLocation = rbLocations.get(index);
            JobDetail jobDetail  = new JobDetail();

            jobDetail.setJobId(jobId);
            jobDetail.setFromName(rbLocation.getCustomerName());
            jobDetail.setFromCompany(rbLocation.getCustomerCompany());
            jobDetail.setFromAddress(rbLocation.getCustomerAddress());
            jobDetail.setFromMobilePhone(rbLocation.getCustomerMobilePhone());
            jobDetail.setToName(rbLocation.getCustomerName());
            jobDetail.setToAddress(rbLocation.getCustomerAddress());
            jobDetail.setToCompany(rbLocation.getCustomerCompany());
            jobDetail.setToMobilePhone(rbLocation.getCustomerMobilePhone());
            jobDetail.setConsignmentNumber(rbLocation.getConsignmentNumbers());
            jobDetail.setOrders(rbLocation.getOrders());
            jobDetail.setType(rbLocation.getType());
            jobDetail.setSizeName(rbLocation.getSizeName());
            jobDetail.setDone(rbLocation.isDone());
            jobDetail.setFromGeolocation(footSteps.get(i-1));
            jobDetail.setToGeolocation(footSteps.get(i));

            List<Order> orders = rbLocation.getOrders();
            Order order = orders.get(0);
            jobDetail.setOperatorRemark(order.getRemark());
            jobDetail.setPickupTimeSlotId(order.getPickupTimeSlotId());
            jobDetail.setDeliveryTimeSlotId(order.getDeliveryTimeSlotId());
            jobDetail.setTimeslots(timeSlots);
            jobDetail.setHasRemark(false);
            boolean failed = false;
            for(Order od : orders){
                if(od.getStatus() == 4 || od.getStatus() == 9){
                    failed = true;
                }
            }
            jobDetail.setHasFailed(failed);

            mJobDetails.add(jobDetail);


            LocationItem locationItem = new LocationItem();
            locationItem.setLatitude(footSteps.get(i).getLatitude());
            locationItem.setLongitude(footSteps.get(i).getLongitude());

            String consignmentNumbers = "";
            for (int j = 0; j < rbLocation.getConsignmentNumbers().size(); j++) {
                consignmentNumbers += rbLocation.getConsignmentNumbers().get(j);
                    consignmentNumbers += ",";

            }
            locationItem.setOrder(consignmentNumbers);
            locationItem.setType(rbLocation.getType());
            locationItem.setName(rbLocation.getCustomerName());
            mPins.add(locationItem);
            displayJobDetail();


        }



    }
    private void displayJobDetail(){
        routeRvAdapter = new RouteRvAdapter(mJobDetails,this);
        mRecyclerView.setAdapter(routeRvAdapter);
    }

    private void noJobFound(){

    }


}
