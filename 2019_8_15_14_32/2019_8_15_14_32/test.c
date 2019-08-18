#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

char *Replace(char *str)
{
	char *start = str;
	int len = strlen(str);
	char *p = str + len;
	char *q = NULL;
	int empty = 0;
	int len1 = 0;
	while (str)
	{
		if (*str == ' ')
			empty++;
	}
	len1 = len + empty * 2 + 1;    //abc*defgx*yz*****q
	q = start + len1 - 1;                  //abc*defgx*yz******
	while (q > p)                  //abc*defgx*yz*****
	{                                          //p
		if (*p == ' ')
		{
			*q-- = '0';
			*q-- = '2';
			*q-- = '%';
			p--;
		}
		else
		{
			*q-- = *p--;
		}
	}
	//for (int i = 0; i < len1; i++)
	//{
	//	printf("%s", start);
	//}
	return start;
}


int main()
{
	char arr[20] = "abc defgx yz";
	Replace(arr);
	//printf("%s\n", arr);
	system("pause");
	return 0;
}