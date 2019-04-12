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
    private int insertResult;
    private String query;

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
        this.database = Database.getInstance();

        try {
            this.checkOnValidAuthorizationResult = this.database.checkOnValidAuthorization(this.login, this.password);
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
        this.database = Database.getInstance();

        try {
            this.checkOnExistUserResult = this.database.checkOnExistUser(this.login);
        }

        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Then("^I should get true result$")
    public void iShouldGetTrueResult() {
        Assert.assertTrue(this.checkOnExistUserResult);
    }

    @Given("^I have a query$")
    public void iHaveAQuery() {
        this.query = "INSERT INTO users values (DEFAULT, 'pravd', 'kola')";
    }

    @When("^I try to insert record in the database$")
    public void iTryToInsertRecordInTheDatabase() {
        Database database = Database.getInstance();

        try {
            this.insertResult = database.insert(query);
        }

        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Then("^I should get (\\d+) because I insert one record$")
    public void iShouldGetBecauseIInsertOneRecord(int rowsNumber) {
        Assert.assertEquals(rowsNumber, this.insertResult);
    }
}
