public class SupermarketBill {
    public static void main(String[] args) {
        int[] price = {1200, 1500, 800, 1000, 900};
        int total = 0;
        for (int i = 0; i < 5; i++) {
            total = total + price[i];
        }
         System.out.println("Total Bill : " + total);
        if (total > 5000) {
            System.out.println("Discount Applicable");
        } else {
            System.out.println("No Discount");
        }
    }
}
