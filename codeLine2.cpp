#include<iostream>
#include<fstream>
using namespace std;
int newGig()
{
	int pep = 0;
	string str1 = "";
	int count=0;
	string myText;
	ifstream file("smooth.txt");
	while (getline (file, myText))
	{
  		// Output the text from the file
  		//counting the number of lines with blank(removed) comment
  		if(myText==str1)
  		{
  			pep = pep +1;
		}
		else if(myText != "")
		{
			//cout << myText;
  			count++;
		}	
  	}
  	//pep gives the number blank lines
  	cout<<"pep"<<pep;
  	cout<<"\n";
  	count = count - pep;
  	cout<<"lets get "<<count;
  	file.close();
}
string removeComments(string prgm) 
{ 
    int n = prgm.length(); 
    string res; 
    int pep = 0;
    // Flags to indicate that single line and multpile line comments 
    // have started or not. 
    bool s_cmt = false; 
    bool m_cmt = false; 
    // Traverse the given program 
    for (int i=0; i<n; i++) 
    { 
        // If single line comment flag is on then check for end of it 
        if (s_cmt == true && prgm[i] == '\n') 
        {
        	 s_cmt = false; 
		}
        // If multiple line comment is on then check for end of it 
        else if  (m_cmt == true && prgm[i] == '*' && prgm[i+1] == '/')
		{
			m_cmt = false,  i++; 	
		}    
        // If this character is in a comment ignore it 
        else if (s_cmt || m_cmt) 
        {
        	 continue; 
		} 
        // Check for beginning of comments and set the approproate flags 
        else if (prgm[i] == '/' && prgm[i+1] == '/')
		{
			cout<<"i"<<i;
			s_cmt = true, i++; 
		}    
        else if (prgm[i] == '/' && prgm[i+1] == '*')
		{
			m_cmt = true,  i++; 	
		}    
        // If current character is a non-comment character append it to res 
        else 
		{
			res += prgm[i]; 
		} 
    } 
    return res; 
} 
int main() 
{ 
	string nex;
	string pine;
	int count=0;
	string line;
	ifstream file("codeLine2.cpp");
	ofstream MyFile("smooth.txt");
	while(getline(file,line))
	{
		string prgm = line;
		cout<<line;
		cout<<"\n";
		pine = removeComments(prgm); 
		MyFile<<pine;
		MyFile<<"\n";
	}
	MyFile.close();
	file.close();
	int cnt = newGig();
    return 0; 
}
  
