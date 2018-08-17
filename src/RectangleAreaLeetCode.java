/**
 *
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 *
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 *
 */
public class RectangleAreaLeetCode {

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int result = getArea(A,B,C,D) + getArea(E,F,G,H);
        if(C<=E || G<=A) return result;
        if(D<=F || H<=B) return result;

        int x1 = Math.max(A,E);
        int y1 = Math.max(B,F);
        int x2 = Math.min(C,G);
        int y2 = Math.min(D,H);
        result -= getArea(x1,y1,x2,y2);
        return result;
    }

    private static int getArea(int x1,int y1, int x2, int y2){
        return (x2-x1)*(y2-y1);
    }
    public static void main(String args[]){
        System.out.println(computeArea(-3,-3,3,3,-5,-5,0,-4));
    }
}
