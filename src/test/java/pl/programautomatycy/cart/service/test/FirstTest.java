package pl.programautomatycy.cart.service.test;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

public class FirstTest {

    @Test
    public void test(){
        assertThat(RestAssured.config(), instanceOf(RestAssured.config().getClass()));
    }
}
