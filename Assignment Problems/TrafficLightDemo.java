public class TrafficLightDemo {
    static class TrafficLight {
        // Private current color
        private String color;
        // Fixed ID
        private final String id;
        // Constructor
        public TrafficLight(String id) {
            this.id = id;
            // Every light starts with RED
            this.color = "RED";
        }
        // Move to next color
        public void next() {
            if(color.equals("RED")) {
                color = "GREEN";
            }
            else if(color.equals("GREEN")) {
                color = "YELLOW";
            }
            else {
                color = "RED";
            }
        }
        // Read-only color access
        public String getColor() {
            return color;
        }
        public String getId() {
            return id;
        }
    }
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println(t.getColor());
        t.next();
        System.out.println(t.getColor());
        t.next();
        System.out.println(t.getColor());
        t.next();
        System.out.println(t.getColor());
    }
}
