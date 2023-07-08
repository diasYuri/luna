using System;

class Program
{
    static int[] fat(int n)
    {
        if (n == 0)
        {
            return new int[] { 1 };
        }
        int[] result = fat(n - 1);
        result[0] *= n;
        return result;
    }

    static int spook(int n)
    {
        if (n == 1)
        {
            return 2 * n;
        }
        if (n == 2)
        {
            return 2 * n + 1;
        }
        return n - 1;
    }

    static void Main()
    {
        int k = fat(6)[0];
        k = spook(2);
        Console.WriteLine(k);
    }
}
