
package filmoteca02.bdd;

import filmoteca02.model.Director;
import filmoteca02.model.Pelicula;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestionBDD{
	
    private static final String NOMBRE_BBDD = "secondfilmoteca";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static final String URL_CONEXION = 
        "jdbc:mysql://localhost:3306/"+ NOMBRE_BBDD + "?serverTimezone=UTC";

    // Conexión con la BBDD
    private static Connection conex;

    // Devuelve referencia a la conexión con la BBDD
    public static Connection getConexion() {		
        return conex;
    }
    // Establece conexión con la BBDD
    public static void conectar() throws SQLException{
        conex = DriverManager.getConnection(URL_CONEXION, USER, PASSWORD);
    }	
    // Liberar/Cerrar conexión con la BBDD
    public static void desconectar() throws SQLException{	
        if (conex != null)
                conex.close();
    }
    // Elimina de la base de datos el director cuyo nombre y apellidos
    // son los que se pasan como parámetros
    public void eliminarDirector(String nombre, String apellidos) {
        if ( nombre == null || apellidos == null)
            return;
        String query =  "DELETE FROM directores WHERE nombre = '" 
                        + nombre.toUpperCase() + "' AND apellidos = '" 
                        + apellidos.toUpperCase() + "';"; 
        try {
           Statement st = conex.createStatement();
           st.executeUpdate(query);	
           st.close();
        }catch (SQLException ex){
            System.out.println( "Error borrando director '" 
                                + nombre + " " + apellidos 
                                + "': " + ex.getMessage());
        }
    }

    // Elimina de la base datos el director que se pasa como parámetro
    public void eliminarDirector(Director director) {
        if (director != null)
            eliminarDirector(director.getNombre(), director.getApellidos());
    }

    // Devuelve true si en la base datos existe el director que se pasa como
    // parámetro
    public boolean existeDirector(Director director) {
        if (director != null)
            return existeDirector(director.getNombre(), director.getApellidos());
        return false;
    }
    // Devuelve true si en la base datos existe un director cuyo nombre y 
    // apellidos son los que se pasan como parámetros
    public boolean existeDirector(String nombre, String apellidos) {
        if ( nombre == null || apellidos == null)
            return false;
        String query = 
                        "SELECT * FROM directores WHERE nombre = '" 
                        + nombre.toUpperCase() + "' AND apellidos = '" 
                        + apellidos.toUpperCase() + "';"; 

        boolean existe = false;
        try {
           Statement st = conex.createStatement();
           ResultSet resultSet = st.executeQuery(query);	   
           if (resultSet.next()) {
               existe = true;
               System.out.println(  "Ya existe director : " + nombre 
                                    + " " + apellidos);
           }
           resultSet.close();
           st.close();
        }catch (SQLException ex){
            System.out.println( "Error comprobando si existe director '" 
                                + nombre + " " + apellidos 
                                + "': " + ex.getMessage());
        }finally {
            return existe;
        }
    }
    // Devuelve todos los directores de la base datos
    public ArrayList<Director> getAllDirectores() {        
        ArrayList<Director> directores = new ArrayList<>();
        try {
            Statement st = conex.createStatement();
            String query = "SELECT nombre, apellidos FROM directores "  
                           + "ORDER BY nombre, apellidos;"; 
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                Director director = new Director(); 
                director.setNombre( resultSet.getString("nombre") );
                director.setApellidos( 
                        resultSet.getString("apellidos") ); 
               directores.add(director);
            }
            resultSet.close();
            st.close();
        }catch (SQLException ex){
            System.out.println(
                    "Error recuperando directores de la base datos: " +
                    ex.getMessage() 
            );
        }finally {
            
            return directores;
        }
    }
    // Devuelve los directores de la base datos que no tienen películas
    public ArrayList<Director> getDirectoresSinPeliculas() {        
        ArrayList<Director> directores = new ArrayList<>();
        try {
            Statement st = conex.createStatement();
            String query = "SELECT * FROM directores WHERE iddirector NOT IN " 
                            + "(SELECT DISTINCT(director) FROM peliculas);";
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                Director director = new Director(); 
                director.setNombre( resultSet.getString("nombre") );
                director.setApellidos( 
                        resultSet.getString("apellidos") ); 
               directores.add(director);
            }
            resultSet.close();
            st.close();
        }catch (SQLException ex){
            System.out.println(
                    "Error recuperando directores de la base datos: " +
                    ex.getMessage() 
            );
        }finally {
            return directores;
        }
    }
    // Devuelve los directores de la base datos que tienen películas
    public ArrayList<Director> getDirectoresConPeliculas() {        
        ArrayList<Director> directores = new ArrayList<>();
        try {
            Statement st = conex.createStatement();
            String query = "SELECT * FROM directores WHERE iddirector IN " 
                            + "(SELECT DISTINCT(director) FROM peliculas);";
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                Director director = new Director(); 
                director.setNombre( resultSet.getString("nombre") );
                director.setApellidos( 
                        resultSet.getString("apellidos") ); 
               directores.add(director);
            }
            resultSet.close();
            st.close();
        }catch (SQLException ex){
            System.out.println(
                    "Error recuperando directores de la base datos: " +
                    ex.getMessage() 
            );
        }finally {
            return directores;
        }
    }
    // Inserta en base datos el director que se pasa como parámetro
    public void insertarDirector(Director director) {
        if ( director != null )                 
            insertarDirector(director.getNombre(), director.getApellidos());
    }

    // Inserta en base datos el director cuyo nombre y apellidos son los que 
    // se pasan como parámetros
    public void insertarDirector(String nombre, String apellidos) {
        if ( nombre == null || apellidos == null  
              || existeDirector(nombre.toUpperCase(), apellidos.toUpperCase()))
            return;
        String nom = nombre.toUpperCase();
        String apes = apellidos.toUpperCase();
        try{
            Statement st = conex.createStatement();
            String query = "INSERT INTO directores(nombre, " 
                           + "apellidos) VALUES('"
                           + nom + "', '" + apes + "');";
            st.executeUpdate( query );                
            st.close();

        }catch (SQLException ex){
            System.out.println( "Error insertando director : " + nom
                                + " " + apes
                                + ": \n" + ex.getMessage() );
        }
    }
    // Modifica en la base datos el contenido del director que se pasa 
    // como parámetro
    public boolean modificarDirector(Director old, Director nuevo) {
        if (old != null && nuevo != null)
            return 
               modificarDirector(old, nuevo.getNombre(), nuevo.getApellidos());
        return false;
    }

    // Modefica en la base datos el contenido del director que tiene un nombre
    // y apellidos iguales a los que se pasan como parámetros
    public boolean modificarDirector(Director old, String nombre, String apellidos) {
        boolean resultado = false;        
        String mensaje = "Error modificando director : " + nombre 
                                + " " + apellidos + ": \n";
        Statement st = null;
        try{
            if ( old != null && nombre != null && apellidos !=null ){
                int clave = getClaveDirector(old);
                if (clave < 0)
                    return false;

                st = conex.createStatement();
                String query = "UPDATE directores SET nombre = '"
                               + nombre.toUpperCase() + "', apellidos = '" 
                               + apellidos.toUpperCase() 
                               + "' WHERE iddirector = " 
                               + clave + " ;" ;
                st.executeUpdate( query ); 
                resultado = true;
                st.close();
            }
        }catch (SQLException ex){
            System.out.println( mensaje + ex.getMessage() );
        }finally{
            return resultado;
        }        
    }
    // Modifica en la base datos el contenido del director que tiene clave 
    // igual a la que se pasa como parámetro
    public boolean modificarDirector(int clave, String nombre, String apellidos) {
        boolean resultado = false;        
        String mensaje = 
                "Error modificando director con clave " + clave + ": \n";
        Statement st = null;
        try{
            if ( clave > 0 && nombre != null && apellidos !=null ){
                st = conex.createStatement();
                String query = "UPDATE directores SET nombre = '"
                               + nombre.toUpperCase() + "', apellidos = '" 
                               + apellidos.toUpperCase() 
                               + "' WHERE iddirector = " 
                               + clave + " ;" ;
                st.executeUpdate( query ); 
                resultado = true;
                st.close();
            }
        }catch (SQLException ex){
            System.out.println( mensaje + ex.getMessage() );
        }finally{
            return resultado;
        }        
    }
    // Devuelve el director que en base datos tiene la clave que se pasa
    // como parámetro
    public Director getDirector(int id){
        Director director = null;
        ResultSet resultSet = null;
        Statement st = null;
        String mensaje = "Error recuperando director con id " + id + ": /n";
        try {
            st = conex.createStatement();
            String query = "SELECT nombre, apellidos FROM directores " +
                           "WHERE iddirector = " + id + ";"; 
            resultSet = st.executeQuery(query);
            while (resultSet.next()) { 
                director = new Director();
                director.setNombre( resultSet.getString("nombre"));
                director.setApellidos( resultSet.getString("apellidos"));
            }
            resultSet.close();
        }catch (SQLException ex){
            System.out.println( mensaje + ex.getMessage() );
        }finally {
            try{
                if (st != null)
                    st.close();
                if (resultSet != null)
                    resultSet.close();
            }catch (SQLException e){
                System.out.println( mensaje + e.getMessage() );
            }
            return director;
            
        }        
    }
    // Devuelve la clave que tiene en base datos el director que se pasa
    // como parámetro
    public int getClaveDirector (Director director){
        int clave = -1;
        String nombre = director.getNombre().toUpperCase();
        String apellidos = director.getApellidos().toUpperCase();
        try {
            Statement st = conex.createStatement();
            String query = "SELECT iddirector FROM directores " +
                           "WHERE nombre = '" + nombre + "' AND apellidos = '"
                           + apellidos + "';"; 
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {  
                clave = resultSet.getInt("iddirector");
            }
            resultSet.close();
            st.close();
        }catch (SQLException ex){
            System.out.println( "Error recuperando id del director " + 
                                director + ": /n" + ex.getMessage() );
        }finally {
            return clave;
        }        
    }
	
    
    // Elimina de la base de datos la película cuyo título es el que se
    // pasa como parámetro
    public void eliminarPelicula(String nombre) {
        try {
            Statement st = conex.createStatement();
                       String query = "DELETE FROM peliculas WHERE titulo = '" 
                        + nombre.toUpperCase() + "';"; 
            st.executeUpdate(query);
            st.close();
        }catch (SQLException ex){
            System.out.println( "Error borrando película : " + 
                                nombre + ": \n" + ex.getMessage() );
        }
    }
    // Elimina de la base de datos la película que se pasa como parámetro
    public void eliminarPelicula(Pelicula pelicula) {
        if (pelicula != null)
            eliminarPelicula(pelicula.getTitulo());
    }

    // Devuelve true si ya existe en la base datos una película cuyo
    // título es el que se pasa como parámetro
    public boolean existePelicula(String titulo) {
        
        String query = 
                        "SELECT * FROM peliculas WHERE titulo = '" 
                        + titulo.toUpperCase() + "';"; 

        boolean existe = true;
        try {
           Statement st = conex.createStatement();
           ResultSet resultSet = st.executeQuery(query);	   
           if (!resultSet.next()) {
                existe = false;
           }
           resultSet.close();
           st.close();
        }catch (SQLException ex){
            System.out.println( "Error comprobando si existe película '" + 
                                titulo + "': " + ex.getMessage() );
        }finally {
            return existe;
        }
    }

    // Devuelve todas las películas de la base de datos
    public ArrayList<Pelicula> getAllPeliculas() {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        try {
            Statement st = conex.createStatement();
            String query = "SELECT titulo, director, pais, duracion, genero "
                           + "FROM peliculas ORDER BY titulo;"; ; 
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                Pelicula pelicula = new Pelicula(); 
                pelicula.setTitulo( resultSet.getString("titulo") );
                pelicula.setDirector( 
                        getDirector( resultSet.getInt("director") ) 
                );
                pelicula.setPais(
                        getPais( resultSet.getInt("pais") ) 
                );
                pelicula.setDuracion(resultSet.getInt("duracion"));  
                pelicula.setGenero(
                        getGenero( resultSet.getInt("genero") )
                );
                peliculas.add(pelicula);
            }
            resultSet.close();
            st.close();
        }catch (SQLException ex){
            System.out.println(
                    "Error recuperando películas de la base datos: " +
                    ex.getMessage() 
            );
        }finally {
            return peliculas;
        }
    }
    // Devuelve todas las películas de la base de datos que son del director
    // y del género que se pasan como parámetros
    public ArrayList<Pelicula> getPeliculas(int idDirector, int idGenero) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        try {
            Statement st = conex.createStatement();
            String query = "SELECT titulo, director, pais, duracion, genero "
                           + "FROM peliculas WHERE director = " + idDirector 
                           + " AND genero = " + idGenero 
                           + " ORDER BY titulo;"; 
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                Pelicula pelicula = new Pelicula(); 
                pelicula.setTitulo( resultSet.getString("titulo") );
                pelicula.setDirector( 
                        getDirector( resultSet.getInt("director") ) 
                );
                pelicula.setPais(
                        getPais( resultSet.getInt("pais") ) 
                );
                pelicula.setDuracion(resultSet.getInt("duracion"));  
                pelicula.setGenero(
                        getGenero( resultSet.getInt("genero") )
                );
                peliculas.add(pelicula);
            }
            resultSet.close();
            st.close();
        }catch (SQLException ex){
            System.out.println(
                    "Error recuperando películas de la base datos: " +
                    ex.getMessage() 
            );
        }finally {
            return peliculas;
        }
    }    
    // Devuelve todas las películas de la base de datos que son del director
    // que se pasa como parámetros
    public ArrayList<Pelicula> getPeliculasPorDirector(int idDirector) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        try {
            Statement st = conex.createStatement();
            String query = "SELECT titulo, director, pais, duracion, genero "
                           + "FROM peliculas WHERE director = " + idDirector 
                           + " ORDER BY titulo;";
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                Pelicula pelicula = new Pelicula(); 
                pelicula.setTitulo( resultSet.getString("titulo") );
                pelicula.setDirector( 
                        getDirector( resultSet.getInt("director") ) 
                );
                pelicula.setPais(
                        getPais( resultSet.getInt("pais") ) 
                );
                pelicula.setDuracion(resultSet.getInt("duracion"));  
                pelicula.setGenero(
                        getGenero( resultSet.getInt("genero") )
                );
                peliculas.add(pelicula);
            }
            resultSet.close();
            st.close();
        }catch (SQLException ex){
            System.out.println(
                    "Error recuperando películas de la base datos: " +
                    ex.getMessage() 
            );
        }finally {
            return peliculas;
        }
    }
    // Devuelve todas las películas de la base de datos que son del genero
    // que se pasa como parámetros
    public ArrayList<Pelicula> getPeliculasPorGenero(int idGenero) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        try {
            Statement st = conex.createStatement();
            String query = "SELECT titulo, director, pais, duracion, genero "
                           + "FROM peliculas WHERE genero = " + idGenero 
                           + " ORDER BY titulo;"; 
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                Pelicula pelicula = new Pelicula(); 
                pelicula.setTitulo( resultSet.getString("titulo") );
                pelicula.setDirector( 
                        getDirector( resultSet.getInt("director") ) 
                );
                pelicula.setPais(
                        getPais( resultSet.getInt("pais") ) 
                );
                pelicula.setDuracion(resultSet.getInt("duracion"));  
                pelicula.setGenero(
                        getGenero( resultSet.getInt("genero") )
                );
                peliculas.add(pelicula);
            }
            resultSet.close();
            st.close();
        }catch (SQLException ex){
            System.out.println(
                    "Error recuperando películas de la base datos: " +
                    ex.getMessage() 
            );
        }finally {
            return peliculas;
        }
    }
    // Devuelve el nombre del genero que en base datos tiene la clave
    // que se pasa como parámetro
    public String getGenero(int id){
        String genero = null;
        try {
            Statement st = conex.createStatement();
            String query = "SELECT nomgenero FROM generos " +
                           "WHERE idgenero = " + id + ";"; 
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {  
                genero = resultSet.getString("nomgenero");
            }
            resultSet.close();
            st.close();
        }catch (SQLException ex){
            System.out.println( "Error recuperando genero con id " + 
                                id + ": /n" + ex.getMessage() );
        }finally {
                return genero;
        }        
    }
    
    // Devuelve el nombre del pais que en base datos tiene la clave
    // que se pasa como parámetro
    public String getPais(int id){
        String pais = null;
        try {
            Statement st = conex.createStatement();
            String query = "SELECT nompais FROM paises " +
                           "WHERE idpais = " + id + ";"; 
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {  
                pais = resultSet.getString("nompais");
            }
            resultSet.close();
            st.close();
        }catch (SQLException ex){
            System.out.println( "Error recuperando pais con id " + 
                                id + ": /n" + ex.getMessage() );
        }finally {
                return pais;
        }        
    }
    // Devuelve la clave que tiene en base datos la película cuyo nombre se
    // pasa como parámetro
    public int getClavePelicula (String titulo){
        int clave = -1;
        try {
            Statement st = conex.createStatement();
            String query = "SELECT idpelicula FROM peliculas " +
                           "WHERE titulo = '" + titulo.toUpperCase() + "';"; 
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {  
                clave = resultSet.getInt("idpelicula");
            }
            resultSet.close();
            st.close();
        }catch (SQLException ex){
            System.out.println( "Error recuperando id pelicula  " + 
                                titulo + ": /n" + ex.getMessage() );
        }finally {
            return clave;
        }        
    }
    // Devuelve la clave que tiene en base datos el pais que se pasa
    // como parámetro
    public int getClavePais (String nombre){
        int clave = -1;
        try {
            Statement st = conex.createStatement();
            String query = "SELECT idpais FROM paises " +
                           "WHERE nompais = '" + nombre.toUpperCase() + "';"; 
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {  
                clave = resultSet.getInt("idpais");
            }
            resultSet.close();
            st.close();
        }catch (SQLException ex){
            System.out.println( "Error recuperando id del pais " + 
                                nombre + ": /n" + ex.getMessage() );
        }finally {
            return clave;
        }        
    }
    
    // Devuelve la clave que tiene en base datos el género que se pasa
    // como parámetro
    public int getClaveGenero (String nombre){
        int clave = -1;
        try {
            Statement st = conex.createStatement();
            String query = "SELECT idgenero FROM generos " +
                           "WHERE nomgenero = '" + nombre.toUpperCase() + "';"; 
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {  
                clave = resultSet.getInt("idgenero");
            }
            resultSet.close();
            st.close();
        }catch (SQLException ex){
            System.out.println( "Error recuperando id del genero " + 
                                nombre + ": /n" + ex.getMessage() );
        }finally {
            return clave;
        }        
    }
   
    // Inserta en la base datos la película que se pasa como parámetro
    public void insertarPelicula(Pelicula pelicula) {
        try {
            if ( !existePelicula( pelicula.getTitulo() ) ) {
                Statement st = conex.createStatement();
                String titulo = pelicula.getTitulo().toUpperCase();
                int duracion = pelicula.getDuracion();
                int pais = getClavePais(pelicula.getPais());
                int genero = getClaveGenero(pelicula.getGenero());
                int director = getClaveDirector(pelicula.getDirector());
                String query = "INSERT INTO peliculas(titulo, director, pais, " 
                               + "duracion, genero) VALUES('";	
                st.executeUpdate(
                        query + titulo + "', " + director + 
                        ", " + pais + ", " + duracion + ", " + 
                        genero + ");" 
                );                
                st.close();
            }            
        }catch (SQLException ex){
            System.out.println( "Error insertando película : " + 
                                pelicula + ": \n" + ex.getMessage() );
        }
    }
    // Devuelve los géneros de la base datos
    public ArrayList<String> getGeneros(){
        ArrayList<String> resultado = new ArrayList();
        try {
            Statement st = conex.createStatement();
            String query = "SELECT nomgenero FROM generos ORDER BY nomgenero;"; 
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {  
               resultado.add(resultSet.getString("nomgenero"));
            }
            resultSet.close();
            st.close();
        }catch (SQLException ex){
            System.out.println( "Error recuperando géneros en base datos :/n" 
                               + ex.getMessage() );
        }finally {
            String[] aux = {};
            return resultado;
        }        
    }
    // Devuelve los generos que tienen películas en la base datos
    public ArrayList<String> getGenerosConPeliculas(){
        ArrayList<String> resultado = new ArrayList();
        try {
            Statement st = conex.createStatement();
            String query = "SELECT nomgenero, idgenero FROM generos " 
                    + "WHERE idgenero IN " 
                    + "(SELECT DISTINCT(genero) FROM peliculas) "
                    + "ORDER BY nomgenero;"; 
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {  
               resultado.add(resultSet.getString("nomgenero"));
            }
            resultSet.close();
            st.close();
        }catch (SQLException ex){
            System.out.println( "Error recuperando géneros en base datos :/n" 
                               + ex.getMessage() );
        }finally {
            String[] aux = {};
            return resultado;
        }        
    }
    // Devuelve los paises de la base datos
    public ArrayList<String> getPaises(){
        ArrayList<String> resultado = new ArrayList();
        try {
            Statement st = conex.createStatement();
            String query = "SELECT nompais FROM paises ORDER BY nompais;"; 
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {  
               resultado.add(resultSet.getString("nompais"));
            }
            resultSet.close();
            st.close();
        }catch (SQLException ex){
            System.out.println( "Error recuperando paises en base datos :/n" 
                               + ex.getMessage() );
        }finally {
            return resultado;
        }        
    }
    // Modifica en la base datos el contenido de la pelicula que tiene clave 
    // igual a la que se pasa como parámetro
    public boolean modificarPelicula(int clave, Pelicula pelicula) {
        boolean resultado = false;        
        String mensaje = 
                "Error modificando película con clave " + clave + ": \n";
        Statement st = null;
        try{
            if ( clave > 0 && pelicula != null){
                st = conex.createStatement();
                String titulo = pelicula.getTitulo().toUpperCase();
                int duracion = pelicula.getDuracion();
                int pais = getClavePais(pelicula.getPais());
                int director = getClaveDirector(pelicula.getDirector());
                int genero = getClaveGenero(pelicula.getGenero());
                String query = "UPDATE peliculas SET titulo = '"
                               + titulo + "', director = " 
                               + director + ", pais = " 
                               + pais + ", duracion = " 
                               + duracion + ", genero = " + genero
                               + " WHERE idpelicula = " 
                               + clave + " ;" ;
                st.executeUpdate( query ); 
                resultado = true;
                st.close();
            }
        }catch (SQLException ex){
            System.out.println( mensaje + ex.getMessage() );
        }finally{
            return resultado;
        }       
    }
}

