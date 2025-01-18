string input = Console.ReadLine();

string output = Console.ReadLine();
switch (input)
{
    case "banana":
    case "apple":
    case "kiwi":
    case "cherry":
    case "lemon":
    case "grapes":
        output = "fruit";
        break;
    case "tomato":
    case "cucumber":
    case "pepper":
    case "carrot":
        output = "vegetable";
        break;
    
    default:
        output = "unknown";
        break;
}
Console.WriteLine(output);
