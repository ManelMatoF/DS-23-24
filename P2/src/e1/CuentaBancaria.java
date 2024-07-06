package e1;

abstract class CuentaBancaria {
    private final String iban;
    private long saldo;
    private Cliente titular;

    public CuentaBancaria(String iban, long saldoInicial, Cliente titular){
        this.iban = iban;
        this.saldo = saldoInicial;
        this.titular = titular;
    }

    public long consultarSaldo() {
        return saldo;
    }

    protected void ingresarDinero(long cantidad) {
        if(cantidad > 0)
            saldo += cantidad;
        else
            System.out.println("No se permite ingredar cantidades negativas");
    }

    protected void retirarDinero(long cantidad) {
        if ((saldo - cantidad) >= titular.getMaxDeuda()) {
            saldo -= cantidad;
        } else {
            System.out.println("No se permite descubierto inferior a " + titular.getMaxDeuda()/100 + " en la cuenta corriente.");
        }
    }

    public String getIban() {
        return iban;
    }
    public long getSaldo(){return saldo;}
    public Cliente getTitular(){return titular;}

}

class CuentaCorriente extends CuentaBancaria {
    public CuentaCorriente(String iban, long saldoInicial, Cliente titular) {
        super(iban, saldoInicial, titular);
    }

}

class CuentaAhorro extends CuentaBancaria {
    public CuentaAhorro(String iban, long saldoInicial, Cliente titular) {
        super(iban, saldoInicial, titular);
    }

    @Override
    public void ingresarDinero(long cantidad) {
        if (cantidad >= getTitular().getMinIngreso()) {
            super.ingresarDinero(cantidad);
        } else {
            System.out.println("El ingreso en la cuenta a plazo debe ser superior a " + getTitular().getMinIngreso()/100 + " euros.");
        }
    }

    @Override
    public void retirarDinero(long cantidad) {
        long comision = Math.max((long)(cantidad * getTitular().getComision()), getTitular().getMinComision());
        if ((getSaldo() - cantidad - comision) >= getTitular().getMaxDeuda()) {
            super.retirarDinero(cantidad + comision);
        } else {
            System.out.println("No se permite descubierto inferior a " + getTitular().getMaxDeuda()/100 + " en la cuenta a plazos");
        }
    }
}