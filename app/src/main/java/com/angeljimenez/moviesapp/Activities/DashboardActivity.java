package com.angeljimenez.moviesapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.angeljimenez.moviesapp.R;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Button btnDone = findViewById(R.id.btnDone);
        btnDone.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        //startActivity(new Intent(this, ExploreActivity.class));
        startActivity(new Intent(this, ShowsActivity.class));
    }
}