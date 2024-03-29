package omnisketch;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public abstract class Record implements Externalizable {
    int id;
    long[] record = new long[Main.numAttributes];
    int ph = -999;
    long phl = -999;
    long timestamp = 0;
    public boolean assembled = false;


    public Record() {
    }


    public Record(int id, long[] record) {
        this.record = record;
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public long[] getRecord() {
        return record;
    }

    public String toString() {
        return "ID: " + id + " org.Record: " + Arrays.toString(record);
    }

    public int nullHandler(String a) {
        if (a.equals(""))
            return ph;
        else
            return parseInt(a);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeObject(record);
        out.writeLong(timestamp);
        //out.writeBoolean(isQuery);
        //out.writeObject(predAttrs);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.id = in.readInt();
        this.record = (long[]) in.readObject();
        this.timestamp = in.readLong();
        //this.isQuery = in.readBoolean();
        //this.predAttrs = (ArrayList<Integer>) in.readObject();
    }

    public abstract void assemble(int id);

    public void add(String[] a) {
        System.out.println("org.Record.add() called");
    }

}
