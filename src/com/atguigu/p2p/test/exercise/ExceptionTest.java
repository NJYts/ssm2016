package com.atguigu.p2p.test.exercise;

import java.util.Scanner;

/**
 * 异常测试类
 *
 * 首先认识异常分类
 * 异常分为运行时异常（RuntimeException）、受检异常（Exception）、系统错误error。
    RuntimeException，也就是运行时异常，表示代码本身存在BUG，比如ArrayIndexOutOfBoundsException，数组下标越界，数组定义的长度不够实际使用，代码若不调BUG进行处理肯定还会报错，控制台一旦报RuntimeException，就必须在代码中找BUG，因为代码BUG是人为粗心制造的，不是try-catch一下就能解决的。try-catch用在代码BUG上是毫无意义的，只需要写代码时谨慎点就能减少BUG，而不是try-catch。
    非RuntimeException，就是受检异常。比如处理文件流时的I/O问题，就属于编译时异常，相当于假设有IO异常就利用try-catch对其进行处理，或者 throws即可。
    error，通常是系统出现了不可控制的错误，这个通常与程序无关，所以是不需要处理的。
 *
 总结：
 *    1.throws是方法抛出异常。如： public int method() throws Exception{//code.....}
 *      a.如果，方法体中有异常并使用try-catch捕获异常并处理，则方法不会抛出异常。
 *      b.如果，方法体中有异常（如：算术异常）且没有捕获并处理；则此方法抛出的是方法体中的异常。
 *      c.如果，方法体中使用‘throw new Exception();’语句抛出一个新的Exception实例；则即是方法体多出一个这样的异常，
 *         方法抛出的是此语句异常。
 *      d.如果，方法体中对异常进行了捕获却没有处理（catch里什么都不做或者try-finally结构），且在catch中使用'throw e;'语句抛出异常，则即是方法抛出的是try中的异常。
 *
 *    2.throw是语句抛出异常。
 *      //***抛出异常e实例或新的Exception实例
 *      a.catch中的throw e;
 *      b.方法体中的throw new Exception();
 *
 *    总之，两者的作用就是简单的抛出异常。
 *
 *    注意：想在catch的参数里使用自定义的异常，则必须先将这个异常抛出才行。（throw new MyException是抛出异常,catch是捕获异常，只有抛出，才能被捕获）
 *    捕捉异常是指发生异常时 做相应的处理 避免程序崩溃，程序在catch 之后继续执行。
 *    抛出异常 提示异常发生的信息 回滚处理。程序停止执行。
 *
 *
 * */
public class ExceptionTest {

    public static void main(String[] args) {
       ExceptionTest t = new ExceptionTest();
        try {
            t.manager();
        } catch (MyException e) {
            e.printStackTrace();
        }
       /* System.out.print("请输入您的年龄：");
        System.out.println("您的年龄：" + t.inputAge());*/
    }

    public int inputAge() {
        int result = -1;
        Scanner scan = new Scanner(System.in);
        while (true) {
           try {
                result = scan.nextInt();
                if (result < 0 || result > 130) {
                    Exception me = new Exception("年龄超出合理范围！");
                    throw me;
                }
                break;
            } catch (Exception e1) {
                System.out.print(e1.getMessage() + "请重新输入：");
               // continue;
            }
            System.out.println("继续执行");
        }
        return result;
    }

    public void regist(int num) throws MyException {
        if (num < 0) {
            throw new MyException("人数为负数不合理!", 1);
        }
        System.out.println("throw 之后的程序不能执行" + num);
    }

    /**
     * 把异常给抛出去,交给更高层处理
     *
     * @throws MyException
     */
    public void manager() throws MyException {
        regist(-100);
    }

    /**
     * 把异常给截获并处理
     */
    public void manager1() {
        try {
            regist(-1330);
        } catch (MyException e) {
            // 在处理错误的时候,可以根据自己的需要去打印错误的信息
            System.out.println("出错了,错误的编号:" + e.getIdNumber());
        }
        System.out.println("程序可以继续执行！");
    }

    class MyException extends Exception {

        private static final long serialVersionUID = 1L;

        private int idNumber;

        public int getIdNumber() {
            return idNumber;

        }

        public MyException(String exception, int id) {
            super(exception);
            this.idNumber = id;
        }
    }
}