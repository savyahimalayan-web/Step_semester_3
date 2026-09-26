public class ShoppingCartDemo {
    static class Cart {
        // Private price storage
        private double[] prices;
        // Number of items added
        private int count;
        // Fixed cart ID
        private final String cartId;
        // Constructor
        public Cart(String cartId, int size) {
            this.cartId = cartId;
            prices = new double[size];
            count = 0;
        }
        // Add item price
        public void addItem(double price) {
            if(count < prices.length) {
                prices[count] = price;
                count++;
            }
        }
        // Calculate total whenever requested
        public double getTotal() {
            double total = 0;
            for(int i = 0; i < count; i++) {
                total += prices[i];
            }
            return total;
        }
        // Return item count
        public int getItemCount() {
            return count;
        }
        // Read-only cart ID
        public String getCartId() {
            return cartId;
        }
    }
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5",20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println("Total: " + cart.getTotal());
        System.out.println("Items: " + cart.getItemCount());
    }
}
