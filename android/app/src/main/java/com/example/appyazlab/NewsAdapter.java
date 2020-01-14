package com.example.appyazlab;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<NewsDemo> {

    private final Activity context;
    private final ArrayList<NewsDemo>  list;

    public NewsAdapter(Activity context,ArrayList<NewsDemo> list) {
        super(context, R.layout.row_list, list);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.list = list;


    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.row_list, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
        TextView categoryText = (TextView) rowView.findViewById(R.id.category);

        titleText.setText(list.get(position).getTitle());
        imageView.setImageResource(list.get(position).getImage());
        categoryText.setText(list.get(position).getCategory());

        return rowView;

    };
}
