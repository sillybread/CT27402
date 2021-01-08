package com.example.hw1_toan_b1704780;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import java.util.List;

public class BarChart6 extends AppCompatActivity {
    int COUNT = 6;
    BarChart mChart;
    TextView textView;
    String Title;
    BarData databar;
    double amountbar1,amountbar2,amountbar3,amountbar4,amountbar5,amountbar6,amountbar7,amountbar8,amountbar9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart3);
        textView = (TextView) findViewById(R.id.texViewBar);
        // Khai báo gia diện đồ thị BarCharts
        mChart = findViewById(R.id.BarChartMpAndroid);
        // Khai báo Intent và lấy dữ liệu từ BarChartsActivity gởi đến.
        Intent intent = getIntent();
        amountbar1 = intent.getDoubleExtra("cot1", 123);
        amountbar2 = intent.getDoubleExtra("cot2", 123);
        amountbar3 = intent.getDoubleExtra("cot3", 123);
        amountbar4 = intent.getDoubleExtra("cot4", 123);
        amountbar5 = intent.getDoubleExtra("cot5", 123);
        amountbar6 = intent.getDoubleExtra("cot6", 123);
        amountbar7 = intent.getDoubleExtra("cot7", 123);
        amountbar8 = intent.getDoubleExtra("cot8", 123);
        amountbar9 = intent.getDoubleExtra("cot9", 123);

        Title = intent.getStringExtra("tendothi"); // Lấy tên đố thị
        // Hiển thị tên đồ thị và tên các cộ
        textView.setText("Đồ thị: " + Title); // Hiển thị tên đồ thị
        // Đặt các thuộc tính của đồ thị
        mChart.setDrawBarShadow(false);
        mChart.setDrawValueAboveBar(true);
        mChart.getDescription().setEnabled(false);
        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        mChart.setMaxVisibleValueCount(60);
        // scaling can now only be done on x- and y-axis separately
        mChart.setPinchZoom(false);
        mChart.setDrawGridBackground(false);
        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(15);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // only intervals of 1 day
        xAxis.setLabelCount(7);
        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setLabelCount(8, false);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setTextSize(15);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setLabelCount(8, false);
        rightAxis.setTextSize(15);
        rightAxis.setSpaceTop(15f);
        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        Legend l = mChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setForm(Legend.LegendForm.SQUARE);
        l.setFormSize(9f);
        l.setTextSize(11f);
        l.setXEntrySpace(4f);
        setDataBar(COUNT, 100);
        mChart.setData(databar); //Đã khai báo ở trên BarData databar3;
        mChart.setVisibility(View.VISIBLE);
        mChart.invalidate();
    }
    private void setDataBar(int count, float range) {
        XAxis xAxis= mChart.getXAxis();
        xAxis.setGranularity(1f);
        float start = 1f;
        Double[] Y3={amountbar1,amountbar2,amountbar3,amountbar4,amountbar5,amountbar6,amountbar7,amountbar8,amountbar9};
        ArrayList<BarEntry> yVals3 = new ArrayList<>();
        for (int i = 0; i < count ; i++) {
            double mult = (range);
            double val3 = (double) (Y3[i]);
            yVals3.add(new BarEntry(i+1, (float)(val3)));
        }
        BarDataSet set1;
        set1 = new BarDataSet(yVals3, "The year 2019");
        set1.setColors(ColorTemplate.MATERIAL_COLORS);
        int startColor1 = ContextCompat.getColor(this, android.R.color.holo_orange_light);
        int startColor2 = ContextCompat.getColor(this, android.R.color.holo_blue_light);
        int startColor3 = ContextCompat.getColor(this, android.R.color.holo_green_light);
        int startColor4 = ContextCompat.getColor(this, android.R.color.holo_purple);
        int startColor5 = ContextCompat.getColor(this, android.R.color.darker_gray);
        int startColor6 = ContextCompat.getColor(this, android.R.color.holo_green_dark);
        int startColor7 = ContextCompat.getColor(this, android.R.color.holo_orange_dark);
        int startColor8 = ContextCompat.getColor(this, android.R.color.holo_red_light);
        int startColor9 = ContextCompat.getColor(this, android.R.color.holo_blue_dark);

        List<Integer> gradientColors = new ArrayList<>();
        gradientColors.add(0, startColor1);
        gradientColors.add(1, startColor2);
        gradientColors.add(2, startColor3);
        gradientColors.add(3, startColor3);
        gradientColors.add(4, startColor3);
        gradientColors.add(5, startColor3);
        gradientColors.add(6, startColor3);
        gradientColors.add(7, startColor3);
        gradientColors.add(8, startColor3);
        set1.setColors(gradientColors);
        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);
        databar = new BarData(dataSets);
        databar.setValueTextSize(15f);
        databar.setBarWidth(0.5f);
    }
}