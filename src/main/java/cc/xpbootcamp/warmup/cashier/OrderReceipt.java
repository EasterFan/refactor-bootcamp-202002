package cc.xpbootcamp.warmup.cashier;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static cc.xpbootcamp.warmup.cashier.Constant.*;

@AllArgsConstructor
public class OrderReceipt {
    private static final double SALES_TAX_RATE = 0.1;
    private static final double DISCOUNT_RATE = 0.02;
    private Order order;

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        printTitle(output);
        printDate(output);
        printCustomInfo(output);
        printLineItems(output);
        calculateAndPrintTaxAndAmount(output);
        return output.toString();
    }

    private void printTitle(StringBuilder output) {
        output.append("===== 老王超市，值得信赖 ======\n");
    }

    private void printDate(StringBuilder output) {
        output.append(DateTimeFormatter.ofPattern(YY_MM_DD).format(LocalDate.now()))
                .append(", ")
                .append(XINGQI).append(WEEKS[LocalDate.now().getDayOfWeek().getValue()])
                .append('\n');
    }

    private void printCustomInfo(StringBuilder output) {
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }

    private void printLineItems(StringBuilder output) {
        for (LineItem lineItem : order.getLineItems()) {
            output.append('\n' + lineItem.getDescription()).append(",").append('\t')
                    .append(lineItem.getPrice()).append('x').append(lineItem.getQuantity())
                    .append('\t');
            output.append(lineItem.totalAmount()).append('\t');
        }
    }

    private void printTaxAndTotalPrice(StringBuilder output, double totalSalesTax, double totalAmount) {
        output.append("\n税额: ").append(totalSalesTax).append('\n');
        double discount = 0;
        if (LocalDate.now().getDayOfWeek().getValue() == 3) {
            discount = totalAmount * DISCOUNT_RATE;
            output.append("折扣: ")
                    .append(BigDecimal.valueOf(discount).setScale(2, RoundingMode.HALF_UP).doubleValue())
                    .append('\n');
        }
        output.append("总价: ")
                .append(BigDecimal.valueOf(totalAmount + totalSalesTax - discount).setScale(2, RoundingMode.HALF_UP).doubleValue())
                .append('\n');
    }

    private void calculateAndPrintTaxAndAmount(StringBuilder output) {
        double totalSalesTax = 0d;
        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            totalSalesTax += lineItem.totalAmount() * SALES_TAX_RATE;
            totalAmount += lineItem.totalAmount();
        }
        printTaxAndTotalPrice(output, totalSalesTax, totalAmount);
    }
}