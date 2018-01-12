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

    interface Order {
        interface Status {
            Integer waitPay = 0;//待付款
            Integer paid = 1;// 1，已付款
            Integer sending = 2;// 2，派送中
            Integer cancel = -1;// -1，已取消'
            Integer complete = 3;//已完成
        }
    }
}
