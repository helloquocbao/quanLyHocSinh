package com.example.quanlyhocsinh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.widget.Toolbar;

import com.example.quanlyhocsinh.adaptor.adaptorsubject;
import com.example.quanlyhocsinh.database.database;
import com.example.quanlyhocsinh.model.Subject;

import java.util.ArrayList;

public class ActivitiSubject extends AppCompatActivity {

    Toolbar toolbar;
    ListView listViewsubject;
    ArrayList<Subject> ArrayListSubject;
    database database;
    com.example.quanlyhocsinh.adaptor.adaptorsubject adaptorsubject;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        toolbar = findViewById(R.id.toolbarSubject);
        listViewsubject = findViewById(R.id.listviewsubject);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        database = new database(this);

        ArrayListSubject = new ArrayList<>();

        Cursor cursor = database.getDataSubject();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            int credit = cursor.getInt(2);
            String time = cursor.getString(3);
            String place = cursor.getString(4);

            ArrayListSubject.add(new Subject(id, title, credit, time, place));
        }

        adaptorsubject = new adaptorsubject(ActivitiSubject.this, ArrayListSubject);
        listViewsubject.setAdapter(adaptorsubject);
        cursor.moveToFirst();
        cursor.close();

        // Tạo sự kiện click vào item subject
        listViewsubject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ActivitiSubject.this, ActivitiSubject.class);
                int id_subject = ArrayListSubject.get(i).getId();
                //truyền dữ liệu id qua subject qua activity student
                intent.putExtra("id_subject",id_subject);
                startActivity(intent);
            }
        });
    }

    //Thêm một menu là add vào toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menuadd, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            // nếu click vào add thì chuyển qua màn hình add subject
            case R.id.menuadd:
                Intent intent1 = new Intent(ActivitiSubject.this, ActivityAddSubject.class);
                startActivity(intent1);
                break;
            //Nếu click vào nút còn lại là nút back thì quay lại main
            default:
                Intent intent = new Intent(ActivitiSubject.this, MainActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //Nếu click back ở điện thoại sẽ quay trở lại main activity
    @Override
    public void onBackPressed() {
        count++;
        if (count >= 1) {
            Intent intent = new Intent(ActivitiSubject.this, MainActivity.class);
            startActivity(intent);
            finish();

        }
    }
}