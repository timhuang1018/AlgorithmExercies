package node;

import java.util.Stack;

/**
 * Example
 * ( '|' denotes where the cursor locates. 'text' shows what's been written to the text editor. )
 * Start with empty text => text = "|"
 * insertCharacter('a') => text = "a|"
 * insertCharacter('b') => text = "ab|"
 * insertCharacter('c') => text = "abc|"
 * moveCursorLeft() => text = "ab|c"
 * moveCursorLeft() => text = "a|bc"
 * backspace() => text = "|bc"
 * moveCursorLeft() => text = "|bc" (nothing happens since cursor was on the leftmost position)
 * undo() => text = "a|bc"
 * undo() => text = "ab|c"
 * undo() => text = "abc|"
 * undo() => text = "ab|"
 * undo() => text = "a|"
 */
public class DesignTextEditor {

    //the cursor will display at selectNode
    //insertCharacter(char c) will insert node next to selectNode
    //backspace() will delete selectNode
    private CharNode selectNode;
    private CharNode head;
    private CharNode tail;

    //remember moves
    private Stack<MoveRecord> undoContainer;

    public DesignTextEditor(){
        head = new CharNode();
        tail = new CharNode();
        head.next = tail;
        tail.pre = head;
        selectNode = head;

        undoContainer = new Stack<>();
    }

    public void moveCursorLeft(){
        if(selectNode != head){
            selectNode = selectNode.pre;
            undoContainer.add(new MoveRecord(null,Move.MoveLeft));
        }
    }

    //only able to move before tail
    public void moveCursorRight(){
        if (selectNode.next != tail){
            selectNode = selectNode.next;
            undoContainer.add(new MoveRecord(null,Move.MoveRight));
        }
    }

    //insert the char right before cursor
    public boolean insertCharacter(char c){
        CharNode addNode = new CharNode();
        addNode.val = c;

        selectNode.next.pre = addNode;
        addNode.pre = selectNode;
        addNode.next = selectNode.next;
        selectNode.next = addNode;

        undoContainer.add(new MoveRecord(addNode,Move.Insert));

        selectNode = selectNode.next;
//        moveCursorRight();

        //always true here since editor has no limit
        return true;
    }

    //delete the char right before cursor
    public boolean backspace(){
        if (selectNode != head){
            CharNode deleteNode = selectNode;
            selectNode.pre.next = selectNode.next;
            selectNode.next.pre = selectNode.pre;

            undoContainer.add(new MoveRecord(deleteNode,Move.BackSpace));

            selectNode = selectNode.pre;
//            moveCursorLeft();
            return true;
        }else {
            return false;
        }
    }

    public boolean undo(){
        if (!undoContainer.isEmpty()){
            //do the counter move
            MoveRecord record = undoContainer.pop();
            switch (record.move){
                case MoveLeft:
                    selectNode = selectNode.next; break;
                case MoveRight:
                    selectNode = selectNode.pre; break;
                case BackSpace:
                    CharNode deleteNode = record.node;
                    deleteNode.next = selectNode.next;
                    deleteNode.pre = selectNode;
                    selectNode.next.pre = deleteNode;
                    selectNode.next = deleteNode;
                    selectNode = selectNode.next;
                    break;
                case Insert:
                    CharNode addNode = selectNode;
                    selectNode = selectNode.pre;
                    addNode.next.pre = addNode.pre;
                    addNode.pre.next = addNode.next;
                    break;
            }

            return true;
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        String text = "";
        CharNode visitor = head.next;
        while (visitor!=null){
            if (visitor == tail) break;
            text += visitor.val + "->";
            visitor = visitor.next;
        }
        return text.length() == 0 ? "no input yet" : text.substring(0,text.length()-2); //do not print the last ->
    }

    static class CharNode{
        char val;
        CharNode next;
        CharNode pre;
    }

    class MoveRecord{
        CharNode node;
        Move move;

        public MoveRecord(CharNode node, Move move){
            this.node = node;
            this.move = move;
        }
    }

    enum Move {
        MoveLeft, MoveRight, Insert, BackSpace
    }

    public static void main(String[] args) {
        DesignTextEditor editor = new DesignTextEditor();
        editor.insertCharacter('a');
        editor.insertCharacter('b');
        editor.insertCharacter('c');
        //expected abc
        System.out.println(editor.toString());
        editor.moveCursorLeft();
        editor.moveCursorLeft();
        editor.backspace();
        //expected bc
        System.out.println(editor.toString());
        editor.moveCursorLeft();
        editor.undo();
        //expected abc
        System.out.println(editor.toString());
        editor.undo();
        editor.undo();
        editor.undo();
        //expected ab
        System.out.println(editor.toString());
        editor.undo();
        //expected a
        System.out.println(editor.toString());
    }
}
