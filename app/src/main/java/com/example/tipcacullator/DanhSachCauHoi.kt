package com.example.tipcacullator

object DanhSachCauHoi{

    private var danh_sach_cau_hoi = ArrayList<CauHoi>()
    fun themCauHoi(cau_hoi: CauHoi){
        danh_sach_cau_hoi.add(cau_hoi)
    }
    fun suaCauHoi(i: Int, cau_hoi: CauHoi){
        danh_sach_cau_hoi[i] = cau_hoi
    }
    fun xoaCauHoi(i : Int){
        danh_sach_cau_hoi.remove(danh_sach_cau_hoi[i])
    }
    fun getAllCauHoi(): ArrayList<CauHoi>{
        return danh_sach_cau_hoi
    }
    fun getSize(): Int{
        return danh_sach_cau_hoi.size
    }
    fun getCauHoi(i : Int): CauHoi{
        return danh_sach_cau_hoi[i];
    }
    fun display(){
        for(value in danh_sach_cau_hoi){
            value.display()
        }
    }
}