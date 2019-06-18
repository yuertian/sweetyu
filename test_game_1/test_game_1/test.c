#define _CRT_SECURE_NO_WARNINGS 1
#include"game.h"
double start, finish;

void muen()
{
	printf("*******************************\n");
	printf("***********  1.play  **********\n");
	printf("***********  0.exit  **********\n");
	printf("*******************************\n");
}

void game()
{

	int ret = 0;
	init_mine();//初始化棋盘
	set_mine();//布雷
	print_mine();//打印电脑棋盘
	printf("\n");
	print_player();//打印玩家棋盘
	start = clock();
	safe_mine();//避免第一次被炸死

	if (count_show_mine() == COUNT)
	{
		print_mine();
		printf("玩家赢！\n\n");
		return;
	}
	print_player();

	while (1)
	{
		int ret = sweep_mine();//扫雷,踩到雷返回1，没有踩到雷返回0
		if (count_show_mine() == COUNT)//若显示的*个数为雷数时，玩家赢
		{
			print_mine();//打印电脑棋盘
			printf("玩家赢！\n\n");
			finish = clock();//完成时间
			printf("用时%d 秒\n", (int)(finish - start) / CLOCKS_PER_SEC);
			break;
		}
		if (ret)//判断是否踩到雷
		{
			printf("被雷炸死\t");
			finish = clock();//完成时间
			printf("用时%d 秒\n", (int)(finish - start) / CLOCKS_PER_SEC);
			print_mine();//查看雷的分布
			break;
		}
		print_player();//打印玩家棋盘
	}
}


int main()
{
	srand((unsigned int)time(NULL));
	int input = 0;
	muen();
	do
	{
		scanf("%d", &input);
		switch (input)
		{
		case 1:game();
			break;
		case 0:exit(1);
			break;
		default:
			printf("输入错误，重新输入\n");
			break;
		}
		muen();
		printf("contiue?\n");
	} while (1);
	system("pause");
	return 0;
}
