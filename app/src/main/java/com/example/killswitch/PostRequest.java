package com.example.killswitch;
import java.io.IOException;
import android.os.AsyncTask;
import android.provider.MediaStore;

import org.json.JSONObject;

import java.lang.*;

import okhttp3.*;

public class PostRequest extends AsyncTask<Void, Void, Void>
{
    String pass;
    PostRequest(String password) {
        pass = password;
    }

    private OkHttpClient client;
    private Exception exception;

    @Override
    protected void onPreExecute() {
        client = new OkHttpClient();
    }

    @Override
    protected Void doInBackground(Void... voids)
    {
        try{sendPost();}
        catch (Exception e) {
            this.exception = e;
        }
        return null;
    }

    public void sendPost() throws Exception {

        // form parameters
        MediaType text = MediaType.get("text/plain");
        RequestBody body = RequestBody.create(pass, text);
                //.add("password", pass)
                //.build();

        /*RequestBody formBody = new FormBody.Builder()
            .add("password", pass)
                .build();

         */

        /*RequestBody body = new FormBody.Builder()
                .add("password", pass)
                .build();
        */

        //@RequestBody String str = pass;

        Request request = new Request.Builder()
                .url("http://100.35.39.80:8001/test")
                //addHeader("User-Agent", "OkHttp Bot")
                .method("POST", body)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

        // Get response body
        System.out.println(response.body().string());


    }
}
