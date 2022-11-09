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
        if (request.getSession().getAttribute("role") != "apprenant") {
            response.sendRedirect("pages/error505.jsp");
        }else {
            try {
                getBriefs(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("action").equals("addRendu")) {
            if (request.getSession().getAttribute("role").equals("apprenant")) {
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

        }

        if (request.getParameter("action").equals("getRendus")) {
            int briefId = Integer.parseInt(request.getParameter("briefId"));
            int promoId = Integer.parseInt(request.getParameter("promoId"));
            int apprenantId = request.getSession().getAttribute("apprenant") != null ? ((com.simplonclone.simplonclone2.entity.Apprenant) request.getSession().getAttribute("apprenant")).getId() : 0;
            Rendus rendus = new Rendus();
            ArrayList<com.simplonclone.simplonclone2.entity.Rendus> renduList = (ArrayList<com.simplonclone.simplonclone2.entity.Rendus>) rendus.getAll(briefId, promoId, apprenantId);
            request.setAttribute("renduList", renduList);
            getBriefs(request, response);

        }


    }

    private void getBriefs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        com.simplonclone.simplonclone2.services.Brief brief = new com.simplonclone.simplonclone2.services.Brief();
        ArrayList<com.simplonclone.simplonclone2.entity.Brief> briefs = (ArrayList<com.simplonclone.simplonclone2.entity.Brief>) brief.getAll((com.simplonclone.simplonclone2.entity.Apprenant) request.getSession().getAttribute("apprenant"));
        request.setAttribute("briefs", briefs);
        request.getRequestDispatcher("pages/rendus.jsp").forward(request, response);
    }
}
