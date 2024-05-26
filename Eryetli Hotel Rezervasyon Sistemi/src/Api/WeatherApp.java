package Api;






import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class WeatherApp implements IWeatherApp {



        private static double windspeed;




        // getWeatherData metodu, belirli bir konum için hava durumu verilerini almak için kullanılır. Bu metot, verilen konum adını kullanarak konumun koordinatlarını alır, ardından bu koordinatları kullanarak hava durumu API'sine bir istek yapar.
        public static JSONObject getWeatherData(String locationName){

            JSONArray locationData = getLocationData(locationName);
            //getLocationData metodu, bir konum adından coğrafi koordinatları almak için kullanılır. Bu metod, belirtilen konum adını kullanarak coğrafi koordinatları almak için bir coğrafi kodlama API'sine bir istek yapar.


            JSONObject location = (JSONObject) locationData.get(0);
            double latitude = (double) location.get("latitude");
            double longitude = (double) location.get("longitude");


            String urlString = "https://api.open-meteo.com/v1/forecast?" +
                    "latitude=" + latitude + "&longitude=" + longitude +
                    "&hourly=temperature_2m,relativehumidity_2m,weathercode,windspeed_10m&timezone=America%2FLos_Angeles";

            try{
                // fetchApiResponse metodu, belirli bir URL'ye bir HTTP isteği yapmak için kullanılır.
                HttpURLConnection conn = fetchApiResponse(urlString);


                // apiye ulaşılıp ulaşılmadığını kontrol ediyor
                if(conn.getResponseCode() != 200){
                    System.out.println("Error: Could not connect to API");
                    return null;
                }

                // store resulting json data
                StringBuilder resultJson = new StringBuilder();
                Scanner scanner = new Scanner(conn.getInputStream());
                while(scanner.hasNext()){
                    // read and store into the string builder
                    resultJson.append(scanner.nextLine());
                }

                // close scanner
                scanner.close();

                // close url connection
                conn.disconnect();

                // parse through our data
                JSONParser parser = new JSONParser();
                JSONObject resultJsonObj = (JSONObject) parser.parse(String.valueOf(resultJson));

                // retrieve hourly data
                JSONObject hourly = (JSONObject) resultJsonObj.get("hourly");

                //findIndexOfCurrentTime metodu, mevcut saatin API'den gelen saat listesindeki indeksini bulur.
                JSONArray time = (JSONArray) hourly.get("time");
                int index = findIndexOfCurrentTime(time);

                // get temperature
                JSONArray temperatureData = (JSONArray) hourly.get("temperature_2m");
                double temperature = (double) temperatureData.get(index);

                // get weather code
                JSONArray weathercode = (JSONArray) hourly.get("weathercode");
                String weatherCondition = convertWeatherCode((long) weathercode.get(index));

                // get humidity
                JSONArray relativeHumidity = (JSONArray) hourly.get("relativehumidity_2m");
                long humidity = (long) relativeHumidity.get(index);

                // get windspeed
                JSONArray windspeedData = (JSONArray) hourly.get("windspeed_10m");
                windspeed = (double) windspeedData.get(index);

                // build the weather json data object that we are going to access in our frontend
                JSONObject weatherData = new JSONObject();
                weatherData.put("temperature", temperature);
                weatherData.put("weather_condition", weatherCondition);
                weatherData.put("humidity", humidity);
                weatherData.put("windspeed", windspeed);

                return weatherData;
            }catch(Exception e){
                e.printStackTrace();
            }

            return null;
        }

        // retrieves geographic coordinates for given location name
        public static JSONArray getLocationData(String locationName){
            // replace any whitespace in location name to + to adhere to API's request format
            locationName = locationName.replaceAll(" ", "+");

            // build API url with location parameter
            String urlString = "https://geocoding-api.open-meteo.com/v1/search?name=" +
                    locationName + "&count=10&language=en&format=json";

            try{
                // call api and get a response
                HttpURLConnection conn = fetchApiResponse(urlString);

                // check response status
                // 200 means successful connection
                if(conn.getResponseCode() != 200){
                    System.out.println("Error: Could not connect to API");
                    return null;
                }else{
                    // store the API results
                    StringBuilder resultJson = new StringBuilder();
                    Scanner scanner = new Scanner(conn.getInputStream());

                    // read and store the resulting json data into our string builder
                    while(scanner.hasNext()){
                        resultJson.append(scanner.nextLine());
                    }

                    // close scanner
                    scanner.close();

                    // close url connection
                    conn.disconnect();

                    // parse the JSON string into a JSON obj
                    JSONParser parser = new JSONParser();
                    JSONObject resultsJsonObj = (JSONObject) parser.parse(String.valueOf(resultJson));

                    // get the list of location data the API gtenerated from the lcoation name
                    JSONArray locationData = (JSONArray) resultsJsonObj.get("results");
                    return locationData;
                }

            }catch(Exception e){
                e.printStackTrace();
            }

            // couldn't find location
            return null;
        }

        private static HttpURLConnection fetchApiResponse(String urlString){
            try{
                // attempt to create connection
                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                // set request method to get
                conn.setRequestMethod("GET");

                // connect to our API
                conn.connect();
                return conn;
            }catch(IOException e){
                e.printStackTrace();
            }

            // could not make connection
            return null;
        }

        private static int findIndexOfCurrentTime(JSONArray timeList){
            //getCurrentTime metodu, geçerli tarihi ve saati biçimlendirir ve API'ye uygun bir şekilde döndürür.
            String currentTime = getCurrentTime();

            // iterate through the time list and see which one matches our current time
            for(int i = 0; i < timeList.size(); i++){
                String time = (String) timeList.get(i);
                if(time.equalsIgnoreCase(currentTime)){
                    // return the index
                    return i;
                }
            }

            return 0;
        }

        private static String getCurrentTime(){
            // get current date and time
            LocalDateTime currentDateTime = LocalDateTime.now();

            // format date to be 2023-09-02T00:00 (this is how is is read in the API)
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH':00'");

            // format and print the current date and time
            String formattedDateTime = currentDateTime.format(formatter);

            return formattedDateTime;
        }

        // convertWeatherCode metodu, hava durumu kodunu daha okunabilir bir formata dönüştürür.
        private static String convertWeatherCode(long weathercode){
            String weatherCondition = "";
            if(weathercode == 0L){
                // clear
                weatherCondition = "Clear";
            }else if(weathercode > 0L && weathercode <= 3L){
                // cloudy
                weatherCondition = "Cloudy";
            }else if((weathercode >= 51L && weathercode <= 67L)
                    || (weathercode >= 80L && weathercode <= 99L)){
                // rain
                weatherCondition = "Rain";

            }else if(weathercode >= 71L && weathercode <= 77L){
                // snow
                weatherCondition = "Snow";
            }

            return weatherCondition;
        }






    }




