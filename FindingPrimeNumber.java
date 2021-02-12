import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*int[] asal = {5, 8, 10, 17, 19, 25, 26, 27, 39, 29};
        findAsalNumber(asal);*/

        Scanner scan = new Scanner(System.in);
        System.out.println("lütfen bir sayı giriniz: ");
        int number = scan.nextInt();
        ArrayList array = findAsalNumber(number);
        System.out.print(number+"'ye kadarki asal sayılar: ");
        for (Object o : array) {
            System.out.print(o + " , ");
        }
    }


    // parametre olarak girilen sayıya kadarki asal sayıları bulan method
    public static ArrayList findAsalNumber(int number) {
        int counter = 0;
        ArrayList<Integer> asalNumbers = new ArrayList<Integer>();

        for (int j = 2; j <= number; j++) {
            counter = 0;
            for (int i = 1; i <= j; i++) {
                if (j % i == 0) {
                    counter++;
                }
            }
            if (counter == 2) {
                //System.out.println(j + "==> sayısı asal sayıdır.<==");
                asalNumbers.add(j);
            }
        }
        return asalNumbers;
    }

    // kullanıcının girdiği sayıya kadar ki asal sayıları bulan method
    public static void findAsalNumber(int[] array) {
        int counter = 0;

        for (int j = 0; j < array.length; j++) {
            counter = 0;
            for (int i = 1; i <= array[j]; i++) {
                if (array[j] % i == 0) {
                    counter++;
                }
            }
            if (counter == 2) {
                System.out.println(array[j] + "=> sayısı asal sayıdır.");
            }
        }
    }
}