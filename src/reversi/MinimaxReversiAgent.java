package reversi;

import java.util.ArrayList;

public class MinimaxReversiAgent {

    

    MinimaxReversiAgent() {
        //To change body of generated methods, choose Tools | Templates.
    }
    
    

    //role 1 or -1
    public validMoveCell max(int[][] board, int role,int depth,int alpha,int beta) {
        
        // if(Main.minmaxlevelcount>=5) return ;
        
        //System.out.println("depth max="+depth);
        if(depth==0|| depth ==-1)
        {
            //System.out.println("FINSHED DEPTH IN max");
            validMoveCell returncCell = new validMoveCell();
            returncCell.utility = huristicFunc(board, role);
            return returncCell;
        }
        
        //Main.minmaxlevelcount++;
        ArrayList<validMoveCell> validMovesList = new ArrayList<validMoveCell>();

        validMovesList = findAllPossibleMoves(board, role);

        validMoveCell maxCVT = new validMoveCell();
        maxCVT.utility = -100000000;
        depth--;
        for (int p = 0; p < validMovesList.size(); p++) {

            validMoveCell testCell = new validMoveCell();
            testCell = validMovesList.get(p);

            int[][] newborad = new int[9][9];

            newborad = makeMove(board, testCell.x, testCell.y, testCell.role);
            

            
            //System.out.println("entering min call with x="+testCell.x+" y="+testCell.y+" depth="+depth+" role="+testCell.role*-1);
            int v = min(newborad, role*(-1),depth,alpha,beta).utility;
            if (v > maxCVT.utility) {
                maxCVT.utility = v;
                maxCVT.x = testCell.x;
                maxCVT.y = testCell.y;
            }
            if(maxCVT.utility>=beta)
            {
                return maxCVT;
            }
            alpha=maxCVT.utility>alpha?maxCVT.utility:alpha;
            //board[i][j] = -1; // reverting back to original state

        }
        
        return maxCVT;

    }

    private validMoveCell min(int[][] board, int role,int depth,int alpha,int beta) {
        
        
        //System.out.println("depth min="+depth);
        
       if(depth==0 || depth ==-1)
        {
            //System.out.println("FINSHED DEPTH IN min");
            validMoveCell returncCell = new validMoveCell();
            returncCell.utility = huristicFunc(board, role*-1);
            return returncCell;
        }
       
        
        ArrayList<validMoveCell> validMovesList = new ArrayList<validMoveCell>();

        validMovesList = findAllPossibleMoves(board, role);

        validMoveCell minCVT = new validMoveCell();
        minCVT.utility = 1000000000;
        depth--;
        for (int p = 0; p < validMovesList.size(); p++) {

            validMoveCell testCell = new validMoveCell();
            testCell = validMovesList.get(p);

            int[][] newborad = new int[9][9];
            
            newborad = makeMove(board, testCell.x, testCell.y, testCell.role);
            

            //System.out.println("entering max call with x="+testCell.x+" y="+testCell.y+" depth="+depth+" role="+testCell.role*-1);
            int v = max(newborad, role*(-1),depth,alpha,beta).utility;
            if (v > minCVT.utility) {
                minCVT.utility = v;
                minCVT.x = testCell.x;
                minCVT.y = testCell.y;
            }
            if(minCVT.utility<=alpha)
            {
                return minCVT;
            }
            beta=minCVT.utility<beta?minCVT.utility:beta;
            //board[i][j] = -1; // reverting back to original state

        }
        //System.out.println("min role="+minCVT.role +"min x="+minCVT.x+"min y="+minCVT.y+"level="+Main.minmaxlevelcount);
        return minCVT;

    }

