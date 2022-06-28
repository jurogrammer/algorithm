package programmers.calculateparkingfee;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, List<Record>> recordsByCarNum = toRecordsByCarNum(records);
        addLastOut(recordsByCarNum);

        List<String> carNums = recordsByCarNum.keySet().stream().sorted().collect(Collectors.toList());
        int[] answer = new int[carNums.size()];
        int i = 0;
        for (String carNum : carNums) {
            List<Record> recordList = recordsByCarNum.get(carNum);
            int accTime = getAccTime(recordList);
            answer[i] = getFee(fees, accTime);
            i++;
        }

        return answer;


    }

    private Map<String, List<Record>> toRecordsByCarNum(String[] records) {
        Map<String, List<Record>> recordsByCarNum = new HashMap<>();
        for (String record : records) {
            String[] split = record.split(" ");
            String time = split[0];
            String carNum = split[1];
            String inOut = split[2];

            recordsByCarNum.computeIfAbsent(carNum, k -> new ArrayList<>());
            List<Record> recordList = recordsByCarNum.get(carNum);
            recordList.add(new Record(carNum, time));
        }
        return recordsByCarNum;
    }

    private int getAccTime(List<Record> recordList) {
        int recordSize = recordList.size();
        int in = 0;
        int out = 1;
        int accTime = 0;
        while (out < recordSize) {
            accTime += (recordList.get(out).getMinTime() - recordList.get(in).getMinTime());
            in += 2;
            out += 2;
        }
        return accTime;
    }

    private int getFee(int[] fees, int accTime) {
        int stdTime = fees[0];
        int stdFee = fees[1];
        int unitMin = fees[2];
        int unitMoney = fees[3];
        return stdFee + ceil(accTime, stdTime, unitMin) * unitMoney;
    }

    private int ceil(int accTime, int stdTime, int unitMin) {
        double value = (double) Math.max(0, accTime - stdTime) / unitMin;
        return (int) Math.ceil(value);
    }

    private void addLastOut(Map<String, List<Record>> recordsByCarNum) {
        for (Map.Entry<String, List<Record>> keyVal : recordsByCarNum.entrySet()) {
            String carNum = keyVal.getKey();
            List<Record> recordList = keyVal.getValue();
            if (recordList.size() % 2 != 0) {
                recordList.add(new Record(carNum, "23:59"));
            }
            recordList.sort(Comparator.comparingInt(Record::getMinTime));
        }
    }

    private static class Record {
        private String carNumber;
        private int minTime;

        public Record(String carNumber, String minTime) {
            this.carNumber = carNumber;
            String[] split = minTime.split(":");
            int hour = Integer.parseInt(split[0]);
            int minute = Integer.parseInt(split[1]);
            this.minTime = hour * 60 + minute;
        }

        public String getCarNumber() {
            return carNumber;
        }

        public int getMinTime() {
            return minTime;
        }
    }
}