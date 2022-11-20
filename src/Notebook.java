import java.util.ArrayList;
import java.util.Scanner;

public class Notebook extends Product {
    private Scanner input = new Scanner(System.in);
    private static ArrayList<Notebook> notebookList = new ArrayList<>();

    public Notebook() {

    }

    public Notebook(int id, String name, double price, int discountRate, int stock, String screenSize, int ram,
                    int storage, Brand brand) {
        super(id, name, price, discountRate, stock, screenSize, ram, storage, brand);
    }

    @Override
    public void menu() {
        System.out.println("1- Mevcut bilgisayarları listele\n" +
                "2- Yeni bilgisayar ekle\n" +
                "3- bilgisayar sil\n" +
                "4- bilgisayarı id numarasına göre sırala\n" +
                "5- bilgisayarı markaya göre filtrele\n"+
                "0- Panelden çık");
        System.out.println();
        System.out.print("Tercihiniz:");
        int select = input.nextInt();
        switch (select) {
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
        ArrayList<Notebook> filterNotebooks = new ArrayList<>();
        System.out.print("Filtrelemek istediğiniz markayı girin:");
        String filterBrand = input.next();
        for (Notebook notebook : notebookList) {
            if (filterBrand.equals(notebook.getBrand().getBrandName())) {
                filterNotebooks.add(notebook);
            }
        }
        print(filterNotebooks);

    }

    @Override
    public void addItem() {
        System.out.println("Bilgisayarın id'sini giriniz:");
        int id = input.nextInt();
        System.out.println("Bilgisayarın adını giriniz:");
        String name = input.next();
        System.out.println("Bilgisayarın fiyatını giriniz:");
        double price = input.nextDouble();
        System.out.println("İndirim oranını giriniz:");
        int discountRate = input.nextInt();
        System.out.println("Stok sayısını giriniz:");
        int stock = input.nextInt();
        System.out.println("Ekran boyutunu giriniz:");
        String screenSize = input.next();
        System.out.println("Ram boyutunu giriniz:");
        int ram = input.nextInt();
        System.out.println("Bilgisayarın depolama alanını giriniz:");
        int storage = input.nextInt();


        Brand.printBrand();
        System.out.println("Lütfen marka id'sini seçin:");
        Brand brand = Brand.getBrand(input.nextInt());
        Notebook notebook = new Notebook(id, name, price, discountRate, stock, screenSize, ram, storage, brand);
        notebookList.add(notebook);
        System.out.println("Bilgisayar eklendi:" + notebook.getId() + "-" + notebook.getName());
    }

    public void print(ArrayList<Notebook> notebook) {
        if (notebook == null) notebook = notebookList;
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                  | Fiyat          | Marka         | Stok Miktarı        | İndirim Oranı      | RAM    | Ekran Boyutu      | Depolama   |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Notebook n : notebook) {
            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | \n",
                    n.getId(), n.getName(), n.getPrice(), n.getBrand().getBrandName(), n.getStock(),
                    n.getDiscountRate(), n.getRam(), n.getScreenSize(), n.getStorage());
        }
    }

    @Override
    public void getProduct() {
        print(null);
    }

    @Override
    public void deleteItem() {
        getProduct();
        System.out.print("Silinmesini istediğiniz ürünün id'sini giriniz:");
        int id = input.nextInt();
        notebookList.remove(id-1);
        System.out.println("Güncel liste");
        getProduct();

    }

}
