package 树;

public class TreeNode<E> {
   public TreeNode<E> left;
   public TreeNode<E> right;
   public E value;

   public TreeNode(E value){ this.value = value;}
   public TreeNode(){};

   public TreeNode addRight(E value){
       TreeNode<E> node = new TreeNode<>(value);
       this.right = node;
       return node;
   }

   public TreeNode addLeft(E value){
       TreeNode<E> node = new TreeNode<>(value);
       this.left = node;
       return node;
   }
}
