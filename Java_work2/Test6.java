import java.util.Scanner;
public class Test6 {
public static void main(String args[])
{
Scanner s=new Scanner(System.in);
System.out.println("请输入一个整数:");
int x=s.nextInt();
System.out.println("请输入一个整数:");
int y=s.nextInt();
deff cd= new deff();
int m=cd.ch(x, y);
int n=x*y/m;
System.out.println("最大公约数是:"+m);
System.out.println("最小公倍数是:"+n);
}

}
class deff{
public int ch(int x,int y)
{
int t;
if(x<y)
{
t=x;
x=y;
y=t;
}
while(y!=0)
{
if(x==y)
{
return x;
}
else
{
int k=x%y;
x=y;
y=k;
}
}
return x;
}
}