package pgs.hash;

import java.util.*;

// 베스트 앨범
public class BestAlbum {

    class Song {
        int idx;
        int play;

        public Song(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> totalPlay = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            totalPlay.put(genres[i], totalPlay.getOrDefault(genres[i], 0) + plays[i]);
        }

        TreeMap<String, Integer> playOrder = new TreeMap<>((o1, o2) -> totalPlay.get(o2) - totalPlay.get(o1));
        for (String key : totalPlay.keySet()) {
            playOrder.put(key, totalPlay.get(key));
        }

        for (String key : playOrder.keySet()) {
            List<Song> songs = new ArrayList<>();
            for (int i = 0; i < genres.length; i++) {
                if (key.equals(genres[i])) {
                    songs.add(new Song(i, plays[i]));
                }
            }

            songs.sort((o1, o2) -> o2.play - o1.play);

            answer.add(songs.get(0).idx);
            if (songs.size() != 1) {
                answer.add(songs.get(1).idx);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
