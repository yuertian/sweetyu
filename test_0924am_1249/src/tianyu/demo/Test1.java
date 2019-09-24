package tianyu.demo;

public class Test1 {
    public static void main(String[] args) {
        testAdd();//插入方法
        testSearch();//查找方法
        testDelete();//删减方法
    }

    public static void testAdd() {
        SeqList seqlist = new SeqList();
        seqlist.add(0,1);//插入
        seqlist.add(1,2);//插入
        seqlist.add(2,3);//插入
        seqlist.add(3,4);//插入
        seqlist.add(4,5);//插入
        seqlist.display();
    }

    public static void testSearch() {
        SeqList seqlist = new SeqList();
        seqlist.add(0,1);//插入
        seqlist.add(1,2);//插入
        seqlist.add(2,3);//插入
        seqlist.add(3,4);//插入
        seqlist.add(4,5);//插入
        seqlist.searchPos(3);//按位查找
        seqlist.searchNum(4);//按值查找
    }

    public static void testDelete() {
        SeqList seqlist = new SeqList();
        seqlist.add(0,1);//插入
        seqlist.add(1,2);//插入
        seqlist.add(2,3);//插入
        seqlist.add(3,4);//插入
        seqlist.add(4,5);//插入
        seqlist.deleteNum(3);//按值删除
        seqlist.deletePos(4);//按坐标删除
        System.out.println("删除后：");
        seqlist.display();
    }


}
