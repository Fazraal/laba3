package com.company;

import java.io.*;

public class Stream {

    public static void serializeBuilding(ControllerClass students, OutputStream out) throws IOException {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(out);
            outputStream.writeObject(students);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static ControllerClass deserializeBuilding(InputStream in) throws ClassNotFoundException {
        ControllerClass students = null;
        try {
            ObjectInputStream inputStream = new ObjectInputStream(in);
            students = (ControllerClass) inputStream.readObject();
            inputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return students;
    }


}
