package pl.programautomatycy.cart.service.test;

import org.testng.annotations.Test;

public class B_POSTmethodBodyFormData {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemWithBodyFormData() {
        Integer productId = 142;
        Integer quantity = 10;
        Boolean returnCart = true;

        String endPoint = "/cocart/v1/add-item";

        serviceHelper.addItem(productId, quantity, returnCart, endPoint);
    }
}
