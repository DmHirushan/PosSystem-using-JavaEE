package lk.ijse.gdse.pos.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ItemDto {
    private String itemCode;
    private String itemName;
    private String itemQty;
    private String unitPrice;
}
