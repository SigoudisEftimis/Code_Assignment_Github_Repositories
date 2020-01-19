package com.example.efti.intralot_interview_project.Parsers;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.efti.intralot_interview_project.Constants.Constants;
import com.example.efti.intralot_interview_project.Listeners.onVolleySuccess;
import com.example.efti.intralot_interview_project.Presenters.LoadingPresenter;
import com.example.efti.intralot_interview_project.models.Repository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.ArrayList;

public class VolleyParser {

    private LoadingPresenter presenter;
    private ArrayList<Repository> repositories_list;

    public VolleyParser(){}

    public void setPresenter(LoadingPresenter presenter) {
        this.presenter = presenter;
    }

    public void fetchData(final onVolleySuccess onVolleySuccess) {

        repositories_list = new ArrayList<>();

        StringRequest request = new StringRequest(Constants.url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Repository[] repository;
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                repository = gson.fromJson(response,Repository[].class);
                for(int i = 0 ; i < repository.length; i++){
                    Repository rep = new Repository();
                    String name = repository[i].getName();
                    String description = repository[i].getDescription();
                    String node_id = repository[i].getNode_id();
                    int id = repository[i].getId();
                    int size = repository[i].getSize();
                    String language = repository[i].getLanguage();
                    boolean has_projects = repository[i].isHas_projects();
                    boolean has_downloads = repository[i].isHas_downloads();
                    boolean has_wiki = repository[i].isHas_wiki();
                    int open_issues = repository[i].getOpen_issues();
                    String default_branch = repository[i].getDefault_branch();
                    int watchers = repository[i].getWatchers();


                    rep.setNode_id(node_id);
                    rep.setId(id);
                    rep.setSize(size);
                    rep.setLanguage(language);
                    rep.setOpen_issues(open_issues);
                    rep.setHas_wiki(has_wiki);
                    rep.setHas_projects(has_projects);
                    rep.setHas_downloads(has_downloads);
                    rep.setWatchers(watchers);
                    rep.setDefault_branch(default_branch);
                    rep.setName(name);
                    rep.setDescription(description);
                    repositories_list.add(rep);
                }
                onVolleySuccess.OnSuccess(repositories_list);


            }
            }, new ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
               VolleyLog.d("", "Error: " + error.getMessage());
               onVolleySuccess.onFail();

           }
       });

        RequestQueue requestQueue = Volley.newRequestQueue(presenter.getFragment().getContext());
        requestQueue.add(request);





    }
}
