package com.camelr.bilal.camelrecommerceproject.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.camelr.bilal.camelrecommerceproject.Data.AtmRecyclerViewAdapter;
import com.camelr.bilal.camelrecommerceproject.Models.ATM;
import com.camelr.bilal.camelrecommerceproject.R;
import com.camelr.bilal.camelrecommerceproject.Util.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ShowATMs extends Fragment {

    private RecyclerView atmView;

    private AtmRecyclerViewAdapter atmRecyclerViewAdapter;

    private RequestQueue queue;

    // TODO: NEED TO CREATE A VIEW THAT WILL INFLATE CORRECT LAYOUT HERE

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Is this line needed?
        // super.onCreateView(inflater, container, savedInstanceState);

        View rootView = inflater.inflate(R.layout.atm_view, container, false);
        atmView = rootView.findViewById(R.id.atmRecyclerView);
        atmView.setHasFixedSize(true);
        atmView.setLayoutManager(new LinearLayoutManager(getContext()));

        final List<ATM> atmList = new ArrayList<>();

        queue = Volley.newRequestQueue(getContext());

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Constants.atmURL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {

                            for (int i = 0; i < response.length(); i++) {

                                JSONObject atmObj = response.getJSONObject(i);

                                ATM atm = new ATM();

                                atm.setAtmId(atmObj.getString("atmid"));
                                atm.setTitle(atmObj.getString("title"));
                                atm.setAddress(atmObj.getString("address"));
                                atm.setType(atmObj.getString("type"));
                                atm.setLat(atmObj.getDouble("lat"));
                                atm.setLon(atmObj.getDouble("lon"));
                                atm.setOnlineStatus(atmObj.getString("onlineStatus"));

                                atmList.add(atm);

                                // Log.d("ATM Statuses", atmList.get(i).getOnlineStatus());

                            }

                        atmRecyclerViewAdapter = new AtmRecyclerViewAdapter
                                (getContext(), atmList);
                        atmView.setAdapter(atmRecyclerViewAdapter);
                        atmRecyclerViewAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {

                            e.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();

            }
        });

        queue.add(jsonArrayRequest);

        return rootView;

    }

}
