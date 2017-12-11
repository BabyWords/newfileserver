package com.example.newfileserver.utils;

/**
 * @author 吴俊文
 * @Description
 * @Date create in:2017/11/22 18:36
 * @e-mail wujunwen@snxun.com
 */


        import java.io.BufferedWriter;
        import java.io.File;
        import java.io.FileOutputStream;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.io.OutputStreamWriter;
        import java.io.PrintWriter;
        import java.io.Writer;

public class WriteFile {

    public static void writeFile(String path,String sets) throws IOException{
//		FileWriter fw = new FileWriter(path);
//		PrintWriter out = new PrintWriter(fw);
        File file=new File(path);

        Writer writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(file), "GB2312"));
        writer.write(sets);
        //fw.close();
        writer.close();
    }
    public static void makeDirs(String path){
        File file = new File(path);
        if(!file.exists()&&!file.isDirectory()){
            file.mkdir();
        }

    }
}