    public int[][] makeMove(int[][] testboard, int i, int j, int role) {

        int[][] board = new int[9][9];
        for (int q = 1; q <= 8; q++) {
            for (int w = 1; w <= 8; w++) {
                board[q][w] = testboard[q][w];
            }
        }
        int player_1, player_2;
        if (role == 1) {
            player_1 = 1;
            player_2 = -1;
        } else {

            player_1 = -1;
            player_2 = 1;
        }

        if (board[i][j] == 1 || board[i][j] == -1) {
            return board;
        }

        int left_start = -5, right_end = -5, top_start = -5, down_end = -5;
        int left_top_dia_start_row = -5, left_top_dia_start_col = -5, right_top_dia_start_row = -5, right_top_dia_end_col = -5, left_down_dia_end_row = -5, left_down_dia_start_col = -5, right_down_dia_end_row = -5, right_down_dia_end_col = -5;

        //left start
        if (j > 2 && board[i][j - 1] == player_2) {
            for (int col = j - 1; col >= 1; col--) {
                if (board[i][col] == 0) {
                    break;
                }
                if (board[i][col] == player_1) {
                    left_start = col;
                    break;
                }
            }
        }

        for (int p = left_start + 1; p <= j && left_start != -5; p++) {
            board[i][p] = player_1;
        }

        //right end
        if (j < 6 && board[i][j + 1] == player_2) {
            for (int col = j + 1; col <= 8; col++) {
                if (board[i][col] == 0) {
                    break;
                }
                if (board[i][col] == player_1) {
                    right_end = col;
                    break;
                }
            }
        }

        for (int p = j; p < right_end && right_end != -5; p++) {
            board[i][p] = player_1;
        }

        //top start
        //System.out.println("i="+i+" j="+j);
        if (i > 2 && board[i - 1][j] == player_2) {
            for (int row = i - 1; row >= 1; row--) {
                if (board[row][j] == 0) {
                    break;
                }
                if (board[row][j] == player_1) {
                    top_start = row;
                    //System.out.println("found=" + row);
                    break;
                }
            }
        }

        for (int p = top_start + 1; p <= i && top_start != -5; p++) {
            board[p][j] = player_1;
        }

        //down_end
        if (i < 6 && board[i + 1][j] == player_2) {
            for (int row = i + 1; row <= 8; row++) {
                if (board[row][j] == 0) {
                    break;
                }
                if (board[row][j] == player_1) {
                    down_end = row;
                    //System.out.println("found=" + row);
                    break;
                }
            }
        }

        for (int p = i; p < down_end && down_end != -5; p++) {
            board[p][j] = player_1;
        }

        //left top dia start
        if (j > 2 && i > 2 && board[i - 1][j - 1] == player_2) {

            for (int col = j - 1, row = i - 1; col >= 1 && row >= 1; col--, row--) {
                if (board[row][col] == 0) {
                    break;
                }
                if (board[row][col] == player_1) {
                    left_top_dia_start_row = row;
                    left_top_dia_start_col = col;
                    break;
                }
            }
        }

        for (int p = left_top_dia_start_row + 1, q = left_top_dia_start_col + 1; p <= i && q <= j && left_top_dia_start_row != -5 && left_top_dia_start_col != -5; p++, q++) {
            board[p][q] = player_1;
        }

        //right down diagonal 
        if (j < 6 && i < 6 && board[i + 1][j + 1] == player_2) {

            for (int col = j + 1, row = i + 1; col <= 8 && row <= 8; col++, row++) {
                if (board[row][col] == 0) {
                    break;
                }
                if (board[row][col] == player_1) {
                    right_down_dia_end_row = row;
                    right_down_dia_end_col = col;
                    break;
                }
            }
        }

        for (int p = i, q = j; p < right_down_dia_end_row && q < right_down_dia_end_col && right_down_dia_end_row != -5 && right_down_dia_end_col != -5; p++, q++) {
            board[p][q] = player_1;
        }

        // right top dia 
        if (i > 2 && j < 6 && board[i - 1][j + 1] == player_2) {

            for (int col = j + 1, row = i - 1; col <= 8 && row >= 1; col++, row--) {
                if (board[row][col] == 0) {
                    break;
                }
                if (board[row][col] == player_1) {
                    right_top_dia_start_row = row;
                    right_top_dia_end_col = col;
                    break;
                }
            }
        }

        for (int p = i, q = j; p > right_top_dia_start_row && q < right_top_dia_end_col && right_top_dia_start_row != -5 && right_top_dia_end_col != -5; p--, q++) {
            board[p][q] = player_1;
        }

        // left down diagonal
        if (i < 6 && j > 2 && board[i + 1][j - 1] == player_2) {

            for (int col = j - 1, row = i + 1; col >= 1 && row <= 8; col--, row++) {
                if (board[row][col] == 0) {
                    break;
                }
                if (board[row][col] == player_1) {
                    left_down_dia_end_row = row;
                    left_down_dia_start_col = col;
                    break;
                }
            }
        }

        for (int p = i, q = j; p < left_down_dia_end_row && q > left_down_dia_start_col && left_down_dia_end_row != -5 && left_down_dia_start_col != -5; p++, q--) {
            board[p][q] = player_1;
        }

        if (left_start != -5 || right_end != -5 || down_end != -5 || top_start != -5 || left_down_dia_end_row != -5 || left_down_dia_start_col != -5 || left_top_dia_start_col != -5 || left_top_dia_start_row != -5 || right_down_dia_end_col != -5 || right_down_dia_end_row != -5 || right_top_dia_end_col != -5 || right_top_dia_start_row != -5) {
            //buttonbox[i][j].setLabel("#");
            //System.out.println("#");

        }
        return board;

    }

