package com.roadbull.driver.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Layout;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.roadbull.driver.R;
import com.roadbull.driver.models.JobDetail;
import com.roadbull.driver.models.Order;
import com.roadbull.driver.models.TimeSlot;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by linhnguyenv1 on 2/10/2017.
 */

public class RouteRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<JobDetail> mJobDetails;
    Context context;
    public RouteRvAdapter(List<JobDetail> mJobDetails,Context context) {
        this.mJobDetails = mJobDetails;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.route_rv_item,null);

        RouteViewHolder viewHolder = new RouteViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        JobDetail jobDetail = mJobDetails.get(position);
        RouteViewHolder viewHolder = (RouteViewHolder) holder;
        String fromText = "";
        String toText = "";
        String timeSlotString = "";

        if(jobDetail.getOrders().isEmpty()){

            if(jobDetail.getType() == 0){
                for(TimeSlot timeSlot : jobDetail.getTimeslots()){
                    if(timeSlot.getId() == jobDetail.getPickupTimeSlotId()){
                        timeSlotString = String.format("%s%s%s%s%s%s",timeSlot.getText()," (" ,timeSlot.getFromTime()," - ",timeSlot.getToTime(), ")");
                        break;
                    }

                }
                if(TextUtils.isEmpty(jobDetail.getFromCompany())){
                    toText  = "<b>" + String.valueOf(position + 1) + ".</b> " + context.getString(R.string.to) + " <b>" + jobDetail.getFromName() + ", " + jobDetail.getFromAddress() + "</b><br /><font color=\"#ff0000\"><b>" + timeSlotString + "</b></font>";
                }else{
                    toText  = "<b>" + String.valueOf(position + 1) + ".</b> " + context.getString(R.string.to) + " <b>" + jobDetail.getFromCompany() + ", " + jobDetail.getFromAddress() + "</b><br /><font color=\"#ff0000\"><b>" + timeSlotString + "</b></font>";
                }

                Log.i("textTodisplay"," time->" +timeSlotString );

            }else{
                for(TimeSlot timeSlot : jobDetail.getTimeslots()){
                    if(timeSlot.getId() == jobDetail.getDeliveryTimeSlotId()){
                        timeSlotString = String.format("%s%s%s%s%s%s",timeSlot.getText()," (" ,timeSlot.getFromTime()," - ",timeSlot.getToTime(), ")");
                        break;

                    }
                }
                if(TextUtils.isEmpty(jobDetail.getToCompany())){
                    toText  = "<b>" + String.valueOf(position + 1) + ".</b> " + context.getString(R.string.to) + " <b>" + jobDetail.getToName() + ", " + jobDetail.getToAddress() + "</b><br /><font color=\"#2fa33b\"><b>" + timeSlotString + "</b></font>";

                }else {
                    toText  = "<b>" + String.valueOf(position + 1) + ".</b> " + context.getString(R.string.to) + " <b>" + jobDetail.getToCompany() + ", " + jobDetail.getToAddress() + "</b><br /><font color=\"#2fa33b\"><b>" + timeSlotString + "</b></font>";
                }
                Log.i("textTodisplay"," time 2 ->" +timeSlotString );

            }
            Log.i("textTodisplay","->" +Html.fromHtml(toText) );

        }else{
            List<Order> orders = jobDetail.getOrders();
            Order order = orders.get(0);
            String color;
            timeSlotString = "";
            if(jobDetail.getType() == 0){
                color = "#ff0000";
                for(TimeSlot timeSlot : jobDetail.getTimeslots()){
                    if(timeSlot.getId() == order.getPickupTimeSlotId()){
                        timeSlotString = String.format("%s%s%s%s%s%s",timeSlot.getText()," (" ,timeSlot.getFromTime()," - ",timeSlot.getToTime(), ")");
                        Log.i("textTodisplay"," time  1 3->" +timeSlotString );
                        break;

                    }
                }
            }else if(jobDetail.getType() == 1){
                color = "#00ff00";
                for(TimeSlot timeSlot : jobDetail.getTimeslots()){
                    if(timeSlot.getId() == order.getDeliveryTimeSlotId()){

                        timeSlotString = String.format("%s%s%s%s%s%s",timeSlot.getText()," (" ,timeSlot.getFromTime()," - ",timeSlot.getToTime(), ")");
                        Log.i("textTodisplay"," time 2 3->" +timeSlotString );
                        break;

                    }
                }

            }else{
                color = "#ff0000";
                timeSlotString = "Return to sender";
            }

            if(TextUtils.isEmpty(jobDetail.getToCompany())){
                toText  = "<b>" + String.valueOf(position + 1) + ".</b> " + context.getString(R.string.to) + " <b>" + jobDetail.getToName() + ", " + jobDetail.getToAddress() + "</b><br /><font color="+ color+"><b>" + timeSlotString + "</b></font>";
            }else{
                toText  = "<b>" + String.valueOf(position + 1) + ".</b> " + context.getString(R.string.to) + " <b>" + jobDetail.getToCompany() + ", " + jobDetail.getToAddress() + "</b><br /><font color="+color+"><b>" + timeSlotString + "</b></font>";

            }

        }

        String postalCode = jobDetail.getPostalCode();
        String postalCodeText = "<font color=\"#000000\"><b>PostalCode : " + postalCode + "</b></font>";
        viewHolder.postCodeTv.setText(Html.fromHtml(postalCodeText));
        viewHolder.fromTv.setText(Html.fromHtml(toText));
//        viewHolder.routeType.setBackgroundColor(Color.RED);
        Log.i("textTodisplay"," time 3->" +timeSlotString );

        Log.i("textTodisplay","->" +Html.fromHtml(toText) );
//        viewHolder.toTv.setText("");
    }

    @Override
    public int getItemCount() {
        return mJobDetails.size();
    }


    class RouteViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.routeType)
        View routeType;
        @BindView(R.id.fromTv)
        TextView fromTv;
//        @BindView(R.id.toTv)
//        TextView toTv;
        @BindView(R.id.postCode)
        TextView postCodeTv;





        public RouteViewHolder(View itemView) {
            super(itemView);
            routeType = itemView.findViewById(R.id.routeType);
            fromTv = (TextView)itemView.findViewById(R.id.fromTv);
//            toTv = (TextView)itemView.findViewById(R.id.toTv);
            postCodeTv = (TextView)itemView.findViewById(R.id.postCode);

        }
    }
}
