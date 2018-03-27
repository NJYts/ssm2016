package exerciseGoWork;

import org.junit.Test;

/**
   *    @author  : niujianye
   *    @time    : 2018/3/27 10:42
   *    @description :水笔3元一支，圆珠笔2元一支，铅笔0.5元一支，编程求100元买100只笔的所有方案
 *    @param :  * @param null
   *    @version : v2.0
   *
   * Created by WISE on 2018/3/27.
 */
public class BugProgrammes {
	@Test
	public void bug(){
		//3x+2y+0.5z = 100
		//x+y+z = 100
		int shui = 0;int yuan = 0;int qian = 0;
		int shuiLength = 100/3;
		int yuanLength = 100/2;
		int qianLength = 100;
		for (int i = 0;i<shuiLength;i++){
			for (int j = 0;j<yuanLength;j++){
				for (int k = 0;k<qianLength;k++){
					if ((3*i+2*j+0.5*k == 100)
						&& (i+j+k == 100)){
						System.out.println("水笔:"+i+"个 圆珠笔："+j+"个 铅笔："+k+"个");
					}
				}
			}
		}
	}
}
