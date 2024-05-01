package pl.programautomatycy.cart.service.test.calculate;

import org.testng.annotations.Test;
import pl.programautomatycy.api.utils.ResponseAssert;
import pl.programautomatycy.cart.service.test.BaseRestTest;

public class CalculateControllerTests extends BaseRestTest {
    @Test
    public void postCalculateResponse() {
        var request = controller.postCalculate(true);

        ResponseAssert.assertThat(request).statusCodeIs(200);
    }
}
