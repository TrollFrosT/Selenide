import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

class ChromeTest {



    @Test

    void shouldTest() {

        Configuration.holdBrowserOpen = true;

        open ("http://localhost:9999/");
        $("span[data-test-id=city] input").setValue("Казань");
        $("span[data-test-id=date] input").setValue("19.03.2023");
        $("span[data-test-id=name] input").setValue("Смирнов-Иванов Петр");
        $("span[data-test-id=phone] input").setValue("+79119999999");
        $("label[data-test-id=agreement]").click();
        $x("//span[contains(text(), 'Забронировать')]").click();
        $("div[data-test-id=notification]").shouldBe(Condition.visible, Duration.ofSeconds(15));

    }



}
