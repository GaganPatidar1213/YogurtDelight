import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class YogurtCart {
    private List<CartItem> cart;

    public YogurtCart() {
        cart = new ArrayList<>();
    }

    public void addToCart(String flavor, double price) {
        CartItem item = new CartItem(flavor, price);
        cart.add(item);
        // No need to call updateCart() here
    }

    public double calculateTotalCost() {
        double totalCost = 0;
        for (CartItem item : cart) {
            totalCost += item.price;
        }
        return totalCost;
    }

    public void generateHtmlPageWithPaymentOptions() {
        String fileName = "payment.html";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("<!DOCTYPE html>");
            writer.newLine();
            writer.write("<html lang=\"en\">");
            writer.newLine();
            writer.write("<head>");
            writer.newLine();
            writer.write("<meta charset=\"UTF-8\">");
            writer.newLine();
            writer.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            writer.newLine();
            writer.write("<title>Payment</title>");
            writer.newLine();
            writer.write("</head>");
            writer.newLine();
            writer.write("<body>");
            writer.newLine();
            writer.write("<h1>Your Yogurt Cart</h1>");
            writer.newLine();
            writer.write("<ul>");
            writer.newLine();
            for (CartItem item : cart) {
                writer.write("<li>" + item.flavor + " - $" + item.price + "</li>");
                writer.newLine();
            }
            writer.write("</ul>");
            writer.newLine();
            double totalCost = calculateTotalCost();
            writer.write("<p>Total Cost: $" + totalCost + "</p>");
            writer.newLine();
            writer.write("<h2>Select Payment Method:</h2>");
            writer.newLine();
            writer.write("<form action=\"process_payment\" method=\"post\">");
            writer.newLine();
            writer.write("<input type=\"radio\" id=\"credit_card\" name=\"payment_method\" value=\"credit_card\">");
            writer.newLine();
            writer.write("<label for=\"credit_card\">Credit Card</label><br>");
            writer.newLine();
            writer.write("<input type=\"radio\" id=\"debit_card\" name=\"payment_method\" value=\"debit_card\">");
            writer.newLine();
            writer.write("<label for=\"debit_card\">Debit Card</label><br>");
            writer.newLine();
            writer.write("<input type=\"radio\" id=\"paypal\" name=\"payment_method\" value=\"paypal\">");
            writer.newLine();
            writer.write("<label for=\"paypal\">PayPal</label><br>");
            writer.newLine();
            writer.write("<input type=\"submit\" value=\"Proceed to Payment\">");
            writer.newLine();
            writer.write("</form>");
            writer.newLine();
            writer.write("</body>");
            writer.newLine();
            writer.write("</html>");
            writer.newLine();
            System.out.println("HTML page generated successfully: " + fileName);
        } catch (IOException e) {
            System.out.println("Error occurred while generating HTML page: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        YogurtCart cart = new YogurtCart();
        cart.addToCart("Kiwi", 299);
        cart.addToCart("Mango", 299);
        cart.addToCart("Strawberry", 299);
        cart.addToCart("Blackberry", 299);
        cart.generateHtmlPageWithPaymentOptions();
    }

    // Inner class to represent a cart item
    private static class CartItem {
        String flavor;
        double price;

        public CartItem(String flavor, double price) {
            this.flavor = flavor;
            this.price = price;
        }
    }
}
