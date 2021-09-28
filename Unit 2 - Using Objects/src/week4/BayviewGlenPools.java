package week4;

public class BayviewGlenPools {
    public static void main(String[] args) {
        final int length = 20;
        final int width = 8;
        final int shallowLength = 5;
        final int transition = 7;
        final int shallowHeight = 3;
        final int deepHeight = 8;

        final int linerCost = 2;

        int volume = calculateVolume(length, width, shallowLength, shallowHeight, transition, deepHeight);
        int surfaceArea = calculateSurfaceArea(length, width, shallowLength, shallowHeight, transition, deepHeight);
    
        int nVolume = (int)(volume*0.9);
        double costLiner = (double)((int)((surfaceArea*(double)linerCost)*100))/100;
        System.out.println(volume);
        System.out.println(nVolume);
        System.out.println(surfaceArea);
        System.out.println("The cost of the liner is $" + costLiner);
        
    }

    private static int calculateVolume(int length, int width, int shallowLength, int shallowHeight, int transition,
            int deepHeight) {
        int volume = (int)((shallowLength*shallowHeight*width)+(deepHeight*(20-5-Math.sqrt(24))*width)+(shallowHeight*width*(Math.sqrt(24)))+((5*(Math.sqrt(24)/2))*width));
        return volume;
    }

    private static int calculateSurfaceArea(int length, int width, int shallowLength, int shallowHeight, int transition,
            int deepHeight) {
        final double deepLength = (15-(Math.sqrt(24)));
        int surfaceArea = (int)((shallowHeight*width)+(deepHeight*width)+(shallowLength*width)+(transition*width)+(deepLength*width)+(deepLength*deepHeight*2)+(shallowLength*shallowHeight*2)+(((shallowHeight+deepHeight)/2.0)*(Math.sqrt(24))*2));
        return surfaceArea;
    }
    
}
