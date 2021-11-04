#include <bits/stdc++.h>
using namespace std;


vector<string> readlines(ifstream &stream) {
    vector<string> lines;
    string line;
    while(getline( stream, line )) {
        lines.push_back(line);
    }
    return lines;
}

vector<string> wordsFromLine(string s) {
    vector<string> words;
    int start = 0;
    int end = s.find(" ");
    while( end != -1 ) {
        string str = s.substr(start, end - start);
        transform(str.begin(), str.end(), str.begin(), ::tolower);
        words.push_back(str);
        start = end + 1;
        end = s.find(" ", start);
    }
    string str = s.substr(start, end - start);
    words.push_back(str);
    return words;
}

map<string, pair<int, set<int> > > getCountOfWords(vector<string> &lines) {
    map<string, pair<int, set<int> > > mp;
    int lineNumber = 0;
    for(auto line : lines) {
        vector<string> words = wordsFromLine(line);
        ++lineNumber;
        for(auto word : words) {
            auto itr = mp.find(word);
            if( itr != mp.end() ) {
                ++itr->second.first;
                itr->second.second.insert(lineNumber);
            } else {
                set<int> lineNumbers;
                lineNumbers.insert(lineNumber);
                mp.insert( {word, make_pair(1, lineNumbers)} );
            }
        }
    }
    return mp;
}

int main() {
    ifstream myFile("in.txt");
    auto lines = readlines(myFile);
    auto mp = getCountOfWords(lines);
    for(auto i : mp) {
        cout << i.first << " " << i.second.first << " ";
        for(auto j : i.second.second) {
            cout << j << " ";
        }
        cout << endl;
    }
    myFile.close();
    return 0;
}
