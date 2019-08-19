#include<stdio.h>
#include<stdlib.h>



char FindOnceChar(char *str)
{
	int arr[256] = { 0 };
	char *p = str;
	while (*p != '\0')
	{
		arr[*p]++;
		p++;
	}
	p = str;
	while (*p!='\0')
	{
		if (arr[*p] == 1)
		{
			return *p;
		}
		p++;
	}
	return '\0';
}


int main()
{
	char *str = "abaccdf";
	printf("%c\n", FindOnceChar(str));
	system("pause");
	return 0;
}



//int MaxArray(int *arr, int len)
//{
//	int max = arr[0];
//	int sum = arr[0];
//	int i = 0;
//	for (i = i; i < len; i++)
//	{
//		if (sum < 0)
//		{
//			max = arr[i];
//		}
//		else
//		{
//			sum += arr[i];
//		}
//		if (sum > max)
//		{
//			max = sum;
//		}
//	}
//	return max;
//}
//
//int main()
//{
//	int arr[] = { 1, -2, 3, 10, -4, 7, 2, -5 };
//	int len = sizeof(arr) / sizeof(arr[0]);
//	int ret = MaxArray(arr, len);
//	printf("%d\n", ret);
//	system("pause");
//	return 0;
//}