package week11;

public class HorseBarn {
    private Horse[] spaces;

    public int findHorseSpace(String name){
        for(int i = 0; i < spaces.length; i++){
            if(spaces[i] != null && spaces[i].getName().equals(name))
                return i;
        }
        return 0;
    }

    public void consolidate(){
        Horse[] temp = new Horse[spaces.length];
        /**for(int i = 0; i < spaces.length; i++){
            if(spaces[i] != null)
                temp[i] = spaces[i];
        }*/
        int i = 0;
        for(Horse horse:spaces){
            if(horse != null){
                temp[i] = horse;
                i++;
            }
        }

        spaces = temp;
    }

}
