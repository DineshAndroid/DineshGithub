package practice.com.myapplication.webapis.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import practice.com.myapplication.R;
import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by dinesh.sengar on 26-08-2016.
 */


public class RetrofitSample extends AppCompatActivity {

    TextView pressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrifit);

        pressure = (TextView) findViewById(R.id.txt_press);

        String url = "http://ec2-52-1-133-240.compute-1.amazonaws.com/PROJECTS/MICOLUMBIA/trunk/api_v2/version_v2";


        //making object of RestAdapter
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(url).build();

       /* {"action":"flag","api_key":"okk00s48w84cggo0kc4wkk8sk0o4gwkwk88wc8g8",
                "entityID":"160","flagname":"like_dislike"
                ,"language":"","timezone":"Asia/Kolkata","userid":"696"}*/
        //Creating Rest Services
        RetrofitInterface restInterface = adapter.create(RetrofitInterface.class);

        //callng  post data

        restInterface.postData("flag", "okk00s48w84cggo0kc4wkk8sk0o4gwkwk88wc8g8", "160", "like_dislike", "", "Asia/Kolkata", "696", new Callback<Model>() {
            @Override
            public void success(Model model, Response response) {
                pressure.setText("responseCode -  "+model.responseCode+" responseMessage -  "+model.responseMessage+" isPostLiked-  "+model.isPostLiked+" postLikeCount-  "+model.postLikeCount);

            }

            @Override
            public void failure(RetrofitError error) {
                String merror = error.getMessage();
                pressure.setText(merror);
            }
        });
    }


}

