package pl.programautomatycy.cart.service.test.totals;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import pl.programautomatycy.api.dto.additem.AddItemRequest;
import pl.programautomatycy.api.utils.ResponseAssert;
import pl.programautomatycy.api.utils.TestData;
import pl.programautomatycy.cart.service.test.BaseRestTest;

public class TotalsControllerTests extends BaseRestTest {

    @When("Get Totals Response")
    public void getTotalsResponse() {
        response = controller.getTotalsResponse();
    }

    @When("Get Totals")
    public void getTotals() {
        var addItemRequest = new AddItemRequest("1", 140, true);
        var addItemResponse = controller.postAddItem(addItemRequest);

        var response = controller.getTotals();

        AssertionsForInterfaceTypes.assertThat(response.getTotal()).isEqualTo("15.00");
    }

    @Then("Assert that totals response code is {string}")
    public void assertThatResponseCodeIs(String scenario) {
        ResponseAssert.assertThat(response).statusCodeIs(TestData.getExpectedResponseCode(scenario));
    }

}
