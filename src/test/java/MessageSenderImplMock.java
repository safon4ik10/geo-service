
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;


public class MessageSenderImplMock {

    @Test
    @DisplayName("Тестирование RU ip")
    void test_message_sender_ru() {

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn(Country.RUSSIA.name());

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("172.0.32.11"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 1));

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> map = new HashMap<String, String>();
        map.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");

        String preferences = messageSender.send(map);
        String expected = Country.RUSSIA.name();

        Assertions.assertEquals(preferences, expected);
    }

    @Test
    @DisplayName("Тестирование USA ip")
    void test_message_sender_other() {

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn(Country.USA.name());

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("96.12.12.12"))
                .thenReturn(new Location("New-York", Country.USA, "ABC", 123));

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> map = new HashMap<String, String>();
        map.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.12.12.12");

        String preferences = messageSender.send(map);
        String expected = Country.USA.name();

        Assertions.assertEquals(preferences, expected);
    }
}
