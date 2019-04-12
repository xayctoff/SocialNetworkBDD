import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.sql.SQLException;

public class LoginTest {

    private Login authorization;
    private String login;
    private String password;
    private boolean signInResult;
    private boolean signUpResult

    @Given("^I have an authorization window$")
    public void iHaveAnAuthorizationWindow() {
        this.authorization = new Login();
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
        try {
            this.signInResult = authorization.signIn(this.login, this.password);
        }

        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Then("^I have to enter my page$")
    public void iHaveToEnterMyPage() {
        Assert.assertTrue(signInResult);
    }

    @And("^I pressed sign up button$")
    public void iPressedSignUpButton() {
        try {
            this.signUpResult = authorization.signUp(this.login, this.password);
        }

        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
