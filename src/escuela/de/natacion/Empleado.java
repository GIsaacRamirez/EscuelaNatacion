/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escuela.de.natacion;
import BaseDeDatos.ConexionMySQL;
import static BaseDeDatos.ConexionMySQL.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Guillermo
 */
public class Empleado extends javax.swing.JFrame {

    int IdEmpleado;
    String ApellidoPaternoEmpleado;
    String ApellidoMaternoEmpleado;
    String NombreEmpleado;
    String TelefonoEmpleado;
    String NumInteriorEmpleado;
    String CalleEmpleado;
    String ColoniaEmpleado;
    String MunicipioEmpleado;
    String EntidadEmpleado;
    int Status;
    
    public void CargarPuestos()
    {
        try {
            ConexionMySQL conexion = new ConexionMySQL();
            conexion.MySQLConnection("root","");
            Statement st = Conexion.createStatement();
            ResultSet rs = st.executeQuery("Select *from Tipoempleado ORDER BY IdTipoEmpleado");
            while(rs.next())
            {
                cmbPuestos.addItem(rs.getString("TipoEmpleado"));
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void IdSiguienteEmpleado()
    {
        try
        {
            ConexionMySQL conexion = new ConexionMySQL();
            conexion.MySQLConnection("root","");
            Statement st = Conexion.createStatement();
            ResultSet rs = st.executeQuery("Select count(IdEmpleado) as num from empleado");
            
            while (rs.next())
            {
                int num=rs.getInt("num");
                if(num==0)
                {
                    this.txtIdEmpleado.setText("1");
                }
                else
                {
                    ResultSet max = st.executeQuery("Select max(IdEmpleado) as maximo from empleado");
                    max.last();
                    int maximo= max.getInt("maximo");
                    this.txtIdEmpleado.setText(""+(maximo+1));       
                   }
                }
                rs.close();
                conexion.closeConnection();
                
                }
                catch(Exception e)
                {
                    
                }
    }
    public Empleado()
    {
        initComponents();
        CargarPuestos();
        this.btnBajaEmpleado.setVisible(false);
        this.btnModificarEmpleado1.setVisible(false);
        
        this.btnIngresarEmpleado.setVisible(true);
        lblEstado.setVisible(false);
        cmbEstado.setVisible(false);
        
        IdSiguienteEmpleado();    
    }
    public Empleado(int id, int op)
    {
        initComponents();
        CargarPuestos();
        this.btnIngresarEmpleado.setVisible(false);
        try 
        {
            this.btnBajaEmpleado.setVisible(false);
            this.btnModificarEmpleado1.setVisible(false);
            ConexionMySQL conexion = new ConexionMySQL();
            conexion.MySQLConnection("root","");
            Statement st = Conexion.createStatement();
            ResultSet rs = st.executeQuery("Select  *from empleado where IdEmpleado="+id);
            while(rs.next())
            {
                int ID= rs.getInt("IdEmpleado");
                txtIdEmpleado.setText(""+ID);
                txtApellidoPaternoEmpleado.setText(rs.getString("ApellidoPaterno"));
                txtApellidoMaternoEmpleado.setText(rs.getString("ApellidoMaterno"));
                txtNombreEmpleado.setText(rs.getString("Nombre"));
                txtTelefonoEmpleado.setText(rs.getString("Telefono"));
                txtNumeroInteriorEmpleado.setText(rs.getString("NumeroInterior"));
                txtCalleEmpleado.setText(rs.getString("Calle"));
                txtColoniaEmpleado.setText(rs.getString("Colonia"));
                txtMunicipioEmpleado.setText(rs.getString("Municipio"));
                txtEntidadEmpleado.setText(rs.getString("Entidad"));
                cmbPuestos.setSelectedIndex(rs.getInt("IdTipoEmpleado"));
            
                Status=rs.getInt("Status");
                if(Status==0)
                {
                    cmbEstado.setSelectedIndex(0);
                }
                else
                {
                    cmbEstado.setSelectedIndex(1);
                }
            }
            cmbEstado.setEnabled(false);
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(op==1)
        {
            bloquearCampos();
            cmbPuestos.setEnabled(false);
        }
        if(op==2)//2 modificar
        {
            this.btnBajaEmpleado.setVisible(false);
            this.btnModificarEmpleado1.setVisible(true);
            
        }
        if(op==3)//3 eliminar
        {
            this.btnBajaEmpleado.setVisible(true);
            this.btnModificarEmpleado1.setVisible(false);
            bloquearCampos();
            cmbEstado.setEnabled(true);
            cmbPuestos.setEnabled(false);
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

        panelEmpleado = new javax.swing.JPanel();
        lblNombreEmpleado = new javax.swing.JLabel();
        txtNombreEmpleado = new javax.swing.JTextField();
        lblApellidoPaternoEmpleado = new javax.swing.JLabel();
        lblApellidoMaternoEmpleado = new javax.swing.JLabel();
        txtApellidoMaternoEmpleado = new javax.swing.JTextField();
        txtApellidoPaternoEmpleado = new javax.swing.JTextField();
        lblTelefonoEmpleado = new javax.swing.JLabel();
        txtTelefonoEmpleado = new javax.swing.JTextField();
        lblCalleEmpleado = new javax.swing.JLabel();
        txtCalleEmpleado = new javax.swing.JTextField();
        lblNumeroInterior = new javax.swing.JLabel();
        txtNumeroInteriorEmpleado = new javax.swing.JTextField();
        lblColoniaEmpleado = new javax.swing.JLabel();
        txtColoniaEmpleado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtMunicipioEmpleado = new javax.swing.JTextField();
        lblEntidadEmpleado = new javax.swing.JLabel();
        txtEntidadEmpleado = new javax.swing.JTextField();
        lblIdEmpleado = new javax.swing.JLabel();
        txtIdEmpleado = new javax.swing.JTextField();
        btnIngresarEmpleado = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnModificarEmpleado1 = new javax.swing.JButton();
        btnBajaEmpleado = new javax.swing.JButton();
        lblEstado = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox();
        lblTipoEmpleado = new javax.swing.JLabel();
        cmbPuestos = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        panelEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        panelEmpleado.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        lblNombreEmpleado.setText("Nombre:");

        lblApellidoPaternoEmpleado.setText("Apellido Paterno:");

        lblApellidoMaternoEmpleado.setText("Apellido Materno:");

        lblTelefonoEmpleado.setText("Telefono:");

        lblCalleEmpleado.setText("Calle:");

        lblNumeroInterior.setText("Numero Interior:");

        lblColoniaEmpleado.setText("Colonia:");

        jLabel1.setText("Municipio:");

        lblEntidadEmpleado.setText("Entidad:");

        lblIdEmpleado.setText("ID de Empleado:");

        txtIdEmpleado.setEditable(false);

        btnIngresarEmpleado.setLabel("Ingresar");
        btnIngresarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarEmpleadoActionPerformed(evt);
            }
        });

        btnCerrar.setLabel("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnModificarEmpleado1.setText("Modificar");
        btnModificarEmpleado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarEmpleado1ActionPerformed(evt);
            }
        });

        btnBajaEmpleado.setText("Guardar Estado Actual");
        btnBajaEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaEmpleadoActionPerformed(evt);
            }
        });

        lblEstado.setText("Estado:");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inactivo", "Activo" }));

        lblTipoEmpleado.setText("Puesto:");

        javax.swing.GroupLayout panelEmpleadoLayout = new javax.swing.GroupLayout(panelEmpleado);
        panelEmpleado.setLayout(panelEmpleadoLayout);
        panelEmpleadoLayout.setHorizontalGroup(
            panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmpleadoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEmpleadoLayout.createSequentialGroup()
                        .addComponent(lblIdEmpleado)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEmpleadoLayout.createSequentialGroup()
                        .addComponent(lblApellidoMaternoEmpleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtApellidoMaternoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEmpleadoLayout.createSequentialGroup()
                        .addGroup(panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelEmpleadoLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMunicipioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEmpleadoLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btnIngresarEmpleado)
                                .addGap(49, 49, 49)
                                .addComponent(btnModificarEmpleado1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelEmpleadoLayout.createSequentialGroup()
                                .addComponent(lblEntidadEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEntidadEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBajaEmpleado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                        .addComponent(btnCerrar))
                    .addGroup(panelEmpleadoLayout.createSequentialGroup()
                        .addComponent(lblEstado)
                        .addGap(18, 18, 18)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEmpleadoLayout.createSequentialGroup()
                        .addGroup(panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelEmpleadoLayout.createSequentialGroup()
                                .addGroup(panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombreEmpleado)
                                    .addComponent(lblTelefonoEmpleado)
                                    .addComponent(lblCalleEmpleado))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblTipoEmpleado)
                                        .addGroup(panelEmpleadoLayout.createSequentialGroup()
                                            .addComponent(txtCalleEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblNumeroInterior)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtNumeroInteriorEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtTelefonoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelEmpleadoLayout.createSequentialGroup()
                                .addComponent(lblApellidoPaternoEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtApellidoPaternoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelEmpleadoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblColoniaEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtColoniaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelEmpleadoLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cmbPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        panelEmpleadoLayout.setVerticalGroup(
            panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmpleadoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdEmpleado)
                    .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidoPaternoEmpleado)
                    .addComponent(txtApellidoPaternoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipoEmpleado)
                    .addComponent(cmbPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidoMaternoEmpleado)
                    .addComponent(txtApellidoMaternoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEmpleado)
                    .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTelefonoEmpleado)
                    .addComponent(txtTelefonoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCalleEmpleado)
                    .addComponent(txtCalleEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumeroInterior)
                    .addComponent(lblColoniaEmpleado)
                    .addComponent(txtColoniaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroInteriorEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMunicipioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEntidadEmpleado)
                    .addComponent(txtEntidadEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEstado)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresarEmpleado)
                    .addComponent(btnModificarEmpleado1)
                    .addComponent(btnBajaEmpleado)
                    .addComponent(btnCerrar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        lblNombreEmpleado.getAccessibleContext().setAccessibleName("lblNombreEmpleado");
        txtNombreEmpleado.getAccessibleContext().setAccessibleName("txtNombreEmpleado");
        lblApellidoPaternoEmpleado.getAccessibleContext().setAccessibleName("lblApellidoPaternoEmpleado");
        lblApellidoMaternoEmpleado.getAccessibleContext().setAccessibleName("ApellidoMaternoEmpleado");
        txtApellidoMaternoEmpleado.getAccessibleContext().setAccessibleName("txtApellidoPaternoEmpleado");
        txtApellidoPaternoEmpleado.getAccessibleContext().setAccessibleName("txtApellidoPaterno");
        lblTelefonoEmpleado.getAccessibleContext().setAccessibleName("lblTelefonoEmpleado");
        txtTelefonoEmpleado.getAccessibleContext().setAccessibleName("txtTelefonoEmpleado");
        lblCalleEmpleado.getAccessibleContext().setAccessibleName("lblCalleEmpleado");
        txtCalleEmpleado.getAccessibleContext().setAccessibleName("txtCalleEmpleado");
        lblNumeroInterior.getAccessibleContext().setAccessibleName("lblNumeroInterior");
        txtNumeroInteriorEmpleado.getAccessibleContext().setAccessibleName("txtNumeroInteriorEmpleado");
        lblColoniaEmpleado.getAccessibleContext().setAccessibleName("lblColoniaEmpleado");
        txtColoniaEmpleado.getAccessibleContext().setAccessibleName("txtColoniaEmpleado");
        txtMunicipioEmpleado.getAccessibleContext().setAccessibleName("txtMunicipioEmpleado");
        lblEntidadEmpleado.getAccessibleContext().setAccessibleName("lblEntidadEmpleado");
        txtEntidadEmpleado.getAccessibleContext().setAccessibleName("txtEntidadEmpleado");
        lblIdEmpleado.getAccessibleContext().setAccessibleName("lblIdEmpleado");
        txtIdEmpleado.getAccessibleContext().setAccessibleName("txtIdEmpleado");
        btnIngresarEmpleado.getAccessibleContext().setAccessibleName("btnIngresarEmpleado");
        btnCerrar.getAccessibleContext().setAccessibleName("btnCerrar");
        btnModificarEmpleado1.getAccessibleContext().setAccessibleName("btnModificarEmpleado");
        btnBajaEmpleado.getAccessibleContext().setAccessibleName("btnEliminarEmpleado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelEmpleado.getAccessibleContext().setAccessibleName("panelEmpleado");

        getAccessibleContext().setAccessibleName("frmEmpleado");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();//Cerrar esta ventana
    }//GEN-LAST:event_btnCerrarActionPerformed

    public Boolean obtenercampos()
    {
        Boolean correcto=true;
       
        if(txtIdEmpleado.getText().matches("^\\s*$"))
        {
            correcto=false;
        }
        else
        {
             IdEmpleado=Integer.parseInt(txtIdEmpleado.getText());
        }
        ApellidoPaternoEmpleado= txtApellidoPaternoEmpleado.getText();
        if(ApellidoPaternoEmpleado.matches("^\\s*$"))
        {
            correcto=false;
        }
        ApellidoMaternoEmpleado= txtApellidoMaternoEmpleado.getText();
        if(ApellidoMaternoEmpleado.matches("^\\s*$"))
        {
            correcto=false;
        }
        NombreEmpleado = txtNombreEmpleado.getText();
        if(NombreEmpleado.matches("^\\s*$"))
        {
            correcto=false;
        }
        TelefonoEmpleado = txtTelefonoEmpleado.getText();
        NumInteriorEmpleado = txtNumeroInteriorEmpleado.getText();
        CalleEmpleado = txtCalleEmpleado.getText();
        ColoniaEmpleado = txtColoniaEmpleado.getText();
        MunicipioEmpleado = txtMunicipioEmpleado.getText();
        EntidadEmpleado = txtEntidadEmpleado.getText();
        if(EntidadEmpleado.equals(""))
        {
            EntidadEmpleado="JALISCO";
        }
        return correcto;
    }
    public void limpiarEmpleado()
    {
        IdSiguienteEmpleado();
        txtApellidoPaternoEmpleado.setText("");
        txtApellidoMaternoEmpleado.setText("");
        txtNombreEmpleado.setText("");
        txtTelefonoEmpleado.setText("");
        txtNumeroInteriorEmpleado.setText("");
        txtCalleEmpleado.setText("");
        txtColoniaEmpleado.setText("");
        txtMunicipioEmpleado.setText("");
        txtEntidadEmpleado.setText("");
        Status=1;
    }
    
    public void bloquearCampos()
    {
                txtApellidoPaternoEmpleado.setEditable(false);
                txtApellidoMaternoEmpleado.setEditable(false);
                txtNombreEmpleado.setEditable(false);
                txtTelefonoEmpleado.setEditable(false);
                txtNumeroInteriorEmpleado.setEditable(false);
                txtCalleEmpleado.setEditable(false);
                txtColoniaEmpleado.setEditable(false);
                txtMunicipioEmpleado.setEditable(false);
                txtEntidadEmpleado.setEditable(false);
    }
    private void btnIngresarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarEmpleadoActionPerformed
        Status=1;//Activo
        Boolean correcto;
        try 
        {
            correcto=obtenercampos();
            if(correcto==true)
            {
                ConexionMySQL mysql = new ConexionMySQL();
                mysql.MySQLConnection("root","");
                String Query = "INSERT INTO empleado "
                    + "(IdEmpleado,"
                    + "ApellidoPaterno,"
                    + "ApellidoMaterno,"
                    + "Nombre,"
                    + "Telefono,"
                    + "NumeroInterior,"
                    + "Calle,"
                    + "Colonia,"
                    + "Municipio,"
                    + "Entidad,"
                    + "IdTipoEmpleado,"
                    + "Status) "
                    + "VALUES "
                    + "("+IdEmpleado+","
                    + "'"+ApellidoPaternoEmpleado+"',"
                    + "'"+ApellidoMaternoEmpleado+"',"
                    + "'"+NombreEmpleado+"',"
                    + "'"+TelefonoEmpleado+"',"
                    + "'"+NumInteriorEmpleado+"',"
                    + "'"+CalleEmpleado+"',"
                    + "'"+ColoniaEmpleado+"',"
                    + "'"+MunicipioEmpleado+"',"
                    + "'"+EntidadEmpleado+"',"
                    + "'"+cmbPuestos.getSelectedIndex()+"',"
                    + ""+Status+")";
            
                Statement st = Conexion.createStatement();
                st.executeUpdate(Query);
                mysql.closeConnection();
                JOptionPane.showMessageDialog(null, "Empleado Ingresado satisfactoriamente con el ID:"+IdEmpleado);
                limpiarEmpleado();
            }
            else
            {
                JOptionPane.showMessageDialog(panelEmpleado,"Los apellidos y el nombre son campos obligatorios");
            }
            
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    
    }//GEN-LAST:event_btnIngresarEmpleadoActionPerformed

    private void btnModificarEmpleado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarEmpleado1ActionPerformed
        obtenercampos();
        try 
        {
            ConexionMySQL conexion = new ConexionMySQL();
            conexion.MySQLConnection("root","");
            
            String Query;
            Query="UPDATE empleado SET ApellidoPaterno='"+ApellidoPaternoEmpleado+"',"
                    + ""+"ApellidoMaterno='"+ApellidoPaternoEmpleado+"',"
                    + ""+"Nombre='"+NombreEmpleado+"',"
                    + ""+"Telefono='"+TelefonoEmpleado+"',"
                    + ""+"NumeroInterior='"+NumInteriorEmpleado+"',"
                    + ""+"Calle='"+CalleEmpleado+"',"
                    + ""+"Colonia='"+ColoniaEmpleado+"',"
                    + ""+"Municipio='"+MunicipioEmpleado+"',"
                    + ""+"IdTipoEmpleado='"+cmbPuestos.getSelectedIndex()+"',"
                    + ""+"Entidad='"+EntidadEmpleado+"'"
                    +"WHERE IdEmpleado="+IdEmpleado;
            
            PreparedStatement pst= Conexion.prepareStatement(Query);
            pst.executeUpdate();
            pst.close();
            conexion.closeConnection();
            JOptionPane.showMessageDialog(panelEmpleado, "Registro Modificado Exitosamente");
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(panelEmpleado, ex);
        }
    }//GEN-LAST:event_btnModificarEmpleado1ActionPerformed

    private void btnBajaEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaEmpleadoActionPerformed
        // TODO add your handling code here:
        obtenercampos();
        try 
        {
            ConexionMySQL conexion = new ConexionMySQL();
            conexion.MySQLConnection("root","");
            Status=cmbEstado.getSelectedIndex();
            String Query;
            Query="UPDATE empleado SET Status='"+Status+"'"
                    +"WHERE IdEmpleado="+IdEmpleado;
            
            PreparedStatement pst= Conexion.prepareStatement(Query);
            pst.executeUpdate();
            pst.close();
            conexion.closeConnection();
            JOptionPane.showMessageDialog(panelEmpleado, "Status Modificado Exitosamente");
            this.dispose();
        } catch (SQLException ex) {
            
        }
    }//GEN-LAST:event_btnBajaEmpleadoActionPerformed

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
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBajaEmpleado;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnIngresarEmpleado;
    private javax.swing.JButton btnModificarEmpleado1;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbPuestos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblApellidoMaternoEmpleado;
    private javax.swing.JLabel lblApellidoPaternoEmpleado;
    private javax.swing.JLabel lblCalleEmpleado;
    private javax.swing.JLabel lblColoniaEmpleado;
    private javax.swing.JLabel lblEntidadEmpleado;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblIdEmpleado;
    private javax.swing.JLabel lblNombreEmpleado;
    private javax.swing.JLabel lblNumeroInterior;
    private javax.swing.JLabel lblTelefonoEmpleado;
    private javax.swing.JLabel lblTipoEmpleado;
    private javax.swing.JPanel panelEmpleado;
    private javax.swing.JTextField txtApellidoMaternoEmpleado;
    private javax.swing.JTextField txtApellidoPaternoEmpleado;
    private javax.swing.JTextField txtCalleEmpleado;
    private javax.swing.JTextField txtColoniaEmpleado;
    private javax.swing.JTextField txtEntidadEmpleado;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JTextField txtMunicipioEmpleado;
    private javax.swing.JTextField txtNombreEmpleado;
    private javax.swing.JTextField txtNumeroInteriorEmpleado;
    private javax.swing.JTextField txtTelefonoEmpleado;
    // End of variables declaration//GEN-END:variables
}
