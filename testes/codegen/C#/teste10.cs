using System;

class Program
{
    static int fibonacci(int n)
    {
        if (n < 1)
            return n;
        if (n == 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static void Main()
    {
        int v = fibonacci(5);
        Console.WriteLine(v);
    }
}
