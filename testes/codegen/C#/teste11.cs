using System;

class Program
{
    static void Main()
    {
        int nlines = 5;
        int i;

        while (nlines > 0)
        {
            i = nlines;
            while (i > 0)
            {
                Console.Write("*");
                i--;
            }
            nlines--;
            Console.WriteLine();
        }
    }
}
