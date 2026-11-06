package com.example.comp2000bookingapp;

import static android.view.View.VISIBLE;
import static android.view.View.INVISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class RoomRequest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_room_request);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        DatePicker calendar = findViewById(R.id.datePicker);
        Button openCalendar = (Button) findViewById(R.id.openCalendar);
        openCalendar.setOnClickListener(x -> onopenCalendarButtonClick(openCalendar, calendar));

        Button[] rooms = {
                        findViewById(R.id.MR1),
                        findViewById(R.id.MR2),
                        findViewById(R.id.MR3),
                        findViewById(R.id.MR4),
                        findViewById(R.id.MR5),
                        findViewById(R.id.SR1),
                        findViewById(R.id.SR2)
                };

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
        TextView selectedRoom = (TextView)findViewById(R.id.selectedRoom);
        TextView selectedDate = (TextView)findViewById(R.id.selectedDate);

        calendar.init(
                calendar.getYear(),
                calendar.getMonth(),
                calendar.getDayOfMonth(),
                (view, year, month, dayOfMonth) -> {
                    String date = String.valueOf(dayOfMonth) + '/' + String.valueOf(month+1) + '/' + String.valueOf(year);
                    selectedDate.setText("Selected Date: "+date);
                });

        Button viewAvailability = (Button) findViewById(R.id.viewAvailability);
        viewAvailability.setOnClickListener(x -> onviewAvailabilityButtonClick());
        Button hotbarCalendar = (Button) findViewById(R.id.hotbarCalendar);
        hotbarCalendar.setOnClickListener(x -> onviewAvailabilityButtonClick());
        Button hotbarHome = (Button) findViewById(R.id.hotbarHome);
        hotbarHome.setOnClickListener(x -> onhotbarHomeButtonClick());
        Button hotbarBookings = (Button) findViewById(R.id.hotbarBookings);
        hotbarBookings.setOnClickListener(x -> onhotbarBookingsButtonClick());
        Button hotbarSettings = (Button) findViewById(R.id.hotbarSettings);
        hotbarSettings.setOnClickListener(x -> onhotbarSettingsButtonClick());

        for(int i = 0; i < rooms.length; i++){
            int index = i;
            rooms[i].setOnClickListener(x -> onRoomButtonClicked(selectedRoom, rooms[index]));
        }

        for(int j = 0; j < startTimes.length; j++){
            int index = j;
            startTimes[j].setOnClickListener(x -> onStartTimeClicked(startTime, startTimes[index]));
        }

        for(int k = 0; k < endTimes.length; k++){
            int index = k;
            endTimes[k].setOnClickListener(x -> onEndTimeClicked(endTime, endTimes[index]));
        }

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
    private void onhotbarSettingsButtonClick(){
        Intent intent = new Intent(this, employeeSettings.class);
        startActivity(intent);
    }
    private void onRoomButtonClicked(TextView selectedRoom, Button roomButton){
        selectedRoom.setText("Selected Room: "+roomButton.getText());
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