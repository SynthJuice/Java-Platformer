package platformer;

public enum TileType {
	WallTL('Q', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 0,  0,  Platformer.UNIT_SIZE)),
	WallTM('W', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 16, 0,  Platformer.UNIT_SIZE)),
	WallTR('E', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 32, 0,  Platformer.UNIT_SIZE)),
	WallML('A', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 0,  16, Platformer.UNIT_SIZE)),
	WallMM('S', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 16, 16, Platformer.UNIT_SIZE)),
	WallMR('D', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 32, 16, Platformer.UNIT_SIZE)),
	WallBL('Z', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 0,  32, Platformer.UNIT_SIZE)),
	WallBM('X', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 16, 32, Platformer.UNIT_SIZE)),
	WallBR('C', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 32, 32, Platformer.UNIT_SIZE)),
	
	WallTCL('+', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 48, 0, Platformer.UNIT_SIZE)),
	WallTCR('-', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 64, 0, Platformer.UNIT_SIZE)),
	WallBCL('*', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 48, 16, Platformer.UNIT_SIZE)),
	WallBCR('/', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 64, 16, Platformer.UNIT_SIZE)),
	
	OutTL('R', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 0, 48, Platformer.UNIT_SIZE)),
	OutTM('T', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 16, 48, Platformer.UNIT_SIZE)),
	OutTR('Y', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 32, 48, Platformer.UNIT_SIZE)),
	OutBL('F', TextureLoader.loadAnimation("res/textures/vent_animation.png", 16, 8)),
	OutBM('G', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 16, 64, Platformer.UNIT_SIZE)),
	OutBR('H', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 32, 64, Platformer.UNIT_SIZE)),
	
	AcidT('~', TextureLoader.loadAnimation("res/textures/acid_animation.png", 16, 16)),
	AcidB('_', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 48, 64, Platformer.UNIT_SIZE)),
	
	HangITL('q', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 80,  0, Platformer.UNIT_SIZE)),
	HangIT ('w', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 96,  0, Platformer.UNIT_SIZE)),
	HangITR('e', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 112, 0, Platformer.UNIT_SIZE)),
	HangIML('a', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 80,  16, Platformer.UNIT_SIZE)),
	HangIMR('d', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 112, 16, Platformer.UNIT_SIZE)),
	HangIBL('z', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 80,  32, Platformer.UNIT_SIZE)),
	HangIBM('x', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 96,  32, Platformer.UNIT_SIZE)),
	HangIBR('c', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 112, 32, Platformer.UNIT_SIZE)),
	HangOTL('r', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 80,  48, Platformer.UNIT_SIZE)),
	HangOT ('t', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 96,  48, Platformer.UNIT_SIZE)),
	HangOTR('y', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 112, 48, Platformer.UNIT_SIZE)),
	HangOML('f', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 80,  64, Platformer.UNIT_SIZE)),
	HangOMR('h', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 112, 64, Platformer.UNIT_SIZE)),
	HangOBL('v', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 80,  80, Platformer.UNIT_SIZE)),
	HangOBM('b', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 96,  80, Platformer.UNIT_SIZE)),
	HangOBR('n', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 112, 80, Platformer.UNIT_SIZE)),
	
	Box1 ('V', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 80, 96, Platformer.UNIT_SIZE)),
	Box2V('B', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 96, 96, Platformer.UNIT_SIZE)),
	Box2H('N', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 112, 96, Platformer.UNIT_SIZE)),
	
	LadderT(':', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 64, 32, Platformer.UNIT_SIZE)),
	LadderM('|', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 64, 48, Platformer.UNIT_SIZE)),
	LadderB(';', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 64, 64, Platformer.UNIT_SIZE)),
	
	Background0('0', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 0, 80, Platformer.UNIT_SIZE)),
	Background1('1', TextureLoader.loadSubTexture("res/textures/spritesheet.png", 16, 80, Platformer.UNIT_SIZE));
	
	public final char character;
	public final Texture texture;
	TileType(char character, Texture texture) {
		this.character = character;
		this.texture = texture;
	}
	
	public static TileType getTileType(char character) {
	    for (TileType type : values()) {
	        if (type.character == character) {
	            return type;
	        }
	    }
	    return null;
	}

}
