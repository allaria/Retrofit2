package com.retrofit2.android.model.callback;

import com.retrofit2.android.model.Flower;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by alaria on 21/04/2016.
 */
public interface FlowerService {

    //https://gist.githubusercontent.com/allaria/3aa4dbd8cc9aa3fb2040100f081e49eb/raw/ea5134b1fc2f29b37f98d560ece02e869e80c9d7/flowers.json

    //@GET("/feeds/flowers.json")
    @GET("/allaria/3aa4dbd8cc9aa3fb2040100f081e49eb/raw/ea5134b1fc2f29b37f98d560ece02e869e80c9d7/flowers.json")
    Call<List<Flower>> getAllFlowers();
}
