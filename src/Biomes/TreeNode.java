package Biomes;

class  TreeNode<T> {
	private T data;
	private boolean requiresResponse;
	
	private TreeNode<T> left; 
	private TreeNode<T> right;
	
	public TreeNode(T data, boolean requiresResponse) {
        this.data = data;
        this.requiresResponse = requiresResponse;
        right = null;
        left = null;
    }
	public TreeNode(T data) {
        this.data = data;
        this.requiresResponse = false;
        right = null;
        left = null;
    }

	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}
	
	public boolean getResponse() {
		return requiresResponse;
	}
}
