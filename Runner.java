import by.gsu.pms.Commodity;
import by.gsu.pms.AbstractPurchase;
import by.gsu.pms.DiscountPurchase;
import by.gsu.pms.PercentDiscountPurchase;
import by.gsu.pms.TransportExpensePurchase;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Commodity uniqueCommodity = new Commodity("Unique Commodity", 100.0);

        AbstractPurchase[] purchases = new AbstractPurchase[6];
        purchases[0] = new DiscountPurchase(uniqueCommodity, 2, 20.0);
        purchases[1] = new DiscountPurchase(uniqueCommodity, 3, 15.0);
        purchases[2] = new PercentDiscountPurchase(uniqueCommodity, 5, 10.0);
        purchases[3] = new PercentDiscountPurchase(uniqueCommodity, 4, 8.0);
        purchases[4] = new TransportExpensePurchase(uniqueCommodity, 6, 50.0);
        purchases[5] = new TransportExpensePurchase(uniqueCommodity, 7, 60.0);

        System.out.println("Array content before sorting:");
        printArrayContent(purchases);

        Arrays.sort(purchases);

        System.out.println("Array content after sorting:");
        printArrayContent(purchases);

        AbstractPurchase minCostPurchase = findMinCostPurchase(purchases);
        System.out.println("Purchase with minimum cost:");
        if (minCostPurchase != null) {
            System.out.println(minCostPurchase.toString());
        }

        performAdditionalTask(purchases);
    }

    private static void printArrayContent(AbstractPurchase[] purchases) {
        for (AbstractPurchase purchase : purchases) {
            System.out.println(purchase.toString());
        }
    }

    private static AbstractPurchase findMinCostPurchase(AbstractPurchase[] purchases) {
        AbstractPurchase minCostPurchase = null;
        double minCost = Double.MAX_VALUE;

        for (AbstractPurchase purchase : purchases) {
            if (purchase.getCost() < minCost) {
                minCost = purchase.getCost();
                minCostPurchase = purchase;
            }
        }

        return minCostPurchase;
    }

    private static void performAdditionalTask(AbstractPurchase[] purchases) {
        System.out.println("Performing additional task...");
        // Add your additional task implementation here
    }
}