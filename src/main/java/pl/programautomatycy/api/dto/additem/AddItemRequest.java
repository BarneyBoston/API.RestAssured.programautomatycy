package pl.programautomatycy.api.dto.additem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddItemRequest {
    private String quantity;
    private Integer product_id;
    private Boolean return_cart;

    public AddItemRequest() {
    }
}
