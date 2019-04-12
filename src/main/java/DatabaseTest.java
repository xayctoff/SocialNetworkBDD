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
    private int updateResult;
    private String insertQuery;
    private String updateQuery;

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
        } catch (SQLException exception) {
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
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Then("^I should get true result$")
    public void iShouldGetTrueResult() {
        Assert.assertTrue(this.checkOnExistUserResult);
    }

    @Given("^I have a query$")
    public void iHaveAQuery() {
        this.insertQuery = "INSERT INTO users values (DEFAULT, 'pravd', 'kola')";
    }

    @When("^I try to insert record in the database$")
    public void iTryToInsertRecordInTheDatabase() {
        Database database = Database.getInstance();

        try {
            this.insertResult = database.insert(insertQuery);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Then("^I should get (\\d+) because I insert one record$")
    public void iShouldGetBecauseIInsertOneRecord(int rowsNumber) {
        Assert.assertEquals(rowsNumber, this.insertResult);
    }

    @When("^I try to update record in the database$")
    public void iTryToUpdateRecordInTheDatabase() {
        this.updateQuery = "UPDATE friends SET status = 2 WHERE first = (SELECT user_id FROM users WHERE login = " +
                "'xayctoff') AND second = (SELECT user_id FROM users WHERE login = 'andre') OR first = (SELECT user_id" +
                " FROM users WHERE login = 'andre') AND second = (SELECT user_id FROM users WHERE login = 'xayctoff')";

        Database database = Database.getInstance();

        try {
            this.updateResult = database.update(updateQuery);
        }

        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Then("^I should get (\\d+) because I update one record$")
    public void iShouldGetBecauseIUpdateOneRecord(int rowsNumber) {
        Assert.assertEquals(rowsNumber, this.updateResult);
    }

    @Given("^I have a login <login>$")
    public void iHaveALoginLogin() {
        
    }

    @When("^I try to get user's id by query$")
    public void iTryToGetUserSIdByQuery() {
        
    }

    @Then("^I should get user's id <user_id>$")
    public void iShouldGetUserSIdUser_id() {
    }
}
