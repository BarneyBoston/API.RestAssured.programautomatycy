package pl.programautomatycy.cart.service.test.countitem;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pl.programautomatycy.api.dto.additem.AddItemRequest;
import pl.programautomatycy.api.utils.ResponseAssert;
import pl.programautomatycy.api.utils.TestData;
import pl.programautomatycy.cart.service.test.BaseRestTest;

import static org.assertj.core.api.Assertions.assertThat;

public class CountItemControllerTests extends BaseRestTest {

    @When("Get Count Item Response")
    public void getCountItemResponse() {
        response = controller.getCountItemResponse();
    }

    @When("Get Count Item")
    public void getCountItem() {
        var request1 = new AddItemRequest("20", 138, true);
        var response1 = controller.postAddItem(request1);

        var response = controller.getCountItem();

        assertThat(response).isEqualTo("20");
    }

    @Then("Assert that count item response code is {string}")
    public void assertThatResponseCodeIs(String scenario) {
        ResponseAssert.assertThat(response).statusCodeIs(TestData.getExpectedResponseCode(scenario));
    }
}
