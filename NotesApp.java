import java.io.*;
import java.util.Scanner;
import java.util.concurrent.Future;

import javax.swing.text.View;

public class NotesApp {

    static final String FILE_NAME = "notes.txt";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n📝 Notes Manager - Java File I/O");
            System.out.println("1. Write a New Note");
            System.out.println("2. View All Notes");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> writeNote();
                case 2 -> readNotes();
                case 3 -> System.out.println("👋 Exiting... Thank you!");
                default -> System.out.println("⚠️ Invalid choice! Try again.");
            }
        } while (choice != 3);
    }
//  Exception block try with catch
    static void writeNote() {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            System.out.print("Enter your note: ");
            String note = scanner.nextLine();
            fw.write(note + "\n");
            System.out.println("✅ Note saved successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error writing to file: " + e.getMessage());
        }
    }

    static void readNotes() {
        System.out.println("\n📖 All Notes:");
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int count = 1;
            while ((line = br.readLine()) != null) {
                System.out.println(count++ + ". " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("⚠️ No notes found. Start by writing a note.");
        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }
    }
}



// # 📝 Java Notes Manager - File I/O Project

// > A simple CLI-based notes manager in Java using FileWriter and BufferedReader to demonstrate Java File I/O operations.

// ---

// ## 🚀 Features

// ✅ Write and save notes to a `.txt` file  
// 📖 View all previously saved notes  
// 💾 Persistent storage using FileWriter & BufferedReader  
// 🧠 Practice File Handling, Input/Output, and Exception Handling in Java

// ---

// ## 📂 Project Structure

// 🛠️ Future Enhancements
// Add option to delete specific notes

// Add timestamps for each note

// Add search functionality

// 📄 License
// This project is open source under the MIT License.

// 👨‍💻 Author
// Gagan Tiwari
// 📧 your-email@example.com
// 📍 India | 💼 MCA Student
// 🔗 LinkedIn | 🔗 GitHub
