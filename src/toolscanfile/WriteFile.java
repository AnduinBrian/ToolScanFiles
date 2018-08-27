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
public class WriteFile {

    public void write_paths_to_file(ArrayList<String> paths, String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        PrintWriter pw = new PrintWriter(writer);
        for (String str : paths) {
            pw.println(str);
        }
        writer.close();
    }

    /**
     *
     * @param fileName
     * @throws IOException
     */
    public void create_file(String fileName) throws IOException {
        File f;
        f = new File(fileName);
        if (f.exists()) {
            f.delete();
        }
    }
}
