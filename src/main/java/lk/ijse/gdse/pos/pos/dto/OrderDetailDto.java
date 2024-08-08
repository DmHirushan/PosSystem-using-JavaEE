package lk.ijse.gdse.pos.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetailDto {
    private String orderId;
    private String itemCode;
    private  double unitPrice;
}
