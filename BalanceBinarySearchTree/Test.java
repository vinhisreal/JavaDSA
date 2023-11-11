public class Test {
    public static void main(String[] args)
    {
        //Cau 1
        AVL a= new AVL();
        a.insert(72);
        a.insert(42);
        a.insert(67);
        a.insert(14);
        a.insert(34);
        a.insert(65);
        a.insert(53);
        a.insert(80);
        a.insert(93);
        a.insert(13);
        a.deleteSucc(14);
        // a.deleteSucc(67);
        a.bfs();
        a.NLR();
    }
}
