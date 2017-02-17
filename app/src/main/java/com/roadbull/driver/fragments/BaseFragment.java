package com.roadbull.driver.fragments;

import android.support.v4.app.Fragment;

/**
 * Created by linhnguyenv1 on 2/8/2017.
 */

public class BaseFragment extends Fragment {
    ProgressDialogFragment progressDialogFragment;
    protected void setTitle(String title){
        getActivity().setTitle(title);
    }

    protected void showProgressDialog(boolean isShow){
        if(isShow){
            if(progressDialogFragment == null){
                progressDialogFragment = new ProgressDialogFragment();
                progressDialogFragment.show(getActivity().getSupportFragmentManager(),"");
            }
        }else{
            if(progressDialogFragment!=null){
                progressDialogFragment.dismiss();
            }
        }

    }

    @Override
    public void onDetach() {
        if(progressDialogFragment!=null){
            progressDialogFragment.dismiss();
        }
        super.onDetach();
    }
}
