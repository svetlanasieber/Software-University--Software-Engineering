# Traffic Optimization Helper Program

## Problem Description

You're designing a smart traffic control system. To do so, you need to write a helper program. The goal of this program is to handle traffic data between two to twenty-six intersections named from A to Z.

### Input

1. The first parameter is an integer number indicating the number of intersections.
   - Example: 3 means that the intersections are from A to C.
2. The second part of the input data is the distance between each of the intersections. The distance is always a single digit from 1 to 9, represented in a matrix form.

### Tasks

1. **Read and Print Matrix**: Read the matrix input and print it with row descriptions and column titles.
2. **Analyze for Optimization Opportunities**: Identify and print all optimization opportunities where there is a difference between the roads of two points.
   - Example output for the matrix:
     ```
     AC(4) - CA(6)
     BC(1) - CB(2)
     ```
3. **Calculate and Print Total Optimization Opportunities**: Sum the absolute differences of all optimization opportunities.
   - Example output:
     ```
     Total opportunities: 3
     ```
4. **Determine and Print Maximum Optimization Opportunity**: Identify the largest optimization opportunity and print it. If there are multiple, print all of them comma-separated.
   - Example output:
     ```
     Max optimization: 2: AC-CA
     ```

<img width="797" alt="traffic_example1" src="https://github.com/svetlanasieber/Software-Engineering--Path-SoftUni/assets/135451084/2fc5799b-3a44-4b1c-972e-1cb83cce4ecc">


<img width="627" alt="example2" src="https://github.com/svetlanasieber/Software-Engineering--Path-SoftUni/assets/135451084/ae121c4c-5822-4aa6-a59b-58141c7bb209">

<img width="765" alt="example3" src="https://github.com/svetlanasieber/Software-Engineering--Path-SoftUni/assets/135451084/c6e3c0a9-a233-46c5-bfac-7ce0ad51df93">
