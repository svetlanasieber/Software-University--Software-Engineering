#include <string>
#include <iostream>
#include <sstream>
#include <vector>
#include <list>
#include <map>
#include <set>
#include <algorithm>
#include <cctype>

using namespace std;

class Locations {

    public:

        typedef vector< string > Names;
        typedef vector< pair<string, string> > Coords;

    private:

        Names names;
        Coords coords;

    public:

        Locations(istream & istr) {

            while(true) {

                string buffer;
                getline(cin, buffer);
                if (buffer == ".")
                    break;

                istringstream istr(buffer);

                string name;
                pair<string, string> coordinates;

                getline(istr, name, ',');
                getline(istr, coordinates.first, ',');
                istr >> coordinates.second;

                names.push_back(name);
                coords.push_back(coordinates);
            }
        }

        string findByCoords(pair<string, string> & coordinates) {

            ostringstream ostr;

            Coords::iterator itFound = find(coords.begin(), coords.end(), coordinates);

            while(itFound != coords.end()) {

                int idx = itFound - coords.begin();

                ostr << names[idx] << ',' << coords[idx].first << ',' << coords[idx].second << endl;

                itFound = find(itFound+1, coords.end(), coordinates);
            }

            return ostr.str();
        }

        string findByName(const string & name) {
            ostringstream ostr;

            Names::iterator itFound = find(names.begin(), names.end(), name);
            if (itFound != names.end()) {
                // found!
                int idx = itFound - names.begin(); // this is the [] index in the vector!

                ostr << names[idx] << ',' << coords[idx].first << ',' << coords[idx].second << endl;
            }

            return ostr.str();
        }
};

int main() {

    Locations locs(cin);

    while(true) {

        string line;
        getline(cin, line);
        if (line == ".")
            break;

        istringstream istr(line);

        string resultStr;

        if (isdigit(line[0])) {
            // pair of coordinates
            
            pair<string, string> coordinates;
            istr >> coordinates.first >> coordinates.second;

            resultStr = locs.findByCoords(coordinates);
        } else {
            string name;
            istr >> name;

            resultStr = locs.findByName(name);
        }

        if (resultStr.size())
            cout << resultStr;
    }

    return 0;
}
