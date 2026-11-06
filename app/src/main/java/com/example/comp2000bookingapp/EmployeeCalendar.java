package com.example.comp2000bookingapp;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class EmployeeCalendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_employee_calendar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button[] startTimes = {
                findViewById(R.id.time9),
                findViewById(R.id.time10),
                findViewById(R.id.time11),
                findViewById(R.id.time12),
                findViewById(R.id.time13),
                findViewById(R.id.time14),
                findViewById(R.id.time15),
                findViewById(R.id.time16),
                findViewById(R.id.time17)
        };

        Button[] endTimes = {
                findViewById(R.id.eTime10),
                findViewById(R.id.eTime11),
                findViewById(R.id.eTime12),
                findViewById(R.id.eTime13),
                findViewById(R.id.eTime14),
                findViewById(R.id.eTime15),
                findViewById(R.id.eTime16),
                findViewById(R.id.eTime17),
                findViewById(R.id.eTime18)
        };
        TextView startTime = (TextView)findViewById(R.id.startTime);
        TextView endTime = (TextView)findViewById(R.id.endTime);

        DatePicker calendar = findViewById(R.id.datePicker);
        Button openCalendar = (Button) findViewById(R.id.chooseDay);
        openCalendar.setOnClickListener(x -> onopenCalendarButtonClick(openCalendar, calendar));

        TextView selectedDate = (TextView)findViewById(R.id.selectedDate);

        calendar.init(
                calendar.getYear(),
                calendar.getMonth(),
                calendar.getDayOfMonth(),
                (view, year, month, dayOfMonth) -> {
                    String date = String.valueOf(dayOfMonth) + '/' + String.valueOf(month+1) + '/' + String.valueOf(year);
                    selectedDate.setText("Selected Date: "+date);
                });

        Button bookRoom = (Button) findViewById(R.id.bookRoom);
        bookRoom.setOnClickListener(x -> onhotbarRequestsButtonClick());
        Button hotbarRequests = (Button) findViewById(R.id.hotbarRequests);
        hotbarRequests.setOnClickListener(x -> onhotbarRequestsButtonClick());
        Button hotbarHome = (Button) findViewById(R.id.hotbarHome);
        hotbarHome.setOnClickListener(x -> onhotbarHomeButtonClick());
        Button hotbarBookings = (Button) findViewById(R.id.hotbarBookings);
        hotbarBookings.setOnClickListener(x -> onhotbarBookingsButtonClick());
        Button hotbarSettings = (Button) findViewById(R.id.hotbarSettings);
        hotbarSettings.setOnClickListener(x -> onhotbarSettingsButtonClick());

        for(int j = 0; j < startTimes.length; j++){
            int index = j;
            startTimes[j].setOnClickListener(x -> onStartTimeClicked(startTime, startTimes[index]));
        }

        for(int k = 0; k < endTimes.length; k++){
            int index = k;
            endTimes[k].setOnClickListener(x -> onEndTimeClicked(endTime, endTimes[index]));
        }
    }




    private void onhotbarRequestsButtonClick(){
        Intent intent = new Intent(this, RoomRequest.class);
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
    private void onhotbarSettingsButtonClick(){
        Intent intent = new Intent(this, employeeSettings.class);
        startActivity(intent);
    }

    private void onStartTimeClicked(TextView startTime, Button startTimes){
        startTime.setText("Start: "+startTimes.getText());
    }
    private void onEndTimeClicked(TextView endTime, Button endTimes){
        endTime.setText("End: "+endTimes.getText());
    }

    private void onopenCalendarButtonClick(Button openCalendar, DatePicker calendar){
        int vis = calendar.getVisibility();
        if(vis == VISIBLE){
            calendar.setVisibility(INVISIBLE);
        }
        else{
            calendar.setVisibility(VISIBLE);
        }
    }
}