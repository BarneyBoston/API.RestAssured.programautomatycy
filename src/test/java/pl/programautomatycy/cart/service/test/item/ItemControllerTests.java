package pl.programautomatycy.cart.service.test.item;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pl.programautomatycy.api.dto.additem.AddItemRequest;
import pl.programautomatycy.api.dto.item.ItemRequest;
import pl.programautomatycy.api.utils.ResponseAssert;
import pl.programautomatycy.cart.service.test.BaseRestTest;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemControllerTests extends BaseRestTest {

    @When("Get Correct Item Response")
    public void getCorrectItemResponse() {
        var request = new AddItemRequest("20", 138, true);
        var response1 = controller.postAddItem(request);

        var request2 = new ItemRequest(extractor.extractStringFromResponse("key", response1), true);
        response = controller.getItem(request2);
    }

    @When("Get Incorrect Item Response")
    public void getIncorrectItemResponse() {
        var request = new ItemRequest("1", true);
        response = controller.getItem(request);
    }

    @When("Get Null Item Response")
    public void getNullItemResponse() {
        var request = new ItemRequest();
        response = controller.getItem(request);
    }

    @When("Post Correct Item Response")
    public void postCorrectItemResponse() {
        var request = new AddItemRequest("20", 138, true);
        var response1 = controller.postAddItem(request);

        var request2 = new ItemRequest(extractor.extractStringFromResponse("key", response1), true);
        response = controller.postUpdateItem(request2);
    }

    @When("Post Incorrect Item Response")
    public void postIncorrectItemResponse() {
        var request = new ItemRequest("1", true);
        response = controller.postUpdateItem(request);
    }

    @When("Post Null Item Response")
    public void postNullItemResponse() {
        var request = new ItemRequest();
        response = controller.postUpdateItem(request);
    }

    @When("Delete Item Response")
    public void deleteItemResponse() {
        var request = new AddItemRequest("20", 138, true);
        var response1 = controller.postAddItem(request);

        var request2 = new ItemRequest(extractor.extractStringFromResponse("key", response1), true);
        response = controller.deleteItem(request2);
    }

    @When("Delete Incorrect Item Response")
    public void deleteIncorrectItemResponse() {
        var request = new ItemRequest("1", true);
        response = controller.deleteItem(request);
    }

    @When("Delete Null Item Response")
    public void deleteNullItemResponse() {
        var request = new ItemRequest();
        response = controller.deleteItem(request);
    }

    @When("Get Item")
    public void getItem() {
        var request = new AddItemRequest("20", 138, true);
        var response1 = controller.postAddItem(request);

        var request2 = new ItemRequest(extractor.extractStringFromResponse("key", response1), true);
        response = controller.getItem(request2);

        assertThat(extractor.extractStringFromResponse("key", response)).isEqualTo(extractor.extractStringFromResponse("key", response));
    }

    @When("Update Item")
    public void updateItem() {
        var request = new AddItemRequest("20", 138, true);
        var response1 = controller.postAddItem(request);

        var request2 = new ItemRequest("10", extractor.extractStringFromResponse("key", response1), true);
        response = controller.postUpdateItem(request2);

        assertThat(extractor.extractNumberFromResponse("quantity", response)).isEqualTo(10);
    }

    @When("Delete Item")
    public void deleteItem() {
        var request = new AddItemRequest("20", 138, true);
        var response1 = controller.postAddItem(request);

        var request2 = new ItemRequest(extractor.extractStringFromResponse("key", response1), true);
        var response2 = controller.deleteItem(request2);

        var request3 = new ItemRequest(extractor.extractStringFromResponse("key", response2), true);
        response = controller.getItem(request3);

        assertThat(extractor.extractNumberFromResponse("quantity", response)).isEqualTo(null);
    }

    @Then("Assert that item response code is {int}")
    public void assertThatResponseCodeIs(Integer responseCode) {
        ResponseAssert.assertThat(response).statusCodeIs(responseCode);
    }

}
