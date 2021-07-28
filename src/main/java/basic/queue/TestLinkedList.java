package basic.queue;

import basic.base.TestBase;

import java.util.LinkedList;

public class TestLinkedList extends TestBase {

    public static void main(String[] args) {

        LinkedList<R> linkedList = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            linkedList.add(new R(i));
        }
        print("linkedList", linkedList);
        print("acquire first elm", linkedList.get(0));
    }
}
