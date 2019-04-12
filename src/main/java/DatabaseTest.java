import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class DatabaseTest {

    private Database database;
    private Database anotherDatabase;
    private String login;
    private String password;

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
        Assert.assertEquals(database, anotherDatabase);
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
        
    }

    @Then("^I should to pass validation$")
    public void iShouldToPassValidation() {
    }
}
