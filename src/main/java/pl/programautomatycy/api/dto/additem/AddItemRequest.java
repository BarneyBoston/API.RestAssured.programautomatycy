package pl.programautomatycy.api.dto.additem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddItemRequest {
    Integer quantity;
    Integer product_id;
    Boolean return_cart;
}
