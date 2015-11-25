/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escuela.de.natacion;

import BaseDeDatos.ConexionMySQL;
import static BaseDeDatos.ConexionMySQL.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author ultron
 * 
 * 
 * 
 * okokoko
 */
public class Clase extends javax.swing.JFrame {
    String IdClase,IdInstructor,HoraInicio,HoraFinal,Precio,Cupo;
    /**
     * Creates new form Clase
     */
    public Clase() {
        initComponents();
        muestraInstructores();
        GeneraIdClase();
    }
    public boolean obtenDatos(){
        
        
        IdInstructor=cmbInstructor.getSelectedItem().toString().substring(0,cmbInstructor.getSelectedItem().toString().indexOf(",") );
        //IdInstructor=tkn.nextToken();
        HoraInicio=cmbHoraInicio.getSelectedItem().toString();
        String aux=HoraInicio.substring(0,HoraInicio.indexOf(":"));
        HoraInicio=aux+""+HoraInicio.substring(HoraInicio.indexOf(":")+1,HoraInicio.length())+"00";
        
        
        HoraFinal=cmbHoraFinal.getSelectedItem().toString();
        String auxFin=HoraFinal.substring(0,HoraFinal.indexOf(":"));
        HoraFinal=auxFin+""+HoraFinal.substring(HoraFinal.indexOf(":")+1,HoraFinal.length())+"00";
        Precio=txtPrecio.getText();
        Cupo=cmbCupo.getSelectedItem().toString();

        return true;
   }
    
