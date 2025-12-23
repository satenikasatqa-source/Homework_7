package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class MeknarkTests {

    @BeforeEach
    void openHomePage() {
        open("https://meknark.am/home");
    }

    @ParameterizedTest
    @Tag("Smoke")
    @DisplayName("Page content changes when language is switched")
    @EnumSource(Language.class)
    void languageSwitchShouldChangePageText(Language language) {


        $("div.lang-dropdown").shouldBe(visible).click();
        $("div.lang-dropdown__content")
                .shouldBe(visible)
                .$$("p")
                .findBy(exactText(language.getDropdownText()))
                .click();
        $("body").shouldHave(text(language.getExpectedTitle()));
    }

    @ParameterizedTest
    @Tag("Smoke")
    @Tag("Blocker")
    @DisplayName("Main action buttons are visible and clickable")
    @ValueSource(strings = {
            "Learn",
            "donor"
    })
    void mainActionButtonsShouldBeClickable(String buttonText) {

        $$("a, button")
                .findBy(text(buttonText))
                .shouldBe(visible)
                .shouldBe(enabled);
    }

    static Stream<String> serviceTitles() {
        return Stream.of(
                "Let us manage YouTube",
                "Project and event management",
                "Translations",
                "Creating and editing of videos",
                "Other"
        );
    }
    @DisplayName("Service cards are displayed on home page")
    @ParameterizedTest
    @MethodSource("serviceTitles")
    void serviceCardsShouldBeVisible(String serviceTitle) {

        $$("div")
                .findBy(text(serviceTitle))
                .shouldBe(visible);
    }

}
