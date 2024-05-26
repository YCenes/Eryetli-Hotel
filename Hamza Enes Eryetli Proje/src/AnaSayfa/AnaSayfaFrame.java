package AnaSayfa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Api.HavaDurumu;
import Api.WeatherApp;
import GirisEkrani.GirisEkranıFrame;
import Rezervasyonlar.RezervasyonlarımFrame;
import Rezervasyonlar.YeniRezervasyon;
import org.json.simple.JSONObject;


public class AnaSayfaFrame extends JFrame {
	private JSONObject weatherData;

	private ImageIcon logo = new ImageIcon("Eryetli.png");
	private ImageIcon anasayfalogo = new ImageIcon("gotelsss.png");

	private String id;

	private JMenuBar menuBar;

	private JMenu rezervasyonlarımBar;
	private JMenu yenirezervasyonlarBar;
	private JMenu odatipleriBar;
	private JMenu hesapBar;
	private JMenu HavaDurumu;

	private JMenuItem HavaDurumuItem;
	private JMenuItem rezervasyonlarımItem;
	private JMenuItem yenirezervasyonItem;
	private JMenuItem oteliçeriğiItem;
	private JMenuItem odatipleriItem;
	private JMenuItem hesaptancikisItem;


	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel bottomPanel;


	private JLabel anasayfahg;
	private JLabel anasayfalogoLabel;






	public AnaSayfaFrame(String id) {

		this.id = id;
		//Nesne Oluşturma

		menuBar = new JMenuBar();

		rezervasyonlarımBar = new JMenu("Rezervasyonlarım");
		yenirezervasyonlarBar = new JMenu("Yeni Rezervasyon");
		odatipleriBar = new JMenu("Oda Tipleri");
		HavaDurumu = new JMenu("Hava Durumu");
		hesapBar = new JMenu("Hesabım");

		rezervasyonlarımItem = new JMenuItem("Rezervasyonlarımı İncele");
		yenirezervasyonItem = new JMenuItem("Rezervasyon Oluştur");
		oteliçeriğiItem = new JMenuItem("Otel İçeriğini İncele");
		odatipleriItem = new JMenuItem("Oda Tiplerini İncele");
		HavaDurumuItem = new JMenuItem("Hava Durumunu Gör");
		hesaptancikisItem = new JMenuItem("Hesaptan Çıkış Yap");


		topPanel = new JPanel();
		middlePanel = new JPanel();
		bottomPanel = new JPanel();


		anasayfahg = new JLabel("Lütfen Yapacağınız İşlemi Seçiniz");
		anasayfalogoLabel = new JLabel();




		//MenuBar İşlemleri

		rezervasyonlarımBar.add(rezervasyonlarımItem);
		yenirezervasyonlarBar.add(yenirezervasyonItem);
		odatipleriBar.add(odatipleriItem);
		HavaDurumu.add(HavaDurumuItem);
		hesapBar.add(hesaptancikisItem);

		menuBar.add(rezervasyonlarımBar);
		menuBar.add(yenirezervasyonlarBar);
		menuBar.add(odatipleriBar);
		menuBar.add(HavaDurumu);
		menuBar.add(hesapBar);

		menuBar.setBackground(Color.lightGray);


		menuBar.setPreferredSize(new Dimension(200,80));


		rezervasyonlarımItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                   if(e.getSource()==rezervasyonlarımItem) {

                	   setVisible(false);

                	   RezervasyonlarımFrame rezos = new RezervasyonlarımFrame(id);
                   }
            }
            });
		HavaDurumuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==HavaDurumuItem) {

					setVisible(false);
					HavaDurumu hava = new HavaDurumu(id);
				}
			}
		});
		yenirezervasyonItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                   if(e.getSource()==yenirezervasyonItem) {

                	   setVisible(false);

                	   YeniRezervasyon yenirezo = new YeniRezervasyon(id);
                   }
            }
            });
		oteliçeriğiItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                   if(e.getSource()==oteliçeriğiItem) {

                   }
            }
            });
		odatipleriItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                   if(e.getSource()==odatipleriItem) {

                	   setVisible(false);

                	   OdaTipleriFrame odaTipleri = new OdaTipleriFrame(id);

                   }
            }
            });

		hesaptancikisItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                   if(e.getSource()==hesaptancikisItem) {


                	   setVisible(false);

                	   GirisEkranıFrame girisekran = new GirisEkranıFrame();
                   }
            }
            });



		//Label İşlemleri

		anasayfahg.setFont(new Font("TimesRoman",Font.ITALIC,50));
		anasayfahg.setForeground(Color.yellow);

		anasayfalogoLabel.setIcon(anasayfalogo);



		//Panel İşlemleri


		middlePanel.setBackground(Color.LIGHT_GRAY);
		middlePanel.add(anasayfahg);

		bottomPanel.add(anasayfalogoLabel);
		bottomPanel.setBackground(Color.lightGray);



		//HAVA DURUMU
		// weather image


		//Düzenleme İşlemleri

		this.setLayout(new BorderLayout());











		//Frame Özellikleri:
		this.add(menuBar,BorderLayout.NORTH);

		this.add(middlePanel,BorderLayout.CENTER);
		this.add(bottomPanel,BorderLayout.SOUTH);


		this.setSize(1024,768);
		this.setIconImage(logo.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Eryetli Otel Anasayfası");



		this.setVisible(true);
		this.setBackground(Color.lightGray);
		this.setLocationRelativeTo(null);

	}



}
