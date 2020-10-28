package vn.com.ps10686.bookzone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vn.com.ps10686.bookzone.Model.HoaDonFinal;
import vn.com.ps10686.bookzone.Model.NhanVien;
import vn.com.ps10686.bookzone.Model.Sach1;
import vn.com.ps10686.bookzone.R;
import vn.com.ps10686.bookzone.api.RetrofitClient;

import static vn.com.ps10686.bookzone.api.RetrofitClient.ROOT_URL;

public class NhanVienAdapter extends BaseAdapter {

    Context context;
    int layout;
    ArrayList<NhanVien> nhanVienss;
    RetrofitClient retrofitClient;

    public NhanVienAdapter(Context context, int layout, ArrayList<NhanVien> nhanVienss) {
        this.context = context;
        this.layout = layout;
        this.nhanVienss = nhanVienss;
    }

    @Override
    public int getCount() {
        return nhanVienss.size();
    }

    @Override
    public Object getItem(int i) {
        return nhanVienss.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class ViewHolder{
        ImageView imvNhanVien;
        TextView tvMaNV;
        TextView tvTenNV;
        TextView tvLuong;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        NhanVienAdapter.ViewHolder holder;

        if (view == null){
            holder = new NhanVienAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.imvNhanVien = (ImageView) view.findViewById(R.id.ivNhanVien);
            holder.tvMaNV = (TextView) view.findViewById(R.id.tvMaNV);
            holder.tvTenNV = (TextView) view.findViewById(R.id.tvTenNV);
            holder.tvLuong = (TextView) view.findViewById(R.id.tvLuong);
            view.setTag(holder);
        }else {
            holder = (NhanVienAdapter.ViewHolder) view.getTag();
        }

        NhanVien nhanVien = nhanVienss.get(i);

        Picasso.with(context).load( ROOT_URL + nhanVien.getHinh().substring(7)).into(holder.imvNhanVien);
        holder.tvMaNV.setText(nhanVien.get_id()  + "something");
        holder.tvTenNV.setText(nhanVien.getTenNhanVien() + "test") ;
        holder.tvLuong.setText(nhanVien.getLuong() + "tes");

        return view;
    }

}
