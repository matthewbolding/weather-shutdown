public class WeatherAlert {
    public static void main(String[] args) {
        StationInformation station = StationInformation.getInstance();

        System.out.println(station.LATITUDE);
        System.out.println(station.LONGITUDE);

        NationWeatherService nws = new NationWeatherService(station);
    }
}
