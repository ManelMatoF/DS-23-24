package e1;

public class Ocupada implements EstadoHabitacion {
    private static final Ocupada estado = new Ocupada();

    public static Ocupada getEstado() {
        return estado;
    }

    @Override
    public void ReservarHabitacion(Habitacion h, String Huesped) {
        //UNA HABITACION OCUPADA NO SE PUEDE RESERVAR
    }

    @Override
    public void TerminarReserva(Habitacion h) {
        h.setHuesped(null);
        h.setEstado(LimpiaAprobada.getEstado());
    }

    @Override
    public void LimpiarHabitacion(Habitacion h, String Limpiador) {
        //UNA HABITACION OCUPADA NO SE PUEDE LIMPIAR
    }

    @Override
    public void LiberarHabitacion(Habitacion h) {
        h.setEstado(PendienteLimpieza.getEstado());
    }

    @Override
    public void AprobarLimpieza(Habitacion h, String Supervisor, boolean Aprobada) {
        //EN UNA HABITACION OCUPADA NO SE PUEDE APROBAR LIMPIEZA
    }

    public String GetMensaje(Habitacion h){
        return "Ocupada";
    }
}
