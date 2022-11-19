package com.example.englishvocabularyquiztest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomHolder> {

    Context context;
    String[] title;
    String[] htmlFile;

    public CustomAdapter(Context context, String[] title, String[] htmlfile) {
        this.context = context;
        this.title = title;
        this.htmlFile = htmlfile;
    }

    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.item_list,parent,false);
        return new CustomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder holder, int position) {

        final String htmlfile=htmlFile[position];



        holder.textView.setText(title[position]);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,StudyActivity.class);
                intent.putExtra("file",htmlfile);
                context.startActivity(intent);
                ((CategoryActivity)context).finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class CustomHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        TextView textView;



        public CustomHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout=(LinearLayout) itemView.findViewById(R.id.linear);
            textView=(TextView) itemView.findViewById(R.id.title);
        }
    }


}
