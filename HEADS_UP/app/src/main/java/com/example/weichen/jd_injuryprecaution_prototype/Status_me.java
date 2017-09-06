package com.example.weichen.jd_injuryprecaution_prototype;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

public class Status_me extends Fragment {

    private Spinner sp1;
    private Spinner sp2;
    private Spinner sp3;
    private Spinner sp4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_status_me,container,false);

        sp1 = (Spinner)view.findViewById(R.id.status_me_sp1);


        return view;
    }
}