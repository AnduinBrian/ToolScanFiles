/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolscanfile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import toolscanfile.MakeTestDirectory;
import toolscanfile.SearchInFile;
import toolscanfile.WriteFile;

/**
 *
 * @author SPlayer
 */
public class Main {

    private static String dirForScan = "D:\\university";
    private static String paths_file = "D:\\test\\all_paths.txt";
    private static String result_file = "D:\\test\\result.txt";
    private ArrayList resultPaths = new ArrayList();
    ArrayList<String> list = new ArrayList<String>();

    WriteFile writeFile = new WriteFile();
    SearchInFile searchInFile = new SearchInFile();

    public void list_all_paths(String dirPath, int level) {

        File dir = new File(dirPath);
        File[] first = dir.listFiles();

        if (first != null && first.length > 0) {
            for (File Ffile : first) {
                if (Ffile.isDirectory()) {
                    list_all_paths(Ffile.getAbsolutePath(), level + 1);
                } else {
//                    System.out.println(Ffile.getAbsolutePath());
                    list.add(Ffile.getAbsolutePath());
                }
            }
        }

    }

    public void scan(String keyword) throws IOException {

        list_all_paths(dirForScan, 0);
        ArrayList<String> full_paths = list;
//        System.out.println(scanFile.list_all_paths(dirForScan, 0));
//
//        for (int i = 0; i < full_paths.size(); i++) {
//            System.out.println(i);
//            System.err.println(full_paths.get(i));
//        }
//        writeFile.create_file(paths_file);

        writeFile.write_paths_to_file(full_paths, paths_file);
        resultPaths = searchInFile.search_in_file(paths_file, keyword);

    }

    public void displayResult() {
        for (int i = 0; i < resultPaths.size(); i++) {
            System.out.println(resultPaths.get(i));
        }
    }

    public void writeResultToFile() throws IOException {
        writeFile.create_file(result_file);
        writeFile.write_paths_to_file(resultPaths, result_file);
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Main main = new Main();
        Scanner input = new Scanner(System.in);
        System.err.println("Nhap vao tu khoa muon tim: ");
        String keyword = input.nextLine();
        main.scan(keyword);
        main.displayResult();
        main.writeResultToFile();

    }
}
