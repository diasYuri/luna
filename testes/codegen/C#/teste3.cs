using System;

class Program
{
    static void Main()
    {
        int k = 4;
        int[] x = new int[k];
        x[0] = 0;
        x[3] = 15;
        Console.WriteLine(x[3]);

        int i = 0;
        while (i < k)
        {
            if (i % 2 == 0)
            {
                x[i] = 2 * i;
            }
            else
            {
                x[i] = 2 * i + 1;
            }
            i = i + 1;
        }

        i = 0;

        Console.Write("{");
        if (0 < k)
        {
            Console.Write(x[0]);
            while (i < k - 1)
            {
                Console.Write(",");
                Console.Write(x[i + 1]);
                i = i + 1;
            }
        }
        Console.Write("}");
        Console.WriteLine();
    }
}
