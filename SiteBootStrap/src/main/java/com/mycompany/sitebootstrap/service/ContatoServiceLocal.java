/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sitebootstrap.service;

import javax.ejb.Local;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

/**
 *
 * @author evani
 */
@Local
public interface ContatoServiceLocal {
    
    public void sendPlainTextEmail(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message, String emailContato) throws AddressException,
            MessagingException;
    
}
