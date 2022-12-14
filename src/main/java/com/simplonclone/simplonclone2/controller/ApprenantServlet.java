package com.simplonclone.simplonclone2.controller;

import com.simplonclone.simplonclone2.entity.Apprenant;
import com.simplonclone.simplonclone2.entity.Brief;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ApprenantServlet", value = "/ApprenantServlet")
public class ApprenantServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            if (request.getSession().getAttribute("role") != "apprenant") {
                response.sendRedirect("pages/error505.jsp");
            }else {
                try {
                    com.simplonclone.simplonclone2.services.Brief brief = new com.simplonclone.simplonclone2.services.Brief();
                    int promoId = (int) request.getSession().getAttribute("promoId");
                    ArrayList<Brief> briefs = brief.getAll(promoId);
                    request.setAttribute("briefs", briefs);
                    request.getRequestDispatcher("pages/apprenant.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




    }
}
