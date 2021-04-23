package com.DataFlair.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Base64DataException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.camerakit.CameraKitView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE;


public class MainActivity extends AppCompatActivity {
    private CameraKitView cameraKitView;

    double in1 = 0, i2 = 0;
    TextView edittext1;
    int i=1;
    String total;

    boolean Add, Sub, Multiply, Divide, Remainder, deci;
    Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_Add, button_Sub,
            button_Mul, button_Div, button_Equ, button_Del, button_Dot, button_Remainder; ImageView button_play;
            ArrayList<String> bitmaps;
            ImageView next_page;
            float f=0;
            TextView display_total;
            ArrayList<String> cost;

            @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cameraKitView = findViewById(R.id.camera);
        bitmaps = new ArrayList<>();
        cost = new ArrayList<>();




        button_0 = (Button) findViewById(R.id.b0);
        next_page=findViewById(R.id.next_page);
        display_total=findViewById(R.id.display_total);
        button_1 = (Button) findViewById(R.id.b1);
        button_2 = (Button) findViewById(R.id.b2);
        button_3 = (Button) findViewById(R.id.b3);
        button_4 = (Button) findViewById(R.id.b4);
        button_5 = (Button) findViewById(R.id.b5);
        button_6 = (Button) findViewById(R.id.b6);
        button_7 = (Button) findViewById(R.id.b7);
        button_8 = (Button) findViewById(R.id.b8);
        button_9 = (Button) findViewById(R.id.b9);
        button_Dot = (Button) findViewById(R.id.bDot);
        button_Add = (Button) findViewById(R.id.badd);
       // button_Sub = (Button) findViewById(R.id.bsub);
        button_Mul = (Button) findViewById(R.id.bmul);
      //  button_Div = (Button) findViewById(R.id.biv);
      //  button_Remainder = (Button) findViewById(R.id.BRemain);
        button_Del = (Button) findViewById(R.id.buttonDel);
        button_Equ = (Button) findViewById(R.id.buttoneql);
        button_play= findViewById(R.id.play);
        edittext1 = (TextView) findViewById(R.id.display);
        button_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edittext1.getText().toString().equals("")){
                    f=f+Float.parseFloat(edittext1.getText().toString());
                    display_total.setText(Float.toString(f));

                    cameraKitView.captureImage(new CameraKitView.ImageCallback() {
                        @Override
                        public void onImage(CameraKitView cameraKitView, final byte[] capturedImage) {

                            String simage=Base64.encodeToString(capturedImage,Base64.DEFAULT);
                            bitmaps.add(simage);
                            cost.add(edittext1.getText().toString());
                            edittext1.setText("");
                        }
                    });
            }else
                    Toast.makeText(MainActivity.this,"enter amount",Toast.LENGTH_SHORT).show();
            }
        });


        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "1");
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "2");
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "3");
            }
        });

        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "4");
            }
        });

        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "5");
            }
        });

        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "6");
            }
        });

        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "7");
            }
        });

        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "8");
            }
        });

        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "9");
            }
        });

        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "0");
            }
        });

        button_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    in1 = Float.parseFloat(edittext1.getText() + "");
                    Add = true;
                    deci = false;
                    edittext1.setText(null);
                }
            }
        });


        button_Mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    in1 = Float.parseFloat(edittext1.getText() + "");
                    Multiply = true;
                    deci = false;
                    edittext1.setText(null);
                }
            }
        });



        button_Equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Add || Sub || Multiply || Divide || Remainder) {
                    i2 = Float.parseFloat(edittext1.getText() + "");
                }

                if (Add) {

                    edittext1.setText(in1 + i2 + "");
                    Add = false;
                }

                if (Sub) {

                    edittext1.setText(in1 - i2 + "");
                    Sub = false;
                }

                if (Multiply) {
                    edittext1.setText(in1 * i2 + "");
                    Multiply = false;
                }

                if (Divide) {
                    edittext1.setText(in1 / i2 + "");
                    Divide = false;
                }
                if (Remainder) {
                    edittext1.setText(in1 % i2 + "");
                    Remainder = false;
                }
            }
             //mCamera.takePicture(null, null, mPicture);
        });

        button_Del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText("");
                in1 = 0.0;
                i2 = 0.0;
            }
        });

        button_Dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (deci) {
                    //do nothing or you can show the error
                } else {
                    edittext1.setText(edittext1.getText() + ".");
                    deci = true;
                }

            }
        });
        next_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                total=display_total.getText().toString();

                Intent intent=new Intent(MainActivity.this,Reciept.class);
                intent.putStringArrayListExtra("bitmap",bitmaps);
                intent.putStringArrayListExtra("cost",cost);
                intent.putExtra("total",total);
                startActivity(intent);
            }
        });


    }
    @Override
    protected void onStart() {
        super.onStart();
        cameraKitView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        cameraKitView.onResume();
    }

    @Override
    protected void onPause() {
        cameraKitView.onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        cameraKitView.onStop();
        super.onStop();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        cameraKitView.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }




}
