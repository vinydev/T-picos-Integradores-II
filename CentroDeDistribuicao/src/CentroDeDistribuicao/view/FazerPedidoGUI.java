/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CentroDeDistribuicao.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Vinicius
 */
public class FazerPedidoGUI extends JFrame{
    ArrayList <JPanel> panel1 = new ArrayList<JPanel>();
    ArrayList <JPanel> panel2 = new ArrayList<JPanel>();
    ArrayList <JLabel> label = new ArrayList<JLabel>();
    JButton b1;
    int num=4;
    
    public FazerPedidoGUI() throws HeadlessException {
        super("Fazer Pedido");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(400, 100, 1000, 700);
        this.setLocationRelativeTo(null);
        iniciarPaineis();
        iniciarLabels();
        iniciarBotoes();
        iniciarTabelas();
        this.setVisible(true);
    }

    private void iniciarPaineis() {
        JPanel pagina = new JPanel();
        this.getContentPane().add(pagina);
        pagina.setBackground(Color.white);
        pagina.setPreferredSize(new Dimension(1000, 800));
        JScrollPane scroll = new JScrollPane();
        scroll.setPreferredSize(new Dimension(1000, 800));
        for (int i = 0; i<this.num;i++){
            this.panel1.add(new JPanel());
            pagina.add(this.panel1.get(i));
            if (i == 0 || i % 2 == 0){
                this.panel1.get(i).setBackground(Color.yellow);
            }else{
                this.panel1.get(i).setBackground(Color.white);
            }
        }
        scroll.setViewportView(pagina);
        this.getContentPane().add(scroll);
        pagina.setLayout(new BoxLayout(pagina, BoxLayout.Y_AXIS));
        for (int i = 0; i<4;i++){
            this.panel2.add(new JPanel());
            this.panel1.get(2).add(this.panel2.get(i));
            this.panel2.get(i).setBackground(Color.yellow);
        }
    }

    private void iniciarLabels() {
        this.label.add(new JLabel("código do pedido: codigo"));
        this.label.add(new JLabel("data do pedido: data"));
        this.label.add(new JLabel("<html><body>Produtos<br>Para<br>adicionar:</body><html>"));
        this.label.add(new JLabel("<html><body>Produtos<br>adicionados:</body><html>"));
        this.panel1.get(0).add(this.label.get(0));
        this.panel1.get(1).add(this.label.get(1));
        this.panel2.get(0).add(this.label.get(2));
        this.panel2.get(2).add(this.label.get(3));
        Font f1 = new Font(Font.DIALOG_INPUT, Font.BOLD, 20);
        for (int i = 0; i<4;i++){
            this.label.get(i).setFont(f1);
        }
    }

    private void iniciarBotoes() {
        ButtonHandler buttonHandler=new ButtonHandler();
        this.b1 = new JButton("Finalizar Pedido");
        this.panel1.get(3).add(this.b1);
        this.b1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        b1.setBackground(Color.white);
        b1.addActionListener(buttonHandler);
        
    }

    private void iniciarTabelas() {
        String [] colunas = {"Nome", "Descrição", "Quantidade"};
        Object [][] dados = {
        {"Bacia", "Tal marca", "2"},
        {"Martelo", "Outra marca", "11"},
        {"caixa", "Brasil", "12"}
        };
        	
        JTable tabela = new JTable(dados, colunas);
        JScrollPane barraRolagem = new JScrollPane(tabela);
        this.panel2.get(1).add(barraRolagem);
        tabela.setPreferredSize(new Dimension(300,100));
        barraRolagem.setPreferredSize(new Dimension(300,100));
        String [] colunas2 = {"Nome", "Descrição", "Quantidade"};
        Object [][] dados2 = {
        {"Bacia", "Tal marca", "2"},
        {"Martelo", "Outra marca", "11"},
        {"caixa", "Brasil", "12"}
        };
        	
        JTable tabela2 = new JTable(dados2, colunas2);
        JScrollPane barraRolagem2 = new JScrollPane(tabela2);
        this.panel2.get(3).add(barraRolagem2);
        tabela2.setPreferredSize(new Dimension(300,100));
        barraRolagem2.setPreferredSize(new Dimension(300,100));
    }
    class ButtonHandler implements ActionListener{
    
    public void actionPerformed(ActionEvent ae){

    if (ae.getSource() == b1){
        
    }
  }
}
}
