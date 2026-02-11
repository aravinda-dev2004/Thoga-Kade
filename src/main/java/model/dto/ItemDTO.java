package model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

    private String itemCode;

    private String description;

    private String PackSize;

    private double unitPrice;

    private int qtyOnHand;
}
