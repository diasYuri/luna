using System;

class Program
{
    static void Main()
    {
        int n = 13;
        int q = 5;
        int w = divMod(n, q)[1];
        int z = 2 * w + 1;

        Console.WriteLine("Z: " + z);
    }

    static int[] divMod(int n, int q)
    {
        int[] result = new int[2];
        result[0] = n / q;
        result[1] = n % q;
        return result;
    }
}