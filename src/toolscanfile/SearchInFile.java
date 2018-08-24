/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolscanfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;

public class SearchInFile {

    public ArrayList search_in_file(String fileName, String keyWord) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        ArrayList resultPaths = new ArrayList();
        InputStream in = new FileInputStream(fileName);
        Reader reader = new InputStreamReader(in, "UTF-8");
        BufferedReader input = null;
        input = new BufferedReader(reader); // mo file path ra 
        BufferedReader result = null;
//        OutputStream out = new FileOutputStream("result.txt");
//        Writer writer = new OutputStreamWriter(out, "UTF-8"); // ghi ket qua sau khi tim kiem
        System.out.println("doc file");
        String search = input.readLine();

        while (search != null) {
            System.out.println(search);
            InputStream readf = new FileInputStream(search);
            Reader readfile = new InputStreamReader(readf, "UTF-8");
            result = new BufferedReader(readfile); //lay tung path trong search.txt
            String path = "";
            while ((path = result.readLine()) != null) {
                System.out.println(path);
                if (path.indexOf(keyWord) > 0) {
                    System.out.println("YES");
                    resultPaths.add(search);
//                    writer.write(search);
//                    writer.write("\n");
                } else {
//                    System.out.println("NO");
                }
            }
            readf.close();
            readfile.close();
            search = input.readLine();
        }
        in.close();
        reader.close();
        input.close();
        result.close();
//        writer.close();

        return resultPaths;
    }

}
