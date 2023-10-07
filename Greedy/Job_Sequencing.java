import java.util.*;
public class Job_Sequencing {

    // Job Sequencing Problem

    // In this solution, we will convert the Job Information into class and store it using ArrayList

    static class Job {
        int deadline;
        int profit;
        int id;
        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String args[]) {

        int job[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        ArrayList<Job> jobs = new ArrayList<>();

        for(int i=0; i<job.length; i++)
            jobs.add(new Job(i, job[i][0], job[i][1]));

        // Collections.sort(jobs, (a, b) -> a.profit - b.profit); // Ascending order of profits
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit); // Descending order of profits

        // Here we are sorting objects by defining a custom comparator
        // The statement as the second argument above is a lambda function
        // Lambda function is basically a shortform for writing any comparator

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for(int i=0; i<jobs.size(); i++) {
            Job curr = jobs.get(i);
            if(curr.deadline > time) {
                seq.add(curr.id);
                time++;
            }
        }

        System.out.println("Max jobs: " + seq.size());
        for(int i=0; i<seq.size(); i++) 
            System.out.print(seq.get(i) + " ");
                
    }
}
