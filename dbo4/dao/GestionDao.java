
package discoteca.dao;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Query;
import discoteca.model.Disco;
import discoteca.model.Estilos;
import java.util.ArrayList;

/**
 *
 * @author Mam
 */
public class GestionDao {
    // Nombre de la base datos
    private static final String NOMBRE_BD = "Discos";
   
    // Conexión a la base datos
    private ObjectContainer bd;

    // Constructor por defecto. Abre la base datos,
    // si no existe la crea. Si la base datos está vacía
    // inserta discos en ella 
    public GestionDao() {
        bd = Db4oEmbedded.openFile(NOMBRE_BD);
    }
    // Constructor que abre la base datos,
    // si no existe la crea. Crea e Inserta en la base datos el 
    // número de discos que se pasa como parámetro
    public GestionDao(int numDiscosAInsertar) {
        this();
        //if (numeroDiscos()<1)
            prepararBD(numDiscosAInsertar);
    }
	
    /** Inserta un objeto disco en la base datos si previamente no existe
     *  un disco con el mismo nombre de grupo y título.
     *  @param d Disco a insertar  */
    public boolean insertarDisco(Disco d) {
        if (d == null){
            System.out.println("\nNo se puede insertar disco nulo\n");
            return false;
        }
        if (d != null && !existeDisco(d)){
            bd.store(d);
            return true;
         }else{
            System.out.println(
                "\nOperación cancelada. Ya existe un disco con : \n\tGrupo => " 
                + d.getGrupo() + " y Título => " + d.getTitulo() + "\n"
            );
        }
        return false;
    }
    /** Insertar en la base datos el objeto disco
        creado con los datos que se pasan como parámetros
    * @param grupo  Nombre del grupo
    * @param titulo Título del Disco
    * @param numCanciones Número canciones que contiene el Disco
    * @param anyo Año publicación Disco
    * @param estilo Estilo música del Disco*/
    public void insertarDisco( String grupo, String titulo, 
                               int numCanciones,int anyo, 
                               Estilos estilo){
        Disco disco = new Disco(grupo, titulo, numCanciones, anyo, estilo);
        insertarDisco(disco);
    }
    /** Comprueba si el disco que se pasa como parámetro está en la base
     *  datos. Dos discos son iguales si tienen el mismo grupo y título.
     * @param d Disco a buscar en la base datos
     * @return true si el disco está en la base datos y false en otro caso */
    public boolean existeDisco(Disco d){
        Disco disco = getDisco (d.getGrupo(), d.getTitulo());
        return ( disco != null );
    }
    // Devuelve un array con los discos de la base datos cuyo nombre 
    // grupo y título son los que se pasan como parámetros
    public Disco getDisco (String grupo, String titulo){  
        Disco modelo = new Disco(grupo, titulo, 0, 0, null);
        ObjectSet objSet = bd.queryByExample(modelo);
        if (objSet.hasNext())
            return (Disco)objSet.next();
        return null;    
    }
    // Devuelve todos los discos de la base datos ordenados por nombre grupo
    public Disco[] getDiscos (){            
        ArrayList<Disco> discos = new ArrayList();
        Query q = bd.query();
        q.constrain(Disco.class);
        q.descend("grupo").orderAscending();
        ObjectSet objSet = q.execute();
        while (objSet.hasNext())
            discos.add((Disco)objSet.next());
        Disco[] aux = {};
        return discos.toArray(aux);
    }
    // Devuelve nombre de los grupos con discos en la base datos
    public String[] getGrupos (){       
        Disco[] discos = getDiscos();
        ArrayList<String> grupos = new ArrayList();
        for (Disco d : discos){
            String nombreGrupo = d.getGrupo();
            if ( !grupos.contains(nombreGrupo))
                grupos.add(nombreGrupo);
        }
        String[] aux = {}; 
        return grupos.toArray(aux);
    }
    // Devuelve los estilos de los discos base datos
    public String[] getEstilos (){          
        Disco[] discos = getDiscos();         
        ArrayList<String> estilos = new ArrayList();
        for (Disco d : discos){
            Estilos estilo = d.getEstilo();
            if ( !estilos.contains(estilo.toString()))
                estilos.add(estilo.toString());
        }
        String[] aux = {}; 
        return estilos.toArray(aux);
    }
    // Devuelve el menor año de publicación discos base datos
    // Si base datos vacía, devuelve -1
    public int getMinAnyo(){         
        Disco[] discos = getDiscosOrderByAnyo();
        if (discos.length > 0){
            return discos[0].getAnyo();
        }
        return -1; 
    }
    // Devuelve el mayor año de publicación discos base datos
    // Si base datos vacía, devuelve -1
    public int getMaxAnyo(){          
        Disco[] discos = getDiscosOrderByAnyo();
        if (discos.length > 0){
            return discos[discos.length - 1].getAnyo();
        }
        return -1; 
    }
    // Devuelve discos de la base datos ordenados por año(ascendente)
    public Disco[] getDiscosOrderByAnyo(){          
        ArrayList<Disco> discos = new ArrayList();
        Query q = bd.query(); 
        q.constrain(Disco.class); 
        q.descend("anyo").orderAscending(); 
        ObjectSet objSet = q.execute(); 
        while(objSet.hasNext()){
            discos.add((Disco)objSet.next());
        }
        Disco[] aux = {}; 
        return discos.toArray(aux);        
    }
    // Devuelve el número de discos que hay en la base datos
    public final int numeroDiscos (){
        return (getDiscos().length);
    }
    // Devuelve un array con todos los Discos de la base datos 
    // cuyo nombre grupo es el que se pasa como parámetro
    public Disco[] getDiscos(String grupo) {
        ArrayList<Disco> discos = new ArrayList();
        if ( grupo != null ){
            Disco modelo = new Disco(grupo, null, 0, 0, null);
            ObjectSet objSet = bd.queryByExample(modelo);
            while (objSet.hasNext())
                discos.add((Disco)objSet.next());            
        }
        Disco[] aux = {};
        return discos.toArray(aux);
    }
    // Devuelve un array con todos los Discos de la base datos 
    // que son del estilo que se pasa como parámetro
    public Disco[] getDiscos(Estilos estilo) {
        ArrayList<Disco> discos = new ArrayList();
        if (estilo != null){
            Query q = bd.query(); 
            q.constrain(Disco.class); 

            q.descend("estilo").constrain(estilo); 
            ObjectSet objSet = q.execute(); 
            while(objSet.hasNext()){
                discos.add((Disco)objSet.next());
            }
        }
        Disco[] aux = {};
        return discos.toArray(aux);
    }
    // Modifica el valor del número canciones del disco que se pasa
    // como parámetro
    public boolean modificarNumCanciones(Disco disco, int nuevoNumCanciones) {

        // Recuperar de la base datos el disco a modificar
        ObjectSet resultado = bd.queryByExample(disco);
        Disco old = null;
        if (resultado.hasNext())
            old = (Disco) resultado.next();

        // Si el disco está en la base datos, modificar número canciones
        if (old != null){
            old.setNumCanciones(nuevoNumCanciones);
            bd.store(old);
            return true;
        }else{
           System.out.println("No existe el disco a modificar.");
           return false;
        }            
    }
    // Devuelve número entero al azar entre el valor mínimo(incluido) y 
    // máximo(incluido) que se pasan como parámetros.
    private int getValorRandom(int min, int max){
       int resultado =  min + (int)((max - min + 1) * Math.random());
       return resultado;
    }
    // Si la base datos está vacía, crea e inserta en ella el 
    // número de discos que se pasa como parámetro
    public final void prepararBD(int numDiscos){
        if (numeroDiscos() < 1){            
            int numEstilos = Estilos.values().length;

            for (int i=0; i<numDiscos; i++){
                Disco disco = new Disco(
                                "Grupo_" + getValorRandom(0, 5),
                                "Titulo_" + i,
                                getValorRandom(3, 20),
                                getValorRandom(1948, 2020),
                                Estilos.values()[getValorRandom(0,numEstilos-1)]
                );
                insertarDisco(disco);
            }
        }
    }
    // Devuelve el primer disco de la base datos
    public Disco getPrimerDisco(){
        Disco primero = null;
        Disco[] discos = getDiscos();
        if (discos.length > 0)
            primero = discos[0];
        return primero;
    }
    
