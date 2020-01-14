package com.example.appyazlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.appyazlab.MainActivity.listPosition;
import static com.example.appyazlab.MainActivity.newsList;
import static com.example.appyazlab.MainActivity.newsList2;

public class ReadActivity extends AppCompatActivity {
    TextView category,title,date,content,view;
    Button like,dislike;
    Service service;
    int  control = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        service = RetrofitClient.getClient().create(Service.class);
        findOneNews(newsList2.get(listPosition).getNewsId());
        newsList2.get(listPosition).setViewOfNumber(newsList2.get(listPosition).getViewOfNumber()+1);
        build();


    }
    public void build(){
        category= (TextView) findViewById(R.id.categoryRead);
        category.setText("Kategori : "+newsList2.get(listPosition).getCategory());

        title= (TextView) findViewById(R.id.titleRead);
        title.setText(newsList2.get(listPosition).getTitle());

        date= (TextView) findViewById(R.id.date);
        date.setText("Tarih : "+newsList2.get(listPosition).getReleaseDate());

        content = (TextView) findViewById(R.id.contentRead);
        content.setText(newsList2.get(listPosition).getContent());

        view = (TextView) findViewById(R.id.viewRead);
        view.setText(newsList2.get(listPosition).getViewOfNumber()+" görüntülenme");

        like = (Button) findViewById(R.id.likeRead);
        like.setText(newsList2.get(listPosition).getLikeOfNumber()+" Beğeni");

        dislike = (Button) findViewById(R.id.dislikeRead);
        dislike.setText(newsList2.get(listPosition).getDislikeOfNumber()+" Beğenmeme");

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (control == 0) {
                    increaseLike(newsList2.get(listPosition).getNewsId());
                    control = newsList2.get(listPosition).getNewsId();
                    newsList2.get(listPosition).setLikeOfNumber(newsList2.get(listPosition).getLikeOfNumber() + 1);
                    like.setText(newsList2.get(listPosition).getLikeOfNumber() + " Beğeni");
                } else if (control == newsList2.get(listPosition).getNewsId()) {
                    decreaseLike(newsList2.get(listPosition).getNewsId());
                    control = 0;
                    newsList2.get(listPosition).setLikeOfNumber(newsList2.get(listPosition).getLikeOfNumber() - 1);
                    like.setText(newsList2.get(listPosition).getLikeOfNumber() + " Beğeni");
                } else if (control == -newsList2.get(listPosition).getNewsId()) {
                    decreaseDislike(newsList2.get(listPosition).getNewsId());
                    increaseLike(newsList2.get(listPosition).getNewsId());
                    control = newsList2.get(listPosition).getNewsId();;
                    newsList2.get(listPosition).setLikeOfNumber(newsList2.get(listPosition).getLikeOfNumber() + 1);
                    newsList2.get(listPosition).setDislikeOfNumber(newsList2.get(listPosition).getDislikeOfNumber() - 1);

                    dislike.setText(newsList2.get(listPosition).getDislikeOfNumber() + " Beğenmeme");
                    like.setText(newsList2.get(listPosition).getLikeOfNumber() + " Beğeni");
                }
            }
        });

        dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (control == 0) {
                    increaseDislike(newsList2.get(listPosition).getNewsId());
                    control = - newsList2.get(listPosition).getNewsId();
                    newsList2.get(listPosition).setDislikeOfNumber(newsList2.get(listPosition).getDislikeOfNumber() + 1);
                    dislike.setText(newsList2.get(listPosition).getDislikeOfNumber() + " Beğenmeme");
                } else if (control == -newsList2.get(listPosition).getNewsId()) {
                    decreaseDislike(newsList2.get(listPosition).getNewsId());
                    control = 0;
                    newsList2.get(listPosition).setDislikeOfNumber(newsList2.get(listPosition).getDislikeOfNumber() -1);
                    dislike.setText(newsList2.get(listPosition).getDislikeOfNumber() + " Beğenmeme");
                } else if (control == newsList2.get(listPosition).getNewsId()) {
                    decreaseLike(newsList2.get(listPosition).getNewsId());
                    increaseDislike(newsList2.get(listPosition).getNewsId());
                    control = -newsList2.get(listPosition).getNewsId();;
                    newsList2.get(listPosition).setLikeOfNumber(newsList2.get(listPosition).getLikeOfNumber() - 1);
                    newsList2.get(listPosition).setDislikeOfNumber(newsList2.get(listPosition).getDislikeOfNumber() + 1);

                    dislike.setText(newsList2.get(listPosition).getDislikeOfNumber() + " Beğenmeme");
                    like.setText(newsList2.get(listPosition).getLikeOfNumber() + " Beğeni");
                }
            }
        });


    }

    public void findOneNews(int id) {
        service.findOneNews(id).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                System.out.println("fail" + t.getMessage());


            }
        });

    }
    public void increaseLike(int id) {
        service.increaseLike(id).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                System.out.println("Like arttı");

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                System.out.println("fail" + t.getMessage());


            }
        });

    }
    public void decreaseLike(int id) {
        service.decreaseLike(id).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                System.out.println("Like azaldı");

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                System.out.println("fail" + t.getMessage());


            }
        });

    }
    public void increaseDislike(int id) {
        service.increaseDislike(id).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                System.out.println("dislike arttı");
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                System.out.println("fail" + t.getMessage());


            }
        });

    }
    public void decreaseDislike(int id) {
        service.decreaseDislike(id).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                System.out.println("dislike azaldı");

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                System.out.println("hatatata" + t.getMessage());


            }
        });

    }


}
