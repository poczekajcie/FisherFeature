package dev.Krakowski.FisherFeature;

//If object is in zone and player click 'space' then change timer, points and set access to avoid getting the object again
public class PointLogic {
    public static void left() {
        for (int i=0; i<ObjectsPosition.tableOfTrash.length; i++) {
            if (ObjectsPosition.tableOfTrash[i].getTrashMove() > 500 && ObjectsPosition.tableOfTrash[i].getTrashMove() < 620 && ObjectsPosition.tableOfTrash[i].getTrashSide() < 177) {
                if (ObjectsPosition.tableOfTrash[i].checkAccess()) {
                    GameTimer.secondsLeft-=3;
                    ObjectsPosition.tableOfTrash[i].setTrashImage(null);
                    ObjectsPosition.tableOfTrash[i].setAccess(false);
                }
            }
        }
        for (int i=0; i<ObjectsPosition.tableOfFish.length; i++) {
            if (ObjectsPosition.tableOfFish[i].getFishMove() > 500 && ObjectsPosition.tableOfFish[i].getFishMove() < 620 && ObjectsPosition.tableOfFish[i].getFishSide() < 177) {
                chnageFishes(i);
            }
        }
    }

    public static void right() {
        for (int i=0; i<ObjectsPosition.tableOfTrash.length; i++) {
            if (ObjectsPosition.tableOfTrash[i].getTrashMove() > 500 && ObjectsPosition.tableOfTrash[i].getTrashMove() < 620 && ObjectsPosition.tableOfTrash[i].getTrashSide() > 167) {
                if (ObjectsPosition.tableOfTrash[i].checkAccess()) {
                    GameTimer.secondsLeft-=3;
                    ObjectsPosition.tableOfTrash[i].setTrashImage(null);
                    ObjectsPosition.tableOfTrash[i].setAccess(false);
                }
            }
        }
        for (int i=0; i<ObjectsPosition.tableOfFish.length; i++) {
            if (ObjectsPosition.tableOfFish[i].getFishMove() > 500 && ObjectsPosition.tableOfFish[i].getFishMove() < 620 && ObjectsPosition.tableOfFish[i].getFishSide() > 177) {
                chnageFishes(i);
            }
        }
    }

    private static void chnageFishes(int i) {
        if (ObjectsPosition.tableOfFish[i].checkAccess()) {
            Game.points++;
            GameTimer.secondsLeft+=1;
            ObjectsPosition.tableOfFish[i].setFishImage(null);
            ObjectsPosition.tableOfFish[i].setAccess(false);
        }
    }
}
