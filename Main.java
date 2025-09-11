public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Kendra", "Morris", 2026, "Computer Science");
        Student s2 = new Student("Madeleine", "Garcia", 2024, "Biology");

        System.out.println("Students:");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println();

        Planet earth = new Planet("Earth", 149_600_000.0, 1.0);
        Planet mars = new Planet("Mars", 227_940_000.0, 0.379);

        System.out.println("Planets:");
        System.out.println(earth);
        System.out.println(mars);
        System.out.println();

        Customer cust = new Customer("Scotty", "Tackett");
        Account acc1 = new Account(cust, 1250.75);
        Account acc2 = new Account(cust, 4200.00);

        System.out.println("Bank Accounts:");
        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println();

        SeatAssignment seatA = new SeatAssignment(12, 'F');
        SeatAssignment seatB = new SeatAssignment(4, 'A');

        Ticket ticket1 = new Ticket("Houston", "New York", "AA123", seatA);
        Ticket ticket2 = new Ticket("Los Angeles", "Tokyo", "JL062", seatB);

        System.out.println("Airline Tickets:");
        System.out.println(ticket1);
        System.out.println(ticket2);
    }
}

class Student {
    private final String firstName;
    private final String lastName;
    private final int classYear;
    private final String major;

    public Student(String firstName, String lastName, int classYear, String major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.classYear = classYear;
        this.major = major;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getClassYear() { return classYear; }
    public String getMajor() { return major; }

    @Override
    public String toString() {
        return String.format("%s %s, Class of %d, Major: %s",
                firstName, lastName, classYear, major);
    }
}

class Planet {
    private final String name;
    private final double distanceFromSunKm;
    private final double gravityRelativeToEarth;

    public Planet(String name, double distanceFromSunKm, double gravityRelativeToEarth) {
        this.name = name;
        this.distanceFromSunKm = distanceFromSunKm;
        this.gravityRelativeToEarth = gravityRelativeToEarth;
    }

    public String getName() { return name; }
    public double getDistanceFromSunKm() { return distanceFromSunKm; }
    public double getGravityRelativeToEarth() { return gravityRelativeToEarth; }

    @Override
    public String toString() {
        return String.format("%s: distance from sun = %.1f km, gravity = %.3f g",
                name, distanceFromSunKm, gravityRelativeToEarth);
    }
}

class Customer {
    private final String firstName;
    private final String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

class Account {
    private final Customer owner;
    private double balance;

    public Account(Customer owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public Customer getOwner() { return owner; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Account(owner=%s, balance=$%.2f)", owner, balance);
    }
}

class SeatAssignment {
    private final int row;
    private final char seatLetter;

    public SeatAssignment(int row, char seatLetter) {
        this.row = row;
        this.seatLetter = seatLetter;
    }

    public int getRow() { return row; }
    public char getSeatLetter() { return seatLetter; }

    @Override
    public String toString() {
        return row + String.valueOf(seatLetter);
    }
}

class Ticket {
    private final String departureCity;
    private final String arrivalCity;
    private final String flightNumber;
    private final SeatAssignment seat;

    public Ticket(String departureCity, String arrivalCity, String flightNumber, SeatAssignment seat) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.flightNumber = flightNumber;
        this.seat = seat;
    }

    public String getDepartureCity() { return departureCity; }
    public String getArrivalCity() { return arrivalCity; }
    public String getFlightNumber() { return flightNumber; }
    public SeatAssignment getSeat() { return seat; }

    @Override
    public String toString() {
        return String.format("Flight %s: %s -> %s, Seat %s",
                flightNumber, departureCity, arrivalCity, seat);
    }
}