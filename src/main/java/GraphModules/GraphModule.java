//package GraphModules;
//
//import MathModules.Function;
//import MathModules.FunctionSystem;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.chart.plot.XYPlot;
//import org.jfree.chart.renderer.xy.XYSplineRenderer;
//import org.jfree.data.xy.XYSeries;
//import org.jfree.data.xy.XYSeriesCollection;
//
//import javax.swing.*;
//import java.awt.*;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class GraphModule {
//    Function function = new Function();
//    FunctionSystem functionSystem = new FunctionSystem();
//
//    public void drawFunction(int number, String functionString){
//
//        final XYSeries series = new XYSeries(functionString);
//        for (int x=-70; x<=70;x+=0.1){
//            series.add(x,function.getFunction(number,x));
//        }
//
//        XYSeriesCollection collection= new XYSeriesCollection();
//        collection.addSeries(series);
//
//        final JFreeChart chart = ChartFactory.createBarChart(
//                "lab2",
//                "x",
//                "y",
//                null,
//                PlotOrientation.VERTICAL,
//                true,
//                false,
//                false);
//
//        final XYPlot plot = chart.getXYPlot();
//        plot.getDomainAxis().setRange(-5, 5);
//        plot.getRangeAxis().setRange(-5, 5);
//        plot.setDomainZeroBaselineVisible(true);
//        plot.setRangeZeroBaselineVisible(true);
//
//        plot.setDataset(0,collection);
//
//        JFrame jf = new JFrame();
//        jf.setContentPane(new ChartPanel(chart));
//        jf.pack();
//        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jf.setVisible(true);
//    }
//
//
//    public void drawFunctionSystem(int number, String function1, String function2){
//        List<XYSeries> series = new ArrayList<>(4);
//        series.add(new XYSeries(function1));
//        series.add(new XYSeries(function2));
//
//        for (double x = -70; x < 70; x += 0.1) {
//            series.get(0).add(x, functionSystem.getFunction(number, x)[0]);
//            series.get(1).add(x, functionSystem.getFunction(number, x)[1]);
//        }
//
//        XYSeriesCollection collection = new XYSeriesCollection();
//
//        for (XYSeries s : series) {
//            collection.addSeries(s);
//        }
//
//        final JFreeChart chart = ChartFactory.createXYLineChart(
//                "System Graph",
//                "X1",                        // x axis label
//                "X2",                        // y axis label
//                null,                        // data
//                PlotOrientation.VERTICAL,
//                true,                        // include legend
//                false,                       // tooltips
//                false                        // urls
//        );
//
//        final XYPlot plot = chart.getXYPlot();
//
//        plot.getDomainAxis().setRange(-5, 5);
//        plot.getRangeAxis().setRange(-5, 5);
//        plot.setDomainZeroBaselineVisible(true);
//        plot.setRangeZeroBaselineVisible(true);
//
//        XYSplineRenderer r = new XYSplineRenderer();
//        r.setSeriesShapesVisible(0, false);
//        r.setSeriesShapesVisible(1, false);
//        r.setSeriesLinesVisible(0, true);
//        r.setSeriesLinesVisible(1, true);
//
//        r.setSeriesPaint(0, Color.RED);
//        r.setSeriesPaint(1, Color.BLUE);
//
//        plot.setDataset(0, collection);
//        plot.setRenderer(r);
//
//        JFrame jf = new JFrame();
//        jf.setContentPane(new ChartPanel(chart));
//        jf.pack();
//        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jf.setVisible(true);
//    }
//
//}
package GraphModules;

import MathModules.Function;
import MathModules.FunctionSystem;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

public class GraphModule {
    private final int number;

    public GraphModule(int number) {
        this.number = number;
    }

    public void drawGraphFunction(String fStr) {
        final XYSeries series1 = new XYSeries(fStr);
        for (double x = -50; x <= 50; x += 0.1) {
            series1.add(x, Function.getFunction(number, x));
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);


        final JFreeChart chart = ChartFactory.createXYLineChart(
                "Function Graph",
                "X",                        // x axis label
                "Y",                        // y axis label
                null,                        // data
                PlotOrientation.VERTICAL,
                true,                        // include legend
                false,                       // tooltips
                false                        // urls
        );


        final XYPlot plot = chart.getXYPlot();
        plot.getDomainAxis().setRange(-5, 5);
        plot.getRangeAxis().setRange(-5, 5);
        plot.setDomainZeroBaselineVisible(true);
        plot.setRangeZeroBaselineVisible(true);

        plot.setDataset(0, dataset);

        JFrame jf = new JFrame();
        jf.setContentPane(new ChartPanel(chart));
        jf.pack();
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }


    public void drawGraphSystem(String f1, String f2) {

        List<XYSeries> series = new ArrayList<>(4);
        series.add(new XYSeries(f1));
        series.add(new XYSeries(f2));

        for (double x = -50; x < 50; x += 0.1) {
            series.get(0).add(x, FunctionSystem.getFunction(number, x)[0]);
            series.get(1).add(x, FunctionSystem.getFunction(number, x)[1]);
        }


        XYSeriesCollection dataset = new XYSeriesCollection();

        for (XYSeries s : series) {
            dataset.addSeries(s);
        }

        final JFreeChart chart = ChartFactory.createXYLineChart(
                "System Graph",
                "X1",                        // x axis label
                "X2",                        // y axis label
                null,                        // data
                PlotOrientation.VERTICAL,
                true,                        // include legend
                false,                       // tooltips
                false                        // urls
        );

        final XYPlot plot = chart.getXYPlot();

        plot.getDomainAxis().setRange(-5, 5);
        plot.getRangeAxis().setRange(-5, 5);
        plot.setDomainZeroBaselineVisible(true);
        plot.setRangeZeroBaselineVisible(true);

        XYSplineRenderer r = new XYSplineRenderer();
        r.setSeriesShapesVisible(0, false);
        r.setSeriesShapesVisible(1, false);
        r.setSeriesLinesVisible(0, true);
        r.setSeriesLinesVisible(1, true);

        r.setSeriesPaint(0, Color.RED);
        r.setSeriesPaint(1, Color.BLUE);

        plot.setDataset(0, dataset);
        plot.setRenderer(r);

        JFrame jf = new JFrame();
        jf.setContentPane(new ChartPanel(chart));
        jf.pack();
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}
