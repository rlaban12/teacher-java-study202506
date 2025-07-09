package chap2_7.lambda.fruit;

import java.util.List;

import static chap2_7.lambda.fruit.Color.*;
import static chap2_7.lambda.fruit.FilterApple.*;
import static chap2_7.lambda.fruit.MappingApple.*;


public class Main {

    public static void main(String[] args) {

        // 사과 바구니 생성
        List<Apple> appleBasket = List.of(
                new Apple(80, GREEN)
                , new Apple(155, GREEN)
                , new Apple(120, RED)
                , new Apple(97, RED)
                , new Apple(200, GREEN)
                , new Apple(50, RED)
                , new Apple(85, YELLOW)
                , new Apple(75, YELLOW)
        );

        List<Apple> greenApples = filterGreenApples(appleBasket);

        System.out.println(greenApples);

        System.out.println("=============");

        // 빨강사과들만 필터링
        List<Apple> redApples
                = filterApplesByColor(appleBasket, RED);
        System.out.println(redApples);

        System.out.println("==============");

        List<Apple> yellowApples = filterApplesByColor(appleBasket, YELLOW);
        System.out.println("yellowApples = " + yellowApples);

        System.out.println("==============");

        // 무게가 100이상인 사과만 필터링
        List<Apple> weightGoe100 = filterApples(appleBasket, new AppleWeightPredicate());
        System.out.println("weightGoe100 = " + weightGoe100);

        // 무게가 홀수인 사과만 필터링
        List<Apple> oddWeightApples = filterApples(appleBasket, x -> x.getWeight() % 2 == 1);
        System.out.println("oddWeightApples = " + oddWeightApples);

        // 색상이 빨강 또는 초록 사과만 필터링
        List<Apple> redOrGreenApples = filterApples(appleBasket, apple -> apple.getColor() == RED || apple.getColor() == GREEN);
        System.out.println("redOrGreenApples = " + redOrGreenApples);

        // 무게가 100이상이면서 빨강사과만 필터링
        List<Apple> redHeavyApples = filterApples(appleBasket, apple -> apple.getWeight() >= 100 && apple.getColor() == RED);
        System.out.println("redHeavyApples = " + redHeavyApples);

        System.out.println("==============");

        List<Integer> numbers = List.of(1,2,3,4,5,6);

        // 짝수만 필터링
        List<Integer> evenNumbers = filter(numbers, n -> n % 2 == 0);
        System.out.println("evenNumbers = " + evenNumbers);

        List<Apple> yellowAppleList
                = filter(appleBasket, a -> a.getColor() == YELLOW);
        System.out.println("yellowAppleList = " + yellowAppleList);

        List<String> filteredFoods = filter(
                List.of("짜장면", "우동", "김", "탕수육"),
                str -> str.length() == 3
        );
        System.out.println("filteredFoods = " + filteredFoods);

        System.out.println("===============");

        List<Color> colorList = mappingApplesByColor(appleBasket);
        System.out.println("colorList = " + colorList);

        System.out.println("===============");

        List<Integer> weightList = mappingApples(appleBasket, new AppleFunction<Integer>() {

            @Override
            public Integer apply(Apple apple) {
                return apple.getWeight();
            }
        });

        System.out.println("weightList = " + weightList);

        System.out.println("============");

        // 색상 문자열의 첫글자만 모아서 리턴
        List<Character> characterList = mappingApples(appleBasket, new AppleFunction<Character>() {

            @Override
            public Character apply(Apple apple) {
                return apple.getColor().toString().charAt(0);
            }
        });

        System.out.println("characterList = " + characterList);

        System.out.println("=============");

        // 각 사과별로 "xx색 사과는 xxg입니다." 라는 문자열 목록을 리턴
        List<String> stringList = mappingApples(appleBasket, new AppleFunction<String>() {
            @Override
            public String apply(Apple apple) {
                return String.format("%s색 사과는 %dg입니다.", apple.getColor().toString(), apple.getWeight());
            }
        });

        System.out.println("stringList = " + stringList);

        System.out.println("=============");

        /*
            사과목록에서 아래와 같은 데이터 형식의 목록을 리턴
            [
                {
                    first: 'G',
                    weight: 0.08
                },
                {
                    first: 'G',
                    weight: 0.15
                }
            ]
         */

    }
}
