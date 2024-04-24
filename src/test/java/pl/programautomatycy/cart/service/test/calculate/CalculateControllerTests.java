package pl.programautomatycy.cart.service.test.calculate;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import pl.programautomatycy.api.utils.ResponseAssert;
import pl.programautomatycy.cart.service.test.BaseRestTest;

public class CalculateControllerTests extends BaseRestTest {
    @Test
    public void postCalculateResponse() {
        Response request = controller.postCalculate(true);

        ResponseAssert.assertThat(request).statusCodeIs(200);
    }
}
