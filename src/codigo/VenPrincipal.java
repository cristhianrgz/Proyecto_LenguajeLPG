package codigo;

 import java.awt.Color;
import java.awt.FileDialog;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Highlighter;
//archivo
import java.io.BufferedWriter;//Escribe la informacion en el archivo o sea lo graba en el disco duro.
import java.io.File;//Comprueva si existe el archivo.
import java.io.FileWriter;//Indica el archivo en el que se va a escribir.
import java.io.IOException;//Para el control de errores. Se debe poner entre public ....() y {}
import java.awt.FileDialog;//Muestra un dia
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.undo.UndoManager;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class VenPrincipal extends javax.swing.JFrame{
static int con=-1;
String d="";
int ren=0;
static String diccionario[]={
    "inicio","programa","expresion_regular","var","{",
    "alfabeto","=","}",";","expresion",
    "validar","(",")","orden_principal","orden",
    "fin","cad","\"","|","conjunto",
    "u!!","i!!","conj",  ","  ,"num",
    "bool","mostrar","cadenas","repetir_si","<",">","ent","d!!","c!!"};
static int grafo[][]={     
//   1 2 3 4 5 6 7 8 9 1 2 3 4 5 6 7 8 9 1 2 3 4 5 6 7 8 9 
    {0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,1},//inicio    1
    {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//programa  2
    {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//exp_reg   3
    {0,0,0,1,1,0,1,1,0,0,0,0,1,0,0,0,0,1,1,0,1,1,0,0,0,0,0,0,0,1,1,1,0,0,0},//var       4
    {0,0,0,1,1,1,0,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,1,0,1,0,1,0,0,0,0,0,1},//{         5
    {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//alfabeto  6
    {0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},//=         7
    {0,1,0,1,0,0,0,0,1,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},//}         8
    {0,1,0,1,0,0,0,1,0,1,1,0,1,0,1,0,1,0,0,0,0,0,1,0,0,1,1,0,1,0,0,0,0,0,1},//;         9    
    {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//expresion 10
    {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//validar   11
    {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//(         12
    {0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//)         13
    {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//ord_prin  14
    {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//orden     15    
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//fin       16
    {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//cad       17
    {0,0,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},//" //falta 18
    {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//|         19
    {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//conjunto  20
    {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//u!!       21    
    {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//i!!       22
    {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//conj      23
    {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},//,         24
    {0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,1,0,0,0},//numero    25
    {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//bool      26
    {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//mostrar   27  
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//cadenas   28 
    {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//repetir_si29
    {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},// <        30 
    {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},// >        31 
    {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},// +        32 
    {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//d!!       33 
    {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//c!!       34 
    {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}//ent       35
}; 
static String delimitador=" >>(){}; = [] \" \" "; 
static int Panterior=-1,Pactual=-1,linea=0;
//-----------------Sintactico---------------------------
    TextLineNumber lineas;
    final Highlighter hilit;
    final Highlighter.HighlightPainter painter;
    final static Color HILIT_COLOR = Color.LIGHT_GRAY;
    final Color entryBg;
    DefaultStyledDocument doc;
    private Archivo archivo;
    private File flArchivo;
    private String Ruta_del_archivo;
    private FileDialog fdAbrir;
    private FileReader frArchivo =null;
    private BufferedReader bwLector=null;
    private BufferedWriter bwEscritor;
    private FileWriter fwArchivo_en_el_que_escribir;
    private FileDialog fdGuardar;
    boolean bandera=false;
    int r=0;
    String arr[],arr1[] = null,pr[];
    int c,cp;
    //DefaultTableModel token;
    public static ArrayList<String> ids = new ArrayList<String>();  
    public static ArrayList<String> errores = new ArrayList<String>();  
    public static ArrayList<String> errorS = new ArrayList<String>(); 
    public static ArrayList<String> t = new ArrayList<String>(); 
    int b1=0,b2=0,in=0,min=0;
    int i;
    String cad="";
    String cadena="";
        
    public VenPrincipal() {
    initComponents();
    this.setTitle("IDE - LPG");
    this.getContentPane().setBackground(Color.WHITE);
    //Panel de numero de lineas
    lineas = new TextLineNumber(txtaCodigo);
    lineas.setCurrentLineForeground(new Color(0, 0, 255));//current line
    lineas.setForeground(new Color(0,0,0));//color linea
    jScrollPane4.setRowHeaderView(lineas);
    jScrollPane4.setViewportView(txtaCodigo);  
    hilit = new DefaultHighlighter();
    painter = new DefaultHighlighter.DefaultHighlightPainter(HILIT_COLOR);
    txtaCodigo.setHighlighter(hilit);
    entryBg = txtaCodigo.getBackground();
    archivo=new Archivo();
    //token =(DefaultTableModel)tbl_tokens.getModel();
    int cp=0;
    this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaSalida = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtaCodigo = new javax.swing.JTextPane();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        Analizar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        MnuBar = new javax.swing.JMenuBar();
        Archivo = new javax.swing.JMenu();
        Nuevo = new javax.swing.JMenuItem();
        Abrir = new javax.swing.JMenuItem();
        Guardar = new javax.swing.JMenuItem();
        GuardarComo = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();
        tablas_simbolos = new javax.swing.JMenu();
        go_PR = new javax.swing.JMenuItem();
        go_ID = new javax.swing.JMenuItem();
        Compilar = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenuItem6.setText("jMenuItem6");

        jMenu2.setText("File");
        jMenuBar1.add(jMenu2);

        jMenu5.setText("Edit");
        jMenuBar1.add(jMenu5);

        jMenu6.setText("File");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("Edit");
        jMenuBar3.add(jMenu7);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel2.setForeground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Salida");

        txtaSalida.setColumns(20);
        txtaSalida.setRows(5);
        txtaSalida.setBorder(null);
        jScrollPane2.setViewportView(txtaSalida);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        txtaCodigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtaCodigo.setToolTipText("");
        txtaCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtaCodigoFocusGained(evt);
            }
        });
        jScrollPane4.setViewportView(txtaCodigo);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 723, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Analizar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Analizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Analizar.setText("Analizar");
        Analizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AnalizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Analizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Analizar, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Lexema", "Componente Léxico"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tabla de tokens");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel2.setText("jLabel2");

        MnuBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MnuBar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        Archivo.setText("Archivo");
        Archivo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        Nuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        Nuevo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Nuevo.setText("Nuevo");
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });
        Archivo.add(Nuevo);

        Abrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        Abrir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Abrir.setText("Abrir");
        Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirActionPerformed(evt);
            }
        });
        Archivo.add(Abrir);

        Guardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        Guardar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        Archivo.add(Guardar);

        GuardarComo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        GuardarComo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        GuardarComo.setText("Guardar como");
        GuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarComoActionPerformed(evt);
            }
        });
        Archivo.add(GuardarComo);

        Salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        Salir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        Archivo.add(Salir);

        MnuBar.add(Archivo);

        tablas_simbolos.setText("Tablas de Simbólos");
        tablas_simbolos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        go_PR.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        go_PR.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        go_PR.setText("Palabras Reservadas");
        go_PR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_PRActionPerformed(evt);
            }
        });
        tablas_simbolos.add(go_PR);

        go_ID.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        go_ID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        go_ID.setText("Identificadores");
        go_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_IDActionPerformed(evt);
            }
        });
        tablas_simbolos.add(go_ID);

        MnuBar.add(tablas_simbolos);

        Compilar.setText("Compilar");
        Compilar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem3.setText("Analisis");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        Compilar.add(jMenuItem3);

        MnuBar.add(Compilar);

        setJMenuBar(MnuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
      //MODIFICAR
        if(!(txtaCodigo.getText().equals(""))){
                 if(evt.getActionCommand().equalsIgnoreCase("Nuevo"))
		{
			JOptionPane.showMessageDialog(null, archivo.escribir_archivo(txtaCodigo.getText()));
		}//if
        }
        else{
        txtaCodigo.setText("");}
        txtaCodigo.setText("");
//        token.setRowCount(0);
        errores.clear();
        txtaSalida.setText("");       
    }//GEN-LAST:event_NuevoActionPerformed

    private void AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirActionPerformed
        fdAbrir=new FileDialog(fdAbrir, "Abrir archivo", FileDialog.LOAD);
	Ruta_del_archivo="";
        try{ frArchivo =new FileReader(Ruta_del_archivo);}catch(IOException ex){/*mensaje de error por si se quiere verificar que sucede*/}
		fdAbrir.setVisible(true);
		fdAbrir.dispose();
		Ruta_del_archivo=fdAbrir.getDirectory()+fdAbrir.getFile().toString() ;
		String respuesta="";
		flArchivo=new File(Ruta_del_archivo);
		try{
			//Este bloque de codigo obligatoriamente debe ir dentro de un try.
			frArchivo=new FileReader(flArchivo);
			bwLector=new BufferedReader (frArchivo);
			String linea="";
			while ((linea=bwLector.readLine())!=null)
			{
				respuesta+=linea+"\n";//Se le pone "\n" al final porque el codigo lo abre pero omitiendo los saltos de liena, entonces, deben volverse a escribir los saltos de linea.
			}//while
			bwLector.close();//Se cierra el archivo.		
		}catch(Exception ex){JOptionPane.showMessageDialog(null,ex.getMessage());}
   txtaCodigo.setText(respuesta);        
    }//GEN-LAST:event_AbrirActionPerformed
                            
    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        if(evt.getActionCommand().equalsIgnoreCase("Guardar")){
			JOptionPane.showMessageDialog(null, archivo.escribir_archivo(txtaCodigo.getText()));
		}//if
    }//GEN-LAST:event_GuardarActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
       JOptionPane.showMessageDialog(null, archivo.escribir_archivo(txtaCodigo.getText()));
        this.dispose();
    }//GEN-LAST:event_SalirActionPerformed

    private void GuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarComoActionPerformed
      if(evt.getActionCommand().equalsIgnoreCase("Guardar Como")){
			JOptionPane.showMessageDialog(null, archivo.escribir_archivo(txtaCodigo.getText()) );
		}//if
    }//GEN-LAST:event_GuardarComoActionPerformed

    private void go_PRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_PRActionPerformed
        new TablaPR().setVisible(true);
    }//GEN-LAST:event_go_PRActionPerformed

    private void go_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_IDActionPerformed
        new TablaID().setVisible(true);
    }//GEN-LAST:event_go_IDActionPerformed

    private void AnalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AnalizarMouseClicked
       if(flArchivo.exists())
            {
        cadena="\n";
        Panterior=-1;Pactual=-1;
        if(txtaCodigo.getText().equals("")){
        showMessageDialog(null,"área de texto vacia");
        }
        else{
//        token.setRowCount(0);
        errores.clear();
        errorS.clear();
        r=1;
        txtaSalida.setText("");
            Validar_Cadenas();
            Errores();
            //if(errores.isEmpty()){
              VSintactico();
              ErroresS(); 
              
            //}
            if(cad.equals(""))
                txtaSalida.setForeground(Color.darkGray);
                txtaSalida.setText("¡Compilación exitosa!");    //Ventana errores}
               
                if (!(cad.equals("")))   {
                txtaSalida.setForeground(Color.BLUE);
                txtaSalida.setText(cad);    //Ventana errores
                        }
            System.out.println(cadena);
        }
        }
         else{
          cadena="\n";
        Panterior=-1;Pactual=-1;
        if(txtaCodigo.getText().equals("")){
        showMessageDialog(null,"área de texto vacia");
        }
        else{
        //archivo.escribir_archivo(txtaCodigo.getText());
       // token.setRowCount(0);
        errores.clear();
        errorS.clear();
        r=1;
        txtaSalida.setText("");
            Validar_Cadenas();
            Errores();
           // if(errores.isEmpty()){
              VSintactico();
              ErroresS(); 
              
            //}
            if(cad.equals(""))
                txtaSalida.setForeground(Color.darkGray);
                txtaSalida.setText("¡Compilación exitosa!");    //Ventana errores}
               
                if (!(cad.equals("")))   {
                txtaSalida.setForeground(Color.BLUE);
                txtaSalida.setText(cad);    //Ventana errores
                        }
            System.out.println(cadena);
        }   
         }
        
    }//GEN-LAST:event_AnalizarMouseClicked
