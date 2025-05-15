#include<iostream>
using namespace std;

int main() {
    enum planets {earth = 3, mars, jupiter, saturn, uranus, neptune};

 
    cout << "earth (" << earth << ") is "
        << uranus - earth << " planets away from "
        << "uranus (" << uranus << ")" << endl;

    enum class Planets {earth = 3, mars, jupiter, saturn, uranus, neptune};

    Planets planetEarth = Planets::earth;

    enum class PlanetsChar : char {earth = 'e', mars = 'm', jupiter = 'j', saturn = 's', uranus = 'u', neptune = 'n'};
    PlanetsChar planetEarthChar = PlanetsChar::earth;

    cout << (char)planetEarthChar << endl;

    return 0;
}
