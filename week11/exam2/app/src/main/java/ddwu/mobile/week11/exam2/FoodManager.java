package ddwu.mobile.week11.exam2;

import java.util.ArrayList;

public class FoodManager {
    ArrayList<Food> foodList;
    public FoodManager() {
        foodList = new ArrayList<Food>();
        foodList.add(new Food("김치찌개", "한국"));
        foodList.add(new Food("된장찌개", "한국"));
        foodList.add(new Food("훠궈", "중국"));
        foodList.add(new Food("딤섬", "중국"));
        foodList.add(new Food("초밥", "일본"));
        foodList.add(new Food("오코노미야키", "일본"));

    }

    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    public void removeData(int idx) {
        foodList.remove(idx); //원본 데이터 지우기
    }
    public void addData(Food food) {
        foodList.add(food); //원본 데이터 지우기
    }
}
