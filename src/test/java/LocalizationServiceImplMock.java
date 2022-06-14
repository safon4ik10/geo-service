import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImplMock {

    @Test
    @DisplayName("Проверка USA LocalizationServiceImpl")
    public void testUSALocale() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String country = localizationService.locale(Country.USA);
        Assertions.assertNotNull(country);

        String actualText = "Welcome";
        Assertions.assertEquals(country, actualText);
    }

    @Test
    @DisplayName("Проверка RU LocalizationServiceImpl")
    public void testRULocale() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String country = localizationService.locale(Country.RUSSIA);
        Assertions.assertNotNull(country);

        String actualText = "Добро пожаловать";
        Assertions.assertEquals(country, actualText);
    }
}
