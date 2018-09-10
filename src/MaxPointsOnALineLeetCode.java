import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.function.ObjDoubleConsumer;

/**
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 */
public class MaxPointsOnALineLeetCode {

    public static class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    public static int maxPoints(Point[] points) {
        if(points.length==0) return 0;
        int max=1;
        for(int i=0;i<points.length;i++){
            Point cur = points[i];
            int duplicates=0;
            int curMax=1;
            HashMap<Pair,Integer> slopeCount = new HashMap<>();
            for(int j=i+1;j<points.length;j++){
                if(points[j].x==cur.x && points[j].y==cur.y)
                    duplicates++;
                else {
                    Pair slope = new Pair(cur.y - points[j].y, cur.x - points[j].x);
                    slopeCount.put(slope, slopeCount.getOrDefault(slope, 1) + 1);
                    curMax = Math.max(curMax, slopeCount.get(slope));
                }
            }
            max=Math.max(curMax+duplicates,max);
        }
        return max;
    }

    private static class Pair{
        int y;
        int x;
        Pair(int y,int x){
            if(y==0){this.y=0;this.x=1;}
            else if(x==0){this.y=1;this.x=0;}
            else{
                int h=gcd(x,y);
                this.x=x/h;
                this.y=y/h;
                if(this.x>0 && this.y>0) return;
                if(this.y<0){
                    this.y=Math.abs(this.y);
                    this.x*=-1;
                }
            }
        }

        private int gcd(int x, int y){
            x=Math.abs(x); y=Math.abs(y);
            int a = Math.max(x,y), b=Math.min(x,y);
            while(b>0){
                int rem=a%b;
                a=b;b=rem;
            }
            return a;
        }

        @Override
        public int hashCode(){
            String code = x+" "+y;
            return code.hashCode();
        }

        @Override
        public boolean equals(Object o){
            return o.hashCode()==this.hashCode();
        }
    }

    public static void main(String args[]){
//        Point[] points={new Point(0,0), new Point(1,1), new Point(1,1),new Point(2,2),new Point(3,3),new Point(1,2),new Point(2,3)}; //must print 5
        Point[] points={new Point(1,1), new Point(3,2), new Point(5,3),new Point(4,1),new Point(2,3),new Point(1,4)}; //must print 4
//        Point[] points={new Point(0,0), new Point(94911151,94911150), new Point(94911152,94911151)}; //must print 2
        System.out.print(maxPoints(points));
    }
}
