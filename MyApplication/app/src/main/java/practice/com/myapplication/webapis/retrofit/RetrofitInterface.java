package practice.com.myapplication.webapis.retrofit;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;

/**
 * Created by dinesh.sengar on 26-08-2016.
 */
public interface RetrofitInterface {

        /*@GET("/weather?q=London,uk")
        void getWheatherReport(Callback<Model> cb);*/

    @Headers("Content-Type: application/json")
    @FormUrlEncoded
    @POST("/likeDislikePost")
    void postData(@Field("action") String action,
                  @Field("api_key") String api_key,
                  @Field("entityID") String entityID,
                  @Field("flagname") String flagname,
                  @Field("language") String language,
                  @Field("timezone") String timezone,
                  @Field("userid") String userid,
                  Callback<Model> callback);

    }

