package model.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartItemDTO {

    private String itemCode;

    private String description;

    private int quantity;

    private double unitPrice;

    private double discount;

    private double totalPrice;
}
