import java.util.Arrays;
public class LinearHashing {
    private int[] array;
    private int N;

    public LinearHashing(int capacity)
    {
        array = new int[capacity];
        Arrays.fill(array, '\0');
        N = 0;
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

            while (array[i] != '\0')
            {
                i = (i + 1) % array.length;
            }

            array[i] = key;
        }

        N++;

        //double the array when the load factor becomes greater than 0.5
        if ((N * 1.0) / array.length > 0.5)
        {
            //double the size of the array
            LinearHashing map = new LinearHashing(array.length * 2);
            
            for (int n : array)
            {
                if (n != '\0')
                {
                    map.put(n);
                }
            }

            this.array = map.getArray();
            this.N = map.getN();
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

    public int getN()
    {
        return this.N;
    }

    public int[] getArray()
    {
        return this.array;
    }
}

