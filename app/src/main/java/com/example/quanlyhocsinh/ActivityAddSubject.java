package com.example.quanlyhocsinh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlyhocsinh.database.database;
import com.example.quanlyhocsinh.model.Subject;

public class ActivityAddSubject extends AppCompatActivity {

    Button buttonAddSubject;
    EditText edtSubjectTitle, edtSubjectCredit, edtSubjectPlace, edtSubjectTime;
    com.example.quanlyhocsinh.database.database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);

        buttonAddSubject = findViewById(R.id.buttonAddSubject);
        edtSubjectCredit = findViewById(R.id.EditTextSubjectCredit);
        edtSubjectPlace = findViewById(R.id.EditTextSubjectPlace);
        edtSubjectTime = findViewById(R.id.EditTextSubjectTime);
        edtSubjectTitle = findViewById(R.id.EditTextSubjectTitle);

        database = new database(this);

        buttonAddSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogAdd();
            }
        });
    }

    private void DialogAdd() {
        // Tạo đối tượng cửa sổ
        Dialog dialog = new Dialog(this);

        //nạp layout vào dialog
        dialog.setContentView(R.layout.dialogadd);

        // tắ lick ngoài là thoát
        dialog.setCanceledOnTouchOutside(false);

        Button btnYes = dialog.findViewById(R.id.buttonYes);
        Button btnNo = dialog.findViewById(R.id.buttonNo);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subjecttile = edtSubjectTitle.getText().toString().trim();
                String credit = edtSubjectCredit.getText().toString().trim();
                String time = edtSubjectTime.getText().toString().trim();
                String place = edtSubjectPlace.getText().toString().trim();

                // nếu dữ liệu chưa nhập đầy đủ
                if (subjecttile.equals("") || credit.equals("") || time.equals("") || place.equals("")) {
                    Toast.makeText(ActivityAddSubject.this, "Did not enter enough information", Toast.LENGTH_LONG).show();
                } else {
                    // gán cho đối tượng subject giá trị được nhập vào
                    Subject subject = CreateSubject();

                    //thêm vào database
                    database.AddSubject(subject);

                    // add thành công thì chuyển gia màn hình subject
                    Intent intent = new Intent(ActivityAddSubject.this, ActivitiSubject.class);
                    startActivity(intent);

                    Toast.makeText(ActivityAddSubject.this, "more Success", Toast.LENGTH_LONG).show();
                }
            }
        });

        // nếu không add nữa
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
dialog.show();
    }

    // Tạo subject
    private Subject CreateSubject() {
        String subjecttile = edtSubjectTitle.getText().toString().trim();
        int credit = Integer.parseInt(edtSubjectCredit.getText().toString().trim());
        String time = edtSubjectTime.getText().toString().trim();
        String place = edtSubjectPlace.getText().toString().trim();

        Subject subject = new Subject(subjecttile, credit, time, place);
        return subject;
    }
}