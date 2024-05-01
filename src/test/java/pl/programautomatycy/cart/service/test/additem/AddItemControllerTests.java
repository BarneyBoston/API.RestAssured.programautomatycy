package pl.programautomatycy.cart.service.test.additem;

import org.testng.annotations.Test;
import pl.programautomatycy.api.dto.additem.AddItemRequest;
import pl.programautomatycy.api.utils.ResponseAssert;
import pl.programautomatycy.cart.service.test.BaseRestTest;

public class AddItemControllerTests extends BaseRestTest {
    @Test
    public void postCorrectAddItemResponse() {
        var request = new AddItemRequest("5", 1690, true);

        var response = controller.postAddItem(request);

        ResponseAssert.assertThat(response).statusCodeIs(200);
    }

    @Test
    public void postAddItemWithoutBodyResponse() {
        var response = controller.postAddItemWithoutBody();

        ResponseAssert.assertThat(response).statusCodeIs(404);
    }

    @Test
    public void postAddItemNullValuesResponse() {
        var request = new AddItemRequest();

        var response = controller.postAddItem(request);

        ResponseAssert.assertThat(response).statusCodeIs(400);
    }
}
