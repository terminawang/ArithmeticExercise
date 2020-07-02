package com.finance.geex.testdemo.arithmetic;

/**
 * Created on 2020/6/28 16:19.
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。

 示例1:

 输入：A = 1, B = 10
 输出：10
 示例2:

 输入：A = 3, B = 4
 输出：12
 提示:
 保证乘法范围不会溢出

 * @author Geex302
 */
public class RecursionMultiplication {

    /**
     *
     * 根据乘法的性质：A * B = A * (B/2) * 2 = A * (B/2) + A * (B/2), 设f(A,B)为 A * B 的函数，所以乘法可以分解为：
     1. B为偶数时，f(A,B) = f(A,B/2) + f(A,B/2);
     2. B为奇数时，f(A,B) = f(A,B/2) + f(A,B/2) + A
     3. 而当B为1时，f(A,B) = A --> (递归的出口)
     *
     *
     * @param A
     * @param B
     * @return
     */

    public int multiplication(int A,int B){
        if(A == 0 || B == 0){
            return 0;
        }

        if(B == 1){
            return A;
        }
        if(B < 0){
            B = -B;
            return -recursion(A,B);
        }
        return recursion(A,B);
    }

    /**
     * 递归
     * @param m
     * @param n
     * @return
     */
    public int recursion(int m,int n){

        if(n == 1){
            return m;
        }

        if(n%2 == 0){
            //偶数
            int half = recursion(m,n/2);
            return half + half;
        }else {
            //奇数
            int half = recursion(m,n/2);
            return half + half + m;
        }

    }


}
