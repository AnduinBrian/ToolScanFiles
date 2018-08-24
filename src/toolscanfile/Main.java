/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolscanfile;
import java.util.ArrayList;
import toolscanfile.MakeTestDirectory;
import toolscanfile.ScanFile;
import toolscanfile.SearchInFile;
import toolscanfile.WriteFile;
/**
 *
 * @author SPlayer
 */
public class Main {
    
    private static String dirForScan = "F:\\\\TaiLieu";
    
    public void scan(){
        ScanFile scanFile = new ScanFile();
        WriteFile writeFile = new WriteFile();
        SearchInFile searchInFile = new SearchInFile();
        
        ArrayList full_paths = scanFile.list_all_paths(dirForScan,0);
        
    }
    
    /**
     * @param args
     */
    public static void main(String[] args){
        // TODO code application logic here
        
    }
}