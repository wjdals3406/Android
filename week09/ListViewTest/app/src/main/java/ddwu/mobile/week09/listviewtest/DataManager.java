package ddwu.mobile.week09.listviewtest;

import java.util.ArrayList;

public class DataManager {
    ArrayList<String> subjectList;
    public DataManager() {
        subjectList= new ArrayList<String>();
        subjectList.add("모바일소트웨어");
        subjectList.add("네트워크");
        subjectList.add("웹서비스");
        subjectList.add("운영체제");
        subjectList.add("웹프로그래밍2");

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
