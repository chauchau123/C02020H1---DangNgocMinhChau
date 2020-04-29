package Controllers;

import Modules.Customer;
import Modules.House;
import Modules.Room;
import Modules.Villa;
import TaskCheckDuLieuDauVao.RegularExpression;
import luuFile.SerializeFileFactory;


import java.io.Serializable;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Pattern;

public class MainControllers extends RegularExpression implements Serializable {

    public static void addNewService() {
        System.out.println("1.\tAdd New Villa\n" +
                "2.\tAdd New House\n" +
                "3.\tAdd New Room\n" +
                "4.\tBack to menu\n" +
                "5.\tExit\n");
        System.out.println("mời bạn lựa chọn dịch vụ theo mong muốn : ");
        int choose = new Scanner(System.in).nextInt();
        switch (choose) {
            case 1:
                System.out.println("---------------------------------------------");
                menuVilla();
                break;
            case 2:
                System.out.println("---------------------------------------------");
                menuHouse();
                break;
            case 3:
                System.out.println("---------------------------------------------");
                menuRoom();
                break;
            case 4:
                displayMainMennu();
                break;
            case 5:
                System.err.println("Bạn đã kết thúc chương trình ! Hẹn gặp lại");
                System.exit(0);
                break;
        }
    }

    //-------------------------------------------------------------------------------------------------------------------
    public static void showService() {
        System.out.println("1.\tShow all Villa\n" +
                "2.\tShow all House\n" +
                "3.\tShow all Room\n" +
                "4.\tShow All Name Villa Not Duplicate\n" +
                "5.\tShow All Name House Not Duplicate\n" +
                "6.\tShow All Name Room Not Duplicate\n" +
                "7.\tBack to menu\n" +
                "8.\tExit\n");
        System.out.println("mời bạn chọn thông tin muốn hiển thị :");
        int c = new Scanner(System.in).nextInt();
        switch (c) {
            case 1:
                System.out.println("Danh sách Villa");
                docVL();
                xuatVL();
                break;
            case 2:
                System.out.println("Danh sách House");
                docHouse();
                xuatHouse();
                break;
            case 3:
                System.out.println("Danh sách Room");
                docRoom();
                xuatRoom();
                break;
            case 4:
                showAllNameVillaNotDuplicate();
                break;
            case 5:
                showAllNameHouseNotDuplicate();
                break;
            case 6:
                showAllNameRoomNotDuplicate();
                break;
            case 7:
                displayMainMennu();
                break;
            case 8:
                System.err.println("Bạn đã thoát ra ! Hẹn gặp lại ");
                System.exit(0);
                break;

        }
    }

    //-------------------------------House--------------------------------------------------
    private static void showAllNameHouseNotDuplicate() {
        TreeSet<String> treeSetHouse = new TreeSet<>(new HashSet<>());

        for (House house : dsHouse) {
            treeSetHouse.add(house.getServiceName());
        }
        Iterator<String> iterator = treeSetHouse.iterator();
        System.out.println("Danh sách các dịch vụ House gồm có là : ");
        while (iterator.hasNext()) {
            System.out.println(count++ + ": " + iterator.next());
        }
        System.out.println("--------------------------------------------------------");
    }
//------------------------------Room-------------------------------------------------------

    private static void showAllNameRoomNotDuplicate() {
        TreeSet<String> treeSetRoom = new TreeSet<>(new HashSet<>());

        for (Room room : dsRoom) {
            treeSetRoom.add(room.getServiceName());
        }
        Iterator<String> iterator = treeSetRoom.iterator();
        System.out.println("Danh sách các dịch vụ Room gồm có là : ");
        while (iterator.hasNext()) {
            System.out.println(count++ + ": " + iterator.next());
        }
        System.out.println("--------------------------------------------------------");

    }

    //-------------------------------Villa----------------------------------------------
    private static void showAllNameVillaNotDuplicate() {
        TreeSet<String> treeSetVilla = new TreeSet<>(new HashSet<>());

        for (Villa villa : dsVL) {
            treeSetVilla.add(villa.getServiceName());
        }
        Iterator<String> iterator = treeSetVilla.iterator();
        System.out.println("Danh sách các dịch vụ Villa gồm có là : ");
        while (iterator.hasNext()) {
            System.out.println(count++ + ": " + iterator.next());
        }
        System.out.println("--------------------------------------------------------");
    }

