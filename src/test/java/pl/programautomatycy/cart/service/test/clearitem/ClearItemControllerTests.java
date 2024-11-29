package pl.programautomatycy.cart.service.test.clearitem;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pl.programautomatycy.api.dto.additem.AddItemRequest;
import pl.programautomatycy.api.utils.ResponseAssert;
import pl.programautomatycy.api.utils.TestData;
import pl.programautomatycy.cart.service.test.BaseRestTest;

import static org.assertj.core.api.Assertions.assertThat;

public class ClearItemControllerTests extends BaseRestTest {

    @When("Post Clear Item Response")
    public void postClearItemRequest() {
        response = controller.postClearItem();
    }

    @When("Post Clear Item")
    public void postClearItem() {
        var addItemRequest = new AddItemRequest("7", 1969, true);
        var addItemResponse = controller.postAddItem(addItemRequest);

        response = controller.postClearItem();

        var getCartResponse = controller.getCart();

        assertThat(extractor.extractStringFromResponse("key", getCartResponse)).isEqualTo(null);
    }

    @Then("Assert that clear item response code is {string}")
    public void assertThatResponseCodeIs(String scenario) {
        ResponseAssert.assertThat(response).statusCodeIs(TestData.getExpectedResponseCode(scenario));
    }
}
