package Trabalho1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadastrarContaPoupanca extends JFrame implements ActionListener{

        static ContaPoupanca cp = new ContaPoupanca();
        
        JLabel msgTitularPoupanca = new JLabel("Titular:");
        JTextField entradaTitularPoupanca = new JTextField(18);
        JLabel msgNumeroPoupanca = new JLabel(" Número da conta: ");
        JTextField entradaNumeroPoupanca = new JTextField(12);
        JLabel msgSaldoPoupanca = new JLabel(" Saldo: ");
        JTextField entradaSaldoPoupanca = new JTextField(18);
        JLabel msgReajustePoupanca = new JLabel(" Reajuste: ");
        JTextField entradaReajustePoupanca = new JTextField(16);
        JButton contaPoupancaOk = new JButton("Ok");
        
        public CadastrarContaPoupanca(){
            
            setLayout(new FlowLayout());
            add(msgTitularPoupanca);
            add(entradaTitularPoupanca);
            add(msgNumeroPoupanca);
            add(entradaNumeroPoupanca);
            add(msgSaldoPoupanca);
            add(entradaSaldoPoupanca);
            add(msgReajustePoupanca);
            add(entradaReajustePoupanca);
            add(contaPoupancaOk);
            contaPoupancaOk.addActionListener(this);
            this.setTitle("Conta Poupança");
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.setSize(270, 180);
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        } 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == contaPoupancaOk){
            cp.setNome(entradaTitularPoupanca.getText());
            cp.setNumero(Integer.parseInt(entradaNumeroPoupanca.getText()));
            cp.setSaldo(Float.parseFloat(entradaSaldoPoupanca.getText()));
            cp.setTaxa(Double.parseDouble(entradaReajustePoupanca.getText()));  
            cp.reajustar(cp.getTaxa());
            CadastrarContaEspecial contaEsp = new CadastrarContaEspecial();
            this.dispose();
        }
    }     
}