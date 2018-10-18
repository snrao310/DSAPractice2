public class InorderSuccessorBSTLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){this.val=val;}
    }

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null || p==null) return null;
        if(p.right!=null){
            TreeNode tem=p.right;
            while(tem.left!=null) tem=tem.left;
            return tem;
        }
        TreeNode tem=root,prev=null;
        while(tem!=null){
            if(tem.val==p.val) return prev;
            if(tem.val>p.val){
                prev=tem;
                tem=tem.left;
            }
            else
                tem=tem.right;
        }
        return null;
    }

    public static TreeNode createTree(){
        TreeNode root=new TreeNode(3);
        TreeNode one=new TreeNode(1);
        TreeNode two= new TreeNode(2);
        TreeNode four=new TreeNode(4);
        TreeNode five= new TreeNode(5);
        root.left=one; root.right=five; five.left=four; one.right=two;
        return root;
    }

    public static void main(String args[]){
        TreeNode root=createTree();
        TreeNode res = inorderSuccessor(root, root.left);
        System.out.print((res==null)?"null":res.val);
    }
}
