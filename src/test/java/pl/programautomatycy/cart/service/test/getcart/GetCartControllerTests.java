package pl.programautomatycy.cart.service.test.getcart;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pl.programautomatycy.api.utils.ResponseAssert;
import pl.programautomatycy.api.utils.TestData;
import pl.programautomatycy.cart.service.test.BaseRestTest;

public class GetCartControllerTests extends BaseRestTest {

    @When("Get Cart Response")
    public void getCartResponse() {
        response = controller.getCart();
    }

    @When("Get Cart Id Response")
    public void getCartIdResponse() {
        var response1 = controller.getCart();
        String id = response1.getCookie("woocommerce_cart_hash");

        response = controller.getCartId(id);

    }

    @Then("Assert that get cart response is {string}")
    public void assertThatResponseCodeIs(String scenario) {
        ResponseAssert.assertThat(response).statusCodeIs(TestData.getExpectedResponseCode(scenario));
    }
}
