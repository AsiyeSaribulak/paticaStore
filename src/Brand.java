import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Brand {
    private int brandId;
    private String brandName;

    private static Scanner input = new Scanner(System.in);

    public Brand(int brandId, String brandName) {
        this.brandId = brandId;
        this.brandName = brandName;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    private static TreeSet<Brand> brandList = new TreeSet<>(new Comparator<Brand>() {
        @Override
        public int compare(Brand o1, Brand o2) {
            return o1.getBrandName().compareTo(o2.getBrandName());
        }
    });

    public static void addBrand() {
        System.out.println("Marka id'si giriniz: ");
        int id = input.nextInt();
        System.out.println("Marka adı giriniz:");
        String name = input.next();
        brandList.add(new Brand(id, name));
    }

    public static void deleteBrand() {
        printBrand();
        System.out.println("Silmek isteğiniz markanın id'si: ");
        int id = input.nextInt();
        for (Brand brand : brandList) {
            if (id == brand.getBrandId()) {
                brandList.remove(brand);
            }
        }
    }

    public static void creatBrand() {
        brandList.add(new Brand(1, "Apple"));
        brandList.add(new Brand(2, "Asus"));
        brandList.add(new Brand(3, "Casper"));
        brandList.add(new Brand(4, "Hp"));
        brandList.add(new Brand(5, "Huawei"));
        brandList.add(new Brand(6, "Lenovo"));
        brandList.add(new Brand(7, "Monster"));
        brandList.add(new Brand(8, "Samsung"));
        brandList.add(new Brand(9, "Xiaomi"));

    }

    public static void printBrand() {
        creatBrand();
        System.out.println("Markalarımız:");
        for (Brand brand : brandList) {
            System.out.println(brand.getBrandId() + " " + "-" + " " + brand.getBrandName());
        }
        System.out.println("-------------------------------");
    }

    public static Brand getBrand(int id) {
        Brand temp = null;
        for (Brand brand : brandList) {
            if (id == brand.getBrandId()) {
                temp = brand;
            }
        }
        return temp;
    }
}
