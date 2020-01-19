package com.example.efti.intralot_interview_project.Factories;

import com.example.efti.intralot_interview_project.Adapters.RepositoryAdapter;
import com.example.efti.intralot_interview_project.Parsers.VolleyParser;

public class Factory {

    public Factory(){}

    public VolleyParser getNewJSONParser()
    {
       return new VolleyParser();
    }

    public RepositoryAdapter getNewRepositoryAdapter()
    {
        return new RepositoryAdapter();
    }

}
