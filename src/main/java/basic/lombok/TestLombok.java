package basic.lombok;

import lombok.*;

import java.util.ArrayList;

// 相当于给实例属性增加get set方法、toString方法、hashCode、equals方法
@Data
@NoArgsConstructor()
@AllArgsConstructor
@Builder
public class TestLombok {

    static String NAME = TestLombok.class.getSimpleName();

    private String city = null;

    public static void main(String[] args) {
        // val用在局部变量上面，声明final类型局部变量
        val list = new ArrayList<String>();
        list.add("test");
        val a = "aaaa";
        System.out.println(a.startsWith("a"));
    }

    public void test() {
//        TestLombok test = new TestLombok();
//        test.getCity();
//        test.equals(new Object());
    }

}