    //----------------------------------------------------------------------------------------------------------------
    // displayMain

    public static void displayMainMennu() {

        System.out.println("1. Add New Services" + "\n" +
                "2. Show Services " + "\n" +
                "3. Add New Customer" + "\n" +
                "4. Show Information of Customer " + "\n" +
                "5. Add New Booking" + "\n" +
                "6. Show Information of Employee" + "\n" +
                "7. Exit" + "\n");
        System.out.println("mời bạn nhập vào lựa chọn");
        int choose = new Scanner(System.in).nextInt();

        switch (choose) {
            case 1:
                addNewService();
            case 2:
                showService();
        }
    }


    // Phần lưu thông tin của Villa---------------------------------------------------------------------------------------
    Scanner sc = new Scanner(System.in);

    static ArrayList<Villa> dsVL = new ArrayList<Villa>();

    public static void menuVilla() {
        System.out.println("1.Nhập Villa");
        System.out.println("2.Lưu Villa");
        System.out.println("3.Quay lại");
        System.out.println("4.Thoát");
        System.out.println("Bạn muốn làm gì ?");
        int l = new Scanner(System.in).nextInt();

        switch (l) {
            case 1:
                nhap();
                menuVilla();
                System.out.println("---------------------------------------------");
                break;
            case 2:
                luu();
                System.out.println("---------------------------------------------");
                break;
            case 3:
                addNewService();
                System.out.println("---------------------------------------------");
                break;
            case 4:
                System.err.println("Bạn đã thoát khỏi Villa !");
                System.exit(0);
                System.out.println("---------------------------------------------");
        }
    }

    private static void docVL() {
        dsVL = SerializeFileFactory.docFile("D://Hoc//hocLapTrinh//codeGym//cacModuleChuongTrinhHocCodeGym//module2//caseStudyModule2//luuFile/luuFileVilla.csv");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Đã đọc xong ! \n Đây là thông tin của Villa ! \n ");

    }

    private static void luu() {

        boolean kq = SerializeFileFactory.luuFile(dsVL, "D://Hoc//hocLapTrinh//codeGym//cacModuleChuongTrinhHocCodeGym//module2//caseStudyModule2//luuFile/luuFileVilla.csv");
        if (kq = true) {
            System.out.println("đã lưu file thành công danh sách Villa");
        } else {
            System.out.println("lưu chưa thành công danh sách Villa");
        }

    }

    private static void xuatVL() {
        for (Villa vl : dsVL) {
            System.out.println(vl);
            System.out.println("---------------------------------------------------------------------");
        }
    }

