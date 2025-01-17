package util;

import java.util.HashMap;

public class BlockNames {
	public static HashMap<String, Integer> nameToID = new HashMap<>();
	
	
	static {
		nameToID.put("air", 0);
		nameToID.put("rock", 1);
		nameToID.put("stone", 1);
		nameToID.put("grass", 2);
		nameToID.put("dirt", 3);
		nameToID.put("cobblestone", 4);

		nameToID.put("cobble", 4);
		nameToID.put("wood", 5);
		nameToID.put("sapling", 6);
		nameToID.put("adminium", 7);
		nameToID.put("bedrock", 7);
		nameToID.put("water", 8);

		nameToID.put("stillwater", 9);
		nameToID.put("lava", 10);
		nameToID.put("stilllava", 11);
		nameToID.put("slava", 11);
		nameToID.put("sand", 12);
		nameToID.put("gravel", 13);

		nameToID.put("goldore", 14);
		nameToID.put("ironore", 15);
		nameToID.put("coalore", 16);
		nameToID.put("tree", 17);
		nameToID.put("log", 17);
		nameToID.put("leaves", 18);

		nameToID.put("sponge", 19);
		nameToID.put("glass", 20);
		nameToID.put("lapislazuliore",  21);
		nameToID.put("lapislazuliblock",  22);

		nameToID.put("dispenser",  23);
		nameToID.put("sandstone",  24);
		nameToID.put("noteblock",  25);
		nameToID.put("bedblock",  26);

		nameToID.put("poweredrail",  27);
		nameToID.put("detectorrail",  28);
		nameToID.put("stickypiston", 29);
		nameToID.put("web", 30);
		nameToID.put("tallgrass", 31);

		nameToID.put("deadshrub", 32);
		nameToID.put("piston", 33);
		nameToID.put("cloth", 35);
		nameToID.put("flower", 37);
		nameToID.put("rose", 38);
		nameToID.put("brownmushroom", 39);

		nameToID.put("redmushroom", 40);
		nameToID.put("gold", 41);
		nameToID.put("goldblock", 41);
		nameToID.put("iron", 42);
		nameToID.put("ironblock", 42);

		nameToID.put("doublestair", 43);
		nameToID.put("stair", 44);
		nameToID.put("step", 44);
		nameToID.put("brickblock", 45);
		nameToID.put("brickwall", 45);

		nameToID.put("tnt", 46);
		nameToID.put("bookshelf", 47);
		nameToID.put("mossycobblestone", 48);
		nameToID.put("mossy", 48);
		nameToID.put("obsidian", 49);

		nameToID.put("torch", 50);
		nameToID.put("fire", 51);
		nameToID.put("mobspawner", 52);
		nameToID.put("woodstairs", 53);
		nameToID.put("chest", 54);
		nameToID.put("redstonewire", 55);

		nameToID.put("diamondore", 56);
		nameToID.put("diamondblock", 57);
		nameToID.put("workbench", 58);
		nameToID.put("crop", 59);
		nameToID.put("crops", 59);
		nameToID.put("soil", 60);

		nameToID.put("furnace", 61);
		nameToID.put("litfurnace", 62);
		nameToID.put("signblock", 63);
		nameToID.put("wooddoorblock", 64);
		nameToID.put("ladder", 65);
		nameToID.put("rails", 66);

		nameToID.put("rail", 66);
		nameToID.put("track", 66);
		nameToID.put("tracks", 66);
		nameToID.put("cobblestonestairs", 67);
		nameToID.put("stairs", 67);
		nameToID.put("signblocktop", 68);

		nameToID.put("wallsign", 68);
		nameToID.put("lever", 69);
		nameToID.put("rockplate", 70);
		nameToID.put("stoneplate", 70);
		nameToID.put("irondoorblock", 71);
		nameToID.put("woodplate", 72);

		nameToID.put("redstoneore", 73);
		nameToID.put("redstoneorealt", 74);
		nameToID.put("redstonetorchoff", 75);
		nameToID.put("redstonetorchon", 76);
		nameToID.put("button", 77);

		nameToID.put("snow", 78);
		nameToID.put("ice", 79);
		nameToID.put("snowblock", 80);
		nameToID.put("cactus", 81);
		nameToID.put("clayblock", 82);
		nameToID.put("reedblock", 83);
		nameToID.put("jukebox", 84);

		nameToID.put("fence", 85);
		nameToID.put("pumpkin", 86);
		nameToID.put("netherstone", 87);
		nameToID.put("slowsand", 88);
		nameToID.put("lightstone", 89);
		nameToID.put("portal", 90);

		nameToID.put("jackolantern", 91);
		nameToID.put("jacko", 91);
		nameToID.put("cakeblock",  92);
		nameToID.put("redstonerepeateroff",  93);

		nameToID.put("redstonerepeateron",  94);
		nameToID.put("lockedchest",  95);
		nameToID.put("trapdoor", 96);
		nameToID.put("ironshovel", 256);

		nameToID.put("ironspade", 256);
		nameToID.put("ironpickaxe", 257);
		nameToID.put("ironpick", 257);
		nameToID.put("ironaxe", 258);
		nameToID.put("flintandsteel", 259);

		nameToID.put("lighter", 259);
		nameToID.put("apple", 260);
		nameToID.put("bow", 261);
		nameToID.put("arrow", 262);
		nameToID.put("coal", 263);

		nameToID.put("diamond", 264);
		nameToID.put("ironbar", 265);
		nameToID.put("goldbar", 266);
		nameToID.put("ironsword", 267);

		nameToID.put("woodsword", 268);
		nameToID.put("woodshovel", 269);
		nameToID.put("woodspade", 269);
		nameToID.put("woodpickaxe", 270);
		nameToID.put("woodpick", 270);

		nameToID.put("woodaxe", 271);
		nameToID.put("stonesword", 272);
		nameToID.put("stoneshovel", 273);
		nameToID.put("stonespade", 273);
		nameToID.put("stonepickaxe", 274);

		nameToID.put("stonepick", 274);
		nameToID.put("stoneaxe", 275);
		nameToID.put("diamondsword", 276);
		nameToID.put("diamondshovel", 277);
		nameToID.put("diamondspade", 277);

		nameToID.put("diamondpickaxe", 278);
		nameToID.put("diamondpick", 278);
		nameToID.put("diamondaxe", 279);
		nameToID.put("stick", 280);
		nameToID.put("bowl", 281);

		nameToID.put("bowlwithsoup", 282);
		nameToID.put("soupbowl", 282);
		nameToID.put("soup", 282);
		nameToID.put("goldsword", 283);
		nameToID.put("goldshovel", 284);

		nameToID.put("goldspade", 284);
		nameToID.put("goldpickaxe", 285);
		nameToID.put("goldpick", 285);
		nameToID.put("goldaxe", 286);
		nameToID.put("string", 287);
		nameToID.put("feather", 288);

		nameToID.put("gunpowder", 289);
		nameToID.put("woodhoe", 290);
		nameToID.put("stonehoe", 291);
		nameToID.put("ironhore", 292);
		nameToID.put("diamondhoe", 293);
		nameToID.put("goldhoe", 294);

		nameToID.put("seeds", 295);
		nameToID.put("wheat", 296);
		nameToID.put("bread", 297);
		nameToID.put("leatherhelmet", 298);
		nameToID.put("leatherchestplate", 299);
		nameToID.put("leatherpants", 300);

		nameToID.put("leatherboots", 301);
		nameToID.put("chainmailhelmet", 302);
		nameToID.put("chainmailchestplate", 303);
		nameToID.put("chainmailpants", 304);

		nameToID.put("chainmailboots", 305);
		nameToID.put("ironhelmet", 306);
		nameToID.put("ironchestplate", 307);
		nameToID.put("ironpants", 308);
		nameToID.put("ironboots", 309);

		nameToID.put("diamondhelmets", 310);
		nameToID.put("diamondchestplate", 311);
		nameToID.put("diamondpants", 312);
		nameToID.put("diamondboots", 313);
		nameToID.put("goldhelmet", 314);

		nameToID.put("goldchestplate", 315);
		nameToID.put("goldpants", 316);
		nameToID.put("goldboots", 317);
		nameToID.put("flint", 318);
		nameToID.put("meat", 319);
		nameToID.put("pork", 319);

		nameToID.put("cookedmeat", 320);
		nameToID.put("cookedpork", 320);
		nameToID.put("painting", 321);
		nameToID.put("paintings", 321);
		nameToID.put("goldenapple", 322);
		nameToID.put("sign", 323);

		nameToID.put("wooddoor", 324);
		nameToID.put("bucket", 325);
		nameToID.put("waterbucket", 326);
		nameToID.put("lavabucket", 327);
		nameToID.put("minecart", 328);
		nameToID.put("saddle", 329);

		nameToID.put("irondoor", 330);
		nameToID.put("redstonedust", 331);
		nameToID.put("snowball", 332);
		nameToID.put("boat", 333);
		nameToID.put("leather", 334);
		nameToID.put("milkbucket", 335);

		nameToID.put("brick", 336);
		nameToID.put("clay", 337);
		nameToID.put("reed", 338);
		nameToID.put("paper", 339);
		nameToID.put("book", 340);
		nameToID.put("slimeorb", 341);
		nameToID.put("storageminecart", 342);

		nameToID.put("poweredminecart", 343);
		nameToID.put("eggs", 344);
		nameToID.put("compass", 345);
		nameToID.put("fishingrod", 346);
		nameToID.put("watch", 347);
		nameToID.put("lightstonedust", 348);

		nameToID.put("lightdust", 348);
		nameToID.put("rawfish", 349);
		nameToID.put("fish", 349);
		nameToID.put("cookedfish", 350);
		nameToID.put("dye",  351);
		nameToID.put("bone",  352);
		nameToID.put("sugar",  353);

		nameToID.put("cake",  354);
		nameToID.put("bed",  355);
		nameToID.put("redstonerepeater",  356);
		nameToID.put("cookie",  357);
		nameToID.put("map", 358);

		nameToID.put("shears", 359);
		nameToID.put("goldrecord", 2256);
		nameToID.put("greenrecord", 2257);
	}
}
