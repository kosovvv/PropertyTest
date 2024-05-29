package uni.pu.fmi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uni.pu.fmi.models.Property;
import uni.pu.fmi.services.BuyPropertyService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class BuyPropertySteps {
    BuyPropertyService buyPropertyService;
    Property property = new Property("Imot 1", "Plovdiv", 0.0d);

    @Given("^потребителя отваря станицата на имота")
    public void потребителя_отваря_станицата_на_имота() throws Throwable {
       String message = "opening...";
    }

    @Given("^натиска върху бутона за купуване на имот")
    public void натиска_върху_бутона_за_купуване_на_имот() throws Throwable {
        buyPropertyService = new BuyPropertyService();
    }

    @Given("^визуализира се форма за купуване на имот")
    public void визуализира_се_форма_за_купуване_на_имот() throws Throwable {
        assertNotNull(buyPropertyService);
    }

    @When("^избере някои от предоставените начини за плащане$")
    public void избере_някои_от_предоставените_начини_за_плащане() throws Throwable {
        buyPropertyService.choosePaymentMethod(true);
    }

    @When("^въведе валиден имеѝл$")
    public void въведе_валиден_имеѝл() throws Throwable {
        buyPropertyService.addEmail("mymail@mail.com");
    }

    @When("^натисне бутона за закуване$")
    public void натисне_бутона_за_закуване() throws Throwable {
        buyPropertyService.checkout(property);
    }

    @Then("^вижда съобщение с текст \"([^\"]*)\"$")
    public void вижда_съобщение_с_текст(String expectedMessage) throws Throwable {
        assertEquals(expectedMessage, buyPropertyService.getMessage());
    }

    @When("^въведе невалиден имеѝл$")
    public void въведе_невалиден_имеѝл() throws Throwable {
        buyPropertyService.addEmail("#%#$WWCCWC");
    }
}
