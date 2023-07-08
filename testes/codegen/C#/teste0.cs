using System;

class Program
{
    static void Main()
    {
        int nlines = 5;
        int i = nlines;

        while (i > 0)
        {
            for (int j = 0; j < i; j++)
            {
                Console.Write("*");
            }
            i--;
            Console.WriteLine();
        }
    }
}
