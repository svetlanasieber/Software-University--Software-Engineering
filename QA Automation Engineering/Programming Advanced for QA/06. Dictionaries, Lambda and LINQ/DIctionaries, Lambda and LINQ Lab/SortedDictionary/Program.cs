//SortedDictionary

//student -> grade
SortedDictionary<string, double> students = new SortedDictionary<string, double>();
students.Add("Ivan", 5.60);
students.Add("Alex", 4.50);
students.Add("Georgi", 5.90);
students.Add("Martin", 5.35);

//Iterating Through a SortedDictionary using foreach loop

foreach (KeyValuePair<string, double> entry in students)
{
    //запис -> entry
    //entry.Key => име на студента
    //entry.Value => оценка

    Console.WriteLine(entry.Key + " -> " + entry.Value);
}
