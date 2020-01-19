package com.example.efti.intralot_interview_project.Listeners;

import com.example.efti.intralot_interview_project.models.Repository;

import java.util.ArrayList;

public interface onVolleySuccess {

    void OnSuccess(ArrayList<Repository> repositories_list);

    void onFail();
}
