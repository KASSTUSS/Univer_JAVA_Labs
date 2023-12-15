import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.FileWriter;

public class WeatherDataExtractor {
    private String locationName;
    private String localTime;
    private String lastUpdated;
    private double temperatureCelsius;
    private boolean isDay;
    private String condition;
    private double windSpeedKph;
    private String windDirection;
    private double pressureMb;
    private double precipitationMm;
    private int humidity;
    private int cloudiness;
    private double feelsLikeCelsius;
    private double visibilityKm;
    private double uvIndex;
    private double windGustKph;

    public WeatherDataExtractor(String locationName, String localTime, String lastUpdated, double temperatureCelsius,
                                boolean isDay, String condition, double windSpeedKph, String windDirection,
                                double pressureMb, double precipitationMm, int humidity, int cloudiness,
                                double feelsLikeCelsius, double visibilityKm, double uvIndex, double windGustKph) {
        this.locationName = locationName;
        this.localTime = localTime;
        this.lastUpdated = lastUpdated;
        this.temperatureCelsius = temperatureCelsius;
        this.isDay = isDay;
        this.condition = condition;
        this.windSpeedKph = windSpeedKph;
        this.windDirection = windDirection;
        this.pressureMb = pressureMb;
        this.precipitationMm = precipitationMm;
        this.humidity = humidity;
        this.cloudiness = cloudiness;
        this.feelsLikeCelsius = feelsLikeCelsius;
        this.visibilityKm = visibilityKm;
        this.uvIndex = uvIndex;
        this.windGustKph = windGustKph;
    }

    public static void main(String[] args) {
        String url = "https://weatherapi-com.p.rapidapi.com/current.json?q=53.1%2C-0.13";
        String apiKey = "644cb2c86bmshcf0295aa91bba29p162415jsn564cdbc1e930";

        try {
            // Создаем URL-объект и настраиваем подключение
            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-RapidAPI-Key", apiKey);

            // Получаем ответ от API
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Обработка ответа в формате JSON
                String jsonString = response.toString();
                JSONObject jsonObject = new JSONObject(jsonString);

                // Извлечение местоположения
                JSONObject location = jsonObject.getJSONObject("location");
                String locationName = location.getString("name");
                String localTime = location.getString("localtime");

                // Извлечение текущей погоды
                JSONObject currentWeather = jsonObject.getJSONObject("current");
                String lastUpdated = currentWeather.getString("last_updated");
                double temperatureCelsius = currentWeather.getDouble("temp_c");
                boolean isDay = currentWeather.getInt("is_day") == 1;
                String condition = currentWeather.getJSONObject("condition").getString("text");
                double windSpeedKph = currentWeather.getDouble("wind_kph");
                String windDirection = currentWeather.getString("wind_dir");
                double pressureMb = currentWeather.getDouble("pressure_mb");
                double precipitationMm = currentWeather.getDouble("precip_mm");
                int humidity = currentWeather.getInt("humidity");
                int cloudiness = currentWeather.getInt("cloud");
                double feelsLikeCelsius = currentWeather.getDouble("feelslike_c");
                double visibilityKm = currentWeather.getDouble("vis_km");
                double uvIndex = currentWeather.getDouble("uv");
                double windGustKph = currentWeather.getDouble("gust_kph");

                // Вывод извлеченных значений
                System.out.println("Местоположение:");
                System.out.println("- Название: " + locationName);
                System.out.println("- Локальное время: " + localTime);
                System.out.println("Текущая погода:");
                System.out.println("- Последнее обновление: " + lastUpdated);
                System.out.println("- Температура в Цельсиях: " + temperatureCelsius +"°C");
                System.out.println("- Время суток: " + (isDay ? "День" : "Ночь"));
                System.out.println("- Состояние: " + condition);
                System.out.println("- Скорость ветра в километрах в час: " + windSpeedKph + " kph");
                System.out.println("- Направление ветра: " + windDirection);
                System.out.println("- Давление в миллибарах: " + pressureMb + " mb");
                System.out.println("- Количество осадков в миллиметрах: " + precipitationMm + " mm");
                System.out.println("- Влажность: " + humidity + "%");
                System.out.println("- Облачность: " + cloudiness + "%");
                System.out.println("- Ощущается как в Цельсиях: " + feelsLikeCelsius + "°C");
                System.out.println("- Видимость в километрах: " + visibilityKm + " km");
                System.out.println("- Индекс УФ: " + uvIndex);
                System.out.println("- Скорость порывов ветра в километрах в час: " + windGustKph + " kph");

                // Создание виджета погоды
                WeatherDataExtractor weatherDataExtractor = new WeatherDataExtractor(locationName, localTime, lastUpdated,
                        temperatureCelsius, isDay, condition, windSpeedKph, windDirection, pressureMb, precipitationMm,
                        humidity, cloudiness, feelsLikeCelsius, visibilityKm, uvIndex, windGustKph);
                weatherDataExtractor.createWidgetHtml("Погодный виджет.html");
            } else {
                System.out.println("Ошибка при получении ответа от API. Код ошибки: " + responseCode);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при выполнении HTTP-запроса: " + e.getMessage());
        }
    }

    public void createWidgetHtml(String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write("<!DOCTYPE html>");
            writer.write("<html lang=\"ru\">");
            writer.write("<head>");
            writer.write("<meta charset=\"UTF-8\">");
            writer.write("<title>Погодный виджет</title>");
            writer.write("</head>");
            writer.write("<body>");
            writer.write("<h1>Погодный виджет</h1>");
            writer.write("<p>Местоположение: " + locationName + "</p>");
            writer.write("<p>Локальное время: " + localTime + "</p>");
            writer.write("<p>Последнее обновление: " + lastUpdated + "</p>");
            writer.write("<p>Температура в Цельсиях: " + temperatureCelsius + "°C</p>");
            writer.write("<p>Время суток: " + (isDay ? "День" : "Ночь") + "</p>");
            writer.write("<p>Состояние: " + condition + "</p>");
            writer.write("<p>Скорость ветра в километрах в час: " + windSpeedKph + " kph</p>");
            writer.write("<p>Направление ветра: " + windDirection + "</p>");
            writer.write("<p>Давление в миллибарах: " + pressureMb + " mb</p>");
            writer.write("<p>Количество осадков в миллиметрах: " + precipitationMm + " mm</p>");
            writer.write("<p>Влажность: " + humidity + "%</p>");
            writer.write("<p>Облачность: " + cloudiness + "%</p>");
            writer.write("<p>Ощущается как в Цельсиях: " + feelsLikeCelsius + "°C</p>");
            writer.write("<p>Видимость в километрах: " + visibilityKm + " km</p>");
            writer.write("<p>Индекс УФ: " + uvIndex + "</p>");
            writer.write("<p>Скорость порывов ветра в километрах в час: " + windGustKph + " kph</p>");
            writer.write("</body>");
            writer.write("</html>");
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка при создании HTML-файла: " + e.getMessage());
        }
    }
}