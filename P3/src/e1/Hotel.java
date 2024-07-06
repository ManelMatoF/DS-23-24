package e1;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private final String nombre;
    private List<Habitacion> Habitaciones = new ArrayList<>();

    public Hotel(String nombre) {
        this.nombre = nombre;
    }

    private Habitacion BuscarHabitacion(int Num) {
        for (Habitacion habitacion : Habitaciones) {
            if (habitacion.getNumero() == Num) {
                return habitacion; // Se encontró la habitación con el número buscado
            }
        }
        return null; // No se encontró ninguna habitación con el número buscado
    }

    public String getNombre() {
        return nombre;
    }

    public void AddHabitacion(String supervisor) {
        Habitaciones.add(new Habitacion(Habitaciones.size() + 1, supervisor));
    }

    public void ReservarHabitacion(String Huesped, int Numero) {
        Habitacion h = BuscarHabitacion(Numero);
        if (h == null)
            System.out.println("Habitacion no encontrada");
        else h.ReservarHabitacion(Huesped);
    }

    public void TerminarReserva(int Numero) {
        Habitacion h = BuscarHabitacion(Numero);
        if (h == null)
            System.out.println("Habitacion no encontrada");
        else h.TerminarReserva();
    }

    public void LimpiarHabitacion(String Limpiador, int Numero) {
        Habitacion h = BuscarHabitacion(Numero);
        if (h == null)
            System.out.println("Habitacion no encontrada");
        else h.LimpiarHabitacion(Limpiador);
    }

    public void LiberarHabitacion(int Numero){
        Habitacion h = BuscarHabitacion(Numero);
        if (h == null)
            System.out.println("Habitacion no encontrada");
        else h.LiberarHabitacion();
    }

    public void AprobarLimpieza(boolean Aprobada, int Numero, String Supervisor){
        Habitacion h = BuscarHabitacion(Numero);
        if (h == null)
            System.out.println("Habitacion no encontrada");
        else h.AprobarLimpieza(Supervisor, Aprobada);
    }

    public String getHabitacionesDisponibles() {//IMPLEMENTAR EN HABITACION CLONEABLE PARA DEVOLVER LISTA INMUTABLE
        StringBuilder lista;
        lista = new StringBuilder();

        for (Habitacion elementos : Habitaciones) {
            if(elementos.getEstado()==LimpiaAprobada.getEstado()){
                lista.append("Habitacion No. ").append(elementos.getNumero());
                lista.append(" ");
            }
        }
        return lista.toString();
    }
    public String getHabitacionesPendienteLimpieza() {//IMPLEMENTAR EN HABITACION CLONEABLE PARA DEVOLVER LISTA INMUTABLE
        StringBuilder lista;
        lista = new StringBuilder();

        for (Habitacion elementos : Habitaciones) {
            if (elementos.getEstado() == PendienteLimpieza.getEstado()) {
                lista.append("Habitacion No. ").append(elementos.getNumero());
                lista.append(" ");
            }
        }
        return lista.toString();
    }
    public String getHabitacionesPendientesAprovacion() {//IMPLEMENTAR EN HABITACION CLONEABLE PARA DEVOLVER LISTA INMUTABLE??
        StringBuilder lista;
        lista = new StringBuilder();

        for (Habitacion elementos : Habitaciones) {
            if(elementos.getEstado()==PendienteAprobacion.getEstado()){
                lista.append("Habitacion No. ").append(elementos.getNumero());
                lista.append(" ");
            }
        }
        return lista.toString();
    }

    public void showInfo() {
        System.out.println("***********************\n" + "Hotel UDC-Hills\n" + "***********************\n");
        for (Habitacion elementos : Habitaciones) {
            System.out.println("Room no. " + elementos.getNumero() + ":" + (elementos.getHuesped()!=null? " Booked by "+ elementos.getHuesped(): " Free") + ". "
                    + elementos.getMensaje()+ ".");
        }
        System.out.println("***********************\n");
    }

    public String getHuesped(int numero){
        Habitacion h = BuscarHabitacion(numero);
        if(h != null && h.getEstado() == Ocupada.getEstado())
            return h.getHuesped();
        else
            return null;
    }
}
