package com.example.comp2000bookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class employeeHomepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_employee_homepage);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button requestRoomButton = (Button) findViewById(R.id.requestRoomButton);
        requestRoomButton.setOnClickListener(x -> onrequestRoomButtonButtonClick());

        Button calendarButtonButton = (Button) findViewById(R.id.calendarButton);
        calendarButtonButton.setOnClickListener(x -> oncalendarButtonButtonClick());

        Button bookingsButtonButton = (Button) findViewById(R.id.bookingsButton);
        bookingsButtonButton.setOnClickListener(x -> onbookingsButtonButtonClick());
    }
    private void onrequestRoomButtonButtonClick(){
        Intent intent = new Intent(this, RoomRequest.class);
        startActivity(intent);
    }
    private void oncalendarButtonButtonClick(){
        Intent intent2 = new Intent(this, EmployeeCalendar.class);
        startActivity(intent2);
    }
    private void onbookingsButtonButtonClick(){
        Intent intent3 = new Intent(this, MyBookings.class);
        startActivity(intent3);
    }
}