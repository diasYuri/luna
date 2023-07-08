using System;

class Program
{
    static Tuple<int, float> f(int x)
    {
        int y = 2 * x + 1;
        if (y < 10)
            return new Tuple<int, float>(y, 1.5f);
        else
            return new Tuple<int, float>(y, 1.5f);
    }

    static void Main()
    {
        float z = f(10).Item2;
        int h = 2 * f(10).Item1;
    }
}
