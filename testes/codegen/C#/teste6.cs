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

        printV(p, k);
        sort(p, k);
        Console.WriteLine();
        printV(p, k);
        Console.WriteLine();
    }

    static void printP(Ponto p)
    {
        Console.Write("(");
        Console.Write(p.x);
        Console.Write(",");
        Console.Write(p.y);
        Console.Write(")");
    }

    static void printV(Ponto[] v, int n)
    {
        Console.Write("{");
        if (0 < n)
        {
            printP(v[0]);
            int i = 1;
            while (i < n)
            {
                Console.Write(",");
                printP(v[i]);
                i = i + 1;
            }
        }
        Console.Write("}");
    }

    static void sort(Ponto[] v, int n)
    {
        int i = 0;
        while (i < n - 1)
        {
            int j = i + 1;
            while (j < n)
            {
                if (v[i].x < v[j].x)
                {
                    Ponto aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                }
                j = j + 1;
            }
            i = i + 1;
        }
    }
}
