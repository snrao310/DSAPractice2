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
        if(people.length==0) return people;
        int[][] result = new int[people.length][2];
        Arrays.fill(result,new int[]{-1,-1});
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[]o2){
                if(o1[0]==o2[0])
                    return o2[1]-o1[1];
                return o1[0]-o2[0];
            }
        });
        for(int i=0;i<people.length;i++){
            for(int j=0, k=-1;j<result.length;j++){ ;
                if(result[j][0]==-1 && result[j][1]==-1)
                    k++;
                if(k==people[i][1]){
                    result[j]=people[i];
                    break;
                }
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
