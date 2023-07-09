
import java.util.Scanner;

public class CarBilling{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CarDealer carDealer = new CarDealer();

        System.out.print("Select car model: ");
        String carModel = sc.nextLine();

        System.out.print("Do you need Insurance (yes/no): ");
        String insuranceOption = sc.nextLine();
        boolean needInsurance = insuranceOption.equalsIgnoreCase("yes");

        System.out.print("Do you need Additional Accessories (yes/no): ");
        String accessoriesOption = sc.nextLine();
        boolean needAdditionalAccessories = accessoriesOption.equalsIgnoreCase("yes");

        System.out.print("Dealer discount (in percentage or rupees): ");
        double dealerDiscount = sc.nextDouble();

        double totalCost = carDealer.calculateTotalCost(carModel, needInsurance, needAdditionalAccessories, dealerDiscount);
        if (totalCost > 0) {
            System.out.println("Total cost: " + totalCost);
        }
    }
}
