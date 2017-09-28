#include <iostream>
#include <fstream>
#include <string>

using namespace std;

void Wait(string msg) // modified not to print \n after msg
{
	char c;
	cout << msg;
	cin.ignore(1024, '\n');
	cin.get(c);
}

void Quit()
{
	char c;
	cout << endl
		 << "Press <enter> to quit program...." << endl;
	cin.ignore(1024, '\n');
	cin.get(c);
}

void String2Ints(string s)
{ // Prints the ascii codes of the characters in s
	//unsigned char c;
	unsigned l = s.length(), c;
	for (unsigned i = 0; i < l; i++)
	{
		c = (unsigned char)(s[i]);
		cout << c << ", ";
	}
	cout << endl;
	return;
}

bool isValidPhrase(string s)
{
	bool isitok = true;
	for (unsigned i = 0; i < s.length(); i++)
		if (unsigned(s[i]) != 32 && !(unsigned(s[i]) > 64 && unsigned(s[i]) < 91))
		{
			isitok = false;
			break;
		}
	return isitok;
}

string my_xor(const string S, const string T)
{ // returns the xor of the given strings, eg  ("@" xor "!") = "a"
	// the first string cannot be longer
	string R, X = " ";
	unsigned l = S.length();
	for (unsigned i = 0; i < l; i++)
	{
		X[0] = ((unsigned char)S[i]) ^ ((unsigned char)T[i]);
		R = R + X;
	}
	return R;
}

bool match(string C1, string C2, string w)
{
	unsigned l = C1.length(), m = w.length(), pos = -1;
	if (m == 0)
		return 0;
	string x;
	if (l > C2.length())
		l = C2.length();
	for (unsigned i = 0; i <= l - m; i++)
	{
		x = my_xor(C2.substr(i, m), my_xor(C1.substr(i, m), w));
		if (isValidPhrase(x))
		{
			cout << "match in the other message = \"" << x << "\" at position "
				 << i << endl;
			pos = i;
		} // return i;}
	}
	return pos;
}

int main()
{
	//CRYPTANALYSIS: Assume that plaintext only consists of capital letters
	// and SPACE. There is a set of possible known phrases in the plaintext.
	// We are given two ciphertexts y1 and y2 and try to find the corresponding
	// plaintexts. By entering a possible phrase w, match(y1,y2,w) is invoked.

	cout << "\n\nEnter two ciphertexts that have been encrypted with the SAME key\n"
		 << "using the simple XOR cipher. Assume the unknown plaintext consists only\n"
		 << "of capital letters and SPACEs. Try various phrases that possibly occur\n"
		 << "occur in one plaintext to find out possible matches in the other \n"
		 << "plainttext.\n\n"
		 << "For the first ciphertext, enter its length N1 and then N1 ascii codes\n"
		 << "of characters. Then, enter the length N2 of the second ciphertext \n"
		 << "followed by N2 ascii codes of characters\n\n";

	unsigned k, l, n1, n2;
	unsigned c;
	string w;

	cin >> n1;
	string y1(n1, '_');
	for (int i = 0; i < n1; i++)
	{
		cin >> c;
		y1[i] = (unsigned char)c;
	}

	cin >> n2;
	string y2(n2, '_');
	for (int i = 0; i < n2; i++)
	{
		cin >> c;
		y2[i] = (unsigned char)c;
	}

	//Wait("");
	cin.ignore(1024, '\n');

	// cout << "\ny1 = \"" << y1 << "\"\n   = ";
	//String2Ints(y1);
	// cout << "\ny2 = \"" << y1 << "\"\n   = ";
	//String2Ints(y2);

	while (1)
	{
		cout << "\nEnter a possible phrase: \n";
		getline(cin, w);
		if (w.length() > 0)
		{
			if (!match(y1, y2, w))
				cout << "no match" << endl;
		}
		else
			break;
	}
	Quit();
}

/*  RULER TO HELP DECRYPT LETTERS AT VARIOUS POSITIONS

          1         2         3         4         5         6         7
01234567890123456789012345678901234567890123456789012345678901234567890


*/
