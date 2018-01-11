package demo.spring.boot.demospringboot.Constant;

public interface Constant {
    interface User {
        interface Role {
            Integer common = 0;
            Integer admin = 1;
            Integer superAdmin = 2;
        }

        interface Gender {
            Integer woman = 0;
            Integer man = 1;
        }
    }
}
