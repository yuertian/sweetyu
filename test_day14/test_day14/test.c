#define _CRT_SECURE_NO_WARNINGS 
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
#include<string.h>
//
//int Mystrncmp(const char *str1, const char *str2)
//{
//	int count = 0;         //bcda   
//	int len = strlen(str1);//abcd
//	char *p2 = str1;
//	assert(str1 != NULL&&str2 != NULL);
//	while (*str1!=*str2)
//	{
//		str1++;
//	}
//	while (*str1++==str2++)
//	{
//		*p2++;
//		count++;
//	}
//	str1 = '\0';
//	return p;
//}


 
int main()
{
	char *str1 = "abcde";
	char *str2 = "cdeab";
	int ret = 0;
	strncat(str1, str2,5);
	if (ret = 1)
		printf("yes");
	else
		printf("no");
	system("pause");
	return 0;
}