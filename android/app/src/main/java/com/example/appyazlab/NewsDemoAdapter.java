package com.example.appyazlab;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;

public class NewsDemoAdapter extends RecyclerView.Adapter<NewsDemoAdapter.ViewHolder> {
    ArrayList<NewsDemo> demos = new ArrayList<>();
    LayoutInflater inflater ;
    Context context;

    private onItemClickListener  mListener;



    public interface onItemClickListener{
        void onItemClick(int position);
    }


    public void setOnItemClickListener(onItemClickListener listener){
        mListener = listener;
    }

    public NewsDemoAdapter(ArrayList<NewsDemo> demos, Context context) {
        this.demos = demos;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.row_list,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(v,mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.category.setText(demos.get(i).getCategory());
        viewHolder.title.setText(demos.get(i).getTitle());
        viewHolder.image.setImageResource(demos.get(i).getImage());
        viewHolder.linear.setTag(viewHolder);

    }

    @Override
    public int getItemCount() {
        return demos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView category,title;
        ImageView image;
        LinearLayout linear;
        public ViewHolder(View itemView, final onItemClickListener listener){
            super(itemView);
            category = itemView.findViewById(R.id.category);
            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
