namespace _02.Facade;

public class ElevatorFacade
{
    private readonly Elevator elevator = new();

    public void CallElevator()
    {
        int passengerFloor = elevator.GetPassangerFloor();
        int elevatorFloor = elevator.GetElevatorFloor();
        elevator.Move(elevatorFloor, passengerFloor);
        elevator.OpenDoors();
        elevator.CloseDoors();
    }

    public void GoToFloor()
    {
        int destinationFloor = elevator.SelectFloor();
        elevator.Move(3, destinationFloor);
        elevator.OpenDoors();
        elevator.CloseDoors();
    }
}