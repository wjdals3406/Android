package dduwcom.mobile.finalreport;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MovieDBHelper extends SQLiteOpenHelper {
    final static String TAG = "MovieDBHelper";
    final static String DB_NAME = "movies.db";
    public final static String TABLE_NAME = "movie_table";
    public final static String COL_ID = "_id";
    public final static String COL_MOVIES = "moviename";
    public final static String COL_GENRE = "genre";
    public final static String COL_RATING = "rating";
    public final static String COL_DIRECTOR = "director";
    public final static String COL_ACTOR = "actor";
    public final static String COL_DATE = "date";


    public MovieDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, " +
                COL_MOVIES + " TEXT, " + COL_GENRE + " TEXT, " + COL_RATING+ " TEXT, "
                + COL_DIRECTOR + " TEXT, " + COL_ACTOR + " TEXT, " + COL_DATE  +" TEXT)";
        Log.d(TAG, sql);
        db.execSQL(sql);
        insertSample(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    private void insertSample(SQLiteDatabase db) {
        db.execSQL("insert into " + TABLE_NAME + " values (null, '어바웃타임', '로맨스', '9.3', '리차드 커티스', '도널 글리슨, 레이첼 맥아담스', '2013.12.05');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '해리포터', '판타지', '9.41', '크리스 콜럼버스', '다니엘 래드클리프, 엠마 왓슨, 루퍼트 그린트','2001.12.14');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '인셉션', '액션', '9.6', '크리스토퍼 놀란', '레오나르도 디카프리오, 와타나베 켄, 조셉 고든 레빗','2010.07.21');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '킹스맨', '액션', '9.02', '매튜 본', '콜린 퍼스, 태런 에저튼', '2015.02.11');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '기생충', '드라마', '9.07', '봉준호', '송강호, 이선균, 조여정', '2019.05.30');");

    }

}

