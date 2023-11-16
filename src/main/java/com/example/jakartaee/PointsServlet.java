package com.example.jakartaee;

import com.example.jakartaee.logic.Main;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "points-servlet", value = "/points-servlet")
public class PointsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double start = Double.parseDouble(request.getParameter("start"));
        double end = Double.parseDouble(request.getParameter("end"));
        double step = Double.parseDouble(request.getParameter("step"));

        Main main = new Main(start, end, step);

        request.setAttribute("main", main);
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
