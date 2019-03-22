package com.example.p1701575.appmeteo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherData {

    private JSONArray weather;
    private double lon, lat, temp, temp_min, temp_max, speed, message;
    private String main, base, description, icon, country, name;
    private int idweather, pressure, humidity, visibility, deg, all, dt, type, idSys, id, sunrise, sunset, cod;

    //Bob le constructeur
    public WeatherData(JSONObject reader) {

        //Parsage du flux
        try {
            //coordonnées
            JSONObject coord = reader.getJSONObject("coord");
            lon = coord.getDouble("lon");
            lat = coord.getDouble("lat");

            //temps
            JSONArray weather = reader.getJSONArray("weather");

            //base
            base = reader.getString("base");

            //main
            JSONObject main = reader.getJSONObject("main");
            temp = main.getDouble("temp");
            pressure = main.getInt("pressure");
            humidity = main.getInt("humidity");
            temp_min = main.getDouble("temp_min");
            temp_max = main.getDouble("temp_max");

            //visibility
            visibility = reader.getInt("visibility");

            //vent
            JSONObject wind = reader.getJSONObject("wind");
            speed = wind.getDouble("speed");
            deg = wind.getInt("deg");

            //nuage
            JSONObject cloud = reader.getJSONObject("cloud");
            all = cloud.getInt("all");

            //dt
            dt = reader.getInt("dt");

            //systeme
            JSONObject sys = reader.getJSONObject("sys");
            type = sys.getInt("type");
            idSys = sys.getInt("id");
            message = sys.getDouble("message");
            country = sys.getString("country");
            sunrise = sys.getInt("sunrise");
            sunset = sys.getInt("sunset");

            //id
            id = reader.getInt("id");

            //name
            name = reader.getString("name");

            //cod
            cod = reader.getInt("cod");


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public JSONArray getWeather() {
        return weather;
    }

    public void setWeather(JSONArray weather) {
        this.weather = weather;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdweather() {
        return idweather;
    }

    public void setIdweather(int idweather) {
        this.idweather = idweather;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIdSys() {
        return idSys;
    }

    public void setIdSys(int idSys) {
        this.idSys = idSys;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
