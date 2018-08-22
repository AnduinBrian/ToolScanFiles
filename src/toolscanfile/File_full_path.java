/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolscanfile;

import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author quang
 */
public class File_full_path {
    public static void write_path(String s){
        ArrayList al;
        al = new ArrayList();
        File f;
        f = new File("all_path.txt");
        try{    
            al = read_path();
            try (FileWriter fw = new FileWriter(f); PrintWriter pw = new PrintWriter(fw)){
                for(int i = 0; i < al.size(); i++){
                   pw.println((String) al.get(i));
                }
                pw.println(s);
                fw.close();
                pw.close();
            }
//            out.println("Done!");
        }catch(IOException e){
//            out.println("Error!");
        }
    }
    
public static ArrayList read_path(){
        File f;
        f = new File("all_path.txt");
        ArrayList al = new ArrayList();
        try{    
            BufferedReader br;
            int count = 0;
            try (FileReader fr = new FileReader(f)) {
                br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null){
                    al.add(line);
                }
            }
            br.close();
        }catch (IOException ex) {
//            out.println("Error!!!");
        } 
        return al;
    }
    
    public static void create_file(){
        File f;
        f = new File("all_path.txt");
        if(f.exists()){
            f.delete();
        }
    }
}
