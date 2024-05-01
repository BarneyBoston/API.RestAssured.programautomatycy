package pl.programautomatycy.api.dto.totals;

import lombok.Data;

import java.util.ArrayList;

@Data
public class TotalsResponse {
    private String subtotal;
    private double subtotal_tax;
    private String shipping_total;
    private int shipping_tax;
    private ArrayList<Object> shipping_taxes;
    private int discount_total;
    private int discount_tax;
    private String cart_contents_total;
    private double cart_contents_tax;
    private CartContentsTaxes cart_contents_taxes;
    private String fee_total;
    private int fee_tax;
    private ArrayList<Object> fee_taxes;
    private String total;
    private double total_tax;
}
