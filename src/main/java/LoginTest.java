import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest {

    private Login signIn;
    private String login;
    private String password;
    private boolean signInResult;

    @Given("^I have an authorization window$")
    public void iHaveAnAuthorizationWindow() {
        this.signIn = new Login();
    }


    @When("^I entered the user login$")
    public void iEnteredTheUserLogin() {
        this.login = "xayctoff";
    }

    @And("^I entered the user password$")
    public void iEnteredTheUserPassword() {
        this.password = "111";
    }

    @And("^I pressed sign in button$")
    public void iPressedSignInButton() {
        this.signInResult = signIn.signIn(this.signIn, this.password);
    }

    @Then("^I have to enter my page$")
    public void iHaveToEnterMyPage() {
    }
}
