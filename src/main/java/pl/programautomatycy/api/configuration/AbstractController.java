package pl.programautomatycy.api.configuration;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.function.Supplier;


public abstract class AbstractController {
    public static final String BASE_URL = "BASE_URL";
    public static final String USERNAME = "USERNAME";
    public static final String PASSWORD = "PASSWORD";
    public static final String API_FILTERS = "API_FILTERS";
    protected final String baseUrl;
    protected final String username;
    protected final String password;
    protected final Supplier<List<Filter>> filterSupplier;
    protected Cookies cookies;

    @Inject
    public AbstractController(@Named("BASE_URL") String baseUrl, @Named("USERNAME") String username, @Named("PASSWORD") String password, @Named("API_FILTERS") Supplier<List<Filter>> filters) {
        this.baseUrl = baseUrl;
        this.username = username;
        this.password = password;
        this.filterSupplier = filters;
    }

    protected RequestSpecification given() {
        RequestSpecification given =
                RestAssured.given()
                        .auth()
                        .preemptive()
                        .basic(username, password)
                        .baseUri(this.baseUrl)
                        .filters(this.filterSupplier.get())
                        .contentType(ContentType.JSON);

        if (this.cookies != null) {
            given.cookies(this.cookies);
        }
        return given;
    }
}
