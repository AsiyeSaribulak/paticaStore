import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone extends Product {
    private int battery;
    private String color;
    private static ArrayList<MobilePhone> phoneList = new ArrayList<>();
    private Scanner input=new Scanner(System.in);
    public MobilePhone(){

    }
    public MobilePhone(int id, String name, double price, int discountRate, int stock, String screenSize, int ram,
                       int storage, Brand brand,int battery,String color) {
        super(id, name, price, discountRate, stock, screenSize, ram, storage, brand);
        this.battery=battery;
        this.color=color;

    }
    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public void menu() {
        System.out.println("1- Mevcut telefonları listele\n" +
                "2- Yeni telefon ekle\n" +
                "3- Telefon sil\n" +
                "4- Telefonları id numarasına göre sırala\n" +
                "5- Telefonları markaya göre filtrele\n"+
                "0- Panelden çık");
        System.out.println();
        System.out.println("Yapmak istediğiniz işlemi seçiniz : ");
        int select= input.nextInt();
        switch(select){
            case 1:
                getProduct();
                break;
            case 2:
                addItem();
                break;
            case 3:
                deleteItem();
                break;
            case 4:
                getProduct();
                break;
            case 5:
                brandFilter();
                break;
            case 0:
                break;
            default:
                System.out.println("Böyle bir seçenek yok. Lütfen seçiminizi tekrar giriniz.");
                break;
        }

    }

    private void brandFilter() {
        getProduct();
        ArrayList<MobilePhone> filterMobilePhones=new ArrayList<>();
        System.out.print("Filtrelemek istediğiniz markayı girin:");
        String filterBrand=input.next();
        for(MobilePhone phone:phoneList){
            if(filterBrand.equals(phone.getBrand().getBrandName())){
                filterMobilePhones.add(phone);
            }
        }
        print(filterMobilePhones);

    }

    @Override
    public void addItem() {
        System.out.println("Cep telefonun id'sini giriniz:");
        int id =input.nextInt();
        System.out.println("Cep telefonun adını giriniz:");
        String name=input.next();
        System.out.println("Cep telefonun fiyatını giriniz:");
        double price=input.nextDouble();
        System.out.println("İndirim oranını giriniz:");
        int discountRate=input.nextInt();
        System.out.println("Stok sayısını giriniz:");
        int stock=input.nextInt();
        System.out.println("Ekran boyutunu giriniz:");
        String screenSize = input.next();
        System.out.println("Ram boyutunu giriniz:");
        int ram=input.nextInt();
        System.out.println("Telefon depolama alanını giriniz:");
        int storage=input.nextInt();
        System.out.println("Telefon pil kapasitesini girin:");
        int battery=input.nextInt();
        System.out.println("Telefon rengini giriniz:");
        String color=input.next();

        Brand.printBrand();
        System.out.println("Lütfen marka id'sini seçin:");
        Brand brand=Brand.getBrand(input.nextInt());
        MobilePhone phone=new MobilePhone(id, name, price, discountRate, stock, screenSize, ram, storage, brand, battery, color);
        phoneList.add(phone);
        System.out.println("Telefon eklendi" + phone.getId()+" " + "-"+ " "+phone.getName());
    }


    @Override
    public void getProduct() {
        print(null);
    }

    @Override
    public void deleteItem() {
        getProduct();
        System.out.print("Silinmesini istediğiniz ürünün id'sini giriniz:");
        int id=input.nextInt();
        phoneList.remove(id-1);
        System.out.println("Güncel liste");
        getProduct();
    }

    private void print(ArrayList<MobilePhone> phones) {
        if(phones==null) phones=phoneList;
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                  | Fiyat          | Marka         | Stok Miktarı        | İndirim Oranı      | RAM    | Ekran Boyutu      | Depolama   | Pil Kapasitesi  | Renk           |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (MobilePhone n:phones){
            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | %-15s | %-14s | \n",
                    n.getId(),n.getName(),n.getPrice(),n.getBrand().getBrandName(),n.getStock(),
                    n.getDiscountRate(),n.getRam(),n.getScreenSize(),n.getStorage(),n.getBattery(),n.getColor());
        }

    }
}
