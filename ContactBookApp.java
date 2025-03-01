import java.util.Scanner;

class Contact {
    String name;
    String phone;
    String email;
    Contact next;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.next = null;
    }
}

class ContactBook {
    private Contact head;

    public void addContact(String name, String phone, String email) {
        Contact newContact = new Contact(name, phone, email);
        if (head == null) {
            head = newContact;
        } else {
            Contact temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newContact;
        }
        System.out.println("Contact added successfully.");
    }

    public void deleteContact(String name) {
        if (head == null) {
            System.out.println("Contact list is empty.");
            return;
        }
        if (head.name.equals(name)) {
            head = head.next;
            System.out.println("Contact deleted.");
            return;
        }
        Contact temp = head;
        while (temp.next != null && !temp.next.name.equals(name)) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Contact not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Contact deleted.");
        }
    }

    public void searchByName(String name) {
        Contact temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("Name: " + temp.name + ", Phone: " + temp.phone + ", Email: " + temp.email);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Contact not found.");
    }

    public void searchByEmail(String email) {
        Contact temp = head;
        while (temp != null) {
            if (temp.email.equalsIgnoreCase(email)) {
                System.out.println("Name: " + temp.name + ", Phone: " + temp.phone + ", Email: " + temp.email);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Contact not found.");
    }

    public void printContacts() {
        if (head == null) {
            System.out.println("Contact list is empty.");
            return;
        }
        Contact temp = head;
        while (temp != null) {
            System.out.println("Name: " + temp.name + ", Phone: " + temp.phone + ", Email: " + temp.email);
            temp = temp.next;
        }
    }
}

public class ContactBookApp {
    public static void main(String[] args) {
        ContactBook book = new ContactBook();
        Scanner scanner = new Scanner(System.in);
        char choice;
        
        do {
            System.out.println("\n**********************");
            System.out.println("(A)dd");
            System.out.println("(D)elete");
            System.out.println("(E)mail Search");
            System.out.println("(P)rint List");
            System.out.println("(S)earch");
            System.out.println("(Q)uit");
            System.out.println("**********************");
            System.out.print("Please enter a command: ");
            choice = scanner.next().charAt(0);
            scanner.nextLine();  // Consume newline

            switch (Character.toUpperCase(choice)) {
                case 'A':
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    book.addContact(name, phone, email);
                    break;
                case 'D':
                    System.out.print("Enter name to delete: ");
                    name = scanner.nextLine();
                    book.deleteContact(name);
                    break;
                case 'E':
                    System.out.print("Enter email to search: ");
                    email = scanner.nextLine();
                    book.searchByEmail(email);
                    break;
                case 'P':
                    book.printContacts();
                    break;
                case 'S':
                    System.out.print("Enter name to search: ");
                    name = scanner.nextLine();
                    book.searchByName(name);
                    break;
                case 'Q':
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        } while (Character.toUpperCase(choice) != 'Q');

        scanner.close();
    }
}

