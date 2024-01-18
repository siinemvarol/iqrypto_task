package com.sinem;

public class Main {
    public static void main(String[] args) {
        byte [][]lands = new byte[][]{{1, 0, 1, 1, 1},
                                      {0, 0, 1, 1, 0},
                                      {0, 1, 0, 0, 0},
                                      {0, 0, 0, 1, 1}};
        isIsland(lands);
    }
    public static void isIsland(byte[][] lands) {
        byte islandCounter = 0;
        byte waterCounter = 0;

        for(int i = 0; i < lands.length; i++) {
            for(int j = 0; j < lands[i].length; j++) {
                if (lands[i][j] == 1) {
                    if (j == 0 || j == 4) {
                        waterCounter++;
                    }
                    if(i == 0 || i == 3) {
                        waterCounter++;
                    }
                    if(j < 4 && lands[i][j+1] == 0) {
                        waterCounter++;
                    }
                    if(j > 0 && lands[i][j-1] == 0) {
                        waterCounter++;
                    }
                    if(i > 0 && lands[i-1][j] == 0) {
                        waterCounter++;
                    }
                    if(i < 3 && lands[i+1][j] == 0) {
                        waterCounter++;
                    }
                //    System.out.println("water counter for lands i " + i + " and j " + j + " is ... " + waterCounter);
                    if(waterCounter == 4) {
                        islandCounter++;
                    } else {
                        if(i > 0) {
                            if(lands[i][j-1] == 0 && lands[i-1][j] == 0) {
                                islandCounter++;
                            }
                        } else {
                            if(lands[i][j-1] == 0) {
                                islandCounter++;
                            }
                        }
                    }
                }
                waterCounter = 0;
            }
        }
        System.out.println("Total island number is... " + islandCounter);
    }
}