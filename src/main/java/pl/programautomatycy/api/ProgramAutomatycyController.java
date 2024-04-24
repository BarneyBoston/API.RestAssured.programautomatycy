package pl.programautomatycy.api;


import com.google.inject.Inject;
import com.google.inject.name.Named;
import io.restassured.filter.Filter;
import io.restassured.response.Response;
import pl.programautomatycy.api.configuration.AbstractController;
import pl.programautomatycy.api.dto.additem.AddItemRequest;
import pl.programautomatycy.api.dto.item.ItemRequest;

import java.util.List;
import java.util.function.Supplier;

public class ProgramAutomatycyController extends AbstractController {
    @Inject
    public ProgramAutomatycyController(@Named(BASE_URL) String baseUrl, @Named(USERNAME) String username, @Named(PASSWORD) String password, @Named("API_FILTERS") Supplier<List<Filter>> filters) {
        super(baseUrl, username, password, filters);
    }

    private static final String ADD_ITEM = "/cocart/v1/add-item";
    private static final String CALCULATE = "/cocart/v1/calculate";
    private static final String GET_CART = "/cocart/v1/get-cart";
    private static final String ITEM = "/cocart/v1/item";

    public Response postAddItem(AddItemRequest request) {
        return given()
                .body(request)
                .post(ADD_ITEM);
    }

    public Response postItem(ItemRequest request) {
        return given()
                .body(request)
                .post(ITEM);
    }

    public Response postCalculate(boolean return_cart) {
        return given()
                .queryParam("return", return_cart)
                .post(CALCULATE);
    }

    public Response getCart() {
        return given()
                .get(GET_CART);
    }
}
