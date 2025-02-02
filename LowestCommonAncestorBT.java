import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorBT {
    //Time Complexity:O(N) n= number of nodes
    //Space Complexity: O(1)
    List<TreeNode> path;
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        path = new ArrayList<>();
        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();
        backtrack(root, p,q);
        for(int i = 0; i< pathP.size(); i++){
            if(pathP.get(i) != pathQ.get(i)) return pathP.get(i-1);
        }
        return null;
    }

    private void backtrack(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return;
        }
        path.add(root);
        if(root == p){
            pathP = new ArrayList<>(path);
            pathP.add(root);
        }
        else if(root == q){
            pathQ = new ArrayList<>(path);
            pathQ.add(root);
        }
        backtrack(root.left, p,q);
        backtrack(root.right ,p ,q);
        path.remove(path.size() - 1);

    }
}
