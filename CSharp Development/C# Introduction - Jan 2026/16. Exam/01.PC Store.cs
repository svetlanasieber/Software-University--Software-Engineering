using System;

double cpuPriceUsd = double.Parse(Console.ReadLine()!);
double gpuPriceUsd = double.Parse(Console.ReadLine()!);
double ramPriceUsd = double.Parse(Console.ReadLine()!);
int ramCount = int.Parse(Console.ReadLine()!);
double discountPercent = double.Parse(Console.ReadLine()!);

const double UsdToBgn = 1.57;

double cpuPriceBgn = cpuPriceUsd * UsdToBgn;
double gpuPriceBgn = gpuPriceUsd * UsdToBgn;
double ramTotalBgn = ramPriceUsd * UsdToBgn * ramCount;

double cpuAfterDiscount = cpuPriceBgn * (1 - discountPercent);
double gpuAfterDiscount = gpuPriceBgn * (1 - discountPercent);

double totalNeeded = cpuAfterDiscount + gpuAfterDiscount + ramTotalBgn;

Console.WriteLine($"Money needed - {totalNeeded:F2} leva.");
