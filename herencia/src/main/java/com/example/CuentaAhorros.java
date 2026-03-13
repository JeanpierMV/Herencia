package com.example;

public class CuentaAhorros extends Cuenta {
    private boolean activa;

    public CuentaAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.activa = saldo >= 10000;
    }

    private void actualizarEstado() {
        activa = saldo >= 10000;
    }

    @Override
    public void consignar(float cantidad) {
        if (!activa) {
            return; // no se puede consignar si la cuenta está inactiva
        }
        super.consignar(cantidad);
    }

    @Override
    public void retirar(float cantidad) {
        if (!activa) {
            return; // no se puede retirar si la cuenta está inactiva
        }
        super.retirar(cantidad);
    }

    @Override
    public void extractoMensual() {
        // Si el número de retiros es mayor a 4, se cobra $1000 por cada retiro adicional
        if (numeroRetiros > 4) {
            int retirosExtra = numeroRetiros - 4;
            comisionMensual += 1000f * retirosExtra;
        }
        super.extractoMensual();
        actualizarEstado();
    }

    @Override
    public void imprimir() {
        actualizarEstado();
        System.out.println("Cuenta de Ahorros");
        System.out.println("Activa: " + activa);
        System.out.println("Saldo: " + saldo);
        System.out.println("Comisión mensual: " + comisionMensual);
        System.out.println("Número de transacciones: " + (numeroConsignaciones + numeroRetiros));
    }
}
