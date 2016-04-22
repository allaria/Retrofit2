package com.retrofit2.android.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.retrofit2.android.R;
import com.retrofit2.android.model.Flower;
import com.retrofit2.android.model.adapter.FlowerAdapter;
import com.retrofit2.android.controller.RestManager;
import com.retrofit2.android.model.helper.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements FlowerAdapter.FlowerClickListener {

    private RecyclerView mRecyclerView;
    private RestManager mManager;
    private FlowerAdapter mFlowerAdapter;
    private Button mReload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configViews();

        mManager = new RestManager();
        Call<List<Flower>> listCall = mManager.getFlowerService().getAllFlowers();
        listCall.enqueue(new Callback<List<Flower>>() {
            @Override
            public void onResponse(Call<List<Flower>> call, Response<List<Flower>> response) {

                if (response.isSuccessful()) {
                    List<Flower> flowerList = response.body();

                    for (int i=0; i<flowerList.size(); i++){
                        Flower flower = flowerList.get(i);
                        mFlowerAdapter.addFlower(flower);
                    }
                }else{
                    int sc = response.code();
                    switch (sc){
                        case 400:
                            Log.e("Error 400", "Bad Request");
                            break;
                        case 404:
                            Log.e("Error 404", "Not Found");
                            break;
                        default:
                            Log.e("Error", "Generic Error");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Flower>> call, Throwable t) {

            }
        });
    }

    private void configViews() {
        mReload = (Button) findViewById(R.id.reload);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        mFlowerAdapter = new FlowerAdapter(this);

        mRecyclerView.setAdapter(mFlowerAdapter);
    }

    @Override
    public void onClick(int position) {
        Flower selectedFlower = mFlowerAdapter.getSelectedFlower(position);
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(Constants.REFERENCE.FLOWER, selectedFlower);
        startActivity(intent);
    }
}
