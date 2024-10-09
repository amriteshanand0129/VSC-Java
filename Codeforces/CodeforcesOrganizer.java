import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CodeforcesOrganizer {

    // Base directory where your Codeforces problems are stored
    private static final String BASE_DIR = "Codeforces"; // Change this to your Codeforces folder path
    private static final String LOG_FILE = BASE_DIR + "/log.md";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get the details of the problem from the user
        System.out.print("Enter Contest Number: ");
        String contestNumber = scanner.nextLine();

        System.out.print("Enter Division (2, 3, or 4): ");
        String division = scanner.nextLine();

        System.out.print("Enter Problem ID (A, B, C, D): ");
        String problemID = scanner.nextLine();

        System.out.print("Enter Problem Name: ");
        String problemName = scanner.nextLine();

        System.out.print("Enter Problem Link: ");
        String problemLink = scanner.nextLine();

        // Step 2: Create the file and directory structure
        createProblemFile(division, problemID, problemName, contestNumber, problemLink);

        // Close the scanner
        scanner.close();
    }

    // Function to create the problem file with boilerplate
    private static void createProblemFile(String division, String problemID, String problemName, String contestNumber,
            String problemLink) {
        // Create the directory structure (Division -> Problem ID)
        String divisionDir = BASE_DIR + "/Division " + division + "/" + problemID;
        File directory = new File(divisionDir);
        if (!directory.exists()) {
            directory.mkdirs(); // Create directory if it doesn't exist
        }

        // Create the Java file with the proper name
        String fileName = problemName.replace(" ", "_") + ".java";
        File problemFile = new File(divisionDir + "/" + fileName);

        try {
            // If the file doesn't exist, create it and add boilerplate
            if (problemFile.createNewFile()) {
                // Add a comment with problem details at the top of the file
                FileWriter writer = new FileWriter(problemFile);
                writer.write("/**\n");
                writer.write(" * Codeforces Round " + contestNumber + " Division " + division);
                writer.write("\n * " + problemName + "\n");
                writer.write(" * Link: " + problemLink + "\n");
                writer.write(" */\n\n");
                writer.write("import java.util.*;\n");
                writer.write("public class " + fileName.replace(".java", "") + " {\n");
                writer.write("    public static void main(String[] args) {\n");
                writer.write("        Scanner in = new Scanner(System.in);\n");
                writer.write("        int T = in.nextInt();\n");
                writer.write("        for(int t=0; t<T; t++) {\n");
                writer.write("        \n\t\t}\n");
                writer.write("        in.close();\n");
                writer.write("    }\n");
                writer.write("}\n");
                writer.close();

                System.out.println("Problem file created: " + problemFile.getPath());

                // Step 3: Update the log.md file
                updateLogFile(division, problemID, problemName, contestNumber, problemLink);
            } else {
                System.out.println("File already exists: " + problemFile.getPath());
            }
        } catch (IOException e) {
            System.err.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    // Function to update the log.md file with problem information
    private static void updateLogFile(String division, String problemID, String problemName, String contestNumber,
            String link) {
        try {
            // Get today's date in the format "yyyy-MM-dd"
            String todayDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

            // Read the content of the log.md file into a String
            File logFile = new File(LOG_FILE);
            StringBuilder logContent = new StringBuilder();

            if (logFile.exists()) {
                // If the log.md file exists, read its current content
                BufferedReader reader = new BufferedReader(new FileReader(logFile));
                String line;
                while ((line = reader.readLine()) != null) {
                    logContent.append(line).append("\n");
                }
                reader.close();
            }

            // Check if today's date is already in the log file
            if (!logContent.toString().contains(todayDate)) {
                // If today's date is not found, append the date to the log file
                logContent.append("\n## ").append(todayDate).append("\n\n");
            }

            String data = String.format("| Contest %-4s | Division %-1s | %-1s | %-30s | %-50s |\n", contestNumber, division, problemID, problemName, link);
            // Append the new problem to today's section
            logContent.append(data);
            // Write the updated log content back to the log.md file
            FileWriter logWriter = new FileWriter(logFile);
            logWriter.write(logContent.toString());
            logWriter.close();

            System.out.println("log.md updated successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while updating log.md.");
            e.printStackTrace();
        }
    }
}
