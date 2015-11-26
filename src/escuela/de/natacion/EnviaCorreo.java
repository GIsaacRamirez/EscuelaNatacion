/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escuela.de.natacion;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
/**
 *
 * @author ultron
 */
public class EnviaCorreo implements Runnable {
    String promo="",email="";
  public void run()
  {
      try {  
          Runtime.getRuntime().exec("echo "+promo+" | mail -s \"Promocion\" "+email+"");
      } catch (IOException ex) {
          Logger.getLogger(EnviaCorreo.class.getName()).log(Level.SEVERE, null, ex);
      }
      
  }
  
}
    

