package com.example.quanlyhocsinh.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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

        return null;
    }
}
