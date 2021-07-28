package basic.boxtype;

import basic.base.TestBase;

public class TestIntCache extends TestBase {
    public static void main(String[] args) {
        print("---------------------------------------------------------------");
        Integer box1 = 1;
        Integer box2 = 1;
        Integer valueOf1 = Integer.valueOf(1);
        Integer new1 = new Integer(1);
        Integer new2 = new Integer(1);
        print("box1 == box2", box1 == box2);
        print("box1 == valueOf1", box1 == valueOf1);
        print("box1 == new1", box1 == new1);
        print("new1 == new2", new2 == new1);
        print("when you use autoBox 'Integer a = 1' or 'Integer.valueOf(1)' , you use the cached object.\n" +
                "when you use new Integer(1), you create a new object.\n" +
                "in one word, use the equals !!! ");
    }
}
