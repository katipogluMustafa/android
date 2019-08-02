package com.teknoarktik.temp3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue = MyRequestQueue.getInstance(getApplicationContext()).getRequestQueue();

        String url = "https://jsonplaceholder.typicode.com/posts";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                
                int i = 0;
                JSONObject temp;
                try{
                    while( ( temp = response.getJSONObject(i) ) != null )
                        Log.d("JSON", i++ + " " + temp);
                }catch ( Exception e){
                    Log.d("JSON","Exception: " + e);
                }

                // I know it is not okay to use unnecessary try catches, just for practice...
                try {
                    Log.d("JSON", "Titles: ");
                    for (i = 0; i < 100; i++)
                        Log.d("JSON", response.getJSONObject(i).getString("title"));
                }catch (Exception e){
                    Log.d("JSON","Exception: " + e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("JSON", "Error: " + error);
            }
        });

        jsonArrayRequest.setTag(TAG);
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if( requestQueue != null )
            requestQueue.cancelAll(TAG);
    }
}
