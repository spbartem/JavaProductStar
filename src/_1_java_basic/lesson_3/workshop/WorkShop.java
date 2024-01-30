package _1_java_basic.lesson_3.workshop;

import java.util.Arrays;

public class WorkShop {

    public static void main(String[] args) {
//        Friend[] friends = new Friend[4];
//        friends[0] = new Friend("Вася", Integer.parseInt("18"), true, 4.25f);
//        friends[1] = new Friend("Катя", Integer.parseInt("19"), true, 5.25f);
//        friends[2] = new Friend("Дима", Integer.parseInt("20"), true, 7.25f);

        Friend[] friends = new Friend[] {
                new Friend("Вася", Integer.parseInt("18"), true, 4.25f),
                new Friend("Катя", Integer.parseInt("19"), true, 5.25f),
                new Friend("Дима", Integer.parseInt("20"), true, 7.25f),
                new Friend("Маша", Integer.parseInt("21"), false, 8.2f),
                new Friend("Саша", Integer.parseInt("22"), false, 9.5f)
        };



        System.out.println("My friends:" + Arrays.toString(friends));
    }
}

class Friend {

    private String name;
    private int age;
    private boolean isFriendFromSchool;
    private float hoursSpentTogetherLastWeek;

    public Friend(String name, int age, boolean isFriendFromSchool, float hoursSpentTogetherLastWeek) {
        this.name = name;
        this.age = age;
        this.isFriendFromSchool = isFriendFromSchool;
        this.hoursSpentTogetherLastWeek = hoursSpentTogetherLastWeek;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isFriendFromSchool=" + isFriendFromSchool +
                ", hoursSpentTogetherLastWeek=" + hoursSpentTogetherLastWeek +
                '}';
    }
}
