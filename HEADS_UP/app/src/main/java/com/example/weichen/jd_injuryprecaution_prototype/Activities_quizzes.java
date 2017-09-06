package com.example.weichen.jd_injuryprecaution_prototype;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Activities_quizzes extends Fragment {

    private ListView listView;
    public String[] date = { "2/20/17","2/15/17","2/12/17","2/17/17","2/12/17","2/5/17","1/22/17","1/18/17"};
    String[] type = new String[] {"Daily Training", "Pre-game Training", "Game Time", "Post-game Recover","Daily Training", "Pre-game Training", "Game Time", "Post-game Recover"};
    String[] status = new String[] {"Working", "Finished","Finished","Finished","Finished","Finished","Finished","Finished"};
    private ArrayList<String> report = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_activities_quizzes,container,false);

        listView = (ListView)view.findViewById(R.id.quizzes_listView);


        for (int i = 0; i < 8; i++) {
            String value = "Date:    "+date[i] + "\n\n"+ "Type:    " + type[i]+"\n\n" + "Status:  " + status[i]+"\n\n"+"Socre:   10/10";
            report.add(value);
        }

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, report);
        listView.setAdapter(arrayAdapter);

        return view;
    }
}
