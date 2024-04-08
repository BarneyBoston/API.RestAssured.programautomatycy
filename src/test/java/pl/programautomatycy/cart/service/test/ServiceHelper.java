package pl.programautomatycy.cart.service.test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ServiceHelper {

    public void addItem(Integer productId, Integer quantity, Boolean returnCart, String endpoint){
        Response response = given()
                .auth()
                .preemptive()
                .basic("koston178@gmail.com", "test")
                .queryParam("product_id", productId)
                .queryParam("quantity", quantity)
                .queryParam("return_cart", returnCart)
                .baseUri("https://programautomatycy.pl/wp-json")
                .post(endpoint);
    }
}
