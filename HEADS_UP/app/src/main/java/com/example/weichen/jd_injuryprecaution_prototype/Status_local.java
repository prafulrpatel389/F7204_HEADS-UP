package com.example.weichen.jd_injuryprecaution_prototype;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Status_local extends Fragment {

    EditText zipcode;
    TextView rank, text;
    Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_status_local,container,false);

        rank = (TextView) view.findViewById(R.id.local_rank);

        text = (TextView) view.findViewById(R.id.local_text);

        zipcode = (EditText) view.findViewById(R.id.local_input);

        button = (Button)view.findViewById(R.id.local_check);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.local_check:
                        String _groupName = zipcode.getText().toString();

                        if (_groupName.length() == 5) {
                            rank.setText("1");
                            text.setText("You are 0% higher then averages of " + _groupName);
                        } else {
                            zipcode.setError("Zip code does not exit.");
                        }
                        break;
                }
            }
        });

        return view;
    }
}
