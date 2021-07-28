package basic.list;

import basic.base.TestBase;

import java.util.ArrayList;
import java.util.List;

public class TestSubList extends TestBase {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        List subList = arrayList.subList(0, arrayList.size());
         // change source array, add element
         arrayList.add("1");
         // 1. remove elm from sub list cause exception：
         subList.remove("2");
         // 2. add elm to sub list cause exception
         subList.add("4");
         // 3. traverse sublist cause exception
        for (Object item: subList) {
            print("");
        }

    }
}
