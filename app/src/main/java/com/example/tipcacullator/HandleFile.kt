package com.example.tipcacullator

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class HandleFile {

    public fun writeFile () {
        val file = File("../../assets/file.txt")
        file.createNewFile()
        val question :ArrayList<CauHoi> = DanhSachCauHoi.getAllCauHoi()
        val objectOutputFile = ObjectOutputStream(FileOutputStream(file))
        for(cauhoi in question){
            objectOutputFile.writeObject(cauhoi)
        }
        objectOutputFile.close()
    }

    public fun readFile(){
        val file = File("../../assets/file.txt")
        file.createNewFile()
        val objectInputFile = ObjectInputStream(FileInputStream(file))
        while(objectInputFile.available() != 0){
            val cau_hoi: CauHoi = objectInputFile.readObject() as CauHoi
            DanhSachCauHoi.themCauHoi(cau_hoi)
        }
        objectInputFile.close()

    }
}