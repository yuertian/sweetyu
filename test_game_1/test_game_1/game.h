#define _CRT_SECURE_NO_WARNINGS 
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>

#define row 12
#define col 12
#define COUNT 10//棋盘中雷的总数
extern char show_mine[row][col];
extern char real_mine[row][col];

void muen();//菜单
void init_mine();//初始化数组
void set_mine();//布雷
int count_mine();//统计周围雷的个数
void print_player();//打印玩家棋盘
void print_mine();//打印电脑棋盘 
int  sweep_mine();//扫雷函数
void safe_mine();//避免第一次被雷炸死的函数
void open_mine(int x, int y);//展开函数
int count_show_mine(); ///判断玩家棋盘剩余未知区域的个数
