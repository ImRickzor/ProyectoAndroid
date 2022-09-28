package com.angeljimenez.moviesapp;

import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.angeljimenez.moviesapp.fragments.SignInFragment;
import com.angeljimenez.moviesapp.fragments.SignUpFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Acceder a los formularios
        Button btnSignUp = findViewById(R.id.btnSignUp);
        Button btnSignIn = findViewById(R.id.btnSignIn);
        Button btnApple = findViewById(R.id.btnApple);
        Button btnFacebook = findViewById(R.id.btnFacebook);

        btnSignUp.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
        btnApple.setOnClickListener(this);
        btnFacebook.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //Cambiar texto de Bienvenida
        TextView txtBienvenida = findViewById(R.id.txtBienvenidos);
        //Cambiar color del texto de los botones
        Button btnSignUp = findViewById(R.id.btnSignUp);
        Button btnSignIn = findViewById(R.id.btnSignIn);

        switch (view.getId()){
            case R.id.btnSignUp:
                mostrarSignUp();
                txtBienvenida.setText("Welcome!");
                btnSignUp.setTextColor(Color.WHITE);
                btnSignIn.setTextColor(Color.parseColor("#5A5A5E"));
                break;
            case R.id.btnSignIn:
                mostrarSignIn();
                txtBienvenida.setText("Hello,\nMovie Lover!");
                btnSignUp.setTextColor(Color.parseColor("#5A5A5E"));
                btnSignIn.setTextColor(Color.WHITE);
                break;
            case R.id.btnApple:
                mostrarDashboard();
                break;
            case R.id.btnFacebook:
                mostrarDashboard();
                break;
        }
    }

    private void mostrarDashboard() {
        startActivity(new Intent(this, DashboardActivity.class));
    }


    @MainThread
    @CallSuper
    public void onStart() {
        super.onStart();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorInicio, new SignUpFragment()).commit();
        Button btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setTextColor(Color.WHITE);
    }

    private void mostrarSignUp() {
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorInicio, new SignUpFragment()).commit();
    }

    private void mostrarSignIn() {
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorInicio, new SignInFragment()).commit();
    }
}