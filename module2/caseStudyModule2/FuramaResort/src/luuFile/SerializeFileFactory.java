package luuFile;

import Emloyee.Employee;
import Modules.Customer;
import Modules.House;
import Modules.Room;
import Modules.Villa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



// phần sao chép thông tin của Villa

public class SerializeFileFactory {
    public static boolean luuFile(ArrayList<Villa> data, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
            oos.close();
            fos.close();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static ArrayList<Villa> docFile(String path) {
        ArrayList<Villa> ds = new ArrayList<Villa>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object data = ois.readObject();
            ds = (ArrayList<Villa>) data;
            ois.close();
            fis.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ds;
    }


//----------------------------------------------------------------------------------------------------------------------------------
    // Phần sao chép thông tin của House

    public static boolean luuFileHouse(ArrayList<House> data, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
            oos.close();
            fos.close();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static ArrayList<House> docFileHouse(String path) {
        ArrayList<House> ds = new ArrayList<House>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object data = ois.readObject();
            ds = (ArrayList<House>) data;
            ois.close();
            fis.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ds;
    }
    //------------------------------------------------------------------------------------------------------------------
    // phần lưu thông tin của Room

    public static boolean luuFileRoom(ArrayList<Room> data, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
            oos.close();
            fos.close();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static ArrayList<Room> docFileRoom(String path) {
        ArrayList<Room> ds = new ArrayList<Room>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object data = ois.readObject();
            ds = (ArrayList<Room>) data;
            ois.close();
            fis.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ds;
    }





    // phần lưu thông tin của Customer
    public static boolean luuFileCustomer(ArrayList<Customer> data, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
            oos.close();
            fos.close();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static ArrayList<Customer> docFileCustomer(String path) {
        ArrayList<Customer> ds = new ArrayList<Customer>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object data = ois.readObject();
            ds = (ArrayList<Customer>) data;
            ois.close();
            fis.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ds;
    }



    // Phần lưu thông tin của Employee

    public static boolean luuFileEmployee(ArrayList<Employee> data, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
            oos.close();
            fos.close();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static ArrayList<Employee> docFileEmployee(String path) {
        ArrayList<Employee> ds = new ArrayList<Employee>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object data = ois.readObject();
            ds = (ArrayList<Employee>) data;
            ois.close();
            fis.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ds;
    }
}