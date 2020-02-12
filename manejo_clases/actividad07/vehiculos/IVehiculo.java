
package actividad07.vehiculos;

// Define las acciones que se pueden realizar sobre los vehículo que pertenecen
// a una empresa de alquiler de vehículos
public interface IVehiculo {
    public void setNumeroDias(int numDias);
    public double getPrecioTotalAlquilerPorDias();
    public void showInformacion();
    public void pideDatos();
}
