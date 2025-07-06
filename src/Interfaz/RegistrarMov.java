/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Entidades.Dependencia;
import Entidades.Documento;
import Entidades.Expediente;
import Entidades.Interesado;
import Entidades.Programa;
import TDA.Cola;
import TDA.ListaDobleEnlazada;
import TDA.NodoDoble;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo
 */
public class RegistrarMov extends javax.swing.JFrame {
// ... (imports y declaración de clase permanecen igual)
private DefaultTableModel modeloTabla;
public RegistrarMov() {
        initComponents();
        configurarTabla();
        
        cargarDependenciasEnComboBox(); // Llama este método al iniciar
        cargarPrioridadesEnComboBox();
        jComboBox1.addActionListener(e -> filtrarExpedientes());
        jComboBox2.addActionListener(e -> filtrarExpedientes());
        jComboBox1.addActionListener(e -> actualizarDependenciasDestino());
        filtrarExpedientes();
    }


private void cargarPrioridadesEnComboBox() {
        jComboBox2.removeAllItems(); // Limpiar primero
        
        // Agregar las opciones de prioridad
        jComboBox2.addItem("Alta (1)");
        jComboBox2.addItem("Media (2)");
        jComboBox2.addItem("Baja (3)");
        
        // Opcional: seleccionar una por defecto
        jComboBox2.setSelectedIndex(0); // Selecciona "Alta (1)"
    }


private void cargarDependenciasEnComboBox() {
        // Limpiar ComboBox primero
        jComboBox1.removeAllItems(); // Origen
        jComboBox3.removeAllItems(); // NUEVOOOOOOO!(BORRAR)
        ListaDobleEnlazada<Dependencia> dependencias = Programa.getListaDependencias();
        
        // Verificar si hay dependencias
        if (dependencias != null && !dependencias.esVacia()) {
            NodoDoble<Dependencia> nodoActual = dependencias.getCabeza();
            
            // Recorrer y agregar cada dependencia a los ComboBox
            while (nodoActual != null) {
                String nombreDependencia = nodoActual.getItem().getNombre();
                jComboBox1.addItem(nombreDependencia);
                jComboBox3.addItem(nombreDependencia); //NUEVOOOOO!!!(BORRAR)
                nodoActual = nodoActual.getSgteNodo();
            }
        }
        /*jComboBox1.addActionListener(e -> actualizarDependenciasDestino());//NUEVOOOO!!!!(BORRAR)*/
        
        
    }



//NUEVOOOOO!(BORRAR)
private void actualizarDependenciasDestino() {
        String dependenciaOrigen = (String) jComboBox1.getSelectedItem();
        jComboBox3.removeAllItems();
        
        ListaDobleEnlazada<Dependencia> dependencias = Programa.getListaDependencias();
        if (dependencias != null && !dependencias.esVacia()) {
            NodoDoble<Dependencia> nodoActual = dependencias.getCabeza();
            while (nodoActual != null) {
                String nombreDependencia = nodoActual.getItem().getNombre();
                // Agregar todas excepto la seleccionada en el primer ComboBox
                if (!nombreDependencia.equals(dependenciaOrigen)) {
                    jComboBox3.addItem(nombreDependencia);
                }
                nodoActual = nodoActual.getSgteNodo();
            }
        }
        // Seleccionar el primer elemento si hay opciones disponibles
        if (jComboBox3.getItemCount() > 0) {
            jComboBox3.setSelectedIndex(0);
        }
    }

