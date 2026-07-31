class Book {
    String title;
    String author;
    double price;
     public static void main(String[] args) {
        Book b = new Book();
         b.title = "ADVANCED PROGRAMMING PROBLEMS";
        b.author = "SOMEONE";
        b.price = 200.00;
        System.out.println("Title: " + b.title);
        System.out.println("Author: " + b.author);
        System.out.println("Price: ₹" + b.price);
    }
}
