package mp4;

import classExplanation.mp1.Movie;

import java.io.*;

import static classExplanation.mp1.Movie.EXTENT_FILE;

public class ExtentHelper
{
    public static void saveAllClassExtents() throws IOException
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(EXTENT_FILE)))
        {
            Movie.saveExtent(oos);
        }


    }

    public static void loadAllClassExtents() throws IOException, ClassNotFoundException
    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(EXTENT_FILE)))
        {
            Movie.loadExtent(ois);
        }
    }
}

