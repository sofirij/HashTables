import java.util.*;
public class SeparateChaining
{
    private LinkedList<Integer>[] array;

    @SuppressWarnings("unchecked")
    public SeparateChaining(int capacity)
    {
        array = new LinkedList[capacity];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = new LinkedList<Integer>();
        }
    }

    public int hash(int key)
    {
        return key % array.length;
    }

    public void put(int key)
    {
        int hash = hash(key);

        array[hash].addFirst(key);
    }

    public void print()
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(i + " - ");
            System.out.println(array[i]);
        }
    }
}