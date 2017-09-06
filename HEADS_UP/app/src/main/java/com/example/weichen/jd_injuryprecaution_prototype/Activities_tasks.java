package com.example.weichen.jd_injuryprecaution_prototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.weichen.jd_injuryprecaution_prototype.R.layout.activity_activities_tasks;

public class Activities_tasks extends Fragment {

    private ListView listView;
    public String[] date = { "2/20/17","2/15/17","2/12/17","2/17/17","2/12/17","2/5/17","1/22/17","1/18/17"};
    String[] type = new String[] {"Daily Training", "Pre-game Training", "Game Time", "Post-game Recover","Daily Training", "Pre-game Training", "Game Time", "Post-game Recover"};
    String[] status = new String[] {"Working", "Finished","Finished","Finished","Finished","Finished","Finished","Finished"};
    private ArrayList<String> report = new ArrayList<>();
    private FloatingActionButton mFAB;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(activity_activities_tasks,container,false);

        listView = (ListView)view.findViewById(R.id.tasks_listView);


        for (int i = 0; i < 8; i++) {
            String value = "Date:    "+date[i] + "\n\n"+ "Type:    " + type[i]+"\n\n" + "Status:  " + status[i]+"\n\n"+"Socre:   100/100";
            report.add(value);
        }

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, report);
        listView.setAdapter(arrayAdapter);

        mFAB = (FloatingActionButton) view.findViewById(R.id.tasks_add);
        mFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder rBuilder = new AlertDialog.Builder(getActivity());
                View mView = inflater.inflate(R.layout.activity_new_tasks_popup,null);
                final Button button = (Button) mView.findViewById(R.id.tasks_ok);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getActivity(), Activities.class));
                    }
                });
                rBuilder.setView(mView);
                AlertDialog dialog = rBuilder.create();
                dialog.show();
            }
        });

        return view;
    }




}
