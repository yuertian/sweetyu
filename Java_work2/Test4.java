public class Test4 {

	static int LeapYear(int year){
		if((year%400 == 0) || (year%100!=0)&& (year%4==0)){
			return 1;   //是闰年，则返回1
		}else{
			return 0;	//不是闰年，则返回0
		}
	}
	public static void main(String[] args) {
		int year;
		int count = 0;
		System.out.println("1000年到2000年");
		for(year = 1000;year<=2000;year++){
			if(LeapYear(year) == 1){
				System.out.println(year+"");
				count++;
				if(count%16 == 0){
					System.out.print("\n");
				}
			}
		}
	}