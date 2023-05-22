package by.gsu.pms;

import java.util.Scanner;

public class PurchasesFactory {
    private enum PurchasesKinds {
        GENERAL_PURCHASE,
        DISCOUNT_PURCHASE,
        QUANTITY_DISCOUNT_PURCHASE
    }

    public Purchase getClassFromFactory(Scanner sc) {
        String id = sc.next();
        PurchasesKinds kind = PurchasesKinds.valueOf(id);

        switch (kind) {
            case GENERAL_PURCHASE:
                return new Purchase(sc.next(), sc.nextDouble(), sc.nextInt());
            case DISCOUNT_PURCHASE:
                return new DiscountPurchase(sc.next(), sc.nextDouble(), sc.nextInt(), sc.nextDouble());
            case QUANTITY_DISCOUNT_PURCHASE:
                return new QuantityDiscountPurchase(sc.next(), sc.nextDouble(), sc.nextInt());
            default:
                return null;
        }
    }
}