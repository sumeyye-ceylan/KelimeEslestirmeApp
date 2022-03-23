package com.example.kelimeeslestirmeapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        Button btn1=findViewById(R.id.board1);
        Button btn2=findViewById(R.id.board2);
        Button btn3=findViewById(R.id.board3);
        Button btn4=findViewById(R.id.board4);
        Button btn5=findViewById(R.id.board5);
        Button btn6=findViewById(R.id.board6);
        Button btn7=findViewById(R.id.board7);
        Button btn8=findViewById(R.id.board8);
        Button btn9=findViewById(R.id.board9);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main2 =new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(main2);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main3 =new Intent(getApplicationContext(),MainActivity3.class);
                startActivity(main3);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main4 =new Intent(getApplicationContext(),MainActivity4.class);
                startActivity(main4);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main5 =new Intent(getApplicationContext(),MainActivity5.class);
                startActivity(main5);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main6 =new Intent(getApplicationContext(),MainActivity6.class);
                startActivity(main6);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main7 =new Intent(getApplicationContext(),MainActivity7.class);
                startActivity(main7);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main8 =new Intent(getApplicationContext(),MainActivity8.class);
                startActivity(main8);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main9 =new Intent(getApplicationContext(),MainActivity9.class);
                startActivity(main9);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main10 =new Intent(getApplicationContext(),MainActivity10.class);
                startActivity(main10);
            }
        });

    }


}