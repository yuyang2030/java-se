package basic.collection;

import basic.base.TestBase;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TestCollection extends TestBase {
    public static void main(String[] args) {

        Map<String, String> hashMap = new HashMap<>();
        Collections.synchronizedMap(hashMap);

    }
}





















