package basic.map;

import basic.base.TestBase;

import java.util.*;


public class TestTreeMap extends TestBase {
    public static void main(String[] args) {
        TreeMap<R, String> treeMap = new TreeMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            arrayList.add(i);
        }
        Collections.shuffle(arrayList);
        print("After shuffle", arrayList);
        for (Integer integer : arrayList) {
            treeMap.put(new R(integer), String.valueOf(integer));
        }
        R[] rArray = treeMap.keySet().toArray(new R[0]);
        print("treeMap's keySet to array", Arrays.toString(rArray));
        print("try get R(6) index", Arrays.binarySearch(rArray, new R(6)));
        print("为啥非要得到数组？意义何在？");
        print("----------------------------------------------------------------------------------");
        print("tree map is", treeMap);
        print("first entry", treeMap.firstEntry());
        print("last entry", treeMap.lastEntry());
        print("higher entry than R(8)", treeMap.higherEntry(new R(8)));
        print("lower entry than R(8)", treeMap.lowerEntry(new R(8)));
        print("first key", treeMap.firstKey());
        print("last key", treeMap.lastKey());
        print("higher key than R(8)", treeMap.higherKey(new R(8)));
        print("lower key than R(8)", treeMap.lowerKey(new R(8)));
        print("subMap [6,8)", treeMap.subMap(new R(6), new R(8)));
        print("tail map R(8)", treeMap.tailMap(new R(8)));
        print("head map R(8)", treeMap.headMap(new R(8)));
        print("subMap [6,8]", treeMap.subMap(new R(6), true, new R(8), true));
        print("headMap [,8]", treeMap.headMap(new R(8), true));
        print("tail map [8,]", treeMap.tailMap(new R(8), true));
        NavigableMap<R,String> navigableMap = treeMap.headMap(new R(8), false);
        print("ceilingEntry >= R(4)", navigableMap.ceilingEntry(new R(4)));
        print("ceilingKey >= R(4)", navigableMap.ceilingKey(new R(4)));
        print("floorEntry <= R(4)", navigableMap.floorEntry(new R(4)));
        print("floorKey <= R(4)", navigableMap.floorKey(new R(4)));
        print("navigable key set [升序]", navigableMap.navigableKeySet());
        print("decending keySet [降序]", navigableMap.descendingKeySet());
        print("decending map", navigableMap.descendingMap());
    }
}
