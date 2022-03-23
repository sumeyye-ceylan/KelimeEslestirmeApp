package com.example.kelimeeslestirmeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    public BoardFragment3 fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Display display=getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        FragmentManager fm = getSupportFragmentManager();
        fragment=(BoardFragment3) fm.findFragmentByTag("etiket");

        if(fragment==null){
            Toast.makeText(this, "Sıfırdan oluştu", Toast.LENGTH_SHORT).show();
            fragment=new BoardFragment3();
            fm.beginTransaction().add(R.id.container,fragment,"Etiket").commit();

        }


    }
}