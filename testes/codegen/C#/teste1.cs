using System;

class Program
{
    static void Main()
    {
        int n = 13;
        int q = 5;
        int quo, res;

        divMod(n, q, out quo, out res);

        Console.WriteLine("Q: " + quo);
        Console.WriteLine("R: " + res);
    }

    static void divMod(int n, int q, out int quo, out int res)
    {
        quo = n / q;
        res = n % q;
    }
}