package basic.base;

import lombok.Data;

import java.util.Arrays;


@Data
public class TestBase {

    public static void print(Object obj) {
        System.out.println(obj);
    }

    public static void print(Object ...array){
        System.out.println(Arrays.toString(array));
    }

    public static void print(String content) {
        System.out.println(content);
    }

    public static void print(String comment, Object obj) {
        System.out.println(comment + ": " + obj);
    }

    @Data
    public static class R implements Comparable<R> {

        public int value;

        public int hashCode;

        public R(int num) {
            this.value = num;
            this.hashCode = num;
        }

        public R(int value, int hashCode) {
            this.value = value;
            this.hashCode = hashCode;
        }

        @Override
        public int compareTo(R o) {
            return this.value - o.getValue();
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof R) {
                return value == ((R) o).value;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return hashCode;
        }

        @Override
        public String toString() {
            return "R{" + value + "," + hashCode + '}';
        }
    }


}
