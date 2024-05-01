package pl.programautomatycy.api;


import com.google.inject.Inject;
import com.google.inject.name.Named;
import io.restassured.filter.Filter;
import io.restassured.response.Response;
import pl.programautomatycy.api.configuration.AbstractController;
import pl.programautomatycy.api.dto.additem.AddItemRequest;
import pl.programautomatycy.api.dto.item.ItemRequest;
import pl.programautomatycy.api.dto.totals.TotalsResponse;

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
    private static final String CLEAR_ITEM = "/cocart/v1/clear";
    private static final String COUNT_ITEM = "/cocart/v1/count-items";
    private static final String TOTALS = "/cocart/v1/totals";

    public Response postAddItem(AddItemRequest request) {
        return given()
                .body(request)
                .post(ADD_ITEM);
    }

    public Response postAddItemWithoutBody() {
        return given()
                .post(ADD_ITEM);
    }

    public Response postUpdateItem(ItemRequest request) {
        return given()
                .body(request)
                .post(ITEM);
    }

    public Response deleteItem(ItemRequest request) {
        return given()
                .body(request)
                .delete(ITEM);
    }

    public Response getItem(ItemRequest request) {
        return given()
                .body(request)
                .get(ITEM);
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

    public Response getCartId(String id) {
        return given()
                .queryParam("id", id)
                .get(GET_CART);
    }

    public Response postClearItem() {
        return given()
                .post(CLEAR_ITEM);
    }

    public Response getCountItemResponse() {
        return given()
                .get(COUNT_ITEM);
    }

    public String getCountItem() {
        return given()
                .get(COUNT_ITEM)
                .getBody()
                .asString()
                .trim();
    }
    public Response getTotalsResponse() {
        return given()
                .get(TOTALS);
    }
    public TotalsResponse getTotals() {
        return given()
                .get(TOTALS)
                .then()
                .extract()
                .as(TotalsResponse.class);
    }

    public void login() {
        given()
                .get("/cocart/v2/login");
    }

    public void logout() {
        given()
                .get("/cocart/v2/logout");
    }
}
