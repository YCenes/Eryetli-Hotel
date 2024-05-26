package GirisEkrani;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import AnaSayfa.AnaSayfaFrame;

public class GirisYapFrame extends JFrame {

	private File dosya = new File("Bilgiler.txt");

	private JButton girisyapbuton;
	private JButton sifremiunuttum;
	private JButton geridonbuton;
	
	private JPanel topPanel;
	private JPanel tcPanel;
	private JPanel sifrePanel;
	private JPanel bottomPanel;
	private JPanel sifreTcPanel;
	
	
	private JLabel TC;
	private JLabel sifre;
	private JLabel logoLabel;
	
	
	private JTextField tTC;
	private JPasswordField tsifre;

	
	public GirisYapFrame() {
		
		
		//Logo İşlemleri:
		
		ImageIcon logo = new ImageIcon("eryetlis.png");
		ImageIcon girisyap = new ImageIcon("girisyap.png");
		
		
		//Nesne Oluşturma:
		
		girisyapbuton = new JButton("Giriş Yap");
		sifremiunuttum = new JButton("Sifremi Unuttum");
		geridonbuton = new JButton("Geri Dön");
		
		topPanel = new JPanel();
		tcPanel = new JPanel();
		sifrePanel = new JPanel();
		bottomPanel = new JPanel();
		sifreTcPanel = new JPanel();
		sifreTcPanel = new JPanel();
		
		
		TC = new JLabel("TC Numaranız:");
		sifre = new JLabel("Şifreniz:");
		logoLabel = new JLabel();
		
		tTC = new JTextField();
		tsifre = new JPasswordField();
		
	
		
		
		//TextField İşlemleri
		
		tTC.setFont(new Font("TimesRoman",Font.ITALIC,30));
		tsifre.setFont(new Font("TimesRoman",Font.ITALIC,30));
		
		tsifre.setEchoChar('*');
		
		tTC.setPreferredSize(new Dimension(200,50));
		tsifre.setPreferredSize(new Dimension(200,50));
		
		
		
		
		
		
		//Label İşlemleri:
		
		logoLabel.setIcon(girisyap);
		TC.setFont(new Font("TimesRoman",Font.ITALIC,30));
		sifre.setFont(new Font("TimesRoman",Font.ITALIC,30));
		
		//Buton İşlemleri:
		
		girisyapbuton.setPreferredSize(new Dimension(300, 120));
		sifremiunuttum.setPreferredSize(new Dimension(300,120));
		geridonbuton.setPreferredSize(new Dimension(300,120));
		
		
		girisyapbuton.setFocusPainted(false);
		sifremiunuttum.setFocusPainted(false);
		geridonbuton.setFocusPainted(false);
		
		girisyapbuton.setBorderPainted(false);
		sifremiunuttum.setBorderPainted(false);
		geridonbuton.setBorderPainted(false);
		
		girisyapbuton.setBackground(Color.black);
		sifremiunuttum.setBackground(Color.black);
		geridonbuton.setBackground(Color.black);
		
		girisyapbuton.setForeground(Color.yellow);
		sifremiunuttum.setForeground(Color.yellow);
		geridonbuton.setForeground(Color.yellow);
		
		girisyapbuton.setFont(new Font("TimesRoman",Font.PLAIN,35));
		sifremiunuttum.setFont(new Font("TimesRoman",Font.PLAIN,35));
		geridonbuton.setFont(new Font("TimesRoman",Font.PLAIN,35));
		
		
		girisyapbuton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
            	girisyapbuton.setBackground(new Color(35,35,35));
            }

            public void mouseExited(MouseEvent e) {
            	girisyapbuton.setBackground(Color.black);
            }

        });
		
		sifremiunuttum.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
            	sifremiunuttum.setBackground(new Color(35,35,35));
            }

            public void mouseExited(MouseEvent e) {
            	sifremiunuttum.setBackground(Color.black);
            }

        });
		
		
		
		sifremiunuttum.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
                setVisible(false);
              SifremiUnuttumFrame sifremiunuttumframe = new SifremiUnuttumFrame();

          	  
          	  
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
		
		
		geridonbuton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
                setVisible(false);
               GirisEkranıFrame girisekran = new GirisEkranıFrame();

          	  
          	  
             }
        
        
        });
		
		
		
		
		
		
		
		
		//Panel İşlemleri:
		
		topPanel.add(logoLabel);
		tcPanel.add(TC);
		tcPanel.add(tTC);
		sifrePanel.add(sifre);
		sifrePanel.add(tsifre);
		sifreTcPanel.add(tcPanel);
		sifreTcPanel.add(sifrePanel);
		
		bottomPanel.add(girisyapbuton);
		bottomPanel.add(sifremiunuttum);
		bottomPanel.add(geridonbuton);
		
		
		
		topPanel.setBackground(Color.lightGray);
		tcPanel.setBackground(Color.lightGray);
		bottomPanel.setBackground(Color.lightGray);
		sifrePanel.setBackground(Color.lightGray);
		
		
		
		
		//Düzenleme İşlemleri:
		
		this.setLayout(new GridLayout(3,1));
		topPanel.setLayout(new FlowLayout());
		tcPanel.setLayout(new FlowLayout());
		sifrePanel.setLayout(new FlowLayout());
		bottomPanel.setLayout(new FlowLayout());
		sifreTcPanel.setLayout(new GridLayout(1,2));
		
		
		
		
		//Dosya İşlemleri
		

		                
		girisyapbuton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==girisyapbuton) {
                    try(BufferedReader reader = new BufferedReader(new FileReader(dosya))) {

                    String id;
                   	String line;
                   	String[] strArray;
                   	boolean hesapvarmi = false;


                    	while((line = reader.readLine()) != null) {

                    		strArray = line.split(",");

                    	if(strArray[3].equals(tTC.getText().trim()) && strArray[7].equals(new String(tsifre.getPassword()))) {

                    		hesapvarmi = true;
                    		id = strArray[0];

                    		JOptionPane.showMessageDialog(null, "Hesabınıza Başarıyla Giriş Yapıldı...");
                    		reader.close();
                    		setVisible(false);
                    		AnaSayfaFrame anasayfa = new AnaSayfaFrame(id);
                    		break;


                    	}



                    	 }
                    	if(hesapvarmi == false) {
                    		JOptionPane.showMessageDialog(null, "Kullanıcı Adınız Veya Şifreniz Yanlış !");

                    	}









                    }
                   catch(Exception e2) {

                	   JOptionPane.showMessageDialog(null, "Dosyada bir hata var.");

                    }
                    
                   



                }
            }});
		
		
		
		
		
		//Frame İşlemleri:
		
		this.add(topPanel);
		this.add(sifreTcPanel);
		this.add(bottomPanel);
		
		
		this.setSize(1024,768);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Eryetli Hotel Giriş Ekranı");
		this.setIconImage(logo.getImage());
		
		
		
		this.setVisible(true);
		
		this.setLocationRelativeTo(null);
		
		
	}
	
	
	
	
	
	
}
