package adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bombgo.bombgo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import Utils.BmobUri;
import bean.channelBean;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by wuwei on 2016/10/21.
 */

public class channelAdapter extends RecyclerView.Adapter<channelAdapter.ViewHolder> {
    List<channelBean.DataBean> list;
    Context context;
    private channelAdapter.onItemClickLitener monItemClickLitener;

    public channelAdapter(Context context, List<channelBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.homeadapter_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    public void setdata( List<channelBean.DataBean> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Picasso.with(context).load(list.get(position).getThumbnail()).into(holder.homepageImg);
        holder.tvBmobTitle.setText(list.get(position).getSummary());
        holder.tvBmobZuozhe.setText(list.get(position).getName());
        if (monItemClickLitener!=null){
            holder.itemHomeCardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    monItemClickLitener.onItemClick(holder.itemView,holder.getLayoutPosition());
                }
            });
        }
    }

    public void setOnItemClickLitener(channelAdapter.onItemClickLitener monItemClickLitener){
        this.monItemClickLitener=monItemClickLitener;
    }

    @Override
    public int getItemCount() {
        return list!=null?list.size():0;
    }

    public interface onItemClickLitener{
        void onItemClick(View view,int postion);

    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.homepage_img)
        ImageView homepageImg;
        @Bind(R.id.tv_bmob_zuozhe)
        TextView tvBmobZuozhe;
        @Bind(R.id.tv_bmob_title)
        TextView tvBmobTitle;
        @Bind(R.id.item_home_cardview)
        CardView itemHomeCardview;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
