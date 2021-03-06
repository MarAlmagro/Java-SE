
package filmoteca02.views;

import filmoteca02.bdd.GestionBDD;
import filmoteca02.model.Director;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;


public class ModificarDirector extends JFrame {

    private GestionBDD baseDatos;
    private JFrame padre;
    int claveDirector = -1;
    Director director;

   
    public ModificarDirector(JFrame padre, String titulo, GestionBDD baseDatos) {
        this.padre = padre;
        padre.setVisible(false);
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Centrar ventana
        this.setLocationRelativeTo(null);
        // Evitar que pueda remidensionarse la ventana
        this.setResizable(false);  
        lbTitulo.setText(titulo);
        lbErrorDirector.setVisible(false);
        this.baseDatos = baseDatos;
        this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent we) {
                    padre.setVisible(true);
                    dispose();
                }
        });
    }
    
    public ModificarDirector( JFrame padre, 
                              int clave, 
                              String titulo, 
                              GestionBDD baseDatos ) 
    {
        this(padre, titulo, baseDatos);
        this.claveDirector = clave;
        btAceptarDir.setText("Modificar");
        this.director = baseDatos.getDirector(claveDirector);
        txNombre.setText(director.getNombre());            
        txApellidos.setText(director.getApellidos());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitulo = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbApellidos = new javax.swing.JLabel();
        btAceptarDir = new javax.swing.JButton();
        lbErrorDirector = new javax.swing.JLabel();
        txNombre = new javax.swing.JTextField();
        txApellidos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Director");

        lbTitulo.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(153, 0, 0));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbNombre.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lbNombre.setForeground(new java.awt.Color(0, 0, 153));
        lbNombre.setText("Nombre");

        lbApellidos.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lbApellidos.setForeground(new java.awt.Color(0, 0, 153));
        lbApellidos.setText("Apellidos");

        btAceptarDir.setBackground(new java.awt.Color(0, 228, 228));
        btAceptarDir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btAceptarDir.setText("Insertar");
        btAceptarDir.setToolTipText("Modificar o Insertar Director");
        btAceptarDir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAceptarDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarDirActionPerformed(evt);
            }
        });

        lbErrorDirector.setBackground(new java.awt.Color(255, 255, 255));
        lbErrorDirector.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbErrorDirector.setForeground(new java.awt.Color(204, 0, 204));
        lbErrorDirector.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbErrorDirector.setOpaque(true);

        txNombre.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txNombre.setToolTipText("Nombre Director");
        txNombre.setMargin(new java.awt.Insets(2, 8, 2, 2));

        txApellidos.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txApellidos.setToolTipText("Apellidos Director");
        txApellidos.setMargin(new java.awt.Insets(2, 8, 2, 2));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbApellidos)
                                    .addComponent(lbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                    .addComponent(txApellidos)))
                            .addComponent(lbErrorDirector, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                            .addComponent(lbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(btAceptarDir, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbTitulo)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombre)
                    .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbApellidos)
                    .addComponent(txApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btAceptarDir)
                .addGap(30, 30, 30)
                .addComponent(lbErrorDirector)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAceptarDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarDirActionPerformed
        // TODO add your handling code here:
        String mensaje = "";   
        lbErrorDirector.setVisible(false); 
        String nombre = txNombre.getText().trim();        
        String apellidos = txApellidos.getText().trim(); 
        if (nombre.isEmpty()){
                mensaje = "Indicar nombre. ";
        }
        if (apellidos.isEmpty()){
                mensaje += "Indicar apellidos";
        }
        if(mensaje.length()<1){
                  
            if (claveDirector < 0){
                if (baseDatos.existeDirector(nombre, apellidos)){                
                    mensaje = "Error. Director ya está en base datos";
                }else{
                    baseDatos.insertarDirector(nombre, apellidos);
                    mensaje = "Director insertado correctamente";
                    ( (VentanaFilmoteca) padre).cargarDirectores();
                    txNombre.setText("");
                    txApellidos.setText("");                
                } 
            }else{
                int clave = 
                    baseDatos.getClaveDirector(new Director(nombre, apellidos));
                if ( clave < 0 || clave == claveDirector){
                    baseDatos.modificarDirector(claveDirector, nombre, apellidos);
                    mensaje = "Director modificado correctamente";
                    ( (VentanaFilmoteca) padre).cargarDirectores();
                    txNombre.setText("");
                    txApellidos.setText("");
                }else{
                    mensaje = "Error. Datos pertenecen a otro Director";
                }
            }
        }   
        lbErrorDirector.setText(mensaje); 
        lbErrorDirector.setVisible(true);  
    }//GEN-LAST:event_btAceptarDirActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAceptarDir;
    private javax.swing.JLabel lbApellidos;
    private javax.swing.JLabel lbErrorDirector;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTextField txApellidos;
    private javax.swing.JTextField txNombre;
    // End of variables declaration//GEN-END:variables
}
