
package filmoteca02.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class FilmotecaBDD {

    private static final String NOMBRE_BBDD = "secondfilmoteca";	                    
    private static final String CONEXION = 
            "jdbc:mysql://localhost:3306/" + NOMBRE_BBDD + 
            "?createDatabaseIfNotExist=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static final String[] PAISES = { 
        "Alemania", "Australia", "Canadá", "China", "Francia", 
        "Gran Bretaña", "Italia", "México", "Portugal", "USA" 
    };
    private static final String[] GENEROS = { 
        "Acción", "Anime", "Ciencia Ficción", "Comedia", "Documental",
        "Drama", "Musical", "Suspense", "Terror", "Western" 
    };
    private static final String[] DIRECTORES = { 
        "Alfred Hitchcok", "Alejandro Amenábar", "Christopher Nolan", 
        "David Lynch", "James Cameron", "Martin Scorsese", "Pedro Almodóvar", 
        "Quentin Tarantino", "Roman Polanski", "Stanley Kubrick",
        "Akira Kurosawa", "Woody Allen"
    };
    private static final String[] TITULOS = { 
        "Quien a hierro mata", "Mula", "Cementerio de animales", "Hobbs & Shaw", 
        "Vengadores: Endgame", "El viaje de Chihiro", "Zombieland 2", 
        "IT: capítulo 2", "Detective Pikachu", "Capitana Marvel"
    };
    private static final int[] DURACIONES = 
                    { 125, 93, 78, 90, 100, 38, 55, 92, 145, 110};

    private static final String CREATE_TAB_GENEROS = 
        "CREATE TABLE IF NOT EXISTS generos(" + 
        "idgenero INT(2) PRIMARY KEY AUTO_INCREMENT, " + 
        "nomgenero VARCHAR(50) NOT NULL);";

    private static final String CREATE_TAB_PAISES = 
        "CREATE TABLE IF NOT EXISTS paises(" + 
        "idpais INT(2) PRIMARY KEY AUTO_INCREMENT, " + 
        "nompais VARCHAR(50) NOT NULL);";
    private static final String CREATE_TAB_DIRECTORES = 
        "CREATE TABLE IF NOT EXISTS directores(" + 
        "iddirector INT(2) PRIMARY KEY AUTO_INCREMENT, " + 
        "nombre VARCHAR(30) NOT NULL, " + 
        "apellidos VARCHAR(50) NOT NULL);";
    private static final String CREATE_TAB_PELICULAS = 
        "CREATE TABLE IF NOT EXISTS peliculas(" + 
        "idpelicula INT PRIMARY KEY AUTO_INCREMENT," + 
        "titulo VARCHAR(50) NOT NULL," +
        "director INT(2) NOT NULL," +
        "pais INT(2) NOT NULL," +
        "duracion INT(3)NOT NULL," +                               
        "genero INT(2)NOT NULL," +
        "FOREIGN KEY (pais) REFERENCES paises(idpais)," + 
        "FOREIGN KEY (director) REFERENCES directores(iddirector)," + 
        "FOREIGN KEY (genero) REFERENCES generos(idgenero));";
    
    private static final String CONSULTA_PAISES = "SELECT * FROM paises;";
    private static final String CONSULTA_GENEROS = "SELECT * FROM generos;";
    private static final String CONSULTA_DIRECTORES = "SELECT * FROM directores;";		
    private static final String CONSULTA_PELICULAS = "SELECT * FROM peliculas;";

    private static Statement st = null;
    private static  Connection conex = null;
    private static ResultSet resultSet = null;

    public static void crear() throws SQLException{
        try {
            conex = DriverManager.getConnection(CONEXION, USER, PASSWORD);					
            st = conex.createStatement();
            st.executeUpdate(CREATE_TAB_GENEROS);
            st.executeUpdate(CREATE_TAB_PAISES);
            st.executeUpdate(CREATE_TAB_DIRECTORES);
            st.executeUpdate(CREATE_TAB_PELICULAS);
            insertarGeneros();
            insertarPaises();
            insertarDirectores();
            insertarPeliculas();
        }finally {
            if (resultSet != null)
                resultSet.close();
            if (st != null)
                st.close();		
            if (conex != null)
                conex.close();
        }
    }

    private static void insertarGeneros() throws SQLException {
        String query = CONSULTA_GENEROS; 
        resultSet = st.executeQuery(query);

        if (!resultSet.next()) {
            query = "INSERT INTO generos(nomgenero) VALUES('";	
            for (String g : GENEROS) {
                    st.executeUpdate( query + g.toUpperCase() + "');" );
            }
        }
    }

    // Insertamos datos si la tabla PAISES está vacía
    private static void insertarPaises() throws SQLException{
       String query = CONSULTA_PAISES; 
       resultSet = st.executeQuery(query);

       if (!resultSet.next()) {
            query = "INSERT INTO paises(nompais) VALUES('";	
            for (String p : PAISES) {
                st.executeUpdate( query + p.toUpperCase() + "');" );
            }
       }	  
    }
    // Insertamos datos si la tabla DIRECTORES está vacía
    private static void insertarDirectores() throws SQLException{
       String query = CONSULTA_DIRECTORES; 
       resultSet = st.executeQuery(query);

       if (!resultSet.next()) {
            query = "INSERT INTO directores(nombre, apellidos) VALUES('";	
            for (String p : DIRECTORES) {
                String[] director = p.toUpperCase().split(" ");
                st.executeUpdate( query + director[0] + "', " + "'"
                + director[1] + "');" );
            }
       }	  
    }
    // Insertamos películas si la tabla PELICULAS está vacía
    private static void insertarPeliculas() throws SQLException{
       String query = CONSULTA_PELICULAS; 
       resultSet = st.executeQuery(query);

       if (!resultSet.next()) {
            query = "INSERT INTO peliculas(titulo, director, pais, " + 
                    "duracion, genero) VALUES('";	
            for (int i=0; i < TITULOS.length; i++) {
                st.executeUpdate(
                        query + TITULOS[i].toUpperCase() + "', " 
                        + getValorRandom(1,4) + ", " + (i+1) + ", " 
                        + DURACIONES[i] + ", " + getValorRandom(1,4) + ");" 
                );
            }	
       }
    }
    // Devuelve número entero al azar entre el valor mínimo(incluido) y 
    // máximo(incluido) que se pasan como parámetros.
    private static int getValorRandom(int min, int max){
       int resultado =  min + (int)((max - min + 1) * Math.random());
       return resultado;
    }
}

