package starter.wikipedia;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.SingleBrowser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class WhenSearchingForTerms {
    public static void main(String[] args) {

    }

    /**
     * Define the webdriver instance to be used for these tests
     */
    @Managed(driver = "firefox")
    WebDriver driver;

    /**
     * Navigation actions. This is a UIInteraction class so it will be instantiated automatically by Serenity.
     */
    NavigateActions navigate;

    /**
     * Actions related to searches. This is a UIInteraction class so it will be instantiated automatically by Serenity.
     */
    SearchActions search;

    /**
     * A page object representing a Wikipedia article that is currently appearing in the browser.
     * Page Objects are automatically initialised by Serenity.
     */
    DisplayedArticle displayedArticle;

    @Test
    void searchBySingleKeyword() throws InterruptedException {
        navigate.toTheHomePage();
        search.searchBy("Everest");
        Thread.sleep(5000);
        System.out.println(">>>>>>>>>" + displayedArticle.getFirstHeading());
        Serenity.reportThat("The first heading should be 'Mount Everest'",
                () -> assertThat(displayedArticle.getFirstHeading()).isEqualTo("Mount Everest")
        );
    }

    @Test
    void searchBySingleKeyword2() {
        navigate.toTheHomePage();
        search.searchBy("Glory to Ukraine");
        System.out.println(">>>>>>>>>" + displayedArticle.getFirstHeading());
        Serenity.reportThat("The first heading should be 'Slava Ukraini'",
                () -> assertThat(displayedArticle.getFirstHeading()).isEqualTo("Slava Ukraini")
        );
    }
}
