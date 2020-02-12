
package filmoteca02.views;

import filmoteca02.model.Pelicula;
import filmoteca02.bdd.GestionBDD;
import filmoteca02.model.Director;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame; 

public class ModificarPelicula extends JFrame {

   
    private GestionBDD baseDatos; 
    private ArrayList<Director> directores;  
    private ArrayList<String> generos; 
    private ArrayList<String> paises;
    private JFrame padre;    
    int clavePelicula = -1;


    
    public ModificarPelicula(JFrame padre, String titulo, GestionBDD baseDatos) {
        this.padre = padre;
        padre.setVisible(false);
        initComponents();
        // Centrar ventana
        this.setLocationRelativeTo(null);
        // Evitar que pueda remidensionarse la ventana
        this.setResizable(false);  
        lbTituloVentana.setText(titulo);
        lbErrorPelicula.setVisible(false);
        this.baseDatos = baseDatos; 
        directores = baseDatos.getAllDirectores();
        generos = baseDatos.getGeneros();
        paises = baseDatos.getPaises();
        this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent we) {
                    padre.setVisible(true);
                    dispose();
                }
        });
        prepararCombos();
    }
    
    private void prepararCombos(){
        
        for (String pais : paises)
            cbPais.addItem(pais);
        for (String genero : generos)
            cbGenero.addItem(genero);
        for (Director director : directores)
            cbDirector.addItem(director.toString());
        
        cbGenero.setSelectedIndex(0);
        cbPais.setSelectedIndex(0);
        cbDirector.setSelectedIndex(0);
    }
    
    public ModificarPelicula(   JFrame padre,
                                Pelicula pelicula, 
                                String titulo, 
                                GestionBDD baseDatos) {
        this(padre, titulo, baseDatos);
        this.clavePelicula = baseDatos.getClavePelicula(pelicula.getTitulo());
        txTitulo.setText(pelicula.getTitulo());            
        txDuracion.setText(pelicula.getDuracion() + "");
        cbGenero.setSelectedItem(pelicula.getGenero());
        cbPais.setSelectedItem(pelicula.getPais());
        cbDirector.setSelectedItem(pelicula.getDirector().toString());
        btAceptarPel.setText("Modificar");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btAceptarPel = new javax.swing.JButton();
        lbErrorPelicula = new javax.swing.JLabel();
        lbTituloVentana = new javax.swing.JLabel();
        lbTitulo = new javax.swing.JLabel();
        lbDirector = new javax.swing.JLabel();
        lbPais = new javax.swing.JLabel();
        lbDuracion = new javax.swing.JLabel();
        lbGenero = new javax.swing.JLabel();
        txTitulo = new javax.swing.JTextField();
        txDuracion = new javax.swing.JTextField();
        cbGenero = new javax.swing.JComboBox<>();
        cbDirector = new javax.swing.JComboBox<>();
        cbPais = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pelicula");

        btAceptarPel.setBackground(new java.awt.Color(0, 228, 228));
        btAceptarPel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btAceptarPel.setText("Insertar");
        btAceptarPel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAceptarPel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarPelActionPerformed(evt);
            }
        });

        lbErrorPelicula.setBackground(new java.awt.Color(255, 255, 255));
        lbErrorPelicula.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbErrorPelicula.setForeground(new java.awt.Color(204, 0, 204));
        lbErrorPelicula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbErrorPelicula.setOpaque(true);

        lbTituloVentana.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbTituloVentana.setForeground(new java.awt.Color(153, 0, 0));
        lbTituloVentana.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbTitulo.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(0, 0, 153));
        lbTitulo.setText("Título");

        lbDirector.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lbDirector.setForeground(new java.awt.Color(0, 0, 153));
        lbDirector.setText("Director");

        lbPais.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lbPais.setForeground(new java.awt.Color(0, 0, 153));
        lbPais.setText("País");

        lbDuracion.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lbDuracion.setForeground(new java.awt.Color(0, 0, 153));
        lbDuracion.setText("Duración");

        lbGenero.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lbGenero.setForeground(new java.awt.Color(0, 0, 153));
        lbGenero.setText("Género");

        txTitulo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txTitulo.setMargin(new java.awt.Insets(2, 8, 2, 2));
        txTitulo.setName(""); // NOI18N

        txDuracion.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txDuracion.setMargin(new java.awt.Insets(2, 8, 2, 2));
        txDuracion.setName(""); // NOI18N

        cbGenero.setBackground(new java.awt.Color(255, 255, 204));
        cbGenero.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbGenero.setForeground(new java.awt.Color(82, 82, 82));
        cbGenero.setToolTipText("Seleccione Género Película");

        cbDirector.setBackground(new java.awt.Color(255, 255, 230));
        cbDirector.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbDirector.setForeground(new java.awt.Color(82, 82, 82));
        cbDirector.setToolTipText("Seleccione Director Película");
        cbDirector.setName(""); // NOI18N

        cbPais.setBackground(new java.awt.Color(255, 255, 204));
        cbPais.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbPais.setForeground(new java.awt.Color(82, 82, 82));
        cbPais.setToolTipText("Seleccione País");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(btAceptarPel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbTituloVentana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbDuracion)
                                    .addComponent(lbGenero)
                                    .addComponent(lbDirector)
                                    .addComponent(lbPais))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txTitulo)
                                    .addComponent(txDuracion)
                                    .addComponent(cbGenero, 0, 188, Short.MAX_VALUE)
                                    .addComponent(cbDirector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbPais, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 46, Short.MAX_VALUE)
                .addComponent(lbErrorPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lbTituloVentana)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTitulo)
                    .addComponent(txTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDirector))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPais))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDuracion))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbGenero))
                .addGap(45, 45, 45)
                .addComponent(btAceptarPel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(lbErrorPelicula)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAceptarPelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarPelActionPerformed
        String mensaje = ""; 
        lbErrorPelicula.setVisible(false);    
        String titulo = txTitulo.getText().trim();
        int duracion = -1;     
        if (titulo.isEmpty()){
                mensaje = "Indicar titulo. ";
        }
        try{
            duracion = Integer.parseInt(txDuracion.getText().trim());
            if (duracion < 1 )
                mensaje += "Duración no válida ";
        }catch (NumberFormatException e){
            mensaje += "Duración no válida ";
        }
        if(mensaje.length()<1){
            Pelicula pelicula = new Pelicula ( 
                                titulo,
                                directores.get(cbDirector.getSelectedIndex()), 
                                cbPais.getSelectedItem().toString(), 
                                duracion, 
                                cbGenero.getSelectedItem().toString()
            );
        
            if (clavePelicula < 0){
                if (baseDatos.existePelicula(titulo)){                
                    mensaje = "Error. Película ya está en base datos";
                }else{
                     baseDatos.insertarPelicula(pelicula);
                    mensaje = "Pelicula insertada correctamente";
                    ( (VentanaFilmoteca) padre).cargarPeliculas();
                    txDuracion.setText(""); 
                    txTitulo.setText("");         
                }
            }else{    
                int clave = 
                    baseDatos.getClavePelicula(pelicula.getTitulo());
                if ( clave < 0 || clave == clavePelicula){
                    baseDatos.modificarPelicula(clavePelicula, pelicula);
                    mensaje = "Pelicula modificada correctamente";
                    ( (VentanaFilmoteca) padre).cargarPeliculas();
                    txDuracion.setText(""); 
                    txTitulo.setText(""); 
                }else{
                    mensaje = "Error. Título pertenece a otra Película";
                }
            }                
        }  
        lbErrorPelicula.setText(mensaje); 
        lbErrorPelicula.setVisible(true);   
    }//GEN-LAST:event_btAceptarPelActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAceptarPel;
    private javax.swing.JComboBox<String> cbDirector;
    private javax.swing.JComboBox<String> cbGenero;
    private javax.swing.JComboBox<String> cbPais;
    private javax.swing.JLabel lbDirector;
    private javax.swing.JLabel lbDuracion;
    private javax.swing.JLabel lbErrorPelicula;
    private javax.swing.JLabel lbGenero;
    private javax.swing.JLabel lbPais;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbTituloVentana;
    private javax.swing.JTextField txDuracion;
    private javax.swing.JTextField txTitulo;
    // End of variables declaration//GEN-END:variables
}