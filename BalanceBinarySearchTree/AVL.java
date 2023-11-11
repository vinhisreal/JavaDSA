import java.lang.Math;
import java.util.LinkedList;
import java.util.Queue;
public class AVL
{
    private Node root;
    public AVL()
    {
        root=null;
    }
    public void insert(int value)
    {
        root=insert(root, value);
    }

    public void NLR()
    {
        Node tmp=root;
        NLR(tmp);
    }
    public Node findMin()
    {
        Node tmp=root;
        return findMin(tmp);
    }
    public Node findMax()
    {
        Node tmp=root;
        return findMax(tmp);
    }
    public Node deleteMin()
    {
        return deleteMin(root);
    }
    public Node deleteMax()
    {
        return deleteMax(root);
    }
    public Node deleteSucc(int key)
    {
        return deleteSucc(root,key);
    }
    public void bfs()
    {
        bfs(root);
    }
    private void NLR(Node x)
    {
        if(x!=null)
        {
            System.out.print(x.key+" ");
            NLR(x.left);
            NLR(x.right);
        }
    }
    private Node rotateLeft(Node x)
    {
        Node y=x.right;
        x.right=y.left;
        y.left=x;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }
    private Node rotateRight(Node x)
    {
        Node y=x.left;
        x.left=y.right;
        y.right=x;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }
    private Node balance(Node x)
    {
        if(checkBalance(x)==2)
        {
            if(checkBalance(x.left)==-1)
            {
                x.left=rotateLeft(x.left);
            }
            x=rotateRight(x);
        }
        else if(checkBalance(x)==-2)
        {
            if(checkBalance(x.right)==1)
            {
                x.right=rotateRight(x.right);
            }
            x=rotateLeft(x);
        }
        return x;
    }
    
    private int checkBalance(Node x)
    {
        return height(x.left)-height(x.right);
    }
    
    private Node insert(Node x, int data)
    {
        if(x==null)
        {
            return new Node(data);
        }
        else if(x.key>data)
        {
            x.left=insert(x.left, data);
        }
        else if(x.key<data)
        {
            x.right=insert(x.right, data);
        }
        else
        {
            x.key=data;
        }
        x.height = 1 + Math.max(height(x.left), height(x.right));
        x=balance(x);
        return x;
    }
    private int height(Node node)
    {
        if (node == null)
            return -1;
        return node.height;
    }
    private Node findMin(Node x)
    {
        if(x.left==null)
        {
            return x;
        }
        return findMin(x.left);
    }
    private Node findMax(Node x)
    {
        if(x.right==null)
        {
            return x;
        }
        return findMax(x.right);
    }
    private Node deleteMin(Node x)
    {
        if(x.left==null)
        {
            return x.right;
        }
        x.left=deleteMin(x.left);
        x.height=1 + Math.max(height(x.left), height(x.right));
        x=balance(x);
        return x;
    }
    private Node deleteMax(Node x)
    {
        if(x.right==null)
        {
            return x.left;
        }
        x.right=deleteMax(x.right);
        x.height=1 + Math.max(height(x.left), height(x.right));
        x=balance(x);
        return x;
    }
    private Node deleteSucc(Node x,int key)
    {
        if (x == null) return null;

        if (key < x.key)
        {
            x.left = deleteSucc(x.left, key);
        }
        else if (key > x.key)
        {
            x.right = deleteSucc(x.right, key);
        }
        else
        {
            if (x.right == null)
            {
                return x.left;
            }
            else if (x.left == null)
            {
                return x.right;
            }
            x.key = findMin(x.right).key;
            x.right = deleteMin(x.right);
        }

        x.height = 1 + Math.max(height(x.left), height(x.right));
        x = balance(x);
        return x;
    }
    private void bfs(Node x)
    {
        Queue<Node> a=new LinkedList<>();
        a.add(x);
        while(!a.isEmpty())
        {
            Node tmp=a.poll();
            System.out.print(tmp.key+" ");
            if(tmp.left!=null)
            {
                a.add(tmp.left);
            }
            if(tmp.right!=null)
            {
                a.add(tmp.right);
            }
        }
    }
}