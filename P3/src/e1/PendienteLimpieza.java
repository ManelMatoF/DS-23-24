package e1;

public class PendienteLimpieza implements EstadoHabitacion {
    private static final PendienteLimpieza estado = new PendienteLimpieza();

    public static PendienteLimpieza getEstado() {
        return estado;
    }

    @Override
    public void ReservarHabitacion(Habitacion h, String Huesped) {
        //NO SE PUEDE RESERVAR AQUI
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
        //NO SE PUEDE LIBERAR HABITACION PENDIENTE DE LIMPIEZA
    }

    @Override
    public void AprobarLimpieza(Habitacion h, String Supervisor, boolean Aprobada) {
        //NO SE PUEDE APROBAR LIMPIEZA HABITACION PENDIENTE DE LIMPIEZA
    }
    public String GetMensaje(Habitacion h){
        return "Pendiente de Limpieza";
    }
}
