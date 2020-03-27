package test_2020_0325;

import java.util.Scanner;

public class Password {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            char[] sw=new char[130];
            String str1="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String str2="VWXYZABCDEFGHIJKLMNOPQRSTU";
            for(int i=0;i<str1.length();i++){
                sw[str1.charAt(i)]=str2.charAt(i);
            }
            String str=sc.nextLine();
            String result="";
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)==' '){
                    result+=" ";
                }else{
                    result+=sw[str.charAt(i)];
                }
            }
            System.out.println(result);
        }
    }
}
