package com.simplonclone.simplonclone2.controller;

import com.simplonclone.simplonclone2.dao.BriefDao;
import com.simplonclone.simplonclone2.services.Brief;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "BriefServlet", value = "/BriefServlet")
public class BriefServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
