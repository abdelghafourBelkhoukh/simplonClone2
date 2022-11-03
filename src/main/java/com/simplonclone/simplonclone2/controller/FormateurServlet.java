package com.simplonclone.simplonclone2.controller;

import com.simplonclone.simplonclone2.dao.BriefDao;
import com.simplonclone.simplonclone2.dao.FormateurDao;
import com.simplonclone.simplonclone2.entity.Brief;
import com.simplonclone.simplonclone2.entity.Formateur;
import com.simplonclone.simplonclone2.entity.Promos;
import com.simplonclone.simplonclone2.services.Apprenant;
import com.simplonclone.simplonclone2.services.SendEmail;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FormateurServlet", value = "/FormateurServlet")
public class FormateurServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            com.simplonclone.simplonclone2.services.Apprenant apprenant = new com.simplonclone.simplonclone2.services.Apprenant();
            ArrayList<com.simplonclone.simplonclone2.entity.Apprenant> apprenants = (ArrayList<com.simplonclone.simplonclone2.entity.Apprenant>) apprenant.getAll();
            request.setAttribute("apprenants", apprenants);

            com.simplonclone.simplonclone2.services.Promo promo = new com.simplonclone.simplonclone2.services.Promo();
            ArrayList<Promos> promos = (ArrayList<Promos>) promo.getAll();
            request.setAttribute("promos", promos);

            com.simplonclone.simplonclone2.services.Brief brief = new com.simplonclone.simplonclone2.services.Brief();
            ArrayList<com.simplonclone.simplonclone2.entity.Brief> briefs = (ArrayList<com.simplonclone.simplonclone2.entity.Brief>) brief.getAll();
            request.setAttribute("briefs", briefs);

            request.getRequestDispatcher("pages/formateur.jsp").forward(request, response);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            switch (request.getParameter("action")) {
                case "addBrief":
                    String title = request.getParameter("title");
                    String description = request.getParameter("description");

                    Brief brief = new Brief();
                    brief.setName(title);
                    brief.setDescription(description);
                    BriefDao briefDao = new BriefDao();
                    briefDao.create(brief);
                    response.sendRedirect("/FormateurServlet");
                    break;
                case "assignBriefToPromo":
                    int promoId = Integer.parseInt(request.getParameter("promoId"));
                    int briefId = Integer.parseInt(request.getParameter("briefId"));
                    com.simplonclone.simplonclone2.services.Brief briefService = new com.simplonclone.simplonclone2.services.Brief();
                    briefService.assignBriefToPromo(promoId, briefId);
                    new SendEmail(promoId);
                    response.sendRedirect("/FormateurServlet");
                    break;
                case "assignApprenantToPromo":
                    int apprenantId = Integer.parseInt(request.getParameter("apprenantId"));
                    int promoId1 = Integer.parseInt(request.getParameter("promoId"));
                    Apprenant apprenant1 = new Apprenant();
                    apprenant1.assignToPromo(apprenantId, promoId1);
                    response.sendRedirect("/FormateurServlet");
                    break;
            }
    }
}
