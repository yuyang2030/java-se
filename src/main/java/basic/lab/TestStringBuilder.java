package basic.lab;

import basic.base.TestBase;

public class TestStringBuilder extends TestBase {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10000; i++) {
            sb.append(i);
        }
        sb.toString();
        print("time used: ", System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        String result = "";
        for (int i = 1; i < 10000; i++) {
            result += i;
        }
        print("time used: ", System.currentTimeMillis() - start);
        final int a = 100;






    }
}
