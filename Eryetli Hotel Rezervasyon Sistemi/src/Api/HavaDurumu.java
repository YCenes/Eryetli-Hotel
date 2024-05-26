package Api;
import AnaSayfa.AnaSayfaFrame;
import GirisEkrani.GirisEkranıFrame;
import  org.json.simple.JSONObject;

import org.json.simple.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;




public class HavaDurumu extends JFrame {
    private JSONObject weatherData;


    public HavaDurumu(String id) {


        // setup our gui and add a title
        super("Weather App");
        this.setBackground(new Color(255, 250, 250));
        this.setTitle("Eryetli Hotel / HavaDurumu");
        ImageIcon logo = new ImageIcon("eryetlis.png");
        this.setIconImage(logo.getImage());

        // configure gui to end the program's process once it has been closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // set the size of our gui (in pixels)
        setSize(1024, 768);

        // load our gui at the center of the screen
        setLocationRelativeTo(null);

        // make our layout manager null to manually position our components within the gui
        setLayout(null);

        // prevent any resize of our gui
        setResizable(false);

        this.getContentPane().setBackground(Color.lightGray);
        addGuiComponents(id);
        setVisible(true);
    }

    private void addGuiComponents(String id) {





        // weather image
        JLabel weatherConditionImage = new JLabel(loadImage("cloudys.png"));
        weatherConditionImage.setBounds(280, 125, 450, 217);
        add(weatherConditionImage);

        // temperature text
        JLabel temperatureText = new JLabel("10 C");
        temperatureText.setBounds(280, 310, 450, 54);
        temperatureText.setFont(new Font("Dialog", Font.BOLD, 30));
        JLabel labelsehir = new JLabel("(İstanbul Hava Durumu)");
        labelsehir.setBounds(400, 380, 350, 54);
        labelsehir.setFont(new Font("Dialog", Font.PLAIN, 20));

        // center the text
        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);
        add(temperatureText);
        add(labelsehir);


        // search button
        JButton geriButton  = new JButton("Geri Dön");
        geriButton.setFont(new Font("TimesRoman",Font.BOLD,20));
        geriButton.setFocusPainted(false);
        geriButton.setBackground(Color.black);
        geriButton.setBorderPainted(false);
        geriButton.setPreferredSize(new Dimension(250,130));
        geriButton.setForeground(Color.yellow);
        geriButton.setBounds(410, 550, 200, 65);
        geriButton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {

                geriButton.setBackground(new Color(35,35,35));
            }

            public void mouseExited(MouseEvent e) {
                geriButton.setBackground(Color.black);
            }

        });
        geriButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                AnaSayfaFrame anasayfa = new AnaSayfaFrame(id);



            }


        });



        add(geriButton);


        // change the cursor to a hand cursor when hovering over this button



                // get location from user
                String userInput = "istanbul";

                // validate input - remove whitespace to ensure non-empty text
                if (userInput.replaceAll("\\s", "").length() <= 0) {
                    return;
                }

                // retrieve weather data
                weatherData = WeatherApp.getWeatherData(userInput);

                // update gui

                // update weather image
                String weatherCondition = (String) weatherData.get("weather_condition");

                // depending on the condition, we will update the weather image that corresponds with the condition
                switch (weatherCondition) {
                    case "Clear":
                        weatherConditionImage.setIcon(loadImage("clear.png"));
                        break;
                    case "Cloudy":
                        weatherConditionImage.setIcon(loadImage("cloudy.png"));
                        break;
                    case "Rain":
                        weatherConditionImage.setIcon(loadImage("rain.png"));
                        break;
                    case "Snow":
                        weatherConditionImage.setIcon(loadImage("snow.pngImage"));
                        break;
                }

                // update temperature text
                double temperature = (double) weatherData.get("temperature");
                temperatureText.setText(temperature + " C");


        ;

    }

    // used to create images in our gui components
    private ImageIcon loadImage(String resourcePath) {
        try {
            // read the image file from the path given
            BufferedImage image = ImageIO.read(new File(resourcePath));

            // returns an image icon so that our component can render it
            return new ImageIcon(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Could not find resource");
        return null;
    }
}