import java.util.Arrays;
public class DoubleHashing {
    private int[] array;

    public DoubleHashing(int capacity)
    {
        array = new int[capacity];
        Arrays.fill(array, '\0');
    }

    public int hash(int key)
    {
        return key % array.length;
    }

    public int hash2(int key)
    {
        return 13 - (key % 13);
    }

    public void put(int key)
    {
        int hash = hash(key);

        if (array[hash] == '\0')
        {
            array[hash] = key;
        }
        else
        {
            int i = hash;
            int k = hash2(key);
            int j = 1;

            while (array[i] != '\0')
            {
                i = (hash + (j * k)) % array.length;
                j++;
            }

            array[i] = key;
        }
    }

    public void print()
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.format("%2d ", i);
        }
        System.out.println();

        for (int i = 0; i < array.length; i++)
        {
            System.out.format("%2s ", "|");
        }
        System.out.println();

        for (int i = 0; i < array.length; i++)
        {
            System.out.format("%2d ", array[i]);
        }
        System.out.println();
    }
}

