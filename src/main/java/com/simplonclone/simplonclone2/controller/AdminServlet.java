package com.simplonclone.simplonclone2.controller;

import com.simplonclone.simplonclone2.entity.Promos;
import com.simplonclone.simplonclone2.services.Apprenant;
import com.simplonclone.simplonclone2.services.Formateur;
import com.simplonclone.simplonclone2.services.Promo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {

    String firstname ;
    String lastname ;
    String email ;
    String password ;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            com.simplonclone.simplonclone2.services.Apprenant apprenant = new com.simplonclone.simplonclone2.services.Apprenant();
            ArrayList<com.simplonclone.simplonclone2.entity.Apprenant> apprenants = (ArrayList<com.simplonclone.simplonclone2.entity.Apprenant>) apprenant.getAll();
            request.setAttribute("apprenants", apprenants);

            com.simplonclone.simplonclone2.services.Formateur formateur = new com.simplonclone.simplonclone2.services.Formateur();
            ArrayList<com.simplonclone.simplonclone2.entity.Formateur> formateurs = (ArrayList<com.simplonclone.simplonclone2.entity.Formateur>) formateur.getAll();
            request.setAttribute("formateurs", formateurs);

            com.simplonclone.simplonclone2.services.Promo promo = new com.simplonclone.simplonclone2.services.Promo();
            ArrayList<Promos> promos = (ArrayList<Promos>) promo.getAll();
            request.setAttribute("promos", promos);

            request.getRequestDispatcher("pages/admin.jsp").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        switch (request.getParameter("action")) {
            case "addPromo":

                String name = request.getParameter("name");

                Promo promo = new Promo();
                promo.create(name);
                response.sendRedirect("/AdminServlet");

                break;
            case "addFormateur":

                getUserInfo(request);
                Formateur formateur = new Formateur();
                formateur.create(firstname, lastname, email, password);
                response.sendRedirect("/AdminServlet");

                break;
            case "addApprenant":

                getUserInfo(request);
                Apprenant apprenant = new Apprenant();
                apprenant.create(firstname, lastname, email, password);
                response.sendRedirect("/AdminServlet");

                break;
            case "assignFormateurToPromo":
                int formateurId = Integer.parseInt(request.getParameter("formateurId"));
                int promoId = Integer.parseInt(request.getParameter("promoId"));
                Formateur formateur1 = new Formateur();
                formateur1.assignToPromo(formateurId, promoId);
                response.sendRedirect("/AdminServlet");
                break;

            case "assignApprenantToPromo":
                int apprenantId = Integer.parseInt(request.getParameter("apprenantId"));
                int promoId1 = Integer.parseInt(request.getParameter("promoId"));
                Apprenant apprenant1 = new Apprenant();
                apprenant1.assignToPromo(apprenantId, promoId1);
                response.sendRedirect("/AdminServlet");
                break;
        }
    }

    private void getUserInfo(HttpServletRequest request){
        this.firstname = request.getParameter("firstname");
        this.lastname = request.getParameter("lastname");
        this.email = request.getParameter("email");
        this.password = request.getParameter("password");
    }
}
