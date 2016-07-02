package com.akadko.lex.Models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akadko on 01.07.2016.
 */
public class Stage {

    private int id;
    private String name;
    private List<Phase> phases;

    public Stage(int id, String name, List<Phase> phases) {
        this.id = id;
        this.name = name;
        this.phases = phases;
    }

    public Stage(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Stage() {
    }

    public static Stage parseJSON(JSONObject json) throws JSONException {
        int id = json.getInt("id");
        String name = json.getString("name");
        List<Phase> phases = new ArrayList<>();

        if (json.has("phases")) {
            for (int i = 0; i < json.getJSONArray("phases").length(); i++) {
                phases.add(Phase.parseJSON(json.getJSONArray("phases").getJSONObject(i)));
            }
            return new Stage(id, name, phases);
        } else return new Stage (id, name);
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

    public List<Phase> getPhases() {
        return phases;
    }

    public void setPhases(List<Phase> phases) {
        this.phases = phases;
    }
}
