package com.example.tipcacullator

object DanhSachCauHoi{

    private var danh_sach_cau_hoi = ArrayList<CauHoi>()
    fun themCauHoi(cau_hoi: CauHoi){
        danh_sach_cau_hoi.add(cau_hoi)
    }
    fun getCauHoi(): ArrayList<CauHoi>{
        return danh_sach_cau_hoi
    }
    fun display(){
        for(value in danh_sach_cau_hoi){
            value.display()
        }
    }
}