package com.example.efti.intralot_interview_project.Presenters;

import android.support.v4.app.Fragment;

import com.example.efti.intralot_interview_project.Factories.Factory;

public class BasePresenter {

    private Fragment fragment;
    private Factory  factory;

    public BasePresenter(Fragment fragment) {
        this.fragment = fragment;
        this.factory = new Factory();
    }

    public Fragment getFragment() {
        return fragment;
    }

    public Factory getFactory() {
        return factory;
    }

}
