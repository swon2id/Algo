import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int cases = readInt(in);
        
        byte[] buf = new byte[cases * 12]; // 충분한 버퍼
        int ptr = 0;
        
        for (int i = 0; i < cases; i++) {
            int a = readInt(in);
            int b = readInt(in);
            ptr = writeInt(buf, ptr, a + b);
            buf[ptr++] = '\n';
        }
        
        System.out.write(buf, 0, ptr - 1); // 마지막 개행 제거
    }
    
    private static int readInt(DataInputStream in) throws IOException {
        int c, n = 0;
        boolean neg = false;
        // 공백/개행 스킵
        do { c = in.read(); } while (c <= ' ');
        if (c == '-') { neg = true; c = in.read(); }
        do {
            n = n * 10 + (c - '0');
            c = in.read();
        } while (c > ' ');
        return neg ? -n : n;
    }
    
    private static int writeInt(byte[] buf, int ptr, int val) {
        if (val < 0) { buf[ptr++] = '-'; val = -val; }
        if (val == 0) { buf[ptr++] = '0'; return ptr; }
        int start = ptr;
        while (val > 0) {
            buf[ptr++] = (byte) ('0' + val % 10);
            val /= 10;
        }
        // 뒤집기
        for (int i = start, j = ptr - 1; i < j; i++, j--) {
            byte tmp = buf[i]; buf[i] = buf[j]; buf[j] = tmp;
        }
        return ptr;
    }
}