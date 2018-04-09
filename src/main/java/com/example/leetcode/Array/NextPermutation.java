package com.example.leetcode.Array;

/**
 * <p>
 * 31.下一个排列
 * </p>
 *
 * @author wangdejian
 * @since 2018/4/9
 */
public class NextPermutation {

    /**
     * 实现获取下一个排列函数，这个算法需要将数字重新排列成字典序中数字更大的排列。

     如果不存在更大的排列，则重新将数字排列成最小的排列（即升序排列）。

     修改必须是原地的，不开辟额外的内存空间。

     这是一些例子，输入位于左侧列，其相应输出位于右侧列。
     1,2,3 → 1,3,2
     3,2,1 → 1,2,3
     1,1,5 → 1,5,1
     */


    /************************************************************************
     * 思路
     * <p>
     * 1、从右向左找到第一个递增数列；
     * 2、找到递增数列中最小的比递增数列前一个数大的数；
     * 3、交换这两个数的位置，将递增数列逆序；
     * <p>
     * 例：146521
     * 1、6521逆序递增，5为递增数列中大于4的数中最小的
     * 2、交换位置变为156421
     * 3、递增数列逆序151246
     * 得146521的下一个排列为151246.
     *
     * @param nums
     */
    public void nextPermutation(int[] num) {
        int n=num.length;
        if(n<2)
            return;
        int index=n-1;
        while(index>0){
            if(num[index-1]<num[index])
                break;
            index--;
        }
        if(index==0){
            reverseSort(num,0,n-1);
            return;
        }
        else{
            int val=num[index-1];
            int j=n-1;
            while(j>=index){
                if(num[j]>val)
                    break;
                j--;
            }
            swap(num,j,index-1);
            reverseSort(num,index,n-1);
            return;
        }
    }

    public void swap(int[] num, int i, int j){
        int temp=0;
        temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }

    public void reverseSort(int[] num, int start, int end){
        if(start>end)
            return;
        for(int i=start;i<=(end+start)/2;i++)
            swap(num,i,start+end-i);
    }
}
