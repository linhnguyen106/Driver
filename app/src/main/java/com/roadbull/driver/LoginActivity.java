package com.roadbull.driver;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.roadbull.driver.manager.PrefManager;
import com.roadbull.driver.models.RoadBullUser;
import com.roadbull.driver.models.response.LoginResponse;
import com.roadbull.driver.models.response.ProfileResponse;
import com.roadbull.driver.services.RoadBullService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements View.OnFocusChangeListener {

    @Inject
    Retrofit mRetrofit;
    @Inject
    SharedPreferences mSharedPreferences;


    // UI references.
    private EditText mUserNameView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private CheckBox mRememberMe;
    private Button mForgotPasswordButton;
    private Button mRegisterButton;
    private PrefManager mPrefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((DriverApplication)getApplication()).getNetworkComponent().inject(this);
        ((DriverApplication)getApplication()).getAppComponent().inject(this);
        mPrefManager = PrefManager.getInstance(mSharedPreferences);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mUserNameView = (EditText) findViewById(R.id.username);
        mRememberMe = (CheckBox) findViewById(R.id.rememberMe);
        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });
        mUserNameView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.next) {
                    mPasswordView.requestFocus();
                    return true;
                }
                return false;
            }
        });
        mUserNameView.setOnFocusChangeListener(this);


        Button mSignInButton = (Button) findViewById(R.id.staff_sign_in_button);
        mSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
        mForgotPasswordButton = (Button) findViewById(R.id.forgot_password_button);
        mForgotPasswordButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
//                startActivity(new Intent(getContext(), ForgotPasswordActivity.class));
            }
        });

        mRegisterButton = (Button) findViewById(R.id.register_button);
        mRegisterButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
//                startActivity(new Intent(getContext(), RegisterActivity.class));
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        if(mPrefManager.isRemember()){
            mRememberMe.setChecked(true);
            mUserNameView.setText(mPrefManager.getUserName());
            mPasswordView.setText(mPrefManager.getPassword());
            attemptLogin();
        }

    }





    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {

        // Reset errors.
        mUserNameView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String userName = mUserNameView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(userName)) {
            mUserNameView.setError(getString(R.string.error_field_required));
            focusView = mUserNameView;
            cancel = true;
        } else if (!isUsernameValid(userName)) {
            mUserNameView.setError(getString(R.string.error_invalid_email));
            focusView = mUserNameView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            doLogin();

        }
    }
    private void doLogin(){

        mSharedPreferences.getBoolean("test",false);
        Log.d("test","test");

        RoadBullService roadBullService =  mRetrofit.create(RoadBullService.class);
        RoadBullUser user = new RoadBullUser();
        user.setUserName(mUserNameView.getText().toString());
        user.setPassword(mPasswordView.getText().toString());
        roadBullService.login(user).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    getUserProfile(response.body());
                }else{
                    getUserProfile(null);
                }


            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                t.printStackTrace();
                getUserProfile(null);
            }
        });

    }
    private void getUserProfile(LoginResponse loginResponse){
        if(loginResponse == null){
            showProgress(false);
            mPasswordView.setError(getString(R.string.error_unknown_error));
            mPasswordView.requestFocus();
            return;
        }

        if (loginResponse.getCode() != 0) {
            showProgress(false);
            mPasswordView.setError(loginResponse.getMessage().replaceAll(" \\| ", "\n"));
            mPasswordView.requestFocus();
            return;
        }
        final String token = "Bearer " +loginResponse.getToken();

        RoadBullService roadBullService =  mRetrofit.create(RoadBullService.class);
        roadBullService.getUserProfileByToken(token).enqueue(new Callback<List<ProfileResponse>>() {
            @Override
            public void onResponse(Call<List<ProfileResponse>> call, Response<List<ProfileResponse>> response) {

                if(response.isSuccessful()){
                    mPrefManager.setToken(token);
                    saveUserInfo(response.body());
                }else{
                   saveUserInfo(null);
                }
            }

            @Override
            public void onFailure(Call<List<ProfileResponse>> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }

    private void saveUserInfo(List<ProfileResponse> data){
        if(data == null || data.isEmpty()){
            showProgress(false);
            mPasswordView.setError(getString(R.string.error_unknown_error));
            mPasswordView.requestFocus();
            return;
        }
        boolean found = false;
        RoadBullUser userProfile = null;
        for(ProfileResponse profileResponse : data){

            if(profileResponse.getProfile()!= null && profileResponse.getProfile().isDriver()){
                found = true;
                userProfile = profileResponse.getProfile();
                break;
            }
        }

        if(!found ){
            showProgress(false);
            mUserNameView.setError(getString(R.string.error_invalid_permissions));
            mUserNameView.requestFocus();
            return;
        }
        if(mRememberMe.isChecked()){
            mPrefManager.setRemember(true);
            mPrefManager.setPassword(mPasswordView.getText().toString());
        }else{
            mPrefManager.setRemember(false);
            mPrefManager.setPassword("");
        }
        mPrefManager.setUserName(mUserNameView.getText().toString());
        mPrefManager.setUserId(String.valueOf(userProfile.getId()));
        mPrefManager.setEmail(userProfile.getEmail());
        mPrefManager.setAddress(userProfile.getAddress());
        mPrefManager.setCountry(userProfile.getCountry());
        mPrefManager.setFullName(userProfile.getName());
        mPrefManager.setPhoto(userProfile.getPhoto());
        mPrefManager.setDrivingLicense(userProfile.getDrivingLicense());
        mPrefManager.setIcNumber(userProfile.getICNumber());
        mPrefManager.setStaffNum(userProfile.getStaffNumber());
        mPrefManager.setVehicleNum(userProfile.getVehicleNumber());
        mPrefManager.setVehicleType(userProfile.getVehicleType());

        showProgress(false);
        //
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    private boolean isUsernameValid(String userName) {
        //TODO: Replace this with your own logic
        return userName.length() > 0;
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.INVISIBLE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.INVISIBLE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
            mLoginFormView.setVisibility(show ? View.INVISIBLE : View.VISIBLE);
        }
    }




    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if ((v.getId() == R.id.username || v.getId() == R.id.password) && !hasFocus) {

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

        }
    }




}

