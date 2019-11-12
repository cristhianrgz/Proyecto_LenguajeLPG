package codigo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diana
 */
public class TablaID extends javax.swing.JFrame {
 DefaultTableModel id;
    /**
     * Creates new form TablaID
     */
    public TablaID() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Identificadores");
        id =(DefaultTableModel)tbl_ids.getModel();
        id.setRowCount(0);
        llenarIDS();
        VenPrincipal.ids.clear();
      
    }
public void llenarIDS()
{
   
    id.setRowCount(0);
    Set<String> hashSet = new HashSet<String>(VenPrincipal.ids);
    VenPrincipal.ids.clear();
    VenPrincipal.ids.addAll(hashSet);
    Collections.sort(VenPrincipal.ids);
    
    for(int i=0;i<VenPrincipal.ids.size();i++)
    {
         Object []fila={VenPrincipal.ids.get(i)};
                        id.addRow(fila);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ids = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tbl_ids.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbl_ids.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "   Nombre", "   Tipo", "   Valor"
            }
        ));
        tbl_ids.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(tbl_ids);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TablaID().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tbl_ids;
    // End of variables declaration//GEN-END:variables
}
