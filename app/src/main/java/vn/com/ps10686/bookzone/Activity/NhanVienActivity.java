package vn.com.ps10686.bookzone.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.com.ps10686.bookzone.Adapter.NhanVienAdapter;
import vn.com.ps10686.bookzone.Model.NhanVien;
import vn.com.ps10686.bookzone.Model.Sach1;
import vn.com.ps10686.bookzone.R;
import vn.com.ps10686.bookzone.api.API;
import vn.com.ps10686.bookzone.api.RetrofitClient;

public class NhanVienActivity extends AppCompatActivity {
    RetrofitClient retrofitClient = new RetrofitClient();
    NhanVienAdapter adapter;
    public static ArrayList<NhanVien> nhanViens = new ArrayList<>();
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien);
        lv = findViewById(R.id.lv_nhanvien);



        API api = retrofitClient.getClien().create(API.class);
        api.getNhanVien().enqueue(new Callback<List<NhanVien>>() {
            @Override
            public void onResponse(Call<List<NhanVien>> call, Response<List<NhanVien>> response) {
                List<NhanVien> ds = response.body();
//                myNotify(ds);
                System.out.println("nhanvien: " + ds);

//                for (int i = 0; i <ds.size(); i++){
//                    NhanVien nhanVien = ds.get(i);
//                    nhanViens.add(nhanVien);
//                }
                System.out.println(nhanViens);
            }

            @Override
            public void onFailure(Call<List<NhanVien>> call, Throwable t) {
                Log.i("Sach", t.getMessage());
            }
        });

        adapter = new NhanVienAdapter(this, R.layout.row_list_nv, nhanViens);
        System.out.println("list:" + nhanViens);

        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
//    public void myNotify(List<NhanVien> danhsah){
//            nhanViens.clear();
//            nhanViens.addAll(danhsah);
//            adapter.notifyDataSetChanged();
//        }
    }

