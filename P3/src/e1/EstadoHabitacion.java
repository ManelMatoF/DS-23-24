package e1;

public interface EstadoHabitacion {
    void ReservarHabitacion(Habitacion h, String Huesped);
    void TerminarReserva(Habitacion h);
    void LimpiarHabitacion(Habitacion h, String Limpiador);
    void LiberarHabitacion(Habitacion h);
    void AprobarLimpieza(Habitacion h , String Supervisor, boolean Aprobada);
    String GetMensaje(Habitacion h);

}
