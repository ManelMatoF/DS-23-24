package e1;


public class Habitacion {//PATRON ESTADO
    private String Supervisor;
    private String Limpiador = null;
    private int numero;
    private String Huesped = null;
    private EstadoHabitacion estado;

    public Habitacion(int numero, String Supervisor) {
        this.numero = numero;
        this.Supervisor = Supervisor;
        estado = LimpiaAprobada.getEstado();
    }

    public String getSupervisor() { return Supervisor; }
    public EstadoHabitacion getEstado() { return estado; }
    public String getHuesped() { return Huesped; }
    public String getLimpiador() { return Limpiador; }
    public int getNumero() {
        return numero;
    }

    public void setEstado(EstadoHabitacion estado) {
        this.estado = estado;
    }

    public void setHuesped(String huesped) {
        Huesped = huesped;
    }

    public void setLimpiador(String Limpiador) {
        this.Limpiador = Limpiador;
    }

    void ReservarHabitacion(String Huesped) {
        estado.ReservarHabitacion(this, Huesped);
    }

    void TerminarReserva() {
        estado.TerminarReserva(this);
    }

    void LimpiarHabitacion(String Limpiador) {
        estado.LimpiarHabitacion(this, Limpiador);
    }

    void LiberarHabitacion() {
        estado.LiberarHabitacion(this);
    }

    void AprobarLimpieza(String Supervisor, boolean Aprobada) {
        estado.AprobarLimpieza(this, Supervisor, Aprobada);
    }
    String getMensaje(){
        return estado.GetMensaje(this);
    }
}
