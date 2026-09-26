public class NameTagDemo {

    static class NameTag {

        // Final fields
        private final String firstName;
        private final String lastName;

        // Constructor
        public NameTag(String fullName) {
            String[] parts = fullName.split(" ");
            firstName = parts[0];
            lastName = parts[1];
        }

        // Return nickname
        public String getNickname() {
            return firstName + " " + lastName.charAt(0) + ".";
        }
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname());
    }
}
