// See https://aka.ms/new-console-template for more information

using _02.Facade;
using System;

ElevatorFacade elevator = new();

elevator.CallElevator();

Console.WriteLine("=================");

elevator.GoToFloor();
