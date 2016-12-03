import java.lang.Math;

public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        Map distances = new HashMap<Double, Integer>();
        for(int i=0; i<points.length; i++){
            for(int j=0;j<points.length; j++){
                if(j == i){
                    continue;
                }
                double distanceIJ = Math.sqrt(Math.pow((points[i][0]-points[j][0]),2)+Math.pow((points[i][1]-points[j][1]),2));
                if(distances.containsKey(distanceIJ)){
                    distances.put(distanceIJ, (int)distances.get(distanceIJ)+1);
                }else{
                    distances.put(distanceIJ, 1);
                }
            }
            Iterator iterator = distances.values().iterator();
            while(iterator.hasNext()){
                int count = (int)iterator.next();
                if(count > 1){
                    result = result + count*(count-1);
                }
            }
            distances.clear();
        }
        return result;
    }
}