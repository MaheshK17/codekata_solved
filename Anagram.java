import java.util.*;
class Anagram
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("give me a");
		String a = sc.nextLine();
		System.out.println("give me b");
		String b = sc.nextLine();
		A obj = new A();
		obj.Anag(a,b);
		obj.AnagPro(a,b);
	}
}
class A
{
	void Anag(String a,String b)
	{
		boolean isAna = false;
		//only one time visit
		boolean visited[] = new boolean[b.length()];
		//both should have same length
		if(a.length() == b.length())
		{
			for(int i=0;i<a.length();i++)
			{
				char c = a.charAt(i);
				isAna = false;
				for(int j=0;j<b.length();j++)
				{
					//check for anagrams charactors and repeating charactors.
					if(b.charAt(j)==c && !visited[j])
					{
						visited[j] = true;
						isAna = true;
						break;
					}
				}
				if(!isAna)
				{
					break;
				}
			}
		}
		//for last when isAna gets true value then it is anagram
		if(isAna){
			System.out.println("Anagram");
		}
		//if anytime in string isAna gets false the is is not anagram
		else{
			System.out.println("Not Anagram");
		}
	}
	void AnagPro(String a,String b)
	{
		boolean isAna = true;

		int a1[] = new int[256];
		int b1[] = new int[256];

		for(char c : a.toCharArray())
		{
			int index = (int)c;
			//increamenting index value
			a1[index]++;
		}

		for(char c : b.toCharArray())
		{
			int index = (int)c;
			//increamenting index value
			b1[index]++;
		}
		for(int i=0;i<256;i++)
		{
			if(a1[i] != b1[i]){
				isAna = false;
				break;
			}
		}
		//for last when isAna gets true value then it is anagram
		if(isAna){
			System.out.println("Anagram");
		}
		//if anytime in string isAna gets false the is is not anagram
		else{
			System.out.println("Not Anagram");
		}
	}
}