/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.GestorCiudad;
import logica.GestorProveedor;
import persistencia.Ciudad;
import persistencia.Proveedor;

/**
 *
 * @author David
 */
public class Proveedores extends javax.swing.JFrame {

    /**
     * Creates new form Proveedores1
     */
    public Proveedores() {
        initComponents();
        cargarTabla();
        cargarComboCiudades();
    }

    
    void cargarTabla(){
        try {
            DefaultTableModel modeloTabla;
            GestorProveedor proveedor = new GestorProveedor();
            modeloTabla = proveedor.cargar();
            this.jTblProveedores.setModel(modeloTabla);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);      
        }
    }
    
    void cargarComboCiudades(){
        try {
            DefaultComboBoxModel modeloCombo;
            GestorCiudad gestorCiudad = new GestorCiudad();
            modeloCombo = gestorCiudad.cargarCiudades();
            this.jcbxCiudades.setModel(modeloCombo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    void limpiarCampos(){
        this.IdProvvedores.setText("");
        this.DesProveedores.setText("");
        this.DirProveedores.setText("");
        this.NomProveedores.setText("");
        this.TelProveedores.setText("");
        this.jcbxCiudades.setSelectedItem(null);
    }
    
    void insertar(){
        Proveedor proveedor = new Proveedor();
        GestorProveedor gestorProveedor = new GestorProveedor();
        //Creo el objecto ciudad para setear el id de la ciudad
        Ciudad c = new Ciudad();
        c.setId(((Ciudad)this.jcbxCiudades.getSelectedItem()).getId());
        proveedor.setNombre(this.NomProveedores.getText());
        proveedor.setDireccion(this.DirProveedores.getText());
        proveedor.setDescripcion(this.DesProveedores.getText());
        proveedor.setTelefono(this.TelProveedores.getText());
        proveedor.setCuidad(c);
        
        if (gestorProveedor.insertar(proveedor))
            JOptionPane.showMessageDialog(null, "Proveedor insertado correctamente");
        else
            JOptionPane.showMessageDialog(null, "Error al insertar");   
    }
    
    void editar(){
        Proveedor proveedor = new Proveedor();
        GestorProveedor gestorProveedor = new GestorProveedor();
        //Creo el objecto ciudad para setear el id de la ciudad
        Ciudad c = new Ciudad();
        c.setId(((Ciudad)this.jcbxCiudades.getSelectedItem()).getId());
        proveedor.setId(Integer.valueOf(this.IdProvvedores.getText()));
        proveedor.setNombre(this.NomProveedores.getText());
        proveedor.setDireccion(this.DirProveedores.getText());
        proveedor.setDescripcion(this.DesProveedores.getText());
        proveedor.setTelefono(this.TelProveedores.getText());
        proveedor.setCuidad(c);
        
        if (gestorProveedor.editar(proveedor))
            JOptionPane.showMessageDialog(null, "Proveedor editado correctamente");
        else
            JOptionPane.showMessageDialog(null, "Error al editar");   
    }
    
    void eliminar(){
        if( !IdProvvedores.getText().equals("") ){
            int confirmacion = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar este proveedor?", "Confirmar", 2);
            if(confirmacion == 0){
                Proveedor proveedor = new Proveedor();
                GestorProveedor gestorProveedor = new GestorProveedor();
                proveedor.setId(Integer.valueOf(this.IdProvvedores.getText()));
                gestorProveedor.eliminar(proveedor);
            }
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

        jLabel1 = new javax.swing.JLabel();
        IdProvvedores = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NomProveedores = new javax.swing.JTextField();
        DirProveedores = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblProveedores = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        DesProveedores = new javax.swing.JTextField();
        TelProveedores = new javax.swing.JTextField();
        EditProveedores = new javax.swing.JButton();
        EliProveedores = new javax.swing.JButton();
        GuaProveedores = new javax.swing.JButton();
        jcbxCiudades = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("PROVEEDORES");

        IdProvvedores.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ID :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("NOMBRE :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("DIRECCIÓN :");

        jTblProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTblProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTblProveedoresMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTblProveedores);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("TELÉFONO :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("CIUDAD :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("DESCRIPCION:");

        EditProveedores.setText("EDITAR");
        EditProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditProveedoresActionPerformed(evt);
            }
        });

        EliProveedores.setText("ELIMINAR");
        EliProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliProveedoresActionPerformed(evt);
            }
        });

        GuaProveedores.setText("GUARDAR");
        GuaProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuaProveedoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EliProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EditProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(GuaProveedores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(IdProvvedores, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(NomProveedores)
                                    .addComponent(DirProveedores))
                                .addGap(101, 101, 101)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DesProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(TelProveedores)
                                    .addComponent(jcbxCiudades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EditProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EliProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GuaProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(IdProvvedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NomProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(DirProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(DesProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbxCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TelProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EditProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditProveedoresActionPerformed
        // TODO add your handling code here:
        editar();
        cargarTabla();
        limpiarCampos();
    }//GEN-LAST:event_EditProveedoresActionPerformed

    private void EliProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliProveedoresActionPerformed
        // TODO add your handling code here:
        eliminar();
        cargarTabla();
        limpiarCampos();
    }//GEN-LAST:event_EliProveedoresActionPerformed

    private void GuaProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuaProveedoresActionPerformed
        // TODO add your handling code here:
        insertar();
        cargarTabla();
        limpiarCampos();
    }//GEN-LAST:event_GuaProveedoresActionPerformed

    private void jTblProveedoresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblProveedoresMousePressed
        // TODO add your handling code here:
        int fila = this.jTblProveedores.rowAtPoint(evt.getPoint());
        this.IdProvvedores.setText(this.jTblProveedores.getValueAt(fila, 0).toString());
        this.NomProveedores.setText(this.jTblProveedores.getValueAt(fila, 1).toString());
        this.DirProveedores.setText(this.jTblProveedores.getValueAt(fila, 2).toString());
        this.DesProveedores.setText(this.jTblProveedores.getValueAt(fila, 3).toString());
        this.TelProveedores.setText(this.jTblProveedores.getValueAt(fila, 4).toString());
        this.jcbxCiudades.setSelectedItem(this.jTblProveedores.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_jTblProveedoresMousePressed

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
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DesProveedores;
    private javax.swing.JTextField DirProveedores;
    private javax.swing.JButton EditProveedores;
    private javax.swing.JButton EliProveedores;
    private javax.swing.JButton GuaProveedores;
    private javax.swing.JTextField IdProvvedores;
    private javax.swing.JTextField NomProveedores;
    private javax.swing.JTextField TelProveedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblProveedores;
    private javax.swing.JComboBox<String> jcbxCiudades;
    // End of variables declaration//GEN-END:variables
}