    public ArrayList<validMoveCell> findAllPossibleMoves(int[][] testboard, int role) {

        ArrayList<validMoveCell> allMoves = new ArrayList<validMoveCell>();
        int[][] board = new int[9][9];
        for (int q = 1; q <= 8; q++) {
            for (int w = 1; w <= 8; w++) {
                board[q][w] = testboard[q][w];
            }
        }
        int player_1, player_2;
        if (role == 1) {
            player_1 = 1;
            player_2 = -1;
        } else {

            player_1 = -1;
            player_2 = 1;
        }

        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {

                if (board[i][j] == 1 || board[i][j] == -1) {
                    continue;
                }

                int left_start = -5, right_end = -5, top_start = -5, down_end = -5;
                int left_top_dia_start_row = -5, left_top_dia_start_col = -5, right_top_dia_start_row = -5, right_top_dia_end_col = -5, left_down_dia_end_row = -5, left_down_dia_start_col = -5, right_down_dia_end_row = -5, right_down_dia_end_col = -5;

                //left start
                if (j > 2 && board[i][j - 1] == player_2) {
                    for (int col = j - 1; col >= 1; col--) {
                        if (board[i][col] == 0) {
                            break;
                        }
                        if (board[i][col] == player_1) {
                            left_start = col;
                            break;
                        }
                    }
                }

                //right end
                if (j < 6 && board[i][j + 1] == player_2) {
                    for (int col = j + 1; col <= 8; col++) {
                        if (board[i][col] == 0) {
                            break;
                        }
                        if (board[i][col] == player_1) {
                            right_end = col;
                            break;
                        }
                    }
                }

                if (i > 2 && board[i - 1][j] == player_2) {
                    for (int row = i - 1; row >= 1; row--) {
                        if (board[row][j] == 0) {
                            break;
                        }
                        if (board[row][j] == player_1) {
                            top_start = row;
                            //System.out.println("found=" + row);
                            break;
                        }
                    }
                }

                //down_end
                if (i < 6 && board[i + 1][j] == player_2) {
                    for (int row = i + 1; row <= 8; row++) {
                        if (board[row][j] == 0) {
                            break;
                        }
                        if (board[row][j] == player_1) {
                            down_end = row;
                            //System.out.println("found=" + row);
                            break;
                        }
                    }
                }

                //left top dia start
                if (j > 2 && i > 2 && board[i - 1][j - 1] == player_2) {

                    for (int col = j - 1, row = i - 1; col >= 1 && row >= 1; col--, row--) {
                        if (board[row][col] == 0) {
                            break;
                        }
                        if (board[row][col] == player_1) {
                            left_top_dia_start_row = row;
                            left_top_dia_start_col = col;
                            break;
                        }
                    }
                }

                //right down diagonal 
                if (j < 6 && i < 6 && board[i + 1][j + 1] == player_2) {

                    for (int col = j + 1, row = i + 1; col <= 8 && row <= 8; col++, row++) {
                        if (board[row][col] == 0) {
                            break;
                        }
                        if (board[row][col] == player_1) {
                            right_down_dia_end_row = row;
                            right_down_dia_end_col = col;
                            break;
                        }
                    }
                }

                // right top dia 
                if (i > 2 && j < 6 && board[i - 1][j + 1] == player_2) {

                    for (int col = j + 1, row = i - 1; col <= 8 && row >= 1; col++, row--) {
                        if (board[row][col] == 0) {
                            break;
                        }
                        if (board[row][col] == player_1) {
                            right_top_dia_start_row = row;
                            right_top_dia_end_col = col;
                            break;
                        }
                    }
                }

                // left down diagonal
                if (i < 6 && j > 2 && board[i + 1][j - 1] == player_2) {

                    for (int col = j - 1, row = i + 1; col >= 1 && row <= 8; col--, row++) {
                        if (board[row][col] == 0) {
                            break;
                        }
                        if (board[row][col] == player_1) {
                            left_down_dia_end_row = row;
                            left_down_dia_start_col = col;
                            break;
                        }
                    }
                }

                if (left_start != -5 || right_end != -5 || down_end != -5 || top_start != -5 || left_down_dia_end_row != -5 || left_down_dia_start_col != -5 || left_top_dia_start_col != -5 || left_top_dia_start_row != -5 || right_down_dia_end_col != -5 || right_down_dia_end_row != -5 || right_top_dia_end_col != -5 || right_top_dia_start_row != -5) {

                    validMoveCell testCell = new validMoveCell();
                    //testCell.role = role;
                    //testCell.utility = utilityFunc(board, player_1);
                    testCell.x = i;
                    testCell.y = j;
                    allMoves.add(testCell);

                }

            }
        }
        return allMoves;

    }

