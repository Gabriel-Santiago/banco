package Trabalho1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Depositar extends JFrame implements ActionListener{

    JLabel msgNumeroDepositar = new JLabel("Número da conta:");
    JTextField entradaNumeroDepositar = new JTextField(12);
    JLabel msgValorDepositar = new JLabel("Valor depositado:");
    JTextField entradaValorDepositar = new JTextField(13);
    JButton okDepositar = new JButton("Ok");
    JButton cancelarDepositar = new JButton("Cancelar");
    
    public Depositar(){
        setLayout(new FlowLayout());
        add(msgNumeroDepositar);
        add(entradaNumeroDepositar);
        add(msgValorDepositar);
        add(entradaValorDepositar);
        add(cancelarDepositar);
        add(okDepositar);
        okDepositar.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setVisible(true); 
        this.setSize(216, 180); 
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Depósito"); 
    } 
    
    @Override
    public void actionPerformed(ActionEvent e) {
       int xDeposito = Integer.parseInt(entradaNumeroDepositar.getText());
        double pDeposito = Double.parseDouble(entradaValorDepositar.getText());
        if(e.getSource() == okDepositar){
            if(xDeposito == CadastrarContas.cm.numero){
               CadastrarContas.cm.depositar(pDeposito);
                this.dispose();
            }else if(xDeposito == CadastrarContaPoupanca.cp.numero){
                CadastrarContaPoupanca.cp.depositar(pDeposito);
                this.dispose();
            }else if(xDeposito == CadastrarContaEspecial.ce.numero){
                CadastrarContaEspecial.ce.depositar(pDeposito);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Conta não encontrada!");
            }
        }else if(e.getSource() == cancelarDepositar){
            JOptionPane.showMessageDialog(null, "O botão CANCELAR foi clicado");
            this.dispose();
        } 
    }   
}