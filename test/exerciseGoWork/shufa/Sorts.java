package exerciseGoWork.shufa;


/**
 * Created by WISE on 2018/3/27.
 */
public class Sorts {
	public static void main(String[] args) {
		int[] m = new int[] { 2, 5, -1, 4, 6, 8, -7, 9, 8 , 22 , 3 , 10,-5};
		MaoPaoPaixu(m);
		for (int i:m){
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.print("二分查找的结果是：");
		System.out.println();
		int[] n = { 11, 22, 33, 44, 55, 66, 77, 88, 99 };
		System.out.println("66下标是" + SecondChaZhao(n, 66));
		System.out.println("101下标是" + SecondChaZhao(n, 101));
	}
	/**
	 * 冒泡排序：下标相邻的两个数进行排序
	 *
	 * @param m
	 *            需要排序的数据，按由小到大排序
	 *
	 */
	public static void MaoPaoPaixu(int[] m) {
		int temp;
		for (int i = 0;i<m.length-1;i++){
			for (int j = 0;j<m.length-1-i;j++){
				if (m[j] > m[j+1]){
					temp = m[j];
					m[j] = m[j+1];
					m[j+1] = temp;
				}
			}
		}
	}
	/**
	 * 二分法查找，前提：被查找的数组是有序排列的，没有该数，默认返回-1
	 *
	 * @param m
	 *            被查找的数组数据
	 * @param key
	 *            需要查找的数据
	 *
	 */
	public static int SecondChaZhao(int[] m, int key) {
		int min = 0, max = m.length - 1, mid;
		//for (int i = min;i<max;i++){
		while(min<=max){
			mid = (min + max)/2;
			if (m[mid] < key){
				min = mid+1;
			}else if (m[mid] > key){
				max = mid-1;
			}else {
				return mid;
			}
		}
		return -1;
	}
	/**
	 * 选择排序：依次固定每个下标，让每个固定下标中的数和后面所有的数据进行比较 找出最大或者最小的值
	 *
	 * @param m 需要排序的数据，按大到小排序
	 */
	public static void XuanzePaixu(int[] m) {
		for (int i = 0; i < m.length ; i++) {//外层控制轮数
			int result = i;//最大值对应的索引
			//内层找到最大值放在前面
			for (int j = i+1; j <m.length ; j++) {
				if (m[j]>m[result]) result=j;
			}
			if(result != i){
				int temp = m[i];
				m[i]=m[result];
				m[result] = temp;
			}
		}
	}
}
