package com.example.efti.intralot_interview_project.Helpers;

import com.example.efti.intralot_interview_project.models.Repository;

import java.util.ArrayList;
import java.util.List;

public class BufferHelper {

    private static List<Repository> bufferList = new ArrayList<>();

    public BufferHelper(){}

    public static List<Repository> getBufferList()
    {
        return bufferList;
    }

    public static void setBufferList(List<Repository> bufferList)
    {
        BufferHelper.bufferList = bufferList;
    }
}
