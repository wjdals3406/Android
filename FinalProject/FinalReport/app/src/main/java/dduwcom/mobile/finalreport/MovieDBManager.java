package dduwcom.mobile.finalreport;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class MovieDBManager {
    MovieDBHelper movieDBHelper;
    Cursor cursor = null;
    public MovieDBManager(Context context) {
        movieDBHelper = new MovieDBHelper(context);
    }

    public ArrayList<Movie> getAllFood() {
        ArrayList movieList = new ArrayList();
        SQLiteDatabase db = movieDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + MovieDBHelper.TABLE_NAME, null);

        while(cursor.moveToNext()) {
            long id = cursor.getInt(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_ID));
            String movieName = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_MOVIES));
            String genre = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_GENRE));
            String rating = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_RATING));

            String director = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_DIRECTOR));
            String actor = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_ACTOR));
            String date = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_DATE));

            if (movieName.equals("어바웃타임")) movieList.add ( new Movie (id, movieName, genre, rating, R.mipmap.abouttime, director, actor, date) );
            else if (movieName.equals("해리포터")) movieList.add ( new Movie (id, movieName, genre, rating, R.mipmap.harrypotter, director, actor, date) );
            else if (movieName.equals("인셉션")) movieList.add ( new Movie (id, movieName, genre, rating, R.mipmap.inception, director, actor, date) );
            else if (movieName.equals("킹스맨")) movieList.add ( new Movie (id, movieName, genre, rating, R.mipmap.kingsman, director, actor, date) );
            else if (movieName.equals("기생충")) movieList.add ( new Movie (id, movieName, genre, rating, R.mipmap.parasite, director, actor, date) );
            else movieList.add ( new Movie (id, movieName, genre, rating, R.mipmap.kakao, director, actor, date) );
        }

        cursor.close();
        movieDBHelper.close();
        return movieList;
    }

    //    DB 에 새로운 food 추가
    public boolean addNewMovie(Movie newFood) {
        SQLiteDatabase db = movieDBHelper.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(MovieDBHelper.COL_MOVIES, newFood.getMovieName());
        value.put(MovieDBHelper.COL_GENRE, newFood.getGenre());
        value.put(MovieDBHelper.COL_RATING, newFood.getRating());

//      insert 메소드를 사용할 경우 데이터 삽입이 정상적으로 이루어질 경우 1 이상, 이상이 있을 경우 0 반환 확인 가능
        long count = db.insert(MovieDBHelper.TABLE_NAME, null, value);
        if (count > 0) return true;
        return false;
    }

    public boolean modifyMovie(Movie movie) {
        SQLiteDatabase sqLiteDatabase = movieDBHelper.getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put(MovieDBHelper.COL_MOVIES, movie.getMovieName());
        row.put(MovieDBHelper.COL_GENRE, movie.getGenre());
        row.put(MovieDBHelper.COL_RATING, movie.getRating());
        row.put(MovieDBHelper.COL_DIRECTOR, movie.getMovieName());
        row.put(MovieDBHelper.COL_ACTOR, movie.getGenre());
        row.put(MovieDBHelper.COL_DATE, movie.getRating());

        String whereClause = MovieDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(movie.get_id()) };

        int result = sqLiteDatabase.update(MovieDBHelper.TABLE_NAME, row, whereClause, whereArgs);
        movieDBHelper.close();
        if (result > 0) return true;
        return false;
    }

    //    _id 를 기준으로 DB에서 food 삭제
    public boolean removeMovie(long id) {
        SQLiteDatabase sqLiteDatabase = movieDBHelper.getWritableDatabase();
        String whereClause = MovieDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(id)}; //id는 long타입이라 String으로 바꿔줘야 함
        int result = sqLiteDatabase.delete(MovieDBHelper.TABLE_NAME, whereClause, whereArgs);
        movieDBHelper.close();
        if (result > 0) return true;
        return false;
    }

    //    나라 이름으로 DB 검색
    public Movie getMovieByTitle(String title) {
//        ArrayList movieList = new ArrayList();
        SQLiteDatabase db = movieDBHelper.getReadableDatabase();
        String whereClause = MovieDBHelper.COL_MOVIES + "=?";
        String[] whereArgs = new String[] { title };
        Cursor cursor = db.query(MovieDBHelper.TABLE_NAME, null, whereClause, whereArgs, null, null, null, null);

        while(cursor.moveToNext()) {
            long id = cursor.getInt(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_ID));
            String movieName = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_MOVIES));
            String genre = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_GENRE));
            String rating = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_RATING));

            String director = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_DIRECTOR));
            String actor = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_ACTOR));
            String date = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_DATE));

            if (movieName.equals("어바웃타임")) return new Movie(id, movieName, genre, rating, R.mipmap.abouttime, director, actor, date);
            else if (movieName.equals("해리포터")) return new Movie (id, movieName, genre, rating, R.mipmap.harrypotter, director, actor, date) ;
            else if (movieName.equals("인셉션")) return new Movie (id, movieName, genre, rating, R.mipmap.inception, director, actor, date) ;
            else if (movieName.equals("킹스맨")) return new Movie (id, movieName, genre, rating, R.mipmap.kingsman, director, actor, date) ;
            else if (movieName.equals("기생충")) return new Movie (id, movieName, genre, rating, R.mipmap.parasite, director, actor, date) ;
            else return new Movie (id, movieName, genre, rating, R.mipmap.kakao, director, actor, date);

//            if (movieName.equals("어바웃타임")) movieList.add ( new Movie (id, movieName, genre, rating, R.mipmap.abouttime, director, actor, date) );
//            else if (movieName.equals("해리포터")) movieList.add ( new Movie (id, movieName, genre, rating, R.mipmap.harrypotter, director, actor, date) );
//            else if (movieName.equals("인셉션")) movieList.add ( new Movie (id, movieName, genre, rating, R.mipmap.inception, director, actor, date) );
//            else if (movieName.equals("킹스맨")) movieList.add ( new Movie (id, movieName, genre, rating, R.mipmap.kingsman, director, actor, date) );
//            else if (movieName.equals("기생충")) movieList.add ( new Movie (id, movieName, genre, rating, R.mipmap.parasite, director, actor, date) );
//            else movieList.add ( new Movie (id, movieName, genre, rating, R.mipmap.kakao, director, actor, date) );
        }

        cursor.close();
        movieDBHelper.close();

        return null;
    }


    //    close 수행
    public void close() {
        if (movieDBHelper != null) movieDBHelper.close();
        if (cursor != null) cursor.close();
    };

}
