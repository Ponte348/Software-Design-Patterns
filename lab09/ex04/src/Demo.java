import java.awt.Color;

import startypes.*;

public class Demo {
    static int CANVAS_SIZE = 1200;
    static int STARS_TO_DRAW = 1000000;
    
    public static void main(String[] args) {
        System.out.println("Initial use of memory: 132 MB");
        System.out.println("Final use should be less than 44 MB\n");
        Sky sky = new Sky();

        // https://astrobackyard.com/wp-content/uploads/2020/03/types-of-stars.jpg
        char[] starTypes = {'O', 'B', 'A', 'F', 'G', 'K', 'M'};
        char type;

		Runtime runtime = Runtime.getRuntime();
		long before = runtime.totalMemory() - runtime.freeMemory();

        for (int i = 0; i < STARS_TO_DRAW; i++) {
            type = starTypes[random(0, starTypes.length-1)];
            sky.placeStar(createStar(type));
        }
        sky.setSize(CANVAS_SIZE, CANVAS_SIZE);
        sky.setBackground(Color.BLACK);
        sky.setVisible(true);

        long after = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("Final used memory: " + (after - before) / 1024 / 1024 + " MB");

    }

    private static Star createStar(char type) {
        int x = random(0, CANVAS_SIZE);
        int y = random(0, CANVAS_SIZE);

        StarType starType = starFactory.getStarType(type);
        Star star = new Star(x, y, starType);

        return star;
    }

	private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}