package com.example.tipcacullator

import java.io.Serializable

class CauHoi(private var cau_hoi: String, private var dap_an_dung: Int) : Serializable {

    constructor() : this(cau_hoi = "", dap_an_dung = 0){

    }

    public var danh_sach_dap_an = mutableListOf<String>()
    public fun getCauHoi() :String {
        return cau_hoi
    }
    public fun setCauHoi(cau_hoi :String) {
        this.cau_hoi = cau_hoi
    }
    public fun getDapAnDung(): Int{
        return dap_an_dung
    }
    public fun getAllDapAn() : MutableList<String> {
        return danh_sach_dap_an
    }
    public fun setDapAnDung(dap_an_dung: Int){
        this.dap_an_dung = dap_an_dung
    }
    public fun setDapAn(A : String, B: String, C: String, D: String){
        danh_sach_dap_an.add(A)
        danh_sach_dap_an.add(B)
        danh_sach_dap_an.add(C)
        danh_sach_dap_an.add(D)
    }
    public fun display(){
        println("Câu hỏi: $cau_hoi")
        println("A. ${danh_sach_dap_an.get(0)}")
        println("B. ${danh_sach_dap_an.get(1)}")
        println("C. ${danh_sach_dap_an.get(2)}")
        println("D. ${danh_sach_dap_an.get(3)}")
        println("Đáp án đúng $dap_an_dung")
    }
}