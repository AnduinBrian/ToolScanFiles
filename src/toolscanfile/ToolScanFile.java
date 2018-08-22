/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolscanfile;

import java.io.*;
import static java.lang.System.*;
import java.util.ArrayList;
/**
 *
 * @author SPlayer
 */
public class ToolScanFile {
    
    /**
     * @param f
     * @param s
     */
    
    public static void write_path(File f, String s){
        ArrayList al = new ArrayList();
        try{    
            al = read_path(f);
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
    
    public static ArrayList read_path(File f){
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
    
    public static void get_path(){

    }
    
    public static void main(String[] args){
        // TODO code application logic here
        File f;
        f = new File("all_path.txt");
        if(f.exists()){
            f.delete();
            f = new File("all_path.txt");
        }
        write_path(f, "F:\\CTF-Writeups");
        write_path(f, "F:\\CTF-Writeups\\Isitdtu CTF Quals\\2018");
        ArrayList al = new ArrayList();
        al = read_path(f);
        for(int i = 0; i< al.size(); i++){
            out.println(al.get(i));
        }
    }
}