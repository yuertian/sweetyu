package tianyu.demo;

import com.sun.javaws.Main;
import com.sun.org.apache.xerces.internal.xinclude.XPointerFramework;

import java.security.ProtectionDomain;

class Person{
    public String name;
    public int age;
    public String sex;

    public void eat() {
        System.out.println(name + "喜欢吃饭！");
    }

    public void sleep() {
        System.out.println(name + "喜欢睡觉！");
    }

    public void show() {
        System.out.println("我是" + name + ",今年"
                + age + "岁，" + sex );
    }
}

public class Test1 {
    public static void main(String[] args) {
        Person shuaishuai = new Person();
        shuaishuai.name = "小明";
        shuaishuai.age = 22;
        shuaishuai.sex = "男";
        shuaishuai.show();
        shuaishuai.eat();

        Person humin = new Person();
        humin.name = "小花";
        humin.age = 18;
        humin.sex = "女";
        humin.show();
        humin.sleep();
    }
}
