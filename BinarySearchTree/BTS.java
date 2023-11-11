import java.util.LinkedList;
import java.util.Queue;
public class BTS
{
    private Node root;
    public BTS()
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
        System.out.println();
    }
    public void LNR()
    {
        Node tmp=root;
        LNR(tmp);
        System.out.println();
    }
    public void LRN()
    {
        Node tmp=root;
        LRN(tmp);
        System.out.println();
    }
    public void RNL()
    {
        Node tmp=root;
        RNL(tmp);
        System.out.println();
    }
    public int search(int data)
    {
        Node tmp=root;
        return search(tmp, data).data;
    }
    public boolean contains(int key)
    {
        Node tmp=root;
        if(search(tmp, key)==null)
            return false;
        return true;
    }
    public int findMin()
    {
        Node tmp=root;
        return findMin(tmp).data;
    }
    public int findMax()
    {
        Node tmp=root;
        return findMax(tmp).data;
    }
    public void deleteMax()
    {
        Node tmp=root;
        deleteMax(tmp);
    }
    public void deleteMin()
    {
        Node tmp=root;
        deleteMin(tmp);
    }
    public void delete_Pre(int data)
    {
        Node tmp=root;
        delete_Pre(tmp,data);
    }
    public void delete_Suc(int data)
    {
        Node tmp=root;
        delete_Suc(tmp, data);
    }
    public int height()
    {
        Node tmp=root;
        return height(tmp);
    }
    public Integer sumNode()
    {
        Node tmp=root;
        return sumNode(tmp);
    }
    public Integer sumEven()
    {
        Node tmp=root;
        return sumEven(tmp);
    }
    public int countLeaves()
    {
        Node tmp=root;
        return countLeaves(tmp);
    }
    public int sumKeyLeaves()
    {
        Node tmp=root;
        return sumKeyLeaves(tmp);
    }
    public void bfs()
    {
        Node tmp=root;
        bfs(tmp);
    }

    private void bfs(Node x)
    {
        Queue<Node> a= new LinkedList<>();
        a.add(x);
        while(!a.isEmpty())
        {
            Node tmp =a.poll();
            System.out.print(tmp.data+ " ");
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

    //Recursion code
    private int sumKeyLeaves(Node x)
    {
        if(x==null)
        {
            return 0;
        }
        if(x.left==null && x.right==null)
        {
            // System.out.println(x.data);
            return x.data;
        }
        
        return sumKeyLeaves(x.left)+sumKeyLeaves(x.right);

    }
    private int countLeaves(Node x)
    {
        if(x==null)
        {
            return 0;
        }
        if(x.left==null && x.right==null)
        {
            System.out.println(x.data);
            return 1;
        }
        return countLeaves(x.left)+countLeaves(x.right);

    }
    private Integer sumEven(Node x)
    {
        if(x==null)
        {
            return 0;
        }
        return x.data%2==0? x.data+sumEven(x.left)+sumEven(x.right):sumEven(x.left)+sumEven(x.right);
    }
    private Integer sumNode(Node x)
    {
        if(x==null)
        {
            return 0;
        }
        return x.data+sumNode(x.left)+sumNode(x.right);
    }
    private int height(Node x)
    {
        if(x==null)
        {
            return -1;
        }
        return Math.max(height(x.left), height(x.right))+1;
    }
    private Node insert(Node x, int data)
    {
        if(x==null)
        {
            return new Node(data);
        }
        else if(x.data>data)
        {
            x.left=insert(x.left, data);
        }
        else if(x.data<data)
        {
            x.right=insert(x.right, data);
        }
        else
        {
            x.data=data;
        }
        return x;
    }
    
    private void NLR(Node x)
    {
        if(x!=null)
        {
            System.out.print(x.data+" ");
            NLR(x.left);
            NLR(x.right);
        }
    }
    private void LNR(Node x)
    {
        if(x!=null)
        {
            LNR(x.left);
            System.out.print(x.data+" ");
            LNR(x.right);
        }
    }
    private void LRN(Node x)
    {
        if(x!=null)
        {
            LRN(x.left);
            LRN(x.right);
            System.out.print(x.data+" ");
        }
    }
    private Node search(Node x, int data)
    {
        if(x==null)
        {
            return null;
        }
        else if(x.data>data)
        {
            return search(x.left, data);
        }
        else if(x.data<data)
        {
            return search(x.right, data);
        }
        else
        {
            return x;
        }
    }
    private void RNL(Node x)
    {
        if(x!=null)
        {
            RNL(x.right);
            System.out.print(x.data+" ");
            RNL(x.left);
        }
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
        x=deleteMin(x.left);
        return x;
    }
    private Node deleteMax(Node x)
    {
        if(x.right==null)
        {
            return x.left;
        }
        x=deleteMax(x.right);
        return x;
    }
    private Node delete_Suc(Node x, int data)
    {
        if(x==null) return null;
        else if(x.data>data)
        {
            x.left=delete_Suc(x.left, data);
        }
        else if(x.data<data)
        {
            x.right=delete_Suc(x.right, data);
        }
        else
        {
            if(x.right==null)
            {
                return x.left;
            }
            if(x.left==null)
            {
                return x.right;
            }
            x.data=findMin(x.right).data;
            x.right=deleteMin(x.right);
        }
        return x;
    }
    private Node delete_Pre(Node x, int data)
    {
        if(x==null) return null;
        else if(x.data>data)
        {
            x.left=delete_Pre(x.left, data);
        }
        else if(x.data<data)
        {
            x.right=delete_Pre(x.right, data);
        }
        else
        {
            if(x.left==null)
            {
                return x.right;
            }
            if(x.right==null)
            {
                return x.left;
            }
            x.data=findMax(x.left).data;
            x.left=deleteMax(x.left);
        }
        return x;
    }
}