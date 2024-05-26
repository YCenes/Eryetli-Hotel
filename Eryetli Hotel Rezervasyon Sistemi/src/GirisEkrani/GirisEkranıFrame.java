package GirisEkrani;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;




public class GirisEkranıFrame extends JFrame{

	private JButton kayıtolbuton;
	private JButton girisyapbuton;
	private JPanel bottomPanel;
	private JPanel topLeftPanel;
	private JPanel topRightPanel;
	private JLabel otelkarsilama;
	private JLabel logokarsilama;
	
	
	
	
	
	
	public GirisEkranıFrame() {
		
		
		
		//Logo:
		
		ImageIcon logo = new ImageIcon("Eryetli.png");
		ImageIcon kucuklogo = new ImageIcon("mehmetims.png");
		
		
		

		
		//Buton ile ilgili kısım:
		
		kayıtolbuton = new JButton("Üye Ol");
		kayıtolbuton.setFont(new Font("TimesRoman",Font.PLAIN,30));

		girisyapbuton = new JButton("Giriş Yap");
		girisyapbuton.setFont(new Font("TimesRoman",Font.PLAIN,30));
		
		
		
		

		girisyapbuton.setPreferredSize(new Dimension(300, 150));
		kayıtolbuton.setPreferredSize(new Dimension(300, 150));
		
		girisyapbuton.setFocusPainted(false);
		kayıtolbuton.setFocusPainted(false);
		girisyapbuton.setBorderPainted(false);
		kayıtolbuton.setBorderPainted(false);
		
		girisyapbuton.setBackground(Color.black);
		kayıtolbuton.setBackground(Color.black);
		
		girisyapbuton.setForeground(Color.yellow);
		kayıtolbuton.setForeground(Color.yellow);
	    

	    girisyapbuton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                girisyapbuton.setBackground(new Color(35,35,35));
            }

            public void mouseExited(MouseEvent e) {
                girisyapbuton.setBackground(Color.black);
            }

        });
          kayıtolbuton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                kayıtolbuton.setBackground(new Color(35,35,35));
            }

            public void mouseExited(MouseEvent e) {
                kayıtolbuton.setBackground(Color.black);
            }

        });
          girisyapbuton.setBorderPainted(false);
          
          
          
          
          
          
          
          girisyapbuton.addActionListener(new ActionListener() {

              @Override
              public void actionPerformed(ActionEvent e) {
              	
                  setVisible(false);
                  GirisYapFrame giris = new GirisYapFrame();

            	  
            	  
               }
          
          
          });
          
          
          
          kayıtolbuton.addActionListener(new ActionListener() {

              @Override
              public void actionPerformed(ActionEvent e) {
              	
                  setVisible(false);
                 UyeOlFrame uyeol = new UyeOlFrame();

            	  
            	  
               }
          
          
          });
          
          
          
          
          
          
		
		
		//Labellar ile ilgili kısım:
		
		otelkarsilama = new JLabel();
		otelkarsilama.setText("Eryetli Hotel'e Hoşgeldiniz...");
		
		otelkarsilama.setFont(new Font("TimesRoman",Font.ITALIC,60));
		
		logokarsilama = new JLabel();
		logokarsilama.setIcon(kucuklogo);
		
		
		//Panellerle İlgili Kısımlar:
		topLeftPanel = new JPanel();
		topRightPanel = new JPanel();
		bottomPanel = new JPanel();
		
		topLeftPanel.add(logokarsilama);
		topRightPanel.add(otelkarsilama);
		bottomPanel.add(girisyapbuton);
		bottomPanel.add(kayıtolbuton);
		
		topLeftPanel.setBackground(Color.lightGray);
		topRightPanel.setBackground(Color.lightGray);
		bottomPanel.setBackground(Color.lightGray);
		
		
		
		
		
		
		//Sayfa Düzeni İle İlgili Kısımlar:
		
		this.setLayout(new GridLayout(3,1));
		
		topLeftPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		topRightPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		
		
		
		//Frame İle İlgili Kısımlar:
	
		this.setSize(1024,768);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Eryetli Hotel Giriş Ekranı");
		this.setIconImage(logo.getImage());
		
		
		this.add(topLeftPanel);
		this.add(topRightPanel);
		this.add(bottomPanel);
		
		this.setVisible(true);
		
		this.setLocationRelativeTo(null);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
