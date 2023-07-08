using System;

class Program
{
    class Ponto
    {
        public double x;
        public double y;
    }

    static void Main()
    {
        Ponto p = new Ponto();
        p.x = 10.0;
        p.y = 10.0;

        Console.Write("(");
        Console.Write(p.x);
        Console.Write(",");
        Console.Write(p.y);
        Console.Write(")");
        Console.WriteLine();
    }
}
