package com.roadbull.driver.models;

/**
 * Created by linhnguyenv1 on 1/24/2017.
 */

public class SettingUrl {
    private String CompanyInfo;
    private String TermsAndConditions;
    private String News;
    private String TypeOfService;
    private String ServiceGuidelines;


    public String getCompanyInfo() {
        return CompanyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        CompanyInfo = companyInfo;
    }

    public String getTermsAndConditions() {
        return TermsAndConditions;
    }

    public void setTermsAndConditions(String termsAndConditions) {
        TermsAndConditions = termsAndConditions;
    }

    public String getNews() {
        return News;
    }

    public void setNews(String news) {
        News = news;
    }

    public String getTypeOfService() {
        return TypeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        TypeOfService = typeOfService;
    }

    public String getServiceGuidelines() {
        return ServiceGuidelines;
    }

    public void setServiceGuidelines(String serviceGuidelines) {
        ServiceGuidelines = serviceGuidelines;
    }
}
