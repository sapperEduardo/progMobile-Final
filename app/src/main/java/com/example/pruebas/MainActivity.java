package com.example.pruebas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
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


    }


    public void presion(View view) {
        nameText = name.getText().toString();
        passwordText = password.getText().toString();

        Toast.makeText(this, "Nombre: " + nameText + "\nContra: " + passwordText, Toast.LENGTH_SHORT).show();

        if (nameText.equals("root") && passwordText.equals("admin")) {
            Intent intent = new Intent(MainActivity.this, Inicio.class);
            intent.putExtra("username", nameText); // Enviar el nombre de usuario
            startActivity(intent);
        } else {
            Toast.makeText(this, "Usuario o contraseña INCORRECTOS", Toast.LENGTH_SHORT).show();
        }
    }



}