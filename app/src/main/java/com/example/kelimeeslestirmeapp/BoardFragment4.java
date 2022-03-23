package com.example.kelimeeslestirmeapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoardFragment4 extends Fragment {
    private Context context;
    private List<Model> modelListLeft, modelListRight;
    private int widthButton, heightButton;
    private LinearLayout containerLeft, containerRight;
    private  int x,y;
    private  int silinenButtonSayisi = 0;
    private  static final int DURATION=400;
    private  static final int DURATION_KAYBOL= 300;
    private  static final int DURATION_ADD_BUTTON= 700;
    private  Button selectButtonLeft = null;
    private  Button selectButtonRight = null;
    private Boolean ButtonClickEnable = true;

    private  View.OnTouchListener touchlistener =new View.OnTouchListener(){
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            x=(int) motionEvent.getX();
            y=(int) motionEvent.getY();
            return false;
        }
    };
    private  View.OnClickListener clicklistenerLeft =new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            if(!ButtonClickEnable){
                return;
            }

            if(selectButtonRight !=null ){
                //eşleştirme  kontrolü yapılıyor
                selectButtonLeft =(Button) view;
                ButtonClickEnable=false;
                if(selectButtonLeft.getId()==selectButtonRight.getId()){
                    revealEffectBlue();
                }
                else {
                    revealEffectRed();
                }
            }
            else {
                if (selectButtonLeft !=null) {
                    selectButtonLeft.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButton)));
                }
                selectButtonLeft=(Button) view;
                selectButtonLeft.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButtonSelect)));
            }
        }
    };


    private  View.OnClickListener clicklistenerRight =new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            if(!ButtonClickEnable){
                return;
            }

            if(selectButtonLeft !=null ){
                //eşleştirme  kontrolü  yapılıyor
                selectButtonRight =(Button) view;
                ButtonClickEnable=false;
                if(selectButtonLeft.getId()==selectButtonRight.getId()){
                    revealEffectBlue();
                }
                else {
                    revealEffectRed();
                }
            }
            else {
                if (selectButtonRight !=null) {
                    selectButtonRight.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButton)));
                }
                selectButtonRight=(Button) view;
                selectButtonRight.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButtonSelect)));
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.board_fragment, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // initialize
        modelListLeft = new ArrayList<>();
        modelListRight = new ArrayList<>();
        containerLeft = ((AppCompatActivity) context).findViewById(R.id.containerLeft);
        containerRight = ((AppCompatActivity) context).findViewById(R.id.containerRight);

        //buton genişlik ve yüksekliğinin hesaplanması
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        widthButton = (int) ((size.x) / (2 + .4));
        heightButton = (int) ((size.y) / (6 + 1.5));

        modelListLeft.add(new Model("Hand", "El", 0));
        modelListLeft.add(new Model("Hair", "Saç", 1));
        modelListLeft.add(new Model("Eye", "Göz", 2));
        modelListLeft.add(new Model("Foot", "Ayak", 3));
        modelListLeft.add(new Model("Finger", "Parmak", 4));
        modelListLeft.add(new Model("Head", "Baş", 5));
        modelListLeft.add(new Model("Ear", "Kulak", 6));
        modelListLeft.add(new Model("Leg", "Ayak", 7));
        modelListLeft.add(new Model("Nose", "Burun", 8));
        modelListLeft.add(new Model("Face", "Yüz", 9));
        modelListLeft.add(new Model("Tooth", "Diş", 10));

        //model listesi klonlama
        for (Model model : modelListLeft) {
            modelListRight.add(model);
        }
        //karıştırma
        Collections.shuffle(modelListLeft);
        Collections.shuffle(modelListRight);

        //soldaki butonlar containera dolduruluyor
        for (int i = 0; i < 6; i++) {
            Button button = new Button(context);
            button.setWidth(widthButton);
            button.setHeight(heightButton);
            button.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            button.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButton)));
            button.setAllCaps(false);
            button.setTextSize(heightButton/7);
            button.setId(modelListLeft.get(0).getId());
            button.setText(modelListLeft.get(0).getKelime());
            button.setOnTouchListener(touchlistener);
            button.setOnClickListener(clicklistenerLeft);
            containerLeft.addView(button);
            modelListLeft.remove(0);
        }
        //sağdaki butonlar containera dolduruluyor
        for (int i = 0; i < 6; i++) {
            Button button = new Button(context);
            button.setWidth(widthButton);
            button.setHeight(heightButton);
            button.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            button.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButton)));
            button.setAllCaps(false);
            button.setTextSize(heightButton/7);
            button.setId(modelListRight.get(0).getId());
            button.setText(modelListRight.get(0).getAnlami());
            button.setOnTouchListener(touchlistener);
            button.setOnClickListener(clicklistenerRight);
            containerRight.addView(button);
            modelListRight.remove(0);
        }
        girisAnimasyonu();
    }
    private  void  girisAnimasyonu(){
        for(int i=0; i<containerLeft.getChildCount(); i++ ) {
            Button button= (Button) containerLeft.getChildAt(5-i);
            ObjectAnimator animator=ObjectAnimator.ofFloat(button ,"translationX",-widthButton*1.5f,0);
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
            animator.setDuration(DURATION + i*70 );
            animator.start();
        }
        for(int i=0; i<containerRight.getChildCount(); i++ ) {
            Button button= (Button) containerRight.getChildAt(5-i);
            ObjectAnimator animator=ObjectAnimator.ofFloat(button ,"translationX",widthButton*1.5f,0);
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
            animator.setDuration(DURATION + i*70 );
            animator.start();
        }
    }
    private void revealEffectRed() {
        int finalRadius = Math.max(widthButton,heightButton);
        Animator animRight = ViewAnimationUtils.createCircularReveal(selectButtonRight,x,y,0,finalRadius);
        Animator animLeft = ViewAnimationUtils.createCircularReveal(selectButtonLeft,x,y,0,finalRadius);
        selectButtonLeft.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButtonRed)));
        selectButtonRight.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButtonRed)));

        animLeft.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                selectButtonLeft.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButton)));
                selectButtonRight.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButton)));

                selectButtonLeft= null;
                selectButtonRight=null;

                ButtonClickEnable=true;
            }
        });
        animLeft.setDuration(DURATION);
        animRight.setDuration(DURATION);
        animRight.start();
        animLeft.start();
    }

    private void revealEffectBlue() {
        int finalRadius = Math.max(widthButton,heightButton);
        Animator animRight = ViewAnimationUtils.createCircularReveal(selectButtonRight,x,y,0,finalRadius);
        Animator animLeft = ViewAnimationUtils.createCircularReveal(selectButtonLeft,x,y,0,finalRadius);
        selectButtonLeft.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButtonBlue)));
        selectButtonRight.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButtonBlue)));

        animLeft.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                kaybol();
            }
        });
        animLeft.setDuration(DURATION);
        animRight.setDuration(DURATION);
        animRight.start();
        animLeft.start();
    }

    private void kaybol() {
        ObjectAnimator AnimatorLeft =ObjectAnimator.ofFloat(selectButtonLeft,"TranslationX",0,-widthButton*1.5f);
        ObjectAnimator AnimatorRight =ObjectAnimator.ofFloat(selectButtonRight,"TranslationX",0,widthButton*1.5f);

        AnimatorSet set= new AnimatorSet();
        set.playTogether(AnimatorLeft,AnimatorRight);
        set.setDuration(DURATION_KAYBOL);
        set.setInterpolator(new LinearInterpolator());
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                selectButtonLeft.setVisibility(View.GONE);
                selectButtonRight.setVisibility(View.GONE);
                selectButtonLeft =null;
                selectButtonRight=null;

                ButtonClickEnable=true;
                silinenButtonSayisi ++;

                if(modelListLeft.size()==0 && modelListRight.size()==0){
                    //eklenecek buton kalmadı ise
                    if(silinenButtonSayisi==11){
                        Dialog dialog = new Dialog(context,R.style.CustomDialog);
                        LayoutInflater layoutInflater=LayoutInflater.from(context);
                        CardView view= (CardView) layoutInflater.inflate(R.layout.dialog,null);
                        dialog.setContentView(view);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.show();
                    }
                }
                else {
                    addButton();
                }
            }
        });
        set.start();
    }

    private void addButton() {
        Button button = new Button(context);
        button.setWidth(widthButton);
        button.setHeight(heightButton);
        button.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        button.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButton)));
        button.setAllCaps(false);
        button.setTextSize(heightButton/7);
        button.setId(modelListLeft.get(0).getId());
        button.setText(modelListLeft.get(0).getKelime());
        button.setOnTouchListener(touchlistener);
        button.setOnClickListener(clicklistenerLeft);
        containerLeft.addView(button ,0);
        modelListLeft.remove(0);
        ObjectAnimator animatorLeft = ObjectAnimator.ofFloat(button,"TranslationX",-widthButton*1.5f,0);
        animatorLeft.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorLeft.setDuration(DURATION_ADD_BUTTON);
        animatorLeft.start();

        Button buttonR = new Button(context);
        buttonR.setWidth(widthButton);
        buttonR.setHeight(heightButton);
        buttonR.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        buttonR.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButton)));
        buttonR.setAllCaps(false);
        buttonR.setTextSize(heightButton/7);
        buttonR.setId(modelListRight.get(0).getId());
        buttonR.setText(modelListRight.get(0).getAnlami());
        buttonR.setOnTouchListener(touchlistener);
        buttonR.setOnClickListener(clicklistenerRight);
        containerRight.addView(buttonR ,0);
        modelListRight.remove(0);
        ObjectAnimator animatorRight = ObjectAnimator.ofFloat(buttonR,"TranslationX",widthButton*1.5f,0);
        animatorRight.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorRight.setDuration(DURATION_ADD_BUTTON);
        animatorRight.start();
    }


}