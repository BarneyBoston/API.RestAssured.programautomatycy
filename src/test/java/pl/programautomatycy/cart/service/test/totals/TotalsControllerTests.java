package pl.programautomatycy.cart.service.test.totals;

import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.testng.annotations.Test;
import pl.programautomatycy.api.dto.additem.AddItemRequest;
import pl.programautomatycy.api.utils.ResponseAssert;
import pl.programautomatycy.cart.service.test.BaseRestTest;

public class TotalsControllerTests extends BaseRestTest {
    @Test
    public void getTotalsResponse() {
        var response = controller.getTotalsResponse();

        ResponseAssert.assertThat(response).statusCodeIs(200);
    }

    @Test
    public void getTotals() {
        var addItemRequest = new AddItemRequest("1", 140, true);
        var addItemResponse = controller.postAddItem(addItemRequest);

        var response = controller.getTotals();

        AssertionsForInterfaceTypes.assertThat(response.getTotal()).isEqualTo("15.00");
    }
}
