package com.mrlonewolfer.timepickerdailog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnTimePicker;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        btnTimePicker=findViewById(R.id.btnTimePicker);
        btnTimePicker.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnTimePicker){
            showTimePickerDailog();
            
        }
    }

    private void showTimePickerDailog() {
        Calendar calendar=Calendar.getInstance();
        int Hour=calendar.get(Calendar.HOUR);
        int Minute=calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog=new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                TextView textView=findViewById(R.id.txtTime);
                if(hourOfDay>12){
                    hourOfDay=hourOfDay-12;
                    textView.setText("Time is : "+hourOfDay+" : "+minute+" P.M");
                }
                else{
                    textView.setText("Time is : "+hourOfDay+" : "+minute+" A.M");
                }
            }
        },Hour,Minute,false);
        timePickerDialog.show();
    }
}
