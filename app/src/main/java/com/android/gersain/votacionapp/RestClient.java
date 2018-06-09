package com.android.gersain.votacionapp;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by Gersain on 09/06/2018.
 */

public interface RestClient {
    @POST("api")
    Call<User> getData();

}
