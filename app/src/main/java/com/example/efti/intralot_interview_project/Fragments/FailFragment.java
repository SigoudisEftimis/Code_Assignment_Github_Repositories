package com.example.efti.intralot_interview_project.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.efti.intralot_interview_project.R;


public class FailFragment extends Fragment {


    public FailFragment() {
        // Required empty public constructor
    }

    public static FailFragment newInstance()
    {
        return new FailFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fail, container, false);
    }

}
