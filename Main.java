import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        //array to hash
        int[] array = new int[]{41, 25, 10, 60, 33, 75, 5, 50, 2, 7, 28, 80, 45, 6, 31};

        //solve the separate chaining problem
        System.out.println("Separate Chaining");
        SeparateChaining map1 = new SeparateChaining(10);
        for (int n : array)
        {
            map1.put(n);
        }
        map1.print();

        
        //solve the linear probing problem
        //show the hashmap after every insertion
        System.out.println("Linear Probing");
        LinearHashing map2 = new LinearHashing(10);
        for (int n : array)
        {
            map2.put(n);
            map2.print();
        }

        //solve the quadratic probing problem
        //show the hashmap after every insertion
        System.out.println("Quadratic Probing");
        QuadraticHashing map3 = new QuadraticHashing(25);
        for (int n : array)
        {
            map3.put(n);
            map3.print();
        }

        //solve the double hashing problem
        //show the hashmap after every iteration
        System.out.println("Double Hashing");
        DoubleHashing map4 = new DoubleHashing(25);
        for (int n : array)
        {
            map4.put(n);
            map4.print();
        }
    }
}