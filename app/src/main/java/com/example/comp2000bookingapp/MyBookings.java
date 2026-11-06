package com.example.comp2000bookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MyBookings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_my_bookings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button hotbarRequests = (Button) findViewById(R.id.hotbarRequests);
        hotbarRequests.setOnClickListener(x -> onhotbarRequestsButtonClick());
        Button hotbarHome = (Button) findViewById(R.id.hotbarHome);
        hotbarHome.setOnClickListener(x -> onhotbarHomeButtonClick());
        Button hotbarCalendar = (Button) findViewById(R.id.hotbarCalendar);
        hotbarCalendar.setOnClickListener(x -> onhotbarCalendarButtonClick());
        Button hotbarSettings = (Button) findViewById(R.id.hotbarSettings);
        hotbarSettings.setOnClickListener(x -> onhotbarSettingsButtonClick());

        Button cancelBooking = (Button) findViewById(R.id.cancelBooking);
        cancelBooking.setOnClickListener(x -> onCancelButtonClick());

        Button cancelBooking2 = (Button) findViewById(R.id.cancelBooking2);
        cancelBooking2.setOnClickListener(x -> onCancelButtonClick());
    }



    private void onhotbarRequestsButtonClick(){
        Intent intent = new Intent(this, RoomRequest.class);
        startActivity(intent);
    }
    private void onhotbarHomeButtonClick(){
        Intent intent = new Intent(this, employeeHomepage.class);
        startActivity(intent);
    }
    private void onhotbarCalendarButtonClick(){
        Intent intent = new Intent(this, EmployeeCalendar.class);
        startActivity(intent);
    }
    private void onhotbarSettingsButtonClick(){
        Intent intent = new Intent(this, employeeSettings.class);
        startActivity(intent);
    }
    private void onCancelButtonClick(){
        CancelBookingDialogueFragment dialog = new CancelBookingDialogueFragment();
        dialog.show(getSupportFragmentManager(), "CancelBookingDialog");
    }
}