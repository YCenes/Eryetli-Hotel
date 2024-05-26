package AnaSayfa;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CiftKisilikOdaFrame extends JFrame {

	private ImageIcon ımage1 = new ImageIcon("ciftkisilikodas.jpg");
	private ImageIcon ımage2 = new ImageIcon("ciftkisilikodas2.jpg");
	private ImageIcon ımage3 = new ImageIcon("ciftkisilikozellikler.jpeg");
	
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	
	private JPanel panel;
	
	
	private JButton geridonbuton;
	
	private String id;
	
	public CiftKisilikOdaFrame(String id) {
		
		this.id = id;
		
		
		
		
		//Nesne Oluşturma
		
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		
		panel = new JPanel();
		
		geridonbuton = new JButton("Geri Dön");
		
		
		
		//Label İşlemleri
		
		label1.setIcon(ımage1);
		label1.setBounds(0, 0, 619, 335);
		
		
		label2.setIcon(ımage2);
		label2.setBounds(522, 0, 488, 334);
		
		
		label3.setIcon(ımage3);
		label3.setBounds(522, 335, 488, 444);
		
		
		
		
		//Panel İşlemleri
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 335, 522, 396);
		panel.setLayout(null);
		geridonbuton.setBounds(162, 132, 174, 116);
		panel.add(geridonbuton);
		
		
		
		//Buton İşlemleri
		geridonbuton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		geridonbuton.setFocusPainted(false);
		geridonbuton.setBorderPainted(false);
		geridonbuton.setForeground(Color.yellow);
		geridonbuton.setBackground(Color.black);
		geridonbuton.setBounds(134, 128, 250, 130);
		
		
		geridonbuton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
                setVisible(false);
               OdaTipleriFrame oda1 = new OdaTipleriFrame(id);

          	  
          	  
             }
        
        
        });
		
		geridonbuton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
            	geridonbuton.setBackground(new Color(35,35,35));
            }

            public void mouseExited(MouseEvent e) {
            	geridonbuton.setBackground(Color.black);
            }

        });
		
		
		
		
		
		//Frame İşlemleri
		this.getContentPane().add(label1);
		this.getContentPane().add(label2);
		this.getContentPane().add(label3);
		this.getContentPane().add(panel);
		this.setBounds(100, 100, 1024, 768);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	
	
	
	
	
	
	
	
	
}
