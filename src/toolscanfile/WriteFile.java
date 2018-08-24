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

    public void write_paths_to_file(ArrayList paths, String fileName) throws IOException {
        File f;
        f = new File(fileName);

        try (FileWriter fw = new FileWriter(f); PrintWriter pw = new PrintWriter(fw)) {
            for (int i = 0; i < paths.size(); i++) {
                pw.println((String) paths.get(i));
            }
            pw.println(paths);
            fw.close();
            pw.close();
        }
    }
    

    public void create_file(String fileName) {
        File f;
        f = new File(fileName);
        if (f.exists()) {
            f.delete();
        }
    }
}
