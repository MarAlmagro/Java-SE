
package filmoteca02.views;

import filmoteca02.model.Pelicula;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class VentanaPeliculas extends JFrame {
    
    private static final String MENSAJE = "\nNo hay películas para mostrar\n\n";
    private static final String TITULO = "Mensaje";
    private static final String MINUTOS = " minutos";
    // Películas para mostrar en la ventana
    private ArrayList<Pelicula> peliculas;
    // Posición que ocupa, en el ArrayList "peliculas", 
    // la película que se está visualizando en la ventana
    private int posActual;
    
    /**
     * Creates new form VentanaPeliculas
     */
    public VentanaPeliculas() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Centrar ventana
        this.setLocationRelativeTo(null);
        // Evitar que pueda remidensionarse la ventana
        this.setResizable(false);        
    }
    
    public VentanaPeliculas(ArrayList<Pelicula> peliculas){
       this();
       setPeliculas(peliculas);
    }
    // Muestra en la ventana los datos de la película 
    // que está en la posición actual
    private void mostrarPelicula(){
        if (posActual > 0)
            btAnterior.setEnabled(true);
        else
            btAnterior.setEnabled(false);
        
        if ( (posActual + 1) < peliculas.size())
            btSiguiente.setEnabled(true);
        else
            btSiguiente.setEnabled(false);
        
        Pelicula pelicula = peliculas.get(posActual);
        
        txDuracion.setText( pelicula.getDuracion() + MINUTOS );
        txDirector.setText( pelicula.getDirector().toString());
        txPais.setText( pelicula.getPais() );
        txGenero.setText( pelicula.getGenero() );
        txTitulo.setText( pelicula.getTitulo() );
    }

    public final void setPeliculas(ArrayList<Pelicula> peliculas) {
        this.peliculas = new ArrayList<> (peliculas);
        posActual = 0;
        if (peliculas.size() > 0)
            mostrarPelicula();
        else       
             JOptionPane.showMessageDialog(
                     this, 
                     MENSAJE, 
                     TITULO, 
                     JOptionPane.INFORMATION_MESSAGE
             );        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTituloVentana = new javax.swing.JLabel();
        lbTitulo = new javax.swing.JLabel();
        lbDirector = new javax.swing.JLabel();
        lbPais = new javax.swing.JLabel();
        lbDuracion = new javax.swing.JLabel();
        lbGenero = new javax.swing.JLabel();
        btAnterior = new javax.swing.JButton();
        btSiguiente = new javax.swing.JButton();
        txTitulo = new javax.swing.JTextField();
        txDuracion = new javax.swing.JTextField();
        txGenero = new javax.swing.JTextField();
        txDirector = new javax.swing.JTextField();
        txPais = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Listado Películas");
        setResizable(false);

        lbTituloVentana.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbTituloVentana.setForeground(new java.awt.Color(153, 0, 0));
        lbTituloVentana.setText("PELÍCULAS");

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

        btAnterior.setBackground(new java.awt.Color(0, 228, 228));
        btAnterior.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btAnterior.setText("<<  ANTERIOR");
        btAnterior.setToolTipText("Película Anterior");
        btAnterior.setActionCommand("");
        btAnterior.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAnterior.setEnabled(false);
        btAnterior.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnteriorActionPerformed(evt);
            }
        });

        btSiguiente.setBackground(new java.awt.Color(0, 228, 228));
        btSiguiente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btSiguiente.setText("SIGUIENTE  >>");
        btSiguiente.setToolTipText("Siguiente Película");
        btSiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btSiguiente.setEnabled(false);
        btSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSiguienteActionPerformed(evt);
            }
        });

        txTitulo.setEditable(false);
        txTitulo.setBackground(new java.awt.Color(255, 255, 255));
        txTitulo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txTitulo.setToolTipText("Título Película");
        txTitulo.setMargin(new java.awt.Insets(2, 8, 2, 2));

        txDuracion.setEditable(false);
        txDuracion.setBackground(new java.awt.Color(255, 255, 255));
        txDuracion.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txDuracion.setToolTipText("Duración Película");
        txDuracion.setMargin(new java.awt.Insets(2, 8, 2, 2));
        txDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDuracionActionPerformed(evt);
            }
        });

        txGenero.setEditable(false);
        txGenero.setBackground(new java.awt.Color(255, 255, 255));
        txGenero.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txGenero.setToolTipText("Género Película");
        txGenero.setMargin(new java.awt.Insets(2, 8, 2, 2));

        txDirector.setEditable(false);
        txDirector.setBackground(new java.awt.Color(255, 255, 255));
        txDirector.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txDirector.setToolTipText("Director Película");
        txDirector.setMargin(new java.awt.Insets(2, 8, 2, 2));
        txDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDirectorActionPerformed(evt);
            }
        });

        txPais.setEditable(false);
        txPais.setBackground(new java.awt.Color(255, 255, 255));
        txPais.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txPais.setToolTipText("País Película");
        txPais.setMargin(new java.awt.Insets(2, 8, 2, 2));
        txPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPaisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(lbTituloVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btAnterior)
                                .addGap(73, 73, 73)
                                .addComponent(btSiguiente))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTitulo)
                                    .addComponent(lbDirector)
                                    .addComponent(lbPais)
                                    .addComponent(lbDuracion)
                                    .addComponent(lbGenero))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txTitulo)
                                    .addComponent(txDirector)
                                    .addComponent(txPais)
                                    .addComponent(txDuracion)
                                    .addComponent(txGenero))))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lbTituloVentana)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTitulo)
                    .addComponent(txTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDirector)
                    .addComponent(txDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPais)
                    .addComponent(txPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDuracion)
                    .addComponent(txDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGenero)
                    .addComponent(txGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSiguiente)
                    .addComponent(btAnterior))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSiguienteActionPerformed
        posActual++;
        mostrarPelicula();
    }//GEN-LAST:event_btSiguienteActionPerformed

    private void btAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnteriorActionPerformed
        posActual--;
        mostrarPelicula();
    }//GEN-LAST:event_btAnteriorActionPerformed

    private void txDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDirectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txDirectorActionPerformed

    private void txDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDuracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txDuracionActionPerformed

    private void txPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txPaisActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAnterior;
    private javax.swing.JButton btSiguiente;
    private javax.swing.JLabel lbDirector;
    private javax.swing.JLabel lbDuracion;
    private javax.swing.JLabel lbGenero;
    private javax.swing.JLabel lbPais;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbTituloVentana;
    private javax.swing.JTextField txDirector;
    private javax.swing.JTextField txDuracion;
    private javax.swing.JTextField txGenero;
    private javax.swing.JTextField txPais;
    private javax.swing.JTextField txTitulo;
    // End of variables declaration//GEN-END:variables
}
