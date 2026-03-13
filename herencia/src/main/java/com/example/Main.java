package com.example;

public class Main {
    public static void main(String[] args) {
        // Crear una cuenta de ahorros
        CuentaAhorros ahorro = new CuentaAhorros(12000f, 12f);
        ahorro.consignar(2000f);
        ahorro.retirar(500f);
        ahorro.retirar(500f);
        ahorro.retirar(500f);
        ahorro.retirar(500f);
        ahorro.retirar(500f); // 5to retiro -> comision extra
        ahorro.extractoMensual();
        ahorro.imprimir();

        System.out.println();

        // Crear una cuenta corriente
        CuentaCorriente corriente = new CuentaCorriente(5000f, 10f);
        corriente.retirar(6000f); // genera sobregiro
        corriente.consignar(2000f); // reduce sobregiro
        corriente.extractoMensual();
        corriente.imprimir();
    }
}
