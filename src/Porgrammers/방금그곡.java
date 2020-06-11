package Porgrammers;

public class 방금그곡 {
    public String solution(String m, String[] musicInfos) {
        String answer = "(None)";
        int musicTime = 0;
        for (int i = 0; i < musicInfos.length; i++) {
            String[] musicInfo = musicInfos[i].split(",");
            String[] startTime = musicInfo[0].split(":");
            String[] endTime = musicInfo[1].split(":");
            String musicTitle = musicInfo[2];

            int diff = getMin(startTime, endTime);
            StringBuilder musicMelody = new StringBuilder(changeMelody(musicInfo[3]));
            StringBuilder melody = new StringBuilder(changeMelody(m));

            int melodyLength = musicMelody.length();

            String realPlayStr = "";
            for (int j = 0; j < diff; j++) {
                int k = j % musicMelody.toString().length();
                realPlayStr += musicMelody.charAt(k);
            }

            if (realPlayStr.contains(melody.toString()) && diff > musicTime) {
                answer = musicTitle;
                musicTime = diff;
            }
        }
        return answer;
    }

    public int getMin(String[] startTime, String[] endTime) {
        int startMin = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
        int endMin = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]);
        return Math.abs(endMin - startMin);
    }

    public String changeMelody(String melody) {
        melody = melody.replace("C#", "c").replace("D#", "d").replace("F#", "f")
                .replace("E#", "e").replace("G#", "g").replace("A#", "a");
        return melody;
    }
}
