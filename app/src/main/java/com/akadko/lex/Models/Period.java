package com.akadko.lex.Models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akadko on 01.07.2016.
 */
public class Period {

    private int id;
    private String name;
    private String startDate;
    private String endDate;
    private List<Session> sessions;

    public Period(int id, String name, String endDate, String startDate, List<Session> sessions) {
        this.id = id;
        this.name = name;
        this.endDate = endDate;
        this.startDate = startDate;
        this.sessions = sessions;
    }

    public Period() {
    }

    public static Period parseJSON(JSONObject json) throws JSONException {
        int id = json.getInt("id");
        String name = json.getString("name");
        String endDate = json.getString("endDate");
        String startDate = json.getString("startDate");
        List<Session> sessions = new ArrayList<>();

        for (int i = 0; i < json.getJSONArray("sessions").length(); i++) {
            sessions.add(Session.parseJSON(json.getJSONArray("sessions").getJSONObject(i)));
        }

        return new Period(id,name,endDate, startDate, sessions);
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }
}
