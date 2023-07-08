using System;

class Program
{
    class Ponto
    {
        public int x;
        public int y;
    }

    static void Main()
    {
        int k = 5;
        Ponto[] p = new Ponto[k];
        int i = 0;

        while (i < k)
        {
            p[i] = new Ponto();
            p[i].x = 12 + i;
            p[i].y = 12 - i;
            i = i + 1;
        }

        Console.WriteLine();
    }
}
