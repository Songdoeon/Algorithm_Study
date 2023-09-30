import java.util.*;

class Solution {
    boolean check(int time, int per){
        if(time % per != 0) return true;
        return false;
    }
    class Car{
        String number;
        int totalTime;
        int entranceTime;
        boolean state;
        
        Car(String number){
            this.number = number;
            this.entranceTime = 0;
            this.totalTime = 0;
            this.state = true;
        }
    }
    public int[] solution(int[] fees, String[] records) {
        List<Integer> list = new ArrayList<>();
        Map<String, Car> map = new HashMap<>();
        
        for(String record : records){
            String[] arg = record.split(" ");
            String[] times = arg[0].split(":");
            int time = Integer.valueOf(times[0]) * 60 + Integer.valueOf(times[1]);
            if(arg[2].equals("IN")){
                Car car = map.getOrDefault(arg[1], new Car(arg[1]));
                car.state = true;
                car.entranceTime = time;                  
                map.put(arg[1], car);
            }
            else{
                Car car = map.get(arg[1]);
                car.totalTime += time - car.entranceTime;
                car.state = false;
            }
        }
        List<String> keySet = new ArrayList(map.keySet());
        keySet.sort((o1, o2) -> o1.compareTo(o2));
        for(String key : keySet){
            Car car = map.get(key);
            if(car.state == true){
                int time = 23 * 60 + 59;
                car.totalTime += time - car.entranceTime;
            }
            if(check(car.totalTime - fees[0], fees[2])) car.totalTime += fees[2];

            if(car.totalTime <= fees[0]) list.add(fees[1]);
            else list.add((car.totalTime - fees[0]) / fees[2] * fees[3] + fees[1]);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}