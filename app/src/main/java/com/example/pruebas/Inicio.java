package com.example.pruebas;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

public class Inicio extends AppCompatActivity {

    ImageCarousel carruselCarp, carruselSyncair;
    List<CarouselItem> listCarruselCarp = new ArrayList<>();
    List<CarouselItem> listCarruselSyncair = new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("PANTALLA INICIO", "INICIO DE onCreate: ");

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        carruselCarp = findViewById(R.id.carouselCarpinteria);
        carruselSyncair = findViewById(R.id.carruselSyncair);

        listCarruselCarp.add(new CarouselItem(R.drawable.carp1));
        listCarruselCarp.add(new CarouselItem(R.drawable.carp2));
        listCarruselSyncair.add((new CarouselItem(R.drawable.sync1)));
        listCarruselSyncair.add((new CarouselItem(R.drawable.sync2)));

        carruselCarp.setData(listCarruselCarp);
        carruselSyncair.setData(listCarruselSyncair);


        Log.i("PANTALLA INICIO", "FINAL DE onCreate: ");
    }


    public void presion(View view) {
        Button button = (Button) view;

        // Animar el cambio de color
        ValueAnimator colorAnimation = ValueAnimator.ofArgb(
                Color.parseColor("#000000"), // Color inicial
                Color.parseColor("#bbb4b2")  // Color al presionar
        );
        colorAnimation.setDuration(150); // Duración de la animación
        colorAnimation.setRepeatMode(ValueAnimator.REVERSE);
        colorAnimation.setRepeatCount(1); // Vuelve al color original
        colorAnimation.addUpdateListener(animator -> {
            button.setBackgroundColor((int) animator.getAnimatedValue());
        });

        colorAnimation.start();

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }, 150);
    }






}