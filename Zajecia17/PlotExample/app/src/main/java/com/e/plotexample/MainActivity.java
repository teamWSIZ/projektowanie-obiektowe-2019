package com.e.plotexample;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {

    TextView infoView;
    TextView infoView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GraphView graph = findViewById(R.id.graph);
        infoView = findViewById(R.id.textView);
        infoView2 = findViewById(R.id.textView2);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();

        double x0 = 0;
        double y0 = fun(x0);
        double xmax = 10;
        double dx = 0.1;

        for (double x = x0; x <= xmax; x += dx) {
            double y = fun(x);

            series.appendData(new DataPoint(x, y), false, 100);
        }

        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(y0);
        graph.getViewport().setMaxY(fun(xmax));

        graph.addSeries(series);

        int n=10;
        int n1 = 10;

        for(int i=0;i<20;i++){
            n = evaluate(n,1.1);
            n1 = evaluate(n1,1.5);
        }

        infoView.setText("Liczba przypadków przy izolacji: "+n);
        infoView2.setText("Liczba przypadków: "+n1);
    }

    double fun(double x) {
        return x * x;
    }

    int evaluate(int n, double speed){
        return (int)(speed*n);
    }
}
