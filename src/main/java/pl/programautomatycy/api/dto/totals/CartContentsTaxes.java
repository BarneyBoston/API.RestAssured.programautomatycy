package pl.programautomatycy.api.dto.totals;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CartContentsTaxes {
    @JsonProperty("1")
    private double number;
}
