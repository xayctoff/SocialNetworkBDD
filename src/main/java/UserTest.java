import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.sql.SQLException;

public class UserTest {

    private User user;
    private String login;
    private String password;
    private String server;
    private String receiver;
    private boolean addFriendResult;

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
        Assert.assertNotNull(this.password);
    }

    @Given("^I have a server$")
    public void iHaveAServer() {
        this.server = "egor228";
    }

    @Given("^I have a receiver$")
    public void iHaveAReceiver() {
        this.receiver = "kobzev";
    }

    @When("^Server try to send friendship request to receiver$")
    public void serverTryToSendFriendshipRequestToReceiver() {
        this.user.addFriend(this.server, this.receiver);
    }

    @And("^I try to check successful bid request$")
    public void iTryToCheckSuccessfulBidRequest() {
        try {
            this.addFriendResult = Database.getInstance().checkOnRequest(this.server, this.receiver);
        }

        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Then("^I should get true <result>$")
    public void iShouldGetTrueResult(boolean result) {
        Assert.assertTrue(result);
    }
}
