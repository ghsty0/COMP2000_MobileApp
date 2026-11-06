package com.example.comp2000bookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class employeeSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_employee_settings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button hotbarCalendar = (Button) findViewById(R.id.hotbarCalendar);
        hotbarCalendar.setOnClickListener(x -> onviewAvailabilityButtonClick());
        Button hotbarHome = (Button) findViewById(R.id.hotbarHome);
        hotbarHome.setOnClickListener(x -> onhotbarHomeButtonClick());
        Button hotbarBookings = (Button) findViewById(R.id.hotbarBookings);
        hotbarBookings.setOnClickListener(x -> onhotbarBookingsButtonClick());
        Button hotbarRequests = (Button) findViewById(R.id.hotbarRequests);
        hotbarRequests.setOnClickListener(x -> onhotbarRequestsButtonClick());
    }



    private void onviewAvailabilityButtonClick(){
        Intent intent = new Intent(this, EmployeeCalendar.class);
        startActivity(intent);
    }
    private void onhotbarHomeButtonClick(){
        Intent intent = new Intent(this, employeeHomepage.class);
        startActivity(intent);
    }
    private void onhotbarBookingsButtonClick(){
        Intent intent = new Intent(this, MyBookings.class);
        startActivity(intent);
    }
    private void onhotbarRequestsButtonClick() {
        Intent intent = new Intent(this, RoomRequest.class);
        startActivity(intent);
    }
}