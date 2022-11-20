import java.util.Scanner;

public class Store {
    static Scanner input = new Scanner(System.in);

    public static void run() {
        boolean isExist = true;
        while (isExist) {
            System.out.println("PatikaStore Ürün Yönetim Paneli !");
            System.out.println("1-Notebook İşlemleri");
            System.out.println("2-Cep Telefonu İşlemleri");
            System.out.println("3-Marka Listele");
            System.out.println("4-Marka Ekle");
            System.out.println("5-Marka sil");
            System.out.println("0-Çıkış!");
            System.out.println();
            System.out.print("Tercihiniz :");

            int select = input.nextInt();

            switch (select) {
                case 1:
                    System.out.println();
                    System.out.println("Notebook İşlemleri");
                    Notebook notebook = new Notebook();
                    notebook.menu();
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Cep Telefonu İşlemleri");
                    MobilePhone phone = new MobilePhone();
                    phone.menu();
                    break;
                case 3:
                    Brand.printBrand();
                    break;
                case 4:
                    Brand.addBrand();
                    System.out.println("Marka Ekle.");
                    break;
                case 5:
                    Brand.deleteBrand();
                    System.out.println("Marka sil.");
                    break;
                case 0:
                    System.out.println("Çıkış");
                    isExist = false;
                    break;
                default:
                    System.out.println();
                    System.out.println("Böyle bir seçenek yok. Lütfen seçiminizi tekrar girin.");
                    System.out.println();
            }
        }
    }
}

