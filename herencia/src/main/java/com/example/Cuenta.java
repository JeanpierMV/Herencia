package com.example;

public class Cuenta {
    protected float saldo;
    protected int numeroConsignaciones = 0;
    protected int numeroRetiros = 0;
    protected float tasaAnual;
    protected float comisionMensual = 0;

    public Cuenta(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }

    public void consignar(float cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            numeroConsignaciones++;
        }
    }

    public void retirar(float cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            numeroRetiros++;
        }
    }

    public void calcularInteres() {
        float interesMensual = saldo * (tasaAnual / 100f) / 12f;
        saldo += interesMensual;
    }

    public void extractoMensual() {
        calcularInteres();
        saldo -= comisionMensual;
        // Nota: los contadores y la comisión se mantienen para que puedan mostrarse en el extracto.
    }

    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Tasa anual: " + tasaAnual);
        System.out.println("Número de consignaciones: " + numeroConsignaciones);
        System.out.println("Número de retiros: " + numeroRetiros);
        System.out.println("Comisión mensual: " + comisionMensual);
    }
}
