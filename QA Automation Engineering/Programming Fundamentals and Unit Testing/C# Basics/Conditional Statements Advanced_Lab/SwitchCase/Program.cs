
int a = 5;
switch (a)
{
    case 5:
    case 6:
        a = a + 1;
        break;
    default:
        a = a + 2;
        break;
}

Console.WriteLine(a);
