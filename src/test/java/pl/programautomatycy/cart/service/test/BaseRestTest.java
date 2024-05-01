package pl.programautomatycy.cart.service.test;

import com.google.inject.Inject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Guice;
import pl.programautomatycy.api.ProgramAutomatycyController;
import pl.programautomatycy.api.configuration.ProgramAutomatycyConfiguration;
import pl.programautomatycy.api.dto.item.ItemRequest;
import pl.programautomatycy.api.utils.ExtractFromResponse;

@Guice(modules = ProgramAutomatycyConfiguration.class)
public class BaseRestTest {
    @Inject
    protected ProgramAutomatycyController controller;
    @Inject
    protected ExtractFromResponse extractor;

    @BeforeClass
    public void loginApi() {
        controller.login();
    }

    @AfterClass
    public void logoutApi() {
        tearDown();
        controller.logout();
    }
    private void tearDown(){
        var response = controller.getCart();
        var list = extractor.extractValuesFromResponse(response, "key");
        list.forEach(key -> {
            var request = new ItemRequest(key,true);
            controller.deleteItem(request);
        });
    }
}
