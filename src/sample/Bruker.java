package sample;


import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bruker implements Serializable {
    public static List<Bruker> brukerList=new ArrayList<Bruker>();

    private transient SimpleStringProperty navn;


    public Bruker(String navn) {
        this.navn = new SimpleStringProperty(navn);
    }



    public String getNavn() {
        return navn.get();
    }

    public SimpleStringProperty navnProperty() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn.set(navn);
    }

    @Override
    public String toString() {
        return "Bruker{" +
                "navn=" + new SimpleStringProperty("haal") +
                '}';
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeUTF(navnProperty().toString());
        s.close();
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.navn=new SimpleStringProperty((String)s.readObject());
        s.close();
        // set values in the same order as writeObject()
    }
}
