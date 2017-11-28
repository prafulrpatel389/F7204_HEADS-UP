package com.example.weichen.jd_injuryprecaution_prototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Activities_surveys extends Fragment {

    private ListView listView;
    String[] type = new String[] {"Self-Report: November 26, 2017", "Self-Report: November 19, 2017"};
    private ArrayList<String> report = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_activities_quizzes,container,false);

        listView = (ListView)view.findViewById(R.id.quizzes_listView);

        for (int i = 0; i < type.length; i++) {
            String value = type[i];
            report.add(value);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.text_view, report);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), Surveys.class);
                intent.putExtra("survey_no", position);
                startActivity(intent);
            }
        });

        return view;
    }
}
