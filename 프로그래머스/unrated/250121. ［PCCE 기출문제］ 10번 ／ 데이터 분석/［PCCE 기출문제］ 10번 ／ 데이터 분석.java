import java.util.*;
import java.util.stream.*;
class Solution {
    class Data{
        int code;
        int date;
        int maximum;
        int remain;
        
        Data(int code, int date, int maximum, int remain){
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this. remain = remain;
        }
        int getDate(){
            return date;
        }
        int getCode(){
            return code;
        }
        int getMaximum(){
            return maximum;
        }
        int getRemain(){
            return remain;
        }
    }
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Data> list = new ArrayList<>();
        
        for(int[] tempData : data){
            list.add(new Data(tempData[0],tempData[1],tempData[2],tempData[3]));
        }
        switch(ext){
            case "code" : list = list.stream().filter(d -> d.getCode() < val_ext).collect(Collectors.toList());break;
            case "date" : list = list.stream().filter(d -> d.getDate() < val_ext).collect(Collectors.toList());break;
            case "maximum" : list = list.stream().filter(d -> d.getMaximum() < val_ext).collect(Collectors.toList());break;
               case "remain" : list = list.stream().filter(d -> d.getRemain() < val_ext).collect(Collectors.toList());break;
        }
        switch(sort_by){
            case "code" : list = list.stream().sorted(Comparator.comparing(Data::getCode)).collect(Collectors.toList());break;
            case "date" : list = list.stream().sorted(Comparator.comparing(Data::getDate)).collect(Collectors.toList());break;
            case "maximum" : list = list.stream().sorted(Comparator.comparing(Data::getMaximum)).collect(Collectors.toList());break;
            case "remain" : list = list.stream().sorted(Comparator.comparing(Data::getRemain)).collect(Collectors.toList());break;
            }
        int[][] answer = new int[list.size()][4];
        int index = 0;
        for(Data tempData : list){
            answer[index][0] = tempData.getCode();
            answer[index][1] = tempData.getDate();
            answer[index][2] = tempData.getMaximum();
            answer[index++][3] = tempData.getRemain();
        }
        return answer;
    }
}