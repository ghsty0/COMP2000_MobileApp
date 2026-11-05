package com.example.comp2000bookingapp;

import android.os.Bundle;
import android.widget.Button;
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


        for(int i = 0; i < rooms.length; i++){
            int index = i;
            rooms[i].setOnClickListener(x -> onRoomButtonClicked(selectedRoom, rooms[index]));
        }
    }
    private void onRoomButtonClicked(TextView selectedRoom, Button roomButton){
        selectedRoom.setText("Selected Room: "+roomButton.getText());
    }
}