package pl.programautomatycy.cart.service.test.clearitem;

import org.testng.annotations.Test;
import pl.programautomatycy.api.dto.additem.AddItemRequest;
import pl.programautomatycy.api.utils.ResponseAssert;
import pl.programautomatycy.cart.service.test.BaseRestTest;

import static org.assertj.core.api.Assertions.assertThat;

public class ClearItemControllerTests extends BaseRestTest {
    @Test
    public void postClearItemResponse() {
        var response = controller.postClearItem();

        ResponseAssert.assertThat(response).statusCodeIs(200);
    }

    @Test
    public void postClearItem() {
        var addItemRequest = new AddItemRequest("7", 1969, true);
        var addItemResponse = controller.postAddItem(addItemRequest);

        var response = controller.postClearItem();

        var getCartResponse = controller.getCart();

        assertThat(extractor.extractStringFromResponse("key", getCartResponse)).isEqualTo(null);
    }
}
