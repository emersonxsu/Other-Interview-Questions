

public class Solution {
    public List<Integer> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Double> res = new ArrayList<>();
        if(root == null) return res;

        queue.add(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            int levelSum = 0;
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.add(queue.peek().left);
                if(queue.peek().right != null) queue.add(queue.peek().right);
                levelSum += queue.remove().val;
            }
            double levelAve = levelSum / levelNum;
            res.add(levelAve);
        }
        return res;
    }
}