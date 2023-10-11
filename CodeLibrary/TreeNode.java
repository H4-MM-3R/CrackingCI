public class TreeNode {
  public int data;
  public TreeNode left;
  public TreeNode right;
  public TreeNode parent;
  private int size = 0;

  public TreeNode(int data) {
    this.data = data;
    size = 1;
  }

  private void setLeftChild(TreeNode left) {
    this.left = left;
    if (left != null) {
      left.parent = this;
    }
  }

  private void setRightChild(TreeNode right) {
    this.right = right;
    if (right != null) {
      right.parent = this;
    }
  }

  public void insertInOrder(int value) {
    if (value <= data) {
      if (left == null) setLeftChild(new TreeNode(value));
      else left.insertInOrder(value);
    } else {
      if (right == null) setRightChild(new TreeNode(value));
      else right.insertInOrder(value);
    }
    size++;
  }

  public int size() {
    return size;
  }

  public boolean isBST() {
    if (left != null) {
      if (data < left.data || !left.isBST()) return false;
    }
    if (right != null) {
      if (data >= right.data || !right.isBST()) return false;
    }

    return true;
  }

  public int height() {
    int leftHeight = left != null ? left.height() : 0;
    int rightHeight = right != null ? right.height() : 0;
    return 1 + Math.max(leftHeight, rightHeight);
  }

  public TreeNode find(int value) {
    if (value == data) return this;
    else if (data <= data) return left != null ? left.find(value) : null;
    else if (value > data) return right != null ? right.find(value) : null;

    return null;
  }

  private static TreeNode createMinimalBST(int arr[], itn start, int end) {
    if (end < start) return null;

    int mid = (start + end) / 2;
    TreeNode n = new TreeNode(arr[mid]);

    n.setLeftChild(createMinimalBST(arr, start, mid - 1));
    n.setRightChild(createMinimalBST(arr, mid + 1, end));

    return n;
  }

  public static TreeNode createMinimalBST(int[] arr) {
    return createMinimalBST(arr, 0, arr.length - 1);
  }
}
