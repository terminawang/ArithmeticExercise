package com.finance.geex.testdemo.arithmetic.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on 2020/7/2 14:55.
 * N皇后问题
 * @author Geex302
 */
public class NQueensProblem {

    List<List<String>> res;


    public List<List<String>> solveNQueens(int n){

        if(n <= 0){
            return null;
        }

        res = new LinkedList<>();
        //创建棋盘
        //创建一个二维数组代表棋盘
        char[][] board = new char[n][n];
//        for (int i = 0; i < board.length; i++) {
//            char[] chars = board[i];
//            for (int j = 0; j < chars.length; j++) {
//                chars[j] = '.';
//            }
//        }
        for(char[] chars:board){
            Arrays.fill(chars,'.');
        }

        //board:路劲  row:可选择列表
        backTrack(board,0);

        return res;

    }

    /**
     * 递归
     * @param board  代表路径，即board中小于row的那些行都已经成功放置了皇后
     * @param row  代表选择列表，即棋盘中的第row行都是可以放置皇后的
     */
    private void backTrack(char[][] board,int row){

        //结束条件
        if(row == board.length){
            //添加满足条件的放置方法
            res.add(charToString(board));
            return;
        }

        int length = board[row].length; //第row行的列数
        for (int col = 0; col < length; col++) {

            //排除不合法的选择
            if(!isValid(board,row,col)){
                continue;
            }

            //第row行的列数进行放置皇后 选择
            board[row][col] = 'Q';
            //进入下一行，即进入下一个决策树
            backTrack(board,row+1);
            //取消选择
            board[row][col] = '.';
        }

    }

    /**
     * 去除不满足条件的放置，即判断该位置的同一列，左上(整个对角线)，右上(整个对角线)是否放置了皇后，
     * 若放置了则说明该位置不合法，返回false
     * @param board
     * @param row
     * @param col
     */
    private boolean isValid(char[][] board,int row,int col){
        int rows = board.length;
        //判断同一列
        for (char[] chars:board){
            if(chars[col] == 'Q'){
                return false;
            }
        }
        //判断右上
        for (int i = row-1,j = col+1; i >=0 && j < rows ; i--,j++) {
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        //判断左上
        for (int i = row-1,j = col-1; i >= 0 && j >= 0 ; i--,j--) {
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }


    private List<String> charToString(char[][] array){
        List<String> result = new LinkedList<>();
        for (char[] chars:array){
            result.add(String.valueOf(chars));
        }
        return result;
    }


}
