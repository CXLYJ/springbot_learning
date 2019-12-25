package com.lyj.test;

import javax.persistence.criteria.Selection;
import java.util.Arrays;

/**
 * Created by lyj on 2018/12/21.
 */
public class Array {

    /**
     * 冒泡排序
     * @param array
     */
    public static void  bubbleSort(int array[]){
        for (int i= 0 ; i < array.length-1; i++){
            for (int j = 0; j < array.length-1 ; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 选择排序
     * @param array
     */
     public static void SelectionSort(int array[]){
        for (int i = 0 ; i < array.length; i++){
            int minIndex = i;
            for (int j = i ; j < array.length; j++){
                if(array[j] < array[minIndex]){ //找到最小的数
                    minIndex = j; //将最小的数的索引保存
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
         System.out.println(Arrays.toString(array));
     }

    public static void main(String[] args) {
        int array[] = {6, 3, 7, 8, 1, 4, 9, 2};
//        bubbleSort(array);
          SelectionSort(array);
    }

}
