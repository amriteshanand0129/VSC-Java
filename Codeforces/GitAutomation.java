import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GitAutomation {
    private static final String REPO_PATH = "C:/Users/Amritesh Anand/VS Code/JAVA";  // Change this to your repo's path
    private static final String REMOTE_NAME = "origin";  // Default remote repository name
    private static final String BRANCH_NAME = "master";    // Change this to your branch name if different
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd yyyy");

    public static void main(String[] args) {
        try {
            // Step 1: Get a list of modified files
            String modifiedFiles = getModifiedFiles();
            
            // Step 2: Create commit message with current date and modified files
            String commitMessage = generateCommitMessage(modifiedFiles);
            System.out.println(commitMessage);
            
            // Step 3: Run git commands to add, commit, and push
            runGitCommand("git add .");
            runGitCommand("git commit -m \"" + commitMessage + "\"");
            runGitCommand("git push " + REMOTE_NAME + " " + BRANCH_NAME);
            
            System.out.println("Changes committed and pushed successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Function to generate the commit message
    private static String generateCommitMessage(String modifiedFiles) {
        String date = dateFormat.format(new Date());
        return date + ": " + modifiedFiles;
    }

    // Function to get the list of modified files
    private static String getModifiedFiles() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("git", "status", "--short");
        processBuilder.directory(new File(REPO_PATH));
        Process process = processBuilder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder fileList = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            // Format: M path/to/modified/file or A path/to/added/file
            if(line.contains("Codeforces")) {

                fileList.append(line.substring(line.lastIndexOf('/')+1, line.indexOf('.')).replace("_", " ")).append(", ");
            }
        }

        if (fileList.length() > 0) {
            fileList.setLength(fileList.length() - 2);  // Remove last comma
        } else {
            fileList.append("No files modified");
        }
        
        return fileList.toString();
    }

    // Function to run git commands
    private static void runGitCommand(String command) throws IOException, InterruptedException {
        System.out.println("Running command: " + command);
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        processBuilder.directory(new File("C:/Users/Amritesh Anand/VS Code/JAVA"));
        Process process = processBuilder.start();
        process.waitFor();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}