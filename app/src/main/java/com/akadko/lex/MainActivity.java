package com.akadko.lex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.akadko.lex.Models.ClassLaw;
import com.akadko.lex.Models.Result;
import com.akadko.lex.Requests.SearchRequest;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue queue = Volley.newRequestQueue(this);
        String api_url = getResources().getString(R.string.url);
        String api_key = getResources().getString(R.string.api_key);
        String app_key = getResources().getString(R.string.app_key);
        SearchRequest searchRequest = new SearchRequest(this)
                .setLawType(SearchRequest.LawType.FKZ)
                .setStatus(SearchRequest.Status.VNESENNYE_V_GD);

        StringRequest request = new StringRequest(Request.Method.GET, searchRequest.getUrl(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("JSON", response);
                        try {
                            Result res = Result.parseJSON(new JSONObject(response));
                            String oldStr = res.getWording() + " " + res.getLaws().get(2).getName();
                            Log.d("Result", URLDecoder.decode(URLEncoder.encode(oldStr, "iso8859-1"),"UTF-8"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error: ", error.getLocalizedMessage());
            }
        });

        queue.add(request);
    }
}
