/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escuela.de.natacion;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
/**
 *
 * @author ultron
 */
public class EnviaCorreo implements Runnable {
    String promo="",email="";
    final String user="escuelapatitosazules@gmail.com";
    final String pass="patitos2015";
  public void run()
  {
      Properties props=new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", "smtp.gmail.com");
      props.put("mail.smtp.port", "587");
      
      Session session=Session.getInstance(props, new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication(){
              return new PasswordAuthentication(user,pass);
          }
});
      try{
      Message message=new MimeMessage(session);
      message.setFrom(new InternetAddress("escuelapatitosazules@gmail.com"));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
      message.setSubject("Promocion Escuela los patitos azules");
      message.setContent("<body><p>"+promo+"</p></body>","text/html; charset=utf-8");
      Transport.send(message);
      
      System.out.println("Mensaje enviado");
      }catch(Exception e)
      {
          System.out.println("Fallo "+e.getLocalizedMessage());
      }
  }
  
}
    

