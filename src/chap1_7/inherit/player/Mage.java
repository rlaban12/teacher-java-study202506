package chap1_7.inherit.player;

public class Mage extends Player {

    int mana; // 마력게이지

    public Mage(String nickName) {
        super(nickName, 40);
        this.mana = 100;
    }

    @Override
    public void showStatus() {
        super.showStatus();
        System.out.println("# 마력: " + this.mana);
    }

    void fireBall(Player player) {
        System.out.printf("%s님이 파이어볼을 시전합니다.\n", this.nickName);
    }
}
