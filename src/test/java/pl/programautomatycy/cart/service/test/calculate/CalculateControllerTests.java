package pl.programautomatycy.cart.service.test.calculate;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pl.programautomatycy.api.utils.ResponseAssert;
import pl.programautomatycy.api.utils.TestData;
import pl.programautomatycy.cart.service.test.BaseRestTest;

public class CalculateControllerTests extends BaseRestTest {

    @When("Post Calculate Item Request with return_cart {string}")
    public void sendAddItemRequest(String return_cart) {
        Boolean parsed = Boolean.parseBoolean(return_cart);
        response = controller.postCalculate(parsed);
    }

    @Then("Assert that calculate response code is {string}")
    public void assertThatResponseCodeIs(String scenario) {
        ResponseAssert.assertThat(response).statusCodeIs(TestData.getExpectedResponseCode(scenario));
    }
}
