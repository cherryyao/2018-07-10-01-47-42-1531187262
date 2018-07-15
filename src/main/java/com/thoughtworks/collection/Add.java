package com.thoughtworks.collection;

import org.w3c.dom.ls.LSInput;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int sum =0;
        if(leftBorder >rightBorder){
            for(int i=rightBorder;i<=leftBorder;i++){
                if(i%2==0){
                    sum += i;
                }
            }
        }
        if(leftBorder<rightBorder){
            for (int i = leftBorder;i<=rightBorder;i++){
                if(i%2==0){
                    sum += i;
                }
            }
        }
        return sum;
//        return IntStream.range(leftBorder,rightBorder+1)
//                .filter(num->num%2==0)
//                .reduce((num1,num2)->num1+num2).getAsInt();


    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
//        return IntStream.range(leftBorder,rightBorder+1)
//                .filter(num->num%2!=0)
//                .reduce((num1,num2)->num1+num2)
//                .getAsInt();
        int sum =0;
        if(leftBorder >rightBorder){
            for(int i=rightBorder;i<=leftBorder;i++){
                if(i%2!=0){
                    sum += i;
                }
            }
        }
        if(leftBorder<rightBorder){
            for (int i = leftBorder;i<=rightBorder;i++){
                if(i%2!=0){
                    sum += i;
                }
            }
        }
        return sum;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().reduce(0,(sum,x)->sum+(x*3+2));
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return  arrayList.stream().map(x -> x%2==1 ? x*3+2 : x).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return  arrayList.stream().filter(x->x%2==1).reduce(0,(sum,x) -> sum+(x*3+5));
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> resultList = arrayList.stream().filter(x->x%2==0).collect(Collectors.toList());

        int median;
        int size = resultList.size();
        if (size % 2 == 0) {
            median = (resultList.get(size / 2) + resultList.get(size / 2 - 1)) / 2;
        } else {
            median = resultList.get(size / 2);
        }
        return median;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        List<Integer> EvenList = arrayList.stream().filter(x->x%2==0).collect(Collectors.toList());
        return EvenList.stream().mapToInt(num->num).sum()/EvenList.size();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        List<Integer> array = arrayList.stream().filter(x->x%2==0).collect(Collectors.toList());
        return array.stream().anyMatch(x->x.equals(specialElment));

    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(x->x%2==0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> listEven = arrayList.stream().filter(x->x%2==0).sorted().collect(Collectors.toList());
        List<Integer> listOdd = arrayList.stream().filter(x->x%2!=0).sorted((num1,num2)->num2-num1).collect(Collectors.toList());
        listEven.addAll(listOdd);
        return listEven;

    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result =new ArrayList<>();
        arrayList.stream().reduce((num1,num2)->{
            Integer num = (num1+num2)*3;
            result.add(num);
            return num2;
        });
        return result;
    }

}
