import java.util.ArrayList;
import java.util.Scanner;

// Class representing a Gym Member
class GymMember {
    private int memberId;
    private String name;
    private String membershipType;
    private double monthlyFee;

    public GymMember(int memberId, String name, String membershipType, double monthlyFee) {
        this.memberId = memberId;
        this.name = name;
        this.membershipType = membershipType;
        this.monthlyFee = monthlyFee;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public void displayMemberInfo() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + name);
        System.out.println("Membership Type: " + membershipType);
        System.out.println("Monthly Fee: Rs." + monthlyFee);
        System.out.println("----------------------");
    }
}

// Class representing the Gym Management System
class GymManagement {
    private ArrayList<GymMember> members = new ArrayList<>();
    private int nextMemberId = 1;

    public int addMember(String name, String membershipType, double monthlyFee) {
        GymMember newMember = new GymMember(nextMemberId++, name, membershipType, monthlyFee);
        members.add(newMember);
        System.out.println("New member added successfully!");
        return newMember.getMemberId();  // Return the new member's ID
    }

    public void viewMember(int memberId) {
        for (GymMember member : members) {
            if (member.getMemberId() == memberId) {
                member.displayMemberInfo();
                return;
            }
        }
        System.out.println("Member ID not found.");
    }

    public void displayAllMembers() {
        if (members.isEmpty()) {
            System.out.println("No members to display.");
            return;
        }
        System.out.println("List of all gym members:");
        for (GymMember member : members) {
            member.displayMemberInfo();
        }
    }
}


// Main class for running the gym membership management system
public class demo1{
    public static void main(String[] args) {
        GymManagement gym = new GymManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Gym Membership System ===");
            System.out.println("1. Add New Member");
            System.out.println("2. View Member Details");
            System.out.println("3. Display All Members");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter membership type (Basic/Premium): ");
                    String membershipType = scanner.nextLine();
                    System.out.print("Enter monthly fee: ");
                    double monthlyFee = scanner.nextDouble();
                    
                    int newMemberId = gym.addMember(name, membershipType, monthlyFee);
                    System.out.println("Your ID is: " + newMemberId);  // Print the new member ID
                    break;
                    
                case 2:
                    System.out.print("Enter Member ID: ");
                    int memberId = scanner.nextInt();
                    gym.viewMember(memberId);
                    break;
                    
                case 3:
                    gym.displayAllMembers();
                    break;
                    
                case 4:
                    System.out.println("Exiting the system.");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

