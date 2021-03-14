package Trabalho1;

import javax.swing.JOptionPane;

public class ContaPoupanca extends Contas{
    
    protected double taxa;

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }
    
    public void depositar(double valor) {
        saldo += valor;
        JOptionPane.showMessageDialog(null, "Depósito efetuado com sucesso, " + CadastrarContaPoupanca.cp.getNome());
    }
        
    public void sacar(double valor) {
        if(valor <= saldo) {
            double novoSaldo = saldo - valor;
            this.saldo = novoSaldo;
            JOptionPane.showMessageDialog(null, "Saque efetuado com sucesso, " + CadastrarContaPoupanca.cp.getNome());
        }    
        else JOptionPane.showMessageDialog(null, "Saldo insuficiente, " + CadastrarContaPoupanca.cp.getNome());
    }
    
    public boolean reajustar (double taxa){
        if(taxa > 0){
            double saldoAtual = this.getSaldo();
            double reajuste = saldoAtual * (taxa / 100);
            this.depositar(reajuste);
            JOptionPane.showMessageDialog(null, "Reajuste efetuado com sucesso, " + CadastrarContaPoupanca.cp.getNome());
            return true;
        }else{
            double saldoAtual = this.getSaldo();
            double reajuste = saldoAtual * 0.1;
            this.depositar(reajuste);
            return false;
        }
    }
    
    public boolean transferir(ContaPoupanca numeroContaDestino, double valor){
        if(this.saldo >= valor){
           this.saldo -= valor;
           numeroContaDestino.saldo += valor;
           JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso, " + CadastrarContaPoupanca.cp.getNome());
           return true;
        }else{
           JOptionPane.showMessageDialog(null, "Saldo insuficiente, " + CadastrarContaPoupanca.cp.getNome());
           return false;
        }
    }
    
    @Override
    public void tipoConta(){
        System.out.println("Conta Poupança");
    }
}