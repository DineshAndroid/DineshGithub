package practice.com.myapplication.webapis;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import practice.com.myapplication.R;
import practice.com.myapplication.webapis.retrofit.RetrofitSample;

/**
 * Created by Dinesh.Sengar on 24-08-2016.
 */
public class WebapiSample extends AppCompatActivity {
    private  TextView tv_data;

    //for retrofit Example

    private final static String TAG = "WebapiSample";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webapi);
        // tv_data=(TextView)findViewById(R.id.tv_data);
    }


    public  void getRetrofit(View view)
    {
        Intent intentPost=new Intent(this, RetrofitSample.class);
        startActivity(intentPost);
    }

    public  void  basicHttp(View view)
    {
        new GetAndPostAsycTask().execute();
    }
    public  void  postAPI(View view)
    {
        new PostAsycTask().execute();
    }

    public  void  getVolley(View view)
    {

        String url="http://maps.google.com/maps/api/geocode/json?address=A-sector60,noida,india&sensor=false;";

        JsonObjectRequest  mJsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Toast.makeText(WebapiSample.this,"Response"+response.toString(),Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(WebapiSample.this,"Response"+error.toString(),Toast.LENGTH_LONG).show();

            }
        });

        Volley.newRequestQueue(this).add(mJsonObjectRequest);
    }


    public  void postVolley(View view)
    {
        String url="http://172.18.81.169:88/vmdservice.svc/Login";
        JSONObject obj=new JSONObject();
        try {
            obj.put("AppVersion","2");
            obj.put("IMEINumber","testvm002123456");
            obj.put("MobilePin","4ACEBEF29D98E2B58085D7481C92130B33D5DF6B");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest  jsonrequest=new JsonObjectRequest(Request.Method.POST, url, obj, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Toast.makeText(WebapiSample.this,"Response  post"+response.toString(),Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(WebapiSample.this,"Response  post"+error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        Volley.newRequestQueue(this).add(jsonrequest);
    }


    public class GetAndPostAsycTask extends AsyncTask<Integer,Void,JSONObject> {
        ProgressDialog mProgressbar;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressbar=new ProgressDialog(WebapiSample.this);
            mProgressbar.setTitle("Wait...");
            mProgressbar.setCancelable(false);
            mProgressbar.show();
        }

        @Override
        protected JSONObject doInBackground(Integer... voids) {

            StringBuilder responseStrBuilder=new StringBuilder();
            JSONObject obj=null;
            HttpURLConnection connection=null;
            try {
                URL url=new URL("http://maps.google.com/maps/api/geocode/json?address=A-sector60,noida,india&sensor=false;");
                //URL url=new URL("http://ec2-52-1-133-240.compute-1.amazonaws.com/PROJECTS/MICOLUMBIA/trunk/api_v2/version_v2/likeDislikePost");
                connection=(HttpURLConnection)url.openConnection();
                connection.setRequestMethod("GET");
                //for post api
                connection.setDoInput(true);
              /*  String urlParam="action=flag&api_key=okk00s48w84cggo0kc4wkk8sk0o4gwkwk88wc8g8&entityID=160&flagname=like_dislike&language=&timezone=Asia/Kolkata&userid=696";
                DataOutputStream  mDataOutputStream=new DataOutputStream(connection.getOutputStream());
                mDataOutputStream.writeBytes(urlParam);
                mDataOutputStream.flush();
                mDataOutputStream.close();*/
                // getting response

                InputStream mInputStream=connection.getInputStream();
                BufferedReader mBufferedReader=new BufferedReader(new InputStreamReader(mInputStream));
                String line="";

                while ((line=mBufferedReader.readLine())!=null)
                {
                    responseStrBuilder.append(line);
                }
                mInputStream.close();

                obj= new JSONObject(responseStrBuilder.toString());

            } catch (Exception e) {
                e.printStackTrace();

            }finally {
                connection.disconnect();
            }
            return obj ;
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            super.onPostExecute(jsonObject);
            mProgressbar.dismiss();
            Toast.makeText(WebapiSample.this,"Response"+jsonObject.toString(),Toast.LENGTH_LONG).show();


            // tv_data.setText(jsonObject.toString());
        }
    }

    public class PostAsycTask extends AsyncTask<Integer,Void,JSONObject> {
        ProgressDialog mProgressbar;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressbar=new ProgressDialog(WebapiSample.this);
            mProgressbar.setTitle("Wait...");
            mProgressbar.setCancelable(false);
            mProgressbar.show();
        }

        @Override
        protected JSONObject doInBackground(Integer... voids) {

            StringBuilder responseStrBuilder=new StringBuilder();
            JSONObject obj=null;
            HttpURLConnection connection=null;
            try {
                URL url=new URL("http://ec2-52-1-133-240.compute-1.amazonaws.com/PROJECTS/MICOLUMBIA/trunk/api_v2/version_v2/likeDislikePost");
                //URL url=new URL("http://ec2-52-1-133-240.compute-1.amazonaws.com/PROJECTS/MICOLUMBIA/trunk/api_v2/version_v2/likeDislikePost");
                connection=(HttpURLConnection)url.openConnection();
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(30000);

                //for post api
                connection.setDoInput(true);
                String urlParam="action=flag&api_key=okk00s48w84cggo0kc4wkk8sk0o4gwkwk88wc8g8&entityID=160&flagname=like_dislike&language=&timezone=Asia/Kolkata&userid=696";
                DataOutputStream  mDataOutputStream=new DataOutputStream(connection.getOutputStream());
                mDataOutputStream.writeBytes(urlParam);
                mDataOutputStream.flush();
                mDataOutputStream.close();
                // getting response

                InputStream mInputStream=connection.getInputStream();
                BufferedReader mBufferedReader=new BufferedReader(new InputStreamReader(mInputStream));
                String line="";

                while ((line=mBufferedReader.readLine())!=null)
                {
                    responseStrBuilder.append(line);
                }
                mInputStream.close();

                obj= new JSONObject(responseStrBuilder.toString());

            } catch (Exception e) {
                e.printStackTrace();

            }finally {
                connection.disconnect();
            }
            return obj ;
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            super.onPostExecute(jsonObject);
            mProgressbar.dismiss();
            // tv_data.setText(jsonObject.toString());
            Toast.makeText(WebapiSample.this,"Response"+jsonObject.toString(),Toast.LENGTH_LONG).show();
        }
    }


}
