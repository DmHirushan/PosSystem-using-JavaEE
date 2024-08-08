package lk.ijse.gdse.pos.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDto {
    private String orderID;
    private String customerId;
    private int total;

}
