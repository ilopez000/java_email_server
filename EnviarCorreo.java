import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarCorreo {

    public static void main(String[] args) {
        // Reemplaza las variables con tu información
        final String remitente = "tucorreo@email.com";
        final String contrasena = "tucontraseña";
        final String destinatario = "destinatario@email.com";
        final String asunto = "Asunto del correo";
        final String mensaje = "Contenido del correo electrónico";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(remitente, contrasena);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setText(mensaje);

            Transport.send(message);

            System.out.println("Correo electrónico enviado correctamente!");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error al enviar el correo electrónico: " + e.getMessage());
        }
    }
}

//descargar librería http://www.java2s.com/Code/Jar/j/Downloadjavaxmailjar.htm
//descargar librería http://www.java2s.com/Code/Jar/a/Downloadactivationjar.htm
//poner librería en IntelliJ https://stackoverflow.com/questions/1051640/correct-way-to-add-external-jars-lib-jar-to-an-intellij-idea-project
