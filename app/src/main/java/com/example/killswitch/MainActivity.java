package com.example.killswitch;

import android.os.Bundle;
import okhttp3.*;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import java.io.*;
public class MainActivity extends AppCompatActivity
{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }


    public void sendMessage(View view)
    {
        final TextView helloTextView = findViewById(R.id.text_home);


        final EditText password = findViewById(R.id.password_id);
        helloTextView.setText("Sent.");
        new PostRequest(password.getText().toString()).execute();
    }


}


