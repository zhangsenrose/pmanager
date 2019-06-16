package com.zhang.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: zhangsw
 * @Date: 2019/6/11
 * @Version 1.0
 */
@PropertySource(value = "classpath:config.properties")
public class SortTest {


    @Test
    public void MaoPaoSort(){
        int[] arr = {88,23,89,23,25,66,9};
        for (int i  = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length -1-i; j++){
                int temp;
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for (int i : arr){
            System.out.println(i);
        }
    }


    @Test
    public void xuanZeSort(){
        int arr[] = {12,9,13,7};
        for (int i=0; i < arr.length-1; i++){
            for (int j = i+1; j < arr.length; j ++){
                int temp;
                if (arr[i] > arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i : arr){
            System.out.println(i);
        }
    }

    @Test
    public void chaRuSort(){


    }






}
