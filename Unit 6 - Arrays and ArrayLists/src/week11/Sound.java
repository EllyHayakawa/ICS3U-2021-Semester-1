package week11;

public class Sound {
    private int[] samples;
    
    int numChanges = limitAmplitude(2000);

    public int limitAmplitude(int limit){
        int numChanged = 0;
        for(int i = 0; i < samples.length; i++){
            if(samples[i] > limit){
                samples[i] = limit;
                numChanged++;
            }else if(samples[i] < -limit){
                samples[i] = -limit;
                numChanged++;
            }
        }
        return numChanged;
    }

    public void trimSilenceFromBeginning(){
        int[] temp = samples;
        int countZero = 0;
        while(samples[countZero] == 0){
            countZero++;
        }

        for(int i = 0; i < countZero; i++){
            samples[i] = temp[i + countZero];
        }
        
    }
    
}