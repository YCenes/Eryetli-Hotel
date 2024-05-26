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
import java.io.File;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SifremiUnuttumFrame extends JFrame {

	
	private File dosya1;
	
	private ImageIcon logo = new ImageIcon("Eryetli.png");
	
	private JButton sifrekurtarButon;
	private JButton geridonButon;
	
	private JPanel topPanel;
	private JPanel MainMiddlePanel;
	private JPanel middlePanel1;
	private JPanel middlePanel2;
	private JPanel bottomPanel;
	
	private JTextField tID;
	private JTextField tTC;	
	
	private JLabel topLabel;
	private JLabel IDLabel;
	private JLabel TCLabel;
	
	
	public SifremiUnuttumFrame() {
		
		//Nesne Oluşturma	
		
		dosya1 = new File("Bilgiler.txt");
		
		sifrekurtarButon = new JButton("Şifremi Kurtar");
		geridonButon = new JButton("Geri Dön");
		
		topPanel = new JPanel();
		MainMiddlePanel = new JPanel();
		middlePanel1 = new JPanel();
		middlePanel2 = new JPanel();
		bottomPanel = new JPanel();
		
		tID = new JTextField();
		tTC = new JTextField();
		
		
		topLabel = new JLabel("Şifrenizi Öğrenmek İçin Aşağıda ki Kutucukları Doldurun");
		IDLabel = new JLabel("ID Numaranız:");
		TCLabel = new JLabel("TC Numaranız:");
		
		
		
		// Buton İşlemleri
		
		sifrekurtarButon.setFont(new Font("TimesRoman",Font.PLAIN,30));
		geridonButon.setFont(new Font("TimesRoman",Font.PLAIN,30));
		sifrekurtarButon.setPreferredSize(new Dimension(300, 150));
		geridonButon.setPreferredSize(new Dimension(300,150));
		sifrekurtarButon.setFocusPainted(false);
		geridonButon.setFocusPainted(false);
		sifrekurtarButon.setBorderPainted(false);
		geridonButon.setBorderPainted(false);
		sifrekurtarButon.setBackground(Color.black);
		geridonButon.setBackground(Color.black);
		sifrekurtarButon.setForeground(Color.yellow);
		geridonButon.setForeground(Color.yellow);
		
		sifrekurtarButon.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                sifrekurtarButon.setBackground(new Color(35,35,35));
            }

            public void mouseExited(MouseEvent e) {
                sifrekurtarButon.setBackground(Color.black);
            }

        });
		geridonButon.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                geridonButon.setBackground(new Color(35,35,35));
            }

            public void mouseExited(MouseEvent e) {
                geridonButon.setBackground(Color.black);
            }

        });
		
		
		
		
		
		geridonButon.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
                setVisible(false);
               GirisYapFrame girisyap = new GirisYapFrame();

          	  
          	  
             }
        
        
        });
		
		
		
		//Label İşlemleri
		
		IDLabel.setFont(new Font("TimesRoman",Font.PLAIN,25));
		TCLabel.setFont(new Font("TimesRoman",Font.PLAIN,25));
		topLabel.setFont(new Font("TimesRoman",Font.PLAIN,40));
		
		
		
		
		
		//TextField İşlemleri
		
		tID.setPreferredSize(new Dimension(170,50));
		tTC.setPreferredSize(new Dimension(170,50));
		
		tID.setFont(new Font("TimesRoman",Font.PLAIN,25));
		tTC.setFont(new Font("TimesRoman",Font.PLAIN,25));
		
		
		
		//Panel İşlemleri:
		
		topPanel.add(topLabel);
		
		middlePanel1.add(IDLabel);
		middlePanel1.add(tID);
		middlePanel2.add(TCLabel);
		middlePanel2.add(tTC);
		
		topPanel.setPreferredSize(new Dimension(600,300));
		
		MainMiddlePanel.add(middlePanel1);
		MainMiddlePanel.add(middlePanel2);
		
		bottomPanel.add(sifrekurtarButon);
		bottomPanel.add(geridonButon);
		
		MainMiddlePanel.setLayout(new GridLayout(1,2));
	
		
		
		
		//Şifre Kurtarma
		
		
		
		
		
		sifrekurtarButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	

                if (e.getSource() == sifrekurtarButon) {
                	
                	

                    try (BufferedReader reader = new BufferedReader(new FileReader(dosya1))) {
                    	
                        String line;
                        String[] strArray;
                        boolean hesapVarMi = false;

                        while ((line = reader.readLine()) != null) {
                            strArray = line.split(",");

                            if (strArray[3].equals(tTC.getText()) && strArray[0].equals(tID.getText())) {
                                JOptionPane.showMessageDialog(null, "Şifreniz: " + strArray[7]);
                                hesapVarMi = true;
                                break;
                            }
                        }

                        if (!hesapVarMi) {
                            JOptionPane.showMessageDialog(null, "Hesabınız bulunamadı.");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Dosya okuma hatası oluştu.");
                    }
                }
            }
        });
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Frame İşlemleri
		
		this.setLayout(new BorderLayout());
		this.add(topPanel,BorderLayout.NORTH);
		this.add(MainMiddlePanel,BorderLayout.CENTER);
		this.add(bottomPanel,BorderLayout.SOUTH);
		
		this.setSize(1024,768);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Şifre Kurtarma Ekranı");
		this.setIconImage(logo.getImage());
		
		
		
		this.setVisible(true);
		
		
		this.setLocationRelativeTo(null);
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
