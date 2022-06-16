package com.atviettelsolutions.plugin.help;

import java.io.*;

public class WriteFileToTemp {
    public File write(InputStream inputStream) throws IOException {
        File tempFile = File.createTempFile("test", "test");
        try(OutputStream outputStream = new FileOutputStream(tempFile)){
            int length;
            byte[] buffer = new byte[1024];
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        }
        return tempFile;
    }
}
