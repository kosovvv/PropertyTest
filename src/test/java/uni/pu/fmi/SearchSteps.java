package uni.pu.fmi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uni.pu.fmi.services.SearchService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SearchSteps {

    SearchService searchBox;
    String actualMessage;
    @Given("^потребителя отваря началната страница$")
    public void потребителя_отваря_началната_страница() throws Throwable {
        String message = "opening...";
    }

    @Given("^натиска върху бутона за търсене в системата$")
    public void натиска_върху_бутона_за_търсене_в_системата() throws Throwable {
        searchBox = new SearchService();
    }

    @Given("^визуализира се форма за търсене в системата$")
    public void визуализира_се_форма_за_търсене_в_системата() throws Throwable {
       assertNotNull(searchBox);
    }

    @When("^въведе валидни входни данни за търсене$")
    public void въведе_валидни_входни_данни_за_търсене() throws Throwable {
       searchBox.addToInputBox("Imot 1");
    }

    @When("^натисне бутона за търсене$")
    public void натисне_бутона_за_търсене() throws Throwable {
        searchBox.clickSearchButton();
    }

    @Then("^вижда съобщение \"([^\"]*)\"$")
    public void вижда_съобщение(String expectedMessage) throws Throwable {
        assertEquals(expectedMessage, searchBox.getMessage());
    }

    @When("^въведе невалидни входни данни за търсене$")
    public void въведе_невалидни_входни_данни_за_търсене() throws Throwable {
       searchBox.addToInputBox("#$#$#%$$$");
    }
    @When("^въведе част от валидното име на имота")
    public void въведе_част_от_валидното_име_на_имота() throws Throwable {
        searchBox.addToInputBox("Im");
    }

    @When("^въведе валидно име на имота, който не съществува$")
    public void въведе_валидно_име_на_имот_който_не_съществува() throws Throwable {
        searchBox.addToInputBox("NonExistingProperty");
    }

    @When("^въведе име на имота, което е над 30 символа$")
    public void въведе_име_на_имота_което_е_над_30_символа() throws Throwable {
        searchBox.addToInputBox("ThisPropertyNameIsTooLongAndExceedsThirtyCharacters");
    }

}
