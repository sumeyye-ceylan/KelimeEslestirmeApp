package com.example.kelimeeslestirmeapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        EditText et_ad,et_mail,et_soyad;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            et_ad= (EditText) findViewById(R.id.et_ad);
            et_soyad= (EditText) findViewById(R.id.et_soyad);
            et_mail= (EditText) findViewById(R.id.et_mail);


        }

        public void butonaDokunuldu(View view){

            switch (view.getId()){

                case R.id.btn_kaydet:

                    String ad=et_ad.getText().toString();
                    String soyad=et_soyad.getText().toString();
                    String mail=et_mail.getText().toString();

                    User user=new User(ad,soyad,mail);

                    try {
                        Veritabani db= new Veritabani(getApplicationContext());
                        long id=db.KayitEkle(user);

                        if(id==-1){
                            Toast.makeText(MainActivity.this, " Kayıt işleminde bir hata oluştu !", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(),"Kayıt işlemi başarılı",Toast.LENGTH_LONG).show();
                        }

                    }catch (Exception e){

                        Toast.makeText(MainActivity.this, "Hay aksi!\n"+e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }


                    et_ad.setText("");
                    et_soyad.setText("");
                    et_mail.setText("");

                    break;

                case R.id.btn_giris:

                    Intent intent=new Intent(getApplicationContext(),MainActivity1.class);
                    startActivity(intent);
            }
        }

    }
