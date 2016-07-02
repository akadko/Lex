package com.akadko.lex.Models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by akadko on 01.07.2016.
 */
public class Law {

    private int id;
    private String number;
    private String name;
    private String comments;
    private String intrDate;
    private String url;
    private String transcriptUrl;
    private LastEvent lastEvent;
    private Subject subject;
    private Committees committees;
    private TypeLaw type;

    public Law(int id, String number, String name, String comments, String intrDate, String url, String transcriptUrl, LastEvent lastEvent, Subject subject, Committees committees, TypeLaw type) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.comments = comments;
        this.intrDate = intrDate;
        this.url = url;
        this.transcriptUrl = transcriptUrl;
        this.lastEvent = lastEvent;
        this.subject = subject;
        this.committees = committees;
        this.type = type;
    }

    public Law() {
    }

    public int getId() {
        return id;
    }

    public static Law parseJSON(JSONObject json) throws JSONException {
        int id = json.getInt("id");
        String number = json.getString("number");
        String name = json.getString("name");
        String comments = json.getString("comments");
        String intrDate = json.getString("introductionDate");
        String url = json.getString("url");
        String trUrl = json.getString("transcriptUrl");
        LastEvent lastEvent = LastEvent.parseJSON(json.getJSONObject("lastEvent"));
        Subject subject = Subject.parseJSON(json.getJSONObject("subject"));
        Committees committees = Committees.parseJSON(json.getJSONObject("committees"));
        TypeLaw typeLaw = TypeLaw.parseJSON(json.getJSONObject("type"));

        return new Law(id, number, name, comments, intrDate, url, trUrl, lastEvent, subject, committees, typeLaw);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getIntrDate() {
        return intrDate;
    }

    public void setIntrDate(String intrDate) {
        this.intrDate = intrDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTranscriptUrl() {
        return transcriptUrl;
    }

    public void setTranscriptUrl(String transcriptUrl) {
        this.transcriptUrl = transcriptUrl;
    }

    public LastEvent getLastEvent() {
        return lastEvent;
    }

    public void setLastEvent(LastEvent lastEvent) {
        this.lastEvent = lastEvent;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Committees getCommittees() {
        return committees;
    }

    public void setCommittees(Committees committees) {
        this.committees = committees;
    }

    public TypeLaw getType() {
        return type;
    }

    public void setType(TypeLaw type) {
        this.type = type;
    }
}
