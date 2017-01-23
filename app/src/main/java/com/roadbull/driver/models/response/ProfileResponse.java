package com.roadbull.driver.models.response;

import com.roadbull.driver.models.RoadBullUser;

/**
 * Created by linhnguyenv1 on 1/23/2017.
 */

public class ProfileResponse {
    private String ProfileType;
    private RoadBullUser Profile;

    public String getProfileType() {
        return ProfileType;
    }

    public void setProfileType(String profileType) {
        ProfileType = profileType;
    }

    public RoadBullUser getProfile() {
        return Profile;
    }

    public void setProfile(RoadBullUser profile) {
        Profile = profile;
    }
}
