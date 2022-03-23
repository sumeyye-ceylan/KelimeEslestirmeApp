package com.example.kelimeeslestirmeapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Veritabani extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="user_veritabani";
    private static final String TABLE_NAME="user_tablosu";
    private static final int DATABASE_VERSION=1;

    private static final String AD="ad";
    private static final String SOYAD="soyad";
    private static final String MAIL="mail";
    private static final String ID="_id";
    public Veritabani(Context context) {


        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String tablo_olustur="CREATE TABLE "+TABLE_NAME+
                " ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                AD+" TEXT, "+
                SOYAD+" TEXT, "+
                MAIL+" TEXT);";

        db.execSQL(tablo_olustur);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    public long KayitEkle(User user) {

        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put(AD,user.getAd());
        cv.put(MAIL,user.getSoyad());
        cv.put(MAIL,user.getMail());

        long id=db.insert(TABLE_NAME,null,cv);

        db.close();
        return id;

    }

    public List<User> TumKayitlariGetir() {

        SQLiteDatabase db=this.getReadableDatabase();

        String [] sutunlar=new String[]{AD,SOYAD,MAIL};

        Cursor c=db.query(TABLE_NAME, sutunlar, null, null, null, null, null);
        //Cursor cursor=db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        int adsirano=c.getColumnIndex(AD);
        int soyadsirano=c.getColumnIndex(SOYAD);
        int mailsirano=c.getColumnIndex(MAIL);

        List<User> userList=new ArrayList<User>();

        for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){

            User user=new User();

            user.setAd(c.getString(adsirano));
            user.setSoyad(c.getString(soyadsirano));
            user.setMail(c.getString(mailsirano));

            userList.add(user);
        }
        db.close();

        return userList;
    }
}
