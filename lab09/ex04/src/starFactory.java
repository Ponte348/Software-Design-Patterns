import startypes.*;
import java.util.HashMap;
import java.util.Map;

public class starFactory {
    //static field starTypes
    private static Map<Character, StarType> starTypes = new HashMap<>();

    /**
     * Constructor for starFactory
     */
    public starFactory() {
    }

    //static method getStarType
    /**
     * @param starType Character
     * @return StarType
     */
    public static StarType getStarType(Character starType) {
        if (!starTypes.containsKey(starType)) {
            switch (starType) {
                case 'O':
                    starTypes.put('O', new OStar());
                    break;
                case 'B':
                    starTypes.put('B', new BStar());
                    break;
                case 'A':
                    starTypes.put('A', new AStar());
                    break;
                case 'F':
                    starTypes.put('F', new FStar());
                    break;
                case 'G':
                    starTypes.put('G', new GStar());
                    break;
                case 'K':
                    starTypes.put('K', new KStar());
                    break;
                case 'M':
                    starTypes.put('M', new MStar());
                    break;
            }
        }

        return starTypes.get(starType);
    }
}
