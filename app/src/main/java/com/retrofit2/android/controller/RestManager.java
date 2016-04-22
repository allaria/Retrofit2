package com.retrofit2.android.controller;

import com.retrofit2.android.model.callback.FlowerService;
import com.retrofit2.android.model.helper.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alaria on 21/04/2016.
 */
public class RestManager {

    private FlowerService mFlowerService;

    public FlowerService getFlowerService() {
        if (mFlowerService == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.BASE_URL2)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mFlowerService = retrofit.create(FlowerService.class);
        }
        return mFlowerService;
    }
}
