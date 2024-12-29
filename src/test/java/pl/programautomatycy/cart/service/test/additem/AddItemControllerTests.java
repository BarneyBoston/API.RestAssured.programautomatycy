package pl.programautomatycy.cart.service.test.additem;

import io.cucumber.java.en.When;
import pl.programautomatycy.api.dto.additem.AddItemRequest;
import pl.programautomatycy.cart.service.test.BaseRestTest;


public class AddItemControllerTests extends BaseRestTest {

    @When("Post Add Item Request with quantity {string}, product_id {int}, return_cart {string}")
    public void sendAddItemRequest(String quantity, Integer product_id, String return_cart) {
        Boolean parsed = Boolean.parseBoolean(return_cart);
        var request = new AddItemRequest(quantity, product_id, parsed);
        response = controller.postAddItem(request);
    }

    @When("Post Add Item Request with empty body")
    public void sendEmptyAddItemRequest() {
        response = controller.postAddItemWithoutBody();
    }

    @When("Post Add Item Request with nulls in body")
    public void sendNullAddItemRequest() {
        var request = new AddItemRequest();
        response = controller.postAddItem(request);
    }


}
