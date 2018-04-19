import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
 * where h is the height of the person and k is the number of people in front of this person who have a height greater
 * than or equal to h. Write an algorithm to reconstruct the queue.
 *
 * Note:
 * The number of people is less than 1,100.
 *
 * Example
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 */
public class QueueReconstructionLeetCode {

    public static int[][] reconstructQueue(int[][] people) {
        //sorting by first element and second in case of tie in first
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0]!=o2[0])
                    return o1[0]-o2[0];
                else
                    return o1[1]-o2[1];
            }
        });

        //after ith iteration of outter loop, if result[j][0]=-1 then a greater or equal element will take the place
        //in next iterations.
        int[][] result = new int[people.length][2];
        for(int[] i:result) Arrays.fill(i,-1);
        for(int i=0;i<people.length;i++){
            int k=0;
            for(int j=0;j<people.length;j++){
                if(result[j][0]==-1 && k==people[i][1]){
                    result[j]=people[i];
                    break;
                }
                else if(result[j][0]==-1 || result[j][0]==people[i][0])
                    k++;
            }
        }
        return result;
    }

    public static void main(String args[]){
        int[][] result = reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
        for(int[] arr: result){
            System.out.println(arr[0]+","+arr[1]+" ");
        }
    }
}
