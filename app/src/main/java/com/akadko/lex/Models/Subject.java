package com.akadko.lex.Models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akadko on 01.07.2016.
 */
public class Subject {

    private List<Deputy> deputies;
    private List<Department> departments;

    public Subject(List<Deputy> deputies, List<Department> departments) {
        this.deputies = deputies;
        this.departments = departments;
    }

    public Subject() {
    }

    public static Subject parseJSON(JSONObject json) throws JSONException {
        List<Deputy> deputies = new ArrayList<>();
        List<Department> departments = new ArrayList<>();

        for (int i = 0; i < json.getJSONArray("deputies").length(); i++) {
            deputies.add(Deputy.parseJSON(json.getJSONArray("deputies").getJSONObject(i)));
        }

        for (int i = 0; i < json.getJSONArray("departments").length(); i++) {
            departments.add(Department.parseJSON(json.getJSONArray("departments").getJSONObject(i)));
        }

        return new Subject(deputies, departments);
    }

    public List<Deputy> getDeputies() {
        return deputies;
    }

    public void setDeputies(List<Deputy> deputies) {
        this.deputies = deputies;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
