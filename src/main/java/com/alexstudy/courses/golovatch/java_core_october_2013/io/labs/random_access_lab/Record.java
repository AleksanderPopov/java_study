package golovatch.courses.io.labs.random_access_lab;

/**
 * Created by Alex on 11/10/2016.
 */
public class Record {
    public static int MAX_DATA_LENGTH = 64;
    private final int id;
    private final byte[] data;
    private final int dataLength;

    public Record(int id, byte[] data) {
        if (data == null) throw new IllegalArgumentException("'data' must be not null");
        if (data.length > MAX_DATA_LENGTH)
            throw new IllegalArgumentException("'data.length' must be less or equals than " + MAX_DATA_LENGTH);
        this.id = id;
        this.data = data;
        this.dataLength = data.length;
    }

    public int getDataLength() { return dataLength; }

    public int getId() {
        return id;
    }

    public byte[] getData() {
        return data;
    }
}
