package chap1_8.pratice;

public class Admin extends Messenger {

    public Admin(String name) {
        super(name);
    }

    @Override
    void sendMessage(String message) {
        System.out.printf("[관리자] %s: %s\n", getName(), message);
    }
}
