package basic.queue;

import basic.base.TestBase;

import java.util.ArrayDeque;
import java.util.Iterator;

public class TestArrayDeque extends TestBase {
    public static void main(String[] args) {
        ArrayDeque<R> arrayDeque = new ArrayDeque<>();
        for (int i = 1; i < 11; i++) {
            arrayDeque.add(new R(i));
        }
        print("----------------test basic-----------------");
        print("current is", arrayDeque);
        print("get first", arrayDeque.peekFirst());
        print("get last", arrayDeque.peekLast());
        arrayDeque.offerFirst(new R(100));
        print("add 100 to first", arrayDeque);
        arrayDeque.offerLast(new R(200));
        print("add 200 to last", arrayDeque);
        print("----------------test stack-----------------");
        arrayDeque.clear();
        arrayDeque.push(new R(100));
        print("push 100", arrayDeque);
        arrayDeque.push(new R(200));
        print("push 200", arrayDeque);
        print("pop top elm", arrayDeque.pop());
        print("arrayDeque now is", arrayDeque);
        print("----------------test descendingIterator-----------------");
        arrayDeque.clear();
        for (int i = 1; i < 11; i++) {
            arrayDeque.add(new R(i));
        }
        print("current is", arrayDeque);
        Iterator<R> iterator = arrayDeque.descendingIterator();
        print("use descendingIterator");
        while (iterator.hasNext()) {
            print(iterator.next());
        }
    }
}
