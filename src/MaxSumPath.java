import java.util.*;

public class MaxSumPath {
    public List<Integer> findMaxSumPath (TreeNode root) {
        List<TreeNode> tempPath = new ArrayList<>();
        int[] maxSum = new int[] {Integer.MIN_VALUE};
        int tempSum = 0;
        List<Integer> maxPath = new ArrayList<>();
        dfs(root, maxPath, tempPath, maxSum,tempSum);
        return maxPath;
    }

    private void dfs(TreeNode root, List<Integer> maxPath, List<TreeNode> tempPath, int[] maxSum, int tempSum) {
        if (root == null) {
            if (tempSum > maxSum[0]) {
                maxPath.clear();
                for (TreeNode node : tempPath) {
                    maxPath.add(node.key);
                }
                maxSum[0] = tempSum;
            }
            return;
        }
        tempPath.add(root);
        tempSum += root.key;
        dfs(root.left, maxPath, tempPath, maxSum, tempSum);
        dfs(root.right, maxPath, tempPath, maxSum, tempSum);
        tempPath.remove(tempPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode rL = new TreeNode(300);
        TreeNode rR = new TreeNode(4);
        TreeNode rLR = new TreeNode(10);
        TreeNode rRL = new TreeNode(15);
        TreeNode rRR = new TreeNode(80);
        root.left = rL;
        root.right = rR;
        rL.right = rLR;
        rR.left = rRL;
        rR.right = rRR;
        MaxSumPath solution = new MaxSumPath();
        List<Integer> maxPath = solution.findMaxSumPath(root);
        System.out.println(maxPath);

    }


}
