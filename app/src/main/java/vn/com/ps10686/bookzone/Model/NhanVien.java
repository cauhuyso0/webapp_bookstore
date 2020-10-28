package vn.com.ps10686.bookzone.Model;

public class NhanVien {
    private String _id;
    private  String tenNhanVien;
    private String luong;
    private String hinh;

    public NhanVien(String _id, String tenNhanVien, String luong, String hinh) {
        this._id = _id;
        this.tenNhanVien = tenNhanVien;
        this.luong = luong;
        this.hinh = hinh;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "_id='" + _id + '\'' +
                ", tenNhanVien='" + tenNhanVien + '\'' +
                ", luong='" + luong + '\'' +
                ", hinh='" + hinh + '\'' +
                '}';
    }
}
