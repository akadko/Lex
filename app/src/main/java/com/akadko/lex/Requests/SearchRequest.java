package com.akadko.lex.Requests;

import android.content.Context;

import com.akadko.lex.R;

/**
 * Created by akadko on 02.07.2016.
 */
public class SearchRequest {

    String url;
    String app_key = "?app_token=app3327c6789e2629ef2d8e27af4387fb58862e6a50";
    String method_name = "/search.json";

    public SearchRequest(Context context) {
        this.url = context.getResources().getString(R.string.url_api_key)
                + method_name + app_key;
    }

    public String getUrl() {
        return url;
    }

    public SearchRequest setLawType(int lawType) {
        url = url + "&law_type=" + lawType;
        return this;
    }

    public SearchRequest setStatus(int status) {
        url = url + "&status=" + status;
        return this;
    }

    public SearchRequest setTopic(int topicId) {
        url = url + "&topic=" + topicId;
        return this;
    }

    public SearchRequest setName(String name) {
        url = url + "&name=" + name;
        return this;
    }

    public SearchRequest setProjectNumber(String number){
        url = url + "&number=" + number;
        return this;
    }

    public SearchRequest setRegStart(String regStartDate) {
        url = url + "&registration_start=" + regStartDate;
        return this;
    }

    public SearchRequest setRegEnd(String regEndDate) {
        url = url + "&registration_end=" + regEndDate;
        return this;
    }

    public SearchRequest setDocNumber(String number) {
        url = url + "&document_number=" + number;
        return this;
    }

    public SearchRequest setClassLaw(int classLawId) {
        url = url + "&class=" + classLawId;
        return this;
    }

    public SearchRequest setFedSubject(int fedSubjectId) {
        url = url + "&federal_subject=" + fedSubjectId;
        return this;
    }

    public SearchRequest setRegionalSubject(int regionalSubjectId) {
        url = url + "&regional_subject=" + regionalSubjectId;
        return this;
    }

    public SearchRequest setDeputy(int deputyId) {
        url = url + "&deputy=" + deputyId;
        return this;
    }

    public SearchRequest setRespCommittee (int committeeId) {
        url = url + "&responsible_committee=" + committeeId;
        return this;
    }

    public SearchRequest setProfileCommittee (int committeeId) {
        url = url + "&profile_committee=" + committeeId;
        return this;
    }

    public SearchRequest setSoexecCommittee (int committeeId) {
        url = url + "&soexecutor_committee=" + committeeId;
        return this;
    }

    public SearchRequest setSearchMode(int id) {
        url = url + "&search_mode=" + id;
        return this;
    }

    public SearchRequest setEventStart(String date) {
        if (url.contains("search_mode")) {
        url = url + "&event_start=" + date;
            return this;
        } else return this;
    }

    public SearchRequest setEventEnd(String date) {
        if (url.contains("search_mode")) {
            url = url + "&event_end=" + date;
            return this;
        } else return this;
    }

    public SearchRequest setStage(int stageId) {
        if (url.contains("search_mode")) {
            url = url + "&stage=" + stageId;
            return this;
        } else return this;
    }

    public SearchRequest setInstance(int instanceId) {
        if (url.contains("search_mode")) {
            url = url + "&instance=" + instanceId;
            return this;
        } else return this;
    }

    public SearchRequest setPhase(int phaseId) {
        if (url.contains("search_mode")) {
            url = url + "&phase=" + phaseId;
            return this;
        } else return this;
    }

    public SearchRequest setPage(int page){
        url = url + "&page=" + page;
        return this;
    }

    public SearchRequest setLimit(int limit) {
        url = url + "&limit=" + limit;
        return this;
    }

    public SearchRequest setSortType(String sortType) {
        url = url + "&sort=" + sortType;
        return this;
    }

    public class LawType {
        public static final int FZ = 38;
        public static final int FKZ = 39;
        public static final int CONSTITUTION = 41;
    }

    public class Status {
        public static final int VNESENNYE_V_GD = 1;
        public static final int RASSMOTRENIE_V_GD = 2;
        public static final int PRIMER_PROGRAM = 3;
        public static final int PROGRAM_COMMITTEE = 4;
        public static final int VNESENNYE_V_GD_POMIMO_PROGRAMM = 5;
        public static final int RASSMOTRENIE_ZAVERSHENO = 6;
        public static final int PODPIS_PRESIDENT = 7;
        public static final int OTKLONEN_V_GD = 8;
        public static final int OTOZVANNYE = 9;
        public static final int ZAVERSHENO_PO_PROCHIM = 99;
    }

    public class SearchMode {
        public static final int All_EVENTS = 1;
        public static final int LAST_EVENT = 2;
        public static final int EXPECTED_EVENT = 3;
    }

    public class SortType {
        public static final String NAME = "name";
        public static final String NUMBER = "number";
        public static final String DATE = "date";
        public static final String DATE_ASC = "date_asc";
        public static final String LAST_EVENT_DATE = "last_event_date";
        public static final String LAST_EVENT_DATE_ASC = "last_event_date_asc";
        public static final String RESP_COMMITTEE = "responsible_committee";
    }

}
