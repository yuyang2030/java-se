package basic.queue;

import basic.base.TestBase;

import java.util.*;

public class TestPriorityQueue extends TestBase {


    public static void main(String[] args) {

        final PriorityQueue<R> priorityQueue = new PriorityQueue<R>(2);
        // test element and peek
        // priorityQueue.element(); ---> NoSuchElementException
        // priorityQueue.peek(); ---> null
        // priorityQueue.remove(); --->NoSuchElementException
        // priorityQueue.poll(); ---> null
        ArrayList<R> arrayList = new ArrayList<R>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(new R(i));
        }
        Collections.shuffle(arrayList);
        print("unordered list", arrayList);
        arrayList.iterator().forEachRemaining(priorityQueue::add);
        print("afetr add", priorityQueue);
        while (!priorityQueue.isEmpty()) {
            print(priorityQueue.remove());
        }
        priorityQueue.offer(new R(1000));
        // 删除头部元素
        priorityQueue.remove();
        print("remove first elm", priorityQueue);
        // 删除指定元素
        priorityQueue.remove(new R(9));
        print("remove R(9)", priorityQueue);
    }

}
