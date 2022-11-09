package com.simplonclone.simplonclone2.controller;

import com.simplonclone.simplonclone2.services.Admin;
import com.simplonclone.simplonclone2.services.Apprenant;
import com.simplonclone.simplonclone2.services.Formateur;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AuthServlet", value = "/AuthServlet")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("action").equals("logout")) {
            request.getSession().invalidate();
            response.sendRedirect("pages/login.jsp");
        }else {

            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String role = request.getParameter("role");

            if (role.equals("apprenant")) {
                Apprenant apprenant = new Apprenant();
                System.out.println("apprenant");
                com.simplonclone.simplonclone2.entity.Apprenant apprenant1 = apprenant.auth(email, password);
                if (apprenant1 == null) {
                    //redirect to login page
                    response.sendRedirect("pages/login.jsp");
                }

                HttpSession session = request.getSession();
                session.setAttribute("apprenant", apprenant1);
                session.setAttribute("id", apprenant1.getId());
                session.setAttribute("promoId", apprenant1.getPromoId());
                session.setAttribute("role", "apprenant");
                session.setAttribute("firstName", apprenant1.getFirstname());
                session.setAttribute("lastName", apprenant1.getLastname());
                session.setAttribute("email", apprenant1.getEmail());

                response.sendRedirect("/ApprenantServlet");

            } else if (role.equals("formateur")) {
                Formateur formateur = new Formateur();
                com.simplonclone.simplonclone2.entity.Formateur formateur1 = formateur.auth(email, password);
                if (formateur1 == null) {
                    //redirect to login page
                    response.sendRedirect("pages/login.jsp");
                }

                HttpSession session = request.getSession();
                session.setAttribute("formateur", formateur1);
                session.setAttribute("role", "formateur");
                session.setAttribute("firstName", formateur1.getFirstname());
                session.setAttribute("lastName", formateur1.getLastname());
                session.setAttribute("email", formateur1.getEmail());

                response.sendRedirect("/FormateurServlet");

            } else if (role.equals("admin")) {
                Admin admin = new Admin();
                com.simplonclone.simplonclone2.entity.Admin admin1 = admin.auth(email, password);

                if (admin1 == null) {
                    //redirect to login page
                    response.sendRedirect("pages/login.jsp");
                }

                HttpSession session = request.getSession();
                session.setAttribute("admin", admin1);
                session.setAttribute("role", "admin");
                session.setAttribute("firstName", admin1.getFirstname());
                session.setAttribute("lastName", admin1.getLastname());
                session.setAttribute("email", admin1.getEmail());


                response.sendRedirect("/AdminServlet");
            } else {
                response.sendRedirect("index.jsp");
            }

        }
    }
}
