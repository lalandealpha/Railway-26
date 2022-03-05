package controller;

import view.MyColorView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyColorController implements ActionListener {
    private MyColorView myColorView;

    public MyColorController(MyColorView myColorView) {
        this.myColorView = myColorView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getActionCommand().equals("Red Text")) {
//            myColorView.setTextColor(Color.RED);
//        } else if (e.getActionCommand().equals("Yellow Text")) {
//            myColorView.setTextColor(Color.YELLOW);
//        } else if (e.getActionCommand().equals("Green Text")) {
//            myColorView.setTextColor(Color.GREEN);
//        } else if (e.getActionCommand().equals("Red Background")) {
//            myColorView.setBackgroundColor(Color.RED);
//        } else if (e.getActionCommand().equals("Yellow Background")) {
//            myColorView.setBackgroundColor(Color.YELLOW);
//        } else if (e.getActionCommand().equals("Green Background")) {
//            myColorView.setBackgroundColor(Color.GREEN);
//        }
        switch(e.getActionCommand()) {
            case "Red Text" :
                myColorView.setTextColor(Color.RED);
                break;
            case "Yellow Text" :
                myColorView.setTextColor(Color.YELLOW);
                break;
            case "Green Text" :
                myColorView.setTextColor(Color.GREEN);
                break;
            case "Red Background" :
                myColorView.setBackgroundColor(Color.RED);
                break;
            case "Yellow Background" :
                myColorView.setBackgroundColor(Color.YELLOW);
                break;
            case "Green Background" :
                myColorView.setBackgroundColor(Color.GREEN);
                break;
            default:
                break;
        }
    }
}
