import java.util.SortedSet;
import java.util.TreeSet;

public class Ques1031 {
    public static void main(String[] args) {
        SortedSet<People> set = new TreeSet<People>();
        set.add(new People(170));
        set.add(new People(165));
        for(People people : set){
            System.out.println("身高："+people.getHeight());
        }
        System.out.println();

        // 将身高矮的人变高
        set.first().setHeight(175);  //之前排在第一位的人就是最矮的
        for(People people : set){
            System.out.println("身高："+people.getHeight());
        }
    }
}

class People implements Comparable<People>{

    private int height;

    public People(int height) {
        super();
        this.height = height;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int compareTo(People p) {
        // 按身高从矮到高排序
        return height - p.height;
    }
}  