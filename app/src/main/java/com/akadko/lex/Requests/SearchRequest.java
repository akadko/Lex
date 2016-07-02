package com.akadko.lex.Requests;

import android.content.Context;

import com.akadko.lex.R;

/**
 * Created by akadko on 02.07.2016.
 */
public class SearchRequest {

    String url;
    String app_key = "?app_token=app3327c6789e2629ef2d8e27af4387fb58862e6a50";

    public SearchRequest(Context context) {
        this.url = context.getResources().getString(R.string.url_api_key)
                + "/search.json" + app_key;
    }

    public String getUrl() {
        return url;
    }

    public SearchRequest setLawType(int lawType) {
        url = url + "&law_type=" + lawType;
        return this;
    }

    public SearchRequest setStatus(int status) {
        url = url + "&status" + status;
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

}
