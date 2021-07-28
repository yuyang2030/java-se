package basic.lab;

import basic.base.TestBase;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

// producer extends and consumer super

public class TestPECS extends TestBase {

    @Data
    static class Fruit{
        private String name;
    }

    @Data
    static class Apple extends Fruit {
        private String name;
    }

    @Data
    static class Pear extends Fruit {
        private String name;
    }

    // producer extends, list just like a producer, all kinds of elms
    public void consumer(List< ? extends Fruit> list){

    }


    public static void main(String[] args) {


    }
}
