package com.simplonclone.simplonclone2.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.simplonclone.simplonclone2.services.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RenduServlet", value = "/RenduServlet")
public class RenduServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("role") == "apprenant" || request.getSession().getAttribute("role") == "formateur") {
            try {
                getBriefs(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else {
            response.sendRedirect("pages/error505.jsp");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("role") == "apprenant") {
            System.out.println("hello apprenant");
            if (request.getParameter("action").equals("addRendu")) {

                    String message = request.getParameter("message");
                    int promoId = (int) request.getSession().getAttribute("promoId");
                    int briefId = Integer.parseInt(request.getParameter("briefId"));
                    int apprenantId = (int) request.getSession().getAttribute("id");
                    Rendus rendus = new Rendus();
                    rendus.addRendu(message, promoId, briefId, apprenantId);
                    SendEmail sendEmail = new SendEmail();
                    sendEmail.sendEmailToFormateur(promoId, briefId, apprenantId);
                    response.sendRedirect("/RenduServlet");

            }

            if (request.getParameter("action").equals("getRendus")) {
                getAllRendus(request, response);

            }
        } else if (request.getSession().getAttribute("role") == "formateur") {
            System.out.println("hello formateur");
            if (request.getParameter("action").equals("getRendus")) {
               getAllRendus(request, response);

            }
        } else {
            response.sendRedirect("pages/error505.jsp");

        }




    }

    private void getAllRendus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int briefId = Integer.parseInt(request.getParameter("briefId"));
        int promoId = Integer.parseInt(request.getParameter("promoId"));
        int apprenantId = request.getSession().getAttribute("apprenant") != null ? ((com.simplonclone.simplonclone2.entity.Apprenant) request.getSession().getAttribute("apprenant")).getId() : 0;
        Rendus rendus = new Rendus();
        ArrayList<com.simplonclone.simplonclone2.entity.Rendus> renduList =  rendus.getAll(briefId, promoId, apprenantId);
        request.setAttribute("renduList", renduList);
        getBriefs(request, response);
    }

    private void getBriefs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        com.simplonclone.simplonclone2.services.Brief brief = new com.simplonclone.simplonclone2.services.Brief();
        int promoId = (int) request.getSession().getAttribute("promoId");
        ArrayList<com.simplonclone.simplonclone2.entity.Brief> briefs = brief.getAll(promoId);
        request.setAttribute("briefs", briefs);
        switch (request.getSession().getAttribute("role").toString()) {
            case "apprenant":
                request.getRequestDispatcher("pages/rendus.jsp").forward(request, response);
                break;
            case "formateur":
                request.getRequestDispatcher("pages/formateurRendus.jsp").forward(request, response);
                break;
            default:
                response.sendRedirect("pages/error505.jsp");
                break;
        }
    }
}
