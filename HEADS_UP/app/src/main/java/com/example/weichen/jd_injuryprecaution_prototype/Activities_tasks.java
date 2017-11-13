package com.example.weichen.jd_injuryprecaution_prototype;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import static android.content.Context.MODE_PRIVATE;
import static com.example.weichen.jd_injuryprecaution_prototype.R.layout.activity_activities_tasks;

public class Activities_tasks extends Fragment {

    private ListView listView;

    public String[] date_list = { "2/20/17","2/15/17","2/12/17","2/17/17","2/12/17","2/5/17","1/22/17","1/18/17"};
    String[] type = new String[] {"Daily Training", "Pre-game Training", "Game Time", "Post-game Recovery","Daily Training", "Pre-game Training", "Game Time", "Post-game Recovery"};
    String[] status = new String[] {"Working", "Finished","Finished","Finished","Finished","Finished","Finished","Finished"};
    private ArrayList<String> report = new ArrayList<>();
    private FloatingActionButton mFAB;

    EditText etTaskDate;
    Spinner spinner;
    int task_count = 0;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(activity_activities_tasks,container,false);

        listView = (ListView)view.findViewById(R.id.tasks_listView);

        final Context context = getActivity();

        SharedPreferences mSharedPreferences = context.getSharedPreferences("TasksRecord", MODE_PRIVATE);

        for (int i = 0; i < 4; i++) {
            String value = "Date:    "+date_list[i] + "\n\n"+ "Type:    " + type[i]+"\n\n" + "Status:  " + status[i]+"\n\n"+"Score:   100/100";
            report.add(value);
        }

        final ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, report);
        listView.setAdapter(arrayAdapter);

        for (int i = 0; i < task_count; i++)
        {
            arrayAdapter.add(mSharedPreferences.getString("task" + i, ""));
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), Task.class);
                // intent.putExtra("survey_no", position);
                startActivity(intent);
            }
        });

        mFAB = (FloatingActionButton) view.findViewById(R.id.tasks_add);
        mFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            AlertDialog.Builder rBuilder = new AlertDialog.Builder(getActivity());
            View mView = inflater.inflate(R.layout.activity_new_tasks_popup,null);

            etTaskDate = (EditText) mView.findViewById(R.id.task_date);
            spinner = (Spinner) mView.findViewById(R.id.newTasks_spinner);

            final Button bCreate = (Button) mView.findViewById(R.id.task_create);
            bCreate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    SharedPreferences mSharedPreferences = context.getSharedPreferences("TasksRecord", MODE_PRIVATE);
                    SharedPreferences.Editor mEditor = mSharedPreferences.edit();

                    String newDate = etTaskDate.getText().toString();
                    String newType = spinner.getSelectedItem().toString();

                    mEditor.putString("task" + task_count, "Date:    " + newDate + "\n\n" + "Type:    " + newType);
                    task_count++;

                    mEditor.apply();

                    String newTask = "Date:    " + newDate + "\n\n" + "Type:    " + newType;

                    Intent intent = new Intent(getActivity(), Activities.class);
                    intent.putExtra("new_task", newTask);
                    startActivity(intent);
                }
            });

            final Button bCancel = (Button) mView.findViewById(R.id.task_cancel);
            bCancel.setOnClickListener(new View.OnClickListener() {
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
