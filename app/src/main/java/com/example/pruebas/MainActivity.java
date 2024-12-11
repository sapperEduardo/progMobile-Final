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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private final String USER_NAME = "seba";
    private final String PASSWORD = "123";
    private EditText name;
    private EditText password;
    private String nameText;
    private String passwordText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name = findViewById(R.id.etname);
        password = findViewById(R.id.etpassword);

        // Listener para cuando el EditText obtiene el foco
        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    name.setHint(""); // Borra el hint al enfocar
                } else if (name.getText().toString().isEmpty()) {
                    name.setHint("Ingrese su nombre"); // Restaura el hint si está vacío
                }
            }
        });
        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    password.setHint(""); // Borra el hint al enfocar
                } else if (password.getText().toString().isEmpty()) {
                    password.setHint("Ingrese su contraseña"); // Restaura el hint si está vacío
                }
            }
        });

    }


    public void presion(View view) {
        Button button = (Button) view;

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
            nameText = name.getText().toString().trim();
            passwordText = password.getText().toString().trim();

            if (nameText.equals(this.USER_NAME) && passwordText.equals(this.PASSWORD)) {
                Log.i("PANTALLA main", "ANTES DE CREAR EL INTENT: ");
                Intent intent = new Intent(MainActivity.this, Inicio.class);
                Log.i("PANTALLA main", "ANTES DE LANZAR EL INTENT: ");
                startActivity(intent);
                this.finish();
                Log.i("PANTALLA main", "DESPUES DE LANZAR EL INTENT: ");
            } else {
                Toast.makeText(this, "Usuario o contraseña INCORRECTOS", Toast.LENGTH_SHORT).show();
            }
        }, 150);
    }



}