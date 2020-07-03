package com.finance.geex.testdemo.arithmetic.backtrack;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Created on 2020/6/30 13:56.
 * 回溯算法
 * 全排列
 * @author Geex302
 */
public class FullPermutationArithmetic {

    List<List<Integer>> res = new LinkedList<>();

    /**
     * 主函数，输入一组不重复的数字，返回它们的全排列
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums){
        //路劲
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums,track);
        return res;
    }


    /**
     *
     * @param nums  可选择列表
     * @param track  路径
     */
    private void backTrack(int[] nums,LinkedList<Integer> track){

        //回溯结束条件
        if(nums.length == track.size()){
            //添加
            res.add(new LinkedList<Integer>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            //排除不合法的选择
            if(track.contains(num)){
                continue;
            }
            //做选择
            track.add(num);
            //进入下一个决策树
            backTrack(nums,track);
            //取消选择
            track.removeLast();

        }

    }







}