//    public int utilityFunc(int[][] board, int role) {
//        int utility = 0;
//        for (int i = 1; i <= 8; i++) {
//            for (int j = 1; j <= 8; j++) {
//                
//                if(board[i][j]==role)
//                {
//                    if(i==1&& j==1 ||i==1&&j==8||i==8&&j==1||i==8&&j==8 )
//                    {
//                        utility=utility+200;
//                    }
//                    else if(i==1 || j==1 || i==8 || j==8)
//                    {
//                        utility=utility+50;
//                    }
//                    else if(i==2 && j==2 || i==2 && j==7||i==7&&j==2||i==7&&j==7)
//                    {
//                        utility=utility-10;
//                    }
//                    else
//                    {
//                        utility=utility+10;
//                    }
//                }
//                
//            }
//        }
//        return utility;
//    }

    private int huristicFunc(int[][] board, int role) {
        int utility=0;
        for(int i=1;i<=8;i++)
        {
            for(int j=1;j<=8;j++)
            {
                if(board[i][j]==role)
                {
                    if(i==1&& j==1 ||i==1&&j==8||i==8&&j==1||i==8&&j==8 )
                    {
                        utility=utility+200;
                    }
                    else if(i==1 || j==1 || i==8 || j==8)
                    {
                        utility=utility+50;
                    }
                    else if(i==2 && j==2 || i==2 && j==7||i==7&&j==2||i==7&&j==7)
                    {
                        utility=utility-10;
                    }
                    else
                    {
                        utility=utility+10;
                    }
                }
                else if(board[i][j]==(role*-1))
                {
                    if(i==1&& j==1 ||i==1&&j==8||i==8&&j==1||i==8&&j==8 )
                    {
                        utility=utility-500;
                    }
                    else if(i==1 || j==1 || i==8 || j==8)
                    {
                        utility=utility-200;
                    }
                }
            }
        }
        ArrayList<validMoveCell> validMovesListHurestic = new ArrayList<validMoveCell>();
        validMovesListHurestic = findAllPossibleMoves(board, role);
        for(int k=0;k<validMovesListHurestic.size();k++)
        {
            if(validMovesListHurestic.get(k).x==1&& validMovesListHurestic.get(k).y==1 ||validMovesListHurestic.get(k).x==1&&validMovesListHurestic.get(k).y==8||validMovesListHurestic.get(k).x==8&&validMovesListHurestic.get(k).y==1||validMovesListHurestic.get(k).x==8&&validMovesListHurestic.get(k).y==8)
            {
                utility=utility+300;
            }
            if(validMovesListHurestic.get(k).x==1 || validMovesListHurestic.get(k).x==8||validMovesListHurestic.get(k).y==1||validMovesListHurestic.get(k).y==8)
            {
                utility=utility+100;
            }
        }
//        ArrayList<validMoveCell> validMovesListHuresticforopnent = new ArrayList<validMoveCell>();
//        validMovesListHuresticforopnent = findAllPossibleMoves(board, role*-1);
//        for(int k=0;k<validMovesListHuresticforopnent.size();k++)
//        {
//            if(validMovesListHuresticforopnent.get(k).x==1&& validMovesListHuresticforopnent.get(k).y==1 ||validMovesListHuresticforopnent.get(k).x==1&&validMovesListHuresticforopnent.get(k).y==8||validMovesListHuresticforopnent.get(k).x==8&&validMovesListHuresticforopnent.get(k).y==1||validMovesListHuresticforopnent.get(k).x==8&&validMovesListHuresticforopnent.get(k).y==8)
//            {
//                utility=utility-1000;
//            }
//            else if(validMovesListHuresticforopnent.get(k).x==1 || validMovesListHuresticforopnent.get(k).x==8||validMovesListHuresticforopnent.get(k).y==1||validMovesListHuresticforopnent.get(k).y==8)
//            {
//                utility=utility-500;
//            }
//        }
        return utility;
    }



}
