package com.example.quanlyhocsinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActivitySubjectInfomation extends AppCompatActivity {

    TextView editCredit, editTitle, editPlace, editTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_infomation);

        editCredit = findViewById(R.id.txtSubjectCredit);
        editTitle = findViewById(R.id.txtSubjectTitle);
        editTime = findViewById(R.id.txtSubjectTime);
        editPlace = findViewById(R.id.txtSubjectPlace);

        //Lấy dữ liệu
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        int credit = intent.getIntExtra("credit",0);
        String time = intent.getStringExtra("time");
        String place = intent.getStringExtra("place");

        //Gán giá trị lên
        editTitle.setText(title);
        editCredit.setText(credit+"");
        editPlace.setText(place);
        editTime.setText(time);


    }
}