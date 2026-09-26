import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    interface Item {
        LocalDate dueDate(LocalDate current);
    }

    static class Book implements Item {
        public LocalDate dueDate(LocalDate current) {
            return current.plusDays(14);
        }
    }

    static class DVD implements Item {
        public LocalDate dueDate(LocalDate current) {
            return current.plusDays(7);
        }
    }

    static class Magazine implements Item {
        public LocalDate dueDate(LocalDate current) {
            return current.plusDays(3);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Map<String, Item> items = new HashMap<>();
        items.put("BOOK", new Book());
        items.put("DVD", new DVD());
        items.put("MAGAZINE", new Magazine());

        LocalDate current = LocalDate.of(2023, 10, 26);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int spaceIdx = line.indexOf(' ');
            String type = line.substring(0, spaceIdx);
            String title = line.substring(spaceIdx + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            Item item = items.get(type);
            LocalDate due = item.dueDate(current);
            System.out.println(title + ": " + due.format(fmt));
        }
    }
}
