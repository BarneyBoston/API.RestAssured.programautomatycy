package pl.programautomatycy.cart.service.test.item;

import org.testng.annotations.Test;
import pl.programautomatycy.api.dto.additem.AddItemRequest;
import pl.programautomatycy.api.dto.item.ItemRequest;
import pl.programautomatycy.api.utils.ResponseAssert;
import pl.programautomatycy.cart.service.test.BaseRestTest;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemControllerTests extends BaseRestTest {
    @Test
    public void getCorrectItemResponse() {
        var request = new AddItemRequest("20", 138, true);
        var response = controller.postAddItem(request);

        var request2 = new ItemRequest(extractor.extractStringFromResponse("key", response), true);
        var response2 = controller.getItem(request2);

        ResponseAssert.assertThat(response2).statusCodeIs(200);
    }

    @Test
    public void getIncorrectItemResponse() {
        var request = new ItemRequest("1", true);
        var response = controller.getItem(request);

        ResponseAssert.assertThat(response).statusCodeIs(403);
    }

    @Test
    public void getNullItemResponse() {
        var request = new ItemRequest();
        var response = controller.getItem(request);

        ResponseAssert.assertThat(response).statusCodeIs(400);
    }

    @Test
    public void postCorrectItemResponse() {
        var request = new AddItemRequest("20", 138, true);
        var response = controller.postAddItem(request);

        var request2 = new ItemRequest(extractor.extractStringFromResponse("key", response), true);
        var response2 = controller.postUpdateItem(request2);

        ResponseAssert.assertThat(response2).statusCodeIs(200);
    }

    @Test
    public void postIncorrectItemResponse() {
        var request = new ItemRequest("1", true);
        var response = controller.postUpdateItem(request);

        ResponseAssert.assertThat(response).statusCodeIs(404);
    }

    @Test
    public void postNullItemResponse() {
        var request = new ItemRequest();
        var response = controller.postUpdateItem(request);

        ResponseAssert.assertThat(response).statusCodeIs(400);
    }

    @Test
    public void deleteItemResponse() {
        var request = new AddItemRequest("20", 138, true);
        var response = controller.postAddItem(request);

        var request2 = new ItemRequest(extractor.extractStringFromResponse("key", response), true);
        var response2 = controller.deleteItem(request2);

        ResponseAssert.assertThat(response2).statusCodeIs(200);
    }

    @Test
    public void deleteIncorrectItemResponse() {
        var request = new ItemRequest("1", true);
        var response = controller.deleteItem(request);

        ResponseAssert.assertThat(response).statusCodeIs(404);
    }

    @Test
    public void deleteNullItemResponse() {
        var request = new ItemRequest();
        var response = controller.deleteItem(request);

        ResponseAssert.assertThat(response).statusCodeIs(400);
    }

    @Test
    public void getItem() {
        var request = new AddItemRequest("20", 138, true);
        var response = controller.postAddItem(request);

        var request2 = new ItemRequest(extractor.extractStringFromResponse("key", response), true);
        var response2 = controller.getItem(request2);

        assertThat(extractor.extractStringFromResponse("key", response)).isEqualTo(extractor.extractStringFromResponse("key", response2));
    }

    @Test
    public void updateItem() {
        var request = new AddItemRequest("20", 138, true);
        var response = controller.postAddItem(request);

        var request2 = new ItemRequest("10", extractor.extractStringFromResponse("key", response), true);
        var response2 = controller.postUpdateItem(request2);

        assertThat(extractor.extractNumberFromResponse("quantity", response2)).isEqualTo(10);
    }

    @Test
    public void deleteItem() {
        var request = new AddItemRequest("20", 138, true);
        var response = controller.postAddItem(request);

        var request2 = new ItemRequest(extractor.extractStringFromResponse("key", response), true);
        var response2 = controller.deleteItem(request2);

        var request3 = new ItemRequest(extractor.extractStringFromResponse("key", response2), true);
        var response3 = controller.getItem(request3);

        assertThat(extractor.extractNumberFromResponse("quantity", response3)).isEqualTo(null);
    }

}
