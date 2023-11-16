package com.example.jakartaee.logic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Main {

    private double start;
    private double end;
    private double step;


    //Function for variant 1
    public double fx(double x) {
        DecimalFormat df = new DecimalFormat("0.000");
        double a = (-0.5);
        double b = 2;
        double res = 0;

        if (x > 0.7 && x <= 1.4) {
            res = a * Math.pow(x, 2) * Math.log(x);
            if (Double.compare(res, -0.0) == 0) res = 0.0;
        } else if (x <= 0.7) {
            res = 1.0;
        } else if (x > 1.4) {
            res = Math.pow(Math.E, a * x) * Math.cos(b * x);
        }
        return Double.parseDouble(df.format(res));
    }

    public int getSize(double start, double end, double step) {
        return (int) Math.round((end - start) / step) + 1;
    }

    public List<Point> collectPointsOnSegment(double start, double end, double step) {
        int size = getSize(start, end, step);
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            double x = start + i * step;
            double y = fx(x);
            points.add(new Point(x, y));
        }
        return points;
    }

    public List<Point> getPoints() {
        return collectPointsOnSegment(start, end, step);
    }

    public Point max() {
        List<Point> points = getPoints();
        int numOfMaxE = getNumOfMaxE(points);

        return points.get(numOfMaxE);
    }

    public Point min() {
        List<Point> points = getPoints();
        int numOfMaxE = getNumOfMinE(points);

        return points.get(numOfMaxE);
    }


    public int getNumOfMaxE(List<Point> points) {
        double max = Double.MIN_VALUE;
        int num = 0;
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).y() > max) {
                max = points.get(i).y();
                num = i;
            }
        }
        return num;
    }

    public int getNumOfMinE(List<Point> points) {
        double min = Double.MAX_VALUE;
        int num = 0;
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).y() < min) {
                min = points.get(i).y();
                num = i;
            }
        }
        return num;
    }

    public double countSumOfFx(List<Point> points) {
        return points.stream()
                .mapToDouble(Point::y)
                .sum();
    }

    public double countArithmeticAverage(List<Point> points) {
        return countSumOfFx(points) / points.size();
    }

    public String printMaxPoint(List<Point> points) {
        int numOfMaxE = getNumOfMaxE(points);
        Point point = points.get(numOfMaxE);
        return String.format("Max f(x) is %d element of the list. f(x) = %.3f, x = %.3f",
                numOfMaxE,
                point.y(),
                point.x());
    }

    public String printMinPoint(List<Point> points) {
        int numOfMinE = getNumOfMinE(points);
        Point point = points.get(numOfMinE);
        return String.format("Min f(x) is %d element of the list. f(x) = %.3f, x = %.3f",
                numOfMinE,
                point.y(),
                point.x());
    }
}