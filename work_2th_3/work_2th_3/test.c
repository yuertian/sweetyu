#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<string.h>


void exchange(char *str)
{
	char *start = str;
	int black = 0;
	int len = strlen(str);
	int newlen = 0;
	char *pstr = str + len;
	char *newpstr = NULL;
	while (*str)
	{
		if (*str == ' ')
			black++;
		    str++;
	}
	newlen = len + black * 2 + 1;
	newpstr = start + newlen - 1;
	while (newpstr > pstr)
	{
		if (*pstr == ' ')
		{
			*newpstr-- = '0';
			*newpstr-- = '2';
			*newpstr-- = '%';
			pstr--;
		}
		else
		{
			*newpstr-- = *pstr--;
		}
	}
}

void main()
{
	char arr[20] = "abc defgx yz";
	exchange(arr);
	printf("%s\n", arr);
	system("pause");
	return 0;
}