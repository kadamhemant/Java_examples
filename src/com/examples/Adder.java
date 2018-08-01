package com.examples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;

/**
 * Hello world!
 *
 */
public class Adder implements Callable<Integer> {

    private Path inFile;

    public Adder(Path inFile)
    {
        this.inFile=inFile;
    }

    public int doAdd() throws IOException {
        int total=0;
        String line=null;

        try(BufferedReader reader= Files.newBufferedReader(inFile))
        {
            while((line=reader.readLine())!=null)
            {
                total+=Integer.parseInt(line);
                System.out.println("Adding Value "+Integer.parseInt(line)+" from file "+inFile.getFileName()+", Now total:- "+total);
            }
        }

        return total;

        /*try(BufferedWriter writer=Files.newBufferedWriter(outFile)){

            writer.write("Total: "+total);
        }*/
    }

    @Override
    public Integer call() throws IOException {

    return doAdd();
    }

    }


