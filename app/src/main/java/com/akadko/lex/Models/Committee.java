package com.akadko.lex.Models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by akadko on 01.07.2016.
 */
public class Committee {

    private int id;
    private String name;
    private boolean isCurrent;
    private String startDate;
    private String stopDate;

    public Committee(int id, String name, boolean isCurrent, String startDate, String stopDate) {
        this.id = id;
        this.name = name;
        this.isCurrent = isCurrent;
        this.startDate = startDate;
        this.stopDate = stopDate;
    }

    public Committee() {
    }

    public static Committee parseJSON(JSONObject json) throws JSONException {
        int id = json.getInt("id");
        String name = json.getString("name");
        boolean isCurrent = json.getBoolean("isCurrent");
        String startDate = json.getString("startDate");
        String stopDate = json.getString("endDate");

        return new Committee(id,name,isCurrent,startDate,stopDate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStopDate() {
        return stopDate;
    }

    public void setStopDate(String stopDate) {
        this.stopDate = stopDate;
    }
}
