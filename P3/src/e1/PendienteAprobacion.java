package e1;

public class PendienteAprobacion implements EstadoHabitacion {
    private static final PendienteAprobacion estado = new PendienteAprobacion();

    public static PendienteAprobacion getEstado() {
        return estado;
    }

    @Override
    public void ReservarHabitacion(Habitacion h, String Huesped) {
      //NO SE PUEDE SE RESERVAR HABITACION
    }

    @Override
    public void TerminarReserva(Habitacion h) {
        //AQUI NO SE PUEDE TERMINAR RESERVA
    }

    @Override
    public void LimpiarHabitacion(Habitacion h, String Limpiador) {
        //NO SE PUEDE LIMPIAR HABITACION PENDIENTE DE APROBACION
    }

    @Override
    public void LiberarHabitacion(Habitacion h) {
        //NO SE PUEDE LIBERAR HABITACION PENDIENTE DE APROBACION
    }

    @Override
    public void AprobarLimpieza(Habitacion h, String Supervisor, boolean Aprobada) {
        if (Aprobada)
        h.setEstado(LimpiaAprobada.getEstado());
        else h.setEstado(PendienteLimpieza.getEstado());
    }

    public String GetMensaje(Habitacion h){
        return "Habitacion limpiada por "+h.getLimpiador()+", pendiente de aprovacion";
    }
}
