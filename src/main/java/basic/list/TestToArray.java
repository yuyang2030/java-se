package basic.list;

import basic.base.TestBase;

import java.util.ArrayList;
import java.util.Arrays;

public class TestToArray extends TestBase {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            arrayList.add(i);
        }
        print("arrayList", arrayList);
        Integer[] intArray = arrayList.toArray(new Integer[0]);
        print("intArray", Arrays.toString(intArray));
    }
}
