using System;

class Program
{
    static void Main()
    {
        int k = 5;
        int?[][] x = new int?[k][];
        int i = 0;

        while (i < k)
        {
            x[i] = new int?[k];
            i = i + 1;
        }

        i = 0;
        while (i < k)
        {
            x[i][i] = 2 * i + 1;
            i = i + 1;
        }

        int z = (int)x[3][3];
    }
}
