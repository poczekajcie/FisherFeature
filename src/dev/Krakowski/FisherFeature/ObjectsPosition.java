package dev.Krakowski.FisherFeature;

import java.util.concurrent.ThreadLocalRandom;

import dev.Krakowski.FisherFeauture.gfx.Assets;

public class ObjectsPosition {
    public static Trash tableOfTrash[] = new Trash[4];
    public static Fish tableOfFish[] = new Fish[4];

    public static void init() {
        for (int i=0; i<tableOfFish.length; i++) {
            tableOfFish[i] = new Fish(ThreadLocalRandom.current().nextInt(-600, 0),ThreadLocalRandom.current().nextInt(135, 210 ),Assets.fish);
        }
        for (int i=0; i<tableOfTrash.length; i++) {
            tableOfTrash[i] = new Trash(ThreadLocalRandom.current().nextInt(-600, 0),ThreadLocalRandom.current().nextInt(135, 210 ),Assets.trash);
        }
    }
}
