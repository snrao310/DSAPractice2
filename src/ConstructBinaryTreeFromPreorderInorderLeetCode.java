/**
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 */
public class ConstructBinaryTreeFromPreorderInorderLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){this.val=val;}
    }

    public static void inOrderTraverse(TreeNode node){
        if(node==null)
            return;
        inOrderTraverse(node.left);
        System.out.print(node.val+" ");
        inOrderTraverse(node.right);
    }


    public static void preOrderTraverse(TreeNode node){
        if(node==null)
            return;
        System.out.print(node.val+" ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    private static TreeNode buildTree(int[] preOrder, int[] inOrder, int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart>preEnd) return null;
        TreeNode root = new TreeNode(preOrder[preStart]);
        if(preStart==preEnd) return root;
        int rootInd,rootVal=preOrder[preStart];
        for(rootInd=inStart;rootInd<=inEnd;rootInd++){
            if(inOrder[rootInd]==rootVal)
                break;
        }
        int numLeft = rootInd -inStart, numRight = inEnd - rootInd;
        root.left = buildTree(preOrder, inOrder, preStart+1, preStart+numLeft, inStart, rootInd-1);
        root.right = buildTree(preOrder, inOrder, preStart+numLeft+1, preEnd, rootInd+1, inEnd);
        return root;
    }



    public static void main(String args[]){
        int[] inOrder={1,2};
        int[] preOrder={2,1};
        TreeNode root=buildTree(preOrder,inOrder);
        inOrderTraverse(root);
        System.out.println();
        preOrderTraverse(root);
    }

}
