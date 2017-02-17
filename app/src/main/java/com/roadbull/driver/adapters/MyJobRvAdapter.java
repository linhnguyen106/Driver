package com.roadbull.driver.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.roadbull.driver.R;
import com.roadbull.driver.RouteActivity;
import com.roadbull.driver.models.Job;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by linhnguyenv1 on 2/8/2017.
 */

public class MyJobRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Job> jobs;
    Context context;

    public MyJobRvAdapter(List<Job> jobs,Context context) {
        this.context = context;
        this.jobs = jobs;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myjob_rv_item,null);
        return new MyJobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyJobViewHolder myJobViewHolder = (MyJobViewHolder) holder;
        final Job job = jobs.get(position);
        myJobViewHolder.jobId.setText(String.valueOf(job.getId()));
        myJobViewHolder.vehicleNum.setText(job.getVehicleNumber());
        myJobViewHolder.createOn.setText(job.getCreatedOn());
        myJobViewHolder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RouteActivity.class);
                intent.putExtra(RouteActivity.EXTRA_JOB_ID,String.valueOf(job.getId()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }

    private class MyJobViewHolder extends RecyclerView.ViewHolder{
        TextView jobId;
        TextView vehicleNum;
        TextView createOn;
        View rootView;

        public MyJobViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            jobId = (TextView) itemView.findViewById(R.id.jobIdTv);
            vehicleNum = (TextView) itemView.findViewById(R.id.vehicleNumTv);
            createOn = (TextView) itemView.findViewById(R.id.dateTimeTv);
        }

    }
}
