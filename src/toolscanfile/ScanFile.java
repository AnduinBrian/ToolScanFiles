/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolscanfile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author huyhu
 */
public class ScanFile {

    public ArrayList<String> list_all_paths(String dirPath, int level) {
        ArrayList<String> list = new ArrayList<String>();
        File dir = new File(dirPath);
        File[] first = dir.listFiles();

        if (first != null && first.length > 0) {
            for (File Ffile : first) {
                if (Ffile.isDirectory()) {
                    list_all_paths(Ffile.getAbsolutePath(), level + 1);
                } else {
                    System.out.println(Ffile.getAbsolutePath());
                    list.add(Ffile.getAbsolutePath());
                }
            }
        }
        return list;
    }

//    public static void main (String[] args){
//        ScanFile scan = new ScanFile();       
//        scan.listDir("F:\\TaiLieu", 0);
//        }
}
