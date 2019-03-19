package chess;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ChessPanel extends JPanel implements ActionListener{
    /** adding jbutton item undo button */
    private static JButton undo;
    private JButton[][] board;
    private ChessModel model;
    private ImageIcon wRook;
    private ImageIcon wBishop;
    private ImageIcon wQueen;
    private ImageIcon wKing;
    private ImageIcon wPawn;
    private ImageIcon wKnight;
    private ImageIcon bRook;
    private ImageIcon bBishop;
    private ImageIcon bQueen;
    private ImageIcon bKing;
    private ImageIcon bPawn;
    private ImageIcon bKnight;

    private boolean firstTurnFlag;
    private int fromRow;
    private int toRow;
    private int fromCol;
    private int toCol;
    private Integer moveNum = 0;
    // declare other intance variables as needed

    public ChessPanel() {
        undo = new JButton("undo");
        this.model = new ChessModel();

        createIcons();

        JPanel buttonpanel = new JPanel();
        //this.add(getJButton(this));
        drawBoard(this.model);
        //set size of reset button twice a high as buttons
        //undo.setPreferredSize(new Dimension(10,10));
        //redo.setPreferredSize(new Dimension(10,10));
        buttonpanel.add(undo);
        undo.addActionListener(this);

        add(buttonpanel);
        firstTurnFlag = true;
    }

    private void drawBoard(ChessModel model){
        this.board = new JButton[model.numRows()][model.numColumns()];
        JPanel boardpanel = new JPanel();
        boardpanel.setLayout(new GridLayout(model.numRows(), model.numColumns(), 1, 1));

        for (int r = 0; r < model.numRows(); r++) {
            for (int c = 0; c < model.numColumns(); c++) {
                if (model.pieceAt(r, c) == null) {
                    board[r][c] = new JButton("", null);
                    board[r][c].addActionListener(this);
                }
                else if (model.pieceAt(r, c).player() == Player.WHITE)
                    placeWhitePieces(model, r, c);
                else if (model.pieceAt(r, c).player() == Player.BLACK)
                    placeBlackPieces(model, r, c);

                setBackGroundColor(model, r, c);
                boardpanel.add(board[r][c]);
            }
        }

        add(boardpanel, BorderLayout.WEST);
        boardpanel.setPreferredSize(new Dimension(600, 600));
    }

    private void setBackGroundColor(ChessModel model, int r, int c) {
        if ((c % 2 == 1 && r % 2 == 0) || (c % 2 == 0 && r % 2 == 1)) {
            board[r][c].setBackground(Color.LIGHT_GRAY);
        } else if ((c % 2 == 0 && r % 2 == 0) || (c % 2 == 1 && r % 2 == 1)) {
            board[r][c].setBackground(Color.WHITE);
        }
    }

    private void placeWhitePieces(ChessModel model, int r, int c) {
        if (model.pieceAt(r, c).type().equals("Pawn")) {
            board[r][c] = new JButton(null, wPawn);
            board[r][c].addActionListener(this);
        }
        if (model.pieceAt(r, c).type().equals("Rook")) {
            board[r][c] = new JButton(null, wRook);
            board[r][c].addActionListener(this);
        }
        if (model.pieceAt(r, c).type().equals("Knight")) {
            board[r][c] = new JButton(null, wKnight);
            board[r][c].addActionListener(this);
        }
        if (model.pieceAt(r, c).type().equals("Bishop")) {
            board[r][c] = new JButton(null, wBishop);
            board[r][c].addActionListener(this);
        }
        if (model.pieceAt(r, c).type().equals("Queen")) {
            board[r][c] = new JButton(null, wQueen);
            board[r][c].addActionListener(this);
        }
        if (model.pieceAt(r, c).type().equals("King")) {
            board[r][c] = new JButton(null, wKing);
            board[r][c].addActionListener(this);
        }
    }

    private void placeBlackPieces(ChessModel model, int r, int c) {
        if (model.pieceAt(r, c).type().equals("Pawn")) {
            board[r][c] = new JButton(null, bPawn);
            board[r][c].addActionListener(this);
        }
        if (model.pieceAt(r, c).type().equals("Rook")) {
            board[r][c] = new JButton(null, bRook);
            board[r][c].addActionListener(this);
        }
        if (model.pieceAt(r, c).type().equals("Knight")) {
            board[r][c] = new JButton(null, bKnight);
            board[r][c].addActionListener(this);
        }
        if (model.pieceAt(r, c).type().equals("Bishop")) {
            board[r][c] = new JButton(null, bBishop);
            board[r][c].addActionListener(this);
        }
        if (model.pieceAt(r, c).type().equals("Queen")) {
            board[r][c] = new JButton(null, bQueen);
            board[r][c].addActionListener(this);
        }
        if (model.pieceAt(r, c).type().equals("King")) {
            board[r][c] = new JButton(null, bKing);
            board[r][c].addActionListener(this);
        }
    }

    private void createIcons() {
        // Sets the Image for white player pieces
        wRook = new ImageIcon("./src/chess/wRook.png");
        wBishop = new ImageIcon("./src/chess/wBishop.png");
        wQueen = new ImageIcon("./src/chess/wQueen.png");
        wKing = new ImageIcon("./src/chess/wKing.png");
        wPawn = new ImageIcon("./src/chess/wPawn.png");
        wKnight = new ImageIcon("./src/chess/wKnight.png");
        // Sets the Image for black player pieces
        bRook = new ImageIcon("./src/chess/bRook.png");
        bBishop = new ImageIcon("./src/chess/bBishop.png");
        bQueen = new ImageIcon("./src/chess/bQueen.png");
        bKing = new ImageIcon("./src/chess/bKing.png");
        bPawn = new ImageIcon("./src/chess/bPawn.png");
        bKnight = new ImageIcon("./src/chess/bKnight.png");
    }

    // method that updates the board
    private void displayBoard(ChessModel model) {

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++)
                if (model.pieceAt(r, c) == null)
                    board[r][c].setIcon(null);
                else
                if (model.pieceAt(r, c).player() == Player.WHITE) {
                    if (model.pieceAt(r, c).type().equals("Pawn"))
                        board[r][c].setIcon(wPawn);

                    if (model.pieceAt(r, c).type().equals("Rook"))
                        board[r][c].setIcon(wRook);

                    if (model.pieceAt(r, c).type().equals("Knight"))
                        board[r][c].setIcon(wKnight);

                    if (model.pieceAt(r, c).type().equals("Bishop"))
                        board[r][c].setIcon(wBishop);

                    if (model.pieceAt(r, c).type().equals("Queen"))
                        board[r][c].setIcon(wQueen);

                    if (model.pieceAt(r, c).type().equals("King"))
                        board[r][c].setIcon(wKing);

                }else
                if (model.pieceAt(r, c).player() == Player.BLACK) {
                    if (model.pieceAt(r, c).type().equals("Pawn"))
                        board[r][c].setIcon(bPawn);

                    if (model.pieceAt(r, c).type().equals("Rook"))
                        board[r][c].setIcon(bRook);

                    if (model.pieceAt(r, c).type().equals("Knight"))
                        board[r][c].setIcon(bKnight);

                    if (model.pieceAt(r, c).type().equals("Bishop"))
                        board[r][c].setIcon(bBishop);

                    if (model.pieceAt(r, c).type().equals("Queen"))
                        board[r][c].setIcon(bQueen);

                    if (model.pieceAt(r, c).type().equals("King"))
                        board[r][c].setIcon(bKing);

                }
        }
        repaint();
    }
