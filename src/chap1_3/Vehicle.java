package chap1_3;

// 자동차 설계도
public class Vehicle {

    // 속성 (필드)
    String company;
    String model;
    int currentSpeed;
    int fuel;
    Owner owner; // 자동차 주인
    boolean isOn;

    // 기본 생성자
    Vehicle() {}

    // String 2개를 받아서 초기화하는 생성자
    Vehicle(String c, String m) {
        company = c;
        model = m;
    }

    // 기능 (메서드)
    void info() {
        System.out.println("자동차 주인: " + owner.name);
        System.out.println("자동차 모델명: " + model);
        System.out.println("자동차 등록일: " + owner.registerDate);
    }

    void powerOn() {
        if (isOn) {
            System.out.println("시동이 이미 걸려있습니다.");
            return;
        }
        isOn = true;
        System.out.println(model + "의 시동이 걸렸습니다.");
    }

    void powerOff() {
        if (!isOn) {
            System.out.println("시동이 걸려있지 않습니다.");
            return;
        }
        isOn = false;
        System.out.println("시동이 꺼졌습니다.");
    }

    void accelerate() {
        System.out.printf("%s 자동차가 주행을 시작합니다.\n", model);
        currentSpeed += 20;
        System.out.printf("현재 속도: %dkm/h\n", currentSpeed);
    }
}