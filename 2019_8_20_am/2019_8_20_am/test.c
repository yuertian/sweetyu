#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<assert.h>



//void FindOnceNum(int arr[], int len, int *num1, int *num2)
//{
//	*num1 = 0;
//	*num2 = 0;
//	int i = 0;
//	int ret = 0;
//	int pos = 0;
//	int temp = 0;
//	for (i = 0; i < len; i++)
//	{
//		ret ^= arr[i];   
//	}                    
//	temp = ret;
//	while (ret)
//	{
//		if (ret % 2 == 1)
//		{
//			break;
//		}
//		pos++;
//		ret /= 2;
//	}
//	for (i = 0; i < len; i++)
//	{
//		if ((arr[i] >> pos) & 1)
//		{
//			*num1 ^= arr[i];
//		}
//	}
//	*num2 = temp^*num1;
//}
//
//
//int main()
//{
//	int arr[10] = { 1, 3, 5, 7, 1, 3, 5, 9 };
//	int len = sizeof(arr) / sizeof(arr[0]);
//	int num1 = 0;
//	int num2 = 0;
//	FindOnceNum(arr, len, num1, num2);
//	printf("%d %d", num1, num2);
//	system("pause");
//	return 0;
//}


//char *DeleteRepeate(char *str1, char *str2)
//{
//	char arr[256] = { 0 };
//	char *p = str1;
//	char *q = str1;
//	while (*str2 != '\0')
//	{
//		arr[*str2] = 1;
//		str2++;
//	}
//	while (*p != '\0')
//	{
//		if (arr[*p] != 1)
//		{
//			*q++ = *p;
//		}
//		p++;
//	}
//	*q = '\0';
//	return str1;
//}
//
//
//int main()
//{
//	char str1[] = "Welcome to cvte";
//	char *str2 = "come";
//	printf("%s\n", DeleteRepeate(str1, str2));
//	system("pause"); 
//	return 0;
//}