/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.presentation;
import com.mycompany.Infraestructure.Models.ClientesModels;
import com.mycompany.Services.ClientesService;
import javax.swing.JOptionPane;

/**
 *
 * @author solua
 */
public class ClientesPresentation extends javax.swing.JFrame {
  ClientesService clientesService;
  
    /**
     * Creates new form Clientes
     */
    public ClientesPresentation() {
        initComponents();
         this.setLocationRelativeTo(null);
        clientesService = new ClientesService("postgres", "1234", "localhost", "5432", "OptativoII");

    }
    private void ConsultarCliente(String id) {
        cargarDatos(clientesService.consultarCliente(Integer.parseInt(id)));
        
    }
    
    private void nuevoCliente() {
        ClientesModels model = new ClientesModels();
        txtCIDPersona.setText(String.valueOf(model.IdPersona));
        date.setDate(model.FechaIngreso);
        cbcalificacion1.setSelectedItem(model.Calificacion);
        cbestado.setSelectedItem(model.Estado);
        
        String result = clientesService.registrarCliente(model);
        JOptionPane.showMessageDialog(this, result);

        limpiarDatos();
    }
    
    private void cargarDatos(ClientesModels model){
        txtCIDPersona.setText(String.valueOf(model.IdPersona));
        date.setDate(model.FechaIngreso);
        cbcalificacion1.setSelectedItem(model.Calificacion);
        cbestado.setSelectedItem(model.Estado);
    }
    
    private void limpiarDatos() {
        txtCIDPersona.setText("");
        date.setDate(null);
        cbcalificacion1.setSelectedIndex(0);
        cbestado.setSelectedIndex(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloPrincipal = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        txtCIDPersona = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbestado = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        tituloPrincipal2 = new javax.swing.JLabel();
        btnModelBuscarClientes = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        etiquetaPersona = new javax.swing.JLabel();
        Cancelar1 = new javax.swing.JButton();
        txtIdCliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cbcalificacion1 = new javax.swing.JComboBox<>();
        botonGuardar = new javax.swing.JButton();
        botonNuevo = new javax.swing.JButton();
        date = new com.toedter.calendar.JDateChooser();

        tituloPrincipal.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        tituloPrincipal.setForeground(new java.awt.Color(102, 0, 102));
        tituloPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloPrincipal.setText("Personas");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Id Persona");

        txtCIDPersona.setEnabled(false);

        jLabel2.setText("Fecha de Ingreso");

        jLabel3.setText("Calificacion");

        cbestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        cbestado.setEnabled(false);

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));
        jPanel1.setForeground(new java.awt.Color(255, 204, 255));

        tituloPrincipal2.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        tituloPrincipal2.setForeground(new java.awt.Color(102, 0, 102));
        tituloPrincipal2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloPrincipal2.setText("Clientes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(tituloPrincipal2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(123, 123, 123))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(tituloPrincipal2)
                .addGap(16, 16, 16))
        );

        btnModelBuscarClientes.setBackground(new java.awt.Color(204, 204, 255));
        btnModelBuscarClientes.setText("Buscar");
        btnModelBuscarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModelBuscarClientesActionPerformed(evt);
            }
        });

        Cancelar.setBackground(new java.awt.Color(204, 204, 0));
        Cancelar.setForeground(new java.awt.Color(255, 255, 255));
        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        etiquetaPersona.setText("Id Cliente");

        Cancelar1.setBackground(new java.awt.Color(204, 51, 0));
        Cancelar1.setForeground(new java.awt.Color(255, 255, 255));
        Cancelar1.setText("Salir");
        Cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancelar1ActionPerformed(evt);
            }
        });

        txtIdCliente.setName("Ingrese ID"); // NOI18N
        txtIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdClienteActionPerformed(evt);
            }
        });
        txtIdCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdClienteKeyPressed(evt);
            }
        });

        jLabel8.setText("Estado");

        cbcalificacion1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        cbcalificacion1.setEnabled(false);

        botonGuardar.setBackground(new java.awt.Color(0, 102, 0));
        botonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        botonNuevo.setBackground(new java.awt.Color(102, 255, 204));
        botonNuevo.setForeground(new java.awt.Color(255, 255, 255));
        botonNuevo.setText("Nuevo");
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(etiquetaPersona)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(botonNuevo)
                                .addGap(18, 18, 18)
                                .addComponent(botonGuardar)
                                .addGap(9, 9, 9)
                                .addComponent(Cancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Cancelar1))
                            .addComponent(cbestado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbcalificacion1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCIDPersona)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtIdCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModelBuscarClientes))
                            .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaPersona)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModelBuscarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCIDPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbcalificacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar)
                    .addComponent(Cancelar)
                    .addComponent(Cancelar1)
                    .addComponent(botonNuevo))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModelBuscarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModelBuscarClientesActionPerformed
         ConsultarCliente( txtIdCliente.getText().trim());
    }//GEN-LAST:event_btnModelBuscarClientesActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CancelarActionPerformed

    private void Cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancelar1ActionPerformed
        this.setVisible (false);
        
    }//GEN-LAST:event_Cancelar1ActionPerformed

    private void txtIdClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdClienteKeyPressed

    }//GEN-LAST:event_txtIdClienteKeyPressed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        ClientesModels cliente = new ClientesModels();
        cliente.setIdPersona(Integer.parseInt(txtCIDPersona.getText()));  
        cliente.setEstado(cbestado.getSelectedItem().toString());  
        cliente.setEstado(cbcalificacion1.getSelectedItem().toString());  
        cliente.setFechaIngreso(date.getDate());

        String resultado = clientesService.registrarCliente(cliente);
        JOptionPane.showMessageDialog(this, resultado);
        
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void txtIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdClienteActionPerformed
        
    }//GEN-LAST:event_txtIdClienteActionPerformed

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        txtCIDPersona.setEnabled(true); 
        date.setEnabled(true); 
        cbcalificacion1.setEnabled(true); 
        cbestado.setEnabled(true); 
    }//GEN-LAST:event_botonNuevoActionPerformed

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
            java.util.logging.Logger.getLogger(ClientesPresentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientesPresentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientesPresentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientesPresentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientesPresentation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Cancelar1;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JButton btnModelBuscarClientes;
    private javax.swing.JComboBox<String> cbcalificacion1;
    private javax.swing.JComboBox<String> cbestado;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JLabel etiquetaPersona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel tituloPrincipal;
    private javax.swing.JLabel tituloPrincipal2;
    private javax.swing.JTextField txtCIDPersona;
    private javax.swing.JTextField txtIdCliente;
    // End of variables declaration//GEN-END:variables

 
}
