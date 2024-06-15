package pl.programautomatycy.cart.service.test;

import com.google.inject.Inject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Guice;
import pl.programautomatycy.api.ProgramAutomatycyController;
import pl.programautomatycy.api.configuration.ProgramAutomatycyConfiguration;
import pl.programautomatycy.api.dto.item.ItemRequest;
import pl.programautomatycy.api.utils.ExtractFromResponse;

@CucumberOptions(
        features = "src/test/resources/scenarios",
        glue = "pl.programautomatycy.cart.service.test"
)
@Guice(modules = ProgramAutomatycyConfiguration.class)
public class TestNgRunner extends AbstractTestNGCucumberTests {

    @Inject
    protected ProgramAutomatycyController controller;

    @Inject
    protected ExtractFromResponse extractor;

    @Given("User is logged in")
    public void loginApi() {
        controller.login();
    }

    @Then("Log out user")
    public void logoutApi() {
        tearDown();
        controller.logout();
    }

    private void tearDown() {
        var response = controller.getCart();
        var list = extractor.extractValuesFromResponse(response, "key");
        list.forEach(key -> {
            var request = new ItemRequest(key, true);
            controller.deleteItem(request);
        });
    }
}
