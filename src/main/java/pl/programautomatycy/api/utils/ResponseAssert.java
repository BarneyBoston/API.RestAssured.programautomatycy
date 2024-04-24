package pl.programautomatycy.api.utils;

import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ObjectAssert;

public class ResponseAssert extends AbstractAssert<ResponseAssert, Response> {
    private ResponseAssert(Response response) {
        super(response, ResponseAssert.class);
    }

    public static ResponseAssert assertThat(Response actual) {
        return new ResponseAssert(actual);
    }

    public ResponseAssert statusCodeIs(int expected) {
        if (((Response) this.actual).getStatusCode() != expected) {
            throw this.failureWithActualExpected(((Response) this.actual).getStatusCode(), expected, "Expected status code to be <%s> but was <%s>.", new Object[]{expected, ((Response) this.actual).getStatusCode()});
        } else {
            return this;
        }
    }

    public ResponseAssert containsJsonPath(String path) {
        this.isNotNull();
        Object valueAtPath = ((Response) this.actual).jsonPath().get(path);
        ((ObjectAssert) Assertions.assertThat(valueAtPath).describedAs("Expected '%s' json path to be present but was not.", new Object[]{path})).isNotNull();
        return this;
    }
}
