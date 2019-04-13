import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class UserTest {

    private User user;
    private String login;
    private String password;
    private String server;
    private String receiver;
    private boolean addFriendResult;
    private boolean confirmFriendshipResult;
    private String message;

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
        this.user = new User();

        try {
            this.user.addFriend(this.server, this.receiver);
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @And("^I try to check users on request$")
    public void iTryToCheckUsersOnRequest() {
        try {
            this.addFriendResult = Database.getInstance().checkOnRequest(this.server, this.receiver);
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Then("^I should get true result after request$")
    public void iShouldGetTrueResultAfterRequest() {
        Assert.assertTrue(this.addFriendResult);
    }

    @When("^Receiver try to confirm friendship request from server$")
    public void receiverTryToConfirmFriendshipRequestFromServer() {
        this.user = new User();
        this.user.confirmFriendship(this.server, this.receiver);
    }

    @And("^I try to check users on friendship$")
    public void iTryToCheckUsersOnFriendship() {
        try {
            this.confirmFriendshipResult = Database.getInstance().checkOnFriendship(this.server, this.receiver);
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Then("^I should get true result after confirm$")
    public void iShouldGetTrueResultAfterConfirm() {
        Assert.assertTrue(this.confirmFriendshipResult);
    }

    @Given("^I have a message$")
    public void iHaveAMessage() {
        this.message = "Пойдём в бар";
    }

    @When("^Server try to send message to receiver$")
    public void serverTryToSendMessageToReceiver() {
        this.user = new User();

        try {
            this.user.writeMessage(this.server, this.receiver, this.message);
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    @Then("^Receiver should get the message$")
    public void receiverShouldGetTheMessage() {
        Assert.assertTrue(Database.getInstance().searchMessage(this.server, this.receiver, this.message));
    }
}
