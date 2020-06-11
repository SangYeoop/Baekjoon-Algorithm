package Porgrammers;

import java.util.Comparator;
import java.util.Vector;

class File {
    public String head;
    public String number;
    public String name;

    File(String head, String number, String name) {
        this.head = head;
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Head : " + head + " Number :" + number + " File Name : " + name + "\n";
    }
}

class FileComparator implements Comparator<File> {
    @Override
    public int compare(File o1, File o2) {
        if (o1.head.toLowerCase().compareTo(o2.head.toLowerCase()) > 0) {
            return 1;
        } else if (o1.head.toLowerCase().compareTo(o2.head.toLowerCase()) == 0) {
            if (Integer.parseInt(o1.number) > Integer.parseInt(o2.number))
                return 1;
            else if (Integer.parseInt(o1.number) == Integer.parseInt(o2.number))
                return 0;
            else
                return -1;
        }
        return -1;
    }
}

public class 파일명정렬 {
    public String[] solution(String[] files) {
        String[] answers;
        Vector<File> vec = new Vector<>();
        for (int i = 0; i < files.length; i++) {
            StringBuilder head = new StringBuilder();
            StringBuilder num = new StringBuilder();
            for (int j = 0; j < files[i].length(); j++) {
                head.append(files[i].charAt(j));
                if (Character.isDigit(files[i].charAt(j))) {
                    num.append(files[i].charAt(j));
                    j++;
                    while (j < files[i].length()) {
                        if (Character.isDigit(files[i].charAt(j))) {
                            num.append(files[i].charAt(j));
                            j++;
                        } else
                            break;
                    }
                    break;
                }
            }
            int len = head.length();
            head.delete(len - 1, len);
            vec.add(new File(head.toString(), num.toString(), files[i]));
        }
        vec.sort(new FileComparator());
        answers = new String[vec.size()];
        for (int i = 0; i < vec.size(); i++) {
            answers[i] = vec.get(i).name;
        }
        return answers;
    }
}


