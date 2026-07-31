class Temperature {
    double celsius;

    void convert() {
        double fahrenheit = (celsius * 9 / 5) + 32;

        System.out.println("Celsius: " + celsius);
        System.out.println("Fahrenheit: " + fahrenheit);
    }

    public static void main(String[] args) {
        Temperature t = new Temperature();

        t.celsius = 30;

        t.convert();
    }
}