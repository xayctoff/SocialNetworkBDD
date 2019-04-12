import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class UserTest {

    private User user;
    private String login;
    private String password;

    @Given("^I have a user$")
    public void iHaveAUser() {
        this.user = new User();
    }

    @When("^I try to get user's login$")
    public void iTryToGetUserSLogin() {
        this.user.setLogin("xayctoff");
        this.login = user.getLogin();
    }

    @Then("^I should get user's login$")
    public void iShouldGetUserSLogin() {
        Assert.assertNotNull(this.login);
    }

    @When("^I try to get user's password$")
    public void iTryToGetUserSPassword() {
        
    }

    @Then("^I should get user's password$")
    public void iShouldGetUserSPassword() {
    }
}
