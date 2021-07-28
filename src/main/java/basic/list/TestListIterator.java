package basic.list;

import basic.base.TestBase;

import java.util.ArrayList;
import java.util.ListIterator;

public class TestListIterator extends TestBase {


    public static void main(String[] args) {
        ArrayList<R> arrayList = new ArrayList<R>();
        for (int i = 1; i < 11; i++) {
            arrayList.add(new R(i));
        }
        ListIterator<R> listIterator = arrayList.listIterator();
            print("current is", listIterator.next());
            print("previous is", listIterator.previous());
            print("next index is", listIterator.nextIndex());
            print("next index is", listIterator.previousIndex());
            print("-----------------------------------------");
            print("set R(2,2) to R(200,200)");
            print("before set", arrayList);
            R targetElm = new R(2);
            while (listIterator.hasNext()) {
                R next = listIterator.next();
                if (next.equals(targetElm)) {
                    listIterator.set(new R(200));
                }
            }
            print("after set", arrayList);
            print("use for to change it back");
            for (int i = 0; i < arrayList.size(); i++){
                R elm = arrayList.get(i);
                if (elm.equals(new R(200))) {
                    // 第一种方法：直接设置生效！
                    arrayList.set(i, new R(2));
                    // 第二种方法：不生效，引用复制，原引用不变。
                    elm = new R(2);
                    // 第三种方法：原地修改，生效！
                    elm.setValue(200);
                    elm.setHashCode(200);
                }
            }
            print("after change back", arrayList);
    }


}
