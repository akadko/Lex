package com.akadko.lex;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akadko.lex.Models.Law;
import com.akadko.lex.Models.Result;
import com.akadko.lex.Models.Subject;
import com.akadko.lex.Requests.SearchRequest;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akadko on 02.07.2016.
 */
public class MainFragment extends Fragment {
    final List<Law> laws = new ArrayList<>();
    final Adapter adapter = new Adapter(laws);
    RecyclerView.LayoutManager lm;
    RecyclerView rv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        rv = (RecyclerView) v.findViewById(R.id.content_recyclerview);
        lm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(lm);

        SearchRequest req = new SearchRequest(getContext());
        req.setStatus(SearchRequest.Status.PODPIS_PRESIDENT)
                .setDeputy(99100142);

        StringRequest request = new StringRequest(StringRequest.Method.GET, req.getUrl(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Response", response);
                        try {
                            Result result = Result.parseJSON(new JSONObject(response));
                            laws.addAll(result.getLaws());
                            Adapter adapter1 = new Adapter(laws);
                            rv.setAdapter(adapter1);
                            Log.d("Adapter", adapter1.getItemCount() + "");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(request);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
