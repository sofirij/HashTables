import java.util.Arrays;
public class QuadraticHashing {
    private int[] array;

    public QuadraticHashing(int capacity)
    {
        array = new int[capacity];
        Arrays.fill(array, '\0');
    }

    public int hash(int key)
    {
        return key % array.length;
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
            int j = 1;

            while (array[i] != '\0')
            {
                i = (hash + (int)Math.pow(j, 2)) % array.length;
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

