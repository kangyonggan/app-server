package com.kangyonggan.as.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author kangyonggan
 * @since 7/19/18
 */
public final class IoUtil {

    private IoUtil() {
    }

    public static String read(InputStream in) throws IOException {
        try {
            byte b[] = new byte[1024];
            int len;

            StringBuilder sb = new StringBuilder();
            while ((len = in.read(b)) != -1) {
                sb.append(new String(b, 0, len));
            }

            return sb.toString();
        } catch (IOException e) {
            throw e;
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public static void write(OutputStream out, String msg) throws IOException {
        try {
            out.write(msg.getBytes());

            out.flush();
        } catch (IOException e) {
            throw e;
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
