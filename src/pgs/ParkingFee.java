package pgs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingFee {
        int basicTime;
        int basicFee;
        int perTime;
        int perFee;

        Map<String, Integer> logMap = new HashMap<>();

        public int[] solution(int[] fees, String[] records) {

            basicTime = fees[0];
            basicFee = fees[1];
            perTime = fees[2];
            perFee = fees[3];


            Map<String, String> map = new HashMap<>();
            Map<String, Integer> ans = new HashMap<>();
            int min = 0;

            for (int i = 0; i < records.length; i++) {
                String time = records[i].split(" ")[0];
                String car = records[i].split(" ")[1];
                String log = records[i].split(" ")[2];

                if (log.equals("IN")) {
                    map.put(car, time);
                } else {
                    min = getUsedTime(time, map.get(car));
                    ans.put(car, ans.getOrDefault(car, 0) + min);
                    map.remove(car);
                }
            }
            if (!map.isEmpty()) {
                for (String car : map.keySet()) {
                    min = getUsedTime(map.get(car), "23:59");
                    ans.put(car, ans.getOrDefault(car, 0) + min);
                }
            }

            return getBill(ans);
        }

        public int getUsedTime(String a, String b) {
            int result = 0;
            try {

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

                Date date1 = sdf.parse(a);
                Date date2 = sdf.parse(b);

                // Date -> 밀리세컨즈
                long timeMil1 = date1.getTime();
                long timeMil2 = date2.getTime();

                // 비교
                long diff = timeMil2 - timeMil1;

                long diffMin = Math.abs(diff / (1000 * 60));

                result = (int) diffMin;

                return result;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return result;
        }


        public int[] getBill(Map<String, Integer> ans) {
            List<Integer> list = new ArrayList<>();

            List<String> keyList = new ArrayList<>(ans.keySet());
            keyList.sort((s1, s2) -> s1.compareTo(s2));

            for (String car : keyList) {
                int min = ans.get(car);
                int bill = 0;

                if (min <= basicTime) {
                    bill += basicFee;
                } else {
                    bill += ((int)Math.ceil(((double) min - basicTime) / perTime)) * perFee + basicFee;
                }
                list.add(bill);
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
}
