
#include<stdio.h>
#include<stdlib.h>
//#include<iostream>

//
//bool Find(int *a, int row, int col, int key)
//{
//	if (a = NULL || row < 0 || col < 0)
//	{
//		return false;
//	}
//	int i = 0;
//	int j = col - 1;
//	while (i < row)
//	{
//		if (a[i*col + j] == key)
//		{
//			return true;
//		}
//		if (a[i*col + j] < key)
//		{
//			i++;
//		}
//		else
//		{
//			j--;
//		}
//	}
//	return false;
//}
//
//int main()
//{
//	int arr[4][4] = { 1, 2, 8, 9,
//		              2, 4, 9, 12,
//		              4, 7, 10, 13,
//		              6, 8, 11, 15
//	                };
//	int ret = Find(*arr, 4, 4, 9);
//	printf("%d", ret);
//	system("pause");
//	return 0;
//}
//


//
//
//
//
//
//
//void Fnid_val(int *arr, int row, int col, int key)
//{
//	int tmpRow = 0;
//	int tmpCol = col - 1;
//
//	while (tmpRow<row&&tmpCol<=0)
//	{
//		if (arr[tmpRow*col+tmpCol-1]==key)
//		{
//			printf("ур╣╫ак");
//		}
//		else if (arr[tmpRow*col + tmpCol - 1] > key)
//		{
//
//			tmpCol--;
//		}
//		else
//		{
//			tmpRow++;
//		}
//	}
//}
//
//int main()
//{
//	//0,3
//	int arr[4][4] = { 1, 2, 8, 9,
//		2, 4, 9, 12,
//		4, 7, 10, 13,
//		6, 8, 11, 15 };
//
//	Fnid_val((int*)arr, 4, 4, 15);
//
//	return 0;
//}



#define ROW 3
void Func2(int arr[][ROW])
{
	int tmpRow = 0;
	int tmpCol = ROW / 2;
	int i = 2;
	arr[tmpRow][tmpCol] = 1;
	//2-n^2
	for (i = 2; i <= ROW*ROW; i++)
	{
		//int tmpRow1 = 0;
		//int tmpCol1 = 0;
		//tmpRow1 = (tmpRow - 1 + ROW) % ROW;
		//tmpCol1 = (tmpCol + 1) % ROW;
		if (arr[(tmpRow - 1 + ROW) % ROW][(tmpRow - 1 + ROW) % ROW] > 0)
			arr[tmpRow + 1][tmpCol] = i;
		else
			arr[(tmpRow - 1 + ROW) % ROW][(tmpRow - 1 + ROW) % ROW] = i;
	}

}

int main()
{
	int arr[3][3] = { 0 };
	Func2(arr);

	return 0;
}