    private static void nhap() {

        System.out.println("Mã dịch vụ : (SVVL-YYYY  -  Trong đó : YYYY là 4 chữ số.)");
        String idVilla = new Scanner(System.in).nextLine();
        String test = "^S[V]{1}+V[L]{1}+[-]+[0-9]{4}$";
        Pattern.matches(test, idVilla);
        while (Pattern.matches(test, idVilla) != true) {
            System.out.println("Mời bạn nhập lại đúng định dạng : ");
            idVilla = new Scanner(System.in).nextLine();
        }

        System.out.print("Tên dịch vụ : ");
        String serviceNameVilla = new Scanner(System.in).nextLine();
        checkStandardizedName(serviceNameVilla);


        System.out.print("Diện tích sử dụng là : ");
        double areaUsedVilla = new Scanner(System.in).nextDouble();
        checkAreaUsedAndAreaPool(areaUsedVilla);

        System.out.print("Chi phí thuê là : ");
        double rentalCostsVilla = new Scanner(System.in).nextDouble();
        checkRentalCosts(rentalCostsVilla);

        System.out.print("Số lượng người tối đa : ");
        int maximumNumberOfPeopleVilla = new Scanner(System.in).nextInt();
        checkMaximumNumberOfPeople(maximumNumberOfPeopleVilla);

        System.out.print("Kiểu thuê là : ");
        String rentalTypeVilla = new Scanner(System.in).nextLine();
        checkStandardizedName(rentalTypeVilla);

        System.out.print("Tiêu chuẩn phòng là : ");
        String roomStandardVilla = new Scanner(System.in).nextLine();
        checkStandardizedName(roomStandardVilla);

        System.out.print("Mô tả tiện nghi khác : ");
        String comfortDescriptionVilla = new Scanner(System.in).nextLine();


        System.out.print("Diện tích hồ bơi là : ");
        double poolAreaVilla = new Scanner(System.in).nextDouble();
        checkAreaUsedAndAreaPool(poolAreaVilla);

        System.out.print("Số tầng : ");
        int numberOfFloorsVilla = new Scanner(System.in).nextInt();
        checkNumberOfFloors(numberOfFloorsVilla);

        Villa villa = new Villa(idVilla, serviceNameVilla, areaUsedVilla, rentalCostsVilla, maximumNumberOfPeopleVilla, rentalTypeVilla, roomStandardVilla, comfortDescriptionVilla, poolAreaVilla, numberOfFloorsVilla);
        dsVL.add(villa);

    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Phần lưu thông tin của House

    static ArrayList<House> dsHouse = new ArrayList<House>();

    public static void menuHouse() {
        System.out.println("1.Nhập vào House");
        System.out.println("2.Lưu file House");
        System.out.println("3.Quay lại");
        System.out.println("4.Thoát ");
        System.out.println("Bạn muốn làm gì ? ");
        int h = new Scanner(System.in).nextInt();

        switch (h) {
            case 1:
                nhapHouse();
                System.out.println("-------------------------------------------------");
                menuHouse();
                break;
            case 2:
                luuHouse();
                System.out.println("-------------------------------------------------");
                break;
            case 3:
                addNewService();
                System.out.println("---------------------------------------------");
                break;
            case 4:
                System.err.println("Bạn đã thoát khỏi House !");
                System.exit(0);
                System.out.println("-------------------------------------------------");
                break;
        }
    }


    private static void nhapHouse() {
        System.out.println("Mã dịch vụ : (SVHO-YYYY  -  Trong đó : YYYY là 4 chữ số.)");
        String idHouse = new Scanner(System.in).nextLine();
        String test = "^S[V]{1}+H[O]{1}+[-]+[0-9]{4}$";
        Pattern.matches(test, idHouse);
        while (Pattern.matches(test, idHouse) != true) {
            System.out.println("Mời bạn nhập lại đúng định dạng : ");
            idHouse = new Scanner(System.in).nextLine();
        }

        System.out.print("Tên dịch vụ : ");
        String serviceNameHouse = new Scanner(System.in).nextLine();
        checkStandardizedName(serviceNameHouse);

        System.out.print("Diện tích sử dụng là : ");
        double areaUsedHouse = new Scanner(System.in).nextDouble();
        checkAreaUsedAndAreaPool(areaUsedHouse);

        System.out.print("Chi phí thuê là : ");
        double rentalCostsHouse = new Scanner(System.in).nextDouble();
        checkRentalCosts(rentalCostsHouse);

        System.out.print("Số lượng người tối đa : ");
        int maximumNumberOfPeopleHouse = new Scanner(System.in).nextInt();
        checkMaximumNumberOfPeople(maximumNumberOfPeopleHouse);


        System.out.print("Kiểu thuê là : ");
        String rentalTypeHouse = new Scanner(System.in).nextLine();
        checkStandardizedName(rentalTypeHouse);


        System.out.print("Tiêu chuẩn phòng là : ");
        String roomStandardHouse = new Scanner(System.in).nextLine();
        checkStandardizedName(roomStandardHouse);


        System.out.print("Mô tả tiện nghi khác : ");
        String comfortStandardHouse = new Scanner(System.in).nextLine();


        System.out.print("Số tầng : ");
        int numberOfFloorsHouse = new Scanner(System.in).nextInt();
        checkNumberOfFloors(numberOfFloorsHouse);


        House house = new House(idHouse, serviceNameHouse, areaUsedHouse, rentalCostsHouse, maximumNumberOfPeopleHouse, rentalTypeHouse, roomStandardHouse, comfortStandardHouse, numberOfFloorsHouse);

        dsHouse.add(house);

    }

    private static void xuatHouse() {
        for (House house : dsHouse) {
            System.out.println(house);
        }
        System.out.println("--------------------------------------------------------------");
    }

    private static void luuHouse() {
        boolean kq = SerializeFileFactory.luuFileHouse(dsHouse, "D://Hoc//hocLapTrinh//codeGym//cacModuleChuongTrinhHocCodeGym//module2//caseStudyModule2//luuFile/luuFileHouse.csv");
        if (kq = true) {
            System.out.println("bạn đã lưu thành công danh sách House ");
        } else {
            System.out.println("bạn lưu chưa thành công danh sách House ");
        }
    }

    private static void docHouse() {
        dsHouse = SerializeFileFactory.docFileHouse("D://Hoc//hocLapTrinh//codeGym//cacModuleChuongTrinhHocCodeGym//module2//caseStudyModule2//luuFile/luuFileHouse.csv");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Đã đọc xong! \n Đây là thông tin của house \n");
    }


    //----------------------------------------------------------------------------------------------------------------------------
    // Room

    static ArrayList<Room> dsRoom = new ArrayList<Room>();
    static int count = 1;

    public static void menuRoom() {
        System.out.println("1.Nhập vào Room");
        System.out.println("2.Lưu file Room");
        System.out.println("3.Quay lại");
        System.out.println("4.Thoát ");
        System.out.println("Bạn muốn làm gì ? ");
        int h = new Scanner(System.in).nextInt();

        switch (h) {
            case 1:
                System.out.println("Danh sách " + count++);
                nhapRoom();
                menuRoom();
                System.out.println("---------------------------------------------");
                break;
            case 2:
                luuRoom();
                System.out.println("---------------------------------------------");
                break;
            case 3:
                addNewService();
                System.out.println("---------------------------------------------");
                break;
            case 4:
                System.err.println("Bạn đã thoát khỏi Room ! ");
                System.exit(0);
                System.out.println("---------------------------------------------");
                break;
        }
    }


    private static void xuatRoom() {
        System.out.println("Đã đọc xong! \n Đây là thông tin của Room \n");
        for (Room room : dsRoom) {
            System.out.println(room);
        }
        System.out.println("----------------------------------------------------");
    }

    private static void nhapRoom() {
        System.out.println("Mã dịch vụ : (SVRO-YYYY)");
        String idRoom = new Scanner(System.in).nextLine();
        String test = "^S[V]{1}+R[O]{1}+[-]+[0-9]{4}$";
        Pattern.matches(test, idRoom);
        while (Pattern.matches(test, idRoom) != true) {
            System.out.println("Mời bạn nhập lại đúng định dạng : ");
            idRoom = new Scanner(System.in).nextLine();
        }

        System.out.print("Tên dịch vụ : ");
        String serviceNameRoom = new Scanner(System.in).nextLine();
        checkStandardizedName(serviceNameRoom);


        System.out.print("Diện tích sử dụng là : ");
        double areaUsedRoom = new Scanner(System.in).nextDouble();
        checkAreaUsedAndAreaPool(areaUsedRoom);

        System.out.print("Chi phí thuê là : ");
        double rentalCostsRoom = new Scanner(System.in).nextDouble();
        checkRentalCosts(rentalCostsRoom);


        System.out.print("Số lượng người tối đa : ");
        int maximumNumberOfPeopleRoom = new Scanner(System.in).nextInt();
        checkMaximumNumberOfPeople(maximumNumberOfPeopleRoom);


        System.out.print("Kiểu thuê là : ");
        String rentalTypeRoom = new Scanner(System.in).nextLine();
        checkStandardizedName(rentalTypeRoom);


        System.out.print("Dịch vụ miễn phí đi kèm : ");
        String serviceFreeRoom = new Scanner(System.in).nextLine();


        Room room = new Room(idRoom, serviceNameRoom, areaUsedRoom, rentalCostsRoom, maximumNumberOfPeopleRoom, rentalTypeRoom, serviceFreeRoom);
        dsRoom.add(room);


    }

    private static void luuRoom() {
        boolean kq = SerializeFileFactory.luuFileRoom(dsRoom, "D://Hoc//hocLapTrinh//codeGym//cacModuleChuongTrinhHocCodeGym//module2//caseStudyModule2//luuFile/luuFileRoom.csv");
        if (kq = true) {
            System.out.println("bạn đã lưu thành công danh sách Room ");
        } else {
            System.out.println("bạn lưu chưa thành công danh sách Room ");
        }
    }

    private static void docRoom() {
        dsRoom = SerializeFileFactory.docFileRoom("D://Hoc//hocLapTrinh//codeGym//cacModuleChuongTrinhHocCodeGym//module2//caseStudyModule2//luuFile/luuFileRoom.csv");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Đã đọc xong! \n Đây là thông tin của Room \n");

    }


    //---------------------------- Task 5-----------------------------------


    public static void menuCustomer() throws ParseException {
        System.out.println("1. Add New Customer\t" +
                "2. Show Information Customers\t");
        System.out.println("Nhập vào lựa chọn của bạn : ");
        int choose = new Scanner(System.in).nextInt();
        switch (choose){
            case 1:
                addNewCustomer();
                break;
            case 2:
                showInfoCustomer();
                break;
        }
    }



    static ArrayList<Customer> dsCustomer = new ArrayList<Customer>();
    public static void addNewCustomer() throws ParseException {
        System.out.println("Nhập họ tên Customer ");
        String nameCustomer = new Scanner(System.in).nextLine();
        checkName(nameCustomer);



        System.out.println("Nhập ngày tháng năm sinh Customer ");
        String birthDayCustomer = new Scanner(System.in).nextLine();
        checkBirthday(birthDayCustomer);

        System.out.println("Nhập vào giới tính của Customer ");
        String genderCustomer = new Scanner(System.in).nextLine();
        checkGender(genderCustomer);

        System.out.println("Nhập vào ID của Customer ");
        String idCardCustomer = new Scanner(System.in).nextLine();
        checkIdCard(idCardCustomer);

        System.out.println("Nhập vào number Phone của Customer ");
        int phoneNumberCustomer = new Scanner(System.in).nextInt();

        System.out.println("Nhập vào email của Customer ");
        String emailCustomer = new Scanner(System.in).nextLine();
        checkEmail(emailCustomer);


        System.out.println("Nhập vào địa chỉ của Customer ");
        String addressCustomer = new Scanner(System.in).nextLine();

        System.out.println("Nhập vào dịch vụ của Customer ");
        Object services = new Scanner(System.in).nextLine();


        Customer customer = new Customer(nameCustomer, birthDayCustomer, genderCustomer, idCardCustomer,
                phoneNumberCustomer,emailCustomer,addressCustomer,services);
        dsCustomer.add(customer);
        luuCustomer();

    }
    private static void xuatCustomer() {
        for (Customer customer : dsCustomer) {
            System.out.println(customer);
        }
        System.out.println("--------------------------------------------------------------");
    }

    private static void luuCustomer() {
        boolean kq = SerializeFileFactory.luuFileCustomer(dsCustomer, "D://Hoc//hocLapTrinh//codeGym//cacModuleChuongTrinhHocCodeGym//module2//caseStudyModule2//luuFile/luuFileCustomer.csv");
        if (kq = true) {
            System.out.println("bạn đã lưu thành công danh sách Customer ");
        } else {
            System.out.println("bạn lưu chưa thành công danh sách Customer ");
        }
    }

    private static void docCustomer() {
        dsCustomer = SerializeFileFactory.docFileCustomer("D://Hoc//hocLapTrinh//codeGym//cacModuleChuongTrinhHocCodeGym//module2//caseStudyModule2//luuFile/luuFileCustomer.csv");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Đã đọc xong! \n Đây là thông tin của house \n");
    }

    public static void showInfoCustomer() {
        docCustomer();
        xuatCustomer();
    }




}



