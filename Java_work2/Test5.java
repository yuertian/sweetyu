public class Test5{
        public static void main(String[] args) {
            int i,j;
            for(i=1;i<=9;i++)//上三角形式输出
    {
    for(j=1;j<=i;j++)
        { System.out.print(j+"*"+i+"="+j*i+" ");
        if(i*j<=9)
        { System.out.print(" ");}
        }
    System.out.println();
    }

    System.out.println();//换两行
    System.out.println();
        }
    }