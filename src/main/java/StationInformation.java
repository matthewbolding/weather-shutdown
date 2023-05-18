import java.io.FileInputStream;
import java.util.Properties;

public class StationInformation {
    public final double LATITUDE, LONGITUDE;

    private StationInformation(double latitude, double longitude) {
        this.LATITUDE = latitude;
        this.LONGITUDE = longitude;
    }

    private static class StationInformationHolder {
        private static double latitude, longitude;

        static {
            try {
                FileInputStream fis = new FileInputStream("station.config");
                Properties p = new Properties ();
                p.load(fis);

                latitude = Double.parseDouble(p.getProperty("latitude"));
                longitude = Double.parseDouble(p.getProperty("longitude"));

                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        private final static StationInformation INSTANCE = new StationInformation(latitude, longitude);
    }

    public static StationInformation getInstance() {
        return StationInformationHolder.INSTANCE;
    }
}
