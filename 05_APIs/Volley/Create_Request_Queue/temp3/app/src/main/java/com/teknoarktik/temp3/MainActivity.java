package com.teknoarktik.temp3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRequestQueue();

        String url = "https://jsonplaceholder.typicode.com/todos/5";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("JSON",   "onResponse:" + response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("JSON", "Error: " + error );
            }
        });
        jsonObjectRequest.setTag(TAG);
        requestQueue.add(jsonObjectRequest);

    }

    private void setupRequestQueue(){
        Cache cache = new DiskBasedCache(getCacheDir(), 1024*1024);     // 1 MB Capacity
        // Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork( new HurlStack());
        // Instantiate the RequestQueue with the cache and network.
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if( requestQueue != null )
            requestQueue.cancelAll(TAG);
    }
}
