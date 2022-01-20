package me.space.calculator.painel;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import me.space.calculator.api.Equação;

public class EquaçãoMenu extends JFrame {
	
	private JPanel contentPane;
	private JTextField a = new JTextField();
	private JTextField b = new JTextField();
	private JTextField c = new JTextField();
	
	private static EquaçãoMenu home;
    
    public static void openPanel() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    EquaçãoMenu.access$0(new EquaçãoMenu());
                    EquaçãoMenu.home.setVisible(true);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
	
	public EquaçãoMenu() {
		this.setResizable(false);
        this.setTitle("Calculadora");
        this.setDefaultCloseOperation(3);
        this.setBounds(180, 180, 280, 280);
        (this.contentPane = new JPanel()).setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);
        final JLabel label_auth = new JLabel("INSERIR NÚMEROS");
        label_auth.setHorizontalAlignment(0);
        label_auth.setFont(new Font("Segoe UI", 1, 16));
        label_auth.setBounds(10, 6, 244, 28);
        this.contentPane.add(label_auth);
        
        final JLabel calc1 = new JLabel("Equação do 2° grau");
        calc1.setHorizontalAlignment(0);
        calc1.setFont(new Font("Segoe UI", 1, 13));
        calc1.setBounds(57, 25, 150, 30);
        this.contentPane.add(calc1);
        
        (this.a = new JTextField()).setBounds(110, 61, 100, 28);
        this.contentPane.add(this.a);
        this.a.setColumns(10);
        final JLabel label_key = new JLabel("Valor de A:");
        label_key.setFont(new Font("Segoe UI", 1, 13));
        label_key.setBounds(10, 67, 90, 17);
        this.contentPane.add(label_key);
        
        final JLabel label_key2 = new JLabel("Valor de B:");
        label_key2.setFont(new Font("Segoe UI", 1, 13));
        label_key2.setBounds(10, 102, 90, 17);
        this.contentPane.add(label_key2);
        
        (this.b = new JTextField()).setBounds(110, 97, 100, 28);
        this.contentPane.add(this.b);
        
        final JLabel label_key3 = new JLabel("Valor de C:");
        label_key3.setFont(new Font("Segoe UI", 1, 13));
        label_key3.setBounds(10, 137, 90, 17);
        this.contentPane.add(label_key3);
        
        (this.c = new JTextField()).setBounds(110, 133, 100, 28);
        this.contentPane.add(this.c);
        
        final JLabel creditos = new JLabel("Criado por: Space!");
        creditos.setFont(new Font("Segoe UI", 1, 13));
        creditos.setBounds(75, 220, 220, 17);
        this.contentPane.add(creditos);
        
        final JButton button = new JButton("Calcular");
        
        button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(a.getText().isEmpty() || a.getText().equalsIgnoreCase(" ")
						|| b.getText().isEmpty() || b.getText().equalsIgnoreCase(" ")
						|| c.getText().isEmpty() || c.getText().equalsIgnoreCase(" ")) { 
					JOptionPane.showMessageDialog(null, "Todos os argumentos não podem ser vazios.", "Erro ao continuar!", 0);
					return;
				}
				if(!isInt(a.getText()) && !isInt(b.getText()) && !isInt(c.getText())) {
					JOptionPane.showMessageDialog(null, "Insira em todos os argumentos somente números!", "Erro ao continuar!", 0);
					return;
				}
				
				if(a.getText().equalsIgnoreCase("0")) {
					JOptionPane.showMessageDialog(null, "Valor de A: 0 - Esta não é uma equação do segundo grau!", "Erro ao continuar!", 0);
					return;
				}
				
				String[] resultado = Equação.calcular(a.getText(), b.getText(), c.getText()).split(" ; ");
				JOptionPane.showMessageDialog(null, "Sua equação é: " + resultado[0] + "\n"
						+ "O valor de Delta é: " + resultado[1] + "\n"
						+ resultado[2], "Resposta", 1);
			}
		});
        
        button.setFont(new Font("Segoe UI", 1, 13));
        button.setBounds(10, 180, 242, 30);
        this.contentPane.add(button);
	}

	public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
	
	static /* synthetic */ void access$0(final EquaçãoMenu home) {
        EquaçãoMenu.home = home;
    }
	
}