//    undo = new JButton("undo");
//    model = new ChessModel();
//    listener = new listener();
//    createIcons();
//    board = new JButton[model.numRows()][model.numColumns()];
//
//    JPanel buttonpanel = new JPanel();
//
//    drawBoard();
//    //set size of reset button twice a high as buttons
//    //undo.setPreferredSize(new Dimension(10,10));
//    //redo.setPreferredSize(new Dimension(10,10));
//        buttonpanel.add(undo);
//        undo.addActionListener(listener);
//
//    add(buttonpanel);
//    firstTurnFlag = true;
    // inner class that represents action listener for buttons
    private void reset(){
        this.removeAll();
        this.model = new ChessModel();
        undo = new JButton("undo");
        //something is wrong with pop fix it for undo
        //array.set(0,new ChessModel());
//        array = new ArrayList<ChessModel>();
//        array.add(this.model);
        this.moveNum = 0;
        System.out.println("Board Array Size: "+this.model.iBoardArray.size());
        //temp.boardArray.pop();
        //temp = manager.pop();
        //temp = new ChessModel();
        redraw();
    }
    private void redraw(){
        createIcons();
        board = new JButton[this.model.numRows()][this.model.numColumns()];
        JPanel buttonpanel = new JPanel();
        drawBoard(this.model);
        buttonpanel.add(undo);
        undo.addActionListener(this);

        add(buttonpanel);
        if(moveNum == 0)
            firstTurnFlag = true;
        revalidate();
        repaint();
        displayBoard(this.model);
    }
        @Override
        public void actionPerformed(ActionEvent event){
        ChessModel temp = this.model;
            if(undo == event.getSource()){
                if(model.moveNum > 0){
                    this.moveNum --;
                    this.removeAll();
                    undo = new JButton("undo");
                    //something is wrong with pop fix it for undo
                    //array.set(0,new ChessModel());
                    //this.model = array.get(this.moveNum);
                    try {
                        this.model.arraySubtract(this.moveNum);
                    }catch(IllegalArgumentException move){
                        move.printStackTrace();
                        System.out.println(move.getMessage());
                    }finally{
                        System.out.println("Panel Move #"+this.moveNum);
                    }
                    //array.remove(array.size()-1);
                    //System.out.println("Board Array Size: "+ this.model.iBoardArray.size());
                    //temp.boardArray.pop();
                    //temp = manager.pop();
                    //this.model = new ChessModel();
                    redraw();
                }
                else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Cannot Undo again!");
                }
            }

            for (int r = 0; r < this.model.numRows(); r++)
                for (int c = 0; c < this.model.numColumns(); c++)
                    if (board[r][c] == event.getSource())
                        if (firstTurnFlag == true) {
                            fromRow = r;
                            fromCol = c;
                            firstTurnFlag = false;
                        } else {
                            toRow = r;
                            toCol = c;
                            firstTurnFlag = true;
                            Move move = new Move(fromRow, fromCol, toRow, toCol);
                            if ((this.model.isValidMove(move)) == true) {
                                this.moveNum ++;
                                //manager.push(this.model);
                                this.model.arrayAdd();
                                try{this.model.move(move);}catch(CloneNotSupportedException clone){
                                    clone.printStackTrace();
                                }finally {
                                    if(this.model.moveNum != this.moveNum)
                                        throw new IllegalArgumentException("Move Numbers must be the same between Model Class and Panel Class!");
                                }
                                displayBoard(this.model);
                                //System.out.println("Array Size Loop : "+this.model.iBoardArray.size());
                                System.out.println("Panel Move #"+this.moveNum);
                            }
                        }
        }


}
