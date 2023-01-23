package ddwu.mobile.week10.customadaptertest;

import java.util.ArrayList;

public class DataManager {
    ArrayList<MyData> dataList;

    public DataManager() {
        dataList = new ArrayList<MyData>();
        dataList.add(new MyData(1, "홍길동", "012345"));
        dataList.add(new MyData(2, "전우치", "123456"));
        dataList.add(new MyData(3, "일자매", "234567"));

    }

    public ArrayList<MyData> getDataList() {
        return dataList;
    }

    //    삭제
    public void removeData(int idx) {
        dataList.remove(idx);
    }


}
