package pl.programautomatycy.cart.service.test.additem;

import org.testng.annotations.Test;
import pl.programautomatycy.api.dto.additem.AddItemRequest;
import pl.programautomatycy.api.dto.item.ItemRequest;
import pl.programautomatycy.api.utils.ResponseAssert;
import pl.programautomatycy.cart.service.test.BaseRestTest;

public class AddItemControllerTests extends BaseRestTest {
    @Test
    public void postAddItemResponse() {
        var request = new AddItemRequest(5, 1690, true);

        var response = controller.postAddItem(request);

        ResponseAssert.assertThat(response).statusCodeIs(200);
    }

    @Test
    public void postAddItemAndUpdateIt() {
        var request = new AddItemRequest(5, 1690, true);
        var response = controller.postAddItem(request);


        var request2 = new ItemRequest(10, extractor.extractFromResponse("key", response), true);
        var response2 = controller.postItem(request2);
    }

}
