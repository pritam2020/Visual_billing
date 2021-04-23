package com.DataFlair.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Reciept extends AppCompatActivity  {
    private static final String TAG ="cow" ;
    ArrayList<String> bitmap;
ArrayList<String> cost;
ImageView checkout;
TextView item,total,grand_total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciept);

        checkout=findViewById(R.id.checkout);
        item=findViewById(R.id.items);
        total=findViewById(R.id.grand_view);
        grand_total=findViewById(R.id.grand_total);

        Intent intent=getIntent();
        bitmap=intent.getStringArrayListExtra("bitmap");
        cost=intent.getStringArrayListExtra("cost");




        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recycler_class adapter = new recycler_class(bitmap,cost);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        grand_total.setText(intent.getStringExtra("total"));
        total.setText(intent.getStringExtra("total"));
        item.setText(Integer.toString(cost.size()));




        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Reciept.this,MainActivity2.class);
                intent1.putExtra("item",Integer.toString(cost.size()));
                intent1.putExtra("total",intent.getStringExtra("total"));
                startActivity(intent1);

            }
        });






    }
}