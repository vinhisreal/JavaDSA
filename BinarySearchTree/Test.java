public class Test {
    public static void main(String[] args)
    {
        //Cau 1
        BTS a= new BTS();
        a.insert(8);
        a.insert(3);
        a.insert(4);
        a.insert(7);
        a.insert(6);
        a.insert(15);
        a.insert(9);
        a.insert(16);
        a.insert(1);
        a.NLR();
        a.LNR();
        a.LRN();
        //Cau 2
        String c="0 14 5 23 9";
        BTS b=createTree(c);
        //Cau 3
        b.RNL();
        //Cau4
        System.out.println("Result of Ex4="+b.contains(100));
        //Cau 8
        System.out.println(a.sumNode());
        //Cau 9
        System.out.println(a.sumEven());
        //Cau10
        System.out.println(a.countLeaves());
        //Cau11
        System.out.println(a.sumKeyLeaves());
        //Cau 12
        a.bfs();

    }
    public static BTS createTree(String s)
    {
        String[] a=s.split(" ");
        BTS b=new BTS();
        for(String x:a)
        {
            if(isNumber(x))
            {
                b.insert(Integer.valueOf(x));
            }
        }
        return b;
    }
    public static boolean isNumber(String s)
    {
        return s.matches("0|([1-9]*[0-9])");
    }
}
