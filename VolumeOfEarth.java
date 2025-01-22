public class VolumeOfEarth {
    public static void main(String[] args) {
        double radiusKm = 6378;
        double conversionFactor = 0.621371;
        double radiusMiles = radiusKm * conversionFactor;
        double volumeKm = (4.0 / 3) * Math.PI * Math.pow(radiusKm, 3);
        double volumeMiles = (4.0 / 3) * Math.PI * Math.pow(radiusMiles, 3);
        System.out.println("The volume of earth in cubic kilometers is " + volumeKm + " and cubic miles is " + volumeMiles);
    }
}

