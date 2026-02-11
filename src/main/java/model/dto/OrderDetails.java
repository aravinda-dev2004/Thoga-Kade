package model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetails {

    private String orderID;

    private String itemCode;

    private Integer orderQty;

    private Integer discount;
}