    // Elimina de la base de datos el disco pasado como parámetro (si existe)
    // Devuelve true si la operación se ha realizado y false en otro caso
    public boolean borrar (Disco disco){
        // Comprobar si existe en la base datos el disco que se quiere borrar
        Disco d = getDisco( disco.getGrupo(), disco.getTitulo());
        // Si el disco está en la base datos lo borramos
        if ( d != null){            
            bd.delete(d);
            return true;
        }
        return false;
    }
    // Devuelve un array con los discos de la base datos que son del estilo 
    // que se pasa como parámetro y tienen un número canciones superior al
    // indicado como segundo parámetro
    public Disco[] getDiscos( Estilos estilo, int numCanciones ){
        ArrayList<Disco> discos = new ArrayList();
        if (estilo != null){
            Query q = bd.query(); 
            q.constrain(Disco.class);
            Constraint c = q.descend("estilo").constrain(estilo);
            q.descend("numCanciones").constrain(numCanciones).greater().and(c); 

            ObjectSet objSet = q.execute(); 
            while(objSet.hasNext()){
                discos.add((Disco)objSet.next());
            }
        }
        Disco[] aux = {};
        return discos.toArray(aux);
        
        
    }
    // Devuelve un array con los discos de la base datos que sean 
    // anteriores al año que se pasa como parámetro. Los discos del resultado 
    // consulta están ordenados ascendentemente por año
    public Disco[] getDiscosAnterioreAnyo ( int anyo){
        ArrayList<Disco> discos = new ArrayList();

        Query q = bd.query(); 
        q.constrain(Disco.class);
        q.descend("anyo").constrain(anyo).smaller(); 
        q.descend("anyo").orderAscending();
        
        ObjectSet objSet = q.execute(); 
        while(objSet.hasNext()){
            discos.add((Disco)objSet.next());
        }
        
        Disco[] aux = {};
        return discos.toArray(aux);
        
    }
    // Cerrar la base datos
    public void cerrarBaseDatos() {
        bd.close();
        // Debug. Borrar el fichero de la BD.
        // cada vez que se ejecuta el programa empieza de cero
        /*File f = new File(NOMBRE_BD);
        f.delete();*/
    } 
    
}
