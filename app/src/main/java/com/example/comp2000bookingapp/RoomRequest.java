package com.example.comp2000bookingapp;

import static android.view.View.VISIBLE;
import static android.view.View.INVISIBLE;

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


        for(int i = 0; i < rooms.length; i++){
            int index = i;
            rooms[i].setOnClickListener(x -> onRoomButtonClicked(selectedRoom, rooms[index]));
        }

    }
    private void onRoomButtonClicked(TextView selectedRoom, Button roomButton){
        selectedRoom.setText("Selected Room: "+roomButton.getText());
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