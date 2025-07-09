package chap2_8.stream;

import java.util.List;
import java.util.stream.Collectors;

import static chap2_8.stream.Menu.menuList;

public class Filtering {
    public static void main(String[] args) {

        // 요리 메뉴 중 채식주의자가 먹을 수 있는 요리만 필터링
        /*List<Dish> vegetarianList = new ArrayList<>();

        for (Dish dish : menuList) {
            if (dish.isVegetarian()) {
                vegetarianList.add(dish);
            }
        }*/

        List<Dish> vegetarianList = menuList.stream() // 1. 데이터 소스 생성
                .filter(Dish::isVegetarian)           // 2. 중간연산
                .collect(Collectors.toList());        // 3. 최종연산

//        System.out.println("vegetarianList = " + vegetarianList);

        vegetarianList.forEach(System.out::println);

        System.out.println("=================");

        // 메뉴중 육류이면서 600칼로리 미만인 요리 필터링
        List<Dish> meatLowCalories = menuList.stream()
                .filter(menu -> menu.getType() == DishType.MEAT && menu.getCalories() < 600)
                .collect(Collectors.toList());

        meatLowCalories.forEach(System.out::println);

        System.out.println("===============");

        // 메뉴중에 요리이름이 4글자인것만 필터링
    }
}
