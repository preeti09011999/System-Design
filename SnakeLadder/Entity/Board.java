
import java.util.Random;


public class Board{
    Cell[][] cells;
   
    public Board(int boardSize, int noOfSnake, int noOfLadders){
        
        initialsizeBoard(boardSize);
        addSnakeLadders(cells, noOfSnake, noOfLadders);
    }

    private void addSnakeLadders(Cell[][] cells, int noOfSnake, int noOfLadders) {
        while(noOfSnake-- > 0){
            Random rndm = new Random();
            int snakeHead = rndm.nextInt(1, cells.length * cells.length-1);
            int snakeTail = rndm.nextInt(1, cells.length*cells.length-1);
            if(snakeHead <= snakeTail) continue;

            Jump snakeObj = new Jump();
            snakeObj.start = snakeHead;
            snakeObj.end  = snakeTail;
            Cell cell = getCell(snakeHead);
            cell.jump = snakeObj;
        }

        while(noOfLadders-- > 0){
            Random rndm = new Random();
            int ladderHead = rndm.nextInt(1, cells.length * cells.length-1);
            int ladderTail = rndm.nextInt(1, cells.length*cells.length-1);
            if(ladderTail <= ladderHead) continue;

            Jump ladderObj = new Jump();
            ladderObj.start = ladderHead;
            ladderObj.end  = ladderTail;
            Cell cell = getCell(ladderHead);
            cell.jump = ladderObj;
        }
    }

    public Cell getCell(int pos){
        int row = pos / cells.length;
        int col = pos % cells.length;
        return cells[row][col];
    }


    private void initialsizeBoard(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                cells[i][j] = new Cell();
            }
        } 
    }
}