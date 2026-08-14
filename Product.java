class ProductInfo {
    int id;
    String name;
    double price;
    int qty;
    ProductInfo(int id, String name, double price, int qty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }
}
public class Product {
    public static void main(String[] args) {
        ProductInfo[] p = new ProductInfo[5];
        p[0]=new ProductInfo(101, "Laptop",50000,1);
        p[1]=new ProductInfo(102, "Mouse",500,4);
        p[2]=new ProductInfo(103, "Keyboard",1200,2);
        p[3]=new ProductInfo(104, "Monitor",8000,1);
        p[4]=new ProductInfo(105, "Pen Drive",600,3);
        for (int i=0;i<5;i++) {
            double total =p[i].price*p[i].qty;
            double discount = (total>=5000)?total*0.10:total*0.05;
            double finalPrice =total-discount;
            System.out.println("ID:"+p[i].id+"Name:"+p[i].name);
            System.out.println("Total:"+total + "Discount:"+discount + "Final:"+finalPrice);
        }
    }
}
    

