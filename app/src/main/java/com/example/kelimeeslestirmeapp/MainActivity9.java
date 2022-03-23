package com.example.kelimeeslestirmeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.widget.Toast;

public class MainActivity9 extends AppCompatActivity {
    public BoardFragment8 fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Display display=getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        FragmentManager fm = getSupportFragmentManager();
        fragment=(BoardFragment8) fm.findFragmentByTag("etiket");

        if(fragment==null){
            Toast.makeText(this, "Sıfırdan oluştu", Toast.LENGTH_SHORT).show();
            fragment=new BoardFragment8();
            fm.beginTransaction().add(R.id.container,fragment,"Etiket").commit();

        }


    }
}