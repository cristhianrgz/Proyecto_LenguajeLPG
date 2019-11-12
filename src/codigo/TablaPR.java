package codigo;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TablaPR extends javax.swing.JFrame {
DefaultTableModel modelLista = new DefaultTableModel();
    /**
     * Creates new form TablaPR
     */
    public TablaPR() {
        initComponents();
        this.setLocationRelativeTo(null);
        llenarTablaPR();
        this.setTitle("Palabras reservadas");
    }
    
    public void llenarTablaPR(){    
        ArrayList<Object> columna = new ArrayList<Object>();
        columna.add("Palabra reservada");
        for(Object col : columna){
            modelLista.addColumn(col);
        }
        
        this.TblPalRes.setModel(modelLista);
        ArrayList<Object[]>PalabraRes = new ArrayList<Object[]>();
        Object[] PR1 = new Object[]{"inicio"};
        Object[] PR2 = new Object[]{"programa"};
        Object[] PR3 = new Object[]{"fin"};
        Object[] PR4 = new Object[]{"montar"};
        Object[] PR5 = new Object[]{"LLDG"};
        Object[] PR6 = new Object[]{"elemento"};
        Object[] PR7 = new Object[]{"cad"};
        Object[] PR8 = new Object[]{"mostrar"};
        Object[] PR9 = new Object[]{"dibujar"};
        Object[] PR10 = new Object[]{"bool"};
        Object[] PR11 = new Object[]{"ent"};
        Object[] PR12 = new Object[]{"numDec"};
        Object[] PR13 = new Object[]{"numDecL"};
        Object[] PR14 = new Object[]{"si"};
        Object[] PR15 = new Object[]{"sino"};
        Object[] PR16 = new Object[]{"hacer"};
        Object[] PR17 = new Object[]{"mientras"};
        Object[] PR18 = new Object[]{"modelo"};
        Object[] PR19 = new Object[]{"imprimir"};
        Object[] PR20 = new Object[]{"obtener"};
        Object[] PR21 = new Object[]{"orden_principal"};
        Object[] PR22 = new Object[]{"LLDGconoSol"};
        Object[] PR23 = new Object[]{"LLDGconoLin"};
        Object[] PR24 = new Object[]{"LLDGcuboSol"};
        Object[] PR25 = new Object[]{"LLDGcuboLin"};
        Object[] PR26 = new Object[]{"LLDGesferaSol"};
        Object[] PR27 = new Object[]{"LLDGesferaLin"};
        Object[] PR28 = new Object[]{"LGrectanSol"};
        Object[] PR29 = new Object[]{"LGrectanLin"};
        Object[] PR30 = new Object[]{"LGrotar"};
        Object[] PR31 = new Object[]{"LGlimpiarBuffer"};
        Object[] PR32 = new Object[]{"LGlimpiarBufferColor"};
        Object[] PR33 = new Object[]{"color_Buffer_Bit"};
        Object[] PR34 = new Object[]{"profundidad_Buffer_Bit"};
        Object[] PR35 = new Object[]{"acumulacion_Buffer_Bit"};
        Object[] PR36 = new Object[]{"plantila_Buffer_Bit"};
        Object[] PR37 = new Object[]{"LGModoPoligono"};
        Object[] PR38 = new Object[]{"LGMaterial"};
        Object[] PR39 = new Object[]{"LGColor"};
        Object[] PR40 = new Object[]{"LGVertice"};
        Object[] PR41 = new Object[]{"LGEmpezar"};
        Object[] PR42 = new Object[]{"LGTerminar"};
        Object[] PR43 = new Object[]{"LG_Puntos"};
        Object[] PR44 = new Object[]{"LG_Lineas"};
        Object[] PR45 = new Object[]{"LG_Linea_Lin"};
        Object[] PR46 = new Object[]{"LG_Linea_Ciclo"};
        Object[] PR47 = new Object[]{"LG_Triangulos"};
        Object[] PR48 = new Object[]{"LG_Triangulo_Lin"};
        Object[] PR49 = new Object[]{"LG_Triangulo_Abanico"};
        Object[] PR50 = new Object[]{"LG_Cuadrado"};
        Object[] PR51 = new Object[]{"LG_Cuadrado_Lin"};
        Object[] PR52 = new Object[]{"LG_Poligono"};
        Object[] PR53 = new Object[]{"LGModoMatriz"};
        Object[] PR54 = new Object[]{"LG_Vista_Modelo"};
        Object[] PR55 = new Object[]{"LG_Proyeccion"};
        Object[] PR56 = new Object[]{"LG_Textura"};
        Object[] PR57 = new Object[]{"LG_Color"};
        Object[] PR58 = new Object[]{"LGMatrizOrtografica"};
        Object[] PR59 = new Object[]{"LGMatrizPerspectiva"};
        Object[] PR60 = new Object[]{"LGMatrizIdentidad"};
        Object[] PR61 = new Object[]{"LGVer"};
        Object[] PR62 = new Object[]{"LGVolverAMostrar"};
        Object[] PR63 = new Object[]{"LGRotar"};
        Object[] PR64 = new Object[]{"LGModoVisualizacion"};
        Object[] PR65 = new Object[]{"LGPosicionVentanaInicio"};
        Object[] PR66 = new Object[]{"LGTamañoVentanaInicio"};
        Object[] PR67 = new Object[]{"LGMatrizIdentidad"};
        Object[] PR68 = new Object[]{"LGCrearVentana"};
        Object[] PR69 = new Object[]{"LGMostrarFuncion"};
        Object[] PR70 = new Object[]{"LGRemodeladoFuncion"};
        Object[] PR71 = new Object[]{"LGLazoPrincipal"};
        Object[] PR72 = new Object[]{"LGMatrizOrtografica2D"};
        Object[] PR73 = new Object[]{"LGVentana"};
        Object[] PR74 = new Object[]{"LGEjecucionLineas"};
        Object[] PR75 = new Object[]{"LG_RGBA"};
        Object[] PR76 = new Object[]{"LG_RGB"};
        Object[] PR77 = new Object[]{"LG_Indice"};
        Object[] PR78 = new Object[]{"LG_Solo"};
        Object[] PR79 = new Object[]{"LG_Doble"};
        Object[] PR80 = new Object[]{"LG_Acumulacion"};
        Object[] PR81 = new Object[]{"LG_Alfa"};
        Object[] PR82 = new Object[]{"LG_Profundo"};
        Object[] PR83 = new Object[]{"LG_Plantilla"};
        Object[] PR84 = new Object[]{"LG_MuestreoMultiple"};
        Object[] PR85 = new Object[]{"LG_Estereo"};
        Object[] PR86 = new Object[]{"LG_Luminosa"};
        
        PalabraRes.add(PR1);
        PalabraRes.add(PR2);
        PalabraRes.add(PR3);
        PalabraRes.add(PR4);
        PalabraRes.add(PR5);
        PalabraRes.add(PR6);
        PalabraRes.add(PR7);
        PalabraRes.add(PR8);
        PalabraRes.add(PR9);
        PalabraRes.add(PR10);
        PalabraRes.add(PR11);
        PalabraRes.add(PR12);
        PalabraRes.add(PR13);
        PalabraRes.add(PR14);
        PalabraRes.add(PR15);
        PalabraRes.add(PR16);
        PalabraRes.add(PR17);
        PalabraRes.add(PR18);
        PalabraRes.add(PR19);
        PalabraRes.add(PR20);
        PalabraRes.add(PR21);
        PalabraRes.add(PR22);
        PalabraRes.add(PR23);
        PalabraRes.add(PR24);
        PalabraRes.add(PR25);
        PalabraRes.add(PR26);
        PalabraRes.add(PR27);
        PalabraRes.add(PR28);
        PalabraRes.add(PR29);
        PalabraRes.add(PR30);
        PalabraRes.add(PR31);
        PalabraRes.add(PR32);
        PalabraRes.add(PR33);
        PalabraRes.add(PR34);
        PalabraRes.add(PR35);
        PalabraRes.add(PR36);
        PalabraRes.add(PR37);
        PalabraRes.add(PR38);
        PalabraRes.add(PR39);
        PalabraRes.add(PR40);
        PalabraRes.add(PR41);
        PalabraRes.add(PR42);
        PalabraRes.add(PR43);
        PalabraRes.add(PR44);
        PalabraRes.add(PR45);
        PalabraRes.add(PR46);
        PalabraRes.add(PR47);
        PalabraRes.add(PR48);
        PalabraRes.add(PR49);
        PalabraRes.add(PR50);
        PalabraRes.add(PR51);
        PalabraRes.add(PR52);
        PalabraRes.add(PR53);
        PalabraRes.add(PR54);
        PalabraRes.add(PR55);
        PalabraRes.add(PR56);
        PalabraRes.add(PR57);
        PalabraRes.add(PR58);
        PalabraRes.add(PR59);
        PalabraRes.add(PR60);
        PalabraRes.add(PR61);
        PalabraRes.add(PR62);
        PalabraRes.add(PR63);
        PalabraRes.add(PR64);
        PalabraRes.add(PR65);
        PalabraRes.add(PR66);
        PalabraRes.add(PR67);
        PalabraRes.add(PR68);
        PalabraRes.add(PR69);
        PalabraRes.add(PR70);
        PalabraRes.add(PR71);
        PalabraRes.add(PR72);
        PalabraRes.add(PR73);
        PalabraRes.add(PR74);
        PalabraRes.add(PR75);
        PalabraRes.add(PR76);
        PalabraRes.add(PR77);
        PalabraRes.add(PR78);
        PalabraRes.add(PR79);
        PalabraRes.add(PR80);
        PalabraRes.add(PR81);
        PalabraRes.add(PR82);
        PalabraRes.add(PR83);
        PalabraRes.add(PR84);
        PalabraRes.add(PR85);
        PalabraRes.add(PR86);
        
        for(Object[] PR : PalabraRes){
            modelLista.addRow(PR);
        }
        this.TblPalRes.setModel(modelLista);
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
        TblPalRes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        TblPalRes.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        TblPalRes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TblPalRes.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(TblPalRes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TablaPR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablaPR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablaPR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablaPR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TablaPR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblPalRes;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
