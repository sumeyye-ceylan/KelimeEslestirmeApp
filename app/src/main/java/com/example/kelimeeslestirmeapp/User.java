package com.example.kelimeeslestirmeapp;

public class User {

        private String Ad;
        private String Soyad;
        private String Mail;

        public User() {
            //boş constructor metod
        }
        public User(String ad, String mail, String soyad) {
            Ad = ad;
            Soyad=soyad;
            Mail = mail;
        }
        public void setAd(String ad) {
            Ad = ad;
        }
        public  void setSoyad(String soyad) { Soyad=soyad ;}
        public void setMail(String mail) {
            Mail = mail;
        }
        public String getAd() {
            return Ad;
        }
        public String getSoyad() {
        return Soyad;
    }
        public String getMail() {
            return Mail;
        }


}