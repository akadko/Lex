package com.akadko.lex.Models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akadko on 01.07.2016.
 */
public class Result {

    private int count;
    private int page;
    private String wording;
    private List<Law> laws;

    public Result(int count, int page, String wording, List<Law> laws) {
        this.count = count;
        this.page = page;
        this.wording = wording;
        this.laws = laws;
    }

    public Result() {
    }

    public static Result parseJSON(JSONObject json) throws JSONException {
        int count = json.getInt("count");
        int page = json.getInt("page");
        String wording = json.getString("wording");
        List<Law> laws = new ArrayList<>();

        for (int i = 0; i < json.getJSONArray("laws").length(); i++) {
            laws.add(Law.parseJSON(json.getJSONArray("laws").getJSONObject(i)));
        }

        return new Result(count, page, wording, laws);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    public List<Law> getLaws() {
        return laws;
    }

    public void setLaws(List<Law> laws) {
        this.laws = laws;
    }
}
