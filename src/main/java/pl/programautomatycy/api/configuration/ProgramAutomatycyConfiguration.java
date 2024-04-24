package pl.programautomatycy.api.configuration;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import java.util.List;
import java.util.function.Supplier;

public class ProgramAutomatycyConfiguration extends AbstractModule {
    @Named(AbstractController.BASE_URL)
    @Provides
    public String baseUrl() {
        return "https://programautomatycy.pl/wp-json";
    }

    @Named(AbstractController.USERNAME)
    @Provides
    public String username() {
        return "koston178@gmail.com";
    }

    @Named(AbstractController.PASSWORD)
    @Provides
    public String password() {
        return "test";
    }

    @Provides
    @Named(AbstractController.API_FILTERS)
    public Supplier<List<Filter>> filtersSupplier() {
        return () -> List.of(new ResponseLoggingFilter(), new RequestLoggingFilter());
    }
}
