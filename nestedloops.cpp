#include <string>
#include <vector>
#include <iostream>
#include <numeric>

struct myObject { 
    int number; 
    std::string word;
};

int main()
{
    myObject mOn1;
    mOn1.number=1;
        
    myObject mOn2;
    mOn2.number=2;
    
    myObject mOn3;
    mOn3.number=3;
    
    myObject mOw1;
    mOw1.word="ab";
        
    myObject mOw2;
    mOw2.word="cd";
    
    myObject mOw3;
    mOw3.word="ef";
    
    std::vector<myObject> vector1;
    vector1.push_back(mOw1);
    vector1.push_back(mOn1);
    vector1.push_back(mOn3);
    vector1.push_back(mOw2);
    vector1.push_back(mOn2);
    vector1.push_back(mOw3);

std::cout << "vector1 size: " << vector1.size() << std::endl;

for (size_t i = vector1.size() - 1; i > 0; --i)
{
    for (size_t j = 0; j < i; ++j)
    {
        if (vector1[i].number>0 && vector1[j].number>0)
            std::cout << vector1[i].number << " " << " and " << vector1[j].number << " = " << vector1[i].number + vector1[j].number  << std::endl;
            
        if (vector1[i].word.size()>0 && vector1[j].word.size()>0)
            std::cout << vector1[i].word << " and " << vector1[j].word << " " << vector1[i].word << vector1[j].word  << std::endl;
    }
}
}
