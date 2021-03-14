package Trabalho1;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Contas extends JFrame{
    
    protected String nome;
    protected int numero;
    protected double saldo;

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
        JOptionPane.showMessageDialog(null, "Depósito efetuado com sucesso, " + CadastrarContas.cm.getNome());
    }
    
    public void sacar(double valor) {
        if(valor <= saldo) {
            double novoSaldo = saldo - valor;
            this.saldo = novoSaldo;
            JOptionPane.showMessageDialog(null, "Saque efetuado com sucesso, " + CadastrarContas.cm.getNome());
        }    
        else JOptionPane.showMessageDialog(null, "Saldo insuficiente, " + CadastrarContas.cm.getNome());
    }
    
    public void tipoConta(){
        System.out.println("Conta Comum");
    }
    
    public boolean transferir(Contas numeroContaDestino, double valor){
        if(this.saldo >= valor){
           this.saldo -= valor;
           numeroContaDestino.saldo += valor;
           JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso, " + CadastrarContas.cm.getNome());
           return true;
        }else{
           JOptionPane.showMessageDialog(null, "Saldo insuficiente, " + CadastrarContas.cm.getNome());
           return false;
        }
    }
}