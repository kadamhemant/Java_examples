package com.examples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Hello world!
 *
 */
public class Adder implements Runnable {

    private Path inFile,outFile;

    public Adder(Path inFile, Path outFile)
    {
        this.inFile=inFile;
        this.outFile=outFile;
    }

    public void doAdd() throws IOException {
        int total=0;
        String line=null;

        try(BufferedReader reader= Files.newBufferedReader(inFile))
        {
            while((line=reader.readLine())!=null)
            {
                total+=Integer.parseInt(line);
                System.out.println(total);
            }
        }

        try(BufferedWriter writer=Files.newBufferedWriter(outFile)){

            writer.write("Total: "+total);
        }
    }

    @Override
    public void run() {
        try {
            doAdd();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

