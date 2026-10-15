package trayholder;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TrayHolder {

    static void queue() {
        Scanner scanner = new Scanner(System.in);
        Quee q = new Quee();

        while (true) {
            System.out.println("\nQueue Operations:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Size");
            System.out.println("6. Exit");

            System.out.print("Choose an operation (1-6): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name of the item: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter weight of the item: ");
                    int weight = Kbint();

                    LocalDate myObj = LocalDate.now();
                    String datein = myObj.getYear() + "-" + myObj.getMonthValue() + "-" + myObj.getDayOfMonth();
                    System.out.println("Entered date: " + datein);

                    String dateexp = DateExp(datein);

                    Tray item = new Tray(name, weight, datein, dateexp);

                    q.enqueue(item);
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.peek();
                    break;
                case 4:
                    q.display();
                    break;
                case 5:
                    q.size();
                    break;
                case 6:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    static void stack() {
        Stack s = new Stack();

        System.out.println("Hello World!");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1: Push");
            System.out.println("2:Pop");
            System.out.println("3:Peak");
            System.out.println("4:Display");
            System.out.println("5:Exit");

            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name of the item: ");
                    String name = sc.nextLine();

                    System.out.print("Enter weight of the item: ");
                    int weight = Kbint();

                    LocalDate myObj = LocalDate.now();
                    String datein = myObj.getYear() + "-" + myObj.getMonthValue() + "-" + myObj.getDayOfMonth();
                    System.out.println("Entered date: " + datein);

                    String dateexp = DateExp(datein);
                    Tray item = new Tray(name, weight, datein, dateexp);

                    s.push(item);
                    break;

                case 2:
                    s.pop();
                    break;

                case 3:
                    s.peek();
                    break;

                case 4:
                    s.display();
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        }

    }

    static int Kbint() {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print("Enter a positive number: ");
                number = sc.nextInt();          // tries to read an integer

                if (number <= 0) {
                    throw new IllegalArgumentException("Number must be positive (greater than 0)!");
                }

                // If we reach here → input is valid
                valid = true;
                System.out.println("You entered a valid positive number: " + number);

            } catch (InputMismatchException e) {
                // User typed a string / letters / symbols
                System.out.println("Error: Please enter a number, not text!");
                sc.nextLine();  // clear the invalid input from the buffer
            } catch (IllegalArgumentException e) {
                // User entered 0 or a negative number
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
        return number;
    }
    

    static String DateExp(String datein) {
        Scanner scanner = new Scanner(System.in);
        int gap;
        String dateexp;
        while (true) {
            System.out.print("Enter date of expire(YYYY-MM-DD): ");
            dateexp = scanner.nextLine();
            String[] myArray = dateexp.split("-");
            String[] myArray1 = datein.split("-");

            int inDay = Integer.parseInt(myArray[2]);
            int expDay = Integer.parseInt(myArray1[2]);
            int inM = Integer.parseInt(myArray1[1]);
            int expM = Integer.parseInt(myArray[1]);
            int inY = Integer.parseInt(myArray1[0]);
            int expY = Integer.parseInt(myArray[0]);

            gap = (expY - inY) * 365 + (expM - inM) * 30 + expDay - inDay;

            if (gap <= 14 && gap > 0) {
                break;
            }

            System.out.println("Expiry must be within 14 days, check it and try again please.");
        }
        return dateexp;
    }

    public static class Tray {

        private String Name, Date, DateExp;
        private int Weight;

        public Tray(String name, int weight, String date, String dateexp) {
            this.Name = name;
            this.Date = date;
            this.DateExp = dateexp;
            this.Weight = weight;
        }
    }

    public static class Stack {

        private Tray[] stack;
        private int top, size;

        public Stack() {
            this.size = 8;
            this.stack = new Tray[8];
            this.top = -1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == size - 1;
        }

        public void push(Tray newTray) {
            if (isFull()) {
                System.out.println("Tray holder is full!");
            } else {
                top++;
                stack[top] = newTray;
            }
        }

        public void pop() {
            if (isEmpty()) {
                System.out.println("Tray holder is empty!");
            } else {
                top--;
            }
        }

        public void peek() {
            if (isEmpty()) {
                System.out.println("Tray holder is empty!");
            } else {
                System.out.println("Tray " + top + ":");
                System.out.println("    Name of item: " + stack[top].Name + " ");
                System.out.println("    Weight of item: " + stack[top].Weight + "g ");
                System.out.println("    Date of instert into holder: " + stack[top].Date + " ");
                System.out.println("    Date of item expire: " + stack[top].DateExp + " ");
            }
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
            } else {
                for (int i = 0; i <= top; i++) {
                    System.out.println("Tray " + i + ":");
                    System.out.println("    Name of item: " + stack[i].Name + " ");
                    System.out.println("    Weight of item: " + stack[i].Weight + "g ");
                    System.out.println("    Date of instert into holder: " + stack[i].Date + " ");
                    System.out.println("    Date of item expire: " + stack[i].DateExp + " ");

                }
                System.out.println();
            }
        }

    }

    public static class Quee {

        private Tray[] quee;
        private int front, rear, size;

        public Quee() {
            this.size = 8;
            this.quee = new Tray[8];
            this.front = 0;
            this.rear = -1;
        }

        public boolean isEmpty() {
            return front == -1;
        }

        public boolean isFull() {
            return rear == size - 1;
        }

        public void enqueue(Tray newtray) {
            if (isFull()) {
                System.out.println("Tray holder is full!");
            } else if (isEmpty() || rear == size - 1) {
                quee[front] = newtray;
                if (rear == size - 1) {
                    front--;
                } else {
                    rear++;
                }
                System.out.println("Tray added.");
            } else if (rear < size - 1) {
                rear++;
                for (int i = rear; i > 0; i--) {
                    quee[i + 1] = quee[i];
                }

                quee[0] = newtray;
                System.out.println("Tray added.");
            }
        }

        public void dequeue() {
            if (isEmpty()) {
                System.out.println("Tray holder is empty!");
            } else {
                front++;
                for (int i = rear; i > 1; i--) {
                    quee[rear] = quee[rear - 1];
                }
                System.out.println("Tray removed from the holder.");
            }
        }

        public void peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
            } else {
                System.out.println("Tray " + rear + ":");
                System.out.println("    Name of item: " + quee[rear].Name + " ");
                System.out.println("    Weight of item: " + quee[rear].Weight + "g ");
                System.out.println("    Date of instert into holder: " + quee[rear].Date + " ");
                System.out.println("    Date of item expire: " + quee[rear].DateExp + " ");
            }
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
            } else {
                for (int i = front; i <= rear; i++) {
                    System.out.println("Tray " + i + ":");
                    System.out.println("    Name of item: " + quee[i].Name + " ");
                    System.out.println("    Weight of item: " + quee[i].Weight + "g ");
                    System.out.println("    Date of instert into holder: " + quee[i].Date + " ");
                    System.out.println("    Date of item expire: " + quee[i].DateExp + " ");

                }
                System.out.println();
            }
        }

        public void size() {
            if (isEmpty()) {
                System.out.println("Queue size: 0");
            } else {
                System.out.println("Queue size: " + (rear - front + 1));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter the size of the queue: ");
//        int size = scanner.nextInt();
        while (true) {

            System.out.println("1: Stack structure.");
            System.out.println("2: Queue structure.");
            System.out.println("3: Exit from system");

            System.out.print("Choose an operation (1-3): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    stack();
                    break;
                case 2:
                    queue();
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
