/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sitebootstrap.managedbean;

import com.mycompany.sitebootstrap.service.ContatoServiceLocal;
import com.mycompany.sitebootstrap.util.Msg;
import java.util.Date;
import java.util.Properties;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author evani
 */
@Named(value = "contatoBean")
@RequestScoped
public class ContatoBean {
    
    @EJB
    private ContatoServiceLocal contatoService;
    /**
     * Creates a new instance of ContatoBean
     */
    private final String host = "smtp.gmail.com";
    private final String port = "587";
    private final String mailFrom = "evaniltobarros@gmail.com";
    private final String password  = "nnlhogtteepypwik"; //senha de aplicativo da conta google

    // outgoing message information
    private final String mailTo = "evaniltobarros@gmail.com";
    
    private String emailContato;
    private final String subject = "Contato do Site";
    private String message;

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String enviarEmail() {
        // SMTP server information

        try {
             contatoService.sendPlainTextEmail(host, port, mailFrom, password, mailTo,
                    subject, message, emailContato);
            //System.out.println("Email sent.");
            Msg.adicionarMsg("Info", "Mensagem enviada com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (Exception ex) {
            //System.out.println("Failed to sent email.");
            //ex.printStackTrace();
            //Msg.adicionarMsg(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
            Msg.adicionarMsg(ex.getMessage(), (ex.getCause() != null ? ex.getCause().getMessage() : ex.getMessage()), FacesMessage.SEVERITY_ERROR);
        }
        //return "success";
        return null;
    }

}
