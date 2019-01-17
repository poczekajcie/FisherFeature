package dev.Krakowski.FisherFeature;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyPress implements KeyListener{
    public static boolean isLeftPosition;
    public static boolean isLeftAction;
    public static boolean isRightAction;

    public void keyPressed(KeyEvent keyEvent){
        if (keyEvent.getKeyCode()==KeyEvent.VK_LEFT){
            isLeftPosition = true;
        }
        if (keyEvent.getKeyCode()==KeyEvent.VK_RIGHT){
            isLeftPosition = false;
        }
        if (keyEvent.getKeyCode()==KeyEvent.VK_SPACE && isLeftPosition) {
            isLeftAction = true;
            PointLogic.left();
        }
        if (keyEvent.getKeyCode()==KeyEvent.VK_SPACE && !isLeftPosition) {
            isRightAction = true;
            PointLogic.right();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
}
