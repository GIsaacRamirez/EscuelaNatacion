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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Guillermo
 */
public class EliminarClaseCliente extends javax.swing.JFrame {
    DefaultTableModel modelo;
    DefaultTableModel asignar;
    /**
     * Creates new form EliminarClaseCliente
     */
    public EliminarClaseCliente() {
        initComponents();
        txtCliente.setEnabled(false);
         modelo=(DefaultTableModel) tablaBuscarClase.getModel();
        modelo.addColumn("IdClase");
        modelo.addColumn("Instructor");
        modelo.addColumn("Inicio");
        modelo.addColumn("Fin");
        modelo.addColumn("Precio");
        modelo.addColumn("Cupo");
        modelo.addColumn("Disponibles");
        
        
        asignar=(DefaultTableModel) tablaAsignar.getModel();
        asignar.addColumn("IdClase");
        asignar.addColumn("Instructor");
        asignar.addColumn("Inicio");
        asignar.addColumn("Fin");
        asignar.addColumn("Precio");
        asignar.addColumn("Cupo");
        asignar.addColumn("Disponibles");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaAsignar = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        txtBuscarCliente = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaBuscarClase = new javax.swing.JTable();
        btnBuscarCliente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();

        jMenuItem1.setText("Eliminar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Cancelar su Eliminación");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Por Eliminar");

        tablaAsignar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaAsignar.setComponentPopupMenu(jPopupMenu2);
        tablaAsignar.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tablaAsignar);

        jLabel1.setText("Clases");

        jLabel4.setText("Buscar Cliente:");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tablaBuscarClase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaBuscarClase.setComponentPopupMenu(jPopupMenu1);
        tablaBuscarClase.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaBuscarClase);

        btnBuscarCliente.setText("Buscar Cliente");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        jLabel3.setText("Cliente:");

        txtCliente.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnEliminar))
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCliente))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(53, 53, 53)
                        .addComponent(btnBuscarCliente)))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEliminar)
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void limpiarAsignar()
    {
        int filas=tablaAsignar.getRowCount();
        for (int i = 0;filas>i; i++) 
        {
            asignar.removeRow(0);
        }
    }
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int correcto=1;
        if(txtCliente.getText().matches("^\\s*$"))
        {
            JOptionPane.showMessageDialog(rootPane, "Por favor ingrese el id");
        }
        else
        {
            
        if(tablaAsignar.getRowCount()>0)
            {
                try {
                    ConexionMySQL conexion = new ConexionMySQL();
                    conexion.MySQLConnection();
                    Statement st = Conexion.createStatement();
                    int filas=tablaAsignar.getRowCount();
                    int encontro=0;
                    if(filas>0)
                    {
                        for (int i = 0;filas>i; i++)
                        {
                            ResultSet rs = st.executeQuery("Select"
                                + " *from clienteclase"
                                + " where idCliente='"+(txtCliente.getText())+""
                                + " ' and idClase="+asignar.getValueAt(i,0));
                            if(rs.next())
                            {
                                String q="DELETE from clienteclase"
                                + " where idcliente="+txtCliente.getText()+" and idclase="+asignar.getValueAt(i,0);
                                
                                st.executeUpdate(q);
                                String u="UPDATE clase SET Disponibles=(Disponibles+1) "
                                +" WHERE idclase="+asignar.getValueAt(i, 0);
                                st.executeUpdate(u);
                            }
                            
                        }
                    }

                    if(correcto==1)
                    {
                        JOptionPane.showMessageDialog(rootPane, "Se registraron correctamente todas las clases");
                    }
                    txtCliente.setText("");
                    limpiarClase();
                    limpiarAsignar();
                } catch (SQLException ex) {
                    Logger.getLogger(AsignarClase_a_Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    public void limpiarClase()
    {
        int filas=tablaBuscarClase.getRowCount();
        for (int i = 0;filas>i; i++) 
        {
            modelo.removeRow(0);
        }
    }
    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        // TODO add your handling code here:
        limpiarClase();
        int contador=0;
        if(!txtBuscarCliente.getText().matches("^\\s*$"))
        {
            String [] datos =new String [7];
            try
            {
                ConexionMySQL conexion = new ConexionMySQL();
                conexion.MySQLConnection();
                Statement st = Conexion.createStatement();
                ResultSet rs = st.executeQuery("Select"
                + " c.idclase as id,"
                + " c.IdInstructor as inst,"
                + " c.HoraInicio as inicio,"
                + " c.HoraFinal as fin, "
                + " c.Precio as p,"
                + " c.Cupo as cup, "
                + "c.disponibles as dis"
                + " from clienteclase as d"
                + " INNER Join  clase as c ON d.IdClase=c.idclase where d.idcliente="+txtBuscarCliente.getText());
                 while(rs.next())
                {
                    if(contador==0)
                    {
                        txtCliente.setText(txtBuscarCliente.getText());
                    }
                    datos[0]=""+rs.getInt("id");
                    datos[1]=rs.getString("inst");
                    datos[2]=rs.getString("inicio");
                    datos[3]=rs.getString("fin");
                    datos[4]=rs.getString("p");
                    datos[5]=rs.getString("cup");
                    datos[6]=rs.getString("dis");
                    modelo.addRow(datos);
                    contador++;
                }
                 if(contador==0)
                 {
                     txtCliente.setText("");
                 }
                
            }
            catch (SQLException ex)
            {

            }
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
         
            int filas=tablaAsignar.getRowCount();
            int encontro=0;
            if(filas>0)
            {
                for (int i = 0;filas>i; i++) 
                {
                    String aux=asignar.getValueAt(i, 0).toString();
                    if(aux.equals(modelo.getValueAt(tablaBuscarClase.getSelectedRow(),0)))
                    {
                        encontro=1;
                        JOptionPane.showMessageDialog(rootPane, "Ya esta en tu asignacion");
                        break;
                    }
                }
            }
            
            if(encontro==0)
            {
                String [] fila=new String[7];
                for(int i=0;i<tablaBuscarClase.getColumnCount();i++)
                {
                    fila[i]=(String) modelo.getValueAt(tablaBuscarClase.getSelectedRow(),i);
                }
                asignar.addRow(fila);
                modelo.removeRow(tablaBuscarClase.getSelectedRow());
            }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        int filas=tablaAsignar.getRowCount();
        if(filas>0)
        {
            String [] fila=new String[7];
            for(int i=0;i<tablaAsignar.getColumnCount();i++)
            {
                fila[i]=(String) asignar.getValueAt(tablaAsignar.getSelectedRow(),i);
            }
            modelo.addRow(fila);
            asignar.removeRow(tablaAsignar.getSelectedRow());
            
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(EliminarClaseCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarClaseCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarClaseCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarClaseCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarClaseCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaAsignar;
    private javax.swing.JTable tablaBuscarClase;
    private javax.swing.JTextField txtBuscarCliente;
    private javax.swing.JTextField txtCliente;
    // End of variables declaration//GEN-END:variables
}
