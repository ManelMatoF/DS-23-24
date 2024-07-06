package e1;

public class LimpiaAprobada implements EstadoHabitacion {

    private static final LimpiaAprobada estado = new LimpiaAprobada();

    public static LimpiaAprobada getEstado() {
        return estado;
    }

    @Override
    public void ReservarHabitacion(Habitacion h, String Huesped) {
        h.setHuesped(Huesped);
        h.setEstado(Ocupada.getEstado());
    }

    @Override
    public void TerminarReserva(Habitacion h) {
        //AQUI NO SE PUEDE TERMINAR RESERVA
    }

    @Override
    public void LimpiarHabitacion(Habitacion h, String Limpiador) {
        h.setLimpiador(Limpiador);
        h.setEstado(PendienteAprobacion.getEstado());
    }

    @Override
    public void LiberarHabitacion(Habitacion h) {
        //UNA HABITACION APROBADA NO SE PUEDE LIBERAR
    }

    @Override
    public void AprobarLimpieza(Habitacion h, String Supervisor, boolean Aprobada) {
        //UNA HABITACION APROBADA NO SE PUEDE APROBAR
    }
    public String GetMensaje(Habitacion h){
        return "Habitacion aprovada por "+ h.getSupervisor();
    }
}
