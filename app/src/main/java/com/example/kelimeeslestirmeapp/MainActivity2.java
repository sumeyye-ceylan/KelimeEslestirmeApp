package com.example.kelimeeslestirmeapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import android.graphics.Point;
import android.widget.Toast;
import android.view.Display;


public class MainActivity2 extends AppCompatActivity {
    public BoardFragment1 fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Display display=getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        FragmentManager fm = getSupportFragmentManager();
        fragment=(BoardFragment1) fm.findFragmentByTag("etiket");

        if(fragment==null){
            Toast.makeText(this, "Sıfırdan oluştu", Toast.LENGTH_SHORT).show();
            fragment=new BoardFragment1();
            fm.beginTransaction().add(R.id.container,fragment,"Etiket").commit();

        }


    }
}
