package com.akadko.lex.Models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by akadko on 01.07.2016.
 */
public class Phase {

    private int id;
    private String name;
    private Instance instance;

    public Phase(int id, String name, Instance instance) {
        this.id = id;
        this.name = name;
        this.instance = instance;
    }

    public Phase(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Phase() {
    }

    public static Phase parseJSON(JSONObject json) throws JSONException {
        int id = json.getInt("id");
        String name = json.getString("name");

        if (json.has("instance")) {
            Instance instance = Instance.parseJSON(json.getJSONObject("instance"));
            return new Phase(id, name, instance);
        } else return new Phase (id, name);
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

    public Instance getInstance() {
        return instance;
    }

    public void setInstances(Instance instance) {
        this.instance = instance;
    }
}
