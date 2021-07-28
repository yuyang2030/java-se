package basic.list;

import basic.base.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestAsList extends TestBase {

    public static void main(String[] args) {
        List innerArrayList = Arrays.asList(new R(1), new R(2), new R(3), new R(4));
        print("innerArrayList instanceof ArrayList :", innerArrayList instanceof ArrayList);
        print("before modify", innerArrayList);
        print("test set elm", innerArrayList.set(0, new R(100)));
        print("after modify", innerArrayList);
        print("test add elm", innerArrayList.add(new R(90)));
        print("test del elm", innerArrayList.remove(new R(90)));
    }
}
