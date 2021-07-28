package basic.map;

import basic.base.TestBase;

import java.util.HashMap;

public class TestHashMap extends TestBase {

    public static void main(String[] args) {
        HashMap<R,String> hashMap = new HashMap<>();
        R r1 = new R(1, 1);
        R r2 = new R(2, 1);
        hashMap.put(r1, "r1");
        hashMap.put(r2, "r2");
        print("----------------------test key equals condition-------------------------------");
        print("test hashcode same but value not equal",hashMap);
        hashMap.clear();
        hashMap.put(new R(1, 1), "r1");
        hashMap.put(new R(1, 2), "r2");
        print("test equal value different hashcode", hashMap);
        print("----------------------test change equals-------------------------------");
        hashMap.clear();
        R r_1 = new R(1);
        R r_2 = new R(2);
        hashMap.put(r_1, "test_1");
        hashMap.put(r_2, "test_2");
        print("after put", hashMap);
        r_1.setValue(100);
        print("after change equals", hashMap);
        hashMap.remove(new R(1));
        print("after remove R(1)", hashMap);
        print("get R(1)", hashMap.get(new R(1)));
        hashMap.put(new R(1), "new R1");
        print("add a new R(1)", hashMap);
        hashMap.remove(new R(100, 1));
        print("after remove R(100, 1)", hashMap);
        print("----------------------test change hashcode-------------------------------");
        hashMap.clear();
        r_1 = new R(1);
        r_2 = new R(2);
        hashMap.put(r_1, "test_1");
        hashMap.put(r_2, "test_2");
        print("after put", hashMap);
        r_1.setHashCode(100);
        print("after change hashcode", hashMap);
        print("get R(1)", hashMap.get(new R(1)));
        hashMap.remove(new R(1));
        print("after remove R(1)", hashMap);
    }



}
