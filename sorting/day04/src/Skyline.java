import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Skyline {

    static class Point {
        int x, y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Building {
        private int l, r, h;

        Building(int l, int r, int h) {
            this.l = l;
            this.r = r;
            this.h = h;
        }
    }

    // Given an array of buildings, return a list of points representing the skyline
    public static List<Point> skyline(Building[] B) {
        List<Point> skyline = new ArrayList<>();
        if (B.length == 1) { //base
            Building b = B[0];
            Point p1 = new Point(b.l, b.h);
            Point p2 = new Point(b.r, 0);
            skyline.add(p1);
            skyline.add(p2);
            return skyline;
        }
        int mid = (B.length + 1) / 2;
        Building[] l = Arrays.copyOfRange(B, 0, mid);//divide
        Building[] r = Arrays.copyOfRange(B, mid, B.length);//divide
        List<Point> lsky = skyline(l);//conquer
        List<Point> rsky = skyline(r);//conquer

        return Merge(lsky, rsky);//combine


    }

    private static List<Point> Merge(List<Point> lsky, List<Point> rsky) {
        List<Point> skyline = new ArrayList<>();
        int x;
        int y;
        int i = 0;
        int j = 0;
        int h1 = 0;
        int h2 = 0;
        while (i<lsky.size()  && j<rsky.size()) {
            Point ll = lsky.get(i);
            Point rr = rsky.get(j);
            if (ll.x < rr.x)
            {h1 = ll.y;
                x = ll.x;
                {
                    if (h1 > h2) {
                        y = h1;
                    } else {
                        y = h2;
                    }
                }
                Point p = new Point(x, y);
                skyline = sky(skyline, p);
                i++;

            } else {
                h2 = rr.y;
                x = rr.x;
                {
                    if (h1 > h2) {
                        y = h1;
                    } else {
                        y = h2;
                    }
                }
                Point p = new Point(x, y);
                skyline = sky(skyline, p);
                j++;
            }

        }
        while (i < lsky.size()) {
            skyline.add(lsky.get(i));
            i++;
        }
        while (j < rsky.size()) {
            skyline.add(rsky.get(j));
            j++;
        }
        return skyline;

    }


    private static List<Point> sky(List<Point> skyline, Point p1) {

        if (skyline.isEmpty()) {
            skyline.add(p1);
            return skyline;
        }
        Point last = skyline.get(skyline.size()-1);
        if (p1.y == last.y) {
            return skyline;
        }
        else if (p1.x==last.x){
            if (p1.y < last.y) {
            return skyline;
        } else {
            skyline.remove(skyline.size()-1);
            skyline.add(p1);
        }}

        else{
            skyline.add(p1);
        }
        return skyline;
    }
}
