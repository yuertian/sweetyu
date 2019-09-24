package tianyu.demo;

import com.sun.org.apache.xpath.internal.functions.FuncQname;

import javax.sound.midi.SysexMessage;

class Animal {
    private String type;
    private String name;
    private int age;
    private String habit;
    private String sex;

    public Animal(String type, String name, int age, String habit) {
        this.type = type;
        this.name = name;
        this.age = age;
        this.habit = habit;
    }

    public Animal(String name, String habit) {
        this.name = name;
        this.habit = habit;
    }

    public Animal(String name, String sex, String habit) {
        this.name = name;
        this.sex = sex;
        this.habit = habit;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", habit='" + habit + '\'' +
                '}';
    }

        public void show() {
        System.out.println("种类：" + type + " / 名字："
                + name + " / 年龄：" + age + " / 爱好：" + habit);
    }
}

public class Test2 {
    public static void main(String[] args) {
    Animal cat = new Animal("小猫","喵星人",2,"喜欢睡觉觉");
    Animal dog = new Animal("小狗","汪星人",2,"喜欢啃骨头");
    Animal pig = new Animal("小乔治","喜欢玩泥巴");
    Animal bird = new Animal("小甜鸟","小公举","唱歌");
//    cat.show();
//    dog.show();
//    pig.show();
        System.out.println(cat);
        System.out.println(dog);
        pig.show();
        bird.show();
    }
}
