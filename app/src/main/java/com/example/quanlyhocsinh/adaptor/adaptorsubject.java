package com.example.quanlyhocsinh.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.quanlyhocsinh.ActivitiSubject;
import com.example.quanlyhocsinh.R;
import com.example.quanlyhocsinh.model.Subject;

import java.util.ArrayList;

public class adaptorsubject extends BaseAdapter {

    private ActivitiSubject context;
    private ArrayList<Subject> arrayListSubject;

    public adaptorsubject(ActivitiSubject context, ArrayList<Subject> arrayListSubject) {
        this.context = context;
        this.arrayListSubject = arrayListSubject;
    }

    @Override
    public int getCount() {
        return arrayListSubject.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListSubject.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.listsuject,null);

        TextView TextViewSubjectTitle = view.findViewById(R.id.TextViewSubjectTitle);
        TextView TextViewCredit = view.findViewById(R.id.TextViewCredit);
        ImageButton imageDelete = view.findViewById(R.id.subjectdelete);
        ImageButton imageInfomation = view.findViewById(R.id.subjectinfomation);
        ImageButton imageUpdate = view.findViewById(R.id.subjectupdate);

        Subject subject = arrayListSubject.get(i);

        TextViewCredit.setText(subject.getNumber_of_credit()+"");
        TextViewSubjectTitle.setText(subject.getSubject_title());

        int id = subject.getId();

        imageInfomation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.infomation(id);
            }
        });

        imageDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        imageUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }
}
