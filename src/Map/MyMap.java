package Map;

import java.util.ArrayList;
import java.util.Scanner;

public class MyMap <K, V>{

    private final ArrayList<K> key;
    private final ArrayList<V> value;

    public MyMap() {
        this.key = new ArrayList<>();
        this.value = new ArrayList<>();
    }

    public void put(K key, V value){
        if (this.key.contains(key)) { //if key exist
            this.value.set(this.key.indexOf(key), value);
        } else { //if key does not exist
            this.key.addLast(key);
            this.value.addLast(value);
        }
    }

    public V get(K key){
        if (this.key.contains(key)){
            return this.value.get(this.key.indexOf(key));
        }
        return null; //if does not exist
    }

    public V remove(K key){
        if (this.key.contains(key)){
            int temp = this.key.indexOf(key);
            V ret = this.value.get(temp);
            value.remove(temp);
            this.key.remove(this.key.indexOf(key));
            return ret;
        }
        return null; //if does not exist
    }

    //para makita nako if sa last bha gyud sha na insert ehe
    public void print(){
        System.out.print("Keys: ");
        for (K k : key){
            System.out.print(k + " ");
        }
        System.out.println();
        System.out.print("Values: ");
        for (V v : value){
            System.out.print(v + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

//        MyMap<Integer, Number> mm = new MyMap<Integer, Number>();
        MyMap<Integer, String> mm = new MyMap<Integer, String>();

//        Number v;
        String v;
        int k;
        char op;

        System.out.println("Operations: \np - put()\tg - get()\tr - remove()\ta - print everything in the arraylist\tx - close program");
        do{
            System.out.print("\nEnter operation: ");
            op = sc.next().charAt(0);

            switch (op){
                case 'p':
                    System.out.print("Enter key: ");
                    k = sc.nextInt();
                    System.out.print("Enter value: ");
//                    v = sc.nextBigDecimal();
                    sc.nextLine();
                    v = sc.nextLine();
                    mm.put(k, v);
                    break;

                case 'g':
                    System.out.print("Enter key: ");
                    k = sc.nextInt();
                    if (mm.get(k) == null) System.out.println("No value exist");
                    else System.out.println("Value at key " + k + " is " + mm.get(k));
                    break;

                case 'r':
                    System.out.print("Enter key: ");
                    k = sc.nextInt();
                    String temp = mm.remove(k);
                    if (temp == null) System.out.println("No value exist");
                    else System.out.println("Value at key " + k + " before removing is " + temp);
                    break;

                case 'a':
                    mm.print();
                    break;

                case 'x':
                    System.out.println("BYE!");
                    break;
            }
        } while (op != 'x');
    }
}
