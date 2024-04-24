package pl.programautomatycy.api.dto.item;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemRequest {
    Integer quantity;
    String cart_item_key;
    Boolean return_cart;

    ItemRequest(String cart_item_key, Boolean return_cart) {
        this.cart_item_key = cart_item_key;
        this.return_cart = return_cart;
    }
}
