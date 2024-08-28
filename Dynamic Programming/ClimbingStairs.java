class ClimbingStairs {

    // Climbing Stairs using Memoization
    public static int countWays(int n, int[] ways) {
        if(n == 1 || n == 2) // This base case will not work for variations like if taking 3 or 4 steps at a time is allowed
            return n;
        /**
         * For variations e.g Apart from 1 and 2, 3 and 4 steps can be taken at a time
         * The following base will work without any modification
         * if(n == 0)
         *     return 1;
         * else if(n < 0)
         *      return 0;
         * 
         * Explanation: 1 way to reach 0th stair -> take no step
         *              0 ways to go negative stair  -> not possible
         */
        if(ways[n] != 0)
            return ways[n];
        ways[n] = countWays(n-1, ways) + countWays(n-2, ways);
        return ways[n];    
    }

    // Climbing Stairs using Tabulation
    public static int countWaysTabulation(int n, int[] table) {
        table[0] = 1;
        table[1] = 1;
        for(int step = 2; step<=n; step++) 
            table[step] = table[step-1] + table[step-2];
        return table[n];
    }
    public static void main(String args[]) {
        int stairs = 6;
        System.out.printf("Number of ways to climb %d stairs\n", stairs);

        int ways[] = new int[stairs+1];
        System.out.println("Memoization: " + countWays(stairs, ways));
        
        int[] table = new int[stairs+1];
        System.out.println("Tabulation: " + countWaysTabulation(stairs, table));
        
        /**
         * ways[i], table[i] represents number of ways to reach the i'th stair
         */
    }
}