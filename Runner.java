import by.gsu.pms.Purchase;
import by.gsu.pms.PurchasesFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Purchase[] purchases = new Purchase[6];
        PurchasesFactory factory = new PurchasesFactory();

        try {
            File file = new File("src/in.txt");
            Scanner scanner = new Scanner(file);

            int index = 0;
            while (scanner.hasNextLine() && index < 6) {
                purchases[index] = factory.getClassFromFactory(new Scanner(scanner.nextLine()));
                index++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (Purchase purchase : purchases) {
            System.out.println(purchase.toString());
        }

        System.out.println("Maximum cost purchase:");
        Purchase maxCostPurchase = findMaxCostPurchase(purchases);
        if (maxCostPurchase != null) {
            System.out.println(maxCostPurchase.toString());
        }

        System.out.println("Are all purchases equal? " + areAllPurchasesEqual(purchases));
    }

    private static Purchase findMaxCostPurchase(Purchase[] purchases) {
        Purchase maxCostPurchase = null;
        double maxCost = 0;

        for (Purchase purchase : purchases) {
            if (purchase != null && purchase.getCost() > maxCost) {
                maxCost = purchase.getCost();
                maxCostPurchase = purchase;
            }
        }

        return maxCostPurchase;
    }

    private static boolean areAllPurchasesEqual(Purchase[] purchases) {
        if (purchases.length <= 1) {
            return true;
        }

        for (int i = 1; i < purchases.length; i++) {
            if (purchases[i] != null && !purchases[i].equals(purchases[0])) {
                return false;
            }
        }

        return true;
    }
}