package pgs.simulation;

import java.util.*;

public class RankSearch {

    private Map<String, List<Integer>> scores = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        settingMap(info);

        return findByQuery(query);
    }

    // java backend junior pizza 150
    // javabackendjuniorpizza, 150

    private void settingMap(String[] infos) {
        StringBuilder sb = new StringBuilder();

        for (String info : infos) {
            String[] value = info.split(" ");
            int score = stoi(value[value.length - 1]);

            String[] keyArr = new String[value.length - 1];
            putKey(value, score, keyArr, 0, sb);
        }

        for (List<Integer> score : scores.values()) {
            Collections.sort(score);
        }
    }

    private void putKey(String[] value, int score, String[] keys, int index, StringBuilder sb) {
        if (index == value.length - 1) { // key의 길이에 도달
            sb.setLength(0);

            for(String key : keys) {
                sb.append(key);
            }

            String key = sb.toString();

            if (!scores.containsKey(key)) {
                scores.put(key, new ArrayList<>());
                scores.get(key).add(score);
            } else {
                scores.get(key).add(score);
            }

            return;
        }

        keys[index] = value[index];
        putKey(value, score, keys, index + 1, sb);
        keys[index] = "-";
        putKey(value, score, keys, index + 1, sb);
    }

    private int[] findByQuery(String[] queries) {

        int[] results = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String[] keyArr = queries[i].replaceAll(" and", "")
                    .split(" +");

            int score = stoi(keyArr[keyArr.length - 1]);
            String key = String.join("", Arrays.copyOf(keyArr, keyArr.length - 1));

            if (!scores.containsKey(key)) {
                results[i] = 0;
            } else {
                results[i] = scores.get(key).size() - parametricSearch(scores.get(key), score);
            }
        }

        return results;
    }

    private int parametricSearch(List<Integer> scoreList, int score) {
        int start = 0;
        int end = scoreList.size();

        while (start < end) {
            int mid = (start + end) / 2;

            if (scoreList.get(mid) >= score) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private void print() {
        System.out.println(scores.keySet().size());

        for (String key : scores.keySet()) {
            System.out.println(key);
        }
    }

    private int stoi(String value) {
        return Integer.parseInt(value);
    }
}