package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class A539 {
//	public int findMinDifference(List<String> timePoints) {
//        boolean[] mark = new boolean[24 * 60];
//        for (String time : timePoints) {
//            String[] t = time.split(":");
//            int h = Integer.parseInt(t[0]);
//            int m = Integer.parseInt(t[1]);
//            if (mark[h * 60 + m]) return 0;
//            mark[h * 60 + m] = true;
//        }
//        
//        int prev = 0, min = Integer.MAX_VALUE;
//        int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
//        for (int i = 0; i < 24 * 60; i++) {
//            if (mark[i]) {
//                if (first != Integer.MAX_VALUE) {
//                    min = Math.min(min, i - prev);
//                }
//                first = Math.min(first, i);
//                last = Math.max(last, i);
//                prev = i;
//            }
//        }
//        
//        min = Math.min(min, (24 * 60 - last + first));
//        
//        return min;
//    }
//	public static int findMinDifference(List<String> timePoints) {
//		Map<String, ArrayList<Integer>> buckets = new HashMap<String, ArrayList<Integer>>();
//		int result = 60 * 24;
//		for (int i = 0; i < timePoints.size(); i++) {
//			String[] s = timePoints.get(i).split(":");
//			ArrayList<Integer> list = buckets.getOrDefault(s[0], new ArrayList<Integer>());
//			list.add(Integer.parseInt(s[1]));
//			buckets.put(s[0], list);
//		}
//		Iterator it = buckets.entrySet().iterator();
//		int last = 0;
//		while (it.hasNext()) {
//			Map.Entry<String, ArrayList<Integer>> pair = (Map.Entry<String, ArrayList<Integer>>) it.next();
//			ArrayList<Integer> array = pair.getValue();
//			Collections.sort(array);
//			if (array.size() < 0) {
//				last-=60;
//			} else {
//				if (array.get(0) - last + 60 < result)
//					result = array.get(0) - last + 60;
//				for (int i = 0; i < array.size() - 1; i++) {
//					if (array.get(i + 1) - array.get(i) < result)
//						result = array.get(i + 1) - array.get(i);
//				}
//				last = array.get(array.size() - 1);
//			}
//		}
//		if (buckets.get("00").get(0) - last + 60 < result)
//			result = buckets.get("00").get(0) - last + 60;
//		return result;
//	}
//
	public static void main(String[] args) {
		List<String> timePoints = new ArrayList<String>();
		//timePoints.add("23:59");
		timePoints.add("00:00");
		timePoints.add("02:11");
		timePoints.add("03:23");
		timePoints.add("01:05");
		timePoints.add("05:45");
		timePoints.add("03:33");
		/*
		 * slower! about 50sec! but straight forward~
		 * */
//		Collections.sort(timePoints);
//		int hour1 = 10*(timePoints.get(0).charAt(0)-'0') + (timePoints.get(0).charAt(1)-'0');
//		int min1 = 10*(timePoints.get(0).charAt(3)-'0') + (timePoints.get(0).charAt(4)-'0');
//		int hour2 = 10*(timePoints.get(timePoints.size()-1).charAt(0)-'0') + (timePoints.get(timePoints.size()-1).charAt(1)-'0');
//		int min2 = 10*(timePoints.get(timePoints.size()-1).charAt(3)-'0') + (timePoints.get(timePoints.size()-1).charAt(4)-'0');
//		int diff = (hour2-hour1)*60 + (min2-min1);
//		int mindiff = Math.min(diff, 1440-diff);
//		for (int i = 0; i < timePoints.size()-1; i++) {
//			hour1 = 10*(timePoints.get(i).charAt(0)-'0') + (timePoints.get(i).charAt(1)-'0');
//			min1 = 10*(timePoints.get(i).charAt(3)-'0') + (timePoints.get(i).charAt(4)-'0');
//			hour2 = 10*(timePoints.get(i+1).charAt(0)-'0') + (timePoints.get(i+1).charAt(1)-'0');
//			min2 = 10*(timePoints.get(i+1).charAt(3)-'0') + (timePoints.get(i+1).charAt(4)-'0');
//			diff = (hour2-hour1)*60 + (min2-min1);
//			diff = Math.min(diff, 1440-diff);
//			mindiff = Math.min(mindiff, diff);
//		}
//		System.out.println(mindiff);
		//findMinDifference(l);
	}
}
