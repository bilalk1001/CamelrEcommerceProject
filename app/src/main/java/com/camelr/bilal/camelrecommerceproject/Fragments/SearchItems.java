package com.camelr.bilal.camelrecommerceproject.Fragments;

import android.support.v4.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.camelr.bilal.camelrecommerceproject.Util.Constants;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SearchItems extends Fragment {

    public void postItemSearch (final String keyword, final int minPrice, final int maxPrice) {

/*
         JsonArrayRequest is just returning the whole array. Need to find out how to post a request
         body with the three parameters
*/

        /*

        Alternative method construction to allow for search without price range:
        Method signature with no parameters, assign request body params to text values in widgets

         */

        Map<String, Object> params = new HashMap<String, Object>();

        params.put("keyword", keyword);
        params.put("minPrice", minPrice);
        params.put("maxPrice", maxPrice);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, Constants.itemSearchURL,
                new JSONObject(params), new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                /*
                for (int i = 0; i < response.length(); i++) {

                    try {

                        JSONObject itemObj = response.getJSONObject(i);

                        Log.d("Array length", String.valueOf(response.length()));
                        Log.d("Search result", itemObj.getString("title"));

                    } catch (JSONException e) {

                        e.printStackTrace();

                    }

                }
                */

/*
                try {
                    Toast.makeText(MainActivity.this, response.getJSONObject(1).getString
                            ("quantity"), Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
*/

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                /**
                 * TODO: Widget for the search in whatever layout should give a String value to
                 * the values in the params HashMap.
                 */

                Map<String, String> params = new HashMap<String, String>();

                params.put("keyword", keyword);
                params.put("minPrice", String.valueOf(minPrice));
                params.put("maxPrice", String.valueOf(maxPrice));

                return params;
            }
        };

//        queue.add(jsonArrayRequest);

    }

}
