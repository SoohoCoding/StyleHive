package com.codebee.stylehive.util;

import com.google.gson.Gson;

import java.util.Map;

public class Util {
    public static void addPageParam(Map<String,Object> map, int size , int page) {
        int startIndex = (page-1)*size;
        map.put("startLimit", startIndex);
        map.put("sizeLimit", size);
    }
}
