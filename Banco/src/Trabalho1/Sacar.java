package Trabalho1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Sacar extends JFrame implements ActionListener{
    
    JLabel msgNumeroSacar = new JLabel("Número da conta:");
    JTextField entradaNumeroSacar = new JTextField(12);
    JLabel msgValorSacar = new JLabel("Valor desejado:");
    JTextField entradaValorSacar = new JTextField(13);
    JButton okSacar = new JButton("Ok");
    JButton cancelarSacar = new JButton("Cancelar");
    
    public Sacar(){
        setLayout(new FlowLayout());
        add(msgNumeroSacar);
        add(entradaNumeroSacar);
        add(msgValorSacar);
        add(entradaValorSacar);
        add(cancelarSacar);
        add(okSacar);
        okSacar.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setVisible(true); 
        this.setSize(216, 180); 
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Saque"); 
    }      
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int xSaque = Integer.parseInt(entradaNumeroSacar.getText());
        double pSaque = Double.parseDouble(entradaValorSacar.getText());
        if(e.getSource() == okSacar){
            if(xSaque == CadastrarContas.cm.numero){
               CadastrarContas.cm.sacar(pSaque);
                this.dispose();
            }else if(xSaque == CadastrarContaPoupanca.cp.numero){
                CadastrarContaPoupanca.cp.sacar(pSaque);
                this.dispose();
            }else if(xSaque == CadastrarContaEspecial.ce.numero){
                CadastrarContaEspecial.ce.sacar(pSaque);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Conta não encontrada!");
            }
        }else if(e.getSource() == cancelarSacar){
            JOptionPane.showMessageDialog(null, "O botão CANCELAR foi clicado");
            this.dispose();
        }
    }
}