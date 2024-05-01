package pl.programautomatycy.cart.service.test.countitem;

import org.testng.annotations.Test;
import pl.programautomatycy.api.dto.additem.AddItemRequest;
import pl.programautomatycy.api.utils.ResponseAssert;
import pl.programautomatycy.cart.service.test.BaseRestTest;

import static org.assertj.core.api.Assertions.assertThat;

public class CountItemControllerTests extends BaseRestTest {
    @Test
    public void getCountItemResponse() {
        var response = controller.getCountItemResponse();

        ResponseAssert.assertThat(response).statusCodeIs(200);
    }

    @Test
    public void getCountItem() {
        var request1 = new AddItemRequest("20", 138, true);
        var response1 = controller.postAddItem(request1);

        var response = controller.getCountItem();

        assertThat(response).isEqualTo("20");
    }
}
