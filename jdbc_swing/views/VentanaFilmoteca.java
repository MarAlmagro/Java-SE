
package filmoteca02.views;

import filmoteca02.bdd.GestionBDD;
import filmoteca02.model.Director;
import filmoteca02.model.Pelicula;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame; 


public class VentanaFilmoteca extends JFrame {
    private ArrayList<String> generos;
    private ArrayList<Director> directores;
    private ArrayList<Pelicula> peliculas;
    private GestionBDD baseDatos;
    /**
     * Creates new form Filmoteca
     */
    public VentanaFilmoteca() {
        initComponents();
        // Centrar ventana
        this.setLocationRelativeTo(null);
        // Evitar que pueda remidensionarse la ventana
        this.setResizable(false); 
        this.generos = new ArrayList();
        this.directores = new ArrayList();
        this.peliculas = new ArrayList();
        rbPelicula.setSelected(true);
        rbDirector.setSelected(false);
        lbErroresPpal.setVisible(false);
        lbErroresListados.setVisible(false);
    }
    public VentanaFilmoteca(GestionBDD baseDatos) {
        this();
        if (baseDatos != null){
            this.baseDatos = baseDatos;
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent we) {
                    try {
                        // Cerrar conexión con base datos
                        GestionBDD.desconectar();                
                    }catch (SQLException ex){
                        System.out.println( 
                                "Error cerrando base datos\n"+ ex.getMessage() 
                        );
                    }finally{
                        System.exit(0);
                    }
                }
            });
            
            rbPelicula.addItemListener(new ItemListener() { 
                @Override
                public void itemStateChanged(ItemEvent event) {
                    int estado = event.getStateChange();
                    if (estado == ItemEvent.SELECTED) {
                        lbPelDir.setText ("Película a Modificar o Eliminar");
                        cargarPeliculas();
                        if ( directores.size() < 1 
                             || generos.size() < 1
                             || baseDatos.getPaises().size() < 1 ){
                           btInsertar.setEnabled(false);                             
                        }else{
                           btInsertar.setEnabled(true); 
                        }
                    } else {
                        lbPelDir.setText ("Director a Modificar o Eliminar");
                        cargarDirectoresOperaciones();
                    }                    
                }
            });
            actualizarCombos();
        }else{
            btEliminar.setEnabled(false);
            btInsertar.setEnabled(false);
            btListar.setEnabled(false);
            btModificar.setEnabled(false);
            rbPelicula.setEnabled(false);
            rbDirector.setEnabled(false);
            lbErroresPpal.setText("Error conexión con base datos");
            lbErroresPpal.setVisible(true);
        }
    }
    private void actualizarCombos(){
        cargarPeliculas();
        btListar.setEnabled(true);     
        cargarDirectores();
        cargarGeneros();    
        if (peliculas.size()<1){
            btListar.setEnabled(false);            
        }
    }
    
    public void cargarPeliculas(){
        peliculas = baseDatos.getAllPeliculas();
        if (rbPelicula.isSelected()){
            cbPelDir.removeAllItems();
            if (peliculas.size() > 0){   
                btEliminar.setEnabled(true);
                btModificar.setEnabled(true);  
                lbErroresPpal.setVisible(false);     
                for (Pelicula p : peliculas){
                    cbPelDir.addItem(p.getTitulo());
                }
                cbPelDir.setSelectedIndex(0);
            }else{
                btEliminar.setEnabled(false);
                btModificar.setEnabled(false);
                lbErroresPpal.setText( "No hay peliculas en base datos" );
                lbErroresPpal.setVisible(true);
            }
        }
    }
    public void cargarDirectores(){       
        directores = baseDatos.getAllDirectores();
        cargarDirectoresListados();
        if (rbDirector.isSelected()){
            cargarDirectoresOperaciones();
        }
    }
    private void cargarDirectoresOperaciones(){   
        cbPelDir.removeAllItems(); 
        if (directores.size() > 0){   
            btEliminar.setEnabled(true);
            btModificar.setEnabled(true);  
            lbErroresPpal.setVisible(false); 
            lbErroresPpal.setText("");    
            for (Director d : this.directores){       
                cbPelDir.addItem(d.toString());
            }
            cbPelDir.setSelectedIndex(0);
        }else{
            btEliminar.setEnabled(false);
            btModificar.setEnabled(false);
            lbErroresPpal.setText( "No hay directores en base datos" );
            lbErroresPpal.setVisible(true);
        }
    }
    private void cargarDirectoresListados(){  
        cbDirectorPpal.removeAllItems();
        lbErroresListados.setVisible(false);
        lbErroresListados.setText( "" );
        if (directores.size() > 0){
            cbDirectorPpal.addItem("**  TODOS  **");
            for (Director d : this.directores){
               cbDirectorPpal.addItem(d.toString());
            }
            cbDirectorPpal.setSelectedIndex(0);
            if (generos.size()>0)
                btListar.setEnabled(true);    
        }else{
            btListar.setEnabled(false);
            lbErroresListados.setText( "Sin directores en base datos. " );
            lbErroresListados.setVisible(true);
        }
    }
    private void cargarGeneros(){    
        generos = baseDatos.getGeneros();
        cbGeneroPpal.removeAllItems();
        if (generos.size() > 0){
            cbGeneroPpal.addItem("**  TODOS  **");
            for (String s : baseDatos.getGeneros()){
                cbGeneroPpal.addItem(s);
            }
            cbGeneroPpal.setSelectedIndex(0);
            if (directores.size()>0){
                btListar.setEnabled(true);
                lbErroresListados.setVisible(false);
            }
                    
        }else{
            btListar.setEnabled(false);
            lbErroresListados.setText( 
                    lbErroresListados.getText() + "Sin géneros a mostrar." );
            lbErroresListados.setVisible(true);            
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

        bgPeliculaDirector = new javax.swing.ButtonGroup();
        lbOperaciones = new javax.swing.JLabel();
        lbListados = new javax.swing.JLabel();
        cbDirectorPpal = new javax.swing.JComboBox<>();
        cbGeneroPpal = new javax.swing.JComboBox<>();
        rbPelicula = new javax.swing.JRadioButton();
        rbDirector = new javax.swing.JRadioButton();
        btInsertar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        cbPelDir = new javax.swing.JComboBox<>();
        btListar = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();
        lbDirector = new javax.swing.JLabel();
        lbGenero = new javax.swing.JLabel();
        lbPelDir = new javax.swing.JLabel();
        lbErroresPpal = new javax.swing.JLabel();
        lbErroresListados = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Filmoteca");

        lbOperaciones.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbOperaciones.setForeground(new java.awt.Color(153, 0, 0));
        lbOperaciones.setText(" Operaciones");

        lbListados.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbListados.setForeground(new java.awt.Color(153, 0, 0));
        lbListados.setText("Listado Películas");
        lbListados.setToolTipText("");

        cbDirectorPpal.setBackground(new java.awt.Color(255, 255, 204));
        cbDirectorPpal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbDirectorPpal.setToolTipText("Seleccione Director Película");
        cbDirectorPpal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cbGeneroPpal.setBackground(new java.awt.Color(255, 255, 204));
        cbGeneroPpal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbGeneroPpal.setToolTipText("Seleccione Género Película");

        bgPeliculaDirector.add(rbPelicula);
        rbPelicula.setText("Película");
        rbPelicula.setToolTipText("Elegir operar en Películas");
        rbPelicula.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        bgPeliculaDirector.add(rbDirector);
        rbDirector.setText("Director");
        rbDirector.setToolTipText("Elegir operar en Directores");
        rbDirector.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btInsertar.setBackground(new java.awt.Color(0, 228, 228));
        btInsertar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btInsertar.setText("Insertar");
        btInsertar.setToolTipText("Insertar Película o Director");
        btInsertar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInsertarActionPerformed(evt);
            }
        });

        btModificar.setBackground(new java.awt.Color(0, 228, 228));
        btModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btModificar.setText("Modificar");
        btModificar.setToolTipText("Modificar Película o Director");
        btModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });

        btEliminar.setBackground(new java.awt.Color(0, 228, 228));
        btEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btEliminar.setText("Eliminar");
        btEliminar.setToolTipText("Eliminar Película o Director");
        btEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btEliminar.setPreferredSize(new java.awt.Dimension(89, 23));
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });

        cbPelDir.setBackground(new java.awt.Color(255, 255, 204));
        cbPelDir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbPelDir.setToolTipText("Seleccionar Pelicula o Director");

        btListar.setBackground(new java.awt.Color(0, 228, 228));
        btListar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btListar.setText("Ver Listado");
        btListar.setToolTipText("Ver listado películas");
        btListar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListarActionPerformed(evt);
            }
        });

        separador.setForeground(new java.awt.Color(0, 0, 0));

        lbDirector.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lbDirector.setForeground(new java.awt.Color(0, 0, 153));
        lbDirector.setText("Director");

        lbGenero.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lbGenero.setForeground(new java.awt.Color(0, 0, 153));
        lbGenero.setText(" Género");
        lbGenero.setToolTipText("");

        lbPelDir.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lbPelDir.setForeground(new java.awt.Color(0, 0, 153));
        lbPelDir.setText("Película a Modificar o Eliminar");

        lbErroresPpal.setBackground(new java.awt.Color(255, 255, 255));
        lbErroresPpal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbErroresPpal.setForeground(new java.awt.Color(204, 0, 204));
        lbErroresPpal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbErroresPpal.setOpaque(true);

        lbErroresListados.setBackground(new java.awt.Color(255, 255, 255));
        lbErroresListados.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbErroresListados.setForeground(new java.awt.Color(204, 0, 204));
        lbErroresListados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbErroresListados.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lbErroresListados, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbErroresPpal, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPelDir, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPelDir, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbDirectorPpal, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbGeneroPpal, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(rbPelicula)
                        .addGap(114, 114, 114)
                        .addComponent(rbDirector))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(btListar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbListados, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbOperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbOperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbPelicula)
                    .addComponent(rbDirector))
                .addGap(18, 18, 18)
                .addComponent(btInsertar)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPelDir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPelDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btModificar)
                .addGap(18, 18, 18)
                .addComponent(lbErroresPpal)
                .addGap(18, 18, 18)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(lbListados, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDirector, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbGenero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbGeneroPpal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDirectorPpal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(btListar)
                .addGap(18, 18, 18)
                .addComponent(lbErroresListados)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Abre una nueva ventana que muestra las películas base datos que son 
    // del director y género seleccionados 
    private void btListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarActionPerformed
        // TODO add your handling code here:
        lbErroresListados.setVisible(false);
        ArrayList<Pelicula> listadoPeliculas = getPeliculasListado();
        if (listadoPeliculas.size()> 0){
            new VentanaPeliculas(listadoPeliculas).setVisible(true);
        }else{  
            lbErroresListados.setText(
                    "No hay películas para la selección actual"
            );
            lbErroresListados.setVisible(true);
        }
    }//GEN-LAST:event_btListarActionPerformed
    // Devuelve las películas de la base datos que son del género y director
    // seleccionados en los JComboBox del apartado Listados
    private ArrayList<Pelicula> getPeliculasListado(){
        int indexDirector = cbDirectorPpal.getSelectedIndex();
        int indexGenero = cbGeneroPpal.getSelectedIndex();
        if (indexDirector == 0 && indexGenero == 0)
            return peliculas;
        int claveDirector = -1;
        int claveGenero = -1;
        if (indexDirector >0){
            claveDirector = 
                  baseDatos.getClaveDirector(directores.get(indexDirector - 1));
        }
        if (indexGenero >0) {
            claveGenero = 
                   baseDatos.getClaveGenero(generos.get(indexGenero - 1));
        }
        if (indexDirector == 0 && indexGenero > 0){
            return baseDatos.getPeliculasPorGenero(claveGenero);
        }
        if (indexDirector > 0 && indexGenero == 0)
            return baseDatos.getPeliculasPorDirector(claveDirector);
        
        return baseDatos.getPeliculas(claveDirector, claveGenero);
    }
    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
         int index = cbPelDir.getSelectedIndex();   
         int clave = -1;
         if (rbDirector.isSelected()){
             clave = baseDatos.getClaveDirector(directores.get(index));
             new ModificarDirector(
                 this, clave, "Modificar Director", baseDatos).setVisible(true);
         }else{     
            Pelicula pelicula = peliculas.get(index);         
            new ModificarPelicula(
               this, pelicula, "Modificar Película", baseDatos).setVisible(true);
         }
    }//GEN-LAST:event_btModificarActionPerformed
    // Elimina la película o el director que ha seleccionado el usuario
    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        int index = cbPelDir.getSelectedIndex();
        lbErroresPpal.setVisible(false);
        if (rbDirector.isSelected()){
            int clave = baseDatos.getClaveDirector(directores.get(index));
            // Eliminar el director si no tiene peliculas en base datos
            if ( baseDatos.getPeliculasPorDirector(clave).size() < 1){
                baseDatos.eliminarDirector(directores.get(index));
                actualizarCombos();
            }else{                
                lbErroresPpal.setText("Director con películas, no eliminado");
                lbErroresPpal.setVisible(true);
            }
        }else{
            baseDatos.eliminarPelicula(peliculas.get(index));   
            actualizarCombos();
        }
    }//GEN-LAST:event_btEliminarActionPerformed

    private void btInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInsertarActionPerformed
         if (rbDirector.isSelected()){
             new ModificarDirector(
                     this, "Insertar Director", baseDatos).setVisible(true);
         }else{             
             new ModificarPelicula(
                     this, "Insertar Película", baseDatos).setVisible(true);
         }
    }//GEN-LAST:event_btInsertarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgPeliculaDirector;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btInsertar;
    private javax.swing.JButton btListar;
    private javax.swing.JButton btModificar;
    private javax.swing.JComboBox<String> cbDirectorPpal;
    private javax.swing.JComboBox<String> cbGeneroPpal;
    private javax.swing.JComboBox<String> cbPelDir;
    private javax.swing.JLabel lbDirector;
    private javax.swing.JLabel lbErroresListados;
    private javax.swing.JLabel lbErroresPpal;
    private javax.swing.JLabel lbGenero;
    private javax.swing.JLabel lbListados;
    private javax.swing.JLabel lbOperaciones;
    private javax.swing.JLabel lbPelDir;
    private javax.swing.JRadioButton rbDirector;
    private javax.swing.JRadioButton rbPelicula;
    private javax.swing.JSeparator separador;
    // End of variables declaration//GEN-END:variables
}
