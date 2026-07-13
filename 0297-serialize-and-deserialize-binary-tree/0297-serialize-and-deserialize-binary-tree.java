
public class Codec {
    int idx;
    public TreeNode Builder(String[] arr){
       if (arr[idx].equals("N")) {
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[idx++]));
        root.left = Builder( arr);
        root.right = Builder( arr);
        return root;
    }

    void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N,");
            return;
        }

        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
          StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        idx = 0;
        String[] arr = data.split(",");
        
        return Builder(arr);
    }
}
