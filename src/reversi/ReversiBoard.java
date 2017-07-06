/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;

import java.awt.Button;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sonjoy
 */
public class ReversiBoard extends javax.swing.JFrame {

    /**
     * Creates new form ReversiBoard
     *
     */
    static Button[][] buttonbox = new Button[9][9];

    public ReversiBoard() {
        initComponents();

        buttonbox[1][1] = b11;
        buttonbox[1][2] = b12;
        buttonbox[1][3] = b13;
        buttonbox[1][4] = b14;
        buttonbox[1][5] = b15;
        buttonbox[1][6] = b16;
        buttonbox[1][7] = b17;
        buttonbox[1][8] = b18;

        buttonbox[2][1] = b21;
        buttonbox[2][2] = b22;
        buttonbox[2][3] = b23;
        buttonbox[2][4] = b24;
        buttonbox[2][5] = b25;
        buttonbox[2][6] = b26;
        buttonbox[2][7] = b27;
        buttonbox[2][8] = b28;

        buttonbox[3][1] = b31;
        buttonbox[3][2] = b32;
        buttonbox[3][3] = b33;
        buttonbox[3][4] = b34;
        buttonbox[3][5] = b35;
        buttonbox[3][6] = b36;
        buttonbox[3][7] = b37;
        buttonbox[3][8] = b38;

        buttonbox[4][1] = b41;
        buttonbox[4][2] = b42;
        buttonbox[4][3] = b43;
        buttonbox[4][4] = b44;
        buttonbox[4][5] = b45;
        buttonbox[4][6] = b46;
        buttonbox[4][7] = b47;
        buttonbox[4][8] = b48;

        buttonbox[5][1] = b51;
        buttonbox[5][2] = b52;
        buttonbox[5][3] = b53;
        buttonbox[5][4] = b54;
        buttonbox[5][5] = b55;
        buttonbox[5][6] = b56;
        buttonbox[5][7] = b57;
        buttonbox[5][8] = b58;

        buttonbox[6][1] = b61;
        buttonbox[6][2] = b62;
        buttonbox[6][3] = b63;
        buttonbox[6][4] = b64;
        buttonbox[6][5] = b65;
        buttonbox[6][6] = b66;
        buttonbox[6][7] = b67;
        buttonbox[6][8] = b68;

        buttonbox[7][1] = b71;
        buttonbox[7][2] = b72;
        buttonbox[7][3] = b73;
        buttonbox[7][4] = b74;
        buttonbox[7][5] = b75;
        buttonbox[7][6] = b76;
        buttonbox[7][7] = b77;
        buttonbox[7][8] = b78;

        buttonbox[8][1] = b81;
        buttonbox[8][2] = b82;
        buttonbox[8][3] = b83;
        buttonbox[8][4] = b84;
        buttonbox[8][5] = b85;
        buttonbox[8][6] = b86;
        buttonbox[8][7] = b87;
        buttonbox[8][8] = b88;

    }

