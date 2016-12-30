package golovatch.courses.io.labs.random_access_lab;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * Created by Alex on 11/10/2016.
 */
public class RecordStorage implements AutoCloseable {
    private static final int INT_SIZE_IN_BYTES = 4;
    private final RandomAccessFile file;

    public RecordStorage(String fileName) throws FileNotFoundException {
        this.file = new RandomAccessFile(fileName, "rw");
    }

    public void write(Record record, int index) throws IOException {
        // seek to record position in file
//        file.seek(index * (INT_SIZE_IN_BYTES + Record.MAX_DATA_LENGTH));
        // write fields
//        file.writeInt(record.getId());
//        file.write(record.getData());

        // seek to record position in file
        System.out.println("Write start, filePointer is " + file.getFilePointer());
        System.out.println("Record object'" + index + "',id = " + record.getId() + ", dataLength = " + record.getDataLength() + ", data = " + Arrays.toString(record.getData()));
        // write fields
        file.writeInt(record.getId());
        file.writeInt(record.getDataLength());
        file.write(record.getData());
        System.out.println("Writing record object '" + index + "' done, filePointer is " + file.getFilePointer());
    }

    public Record read(int index) throws IOException {
        // seek to record position in file
//        file.seek(index * (INT_SIZE_IN_BYTES + Record.MAX_DATA_LENGTH));
        // read fields
//        int id = file.readInt();
//        byte[] data = new byte[Record.MAX_DATA_LENGTH];
//        file.readFully(data);
        // return
//        return new Record(id, data);

        System.out.println("Read start, filePointer is " + file.getFilePointer());
        // seek to record position in file
        for (int i = 0; i < index; i++) {
            System.out.println("skip record object '" + i + "' to reach record object '" + index + "'");
            // read id field
            int id = file.readInt();
            System.out.println("id is " + id);
            // read dataLength field
            int dataLength = file.readInt();
            System.out.println("dataLength is " + dataLength);
            // skip byte[] field
            System.out.println("File pointer before seek is " + file.getFilePointer());
//            file.seek(dataLength + INT_SIZE_IN_BYTES*2);
            file.readFully(new byte[dataLength]);
            System.out.println("File pointer after seek is " + file.getFilePointer());
        }

        // read fields
        int id = file.readInt();
        int dataLength = file.readInt();
        byte[] data = new byte[dataLength];
        file.readFully(data);
        System.out.println("Record object '" + index + "' successfully readed, id = " + id + ", dataLength = " + dataLength + ", data = " + Arrays.toString(data));
        // set filePointer to zero, for future search
        file.seek(0);
        return new Record(id, data);
    }

    public void flush() throws IOException {
        file.getChannel().force(true);
        file.getFD().sync();
    }

    @Override
    public void close() throws IOException {
        file.close();
    }
}