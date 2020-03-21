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

        LineGraphSeries<DataPoint> seriesN = new LineGraphSeries<>();
        LineGraphSeries<DataPoint> seriesN1 = new LineGraphSeries<>();

        int n=10;
        int n1 = 10;

        int maxDni = 20;

        for(int i=0;i<maxDni;i++){
            n = evaluate(n,1.2);
            n1 = evaluate(n1,1.3);

            seriesN.appendData(new DataPoint(i,n),false,1000);
            seriesN1.appendData(new DataPoint(i,n1),false,1000);
        }

        infoView.setText("Liczba przypadków przy izolacji: "+n+" po "+maxDni+" dniach");
        infoView2.setText("Liczba przypadków: "+n1+" po "+maxDni+" dniach");

        graph.addSeries(seriesN);
        graph.addSeries(seriesN1);

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(n1);
    }

    double fun(double x) {
        return x * x;
    }

    int evaluate(int n, double speed){
        return (int)(speed*n);
    }
}
