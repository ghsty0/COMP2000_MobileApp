package com.example.comp2000bookingapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class CancelBookingDialogueFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Hold It!");
        builder.setMessage("This action will submit a cancellation request. Are you sure you want to proceed?");
        builder.setPositiveButton("Yes, I want to cancel.", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i){ }
        });
        builder.setNegativeButton("No, take me back.", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i){ }
        });
        return builder.create();
    }
}

