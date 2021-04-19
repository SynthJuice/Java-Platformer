package platformer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MapLoader {
	
	public static char[][] loadMap(String path) throws IOException {
		File file = new File(path);
		if (file.exists()) {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			int width = Integer.parseInt(line.split("x")[0]), height = Integer.parseInt(line.split("x")[1]);
			char[][] mapArray = new char[width][height];
			line = reader.readLine();
			int y = 0;
			while (line != null) {
				for (int x = 0; x < width; x++) {
					mapArray[x][y] = line.charAt(x);
				}
				++y;
				line = reader.readLine();
			}
			reader.close();
			
			return mapArray;
		} else {
			throw new FileNotFoundException();
		}
	}
	
}
