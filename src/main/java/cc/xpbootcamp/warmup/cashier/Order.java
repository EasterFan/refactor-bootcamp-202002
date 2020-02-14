package cc.xpbootcamp.warmup.cashier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class Order {
    private String customerName;
    private String customerAddress;
    private List<LineItem> lineItems;
}