    /**
     *
     */
    public void TempUpdate() {
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                //buttonbox[i][j].setLabel("");
                if (boarddata[i][j] == 0) {
                    buttonbox[i][j].setBackground(Color.gray);
                } else if (boarddata[i][j] == 1) {
                    buttonbox[i][j].setBackground(Color.black);
                } else if (boarddata[i][j] == -1) {
                    buttonbox[i][j].setBackground(Color.blue);
                }
            }

        }
    }

    public void update() {
        if (next_player == 1) {
            current_color_label.setText("Black");
        }
        if (next_player == -1) {
            current_color_label.setText("Blue");
        }
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                buttonbox[i][j].setLabel("");
                if (boarddata[i][j] == 0) {
                    buttonbox[i][j].setBackground(Color.gray);
                } else if (boarddata[i][j] == 1) {
                    buttonbox[i][j].setBackground(Color.black);
                } else if (boarddata[i][j] == -1) {
                    buttonbox[i][j].setBackground(Color.blue);
                }
            }

        }
        scoreUpdate();

    }

    public void showAvailavleMoves(int next_player) {
        int player_1, player_2;
        if (next_player == 1) {
            player_1 = 1;
            player_2 = -1;
        } else {
            player_1 = -1;
            player_2 = 1;
        }
        validMovesList.clear();
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if (boarddata[i][j] == 1 || boarddata[i][j] == -1) {
                    continue;
                }

                int left_start = -5, right_end = -5, top_start = -5, down_end = -5;
                int left_top_dia_start_row = -5, left_top_dia_start_col = -5, right_top_dia_start_row = -5, right_top_dia_end_col = -5, left_down_dia_end_row = -5, left_down_dia_start_col = -5, right_down_dia_end_row = -5, right_down_dia_end_col = -5;

                //left start
                if (j > 2 && boarddata[i][j - 1] == player_2) {
                    for (int col = j - 1; col >= 1; col--) {
                        if (boarddata[i][col] == 0) {
                            break;
                        }
                        if (boarddata[i][col] == player_1) {
                            left_start = col;
                            break;
                        }
                    }
                }

                for (int p = left_start + 1; p <= j && left_start != -5; p++) {
                    //buttonbox[i][p].setBackground(Color.black);
                }

                //right end
                if (j <=6 && boarddata[i][j + 1] == player_2) {
                    for (int col = j + 1; col <= 8; col++) {
                        if (boarddata[i][col] == 0) {
                            break;
                        }
                        if (boarddata[i][col] == player_1) {
                            right_end = col;
                            break;
                        }
                    }
                }

                for (int p = j; p < right_end && right_end != -5; p++) {
                    //buttonbox[i][p].setBackground(Color.black);
                }

                //top start
                //System.out.println("i="+i+" j="+j);
                if (i > 2 && boarddata[i - 1][j] == player_2) {
                    for (int row = i - 1; row >= 1; row--) {
                        if (boarddata[row][j] == 0) {
                            break;
                        }
                        if (boarddata[row][j] == player_1) {
                            top_start = row;
                            //System.out.println("found=" + row);
                            break;
                        }
                    }
                }

                for (int p = top_start + 1; p <= i && top_start != -5; p++) {
                    //buttonbox[p][j].setBackground(Color.black);
                }

                //down_end
                if (i <= 6 && boarddata[i + 1][j] == player_2) {
                    for (int row = i + 1; row <= 8; row++) {
                        if (boarddata[row][j] == 0) {
                            break;
                        }
                        if (boarddata[row][j] == player_1) {
                            down_end = row;
                            //System.out.println("found=" + row);
                            break;
                        }
                    }
                }

                for (int p = i; p < down_end && down_end != -5; p++) {
                    //buttonbox[p][j].setBackground(Color.black);
                }

                //left top dia start
                if (j > 2 && i > 2 && boarddata[i - 1][j - 1] == player_2) {

                    for (int col = j - 1, row = i - 1; col >= 1 && row >= 1; col--, row--) {
                        if (boarddata[row][col] == 0) {
                            break;
                        }
                        if (boarddata[row][col] == player_1) {
                            left_top_dia_start_row = row;
                            left_top_dia_start_col = col;
                            break;
                        }
                    }
                }

                for (int p = left_top_dia_start_row + 1, q = left_top_dia_start_col + 1; p <= i && q <= j && left_top_dia_start_row != -5 && left_top_dia_start_col != -5; p++, q++) {
                    //buttonbox[p][q].setBackground(Color.black);
                }

                //right down diagonal 
                if (j <= 6 && i <= 6 && boarddata[i + 1][j + 1] == player_2) {

                    for (int col = j + 1, row = i + 1; col <= 8 && row <= 8; col++, row++) {
                        if (boarddata[row][col] == 0) {
                            break;
                        }
                        if (boarddata[row][col] == player_1) {
                            right_down_dia_end_row = row;
                            right_down_dia_end_col = col;
                            break;
                        }
                    }
                }

                for (int p = i, q = j; p < right_down_dia_end_row && q < right_down_dia_end_col && right_down_dia_end_row != -5 && right_down_dia_end_col != -5; p++, q++) {
                    // buttonbox[p][q].setBackground(Color.black);
                }

                // right top dia 
                if (i > 2 && j <=6 && boarddata[i - 1][j + 1] == player_2) {

                    for (int col = j + 1, row = i - 1; col <= 8 && row >= 1; col++, row--) {
                        if (boarddata[row][col] == 0) {
                            break;
                        }
                        if (boarddata[row][col] == player_1) {
                            right_top_dia_start_row = row;
                            right_top_dia_end_col = col;
                            break;
                        }
                    }
                }

                for (int p = i, q = j; p > right_top_dia_start_row && q < right_top_dia_end_col && right_top_dia_start_row != -5 && right_top_dia_end_col != -5; p--, q++) {
                    // buttonbox[p][q].setBackground(Color.black);
                }

                // left down diagonal
                if (i <= 6 && j > 2 && boarddata[i + 1][j - 1] == player_2) {

                    for (int col = j - 1, row = i + 1; col >= 1 && row <= 8; col--, row++) {
                        if (boarddata[row][col] == 0) {
                            break;
                        }
                        if (boarddata[row][col] == player_1) {
                            left_down_dia_end_row = row;
                            left_down_dia_start_col = col;
                            break;
                        }
                    }
                }

                for (int p = i, q = j; p < left_down_dia_end_row && q > left_down_dia_start_col && left_down_dia_end_row != -5 && left_down_dia_start_col != -5; p++, q--) {
                    // buttonbox[p][q].setBackground(Color.black);
                }

                if (left_start != -5 || right_end != -5 || down_end != -5 || top_start != -5 || left_down_dia_end_row != -5 || left_down_dia_start_col != -5 || left_top_dia_start_col != -5 || left_top_dia_start_row != -5 || right_down_dia_end_col != -5 || right_down_dia_end_row != -5 || right_top_dia_end_col != -5 || right_top_dia_start_row != -5) {
                    validMoveCell cell = new validMoveCell();
                    cell.role = player_1;
                    cell.x = i;
                    cell.y = j;
                    validMovesList.add(cell);
                    buttonbox[i][j].setLabel("#");
                    //System.out.println("#");
                }

            }
        }

    }

    public void mouseenterd(int i, int j) {

        int player_1, player_2;
        if (next_player == 1) {
            player_1 = 1;
            player_2 = -1;
        } else {
            player_1 = -1;
            player_2 = 1;
        }

        if (boarddata[i][j] == 1 || boarddata[i][j] == -1) {
            return;
        }

        int left_start = -5, right_end = -5, top_start = -5, down_end = -5;
        int left_top_dia_start_row = -5, left_top_dia_start_col = -5, right_top_dia_start_row = -5, right_top_dia_end_col = -5, left_down_dia_end_row = -5, left_down_dia_start_col = -5, right_down_dia_end_row = -5, right_down_dia_end_col = -5;

        //left start
        if (j > 2 && boarddata[i][j - 1] == player_2) {
            for (int col = j - 1; col >= 1; col--) {
                if (boarddata[i][col] == 0) {
                    break;
                }
                if (boarddata[i][col] == player_1) {
                    left_start = col;
                    break;
                }
            }
        }

        for (int p = left_start + 1; p <= j && left_start != -5; p++) {
            if (next_player == 1) {
                buttonbox[i][p].setBackground(Color.black);
            } else if (next_player == -1) {
                buttonbox[i][p].setBackground(Color.blue);
            }
        }

        //right end
        if (j <= 6 && boarddata[i][j + 1] == player_2) {
            for (int col = j + 1; col <= 8; col++) {
                if (boarddata[i][col] == 0) {
                    break;
                }
                if (boarddata[i][col] == player_1) {
                    right_end = col;
                    break;
                }
            }
        }

        for (int p = j; p < right_end && right_end != -5; p++) {
            if (next_player == 1) {
                buttonbox[i][p].setBackground(Color.black);
            } else if (next_player == -1) {
                buttonbox[i][p].setBackground(Color.blue);
            }
        }

        //top start
        //System.out.println("i="+i+" j="+j);
        if (i > 2 && boarddata[i - 1][j] == player_2) {
            for (int row = i - 1; row >= 1; row--) {
                if (boarddata[row][j] == 0) {
                    break;
                }
                if (boarddata[row][j] == player_1) {
                    top_start = row;
                    //System.out.println("found=" + row);
                    break;
                }
            }
        }

        for (int p = top_start + 1; p <= i && top_start != -5; p++) {
            if (next_player == 1) {
                buttonbox[p][j].setBackground(Color.black);
            } else if (next_player == -1) {
                buttonbox[p][j].setBackground(Color.blue);
            }
        }

        //down_end
        if (i <= 6 && boarddata[i + 1][j] == player_2) {
            for (int row = i + 1; row <= 8; row++) {
                if (boarddata[row][j] == 0) {
                    break;
                }
                if (boarddata[row][j] == player_1) {
                    down_end = row;
                    //System.out.println("found=" + row);
                    break;
                }
            }
        }

        for (int p = i; p < down_end && down_end != -5; p++) {
            if (next_player == 1) {
                buttonbox[p][j].setBackground(Color.black);
            } else if (next_player == -1) {
                buttonbox[p][j].setBackground(Color.blue);
            }
        }

        //left top dia start
        if (j > 2 && i > 2 && boarddata[i - 1][j - 1] == player_2) {

            for (int col = j - 1, row = i - 1; col >= 1 && row >= 1; col--, row--) {
                if (boarddata[row][col] == 0) {
                    break;
                }
                if (boarddata[row][col] == player_1) {
                    left_top_dia_start_row = row;
                    left_top_dia_start_col = col;
                    break;
                }
            }
        }

        for (int p = left_top_dia_start_row + 1, q = left_top_dia_start_col + 1; p <= i && q <= j && left_top_dia_start_row != -5 && left_top_dia_start_col != -5; p++, q++) {
            if (next_player == 1) {
                buttonbox[p][q].setBackground(Color.black);
            } else if (next_player == -1) {
                buttonbox[p][q].setBackground(Color.blue);
            }
        }

        //right down diagonal 
        if (j <= 6 && i <= 6 && boarddata[i + 1][j + 1] == player_2) {

            for (int col = j + 1, row = i + 1; col <= 8 && row <= 8; col++, row++) {
                if (boarddata[row][col] == 0) {
                    break;
                }
                if (boarddata[row][col] == player_1) {
                    right_down_dia_end_row = row;
                    right_down_dia_end_col = col;
                    break;
                }
            }
        }

        for (int p = i, q = j; p < right_down_dia_end_row && q < right_down_dia_end_col && right_down_dia_end_row != -5 && right_down_dia_end_col != -5; p++, q++) {
            if (next_player == 1) {
                buttonbox[p][q].setBackground(Color.black);
            } else if (next_player == -1) {
                buttonbox[p][q].setBackground(Color.blue);
            }
        }

        // right top dia 
        if (i > 2 && j <= 6 && boarddata[i - 1][j + 1] == player_2) {

            for (int col = j + 1, row = i - 1; col <= 8 && row >= 1; col++, row--) {
                if (boarddata[row][col] == 0) {
                    break;
                }
                if (boarddata[row][col] == player_1) {
                    right_top_dia_start_row = row;
                    right_top_dia_end_col = col;
                    break;
                }
            }
        }

        for (int p = i, q = j; p > right_top_dia_start_row && q < right_top_dia_end_col && right_top_dia_start_row != -5 && right_top_dia_end_col != -5; p--, q++) {
            if (next_player == 1) {
                buttonbox[p][q].setBackground(Color.black);
            } else if (next_player == -1) {
                buttonbox[p][q].setBackground(Color.blue);
            }
        }

        // left down diagonal
        if (i <= 6 && j > 2 && boarddata[i + 1][j - 1] == player_2) {

            for (int col = j - 1, row = i + 1; col >= 1 && row <= 8; col--, row++) {
                if (boarddata[row][col] == 0) {
                    break;
                }
                if (boarddata[row][col] == player_1) {
                    left_down_dia_end_row = row;
                    left_down_dia_start_col = col;
                    break;
                }
            }
        }

        for (int p = i, q = j; p < left_down_dia_end_row && q > left_down_dia_start_col && left_down_dia_end_row != -5 && left_down_dia_start_col != -5; p++, q--) {
            if (next_player == 1) {
                buttonbox[p][q].setBackground(Color.black);
            } else if (next_player == -1) {
                buttonbox[p][q].setBackground(Color.blue);
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        b11 = new java.awt.Button();
        b12 = new java.awt.Button();
        b13 = new java.awt.Button();
        b14 = new java.awt.Button();
        b15 = new java.awt.Button();
        b16 = new java.awt.Button();
        b17 = new java.awt.Button();
        b18 = new java.awt.Button();
        b22 = new java.awt.Button();
        b23 = new java.awt.Button();
        b21 = new java.awt.Button();
        b24 = new java.awt.Button();
        b25 = new java.awt.Button();
        b26 = new java.awt.Button();
        b27 = new java.awt.Button();
        b28 = new java.awt.Button();
        b31 = new java.awt.Button();
        b35 = new java.awt.Button();
        b36 = new java.awt.Button();
        b38 = new java.awt.Button();
        b32 = new java.awt.Button();
        b37 = new java.awt.Button();
        b33 = new java.awt.Button();
        b34 = new java.awt.Button();
        b67 = new java.awt.Button();
        b48 = new java.awt.Button();
        b62 = new java.awt.Button();
        b55 = new java.awt.Button();
        b54 = new java.awt.Button();
        b52 = new java.awt.Button();
        b43 = new java.awt.Button();
        b46 = new java.awt.Button();
        b47 = new java.awt.Button();
        b65 = new java.awt.Button();
        b51 = new java.awt.Button();
        b68 = new java.awt.Button();
        b45 = new java.awt.Button();
        b41 = new java.awt.Button();
        b63 = new java.awt.Button();
        b44 = new java.awt.Button();
        b53 = new java.awt.Button();
        b58 = new java.awt.Button();
        b56 = new java.awt.Button();
        b66 = new java.awt.Button();
        b57 = new java.awt.Button();
        b42 = new java.awt.Button();
        b61 = new java.awt.Button();
        b64 = new java.awt.Button();
        b78 = new java.awt.Button();
        b77 = new java.awt.Button();
        b72 = new java.awt.Button();
        b74 = new java.awt.Button();
        b71 = new java.awt.Button();
        b75 = new java.awt.Button();
        b73 = new java.awt.Button();
        b76 = new java.awt.Button();
        b88 = new java.awt.Button();
        b87 = new java.awt.Button();
        b82 = new java.awt.Button();
        b84 = new java.awt.Button();
        b81 = new java.awt.Button();
        b85 = new java.awt.Button();
        b83 = new java.awt.Button();
        b86 = new java.awt.Button();
        jPanel2 = new javax.swing.JPanel();
        current_color_label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BlackScoreLable = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BlueScoreLable = new javax.swing.JLabel();
        winMessageLable = new javax.swing.JLabel();
        AIvsHumanButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        startGameButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        b11.setBackground(new java.awt.Color(150, 150, 150));
        b11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b11MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b11MouseEntered(evt);
            }
        });
        b11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b11ActionPerformed(evt);
            }
        });

        b12.setBackground(new java.awt.Color(150, 150, 150));
        b12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b12MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b12MouseEntered(evt);
            }
        });
        b12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b12ActionPerformed(evt);
            }
        });

        b13.setBackground(new java.awt.Color(150, 150, 150));
        b13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b13MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b13MouseEntered(evt);
            }
        });
        b13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b13ActionPerformed(evt);
            }
        });

        b14.setBackground(new java.awt.Color(150, 150, 150));
        b14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b14MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b14MouseEntered(evt);
            }
        });
        b14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b14ActionPerformed(evt);
            }
        });

        b15.setBackground(new java.awt.Color(10, 10, 10));
        b15.setLabel("button1");
        b15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b15MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b15MouseEntered(evt);
            }
        });
        b15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b15ActionPerformed(evt);
            }
        });

        b16.setBackground(new java.awt.Color(10, 10, 10));
        b16.setLabel("button1");
        b16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b16MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b16MouseEntered(evt);
            }
        });
        b16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b16ActionPerformed(evt);
            }
        });

        b17.setBackground(new java.awt.Color(10, 10, 10));
        b17.setLabel("button1");
        b17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b17MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b17MouseEntered(evt);
            }
        });
        b17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b17ActionPerformed(evt);
            }
        });

        b18.setBackground(new java.awt.Color(10, 10, 10));
        b18.setLabel("button1");
        b18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b18MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b18MouseEntered(evt);
            }
        });
        b18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b18ActionPerformed(evt);
            }
        });

        b22.setBackground(new java.awt.Color(150, 150, 150));
        b22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b22MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b22MouseEntered(evt);
            }
        });
        b22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b22ActionPerformed(evt);
            }
        });

        b23.setBackground(new java.awt.Color(10, 10, 10));
        b23.setLabel("button1");
        b23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b23MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b23MouseEntered(evt);
            }
        });
        b23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b23ActionPerformed(evt);
            }
        });

        b21.setBackground(new java.awt.Color(10, 10, 10));
        b21.setLabel("button1");
        b21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b21MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b21MouseEntered(evt);
            }
        });
        b21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b21ActionPerformed(evt);
            }
        });

        b24.setBackground(new java.awt.Color(10, 10, 10));
        b24.setLabel("button1");
        b24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b24MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b24MouseEntered(evt);
            }
        });
        b24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b24ActionPerformed(evt);
            }
        });

        b25.setBackground(new java.awt.Color(10, 10, 10));
        b25.setLabel("button1");
        b25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b25MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b25MouseEntered(evt);
            }
        });
        b25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b25ActionPerformed(evt);
            }
        });

        b26.setBackground(new java.awt.Color(10, 10, 10));
        b26.setLabel("button1");
        b26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b26MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b26MouseEntered(evt);
            }
        });
        b26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b26ActionPerformed(evt);
            }
        });

        b27.setBackground(new java.awt.Color(10, 10, 10));
        b27.setLabel("button1");
        b27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b27MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b27MouseEntered(evt);
            }
        });
        b27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b27ActionPerformed(evt);
            }
        });

        b28.setBackground(new java.awt.Color(10, 10, 10));
        b28.setLabel("button1");
        b28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b28MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b28MouseEntered(evt);
            }
        });
        b28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b28ActionPerformed(evt);
            }
        });

        b31.setBackground(new java.awt.Color(10, 10, 10));
        b31.setLabel("button1");
        b31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b31MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b31MouseEntered(evt);
            }
        });
        b31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b31ActionPerformed(evt);
            }
        });

        b35.setBackground(new java.awt.Color(10, 10, 10));
        b35.setLabel("button1");
        b35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b35MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b35MouseEntered(evt);
            }
        });
        b35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b35ActionPerformed(evt);
            }
        });

        b36.setBackground(new java.awt.Color(10, 10, 10));
        b36.setLabel("button1");
        b36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b36MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b36MouseEntered(evt);
            }
        });
        b36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b36ActionPerformed(evt);
            }
        });

        b38.setBackground(new java.awt.Color(10, 10, 10));
        b38.setLabel("button1");
        b38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b38MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b38MouseEntered(evt);
            }
        });
        b38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b38ActionPerformed(evt);
            }
        });

        b32.setBackground(new java.awt.Color(10, 10, 10));
        b32.setLabel("button1");
        b32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b32MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b32MouseEntered(evt);
            }
        });
        b32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b32ActionPerformed(evt);
            }
        });

        b37.setBackground(new java.awt.Color(10, 10, 10));
        b37.setLabel("button1");
        b37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b37MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b37MouseEntered(evt);
            }
        });
        b37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b37ActionPerformed(evt);
            }
        });

        b33.setBackground(new java.awt.Color(10, 10, 10));
        b33.setLabel("button1");
        b33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b33MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b33MouseEntered(evt);
            }
        });
        b33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b33ActionPerformed(evt);
            }
        });

        b34.setBackground(new java.awt.Color(10, 10, 10));
        b34.setLabel("button1");
        b34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b34MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b34MouseEntered(evt);
            }
        });
        b34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b34ActionPerformed(evt);
            }
        });

        b67.setBackground(new java.awt.Color(10, 10, 10));
        b67.setLabel("button1");
        b67.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b67MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b67MouseEntered(evt);
            }
        });
        b67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b67ActionPerformed(evt);
            }
        });

        b48.setBackground(new java.awt.Color(10, 10, 10));
        b48.setLabel("button1");
        b48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b48MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b48MouseEntered(evt);
            }
        });
        b48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b48ActionPerformed(evt);
            }
        });

        b62.setBackground(new java.awt.Color(10, 10, 10));
        b62.setLabel("button1");
        b62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b62MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b62MouseEntered(evt);
            }
        });
        b62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b62ActionPerformed(evt);
            }
        });

        b55.setBackground(new java.awt.Color(10, 10, 10));
        b55.setLabel("button1");
        b55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b55MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b55MouseEntered(evt);
            }
        });
        b55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b55ActionPerformed(evt);
            }
        });

        b54.setBackground(new java.awt.Color(10, 10, 10));
        b54.setLabel("button1");
        b54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b54MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b54MouseEntered(evt);
            }
        });
        b54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b54ActionPerformed(evt);
            }
        });

        b52.setBackground(new java.awt.Color(10, 10, 10));
        b52.setLabel("button1");
        b52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b52MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b52MouseEntered(evt);
            }
        });
        b52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b52ActionPerformed(evt);
            }
        });

        b43.setBackground(new java.awt.Color(10, 10, 10));
        b43.setLabel("button1");
        b43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b43MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b43MouseEntered(evt);
            }
        });
        b43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b43ActionPerformed(evt);
            }
        });

        b46.setBackground(new java.awt.Color(10, 10, 10));
        b46.setLabel("button1");
        b46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b46MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b46MouseEntered(evt);
            }
        });
        b46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b46ActionPerformed(evt);
            }
        });

        b47.setBackground(new java.awt.Color(10, 10, 10));
        b47.setLabel("button1");
        b47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b47MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b47MouseEntered(evt);
            }
        });
        b47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b47ActionPerformed(evt);
            }
        });

        b65.setBackground(new java.awt.Color(10, 10, 10));
        b65.setLabel("button1");
        b65.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b65MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b65MouseEntered(evt);
            }
        });
        b65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b65ActionPerformed(evt);
            }
        });

        b51.setBackground(new java.awt.Color(10, 10, 10));
        b51.setLabel("button1");
        b51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b51MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b51MouseEntered(evt);
            }
        });
        b51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b51ActionPerformed(evt);
            }
        });

        b68.setBackground(new java.awt.Color(10, 10, 10));
        b68.setLabel("button1");
        b68.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b68MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b68MouseEntered(evt);
            }
        });
        b68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b68ActionPerformed(evt);
            }
        });

        b45.setBackground(new java.awt.Color(10, 10, 10));
        b45.setLabel("button1");
        b45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b45MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b45MouseEntered(evt);
            }
        });
        b45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b45ActionPerformed(evt);
            }
        });

        b41.setBackground(new java.awt.Color(10, 10, 10));
        b41.setLabel("button1");
        b41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b41MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b41MouseEntered(evt);
            }
        });
        b41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b41ActionPerformed(evt);
            }
        });

        b63.setBackground(new java.awt.Color(10, 10, 10));
        b63.setLabel("button1");
        b63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b63MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b63MouseEntered(evt);
            }
        });
        b63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b63ActionPerformed(evt);
            }
        });

        b44.setBackground(new java.awt.Color(10, 10, 10));
        b44.setLabel("button1");
        b44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b44MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b44MouseEntered(evt);
            }
        });
        b44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b44ActionPerformed(evt);
            }
        });

        b53.setBackground(new java.awt.Color(10, 10, 10));
        b53.setLabel("button1");
        b53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b53MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b53MouseEntered(evt);
            }
        });
        b53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b53ActionPerformed(evt);
            }
        });

        b58.setBackground(new java.awt.Color(10, 10, 10));
        b58.setLabel("button1");
        b58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b58MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b58MouseEntered(evt);
            }
        });
        b58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b58ActionPerformed(evt);
            }
        });

        b56.setBackground(new java.awt.Color(10, 10, 10));
        b56.setLabel("button1");
        b56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b56MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b56MouseEntered(evt);
            }
        });
        b56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b56ActionPerformed(evt);
            }
        });

        b66.setBackground(new java.awt.Color(10, 10, 10));
        b66.setLabel("button1");
        b66.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b66MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b66MouseEntered(evt);
            }
        });
        b66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b66ActionPerformed(evt);
            }
        });

        b57.setBackground(new java.awt.Color(10, 10, 10));
        b57.setLabel("button1");
        b57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b57MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b57MouseEntered(evt);
            }
        });
        b57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b57ActionPerformed(evt);
            }
        });

        b42.setBackground(new java.awt.Color(10, 10, 10));
        b42.setLabel("button1");
        b42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b42MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b42MouseEntered(evt);
            }
        });
        b42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b42ActionPerformed(evt);
            }
        });

        b61.setBackground(new java.awt.Color(10, 10, 10));
        b61.setLabel("button1");
        b61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b61MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b61MouseEntered(evt);
            }
        });
        b61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b61ActionPerformed(evt);
            }
        });

        b64.setBackground(new java.awt.Color(10, 10, 10));
        b64.setLabel("button1");
        b64.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b64MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b64MouseEntered(evt);
            }
        });
        b64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b64ActionPerformed(evt);
            }
        });

        b78.setBackground(new java.awt.Color(10, 10, 10));
        b78.setLabel("button1");
        b78.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b78MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b78MouseEntered(evt);
            }
        });
        b78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b78ActionPerformed(evt);
            }
        });

        b77.setBackground(new java.awt.Color(10, 10, 10));
        b77.setLabel("button1");
        b77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b77MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b77MouseEntered(evt);
            }
        });
        b77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b77ActionPerformed(evt);
            }
        });

        b72.setBackground(new java.awt.Color(10, 10, 10));
        b72.setLabel("button1");
        b72.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b72MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b72MouseEntered(evt);
            }
        });
        b72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b72ActionPerformed(evt);
            }
        });

        b74.setBackground(new java.awt.Color(10, 10, 10));
        b74.setLabel("button1");
        b74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b74MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b74MouseEntered(evt);
            }
        });
        b74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b74ActionPerformed(evt);
            }
        });

        b71.setBackground(new java.awt.Color(10, 10, 10));
        b71.setLabel("button1");
        b71.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b71MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b71MouseEntered(evt);
            }
        });
        b71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b71ActionPerformed(evt);
            }
        });

        b75.setBackground(new java.awt.Color(10, 10, 10));
        b75.setLabel("button1");
        b75.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b75MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b75MouseEntered(evt);
            }
        });
        b75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b75ActionPerformed(evt);
            }
        });

        b73.setBackground(new java.awt.Color(10, 10, 10));
        b73.setLabel("button1");
        b73.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b73MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b73MouseEntered(evt);
            }
        });
        b73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b73ActionPerformed(evt);
            }
        });

        b76.setBackground(new java.awt.Color(10, 10, 10));
        b76.setLabel("button1");
        b76.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b76MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b76MouseEntered(evt);
            }
        });
        b76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b76ActionPerformed(evt);
            }
        });

        b88.setBackground(new java.awt.Color(10, 10, 10));
        b88.setLabel("button1");
        b88.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b88MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b88MouseEntered(evt);
            }
        });
        b88.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b88ActionPerformed(evt);
            }
        });

        b87.setBackground(new java.awt.Color(10, 10, 10));
        b87.setLabel("button1");
        b87.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b87MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b87MouseEntered(evt);
            }
        });
        b87.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b87ActionPerformed(evt);
            }
        });

        b82.setBackground(new java.awt.Color(10, 10, 10));
        b82.setLabel("button1");
        b82.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b82MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b82MouseEntered(evt);
            }
        });
        b82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b82ActionPerformed(evt);
            }
        });

        b84.setBackground(new java.awt.Color(10, 10, 10));
        b84.setLabel("button1");
        b84.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b84MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b84MouseEntered(evt);
            }
        });
        b84.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b84ActionPerformed(evt);
            }
        });

        b81.setBackground(new java.awt.Color(10, 10, 10));
        b81.setLabel("button1");
        b81.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b81MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b81MouseEntered(evt);
            }
        });
        b81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b81ActionPerformed(evt);
            }
        });

        b85.setBackground(new java.awt.Color(10, 10, 10));
        b85.setLabel("button1");
        b85.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b85MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b85MouseEntered(evt);
            }
        });
        b85.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b85ActionPerformed(evt);
            }
        });

        b83.setBackground(new java.awt.Color(10, 10, 10));
        b83.setLabel("button1");
        b83.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b83MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b83MouseEntered(evt);
            }
        });
        b83.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b83ActionPerformed(evt);
            }
        });

        b86.setBackground(new java.awt.Color(10, 10, 10));
        b86.setLabel("button1");
        b86.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b86MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b86MouseEntered(evt);
            }
        });
        b86.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b86ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(b11, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b12, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(b21, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b22, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b13, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(b23, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(b24, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(b14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(b15, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(b16, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(b17, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(b25, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(b26, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(b27, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b18, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(b61, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b62, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b63, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b64, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b65, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b66, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b67, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b68, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(b41, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b42, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b43, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b44, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b45, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b46, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b47, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b48, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(b51, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b52, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b53, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b54, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b55, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b56, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b57, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b58, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(b71, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b72, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b73, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b74, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b75, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b76, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b77, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b78, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(b81, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b82, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b83, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b84, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b85, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b86, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b87, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b88, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(b31, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b32, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b33, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b34, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b35, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b36, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b37, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(b28, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(b38, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b17, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b16, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b14, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b15, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b18, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b27, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b26, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b24, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b25, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b28, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b21, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b22, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b23, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b37, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b36, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b31, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b32, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b33, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b34, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b35, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b38, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b47, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b46, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b41, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b42, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b43, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b44, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b45, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b48, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b57, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b56, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b51, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b52, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b53, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b54, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b55, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b58, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b67, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b66, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b61, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b62, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b63, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b64, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b65, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b68, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b77, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b76, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b71, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b72, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b73, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b74, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b75, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b78, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b87, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b86, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b81, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b82, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b83, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b84, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b85, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b88, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        current_color_label.setText("test");

        jLabel1.setText("Now");

        jLabel2.setText("move");

        jLabel3.setText("Black Score:");

        BlackScoreLable.setText("jLabel4");

        jLabel4.setText("Blue Score:");

        BlueScoreLable.setText("jLabel5");

        winMessageLable.setText("wining message");

        AIvsHumanButton.setText("AI vs Human");
        AIvsHumanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AIvsHumanButtonActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(28, 228, 71));
        jLabel5.setText("your color is black");

        startGameButton.setText("Start New Game");
        startGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGameButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(winMessageLable, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(AIvsHumanButton)
                        .addGap(183, 183, 183)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BlackScoreLable)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(current_color_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BlueScoreLable)
                        .addGap(172, 172, 172))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(startGameButton)
                        .addGap(194, 194, 194))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(current_color_label)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(BlackScoreLable)
                    .addComponent(jLabel4)
                    .addComponent(BlueScoreLable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(AIvsHumanButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(startGameButton))
                .addGap(22, 22, 22)
                .addComponent(winMessageLable, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b61ActionPerformed
        // TODO add your handling code here:
        next_move(6, 1);
    }//GEN-LAST:event_b61ActionPerformed

    private void b71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b71ActionPerformed
        // TODO add your handling code here:
        next_move(7, 1);
    }//GEN-LAST:event_b71ActionPerformed

    private void b81ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b81ActionPerformed
        // TODO add your handling code here:
        next_move(8, 1);
    }//GEN-LAST:event_b81ActionPerformed

    private void b11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b11ActionPerformed
        // TODO add your handling code here:
        next_move(1, 1);
    }//GEN-LAST:event_b11ActionPerformed

    private void b13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b13ActionPerformed
        // TODO add your handling code here:
        next_move(1, 3);
    }//GEN-LAST:event_b13ActionPerformed

    private void b21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b21ActionPerformed
        // TODO add your handling code here:
        next_move(2, 1);
    }//GEN-LAST:event_b21ActionPerformed

    private void b22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b22ActionPerformed
        // TODO add your handling code here:
        next_move(2, 2);
    }//GEN-LAST:event_b22ActionPerformed

    private void b33MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b33MouseEntered
        mouseenterd(3, 3);

    }//GEN-LAST:event_b33MouseEntered

    private void b33MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b33MouseExited
        TempUpdate();
    }//GEN-LAST:event_b33MouseExited

    private void b64MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b64MouseEntered
        // TODO add your handling code here:
        mouseenterd(6, 4);
    }//GEN-LAST:event_b64MouseEntered

    private void b45MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b45MouseEntered
        // TODO add your handling code here:
        mouseenterd(4, 5);
    }//GEN-LAST:event_b45MouseEntered

    private void b46MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b46MouseEntered
        // TODO add your handling code here:
        mouseenterd(4, 6);
    }//GEN-LAST:event_b46MouseEntered

    private void b56MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b56MouseEntered
        // TODO add your handling code here:
        mouseenterd(5, 6);
    }//GEN-LAST:event_b56MouseEntered

    private void b65MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b65MouseEntered
        // TODO add your handling code here:
        mouseenterd(6, 5);
    }//GEN-LAST:event_b65MouseEntered

    private void b46MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b46MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b46MouseExited

    private void b11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b11MouseEntered
        // TODO add your handling code here:
        mouseenterd(1, 1);
    }//GEN-LAST:event_b11MouseEntered

    private void b12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b12MouseEntered
        // TODO add your handling code here:
        mouseenterd(1, 2);
    }//GEN-LAST:event_b12MouseEntered

    private void b41MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b41MouseEntered
        // TODO add your handling code here:
        mouseenterd(4, 1);
    }//GEN-LAST:event_b41MouseEntered

    private void b42MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b42MouseEntered
        // TODO add your handling code here:
        mouseenterd(4, 2);
    }//GEN-LAST:event_b42MouseEntered

    private void b43MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b43MouseEntered
        // TODO add your handling code here:
        mouseenterd(4, 3);
    }//GEN-LAST:event_b43MouseEntered

    private void b44MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b44MouseEntered
        // TODO add your handling code here:
        mouseenterd(4, 4);
    }//GEN-LAST:event_b44MouseEntered

    private void b45MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b45MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b45MouseExited

    private void b47MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b47MouseEntered
        // TODO add your handling code here:
        mouseenterd(4, 7);
    }//GEN-LAST:event_b47MouseEntered

    private void b47MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b47MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b47MouseExited

    private void b48MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b48MouseEntered
        // TODO add your handling code here:
        mouseenterd(4, 8);
    }//GEN-LAST:event_b48MouseEntered

    private void b48MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b48MouseExited
        // TODO add your handling code here:
        TempUpdate();

    }//GEN-LAST:event_b48MouseExited

    private void b51MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b51MouseEntered
        // TODO add your handling code here:
        mouseenterd(5, 1);
    }//GEN-LAST:event_b51MouseEntered

    private void b51MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b51MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b51MouseExited

    private void b52MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b52MouseEntered
        // TODO add your handling code here:
        mouseenterd(5, 2);
    }//GEN-LAST:event_b52MouseEntered

    private void b52MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b52MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b52MouseExited

    private void b53MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b53MouseEntered
        // TODO add your handling code here:
        mouseenterd(5, 3);
    }//GEN-LAST:event_b53MouseEntered

    private void b53MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b53MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b53MouseExited

    private void b54MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b54MouseEntered
        // TODO add your handling code here:
        mouseenterd(5, 4);
    }//GEN-LAST:event_b54MouseEntered

    private void b54MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b54MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b54MouseExited

    private void b55MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b55MouseEntered
        // TODO add your handling code here:
        mouseenterd(5, 5);
    }//GEN-LAST:event_b55MouseEntered

    private void b55MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b55MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b55MouseExited

    private void b56MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b56MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b56MouseExited

    private void b57MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b57MouseEntered
        // TODO add your handling code here:
        mouseenterd(5, 7);
    }//GEN-LAST:event_b57MouseEntered

    private void b57MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b57MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b57MouseExited

    private void b58MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b58MouseEntered
        // TODO add your handling code here:
        mouseenterd(5, 8);
    }//GEN-LAST:event_b58MouseEntered

    private void b58MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b58MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b58MouseExited

    private void b18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b18MouseEntered
        // TODO add your handling code here:
        mouseenterd(1, 8);
    }//GEN-LAST:event_b18MouseEntered

    private void b18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b18MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b18MouseExited

    private void b17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b17MouseEntered
        // TODO add your handling code here:
        mouseenterd(1, 7);
    }//GEN-LAST:event_b17MouseEntered

    private void b17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b17MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b17MouseExited

    private void b16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b16MouseEntered
        // TODO add your handling code here:
        mouseenterd(1, 6);
    }//GEN-LAST:event_b16MouseEntered

    private void b16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b16MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b16MouseExited

    private void b15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b15MouseEntered
        // TODO add your handling code here:
        mouseenterd(1, 5);
    }//GEN-LAST:event_b15MouseEntered

    private void b15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b15MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b15MouseExited

    private void b14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b14MouseEntered
        // TODO add your handling code here:
        mouseenterd(1, 4);
    }//GEN-LAST:event_b14MouseEntered

    private void b14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b14MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b14MouseExited

    private void b13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b13MouseEntered
        // TODO add your handling code here:
        mouseenterd(1, 3);
    }//GEN-LAST:event_b13MouseEntered

    private void b13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b13MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b13MouseExited

    private void b12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b12MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b12MouseExited

    private void b11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b11MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b11MouseExited

    private void b21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b21MouseEntered
        // TODO add your handling code here:
        mouseenterd(2, 1);
    }//GEN-LAST:event_b21MouseEntered

    private void b21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b21MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b21MouseExited

    private void b22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b22MouseEntered
        // TODO add your handling code here:
        mouseenterd(2, 2);

    }//GEN-LAST:event_b22MouseEntered

    private void b22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b22MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b22MouseExited

    private void b23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b23MouseEntered
        // TODO add your handling code here:
        mouseenterd(2, 3);
    }//GEN-LAST:event_b23MouseEntered

    private void b23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b23MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b23MouseExited

    private void b24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b24MouseEntered
        // TODO add your handling code here:
        mouseenterd(2, 4);
    }//GEN-LAST:event_b24MouseEntered

    private void b24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b24MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b24MouseExited

    private void b25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b25MouseEntered
        // TODO add your handling code here:
        mouseenterd(2, 5);
    }//GEN-LAST:event_b25MouseEntered

    private void b25MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b25MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b25MouseExited

    private void b26MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b26MouseEntered
        // TODO add your handling code here:
        mouseenterd(2, 6);
    }//GEN-LAST:event_b26MouseEntered

    private void b26MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b26MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b26MouseExited

    private void b27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b27MouseEntered
        // TODO add your handling code here:
        mouseenterd(2, 7);
    }//GEN-LAST:event_b27MouseEntered

    private void b27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b27MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b27MouseExited

    private void b28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b28MouseEntered
        // TODO add your handling code here:
        mouseenterd(2, 8);
    }//GEN-LAST:event_b28MouseEntered

    private void b28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b28MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b28MouseExited

    private void b31MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b31MouseEntered
        // TODO add your handling code here:
        mouseenterd(3, 1);
    }//GEN-LAST:event_b31MouseEntered

    private void b31MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b31MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b31MouseExited

    private void b32MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b32MouseEntered
        // TODO add your handling code here:
        mouseenterd(3, 2);
    }//GEN-LAST:event_b32MouseEntered

    private void b32MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b32MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b32MouseExited

    private void b34MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b34MouseEntered
        // TODO add your handling code here:
        mouseenterd(3, 4);
    }//GEN-LAST:event_b34MouseEntered

    private void b34MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b34MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b34MouseExited

    private void b35MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b35MouseEntered
        // TODO add your handling code here:
        mouseenterd(3, 5);
    }//GEN-LAST:event_b35MouseEntered

    private void b35MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b35MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b35MouseExited

    private void b36MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b36MouseEntered
        // TODO add your handling code here:
        mouseenterd(3, 6);
    }//GEN-LAST:event_b36MouseEntered

    private void b36MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b36MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b36MouseExited

    private void b37MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b37MouseEntered
        // TODO add your handling code here:
        mouseenterd(3, 7);
    }//GEN-LAST:event_b37MouseEntered

    private void b37MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b37MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b37MouseExited

    private void b38MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b38MouseEntered
        // TODO add your handling code here:
        mouseenterd(3, 8);
    }//GEN-LAST:event_b38MouseEntered

    private void b38MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b38MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b38MouseExited

    private void b41MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b41MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b41MouseExited

    private void b42MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b42MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b42MouseExited

    private void b43MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b43MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b43MouseExited

    private void b44MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b44MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b44MouseExited

    private void b61MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b61MouseEntered
        // TODO add your handling code here:
        mouseenterd(6, 1);
    }//GEN-LAST:event_b61MouseEntered

    private void b61MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b61MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b61MouseExited

    private void b62MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b62MouseEntered
        // TODO add your handling code here:
        mouseenterd(6, 2);
    }//GEN-LAST:event_b62MouseEntered

    private void b62MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b62MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b62MouseExited

    private void b63MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b63MouseEntered
        // TODO add your handling code here:
        mouseenterd(6, 3);
    }//GEN-LAST:event_b63MouseEntered

    private void b63MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b63MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b63MouseExited

    private void b64MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b64MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b64MouseExited

    private void b65MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b65MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b65MouseExited

    private void b66MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b66MouseEntered
        // TODO add your handling code here:
        mouseenterd(6, 6);
    }//GEN-LAST:event_b66MouseEntered

    private void b66MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b66MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b66MouseExited

    private void b67MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b67MouseEntered
        // TODO add your handling code here:
        mouseenterd(6, 7);
    }//GEN-LAST:event_b67MouseEntered

    private void b67MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b67MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b67MouseExited

    private void b68MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b68MouseEntered
        // TODO add your handling code here:
        mouseenterd(6, 8);
    }//GEN-LAST:event_b68MouseEntered

    private void b68MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b68MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b68MouseExited

    private void b71MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b71MouseEntered
        // TODO add your handling code here:
        mouseenterd(7, 1);
    }//GEN-LAST:event_b71MouseEntered

    private void b71MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b71MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b71MouseExited

    private void b72MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b72MouseEntered
        // TODO add your handling code here:
        mouseenterd(7, 2);
    }//GEN-LAST:event_b72MouseEntered

    private void b72MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b72MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b72MouseExited

    private void b73MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b73MouseEntered
        // TODO add your handling code here:
        mouseenterd(7, 3);
    }//GEN-LAST:event_b73MouseEntered

    private void b73MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b73MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b73MouseExited

    private void b74MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b74MouseEntered
        // TODO add your handling code here:
        mouseenterd(7, 4);
    }//GEN-LAST:event_b74MouseEntered

    private void b74MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b74MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b74MouseExited

    private void b75MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b75MouseEntered
        // TODO add your handling code here:
        mouseenterd(7, 5);
    }//GEN-LAST:event_b75MouseEntered

    private void b75MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b75MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b75MouseExited

    private void b76MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b76MouseEntered
        // TODO add your handling code here:
        mouseenterd(7, 6);
    }//GEN-LAST:event_b76MouseEntered

    private void b76MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b76MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b76MouseExited

    private void b77MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b77MouseEntered
        // TODO add your handling code here:
        mouseenterd(7, 7);
    }//GEN-LAST:event_b77MouseEntered

    private void b77MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b77MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b77MouseExited

    private void b78MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b78MouseEntered
        // TODO add your handling code here:
        mouseenterd(7, 8);
    }//GEN-LAST:event_b78MouseEntered

    private void b78MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b78MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b78MouseExited

    private void b81MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b81MouseEntered
        // TODO add your handling code here:
        mouseenterd(8, 1);
    }//GEN-LAST:event_b81MouseEntered

    private void b81MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b81MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b81MouseExited

    private void b82MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b82MouseEntered
        // TODO add your handling code here:
        mouseenterd(8, 2);
    }//GEN-LAST:event_b82MouseEntered

    private void b82MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b82MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b82MouseExited

    private void b83MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b83MouseEntered
        // TODO add your handling code here:
        mouseenterd(8, 3);
    }//GEN-LAST:event_b83MouseEntered

    private void b83MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b83MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b83MouseExited

    private void b84MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b84MouseEntered
        // TODO add your handling code here:
        mouseenterd(8, 4);
    }//GEN-LAST:event_b84MouseEntered

    private void b84MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b84MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b84MouseExited

    private void b85MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b85MouseEntered
        // TODO add your handling code here:
        mouseenterd(8, 5);
    }//GEN-LAST:event_b85MouseEntered

    private void b85MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b85MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b85MouseExited

    private void b86MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b86MouseEntered
        // TODO add your handling code here:
        mouseenterd(8, 6);
    }//GEN-LAST:event_b86MouseEntered

    private void b86MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b86MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b86MouseExited

    private void b87MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b87MouseEntered
        // TODO add your handling code here:
        mouseenterd(8, 7);
    }//GEN-LAST:event_b87MouseEntered

    private void b87MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b87MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b87MouseExited

    private void b88MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b88MouseEntered
        // TODO add your handling code here:
        mouseenterd(8, 8);
    }//GEN-LAST:event_b88MouseEntered

    private void b88MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b88MouseExited
        // TODO add your handling code here:
        TempUpdate();
    }//GEN-LAST:event_b88MouseExited

    private void b12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b12ActionPerformed
        // TODO add your handling code here:
        next_move(1, 2);
    }//GEN-LAST:event_b12ActionPerformed

    private void b14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b14ActionPerformed
        // TODO add your handling code here:
        next_move(1, 4);
    }//GEN-LAST:event_b14ActionPerformed

    private void b15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b15ActionPerformed
        // TODO add your handling code here:
        next_move(1, 5);
    }//GEN-LAST:event_b15ActionPerformed

    private void b16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b16ActionPerformed
        // TODO add your handling code here:
        next_move(1, 6);
    }//GEN-LAST:event_b16ActionPerformed

    private void b17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b17ActionPerformed
        // TODO add your handling code here:
        next_move(1, 7);
    }//GEN-LAST:event_b17ActionPerformed

    private void b18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b18ActionPerformed
        // TODO add your handling code here:
        next_move(1, 8);
    }//GEN-LAST:event_b18ActionPerformed

    private void b23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b23ActionPerformed
        // TODO add your handling code here:
        next_move(2, 3);
    }//GEN-LAST:event_b23ActionPerformed

    private void b24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b24ActionPerformed
        // TODO add your handling code here:
        next_move(2, 4);
    }//GEN-LAST:event_b24ActionPerformed

    private void b25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b25ActionPerformed
        // TODO add your handling code here:
        next_move(2, 5);
    }//GEN-LAST:event_b25ActionPerformed

    private void b26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b26ActionPerformed
        // TODO add your handling code here:
        next_move(2, 6);
    }//GEN-LAST:event_b26ActionPerformed

    private void b27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b27ActionPerformed
        // TODO add your handling code here:
        next_move(2, 7);
    }//GEN-LAST:event_b27ActionPerformed

    private void b28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b28ActionPerformed
        // TODO add your handling code here:
        next_move(2, 8);
    }//GEN-LAST:event_b28ActionPerformed

    private void b31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b31ActionPerformed
        // TODO add your handling code here:
        next_move(3, 1);
    }//GEN-LAST:event_b31ActionPerformed

    private void b32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b32ActionPerformed
        // TODO add your handling code here:
        next_move(3, 2);
    }//GEN-LAST:event_b32ActionPerformed

    private void b33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b33ActionPerformed
        // TODO add your handling code here:
        next_move(3, 3);
    }//GEN-LAST:event_b33ActionPerformed

    private void b34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b34ActionPerformed
        // TODO add your handling code here:
        next_move(3, 4);
    }//GEN-LAST:event_b34ActionPerformed

    private void b35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b35ActionPerformed
        // TODO add your handling code here:
        next_move(3, 5);
    }//GEN-LAST:event_b35ActionPerformed

    private void b36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b36ActionPerformed
        // TODO add your handling code here:
        next_move(3, 6);
    }//GEN-LAST:event_b36ActionPerformed

    private void b37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b37ActionPerformed
        // TODO add your handling code here:
        next_move(3, 7);
    }//GEN-LAST:event_b37ActionPerformed

    private void b38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b38ActionPerformed
        // TODO add your handling code here:
        next_move(3, 8);
    }//GEN-LAST:event_b38ActionPerformed

    private void b41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b41ActionPerformed
        // TODO add your handling code here:
        next_move(4, 1);
    }//GEN-LAST:event_b41ActionPerformed

    private void b42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b42ActionPerformed
        // TODO add your handling code here:
        next_move(4, 2);
    }//GEN-LAST:event_b42ActionPerformed

    private void b43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b43ActionPerformed
        // TODO add your handling code here:
        next_move(4, 3);
    }//GEN-LAST:event_b43ActionPerformed

    private void b44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b44ActionPerformed
        // TODO add your handling code here:
        next_move(4, 4);
    }//GEN-LAST:event_b44ActionPerformed

    private void b45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b45ActionPerformed
        // TODO add your handling code here:
        next_move(4, 5);
    }//GEN-LAST:event_b45ActionPerformed

    private void b46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b46ActionPerformed
        // TODO add your handling code here:
        next_move(4, 6);
    }//GEN-LAST:event_b46ActionPerformed

    private void b47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b47ActionPerformed
        // TODO add your handling code here:
        next_move(4, 7);
    }//GEN-LAST:event_b47ActionPerformed

    private void b48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b48ActionPerformed
        // TODO add your handling code here:
        next_move(4, 8);
    }//GEN-LAST:event_b48ActionPerformed

    private void b51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b51ActionPerformed
        // TODO add your handling code here:
        next_move(5, 1);
    }//GEN-LAST:event_b51ActionPerformed

    private void b52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b52ActionPerformed
        // TODO add your handling code here:
        next_move(5, 2);
    }//GEN-LAST:event_b52ActionPerformed

    private void b53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b53ActionPerformed
        // TODO add your handling code here:
        next_move(5, 3);
    }//GEN-LAST:event_b53ActionPerformed

    private void b54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b54ActionPerformed
        // TODO add your handling code here:
        next_move(5, 4);
    }//GEN-LAST:event_b54ActionPerformed

    private void b55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b55ActionPerformed
        // TODO add your handling code here:
        next_move(5, 5);
    }//GEN-LAST:event_b55ActionPerformed

    private void b56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b56ActionPerformed
        // TODO add your handling code here:
        next_move(5, 6);
    }//GEN-LAST:event_b56ActionPerformed

    private void b57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b57ActionPerformed
        // TODO add your handling code here:
        next_move(5, 7);
    }//GEN-LAST:event_b57ActionPerformed

    private void b58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b58ActionPerformed
        // TODO add your handling code here:
        next_move(5, 8);
    }//GEN-LAST:event_b58ActionPerformed

    private void b62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b62ActionPerformed
        // TODO add your handling code here:
        next_move(6, 2);
    }//GEN-LAST:event_b62ActionPerformed

    private void b63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b63ActionPerformed
        // TODO add your handling code here:
        next_move(6, 3);
    }//GEN-LAST:event_b63ActionPerformed

    private void b64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b64ActionPerformed
        // TODO add your handling code here:
        next_move(6, 4);
    }//GEN-LAST:event_b64ActionPerformed

    private void b65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b65ActionPerformed
        // TODO add your handling code here:
        next_move(6, 5);
    }//GEN-LAST:event_b65ActionPerformed

    private void b66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b66ActionPerformed
        // TODO add your handling code here:
        next_move(6, 6);
    }//GEN-LAST:event_b66ActionPerformed

    private void b67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b67ActionPerformed
        // TODO add your handling code here:
        next_move(6, 7);
    }//GEN-LAST:event_b67ActionPerformed

    private void b68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b68ActionPerformed
        // TODO add your handling code here:
        next_move(6, 8);
    }//GEN-LAST:event_b68ActionPerformed

    private void b72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b72ActionPerformed
        // TODO add your handling code here:
        next_move(7, 2);
    }//GEN-LAST:event_b72ActionPerformed

    private void b73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b73ActionPerformed
        // TODO add your handling code here:
        next_move(7, 3);
    }//GEN-LAST:event_b73ActionPerformed

    private void b74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b74ActionPerformed
        // TODO add your handling code here:
        next_move(7, 4);
    }//GEN-LAST:event_b74ActionPerformed

    private void b75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b75ActionPerformed
        // TODO add your handling code here:
        next_move(7, 5);
    }//GEN-LAST:event_b75ActionPerformed

    private void b76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b76ActionPerformed
        // TODO add your handling code here:
        next_move(7, 6);
    }//GEN-LAST:event_b76ActionPerformed

    private void b77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b77ActionPerformed
        // TODO add your handling code here:
        next_move(7, 7);
    }//GEN-LAST:event_b77ActionPerformed

    private void b78ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b78ActionPerformed
        // TODO add your handling code here:
        next_move(7, 8);
    }//GEN-LAST:event_b78ActionPerformed

    private void b82ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b82ActionPerformed
        // TODO add your handling code here:
        next_move(8, 2);
    }//GEN-LAST:event_b82ActionPerformed

    private void b83ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b83ActionPerformed
        // TODO add your handling code here:
        next_move(8, 3);
    }//GEN-LAST:event_b83ActionPerformed

    private void b84ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b84ActionPerformed
        // TODO add your handling code here:
        next_move(8, 4);
    }//GEN-LAST:event_b84ActionPerformed

    private void b85ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b85ActionPerformed
        // TODO add your handling code here:
        next_move(8, 5);
    }//GEN-LAST:event_b85ActionPerformed

    private void b86ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b86ActionPerformed
        // TODO add your handling code here:
        next_move(8, 6);
    }//GEN-LAST:event_b86ActionPerformed

    private void b87ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b87ActionPerformed
        // TODO add your handling code here:
        next_move(8, 7);
    }//GEN-LAST:event_b87ActionPerformed

    private void b88ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b88ActionPerformed
        // TODO add your handling code here:
        next_move(8, 8);
    }//GEN-LAST:event_b88ActionPerformed

    private void AIvsHumanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AIvsHumanButtonActionPerformed
        // TODO add your handling code here:
        next_player = 1;
        //AIvsAIButton.setVisible(false);
    }//GEN-LAST:event_AIvsHumanButtonActionPerformed

    private void startGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startGameButtonActionPerformed
        // TODO add your handling code here:
        if (next_player == -5) {
            JOptionPane.showMessageDialog(rootPane, "please select playing mode");
        } else {
            

            
            boardInitialization();
            update();
            showAvailavleMoves(next_player);
            //next_move(validMovesList.get(2).x, validMovesList.get(2).y);
        }
    }//GEN-LAST:event_startGameButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AIvsHumanButton;
    private javax.swing.JLabel BlackScoreLable;
    private javax.swing.JLabel BlueScoreLable;
    private java.awt.Button b11;
    private java.awt.Button b12;
    private java.awt.Button b13;
    private java.awt.Button b14;
    private java.awt.Button b15;
    private java.awt.Button b16;
    private java.awt.Button b17;
    private java.awt.Button b18;
    private java.awt.Button b21;
    private java.awt.Button b22;
    private java.awt.Button b23;
    private java.awt.Button b24;
    private java.awt.Button b25;
    private java.awt.Button b26;
    private java.awt.Button b27;
    private java.awt.Button b28;
    private java.awt.Button b31;
    private java.awt.Button b32;
    private java.awt.Button b33;
    private java.awt.Button b34;
    private java.awt.Button b35;
    private java.awt.Button b36;
    private java.awt.Button b37;
    private java.awt.Button b38;
    private java.awt.Button b41;
    private java.awt.Button b42;
    private java.awt.Button b43;
    private java.awt.Button b44;
    private java.awt.Button b45;
    private java.awt.Button b46;
    private java.awt.Button b47;
    private java.awt.Button b48;
    private java.awt.Button b51;
    private java.awt.Button b52;
    private java.awt.Button b53;
    private java.awt.Button b54;
    private java.awt.Button b55;
    private java.awt.Button b56;
    private java.awt.Button b57;
    private java.awt.Button b58;
    private java.awt.Button b61;
    private java.awt.Button b62;
    private java.awt.Button b63;
    private java.awt.Button b64;
    private java.awt.Button b65;
    private java.awt.Button b66;
    private java.awt.Button b67;
    private java.awt.Button b68;
    private java.awt.Button b71;
    private java.awt.Button b72;
    private java.awt.Button b73;
    private java.awt.Button b74;
    private java.awt.Button b75;
    private java.awt.Button b76;
    private java.awt.Button b77;
    private java.awt.Button b78;
    private java.awt.Button b81;
    private java.awt.Button b82;
    private java.awt.Button b83;
    private java.awt.Button b84;
    private java.awt.Button b85;
    private java.awt.Button b86;
    private java.awt.Button b87;
    private java.awt.Button b88;
    private javax.swing.JLabel current_color_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton startGameButton;
    private javax.swing.JLabel winMessageLable;
    // End of variables declaration//GEN-END:variables

    public void next_move(int i, int j) {
        int player_1, player_2;
        if (next_player == 1) {
            player_1 = 1;
            player_2 = -1;
        } else {

            player_1 = -1;
            player_2 = 1;
        }

        if (boarddata[i][j] == 1 || boarddata[i][j] == -1) {
            return;
        }

        int left_start = -5, right_end = -5, top_start = -5, down_end = -5;
        int left_top_dia_start_row = -5, left_top_dia_start_col = -5, right_top_dia_start_row = -5, right_top_dia_end_col = -5, left_down_dia_end_row = -5, left_down_dia_start_col = -5, right_down_dia_end_row = -5, right_down_dia_end_col = -5;

        //left start
        if (j > 2 && boarddata[i][j - 1] == player_2) {
            for (int col = j - 1; col >= 1; col--) {
                if (boarddata[i][col] == 0) {
                    break;
                }
                if (boarddata[i][col] == player_1) {
                    left_start = col;
                    break;
                }
            }
        }

        for (int p = left_start + 1; p <= j && left_start != -5; p++) {
            boarddata[i][p] = player_1;
        }

        //right end
        if (j <= 6 && boarddata[i][j + 1] == player_2) {
            for (int col = j + 1; col <= 8; col++) {
                if (boarddata[i][col] == 0) {
                    break;
                }
                if (boarddata[i][col] == player_1) {
                    right_end = col;
                    break;
                }
            }
        }

        for (int p = j; p < right_end && right_end != -5; p++) {
            boarddata[i][p] = player_1;
        }

        //top start
        //System.out.println("i="+i+" j="+j);
        if (i > 2 && boarddata[i - 1][j] == player_2) {
            for (int row = i - 1; row >= 1; row--) {
                if (boarddata[row][j] == 0) {
                    break;
                }
                if (boarddata[row][j] == player_1) {
                    top_start = row;
                    //System.out.println("found=" + row);
                    break;
                }
            }
        }

        for (int p = top_start + 1; p <= i && top_start != -5; p++) {
            boarddata[p][j] = player_1;
        }

        //down_end
        if (i <= 6 && boarddata[i + 1][j] == player_2) {
            for (int row = i + 1; row <= 8; row++) {
                if (boarddata[row][j] == 0) {
                    break;
                }
                if (boarddata[row][j] == player_1) {
                    down_end = row;
                    //System.out.println("found=" + row);
                    break;
                }
            }
        }

        for (int p = i; p < down_end && down_end != -5; p++) {
            boarddata[p][j] = player_1;
        }

        //left top dia start
        if (j > 2 && i > 2 && boarddata[i - 1][j - 1] == player_2) {

            for (int col = j - 1, row = i - 1; col >= 1 && row >= 1; col--, row--) {
                if (boarddata[row][col] == 0) {
                    break;
                }
                if (boarddata[row][col] == player_1) {
                    left_top_dia_start_row = row;
                    left_top_dia_start_col = col;
                    break;
                }
            }
        }

        for (int p = left_top_dia_start_row + 1, q = left_top_dia_start_col + 1; p <= i && q <= j && left_top_dia_start_row != -5 && left_top_dia_start_col != -5; p++, q++) {
            boarddata[p][q] = player_1;
        }

        //right down diagonal 
        if (j <= 6 && i <= 6 && boarddata[i + 1][j + 1] == player_2) {

            for (int col = j + 1, row = i + 1; col <= 8 && row <= 8; col++, row++) {
                if (boarddata[row][col] == 0) {
                    break;
                }
                if (boarddata[row][col] == player_1) {
                    right_down_dia_end_row = row;
                    right_down_dia_end_col = col;
                    break;
                }
            }
        }

        for (int p = i, q = j; p < right_down_dia_end_row && q < right_down_dia_end_col && right_down_dia_end_row != -5 && right_down_dia_end_col != -5; p++, q++) {
            boarddata[p][q] = player_1;
        }

        // right top dia 
        if (i > 2 && j <= 6 && boarddata[i - 1][j + 1] == player_2) {

            for (int col = j + 1, row = i - 1; col <= 8 && row >= 1; col++, row--) {
                if (boarddata[row][col] == 0) {
                    break;
                }
                if (boarddata[row][col] == player_1) {
                    right_top_dia_start_row = row;
                    right_top_dia_end_col = col;
                    break;
                }
            }
        }

        for (int p = i, q = j; p > right_top_dia_start_row && q < right_top_dia_end_col && right_top_dia_start_row != -5 && right_top_dia_end_col != -5; p--, q++) {
            boarddata[p][q] = player_1;
        }

        // left down diagonal
        if (i <= 6 && j > 2 && boarddata[i + 1][j - 1] == player_2) {

            for (int col = j - 1, row = i + 1; col >= 1 && row <= 8; col--, row++) {
                if (boarddata[row][col] == 0) {
                    break;
                }
                if (boarddata[row][col] == player_1) {
                    left_down_dia_end_row = row;
                    left_down_dia_start_col = col;
                    break;
                }
            }
        }

        for (int p = i, q = j; p < left_down_dia_end_row && q > left_down_dia_start_col && left_down_dia_end_row != -5 && left_down_dia_start_col != -5; p++, q--) {
            boarddata[p][q] = player_1;
        }

        if (left_start != -5 || right_end != -5 || down_end != -5 || top_start != -5 || left_down_dia_end_row != -5 || left_down_dia_start_col != -5 || left_top_dia_start_col != -5 || left_top_dia_start_row != -5 || right_down_dia_end_col != -5 || right_down_dia_end_row != -5 || right_top_dia_end_col != -5 || right_top_dia_start_row != -5) {
            //buttonbox[i][j].setLabel("#");
            //System.out.println("#");
            if (next_player == 1) {
                next_player = -1;
            } else if (next_player == -1) {
                next_player = 1;
            }
            update();

//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(ReversiBoard.class.getName()).log(Level.SEVERE, null, ex);
//            }
            showAvailavleMoves(next_player);

            boolean isFinished = scoreUpdate();
            if (!isFinished) {
                checkComputerMove();
            } else {
                return;
            }
        }

    }

    private boolean scoreUpdate() {
        //To change body of generated methods, choose Tools | Templates.
        int blackscore = 0, bluescore = 0;
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if (boarddata[i][j] == 1) {
                    blackscore++;
                } else if (boarddata[i][j] == -1) {
                    bluescore++;
                }
            }
        }

        BlackScoreLable.setText("" + blackscore);
        BlueScoreLable.setText("" + bluescore);

        if (blackscore + bluescore == 64) {
            if (blackscore > bluescore) {
                winMessageLable.setText("Black Win");
                winMessageLable.setForeground(Color.red);
            } else {
                winMessageLable.setText("Blue Win");
                winMessageLable.setForeground(Color.blue);
            }
            winMessageLable.setVisible(true);

            return true;
        }

        return false;

    }

    private void checkComputerMove() {
        int maxsize;
        maxsize = validMovesList.size();
        if (maxsize == 0) {
            System.out.println("No move for 'player " + next_player + "'");
            noMoveCount++;
            if (noMoveCount == 2) {
                return;
            }

            if (next_player == 1) {
                next_player = -1;
            } else if (next_player == -1) {
                next_player = 1;
            }

            update();
            showAvailavleMoves(next_player);
            boolean isFinished = scoreUpdate();
            if (!isFinished) {
                checkComputerMove();
                return;
            } else {
                return;
            }
        }
        noMoveCount = 0;
        //System.out.println("maxsize-------------------------------- =" + maxsize);

        if (next_player == -1) {     //this line for 2 player mode

//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(ReversiBoard.class.getName()).log(Level.SEVERE, null, ex);
//            }
            int rowNum, colNum;
            int player1, player2;
            if (next_player == 1) {
                player1 = 1;
                player2 = -1;
            } else {
                player1 = -1;
                player2 = 1;
            }

            MinimaxReversiAgent testAgent = new MinimaxReversiAgent();
            validMoveCell testcell = new validMoveCell();

            testcell = testAgent.max(boarddata, player1, 12, -10000000, 10000000);
            rowNum = testcell.x;
            colNum = testcell.y;

//            int moveNumber = 0 + (int) (Math.random() * maxsize);
//            //System.out.println("moveNumber =" + moveNumber);
//            rowNum = validMovesList.get(moveNumber).x;
//            colNum = validMovesList.get(moveNumber).y;
            //System.out.println("rand row=" + rowNum + " rand col=" + colNum);
            //buttonbox[rowNum][colNum].setLabel("X");
            next_move(rowNum, colNum);

        }
    }


    ArrayList<validMoveCell> validMovesList = new ArrayList<validMoveCell>();

    private void boardInitialization() {
        
        //for(in)
        for(int i=1;i<=8;i++)
        {
            for(int j=1;j<=8;j++)
            {
                boarddata[i][j]=0;
            }
        }
        boarddata[4][4] = -1;
        boarddata[4][5] = 1;
        boarddata[5][4] = 1;
        boarddata[5][5] = -1;
        winMessageLable.setVisible(false);
        
        
    }
    static int[][] boarddata = new int[9][9];
    static int noMoveCount=0;
    static int next_player=-5;

}