public void VSintactico(){
linea=0;
int l=0;
t.clear();
int op=0,cn=0;
StringTokenizer lineas=new StringTokenizer(cadena,"\n");//CORTAMOS POR SALTOS DE LINEA
StringTokenizer tokens; 
while(lineas.hasMoreTokens()){//LEEMOS LINEA A LINEA
linea++;//incrementamos la linea 
tokens=new StringTokenizer(lineas.nextToken(),delimitador,true);//CORTAMOS CADA LINEA EN TOKENS SEPARADOS 
while(tokens.hasMoreTokens()){ 
String token=tokens.nextToken().trim(); 
if(!token.equals("")){ 
t.add(token);
Pactual=regresa(token);
if(Panterior>0){ 
if(grafo[Panterior][Pactual]==0){ 
    System.out.print("Numero de saltos: "+l);
    if(l>=1){linea=linea-l;}
System.out.println("Error sintactico en linea :"+(linea)+" Cerca de : "+token); 
errorS.add("Error sintactico cerca del token : "+t.get(cn-1)+" Linea "+(linea));
l=0;
} 
} 
cn++;
Panterior=Pactual; 
} 

}

} 
if(!(t.get(0).equals("inicio"))){ errorS.add("Error,No se encontro la estructura de inicio"); System.out.println("E1: ");}
if(!(t.get(t.size()-1)).equals("fin")){ errorS.add("Error,No se encontro la estructura de fin"); System.out.println("E2"); }
for(int j=0;j<=t.size()-1;j++){
    if(t.get(j).equals("orden_principal")){
       op=1;
    }     
}
if(op==0){errorS.add("Error, No cuenta con Orden principal"); }
}
static int regresa(String token){ 
   
for(int i=0;i<diccionario.length;i++){ 
if(token.equals(diccionario[i]))   return i;//REGRESAMOS LA POSICION DE EL TOKEN EN EL VECTOR 
} 
if(Character.isLetter(token.charAt(0))) 
return 3; //REGRESAMOS LAPOSICION DE LA VARIABLE EN EL VECTOR 

if(Character.isDigit(token.charAt(0))) 
return 24; //REGRESAMOS LAPOSICION DE LA VARIABLE EN EL VECTOR 

if(Character.isAlphabetic(token.charAt(0))) 
return 28; //REGRESAMOS LAPOSICION DE LA VARIABLE EN EL VECTOR 
else return 0;  
}
    private void txtaCodigoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtaCodigoFocusGained
