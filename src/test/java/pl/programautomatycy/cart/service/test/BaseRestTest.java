package pl.programautomatycy.cart.service.test;

import com.google.inject.Inject;
import io.restassured.response.Response;
import org.testng.annotations.Guice;
import pl.programautomatycy.api.ProgramAutomatycyController;
import pl.programautomatycy.api.configuration.ProgramAutomatycyConfiguration;
import pl.programautomatycy.api.utils.ExtractFromResponse;

@Guice(modules = ProgramAutomatycyConfiguration.class)
public class BaseRestTest {
    @Inject
    protected ProgramAutomatycyController controller;
    @Inject
    protected ExtractFromResponse extractor;

    protected static Response response;
}
