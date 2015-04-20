
public TreeNode bintree2listHelper(TreeNode root) {
    // Base case
    if (root == null) return root;
    // Convert the left subtree and link to root
    if (root.left != null) {
      // Convert the left subtree
      TreeNode l = bintree2listHelper(root.left);
      /* Find inorder predecessor. After this loop, left
         will point to the inorder predecessor  */
      while(l.right != null) l = l.right;
      // Make root as next of the predecessor
      l.right = root;
      // Make predecssor as previous of root
      root.left = l;
    }
    // Convert the right subtree and link to root
    if (root.right != null) {
      // Convert the right subtree
      TreeNode r = bintree2listHelper(root.right);
      // Find inorder successor. After this loop, right
      // will point to the inorder successor
      while(r.left != null) r = r.left;
      // Make root as previous of successor
      r.left = root;
      // Make successor as next of root
      root.right = r;
    }
    return root;
}
// main function
public TreeNode bintree2list(TreeNode root) {
    // Base case
    if (root == nullptr) return root;
    // Convert to DLL using bintree2listUtil()
    root = bintree2listHelper(root);
    // bintree2listHelper() returns root node of the converted
    // DLL.  We need pointer to the leftmost node which is
    // head of the constructed DLL, so move to the leftmost node

    // if need circular, need initialize tail to root
    TreeNode tail = root;
    while (root.left != null) root = root.left;
    // if need circular
    while(tail.right != null) tail = tail.right;
    root.left = tail;
    tail.right = root;
    return root;

}