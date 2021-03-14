package Trabalho1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Transferir extends JFrame implements ActionListener{

    JLabel msgNumeroDarTransferir = new JLabel("Número da conta que vai dar:");
    JTextField entradaNumeroDarTransferir = new JTextField(12);
    JLabel msgNumeroReceberTransferir = new JLabel("Número da conta receber:");
    JTextField entradaNumeroReceberTransferir = new JTextField(12);
    JLabel msgValorTransferir = new JLabel("Valor da transferência:");
    JTextField entradaValorTransferir = new JTextField(13);
    JButton okTransferir = new JButton("Ok");
    JButton cancelarTransferir = new JButton("Cancelar");
    
    public Transferir(){
        setLayout(new FlowLayout());
        add(msgNumeroDarTransferir);
        add(entradaNumeroDarTransferir);
        add(msgNumeroReceberTransferir);
        add(entradaNumeroReceberTransferir);
        add(msgValorTransferir);
        add(entradaValorTransferir);
        add(cancelarTransferir);
        add(okTransferir);
        okTransferir.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setVisible(true); 
        this.setSize(216, 216); 
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Transferir"); 
    } 
    
    @Override
    public void actionPerformed(ActionEvent e) {
       int xDarTransferir = Integer.parseInt(entradaNumeroDarTransferir.getText());
       int xReceberTransferir = Integer.parseInt(entradaNumeroReceberTransferir.getText());
       double xValorTransferir = Double.parseDouble(entradaValorTransferir.getText());
       if(e.getSource() == okTransferir){
           if(xDarTransferir == CadastrarContas.cm.numero){
               if(xReceberTransferir == CadastrarContaPoupanca.cp.numero){
                   CadastrarContas.cm.transferir(CadastrarContaPoupanca.cp, xValorTransferir);
                   this.dispose();
               }else if(xReceberTransferir == CadastrarContaEspecial.ce.numero){
                   CadastrarContas.cm.transferir(CadastrarContaEspecial.ce, xValorTransferir);
                   this.dispose();
               }else{
                   JOptionPane.showMessageDialog(null, "Conta para transferência não encontrada!");
               }
           }else if(xDarTransferir == CadastrarContaPoupanca.cp.numero){
               if(xReceberTransferir == CadastrarContas.cm.numero){
                   CadastrarContaPoupanca.cp.transferir(CadastrarContas.cm, xValorTransferir);
                   this.dispose();
               }else if(xReceberTransferir == CadastrarContaEspecial.ce.numero){
                   CadastrarContaPoupanca.cp.transferir(CadastrarContaEspecial.ce, xValorTransferir);
                   this.dispose();
               }else{
                   JOptionPane.showMessageDialog(null, "Conta para transferência não encontrada!");
               }
           }else if(xDarTransferir == CadastrarContaEspecial.ce.numero){
               if(xReceberTransferir == CadastrarContas.cm.numero){
                   CadastrarContaEspecial.ce.transferir(CadastrarContas.cm, xValorTransferir);
                   this.dispose();
               }else if(xReceberTransferir == CadastrarContaPoupanca.cp.numero){
                   CadastrarContaEspecial.ce.transferir(CadastrarContaPoupanca.cp, xValorTransferir);
                   this.dispose();
               }else{
                   JOptionPane.showMessageDialog(null, "Conta para transferência não encontrada!");
               }
           }else{
               JOptionPane.showMessageDialog(null, "Conta para transferência não encontrada!");
           }
       }else if(e.getSource() == cancelarTransferir){
           JOptionPane.showMessageDialog(null, "O botão CANCELAR foi clicado");
           this.dispose();
       }
    } 
}