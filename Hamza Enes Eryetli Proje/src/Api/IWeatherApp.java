package Api;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.net.HttpURLConnection;

public interface IWeatherApp {


    public static JSONObject getWeatherData(String locationName) {
        return null;
    }

    public static JSONArray getLocationData(String locationName) {
        return null;
    }

    private static HttpURLConnection fetchApiResponse(String urlString){
        HttpURLConnection con = null;
        return con;
    }
    private static int findIndexOfCurrentTime(JSONArray timeList){

        return 0;
    }

    private static String getCurrentTime(){
        return null;
    }
    private static String convertWeatherCode(long weathercode){
        return null;
    }


}
