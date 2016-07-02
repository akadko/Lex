package com.akadko.lex.Models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akadko on 01.07.2016.
 */
public class Committees {

    private Committee responsible;
    private List<Committee> profile;
    private List<Committee> soexecutor;

    public Committees(Committee responsible, List<Committee> profile, List<Committee> soexecutor) {
        this.responsible = responsible;
        this.profile = profile;
        this.soexecutor = soexecutor;
    }

    public Committees() {
    }

    public static Committees parseJSON(JSONObject json) throws JSONException {
        Committee responsible = new Committee();
        List<Committee> profile = new ArrayList<>();
        List<Committee> soexecutor = new ArrayList<>();

        if (!json.isNull("responsible"))
            responsible = Committee.parseJSON(json.getJSONObject("responsible"));
        if (!json.isNull("profile"))
            for (int i = 0; i < json.getJSONArray("profile").length(); i++) {
                profile.add(Committee.parseJSON(json.getJSONArray("profile").getJSONObject(i)));
            }
        if (!json.isNull("soexecutor"))
        for (int i = 0; i < json.getJSONArray("soexecutor").length(); i++) {
            profile.add(Committee.parseJSON(json.getJSONArray("soexecutor").getJSONObject(i)));
        }

        return new Committees(responsible, profile, soexecutor);
    }

    public Committee getResponsible() {
        return responsible;
    }

    public void setResponsible(Committee responsible) {
        this.responsible = responsible;
    }

    public List<Committee> getProfile() {
        return profile;
    }

    public void setProfile(List<Committee> profile) {
        this.profile = profile;
    }

    public List<Committee> getSoexecutor() {
        return soexecutor;
    }

    public void setSoexecutor(List<Committee> soexecutor) {
        this.soexecutor = soexecutor;
    }
}
