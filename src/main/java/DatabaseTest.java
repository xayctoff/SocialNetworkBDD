import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.sql.SQLException;

public class DatabaseTest {

    private Database database;
    private Database anotherDatabase;
    private String login;
    private String password;
    private boolean checkOnValidAuthorizationResult;
    private boolean checkOnExistUserResult;

    @Given("^I haven't connection to the database$")
    public void iHavenTConnectionToTheDatabase() {
        this.database = null;
    }

    @When("^I try to connect to the database$")
    public void iTryToConnectToTheDatabase() {
        this.database = Database.getInstance();
    }

    @Then("^I should connect to the database$")
    public void iShouldConnectToTheDatabase() {
        Assert.assertNotNull(this.database);
    }

    @Given("^I have connection to the database$")
    public void iHaveConnectionToTheDatabase() {
        this.anotherDatabase = Database.getInstance();
    }

    @Then("^I should get current connection$")
    public void iShouldGetCurrentConnection() {
        Assert.assertEquals(this.database, this.anotherDatabase);
    }

    @Given("^I have a login$")
    public void iHaveALogin() {
        this.login = "xayctoff";
    }

    @Given("^I have a password$")
    public void iHaveAPassword() {
        this.password = "111";
    }

    @When("^I try to check valid authorization$")
    public void iTryToCheckValidAuthorization() {
        try {
            this.checkOnValidAuthorizationResult = database.checkOnValidAuthorization(this.login, this.password);
        }

        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Then("^I should to pass validation$")
    public void iShouldToPassValidation() {
        Assert.assertTrue(this.checkOnValidAuthorizationResult);
    }

    @When("^I try to check user existence$")
    public void iTryToCheckUserExistence() {
        try {
            this.checkOnExistUserResult = database.checkOnExistUser(this.login);
        }

        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Then("^I should get true result$")
    public void iShouldGetTrueResult() {
        Assert.assertTrue(this.checkOnExistUserResult);
    }
}
