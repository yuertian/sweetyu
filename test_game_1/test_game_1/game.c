#include"game.h"


char show_mine[row][col] = { 0 };
char real_mine[row][col] = { 0 };


void init_mine()//初始化棋盘
{
	int i = 0;
	int j = 0;
	for (int i = 0; i < row; i++)
	{
		for (j = 0; j < col; j++)
		{
			show_mine[i][j] = '*';
			real_mine[i][j] = '0';
		}
	}
}


void print_player()//打印玩家棋盘
{
	int i = 0;
	int j = 0;
	printf("0  ");
	for (i = 1; i <row - 1; i++)
	{
		printf("%d ", i);
	}
	printf("\n");
	for (i = 1; i <row - 2; i++)
	{
		printf("%d  ", i);
		for (j = 1; j < col - 1; j++)
		{
			printf("%c ", show_mine[i][j]);
		}
		printf("\n");
	}
	printf("10 ");
	for (i = 1; i < row - 1; i++)
	{
		printf("%c ", show_mine[10][i]);
	}
	printf("\n");
}


void print_mine()//打印电脑棋盘
{
	int i = 0;
	int j = 0;
	printf("0  ");
	for (i = 1; i <row - 1; i++)
	{
		printf("%d ", i);
	}
	printf("\n");
	for (i = 1; i <row - 2; i++)
	{
		printf("%d  ", i);
		for (j = 1; j < col - 1; j++)
		{
			printf("%c ", real_mine[i][j]);
		}
		printf("\n");
	}
	printf("10 ");
	for (i = 1; i < row - 1; i++)
	{
		printf("%c ", real_mine[10][i]);
	}
	printf("\n");
}



void set_mine()//给电脑棋盘布雷
{
	int x = 0;
	int y = 0;
	int count = COUNT;//雷总数
	while (count)
	{
		int x = rand() % 10 + 1;
		int y = rand() % 10 + 1;
		if (real_mine[x][y] == '0')
		{
			real_mine[x][y] = '1';
			count--;
		}
	}
}


int count_mine(int x, int y)//检测周围8个区域雷的个数
{
	int count = 0;
	if (real_mine[x - 1][y - 1] == '1')
		count++;
	if (real_mine[x - 1][y] == '1')
		count++;
	if (real_mine[x - 1][y + 1] == '1')
		count++;
	if (real_mine[x][y - 1] == '1')
		count++;
	if (real_mine[x][y + 1] == '1')
		count++;
	if (real_mine[x + 1][y - 1] == '1')
		count++;
	if (real_mine[x + 1][y] == '1')
		count++;
	if (real_mine[x + 1][y + 1] == '1')
		count++;
	return count;
}

void safe_mine()//避免第一次炸死
{
	int x = 0;
	int y = 0;
	char ch = 0;
	int count = 0;
	int ret = 1;
	printf("输入坐标扫雷\n");
	while (1)
	{
		scanf("%d%d", &x, &y);
		if ((x >= 1 && x <= 10) && (y >= 1 && y <= 10))
		{
			if (real_mine[x][y] == '1')//第一次踩到雷
			{
				real_mine[x][y] = '0';
				char ch = count_mine(x, y);
				show_mine[x][y] = ch + '0';
				open_mine(x, y);
				while (ret)//在其余不是雷的地方布雷
				{
					int x = rand() % 10 + 1;
					int y = rand() % 10 + 1;
					if (real_mine[x][y] == '0')
					{
						real_mine[x][y] = '1';
						ret--;
						break;
					}
				}
				break; 
			}
			if (real_mine[x][y] == '0')
			{
				char ch = count_mine(x, y);
				show_mine[x][y] = ch + '0';
				open_mine(x, y);
				break;
			}
		}
		else//坐标错误
		{
			printf("输入错误重新输入\n");
		}
	}
}


int sweep_mine()
{
	int x = 0;
	int y = 0;
	int count = 0;
	printf("输入坐标扫雷\n");
	scanf("%d%d", &x, &y);
	if ((x >= 1 && x <= 10) && (y >= 1 && y <= 10))
	{
		if (real_mine[x][y] == '0')
		{
			char ch = count_mine(x, y);
			show_mine[x][y] = ch + '0';
			open_mine(x, y);
			if (count_show_mine() == COUNT)//判断剩余未知区域雷的个数是否为雷数
			{
				print_mine();
				printf("玩家赢！\n\n");
				return 0;
			}
		}
		else if (real_mine[x][y] == '1')
		{
			return 1;
		}

	}
	else
	{
		printf("输入错误重新输入\n");
	}
	return 0;
}



void open_mine(int x, int y)//显示该坐标周围雷数
{
	if (real_mine[x - 1][y - 1] == '0')
	{
		show_mine[x - 1][y - 1] = count_mine(x - 1, y - 1) + '0';
	}
	if (real_mine[x - 1][y] == '0')
	{
		show_mine[x - 1][y] = count_mine(x - 1, y) + '0';
	}
	if (real_mine[x - 1][y + 1] == '0')
	{
		show_mine[x - 1][y + 1] = count_mine(x - 1, y + 1) + '0';
	}
	if (real_mine[x][y - 1] == '0')
	{
		show_mine[x][y - 1] = count_mine(x, y - 1) + '0';
	}
	if (real_mine[x][y + 1] == '0')
	{
		show_mine[x][y + 1] = count_mine(x, y + 1) + '0';
	}
	if (real_mine[x + 1][y - 1] == '0')
	{
		show_mine[x + 1][y - 1] = count_mine(x + 1, y - 1) + '0';
	}
	if (real_mine[x + 1][y] == '0')
	{
		show_mine[x + 1][y] = count_mine(x + 1, y) + '0';
	}
	if (real_mine[x + 1][y + 1] == '0')
	{
		show_mine[x + 1][y + 1] = count_mine(x + 1, y + 1) + '0';
	}
}


int count_show_mine()//判断剩余未知区域雷的个数
{
	int count = 0;
	int i = 0;
	int j = 0;
	for (i = 1; i <= row - 2; i++)
	{
		for (j = 1; j <= col - 2; j++)
		{
			if (show_mine[i][j] == '*')
			{
				count++;
			}
		}

	}
	return count;
}
