public class HealthBarDemo {
    static class Character {
        // Private health variable
        private int health;
        // Maximum health cannot be changed
        private final int maxHealth;
        // Constructor
        public Character(int maxHealth) {
            this.maxHealth = maxHealth;
            this.health = maxHealth;
        }
        // Reduce health
        public void takeDamage(int amount) {
            if(amount > 0) {
                health -= amount;
                // Health cannot go below zero
                if(health < 0) {
                    health = 0;
                }
            }
        }
        // Increase health
        public void heal(int amount) {
            if(amount > 0) {
                health += amount;
                // Health cannot exceed maximum
                if(health > maxHealth) {
                    health = maxHealth;
                }
            }
        }
        // Read-only health access
        public int getHealth() {
            return health;
        }
    }
    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println("Health after damage: " + c.getHealth());
        c.heal(50);
        System.out.println("Health after healing: " + c.getHealth());
        c.takeDamage(150);
        System.out.println("Health after huge damage: " + c.getHealth());
    }
}
