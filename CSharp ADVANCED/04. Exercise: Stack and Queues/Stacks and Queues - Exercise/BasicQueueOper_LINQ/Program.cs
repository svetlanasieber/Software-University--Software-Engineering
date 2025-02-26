int[] paramenters = Console.ReadLine()!.Split().Select(int.Parse).ToArray();
int n = paramenters[0], s = paramenters[1], x = paramenters[2];

Queue<int> queue = new Queue<int>();

IEnumerable<int> numbers = Console.ReadLine()!.Split().Select(int.Parse);
foreach (int number in numbers)
    queue.Enqueue(number);

for (int i = 0; i < s; i++) queue.Dequeue();

if(queue.Count == 0) Console.WriteLine(0);
else if (queue.Any(el => el == x)) Console.WriteLine("true");
else Console.WriteLine(queue.Min());
