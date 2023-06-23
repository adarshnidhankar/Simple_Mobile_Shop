package Mobile_shop;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean status = true;
        while (status) {
            System.out.println("Choose Option: ");
            System.out.println("1. Add Mobile. \n2. Search Mobile. \n3. Delete Mobile. \n4. Exit. ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addMobile();
                case 2 -> searchMobile();
                case 3 -> deleteMobile();
                case 4 -> status = false;
                default -> System.out.println("Invalid Option");
            }
        }
    }

    public static void addMobile() {

        System.out.println("Enter the Model No: ");
        int id = sc.nextInt();
        System.out.println("Enter the Model name: ");
        String name = sc.next().toLowerCase();
        System.out.println("Enter the Company name: ");
        String cName = sc.next().toLowerCase();
        System.out.println("Enter the RAM: ");
        String ram = sc.next().toLowerCase();
        System.out.println("Enter the Camera Pixel: ");
        String pixel = sc.next().toLowerCase();
        System.out.println("Enter the Mobile Price: ");
        double price = sc.nextDouble();

        Mobile_DTO dto = new Mobile_DTO();
        dto.setModelNo(id);
        dto.setModelName(name);
        dto.setCompany(cName);
        dto.setRam(ram);
        dto.setCameraPixel(pixel);
        dto.setPrice(price);

        Mobile_DAO dao = new Mobile_DAO();

        int count = dao.addMobile(dto);
        System.out.println(count + " Data Inserted");
    }

    public static void searchMobile() {

        boolean status = true;
        while (status) {
            System.out.println("choose Option: ");
            System.out.println("1. Mobile by Company. \n2. Mobile by Price. \n3. Mobile by RAM. \n4. Mobile by Camera. \n5. Exit. ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> searchByCompany();
                case 2 -> searchByPrice();
                case 3 -> searchByRam();
                case 4 -> searchByCamera();
                case 5 -> status = false;
                default -> System.out.println(" Invalid Option");
            }
        }
    }

    public static void searchByCompany() {
        System.out.println("Enter the Company Name: ");
        String cName = sc.next().toLowerCase();

        Mobile_DAO dao1 = new Mobile_DAO();
        List<Mobile_DTO> data = dao1.searchByCompany(cName);
        displayData(data);
    }

    public static void searchByPrice() {
        System.out.println("Enter the Minimum Price: ");
        double price1 = sc.nextDouble();
        System.out.println("Enter the Maximum Price: ");
        double price2 = sc.nextDouble();

        Mobile_DAO dao2 = new Mobile_DAO();
        List<Mobile_DTO> data = dao2.searchByPrice(price1, price2);
        displayData(data);
    }

    public static void searchByRam() {
        String ram = "";
        System.out.println("Choose Option: ");
        System.out.println("1. 2Gb \n2. 4GB \n3. 6GB \n4. 8GB \n5 12GB ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> ram = "2gb";
            case 2 -> ram = "4gb";
            case 3 -> ram = "6gb";
            case 4 -> ram = "8gb";
            case 5 -> ram = "12gb";
            default -> System.out.println("Invalid Option");
        }
        Mobile_DAO dao2 = new Mobile_DAO();
        List<Mobile_DTO> data = dao2.searchByRam(ram);
        displayData(data);
    }

    public static void searchByCamera() {
        System.out.println("Enter the Minimum Pixel: ");
        String pixel1 = sc.next().toLowerCase();
        System.out.println("Enter the Maximum Pixel: ");
        String pixel2 = sc.next().toLowerCase();

        Mobile_DAO dao4 = new Mobile_DAO();
        List<Mobile_DTO> data = dao4.searchByCamera(pixel1, pixel2);
        displayData(data);
    }

    public static void deleteMobile() {
        System.out.println("Enter the Model No: ");
        int modelNo = sc.nextInt();

        Mobile_DAO dao5 = new Mobile_DAO();
        int count = dao5.deleteMobile(modelNo);
        System.out.println(count + " Mobile Deleted");
    }
    public static void displayData(List<Mobile_DTO> data){
        for (Mobile_DTO m1 : data) {
            System.out.println(m1.getModelNo() + "\t\t" + m1.getModelName() + "\t\t" + m1.getCompany() + "\t\t" + m1.getRam() + "\t\t" + m1.getCameraPixel() + "\t\t" + m1.getPrice());
        }
    }
}
