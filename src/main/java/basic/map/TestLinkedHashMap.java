package basic.map;

import basic.base.TestBase;

import java.util.LinkedHashMap;

public class TestLinkedHashMap extends TestBase {

    public static void main(String[] args) {
        LinkedHashMap<R,String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(new R(1), "r1");
        linkedHashMap.put(new R(2), "r2");
        print("linkedHashMap", linkedHashMap);
        linkedHashMap.put(new R(1), "test change r1");
        print("after change linkedHashMap", linkedHashMap);
        linkedHashMap.forEach((k,v)->{print(k,v);});
    }
}
