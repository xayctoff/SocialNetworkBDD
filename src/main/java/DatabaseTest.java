import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class DatabaseTest {

    private Database database;

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
}
