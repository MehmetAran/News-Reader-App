package com.example.appyazlab;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
     //RecyclerView recyclerView;
    TimerTask scanTask;
    final Handler handler = new Handler();
    Timer t = new Timer();
    private News news;
    NewsAdapter newsAdapter;
     private ArrayList<NewsDemo> demos;
     private ListView listView;
     //ArrayList<NewsDemo> newsDemos = new ArrayList<NewsDemo>();
     Service service;
     public static List<News> newsList = new ArrayList<News>();
    public static List<News> newsList2 = new ArrayList<News>();
    private AlarmManager alarmManager;
    private PendingIntent alarmIntent;
    //Context context  = this;
    public static int listPosition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        service = RetrofitClient.getClient().create(Service.class);

        newsList = allList();
        // Bildirim icin
        doWifiScan();




    }
    public List<News> allList() {
        service.newsListCall().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                newsList = response.body();

                EditText theFilter = (EditText)findViewById(R.id.searchFilter);
                Button theFilterButton = (Button) findViewById(R.id.searchButton);
                 demos = new ArrayList<>();
                for(News n : newsList){
                    if(theFilter.getText().toString().equals("")){
                        demos.add(new NewsDemo(n.getCategory(),n.title,0,n.getNewsId()));
                        newsList2.add(n);
                    }
                    else if(theFilter.getText().toString().equals(n.getCategory()) ){
                        demos.add(new NewsDemo(n.getCategory(),n.title,0,n.getNewsId()));
                        newsList2.add(n);

                    }



                }
                theFilterButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        allList();
                        demos.removeAll(demos);
                        newsList2.removeAll(newsList2);
                    }
                });


                listView = (ListView) findViewById(R.id.listView);
                newsAdapter = new NewsAdapter(MainActivity.this,demos);
                listView.setAdapter(newsAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        listPosition = position;
                        Intent intent = new Intent(MainActivity.this,ReadActivity.class);
                        startActivity(intent);
                    }
                });



                    //             recyclerView = findViewById(R.id.recycler);
         //           LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
           //         linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
             //       linearLayoutManager.scrollToPosition(0);
               //     recyclerView.setLayoutManager(linearLayoutManager);
                 //   recyclerView.setHasFixedSize(true);
                   // NewsDemoAdapter newsDemoAdapter = new NewsDemoAdapter(demos,context);
                    //recyclerView.setAdapter(newsDemoAdapter);



            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                System.out.println("fail" + t.getMessage());
            }
        });
         return newsList2;
    }
    public void doWifiScan(){

        scanTask = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {



                        Intent intent = new Intent(MainActivity.this, MyForeGroundService.class);
                        intent.setAction(MyForeGroundService.ACTION_STOP_FOREGROUND_SERVICE);
                        startService(intent);
                        Log.d("TIMER", "Timer set off");
                    }
                });
            }};


        t.schedule(scanTask, 300, 3000);

    }

}
