package practice.com.myapplication.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import org.json.JSONObject;

import java.util.Arrays;

import practice.com.myapplication.R;

/**
 * Created by dinesh.sengar on 02-09-2016.
 */
public class FacebookSampleActivity extends AppCompatActivity {
    private CallbackManager  mcCallbackManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb);
    }

    public  void loginWithFB(View view)
    {
        mcCallbackManager= CallbackManager.Factory.create();
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile","email"));
        LoginManager.getInstance().registerCallback(mcCallbackManager, new FacebookCallback<LoginResult>() {
           @Override
           public void onSuccess(LoginResult loginResult) {

               if(loginResult.getAccessToken()!=null)
               {
                   GraphRequest mGraphRequest=GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                       @Override
                       public void onCompleted(JSONObject object, GraphResponse response) {

                           Toast.makeText(FacebookSampleActivity.this, "facebook data"+object.toString(), Toast.LENGTH_SHORT).show();

                       }
                   });
                   Bundle param=new Bundle();
                   param.putString("fields", "id,name,first_name,last_name,email");
                   mGraphRequest.setParameters(param);
                   mGraphRequest.executeAsync();
               }
           }

           @Override
           public void onCancel() {
               Toast.makeText(FacebookSampleActivity.this, "FB cancel", Toast.LENGTH_SHORT).show();

           }

           @Override
           public void onError(FacebookException error) {
               Toast.makeText(FacebookSampleActivity.this, "cancel"+error.getMessage(), Toast.LENGTH_SHORT).show();

           }
       });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mcCallbackManager.onActivityResult(requestCode,resultCode,data);
    }
}
