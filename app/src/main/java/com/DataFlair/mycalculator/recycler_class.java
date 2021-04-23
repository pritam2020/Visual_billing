package com.DataFlair.mycalculator;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class recycler_class extends RecyclerView.Adapter<recycler_class.ViewHolder> {

ArrayList<String> bitmap;
ArrayList<String> cost;

    public recycler_class(ArrayList<String> bitmap, ArrayList<String> cost) {
        this.bitmap = bitmap;
        this.cost = cost;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.reciept_recycle, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
     holder.text1.setText(String.valueOf(position+1));
        //byte[] barray = bitmap.get(position).getBytes();
         byte[] ima= Base64.decode(bitmap.get(position),Base64.DEFAULT);
        Bitmap bmp = BitmapFactory.decodeByteArray(ima, 0, ima.length);
        holder.image.setImageBitmap(bmp);
        holder.text2.setText(String.valueOf(cost.get(position)));

    }


    @Override
    public int getItemCount() {
        return bitmap.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        ImageView image;
        TextView text1,text2;
        public ViewHolder(View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.recycle_image);
            text1=itemView.findViewById(R.id.recycle_txt1);
            text2=itemView.findViewById(R.id.recycle_txt2);

        }
    }
}
