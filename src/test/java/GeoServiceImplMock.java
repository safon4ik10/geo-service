import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplMock {

    @Test
    @DisplayName("Проверка RU GeoServiceImpl")
    public void testByIpRU() {
        GeoService geoService = new GeoServiceImpl();
        String ip = "172.16.16.16";

        Location location = geoService.byIp(ip);
        Assertions.assertNotNull(location);

        Location actualLocation = new Location("Moscow", Country.RUSSIA, "Ilicha", 0);
        Assertions.assertNotNull(actualLocation);
        Assertions.assertEquals(actualLocation.getCountry(), location.getCountry());
    }

    @Test
    @DisplayName("Проверка USA GeoServiceImpl")
    public void testByIpUSA() {
        GeoService geoService = new GeoServiceImpl();
        String ip = "96.16.12.11";

        Location location = geoService.byIp(ip);
        Assertions.assertNotNull(location);

        Location actualLocation = new Location("New York", Country.USA, " 10th Avenue", 32);
        Assertions.assertNotNull(actualLocation);
        Assertions.assertEquals(actualLocation.getCountry(), location.getCountry());
    }
}
