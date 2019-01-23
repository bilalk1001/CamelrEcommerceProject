package com.camelr.bilal.camelrecommerceproject.Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.camelr.bilal.camelrecommerceproject.Data.CartRecyclerViewAdapter;
import com.camelr.bilal.camelrecommerceproject.Models.Item;
import com.camelr.bilal.camelrecommerceproject.Util.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class ShowItems extends Fragment {

    private CartRecyclerViewAdapter cartRecyclerViewAdapter;

    private Context context;

    private List<Item> itemList;

    private RecyclerView cartView;

    JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Constants.baseURL,
            new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    // 'JSONArray response' is the array shown on the URL page

                    try {

/*
                             Starting this loop at i = 1 because we want to exclude the first object
                             in the array; it is an example with no actual product listed
*/
                        for (int i = 1; i < response.length(); i++) {

                            JSONObject itemObj = response.getJSONObject(i);

                            Item item = new Item();

                            item.setTitle(itemObj.getString("title"));
                            item.setDescription(itemObj.getString("description"));
                            item.setPrice(itemObj.getInt("price"));
                            item.setQuantity(itemObj.getInt("quantity"));
                            item.setSku(itemObj.getString("sku"));

                            if (itemObj.isNull("exchangepolicy")) {

                                item.setExchangePolicy("N/A");

                            } else {

                                item.setExchangePolicy(itemObj.getString("exchangepolicy"));

                            }



                            if (itemObj.isNull("returnpolicy")) {

                                item.setReturnPolicy("N/A");

                            } else {

                                item.setReturnPolicy(itemObj.getString("returnpolicy"));

                            }



                            if (itemObj.isNull("internationalcharges")) {

                                item.setIntlChrg("None");

                            } else {

                                item.setIntlChrg(itemObj.getString("internationalcharges"));

                            }



                            if (itemObj.isNull("domesticcharges")) {

                                item.setDomesticChrg("None");

                            } else {

                                item.setDomesticChrg(itemObj.getString("domesticcharges"));

                            }

                            // Testing output of above JSON calls. So far so good!

                            itemList.add(item);

                        }

/*
                             The method call to initialize a RecyclerView Adapter inside the
                             MainActivity Context and passed the newly created ArrayList itemList
*/
/*
                        cartRecyclerViewAdapter = new CartRecyclerViewAdapter(MainActivity.this ,
                                itemList);
*/
                        cartView.setAdapter(cartRecyclerViewAdapter);
                        cartRecyclerViewAdapter.notifyDataSetChanged();

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

}
