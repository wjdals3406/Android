package dduwcom.mobile.finalreport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Movie> myDataList; //원본데이터 보관
    private LayoutInflater layoutInflater;
    final static String TAG = "";

    public MyAdapter(Context context, int layout, ArrayList<Movie> myDataList) {
        this.context = context;
        this.layout = layout;
        this.myDataList = myDataList;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myDataList.size();
    }

    @Override
    public Object getItem(int i) {//i : position을 의미
        return myDataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return myDataList.get(i).get_id();
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup viewGroup) {
        final int position = pos;

        ViewHolder viewHolder;
        if(convertView == null){
            convertView = layoutInflater.inflate(layout, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.mvName = convertView.findViewById(R.id.mvName);
            viewHolder.genre = convertView.findViewById(R.id.genre);
            viewHolder.rating = convertView.findViewById(R.id.rating);
            viewHolder.imgView = (ImageView)convertView.findViewById(R.id.update_img);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.mvName.setText(myDataList.get(position).getMovieName());
        viewHolder.genre.setText(myDataList.get(position).getGenre());
        viewHolder.rating.setText(myDataList.get(position).getRating());
        viewHolder.imgView.setImageResource(myDataList.get(position).getImgIcon());

        return convertView;
    }

    static class ViewHolder {
        TextView mvName;
        TextView genre;
        TextView rating;
        ImageView imgView;
    }
}
