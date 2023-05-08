package stepdefinitions;

import com.qa.factory.DriverFactory;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class HomePageSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private HomePage homePage;

    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable dataTable){
        List<Map<String, String>> credList = dataTable.asMaps(String.class, String.class);
        String userName = credList.get(0).get("username");
        String password = credList.get(0).get("password");
        DriverFactory.getDriver()
                .get("https://classic.freecrm.com/");
        homePage = loginPage.doLogin(userName,password);
    }

    @Given("user is on Home page")
    public void user_is_on_Home_page(){
        homePage.getHomePageTitle();
    }

    @Then("accounts section count should be {int}")
    public void accounts_section_count_should_be(Integer ExpectedHeaders) {
        Assert.assertTrue(homePage.getTechnologiesCount()==ExpectedHeaders);
    }

    @Then("user gets headers section")
    public void user_gets_headers_section(DataTable dataTable) {
            List<String> expHeaderList = dataTable.asList();
            System.out.println(expHeaderList);
        List<String> actHeaderList = homePage.getHomePageHeaderName();
        System.out.println(actHeaderList);
        Assert.assertTrue(expHeaderList.containsAll(actHeaderList));
    }



}
