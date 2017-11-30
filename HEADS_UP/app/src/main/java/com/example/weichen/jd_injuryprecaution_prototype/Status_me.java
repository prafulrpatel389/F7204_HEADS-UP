package com.example.weichen.jd_injuryprecaution_prototype;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;

public class Status_me extends Fragment {

    int score;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_status_me,container,false);

        BarChart barChart = (BarChart) view.findViewById(R.id.chart);

        barChart.setDrawGridBackground(false);


        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(1, 23));
        entries.add(new BarEntry(2, 17));
        entries.add(new BarEntry(3, 23));
        entries.add(new BarEntry(4, 34));
        entries.add(new BarEntry(5, 34));
        entries.add(new BarEntry(6, 25));
        entries.add(new BarEntry(7, 10));
        entries.add(new BarEntry(8, 10));
        entries.add(new BarEntry(9, 21));
        entries.add(new BarEntry(10, 30));
        entries.add(new BarEntry(11, 19));

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user_pass", Context.MODE_PRIVATE);
        score = sharedPreferences.getInt("score", 0);

        entries.add(new BarEntry(12, score));

        BarDataSet dataset = new BarDataSet(entries, "Scores in current year. ");


        String[] months = new String[]{"Jan","Feb","Mar","April","May","June","July","Aug","Sept","Oct","Nov","Dec","","",""};
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter((new myXAisValueFormatter(months)));
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        xAxis.setGranularity(1);
        xAxis.setCenterAxisLabels(true);
        xAxis.setAxisMinimum(1);


        BarData data = new BarData(dataset);
        barChart.setData(data);
        barChart.animateY(5000);

        return view;
    }



    public class myXAisValueFormatter implements IAxisValueFormatter{

        private String[] mValues;
        public myXAisValueFormatter(String[] values){
            this.mValues = values;


        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mValues[(int)value];
        }
    }
}