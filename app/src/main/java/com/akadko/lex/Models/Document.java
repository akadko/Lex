package com.akadko.lex.Models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by akadko on 01.07.2016.
 */
public class Document {

    private String name;
    private String type;

    public Document(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Document() {
    }

    public static Document parseJSON(JSONObject json) throws JSONException {
        String name = json.getString("name");
        String type = json.getString("type");

        return new Document(name, type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
