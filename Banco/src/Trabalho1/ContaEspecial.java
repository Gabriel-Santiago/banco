package Trabalho1;

import javax.swing.JOptionPane;

public class ContaEspecial extends Contas{
    
    protected int limite;
    protected double multa;
    
    public double getLimite() {
        return limite;
    }
    public void setLimite(int limite) {
        this.limite = limite;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }
    
    public void depositar(double valor) {
        saldo += valor;
        JOptionPane.showMessageDialog(null, "Depósito efetuado com sucesso, " + CadastrarContaEspecial.ce.getNome());
    }
    
    @Override
    public void sacar(double valor) {
        if(valor <= saldo){
            double novoSaldo = saldo - valor;
            this.saldo = novoSaldo;
            JOptionPane.showMessageDialog(null, "Saque efetuado com sucesso, " + CadastrarContaEspecial.ce.getNome());
        }else if(valor <= saldo + limite) {
            double multaAjustada = (multa / 100) + 1;
            double novoSaldo = (saldo - valor) * multaAjustada;
            this.saldo = novoSaldo;
            JOptionPane.showMessageDialog(null, "Saque efetuado usando cheque especial, " + CadastrarContaEspecial.ce.getNome());
        }else{
            JOptionPane.showMessageDialog(null, "Saldo insuficiente, " + CadastrarContaEspecial.ce.getNome());
        }
    }
    
    public boolean transferir(ContaEspecial numeroContaDestino, double valor){
        if(this.saldo >= valor){
           this.saldo -= valor;
           numeroContaDestino.saldo += valor;
           JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso, " + CadastrarContaEspecial.ce.getNome());
           return true;
        }else{
           JOptionPane.showMessageDialog(null, "Saldo insuficiente, " + CadastrarContaEspecial.ce.getNome());
           return false;
        }
    }
    
    @Override
    public void tipoConta(){
        System.out.println("Conta Especial");
    }
}