package Controller.Actions;

import Model.Shapes.Shape;

import java.util.ArrayList;
import java.util.Collections;

public class ActionManager {
    private boolean isFirstAction = false;
    private boolean isLastAction = false;
    ArrayList<Action> actions = new ArrayList<>(Collections.emptyList());
    private int currentActionIndex;
    private static ActionManager instance;

    public static synchronized ActionManager getInstance() {
        if (instance == null) {
            instance = new ActionManager();
        }
        return instance;
    }

    public void addActionToList(Action action) {
        if (currentActionIndex != actions.size() - 1) {
            actions.subList(currentActionIndex, actions.size()).clear();
        }
        actions.add(action);
        currentActionIndex = actions.size() - 1;
        if (actions.size() > 10) {
            actions.remove(0);
        }
    }

    public void saveEditedShapes(ArrayList<Shape> shapes) {
        Action curAction = actions.get(currentActionIndex);
        if (curAction instanceof EditAction) {
            ((EditAction)curAction).saveEditedShape(shapes);
        }
    }

    public void undoAction() {
        if (isFirstAction) {
            return;
        }
        if (currentActionIndex >= actions.size()) {
            currentActionIndex--;
        }
        Action curAction = actions.get(currentActionIndex);
        curAction.undoAction();
        if (currentActionIndex - 1 >= 0) {
            isLastAction = false;
        } else {
            isFirstAction = true;
        }
        currentActionIndex--;
    }

    public void redoAction() {
        if (isLastAction) {
            return;
        }
        if (currentActionIndex + 1 != actions.size()) {
            isFirstAction = false;
        } else {
            isLastAction = true;
        }
        currentActionIndex += 1;
        if (currentActionIndex >= actions.size()) return;
        Action curAction = actions.get(currentActionIndex);
        curAction.redoAction();
    }

}
