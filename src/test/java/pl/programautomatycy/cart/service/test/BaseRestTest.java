package pl.programautomatycy.cart.service.test;

import com.google.inject.Inject;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.annotations.Guice;
import pl.programautomatycy.api.ProgramAutomatycyController;
import pl.programautomatycy.api.configuration.ProgramAutomatycyConfiguration;
import pl.programautomatycy.api.utils.ExtractFromResponse;
import pl.programautomatycy.api.utils.ResponseAssert;
import pl.programautomatycy.api.utils.TestData;

@Guice(modules = ProgramAutomatycyConfiguration.class)
public class BaseRestTest {
    @Inject
    protected ProgramAutomatycyController controller;
    @Inject
    protected ExtractFromResponse extractor;

    protected static Response response;

    @Then("Assert that add item response code is {string}")
    public void assertThatResponseCodeIs(String scenario) {
        ResponseAssert.assertThat(response).statusCodeIs(TestData.getExpectedResponseCode(scenario));
    }
}
