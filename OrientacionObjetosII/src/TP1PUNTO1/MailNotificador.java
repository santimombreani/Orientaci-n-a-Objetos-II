/*
package TP1PUNTO1;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class MailNotificador implements INotificador {

    private final String username;
    private final String password;

    public MailNotificador(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void notificarInscripcion(Participante participante, Concurso concurso) {
        // Configuración SMTP MailTrap
        String host = "smtp.mailtrap.io";
        int port = 587;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", String.valueOf(port));

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("noreply@concurso.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(participante.getNombre() + "@mailtrap.io")); // simulación
            message.setSubject("Inscripción confirmada");
            message.setText("Hola " + participante.getNombre() +
                    ", tu inscripción al concurso " + concurso.getNombre() + " fue exitosa.");

            Transport.send(message);
            System.out.println("Email enviado a " + participante.getNombre());

        } catch (MessagingException e) {
            System.out.println("Error al enviar email: " + e.getMessage());
        }
    }
}*/
