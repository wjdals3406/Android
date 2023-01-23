package ddwu.mobile.week09.adapterviewtest01;

import java.util.ArrayList;

public class DataManager {
    ArrayList<String> subjectList;
    public DataManager() {
        subjectList= new ArrayList<String>();
        subjectList.add("노르웨이숲");
        subjectList.add("러시안블루");
        subjectList.add("코리안숏헤어");
        subjectList.add("먼치킨");
        subjectList.add("터키시앙고리");
        subjectList.add("페르시안");
        subjectList.add("스코티시폴드");

    }

    public ArrayList<String> getSubjectList() {
        return subjectList;
    }

    public void removeData(int idx) {
        subjectList.remove(idx); //원본 데이터 지우기
    }
    public void addData(String subject) {
        subjectList.add(subject); //원본 데이터 지우기
    }
}
