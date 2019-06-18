#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
void menu()
{
	printf("--------------------------\n");
	printf("--------  1、玩   --------\n");
	printf("--------  0、不玩 --------\n");
	printf("--------------------------\n");
	printf("--------- 请选择 ---------\n");
}
void game()
{
	int guess = 0;
	int ret = 0;
	srand((unsigned int)time(NULL)); //这个放在函数里面也是ok的呀
	ret = rand() % 100 + 1;
	while (1)
	{
		printf("输入要猜的数字\n");
		scanf("%d", &guess);
		if (guess > ret)
		{
			printf("猜大了\n");
		}
		else if (guess < ret)
		{
			printf("猜小了\n");
		}
		else
		{
			printf("猜对了\n");
			break;
		}
	}

}
int main()
{
	int input = 0;
	do{
		menu();
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			game();
			break;
		case 0:
			printf("退出游戏");
			break;
		default:
			printf("输入错误，请重新输入");
			break;
		}
	} while (input);
	system("pause");
	return 0;
}
