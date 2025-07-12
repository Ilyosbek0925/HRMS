package spring.hrms.service.emailService;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;

import java.security.SecureRandom;
import java.util.Properties;

public class EmailService {
    static Message message;
    @Value("${spring.mail.host}")
    private static String host;
    @Value("${spring.mail.password}")
    private static String password;
    @Value("${spring.mail.username}")
    private static String username;
    @Value("${spring.mail.port}")
    private static int port;
    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private static boolean smtpStarttlsEnable;
    @Value("${spring.mail.properties.mail.smtp.auth}")
    private static boolean smtpAuth;
    @Value("${spring.mail.properties.mail.smtp.starttls.required}")
    private static boolean smtpStarttlsRequired;


    static {

        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.ssl.enable", smtpStarttlsEnable);
        properties.put("mail.smtp.auth" , smtpAuth);
        Session session = Session.getInstance(properties,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        Message m = new MimeMessage(session);
        try {
            m.setSubject("application entrance code ");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        try {
            m.setFrom(new InternetAddress(username));
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        message = m;
    }

    public static String sendCode(String to) {

        SecureRandom secureRandom = new SecureRandom();
        String code = String.valueOf(secureRandom.nextInt(1000, 9999));
        System.out.println(to);
        try {
            message.setText("code : " + code);
            message.setSubject("Aplication entry code");
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException();
        }
        System.out.println("successful send");
        return code;
    }


}