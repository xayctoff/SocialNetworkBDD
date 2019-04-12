import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserTest {

    private User user;

    @Given("^I have a user$")
    public void iHaveAUser() {
        this.user = new User();
    }

    @When("^I try to get user's login$")
    public void iTryToGetUserSLogin() {
    }

    @Then("^I should get user's login$")
    public void iShouldGetUserSLogin() {
    }
}
