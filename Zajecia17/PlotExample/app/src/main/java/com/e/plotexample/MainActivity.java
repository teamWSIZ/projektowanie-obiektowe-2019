package com.e.plotexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GraphView graph = findViewById(R.id.graph);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();

        double x0 = 0;
        double y0 = fun(x0);
        double xmax = 10;
        double dx = 0.1;

        for (double x = x0; x <= xmax; x += dx) {
            double y = fun(x);

            series.appendData(new DataPoint(x, y), false, 100);
        }

        graph.addSeries(series);
    }

    double fun(double x) {
        return x * x;
    }
}