    public void GeneraIdClase()
   {
       try
            {
                ConexionMySQL conexion = new ConexionMySQL();
                conexion.MySQLConnection();
                Statement st = Conexion.createStatement();
                ResultSet rs = st.executeQuery("SELECT COUNT(clase.IdClase) as id FROM clase;");
                
                while(rs.next())
                {
                    int id= rs.getInt("Id");
                    this.IdClase=Integer.toString(id+1);
                    this.txtIdClase.setText(IdClase);
                }
                rs.close();
                conexion.closeConnection();
                
            }
            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(rootPane, ex);
            }
   }
    
    
    
   public void muestraInstructores()
   {
       try
            {
                ConexionMySQL conexion = new ConexionMySQL();
                conexion.MySQLConnection();
                Statement st = Conexion.createStatement();
                ResultSet rs = st.executeQuery("SELECT IdEmpleado, Nombre FROM empleado WHERE Instructor=true");
                while(rs.next())
                {
                    int id= rs.getInt("IdEmpleado");
                    String nombre=rs.getString("Nombre");
                    cmbInstructor.addItem(Integer.toString(id)+","+nombre);
                }
                rs.close();
                conexion.closeConnection();
                
            }
            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(rootPane, ex);
            }
   }
   
   public void RegistraClase(){
       
        try 
        {
            
            if(obtenDatos()==true)
            {
                ConexionMySQL mysql = new ConexionMySQL();
                mysql.MySQLConnection();
                String Query = "INSERT INTO clase "
                    + "(IdClase,"
                    + "IdInstructor,"
                    + "HoraInicio,"
                    + "HoraFinal,"
                    + "Precio,"
                    + "Cupo) "
                    + "VALUES "
                    + "("+IdClase+","
                    + ""+IdInstructor+","
                    + "'"+HoraInicio+"',"
                    + "'"+HoraFinal+"',"
                    + ""+Precio+","
                    + ""+Cupo+")";
                
                
                
                Statement st = Conexion.createStatement();
                st.executeUpdate(Query);
                /*
                    Dias
                    Lunes=2
                    Martes=3
                    Miercoles=4
                    Jueves=5
                    Viernes=6
                    Sabado=7
                */
                if(checkLunes.isSelected())
                {
                    String QueryDias="INSERT INTO claseDia (IdClase,Dia)VALUES ("+IdClase+","+2+")";  
                    st.executeUpdate(QueryDias);
                }
                if(checkMartes.isSelected())
                {
                    String QueryDias="INSERT INTO claseDia (IdClase,Dia)VALUES ("+IdClase+","+3+")";  
                    st.executeUpdate(QueryDias);
                }
                if(checkMiercoles.isSelected())
                {
                    String QueryDias="INSERT INTO claseDia (IdClase,Dia)VALUES ("+IdClase+","+4+")";  
                    st.executeUpdate(QueryDias);
                }
                if(checkJueves.isSelected())
                {
                    String QueryDias="INSERT INTO claseDia (IdClase,Dia)VALUES ("+IdClase+","+5+")";  
                    st.executeUpdate(QueryDias);
                }
                if(checkViernes.isSelected())
                {
                    String QueryDias="INSERT INTO claseDia (IdClase,Dia)VALUES ("+IdClase+","+6+")";  
                    st.executeUpdate(QueryDias);
                }
                if(checkSabado.isSelected())
                {
                    String QueryDias="INSERT INTO claseDia (IdClase,Dia)VALUES ("+IdClase+","+7+")";  
                    st.executeUpdate(QueryDias);
                }
                mysql.closeConnection();
                JOptionPane.showMessageDialog(null, "Clase registrada");
            }
            else
            {
            }
            
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex);
        }
       
   }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        cmbInstructor = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cmbHoraInicio = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cmbHoraFinal = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbCupo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        checkLunes = new javax.swing.JCheckBox();
        checkMartes = new javax.swing.JCheckBox();
        checkMiercoles = new javax.swing.JCheckBox();
        checkJueves = new javax.swing.JCheckBox();
        checkViernes = new javax.swing.JCheckBox();
        checkSabado = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtIdClase = new javax.swing.JTextField();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setTitle("Clase");

        jLabel1.setText("Instructor:");

        cmbInstructor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbInstructorActionPerformed(evt);
            }
        });

        jLabel2.setText("Hora inicio");

        cmbHoraInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00" }));
        cmbHoraInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHoraInicioActionPerformed(evt);
            }
        });

        jLabel3.setText("Hora final");

        cmbHoraFinal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00" }));
        cmbHoraFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHoraFinalActionPerformed(evt);
            }
        });

        jLabel4.setText("Precio:");

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        jLabel5.setText("Cupo:");

        cmbCupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        cmbCupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCupoActionPerformed(evt);
            }
        });

        jLabel6.setText("Estudiantes");

        jLabel7.setText("Dias que se imparte la clase:");

        checkLunes.setText("Lunes");

        checkMartes.setText("Martes");

        checkMiercoles.setText("Miercoles");

        checkJueves.setText("Jueves");

        checkViernes.setText("Viernes");

        checkSabado.setText("Sabado");

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Id Clase");

        txtIdClase.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbInstructor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbHoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cmbCupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel6))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(checkLunes)
                                    .addGap(18, 18, 18)
                                    .addComponent(checkJueves))
                                .addComponent(jLabel7)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(checkMiercoles)
                                        .addComponent(checkMartes))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(checkViernes)
                                        .addComponent(checkSabado))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdClase, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 171, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtIdClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cmbHoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkLunes)
                    .addComponent(checkJueves))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkMartes)
                    .addComponent(checkViernes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkMiercoles)
                    .addComponent(checkSabado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbInstructorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbInstructorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbInstructorActionPerformed

    private void cmbHoraInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHoraInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbHoraInicioActionPerformed

    private void cmbHoraFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHoraFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbHoraFinalActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void cmbCupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCupoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        obtenDatos();
        RegistraClase();
        GeneraIdClase();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Clase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkJueves;
    private javax.swing.JCheckBox checkLunes;
    private javax.swing.JCheckBox checkMartes;
    private javax.swing.JCheckBox checkMiercoles;
    private javax.swing.JCheckBox checkSabado;
    private javax.swing.JCheckBox checkViernes;
    private javax.swing.JComboBox cmbCupo;
    private javax.swing.JComboBox cmbHoraFinal;
    private javax.swing.JComboBox cmbHoraInicio;
    private javax.swing.JComboBox cmbInstructor;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtIdClase;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
