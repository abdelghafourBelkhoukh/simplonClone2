package com.simplonclone.simplonclone2.services;


import com.simplonclone.simplonclone2.dao.BriefDao;
import com.simplonclone.simplonclone2.dao.PromoDao;
import com.simplonclone.simplonclone2.entity.Brief;
import com.simplonclone.simplonclone2.entity.Promos;
import models.SendEnhancedRequestBody;
import models.SendEnhancedResponseBody;
import models.SendRequestMessage;
import services.Courier;
import services.SendService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SendEmail {

    public SendEmail(int promoId) {
        Apprenant apprenant = new Apprenant();
        ArrayList<com.simplonclone.simplonclone2.entity.Apprenant> apprenants = apprenant.getApprenantById(promoId);
        for (com.simplonclone.simplonclone2.entity.Apprenant apprenant1 : apprenants) {
            String to = apprenant1.getEmail();
            String subject = "New Brief";
            String message = "Bonjour " + apprenant1.getFirstname() + " " + apprenant1.getLastname() + ",\n" +
                    "Vous avez un nouveau brief à lire.\n" +
                    "Cordialement,\n" +
                    "L'équipe SimplonClone";
            SendEmail.send(to, subject, message);

        }


    }
    public SendEmail() {


    }

    private static void send(String email, String subject, String message) {
        System.out.println(subject);
        System.out.println(email);
        System.out.println(message);
        System.out.println("--------------------------");
        Courier.init("pk_prod_YFX88J0RXZM3WRQ2M0FTHWF4BMV7");

        SendEnhancedRequestBody sendEnhancedRequestBody = new SendEnhancedRequestBody();
        SendRequestMessage sendRequestMessage = new SendRequestMessage();
        HashMap<String, String> to = new HashMap<String, String>();
        to.put("email", email);
        sendRequestMessage.setTo(to);

        HashMap<String, String> content = new HashMap<String, String>();
        content.put("title", subject);
        content.put("body", message);
        sendRequestMessage.setContent(content);

        sendEnhancedRequestBody.setMessage(sendRequestMessage);

        try {
            SendEnhancedResponseBody response = new SendService().sendEnhancedMessage(sendEnhancedRequestBody);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void sendEmailToFormateur(int promoId, int briefId, int apprenantId) {
        Formateur formateur = new Formateur();
        int formateurId = formateur.getFormateurId(promoId);
        Brief brief = getBriefById(briefId);
        Apprenant apprenant = new Apprenant();
        com.simplonclone.simplonclone2.entity.Apprenant apprenant1 = apprenant.getOneApprenantById(apprenantId);
        String to = formateur.getFormateurEmail(formateurId);
        String subject = "New Rendu";
        String message = "Bonjour,\n" +
                "L'apprenant " + apprenant1.getFirstname() + " " + apprenant1.getLastname() + " a rendu le brief " + brief.getName() + ".\n" +
                "Cordialement,\n" +
                "L'équipe SimplonClone";
        SendEmail.send(to, subject, message);
    }

    private Brief getBriefById(int briefId) {
        BriefDao briefDao = new BriefDao();
        return briefDao.getOne(briefId);
    }
}
