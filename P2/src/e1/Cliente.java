package e1;
abstract class Cliente {
    private final String dni;

    public Cliente(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public long getMaxDeuda() {
        return 0;
    }
    public float getComision() {
        return 0.04F;
    }
    public long getMinComision(){
        return 300;
    }
    public long getMinIngreso(){
        return 100000;
    }
}
class ClienteNormal extends Cliente{
    public ClienteNormal(String dni){
        super(dni);
    }
}

class ClientePreferente extends Cliente{
    public ClientePreferente(String dni){
        super(dni);
    }
    @Override
    public long getMaxDeuda() {
        return -100000;
    }
    @Override
    public long getMinIngreso() {
        return 50000;
    }
    @Override
    public float getComision() {
        return 0.02F;
    }
    @Override
    public long getMinComision() {
        return 100;
    }
}
class ClienteVIP extends Cliente{
    public ClienteVIP(String dni){
        super(dni);
    }

    @Override
    public long getMinIngreso() {
        return 0;
    }
    @Override
    public long getMaxDeuda() {
        return Long.MIN_VALUE;
    }
    @Override
    public long getMinComision() {
        return 0;
    }
    @Override
    public float getComision() {
        return 0.0F;
    }
}