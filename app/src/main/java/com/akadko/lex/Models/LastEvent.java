package com.akadko.lex.Models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by akadko on 01.07.2016.
 */
public class LastEvent {

    private Stage stage;
    private Phase phase;
    private String solution;
    private String date;
    private Document document;

    public LastEvent(Stage stage, Phase phase, String solution, String date, Document document) {
        this.stage = stage;
        this.phase = phase;
        this.solution = solution;
        this.date = date;
        this.document = document;
    }

    public LastEvent() {
    }

    public static LastEvent parseJSON(JSONObject json) throws JSONException {
        Stage stage = Stage.parseJSON(json.getJSONObject("stage"));
        Phase phase = Phase.parseJSON(json.getJSONObject("phase"));
        String solution = json.getString("solution");
        String date = json.getString("date");
        Document document = null;
        if (!json.isNull("document")) {
        document = Document.parseJSON(json.getJSONObject("document"));
        }

        return new LastEvent(stage, phase, solution, date, document);
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
