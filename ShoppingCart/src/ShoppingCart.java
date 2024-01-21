import java.util.HashMap;
import java.util.Map;

class ShoppingCart {
    private Map<String, Item> cartItems;

    public ShoppingCart() {
        this.cartItems = new HashMap<>();
    }


    public void addItem(Item item) {
          cartItems.put(item.getName(), item);
//        incase user again added same product then prev object will be override so no need to handle that case here
    }


    public void removeItem(String itemName) {
        if(cartItems.containsKey(itemName)) {
            cartItems.remove(itemName);
        }else {
            System.out.println("Item does Not Exits !");
        }
    }


    public void updateQuantity(String itemName, int newQuantity) {
        if (cartItems.containsKey(itemName)) {
            Item item = cartItems.get(itemName);
            item.setQuantity(newQuantity);
        }else {
            System.out.println("Item does Not Exits !");
        }
    }


    public void viewCart() {
        if(cartItems.size()==0){
            System.out.println("Cart is Empty");
            return;
        }
        double totalPrice = 0.0;
        System.out.println("_________Items in Cart:___________");
        for (Item item : cartItems.values()) {
            System.out.println(item);
            totalPrice += item.calculateTotalPrice();
        }
        System.out.println("Total Price: $" + totalPrice);
        System.out.println("\n__________________________________");
    }


    public void checkout() {
        System.out.println("Checkout Summary:");
        viewCart();
        cartItems.clear();
    }
}
