class Rainwater {
    public static void main(String args[]){
        int heights[] = {4, 2, 0, 6, 3, 2, 5};
        trappedRainwater(heights);
    }
    public static void trappedRainwater(int heights[]){
        int l = heights.length;
        int leftmax[]=new int[l];
        int rightmax[]=new int[l];

        // Assigning values of maximum left boundary for each bar
        leftmax[0]=heights[0];
        for(int i=1;i<l;i++){
            leftmax[i] = Math.max(heights[i], leftmax[i-1]);
        }

        // Assigning values of maximum right boundary for each bar
        rightmax[l-1]=heights[l-1];
        for(int i=l-2;i>=0;i--){
            rightmax[i] = Math.max(heights[i], rightmax[i+1]);
        }

        // Calculating maximum water that can be trapped above each bar
        int waterlevel, trappedwater, sum=0;
        for(int i=0;i<l;i++){
            waterlevel = Math.min(rightmax[i], leftmax[i]);
            trappedwater = waterlevel-heights[i];
            System.out.println(trappedwater);
            sum += trappedwater;
        }System.out.println("Total rainwater that can be trapped: " + sum);
    }
}
