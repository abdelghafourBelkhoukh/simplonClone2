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
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        if (role.equals("apprenant")) {
            Apprenant apprenant = new Apprenant();
            com.simplonclone.simplonclone2.entity.Apprenant apprenant1 = apprenant.auth(email, password);
            if (apprenant1 == null) {
                //redirect to login page
                response.sendRedirect("login.jsp");
            }
            //set session
            HttpSession session = request.getSession();
            session.setAttribute("apprenant", apprenant1);

            response.sendRedirect("/ApprenantServlet");

        } else if (role.equals("formateur")) {
            Formateur formateur = new Formateur();
            if (formateur.auth(email, password) == null) {
                //redirect to login page
                response.sendRedirect("login.jsp");
            }

            response.sendRedirect("/FormateurServlet");

        } else if (role.equals("admin")) {
            Admin admin = new Admin();
            if (admin.auth(email, password) == null) {
                //redirect to login page
                response.sendRedirect("login.jsp");
            }
            response.sendRedirect("/AdminServlet");
        } else {
            response.sendRedirect("index.jsp");
        }


    }
}
