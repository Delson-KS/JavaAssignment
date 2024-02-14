import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void menu() {
        boolean menu_exit ;
        boolean row = true;
        DbFunctions db = new DbFunctions();
        Scanner in = new Scanner(System.in);
        int user_input;
        while (menu_exit = true) {
            for (int i = 0; i < 18; i++) {
                System.out.print("_");
            }
            System.out.println("\n1.View time table \n2.Add subject to dashboard \n3.View assignment table\n4.Change assignments\n5.Delete lesson from dashboard\n6.Change lesson\n7.Exit");
            for (int i = 0; i < 18; i++) {
                System.out.print("_");
            }
            System.out.println();
            user_input = in.nextInt();
            if (user_input == 1) {
                db.print_table_dashboard("dashboard");
            }
            if (user_input == 2) {
                while (row == true) {

                    System.out.println("Which day? \n1.Monday \n2.Tuesday \n3.Wednesday \n4.Thursday\n5.Friday\n");

                    int choose = in.nextInt();
                    String day = null;
                    if (choose == 1) {
                        day = "Monday";
                    }
                    if (choose == 2) {
                        day = "Tuesday";
                    }
                    if (choose == 3) {
                        day = "Wednesday";
                    }
                    if (choose == 4) {
                        day = "Thursday";
                    }
                    if (choose == 5) {
                        day = "Friday";
                    }

                    if (day != null) {
                        System.out.println("Subject name: ");

                        String sub_name = in.next();

                        System.out.println("Inserted " + sub_name);

                        System.out.println("Teacher name: ");
                        String teacher_name = in.next();

                        System.out.println("Inserted " + teacher_name);

                        System.out.println("Classroom: ");
                        String classroom = in.next();
                        System.out.println("Inserted " + classroom);


                        db.insert_row_to_dashboard("dashboard", day, sub_name, teacher_name, classroom);
                        System.out.println("Add more?\n1.Yes\n2.No");
                        if (in.nextInt() == 1) {
                            row = true;
                        } else {
                            row = false;
                        }
                    }
                }
            }
            if (user_input == 3) {
                db.print_table_assignments("Assignments");
            }
            if (user_input == 4) {
                db.print_table_assignments("Assignments");
                System.out.println("Have you 1.finished or \n2.add");
                int choice = in.nextInt();
                if (choice == 1) {
                    System.out.println("Which one?");
                    int index = in.nextInt();
                    db.delete_row_by_id("Assignments", index);
                    System.out.println("Deleted");
                }
                if (choice == 2) {
                    System.out.println("Subject name");
                    String sub_name = in.next();
                    System.out.println("Deadline ");
                    String deadline = in.next();
                    db.insert_assignments("Assignments", sub_name, deadline);
                }
            }
            if (user_input == 5) {
                while(row) {
                    System.out.println("Which subject do u wanna delete?");
                    String sub_name = in.next();
                    db.delete_row_by_name("dashboard", sub_name);
                    System.out.println("again?\n1.Yes\n2.No");
                    if (in.nextInt() == 1) {
                        row = true;
                    } else {
                        row = false;
                    }
                }
            }
            if (user_input == 6) {
                System.out.println("which one to replace");
                String sub_name = in.next();
                db.delete_row_by_name("dashboard", sub_name);
                System.out.println("changed");
            }
            if (user_input == 7) {
                System.out.println("bb!");
                break;
            }

        }
    }


    public static void main(String[] args) {
        menu();
    }

}

