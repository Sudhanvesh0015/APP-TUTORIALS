import java.sql.*;
import java.util.Scanner;

public class ProductJDBC {
    static final String URL = "jdbc:mysql://localhost:3306/storedb";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Connected to MySQL.");
            while (true) {
                System.out.println("\n1. Insert Product\n2. Retrieve Product by ID\n"
                        + "3. Update Quantity\n4. Show Products with Quantity < 10\n5. Exit");
                System.out.print("Choice: ");
                int choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {
                    case 1 -> insertProduct(con, sc);
                    case 2 -> getProduct(con, sc);
                    case 3 -> updateQuantity(con, sc);
                    case 4 -> lowStock(con);
                    case 5 -> { System.out.println("Goodbye!"); return; }
                    default -> System.out.println("Invalid choice.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input.");
        }
    }

    static void insertProduct(Connection con, Scanner sc) throws SQLException {
        System.out.print("Product ID: ");   int id = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Product Name: "); String name = sc.nextLine();
        System.out.print("Price: ");        double price = Double.parseDouble(sc.nextLine().trim());
        System.out.print("Quantity: ");     int qty = Integer.parseInt(sc.nextLine().trim());

        String sql = "INSERT INTO Product (ProductID, ProductName, Price, Quantity) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, price);
            ps.setInt(4, qty);
            System.out.println(ps.executeUpdate() + " product inserted.");
        }
    }

    static void getProduct(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Product ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());

        String sql = "SELECT * FROM Product WHERE ProductID = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    printHeader();
                    printRow(rs);
                } else {
                    System.out.println("No product found with ID " + id);
                }
            }
        }
    }

    static void updateQuantity(Connection con, Scanner sc) throws SQLException {
        System.out.print("Product ID: ");    int id = Integer.parseInt(sc.nextLine().trim());
        System.out.print("New Quantity: ");  int qty = Integer.parseInt(sc.nextLine().trim());

        String sql = "UPDATE Product SET Quantity = ? WHERE ProductID = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, qty);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Quantity updated." : "Product not found.");
        }
    }

    static void lowStock(Connection con) throws SQLException {
        String sql = "SELECT * FROM Product WHERE Quantity < ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, 10);
            try (ResultSet rs = ps.executeQuery()) {
                boolean found = false;
                while (rs.next()) {
                    if (!found) { printHeader(); found = true; }
                    printRow(rs);
                }
                if (!found) System.out.println("No products with quantity below 10.");
            }
        }
    }

    static void printHeader() {
        System.out.printf("%-10s %-25s %-10s %-8s%n", "ProductID", "ProductName", "Price", "Quantity");
    }

    static void printRow(ResultSet rs) throws SQLException {
        System.out.printf("%-10d %-25s %-10.2f %-8d%n",
                rs.getInt("ProductID"), rs.getString("ProductName"),
                rs.getDouble("Price"), rs.getInt("Quantity"));
    }
}