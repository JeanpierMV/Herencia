package com.example;

public class CuentaCorriente extends Cuenta {
    private float sobregiro = 0;

    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
    }

    @Override
    public void retirar(float cantidad) {
        if (cantidad <= 0) {
            return;
        }
        if (cantidad <= saldo) {
            super.retirar(cantidad);
        } else {
            float excedente = cantidad - saldo;
            saldo = 0;
            sobregiro += excedente;
            numeroRetiros++;
        }
    }

    @Override
    public void consignar(float cantidad) {
        if (cantidad <= 0) {
            return;
        }
        if (sobregiro > 0) {
            if (cantidad >= sobregiro) {
                cantidad -= sobregiro;
                sobregiro = 0;
                super.consignar(cantidad);
            } else {
                sobregiro -= cantidad;
                // No se incrementa el saldo porque aún hay sobregiro
                numeroConsignaciones++;
            }
        } else {
            super.consignar(cantidad);
        }
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    @Override
    public void imprimir() {
        System.out.println("Cuenta Corriente");
        System.out.println("Saldo: " + saldo);
        System.out.println("Comisión mensual: " + comisionMensual);
        System.out.println("Número de transacciones: " + (numeroConsignaciones + numeroRetiros));
        System.out.println("Sobregiro: " + sobregiro);
    }
}
