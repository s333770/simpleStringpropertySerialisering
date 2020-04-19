package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.beans.PropertyEditorSupport;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static sample.Bruker.brukerList;

public class Controller implements Serializable {



    @FXML
    private TextField txtNavn;



    public void btnSerialiser(ActionEvent actionEvent) throws IOException {
        FileOutputStream fos=new FileOutputStream("bruker.txt");
        ObjectOutputStream os=new ObjectOutputStream(fos);
        os.writeObject(brukerList.get(0).getNavn());
        os.close();
        fos.close();
    }

    public void btnDeserialiser(ActionEvent actionEvent) throws IOException, ClassNotFoundException {

        FileInputStream fis=new FileInputStream("bruker.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        try{
            String result=(String)ois.readObject();
            System.out.println("hello");
        }
        catch(EOFException e){
            System.out.println("ferdig med inputstream");
        }











    }

    public void btnLagre(ActionEvent actionEvent) {
        brukerList.add(new Bruker(txtNavn.getText()));
        System.out.println(brukerList.get(0).getNavn());



    }
}
