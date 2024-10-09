public class Kadanes_Algo {
    public static void main(String args[]){
        int numbers[] = {4, 2, 0, 6, 3, 2, 5};
        kadanes(numbers);
    }
    public static void kadanes(int numbers[]){
        int l = numbers.length;
        int leftmax[]=new int[7];
        int rightmax[]=new int[7];
        leftmax[0]=numbers[0];
        for(int i=1;i<l;i++){
            if(leftmax[i-1]>numbers[i])
                leftmax[i]=leftmax[i-1];
            else
                leftmax[i]=numbers[i];
        }
        rightmax[l-1]=numbers[l-1];
        for(int i=l-2;i>=0;i--){
            if(rightmax[i+1]>numbers[i])
                rightmax[i]=rightmax[i+1];
            else
                rightmax[i]=numbers[i];
        }
        int maxlevel, waterlevel, sum=0;
        for(int i=0;i<l;i++){
            maxlevel=Math.min(rightmax[i], leftmax[i]);
            waterlevel = maxlevel-numbers[i];
            System.out.println(waterlevel);
            sum+=waterlevel;
        }System.out.println(sum);
    }
}