//        UndoManager manager = new UndoManager();
//        action 
    }//GEN-LAST:event_txtaCodigoFocusGained

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if(txtaCodigo.getText().equals("")){
        showMessageDialog(null,"área de texto vacia");
        }
        else{
//        token.setRowCount(0);
        errores.clear();
        r=1;
        txtaSalida.setText("");
            Validar_Cadenas();
            Errores();
                txtaSalida.setForeground(Color.BLUE);
                txtaSalida.setText(cad);    //Ventana errores
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed
//--- ALMACENAR ERRORES EN CAD PARA MOSTRAR
public void Errores(){
     cad="";
    for(int e=0;e<errores.size();e++){cad=cad+errores.get(e)+"\n";}   //Guarda en cad los errores almacenados
}
public void ErroresS(){ //Errores Sitacticos
     cad="";
    for(int e=0;e<errorS.size();e++){cad=cad+errorS.get(e)+"\n";}   //Guarda en cad los errores almacenados
}
public String caracter;
public void Validar_Cadenas(){
caracter=txtaCodigo.getText();          //Asigna a variable caracter todo el texto del area
caracter=caracter.replace("\t"," ");    //Reemplaza tabulador por espacio
String car="";
     b1=0; //Apuntadores , b1--> inicial b2-->final
     b2=0;
     in=0; //Incremento de id y palabra reservada
     min=0;// Bandera de id y palabra reservada
     int inu=0,nu=0, COMENTARIO=0,COMILLA=0,SIMPLES=0,er=0; // inu--> Incremento numero, nu-->Bandera de numero
     for(i=0;i<caracter.length();i++){  //Recorrer todo el texto
         er=0;
         if(caracter.charAt(i)==44){};
          if (COMILLA==1&&(caracter.charAt(i)==34)){
                COMILLA=0;
                cadena=cadena+("\"\"");
                 Object []fila={("\""+car+"\""),"cadena"};
//                 token.addRow(fila);
                 car="";
                i++;
            }
            if (SIMPLES==1&&(caracter.charAt(i)==39)){
                SIMPLES=0;
                i++;
            }  
         if (caracter.length() - 1-i>1) {
                if(((""+caracter.charAt(i)).equals(">")&&(""+caracter.charAt(i+1)).equals(">"))&&COMENTARIO==1 )
                {
                    COMENTARIO=0;
                    i++;
                    i++;
                    b1=i;
                    }
                } //Comentarios
         if(COMILLA>0){ car=car+caracter.charAt(i);}
      
                 
            if(COMENTARIO==0&&SIMPLES==0&&COMILLA==0){
                
                 if(Character.isLowerCase(caracter.charAt(i))||caracter.charAt(i)=='_'||Character.isUpperCase(caracter.charAt(i))){
                        switch(nu){
                             case 0:{
                                 b2=i+1;
                                 in++;
                                 if(in==1){ b1=i; }
                                 min = 1;
                              break;
                            }   // 
                           case 1:{
                            if(caracter.length()-1-i<2){
                                numero();
                                nu=0;
                                b1=i;}
                            else if (!((caracter.charAt(i)=='e'))||((caracter.charAt(i)=='E'))){
                                numero();
                                nu=0;
                                b1=i;
                                b2=i+1;}         
                            else if(Character.isDigit(caracter.charAt(i+1))){
                                b2=i+1;}
                            else{
                                numero();
                                nu=0;
                            }  break;
                            } // 
                           case 2:{
                                p_r();
                                min=0;
                                nu=0; 
                                b1=i;
                                break;
                           } 
                        
                           default:{
                                b2=i+1;
                                break;
                            }
                        }//switch
                        
                        if (i == caracter.length()-1) {
                           p_r();min=0;}
                        
    }// Caso que puede ser un ID o PALABRA RESERVADA
                    
              else if (caracter.charAt(i)=='+'||caracter.charAt(i)=='-'||caracter.charAt(i)==';'){
                        if(caracter.charAt(i)==';'){
                            if(min==1){
                            p_r();
                            min=0;}
                            if(nu==1){
                            numero();
                            nu=0;
                            }
                            op_ar(); 
                            b1=i; 
                             }
                        else{
                         if(caracter.length()-i<2){
                            if (i==caracter.length()-1)  {
                                if(min==1){
                                   p_r();
                                   min=0;}
                                if(nu==1){
                                    numero();
                                    nu=0; }
                                    op_ar();
                            }
                            else{
                            if(min==1){
                              p_r();
                              min=0;
                              b1=1;}
                            
                            if(Character.isDigit(caracter.charAt(i+1))){
                                b2=i+1;
                                b1=i;
                                inu=1;
                                }
                            }
                        }
                         else{
                            if(min==1){
                               p_r();
                               min=0;}
                            if(nu==1){
                               numero();
                               nu=0;}
                            
                            if(Character.isDigit(caracter.charAt(i+1))){
                                b2=i+1;
                                b1=i;
                                inu=1;
                                }
                            else{
                            op_ar();
                            }
                        }
                        }     
                    }// Caso de op.aritemtica y delimitador ;
              
            else if (Character.isDigit(caracter.charAt(i))||caracter.charAt(i)=='.'){
                    if(min==1&&Character.isDigit(caracter.charAt(i))){ 
                       b2=i+1;
                       nu=2;
                    }//min==1 
                    else if(min==1&&!Character.isDigit(caracter.charAt(i))){
                            p_r();
                            min=0;
                            b1=i;} 
                    if(min==0){ 
                        b2=i+1;
                        inu++;
                        if(inu==1){ b1=i; }
                        nu = 1;
                      }
                    if (i == caracter.length()-1&&min==1) {
                        p_r();
                        min=0;}
                     else if (i == caracter.length()-1) {
                        numero();
                        nu=0;}
                    
                       } // Digito o punto
          
           else if(caracter.charAt(i)=='<'||caracter.charAt(i)=='>'){
                    if(min==1){ 
                        p_r();
                        min=0;
                    }//min==1
                    if(nu==1){ 
                        numero();   
                    }//nu=0
                       b1=i;
                    if(caracter.length()-i>0){
                       if(("" + caracter.charAt(i)).equals("<")&&("" + caracter.charAt(i+1)).equals("<")&&COMENTARIO==0){
                          COMENTARIO=1; }
                    }
                    
                    if(COMENTARIO==0){
                        if(caracter.charAt(i)=='>'){
                           if(i == caracter.length()-1){
                              b2=i+1;
                              op_relacional();
                             }
                           else if(i < caracter.length()-1){
                                 if(caracter.charAt(i)=='<'){
                                     b2=i+2;
                                     op_relacional();
                                     i++;
                                     b1=i+1;
                                 }
                                 else{
                                     b2=i+1;
                                     op_relacional();
                                 }
                             }    
                        }
                        else{
                            b2=i+1;
                            op_relacional();
                        } 
                    }
                } // CASO OPERADOR_RELACIONAL
           
           else if (caracter.charAt(i)=='(' ||caracter.charAt(i)==')'|| caracter.charAt(i)==']' 
                   || caracter.charAt(i)=='[' ||caracter.charAt(i)=='{' || caracter.charAt(i)==']') {
                        if(min==1){ 
                        p_r();
                        min=0; 
                    }//min==1
                    if(nu==1){ 
                        numero();
                        nu=0;
                    }//nu=0
                        b1=i;
                        agrupar();
                        }   // Simbolos de agrupación
           else if (caracter.charAt(i)=='|') {operadores(); }
           else if (caracter.charAt(i)=='='||caracter.charAt(i)==',' ) {
                    if(min==1){ 
                    p_r();
                    min=0;
                    }//min==1
                    if(nu==1){ 
                    numero();
                    nu=0;
                    }//nu=0
                    b1=i;
                    con_asig();
                    }// Asignacion y concatenacion
           
           else if (caracter.charAt(i)=='!') {
                        if(nu==1){ 
                        numero();
                        nu=0;
                        inu=0;}//nu=0
                    if(i==caracter.length()-1){
                         if(b2-b1!=1){
                            if(min==1){ 
                                b2=i;
                                p_r();
                                min=1;
                                b1=i;
                                in=1;}
                         }//min==1min=0;
                    }
                        if(min==1){ 
                            if(i==caracter.length()-1){
                                p_r();
                                min=0; 
                                b1=i;
                                b2=i+1;
                                operadores();
                                min=0;
                                in=0;
                            }
                            else{
                  
                          if((caracter.charAt(i-1)=='d'||caracter.charAt(i-1)=='a'||caracter.charAt(i-1)=='o'||caracter.charAt(i-1)=='u'||caracter.charAt(i-1)=='i'||caracter.charAt(i-1)=='n'||caracter.charAt(i-1)=='c')&&caracter.charAt(i+1)=='!' ){
                            if(b2-b1!=1){
                                 if(min==1){ 
                                    b2=i-1;
                                    p_r();
                                    min=0;
                                    b1=i-1;
                                    b2=i+2;
                                    in=0;
                                    operadores();
                            }
                            }
                            else{
                                b2=i+2;
                                operadores();
                                min=0;
                                in=0;
                            }
                            } //Operadores  
                                p_r();
                                min=0; 
                                min=0;
                                in=0;
                                b1=i;
                                b2=i+1;
                                operadores();
                            }
                        
                    }//min==1
                   
                    b1=i;
                         if(i==caracter.length()-1){
                         if(b2-b1!=1){
                            if(min==1){ 
                               b2=i;
                        p_r();
                        min=1;
                        b1=i;
                        in=1;
                            }
                    }//min==1min=0;
               }
                        if(min==1){ 
                            if(i==caracter.length()-1)
                            {
                               p_r();
                                min=0; 
                                b1=i;
                                b2=i+1;
                                operadores();
                            }
                            else{
                                b2=i+2;
                            operadores();
                            }
                                p_r();
                                min=0; 
                                min=0;
                                in=0;
                                b1=i;
                                b2=i+1;
                                operadores();
                            
                        
                    }//min==1
                   
                    b1=i;
}//Fin de operadores
           
           
           else if (caracter.charAt(i) == ' ') {//ESPACIO VACIO
                if (min == 1) {
                    p_r();
                }
                if (nu== 1) {
                    numero();           
                }
               min=0;
               nu=0;
               inu=0;
               in=0;
               b1 = i + 1;
            } 
        else if (caracter.charAt(i)=='\n') {//ENTER
            r++;
            cadena=cadena+"   \n";
            
                if (min == 1) {
                    p_r();
                }
                if (nu== 1) {
                   numero(); }
                
                b1 = i + 1;
                min=0;
                nu=0;
                inu=0;  
                in=0;
            
                    }
        else{ //Segun aqui caen los caracteres no validos
                      if(min==1){ 
                        p_r();
                        min=0;
                        
                    }//min==1
                    if(nu==1){ 
                        numero();
                        nu=0;
                        
                    }//nu=0
                    b1=i;
                    min=0;
               nu=0;
               inu=0;
               in=0;
               agrupar();
               switch (caracter.charAt(i)){
                    case 39:
                       
                        SIMPLES=1;
                        er++;
                        break;
                    case 34:
                        
                        COMILLA=1;
                        er++;
                    break;
                    
                }
                    }
                 
                 
                     //ERROR 
              if(er==0){
             if(caracter.charAt(i)>126 && caracter.charAt(i)<255 || caracter.charAt(i)>34 && caracter.charAt(i)<40 || caracter.charAt(i)==64 
                     || caracter.charAt(i)==96 || caracter.charAt(i)>90 && caracter.charAt(i)<95  ){
               
                 errores.add("Error lexico 1. En la linea : "+(r)+" ' "+caracter.charAt(i)+" ' Cadena no valida");
//                    Object []fila={(""+caracter.charAt(i)),"Error"};
//                    token.addRow(fila);
                b1=i+1; b2=i-1; 
                 }
              }
            }
    }// for

}//VALIDAR
//---------------------------------- EXPRESIONES
public void operadores(){ 
    Pattern   p =Pattern.compile("o!!|a!!|n!!|\\|");
        if(caracter.charAt(i)=='|'){  
            Matcher   m2 = p.matcher(caracter.charAt(i)+"");   
           // System.out.println(m2.matches()+"op_rel");
            if(m2.matches()==true){
               bandera=true;  
               Object []fila={caracter.charAt(i),"Operador lógico"};
//               token.addRow(fila);
               cadena=cadena+caracter.charAt(i)+"";
                b1=i+1;
                ren++;
            }//Operador lógico}
            }
        else {
    Matcher   m = p.matcher(caracter.substring(b1,b2));   
            //System.out.println(m.matches()+"op_rel");
            if(m.matches()==true){
               bandera=true;  
               Object []fila={caracter.substring(b1,b2),"Operador lógico"};
//               token.addRow(fila);
               cadena=cadena+caracter.substring(b1,b2)+"";
                b1=i+1;
                ren++;
            }//Operador lógico
        else {
            p = Pattern.compile("u!!|i!!|c!!|d!!");
            m = p.matcher(caracter.substring(b1,b2));   
            //System.out.println(m.matches()+"op_rel");
            if(m.matches()==true){
               bandera=true;  
               Object []fila={caracter.substring(b1,b2),"Operador de conjuntos"};
//               token.addRow(fila);
               cadena=cadena+caracter.substring(b1,b2)+"";
                b1=i+1;
                ren++;
           }//Operador de conjuntos
            }
            }
}
public void con_asig(){  
    Pattern p =Pattern.compile("=|,");
    Matcher m = p.matcher(""+caracter.charAt(i));   
            System.out.println(m.matches()+"op_ag");
            if(m.matches()==true){
             bandera=true;  
             cadena=cadena+caracter.charAt(i)+"";
            if((""+caracter.charAt(i)).equals("=")){ Object []fila={(""+caracter.charAt(i)),"Operador de asignación" }; /*token.addRow(fila);*/}
                else{
                Object []fila={(""+caracter.charAt(i)),"Operador de concatenación" }; /*token.addRow(fila)*/;}
               b1=i+1;
               ren++;
            }
}//Operador asignación
public void agrupar(){     
    Pattern  p =Pattern.compile("\\(|\\)|\\{|\\[|\\]|\\}");
    Matcher  m = p.matcher((""+caracter.charAt(i)));   
    //showMessageDialog(null,caracter.charAt(i));
            //System.out.println(m.matches()+"op_ag");
            if(m.matches()==true){
                bandera=true;  
                cadena=cadena+caracter.charAt(i)+"";
                Object []fila={(""+caracter.charAt(i)),"Operador de agrupación"};
//                token.addRow(fila);
                ren++;
            }
            b1=i+1;
}// Operador de agrupación
public void op_ar(){
   Pattern p =Pattern.compile(";|(\\+|-)");
   Matcher m = p.matcher(""+caracter.charAt(i));   
        //System.out.println(m.matches()+"op_ar");
        if(m.matches()==true){
         bandera=true;  
         cadena=cadena+caracter.charAt(i)+"";
         if((""+caracter.charAt(i)).equals(";")){ Object []fila={""+caracter.charAt(i),"Delimitador" }; /*token.addRow(fila)*/;}
         else { Object []fila={caracter.charAt(i),"Operador aritmetico" }; /*token.addRow(fila)*/;}
         ren++;
        }
        b1=i+1;
}//Operador arit
public void p_r(){
//showMessageDialog(null,caracter.substring(b1,b2);
Pattern p = Pattern.compile("conj|inicio|programa|fin|crear|afnd|afd|elemento|estado|estado_inicial|estado_final|cad|alidar|mostrar|alfabeto|gráfico|tabla|con|trn"
        + "|transicion|guardar_grafico|bool|ent|repetir|repetir_si|hacer|mientras|mt|cinta|automata|transicionmt|direccion|izq|der|imprimir|obtener|conjunto"
        + "|orden_principal|expresion_regular|orden|cad|bool|ent|estado_inicial|estado_final|estado|elemento|cinta|validar|expresion");
Matcher m = p.matcher(caracter.substring(b1,b2));   
//System.out.println(m.matches()+"p_r");
     if(m.matches()==true){
         bandera=true;  
         cadena=cadena+caracter.substring(b1,b2)+" ";
         Object []fila={caracter.substring(b1,b2),"Palabra reservada"};
//         token.addRow(fila);
         b1=i+1;
         ren++;
     }//Palabra Reservada
        else{
        p =Pattern.compile("[a-z-A-Z]{1,10}(\\_|[0-9]|[a-zA-Z])*?{1,10}?");
        m = p.matcher(caracter.substring(b1,b2));
  //      System.out.println(m.matches()+"Identificador");
        if(m.matches()==true){
            if(caracter.substring(b1,b2).length()>20) {
                errores.add("Error lexico 2. En la linea : "+(r)+" identificador ' "+caracter.substring(b1,b2)+" '  excede tamaño");
//                    Object []fila={caracter.substring(b1,b2),"Error"};
//                    token.addRow(fila);
                 }
            else{
           
            ids.add(caracter.substring(b1,b2)); //guarda id para tabla de id
            bandera=true; 
            cadena=cadena+caracter.substring(b1,b2)+" ";
            Object []fila={caracter.substring(b1,b2),"id"};
//            token.addRow(fila);
         //   String d= (String) tbl_tokens.getValueAt(ren-1,0);
           // showMessageDialog(null,d);
            ren++;
            }
            b1=i+1;     
    }
 }//Identificador
}//Plabras reservdas e identificadores
public void numero(){
          Pattern  q = Pattern.compile("([+|-]?[0-9]+((e|E)[0-9]+)?)|([+|-]?[0-9]+(\\.)?[0-9]+)((e|E)[0-9 | ]+)?");
          Matcher  n = q.matcher(caracter.substring(b1,b2));
    //        System.out.println(n.matches()+"numero");
            if(n.matches()==true){
                bandera=true;  
                cadena=cadena+caracter.substring(b1,b2)+"";
                Object []fila={caracter.substring(b1,b2),"Numero"};
//                token.addRow(fila);
                b1=i+1;
                ren++;
             }
            else{
            errores.add("Error lexico 3. En la linea : "+(r)+" numero no valido ' "+caracter.substring(b1,b2));
//                    Object []fila={caracter.substring(b1,b2),"Error"};
//                    token.addRow(fila);
            }
}//Número
public void op_relacional(){
        Pattern p =Pattern.compile("<|>|><");
        //showMessageDialog(null,caracter.substring(b1,b2));
        Matcher m = p.matcher(caracter.substring(b1,b2));   
      //  System.out.println(m.matches()+"op_rel");
            if(m.matches()==true){
                bandera=true;  
                cadena=cadena+caracter.substring(b1,b2)+"";
                Object []fila={caracter.substring(b1,b2),"Operador relacional"};
//                token.addRow(fila);
                b1=i+1;
                ren++;
            }                      
}//Operador Relacional
        

//---------------------------------- MANEJO DE ARCHIVOS        
public class Archivo{
	public Archivo()
	{
		fdGuardar=new FileDialog(fdGuardar, "Guardar como", FileDialog.SAVE);
		Ruta_del_archivo="";
		flArchivo=new File(Ruta_del_archivo);
	}//Constructor
 
	public String escribir_archivo(String texto_a_guardar)
	{
		String mTextos[]=texto_a_guardar.split("\n"), respuesta="";//Se detecta el salto de linea, se va colocando en el vector.
	//JOptionPane.showMessageDialog(null,texto_a_guardar);
		fdGuardar.setVisible(true);
		fdGuardar.dispose();
		Ruta_del_archivo=fdGuardar.getDirectory()+fdGuardar.getFile() + ".txt";
		flArchivo=new File(Ruta_del_archivo);
		//Este condicional no afecta en nada la forma de guardar el archivo pero si es bueno usarlo para no borrar un trabajo previo.
		if(flArchivo.exists())
		{
			respuesta="El archivo ya existia y ha sido sobreescrito. \nEn la direccion: " +  flArchivo.getPath( ) ;
		}//if
		else
		{
			respuesta="El archivo ha sido creado exitosamente.\nEn la direccion: " +  flArchivo.getPath( ) ;
		}//else*/
 
		try{
			//Este bloque de codigo obligatoriamente debe ir dentro de un try.
			fwArchivo_en_el_que_escribir=new FileWriter(flArchivo);//De momento se deja hasta aqui, listo para escribir, se escribe en el momento de dar la orden.
			for (int i=0; i<=mTextos.length-1;i++)
			{
				//Se va escribiendo cada linea en el archivo de texto.
				fwArchivo_en_el_que_escribir.write(mTextos[i] + "\r\n" );
			}//for
			//Este metodo escribe el archivo en el disco duro.
			bwEscritor=new BufferedWriter(fwArchivo_en_el_que_escribir);
			bwEscritor.close();//Se cierra el archivo.		
		}catch(Exception ex){JOptionPane.showMessageDialog(null,ex.getMessage());}
 
		return respuesta;
	}//escribir_archivo 
}//Class Archivo

    public static void main(String args[]) {
            
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VenPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Abrir;
    private javax.swing.JLabel Analizar;
    private javax.swing.JMenu Archivo;
    private javax.swing.JMenu Compilar;
    private javax.swing.JMenuItem Guardar;
    private javax.swing.JMenuItem GuardarComo;
    private javax.swing.JMenuBar MnuBar;
    private javax.swing.JMenuItem Nuevo;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenuItem go_ID;
    private javax.swing.JMenuItem go_PR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenu tablas_simbolos;
    public static javax.swing.JTextPane txtaCodigo;
    private javax.swing.JTextArea txtaSalida;
    // End of variables declaration//GEN-END:variables


}

