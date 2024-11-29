#include <map>
#include <set>
#include <vector>
#include <string>
#include <iostream>
#include <sstream>


using namespace std;

int main(void) {

    map< string, map<string, set<string> > > data;

    int dataNum;
    cin >> dataNum;

    while(dataNum--) {
        string continent, country, city;
        cin >> continent >> country >> city;
        
        data[continent][country].insert(city);
    }

    for(map< string, map<string, set<string> > >::iterator itContients = data.begin(); itContients != data.end(); itContients++) {
        cout << itContients->first << ":" << endl;

        map<string, set<string> > & countries = itContients->second;

        for(map<string, set<string> >::iterator itCountries = countries.begin(); itCountries != countries.end(); itCountries++) {
            cout << "  " << itCountries->first << " -> ";
            
            set<string> & cities = itCountries->second;

            bool bFirst = true;
            for(string city : cities) {

                if (!bFirst) 
                    cout << ", ";
                else
                    bFirst = false;
                    
                cout << city;
            }

            cout << endl;
        }
    }

    return 0;
}
