package Biomes;

import java.util.InputMismatchException;
import java.util.Scanner;

class BinaryTree<T> {
	private TreeNode<T> root;
	
	public BinaryTree()
	{
		this.root = null;
	}
	
	public BinaryTree(T data)
	{
		this.root = new TreeNode<T>(data);
	}
	
	/**
	 * Progresses through tree, prompting user if input is required.
	 */
	public void dialogue()
	{
		Scanner sc = new Scanner(System.in);
		TreeNode<T> current = this.root;
		while (current != null)
		{
			System.out.println(current.getData());
			if (current.getResponse())
			{
				
				int userInput = sc.nextInt();
				//user is presented with yes/no response, response determines next dialogue
				while (userInput != 0 && userInput != 1)
				{
					if (userInput == 0)
					{
						current = current.getLeft();
					} else if (userInput == 1) 
					{
						current = current.getRight();
					}
					else {
						System.out.println("Please pick one of numbers presented.");
					}
				}
			} else {
				current = current.getRight();
			}
		}
	}
}
