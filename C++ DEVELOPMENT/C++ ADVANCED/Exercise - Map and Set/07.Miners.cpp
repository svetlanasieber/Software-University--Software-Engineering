#include <iostream>
#include <string>
#include <map>
#include <cctype>
#include <algorithm>

using namespace std;

int main() {
    map<string, int> resources;
    map<string, string> originalResources;
    string input;
    string resource;
    int quantity;

    while (true) {
       
        getline(cin, input);
        if (input == "stop") {
            break;
        }
        resource = input;

       
        getline(cin, input);
        if (input == "stop") {
            break;
        }
        quantity = stoi(input);

        
        string resourceLower = resource;
        transform(resourceLower.begin(), resourceLower.end(), resourceLower.begin(), ::tolower);

        
        resources[resourceLower] += quantity;

        originalResources[resourceLower] = resource;
    }

  
    for (const auto& pair : resources) {
        cout << originalResources[pair.first] << " -> " << pair.second << endl;
    }

    return 0;
}
