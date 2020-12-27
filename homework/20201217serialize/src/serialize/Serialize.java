package serialize;

import java.io.*;

public class Serialize {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person hong = new Person("hong", Gender.female, 24);
        Person ming = new Person("ming", 22);
        Serialize main  = new Serialize();
        main.toFile(hong, "/Users/captain/Desktop/hong");
        main.toFile(ming, "/Users/captain/Desktop/ming");
        Person p1 = (Person) main.fromFile("/Users/captain/Desktop/hong");
        System.out.println(p1);
        Person p2 = (Person) main.fromFile("/Users/captain/Desktop/ming");
        System.out.println(p2);
    }

    public void toFile(Serializable obj, String filepath)throws IOException{
        try(FileOutputStream  fileOutputStream = new FileOutputStream(filepath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ) {
            objectOutputStream.writeObject(obj);
        }
    }


    public Serializable fromFile(String filepath) throws IOException, ClassNotFoundException{
        try(FileInputStream fileInputStream = new FileInputStream(filepath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            return (Serializable) objectInputStream.readObject();
        }
    }
}
