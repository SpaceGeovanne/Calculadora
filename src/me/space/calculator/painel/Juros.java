package me.space.calculator.painel;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import me.space.calculator.api.JurosCalc;

public class Juros extends JFrame {
	
	private JPanel contentPane;
	private static Juros juros;
	private JTextField a = new JTextField();
	private JTextField b = new JTextField();
	private JTextField c = new JTextField();
	
	public static void openPanel() {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					Juros.access$0(new Juros());
					Juros.juros.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Juros() {
		this.setResizable(false);
        this.setTitle("Juros Simples");
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
        
        final JLabel calc1 = new JLabel("Juros Simples");
        calc1.setHorizontalAlignment(0);
        calc1.setFont(new Font("Segoe UI", 1, 13));
        calc1.setBounds(57, 25, 150, 30);
        this.contentPane.add(calc1);
        
        (this.a = new JTextField()).setBounds(80, 61, 100, 28);
        this.contentPane.add(this.a);
        this.a.setColumns(10);
        final JLabel label_key = new JLabel("Capital:");
        label_key.setFont(new Font("Segoe UI", 1, 13));
        label_key.setBounds(15, 67, 90, 17);
        this.contentPane.add(label_key);
        
        final JLabel label_key2 = new JLabel("Taxa:");
        label_key2.setFont(new Font("Segoe UI", 1, 13));
        label_key2.setBounds(15, 102, 90, 17);
        this.contentPane.add(label_key2);
        
        (this.b = new JTextField()).setBounds(80, 97, 100, 28);
        this.contentPane.add(this.b);
        
        final JLabel label_key3 = new JLabel("Tempo:");
        label_key3.setFont(new Font("Segoe UI", 1, 13));
        label_key3.setBounds(15, 137, 90, 17);
        this.contentPane.add(label_key3);
        
        (this.c = new JTextField()).setBounds(80, 133, 100, 28);
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
				
				JOptionPane.showMessageDialog(null, JurosCalc.calcular(a.getText(), b.getText(), c.getText()), "Resposta", 2);
			}
		});
        
        button.setFont(new Font("Segoe UI", 1, 13));
        button.setBounds(10, 170, 242, 20);
        this.contentPane.add(button);
        
        final JButton back = new JButton("Voltar");
        back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home.openPanel();
			}
		});
        back.setFont(new Font("Segoe UI", 1, 13));
        back.setBounds(10, 197, 242, 20);
        this.contentPane.add(back);
        
	}
	
	static /* synthetic */ void access$0(final Juros juros) {
        Juros.juros = juros;
    }
	
	public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
