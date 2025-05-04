using System;

namespace _02.Facade;
public class Elevator
{
    public int GetPassangerFloor()
    {
        Console.WriteLine("Elevator called from floor 3");

        return 3;
    }

    public int GetElevatorFloor()
    {
        Console.WriteLine("Elevator is on floor 8");

        return 8;
    }

    public void Move(int elevatorFloor, int selectedFloor)
    {
        if (elevatorFloor < selectedFloor)
        {
            Console.WriteLine("Moving up");
            return;

        }

        if (elevatorFloor > selectedFloor)
        {
            Console.WriteLine("Moving down");
            return;
        }

        Console.WriteLine("Same floor");

        return;
    }

    public int SelectFloor()
    {
        Console.WriteLine("Selected floor is ground floor");

        return 0;
    }

    public void OpenDoors()
    {
        Console.WriteLine("Open doors");
    }

    public void CloseDoors()
    {
        Console.WriteLine("Close doors");
    }
}
