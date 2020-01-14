package com.example.appyazlab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationReceiver extends BroadcastReceiver {
    private Service service;
    List<News> listNews;

    @Override
    public void onReceive(Context context, Intent intent) {
        service = RetrofitClient.getClient().create(Service.class);
        getListSize();
        Bundle pudsBundle = intent.getExtras();
    }
    public void getListSize() {
        service.newsListCall().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                listNews = response.body();
                //if(listNews.size() > MainActivity.newsList.size()){
                    System.out.println("listNews : " + listNews.size() + " newList :  " + MainActivity.newsList.size());
                //}



                }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                System.out.println("fail" + t.getMessage());
            }
        });
    }

}
