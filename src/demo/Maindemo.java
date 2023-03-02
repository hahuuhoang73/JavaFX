package demo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Maindemo {
    public static void main(String args[]){
        HashSet<Integer> hsi= new HashSet<>();
        hsi.add(2);
        hsi.add(3);
        hsi.add(1);
        hsi.add(2);
        System.out.println("so luong: "+hsi.size());


        PriorityQueue<Integer> pqi= new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2>0?-1:1;
            }
        });
        pqi.add(6);
        pqi.add(4);
        pqi.add(7);
        pqi.add(5);
        pqi.add(2);
        while (pqi.size() > 0){
            Integer x = pqi.poll();
            System.out.println(x);
            System.out.println("SL pqi:"+pqi.size());
        }


        HashMap<String,String> psm = new HashMap<>();
        psm.put("name","Nguyen Van An ");
        psm.put("class name","T2207A");

        System.out.println(psm.get("name"));
        System.out.println(psm.get("class name"));

    }
}
