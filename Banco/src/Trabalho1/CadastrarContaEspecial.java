package Trabalho1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadastrarContaEspecial extends JFrame implements ActionListener{

        static ContaEspecial ce = new ContaEspecial();
    
        JLabel msgTitularEspecial = new JLabel("Titular:");
        JTextField entradaTitularEspecial = new JTextField(18);
        JLabel msgNumeroEspecial = new JLabel(" Número da conta: ");
        JTextField entradaNumeroEspecial = new JTextField(12);
        JLabel msgSaldoEspecial = new JLabel(" Saldo: ");
        JTextField entradaSaldoEspecial = new JTextField(18);
        JLabel msgLimiteEspecial = new JLabel(" Limite:");
        JTextField entradaLimiteEspecial = new JTextField(18);
        JLabel msgMultaEspecial = new JLabel(" Multa:");
        JTextField entradaMultaEspecial = new JTextField(18);
        JButton contaEspecialOk = new JButton("Ok");
        
        public CadastrarContaEspecial(){
            
            setLayout(new FlowLayout());
            add(msgTitularEspecial);
            add(entradaTitularEspecial);
            add(msgNumeroEspecial);
            add(entradaNumeroEspecial);
            add(msgSaldoEspecial);
            add(entradaSaldoEspecial);
            add(msgLimiteEspecial);
            add(entradaLimiteEspecial);
            add(msgMultaEspecial);
            add(entradaMultaEspecial);
            add(contaEspecialOk);
            contaEspecialOk.addActionListener(this);
            this.setTitle("Conta Especial");
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.setSize(270, 216);
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        } 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == contaEspecialOk){
            ce.setNome(entradaTitularEspecial.getText());
            ce.setNumero(Integer.parseInt(entradaNumeroEspecial.getText()));
            ce.setSaldo(Float.parseFloat(entradaSaldoEspecial.getText()));
            ce.setLimite(Integer.parseInt(entradaLimiteEspecial.getText()));
            ce.setMulta(Double.parseDouble(entradaMultaEspecial.getText()));
            Principal principal = new Principal();
            this.dispose();
        }
    }  
}