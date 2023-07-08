using System;

class Program
{
    static bool even(int n)
    {
        if (n == 0)
            return true;
        else
            return odd(n - 1);
    }

    static bool odd(int n)
    {
        if (n == 0)
            return false;
        else
            return even(n - 1);
    }

    static void Main()
    {
        bool r = even(3);
        if (r)
        {
            Console.Write('P');
            Console.Write('A');
            Console.Write('R');
        }
        else
        {
            Console.Write('I');
            Console.Write('M');
            Console.Write('P');
            Console.Write('A');
            Console.Write('R');
        }
    }
}
