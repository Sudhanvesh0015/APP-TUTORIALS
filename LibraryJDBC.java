import java.sql.*;
import java.util.Scanner;

/*
 * SQL setup:
 *   CREATE DATABASE librarydb;
 *   USE librarydb;
 *   CREATE TABLE Book (
 *       BookID       INT PRIMARY KEY,
 *       Title        VARCHAR(100),
 *       Author       VARCHAR(100),
 *       Price        DECIMAL(8,2),
 *       Availability VARCHAR(10) DEFAULT 'Available'   -- 'Available' / 'Issued'
 *   );
 *
 * Compile: javac LibraryJDBC.java
 * Run:     java -cp .;mysql-connector-j.jar LibraryJDBC     (use ':' instead of ';' on Linux/Mac)
 */
public class LibraryJDBC {
    static final String URL = "jdbc:mysql://localhost:3306/librarydb";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Connected to database.");
            while (true) {
                System.out.println("\n1. Insert Book\n2. Search Book by ID\n"
                        + "3. Display Available Books\n4. Issue Book\n5. Exit");
                System.out.print("Choice: ");
                int choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {
                    case 1 -> insertBook(con, sc);
                    case 2 -> searchBook(con, sc);
                    case 3 -> displayAvailable(con);
                    case 4 -> issueBook(con, sc);
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

    static void insertBook(Connection con, Scanner sc) throws SQLException {
        System.out.print("Book ID: ");  int id = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Title: ");    String title = sc.nextLine();
        System.out.print("Author: ");   String author = sc.nextLine();
        System.out.print("Price: ");    double price = Double.parseDouble(sc.nextLine().trim());

        String sql = "INSERT INTO Book (BookID, Title, Author, Price, Availability) "
                   + "VALUES (?, ?, ?, ?, 'Available')";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setDouble(4, price);
            System.out.println(ps.executeUpdate() + " book inserted.");
        }
    }

    static void searchBook(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Book ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());

        String sql = "SELECT * FROM Book WHERE BookID = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    printHeader();
                    printRow(rs);
                } else {
                    System.out.println("No book found with ID " + id);
                }
            }
        }
    }

    static void displayAvailable(Connection con) throws SQLException {
        String sql = "SELECT * FROM Book WHERE Availability = 'Available'";
        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            boolean found = false;
            while (rs.next()) {
                if (!found) { printHeader(); found = true; }
                printRow(rs);
            }
            if (!found) System.out.println("No available books.");
        }
    }

    static void issueBook(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Book ID to issue: ");
        int id = Integer.parseInt(sc.nextLine().trim());

        String sql = "UPDATE Book SET Availability = 'Issued' "
                   + "WHERE BookID = ? AND Availability = 'Available'";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Book issued successfully."
                                        : "Book not found or already issued.");
        }
    }

    static void printHeader() {
        System.out.printf("%-8s %-25s %-20s %-10s %-12s%n",
                "BookID", "Title", "Author", "Price", "Availability");
    }

    static void printRow(ResultSet rs) throws SQLException {
        System.out.printf("%-8d %-25s %-20s %-10.2f %-12s%n",
                rs.getInt("BookID"), rs.getString("Title"), rs.getString("Author"),
                rs.getDouble("Price"), rs.getString("Availability"));
    }
}
