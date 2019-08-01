package com.teknoarktik.temp3;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;

/**
 * A key concept is that the RequestQueue must be instantiated with the Application context, not an Activity context.
 * This ensures that the RequestQueue will last for the lifetime of your app,
 * instead of being recreated every time the activity is recreated
 */

public class MyRequestQueue {
    private static MyRequestQueue instance;
    private static Context ctx;

    private RequestQueue requestQueue;

    private MyRequestQueue(Context context){
        ctx = context;
        setupRequestQueue(context);
    }

    private void setupRequestQueue(Context context){
        Cache cache = new DiskBasedCache(context.getCacheDir(), 1024*1024);     // 1 MB Capacity
        // Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork( new HurlStack());
        // Instantiate the RequestQueue with the cache and network.
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();
    }

    public static synchronized MyRequestQueue getInstance(Context context){
        if( instance == null )
            instance = new MyRequestQueue(context);
        return instance;
    }

    public RequestQueue getRequestQueue(){
        if( requestQueue == null )
            //  getApplicationContext() is key, it keeps you from leaking the
            //  Activity or BroadcastReceiver if someone passes one in.
            setupRequestQueue(ctx.getApplicationContext());
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request){
        getRequestQueue().add(request);
    }

}
