package platformer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MapLoader {
	
	public static Map loadMap(String path) throws IOException {
		File file = new File(path);
		if (file.exists()) {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			int width = Integer.parseInt(line.split("x")[0]), height = Integer.parseInt(line.split("x")[1]);
			char[][] mapArray = new char[width][height];
			line = reader.readLine();
			for (int y = 0; y < height; ++y) {
				for (int x = 0; x < width; ++x) {
					mapArray[x][y] = line.charAt(x);
				}
				line = reader.readLine();
			}

			line = reader.readLine();
			
			char[][] backgroundArray = new char[width][height];
			for (int y = 0; y < height; ++y) {
				for (int x = 0; x < width; ++x) {
					backgroundArray[x][y] = line.charAt(x);
				}
				line = reader.readLine();
			}
			reader.close();
			
			return new Map(mapArray, backgroundArray, Platformer.SCALE);
		} else {
			throw new FileNotFoundException();
		}
	}
	
}
