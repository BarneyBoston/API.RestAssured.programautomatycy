package pl.programautomatycy.cart.service.test.getcart;

import org.testng.annotations.Test;
import pl.programautomatycy.api.utils.ResponseAssert;
import pl.programautomatycy.cart.service.test.BaseRestTest;

public class GetCartControllerTests extends BaseRestTest {
    @Test
    public void getCartResponse() {
        var response = controller.getCart();

        ResponseAssert.assertThat(response).statusCodeIs(200);
    }
    @Test
    public void getCartIdResponse() {
        var response = controller.getCart();
        String id = response.getCookie("woocommerce_cart_hash");

        var response2 = controller.getCartId(id);

        ResponseAssert.assertThat(response2).statusCodeIs(200);
    }
}