    // ... (resto del código existente)


















public void actualizarComboBoxDependencias() {
    cargarDependenciasEnComboBox();
}
    
    
    
        
    

       
             private void agregarExpedientesDeCola(Cola<Expediente> cola) {//nuevoo!! el segundo "nombreDependencia"
    if (cola == null) return;
    
    Cola<Expediente> temp = new Cola<>();
    while (!cola.esVacia()) {
        Expediente exp = cola.desencolar();
        temp.encolar(exp);
        
        
        // Agregar a la tabla
        modeloTabla.addRow(new Object[]{
            exp.getIdExpediente(),
            "Prioridad " + exp.getPrioridad(),
            exp.getInteresado().getNombres(),
            exp.getAsunto(),
            //NUEVO!!!
            // ... otros campos que necesites
        });
    }
       
// Restaurar la cola original
    while (!temp.esVacia()) {
        cola.encolar(temp.desencolar());
    }
}
    private void filtrarExpedientes() {
    modeloTabla.setRowCount(0); // Limpiar tabla
    String dependenciaSeleccionada = (String) jComboBox1.getSelectedItem();
    String prioridadSeleccionada = (String) jComboBox2.getSelectedItem();
    if (dependenciaSeleccionada == null) return;
    ListaDobleEnlazada<Dependencia> dependencias = Programa.getListaDependencias();
    if (dependencias != null) {
        NodoDoble<Dependencia> actual = dependencias.getCabeza();
        while (actual != null) {
            Dependencia dep = actual.getItem();
            if (dep.getNombre().equals(dependenciaSeleccionada)) {
                if (prioridadSeleccionada.equals("Alta (1)") || prioridadSeleccionada.contains("1")) {
                    agregarExpedientesDeCola(dep.getColaAlta());
                }
                if (prioridadSeleccionada.equals("Media (2)") || prioridadSeleccionada.contains("2")) {
                    agregarExpedientesDeCola(dep.getColaMedia());
                }
                if (prioridadSeleccionada.equals("Baja (3)") || prioridadSeleccionada.contains("3")) {
                    agregarExpedientesDeCola(dep.getColaBaja());
                }
                break; // Salir del bucle una vez encontrada la dependencia
            }
            actual = actual.getSgteNodo();
        }
    }
}
            
            
            
            
            
            
            
            
            
    
    private void configurarTabla() {
    modeloTabla = new DefaultTableModel(
        new Object[][]{},
        new String[]{"ID", "Prioridad", "Interesado", "Asunto", "Estado"} // Columnas
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    jTable1.setModel(modeloTabla);
}
    public void actualizarTabla() {
    filtrarExpedientes();
    

// Vuelve a aplicar los filtros actuales
}
    
    
    private boolean esIdValido(String id) {
    // Verifica primero en la tabla visible (datos ya filtrados)
    for (int i = 0; i < jTable1.getRowCount(); i++) {
        String idEnTabla = jTable1.getValueAt(i, 0).toString(); // Columna 0 = ID
        if (idEnTabla.equals(id)) {
            return true;
        }
    }
    return false;
}
    
    
    // ... (el resto del código generado por NetBeans permanece igual)

    /**
     * Creates new form RegistrarMov
     */
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 12)); // NOI18N
        jLabel1.setText("DEPENDENCIA ORIGEN:");

        jLabel2.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 12)); // NOI18N
        jLabel2.setText("DEPENDENCIA DESTINO:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 12)); // NOI18N
        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 12)); // NOI18N
        jButton2.setText("Mover Expediente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 12)); // NOI18N
        jLabel3.setText("MOVER EXPEDIENTE");

        jLabel4.setText("PRIORIDAD:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("ID DE EXPEDIENTE:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2)))
                        .addGap(150, 150, 150)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here
        ScreenManager.goBack(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
        
        
  jButton2.addActionListener(e -> {
    String idIngresado = jTextField2.getText().trim();
    
    if (idIngresado.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese un ID", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (esIdValido(idIngresado)) {
        // El ID es válido (existe en la tabla filtrada)
        jTextField2.setBackground(Color.WHITE);
        // Aquí irá luego tu lógica para mover el expediente...
        JOptionPane.showMessageDialog(this, "ID válido: " + idIngresado);
    } else {
        // El ID no existe en los resultados actuales
        jTextField2.setBackground(new Color(255, 200, 200)); // Fondo rojo claro
        JOptionPane.showMessageDialog(this, 
            "ID no encontrado en los resultados filtrados", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
});
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarMov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarMov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarMov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarMov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarMov().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
