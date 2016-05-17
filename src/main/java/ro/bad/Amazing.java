package ro.bad;

/**
 * + The original program is by Jack Hauber, and the source is
 * "Basic Computer Games." Used with permission of David Ahl;
 * see www.SwapMeetDave.com.
 * + This exercise was inspired by Alan Hensel's use of Amazing
 * as a refactoring challenge.
 * + This transliteration to Java was created by Bill Wake, William.Wake@acm.org
 *
 * http://xp123.com/articles/refactoring-challenge-the-amazing-maze/
 */

import java.util.Random;

public class Amazing {
    private Random random;

    public Amazing(int seed) {
        random = new Random(seed);
    }

    public String doit(int noCols, int noRows) {
        StringBuilder result = new StringBuilder();
        result.setLength(0);
        result.append("Amazing - Copyright by Creative Computing, Morristown, NJ");
        result.append("\n");

        if (noCols == 1 || noRows == 1) {
            return result.toString();
        }

        int[][] wArray = new int[noCols + 1][noRows + 1];
        for (int i = 0; i <= noCols; i++) {
            wArray[i] = new int[noRows + 1];
        }

        int[][] vArray = new int[noCols + 1][noRows + 1];
        for (int i = 0; i <= noCols; i++) {
            vArray[i] = new int[noRows + 1];
        }

        int q = 0;
        int z = 0;
        int x = rand(noCols);

        // 130:170
        for (int i = 1; i <= noCols; i++) {
            if (i == x) {
                result.append(":  ");
            } else {
                result.append(":--");
            }
        }
        // 180
        result.append(":");
        result.append("\n");

        // 190
        int c = 1;
        wArray[x][1] = c;
        c++;

        // 200
        int col = x;
        int row = 1;
        int target = 270;

        boolean shouldContinue = true;


        while (shouldContinue) {
            switch (target) {
                case 210:
                    if (col != noCols) {
                        col++;
                    } else {
                        if (row != noRows) {
                            col = 1;
                            row++;
                        } else {
                            col = 1;
                            row = 1;
                        }
                    }
                    target = 260;
                    continue;
                case 260:
                    if (wArray[col][row] == 0) {
                        target = 210;
                    } else {
                        target = 270;
                    }
                    continue;
                case 270:
                    if (col - 1 == 0) {
                        target = 600;
                    } else {
                        if (wArray[col - 1][row] != 0) {
                            target = 600;
                        } else {
                            if (row - 1 == 0) {
                                target = 430;
                            } else {
                                if (wArray[col][row - 1] != 0) {
                                    target = 430;
                                } else {
                                    if (col == noCols) {
                                        target = 350;
                                    } else {
                                        if (wArray[col + 1][row] != 0) {
                                            target = 350;
                                        } else {
                                            x = rand(3);
                                            if (x == 1) {
                                                wArray[col - 1][row] = c;
                                                c++;
                                                vArray[col - 1][row] = 2;
                                                col--;
                                                target = 960;
                                            } else if (x == 2) {
                                                wArray[col][row - 1] = c;
                                                c++;
                                                target = 1000;
                                            } else {
                                                wArray[col + 1][row] = c;
                                                target = 1030;
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }
                    continue;
                case 350:
                    if (row != noRows) {
                        if (wArray[col][row + 1] != 0) {
                            x = rand(2);
                            target = 420;
                        } else {
                            x = rand(3);
                            target = 400;
                        }
                    } else {
                        if (z == 1) {
                            x = rand(2);
                            target = 420;
                        } else {
                            q = 1;
                            x = rand(3);
                            target = 400;
                        }
                    }
                    continue;
                case 400:
                    if (x == 1) {
                        wArray[col - 1][row] = c;
                        c++;
                        vArray[col - 1][row] = 2;
                        col--;
                        target = 960;
                    } else if (x == 2) {
                        wArray[col][row - 1] = c;
                        c++;
                        target = 1000;
                    } else {
                        target = 1090;
                    }
                    continue;
                case 420:
                    if (x == 1) {
                        wArray[col - 1][row] = c;
                        c++;
                        vArray[col - 1][row] = 2;
                        col--;
                        target = 960;
                    } else {
                        wArray[col][row - 1] = c;
                        c++;
                        target = 1000;
                    }
                    continue;
                case 430:
                    if (col == noCols) {
                        target = 530;
                    } else {
                        if (wArray[col + 1][row] != 0) {
                            target = 530;
                        } else {
                            if (row != noRows) {
                                if (wArray[col][row + 1] != 0) {
                                    x = rand(2);
                                    target = 520;
                                } else {
                                    x = rand(3);
                                    target = 500;
                                }
                            } else {
                                if (z == 1) {
                                    x = rand(2);
                                    target = 520;
                                } else {
                                    q = 1;
                                    x = rand(3);
                                    target = 500;
                                }
                            }
                        }
                    }
                    continue;
                case 500:
                    if (x == 1) {
                        wArray[col - 1][row] = c;
                        c++;
                        vArray[col - 1][row] = 2;
                        col--;
                        target = 960;
                    } else if (x == 2) {
                        wArray[col + 1][row] = c;
                        target = 1030;
                    } else {
                        target = 1090;
                    }
                    continue;
                case 520:
                    if (x == 1) {
                        wArray[col - 1][row] = c;
                        c++;
                        vArray[col - 1][row] = 2;
                        col--;
                        target = 960;
                    } else {
                        wArray[col + 1][row] = c;
                        target = 1030;
                    }
                    continue;
                case 530:
                    if (row != noRows) {
                        if (wArray[col][row + 1] != 0) {
                            wArray[col - 1][row] = c;
                            c++;
                            vArray[col - 1][row] = 2;
                            col--;
                            target = 960;
                        } else {
                            x = rand(2);
                            target = 580;
                        }
                    } else {
                        if (z == 1) {
                            wArray[col - 1][row] = c;
                            c++;
                            vArray[col - 1][row] = 2;
                            col--;
                            target = 960;
                        } else {
                            q = 1;
                            x = rand(2);
                            target = 580;
                        }
                    }
                    continue;
                case 580:
                    if (x == 1) {
                        wArray[col - 1][row] = c;
                        c++;
                        vArray[col - 1][row] = 2;
                        col--;
                        target = 960;
                    } else {
                        target = 1090;
                    }
                    continue;
                case 600:
                    if (row - 1 == 0) {
                        target = 790;
                    } else {
                        if (wArray[col][row - 1] != 0) {
                            target = 790;
                        } else {
                            if (col == noCols) {
                                target = 720;
                            } else {
                                if (wArray[col + 1][row] != 0) {
                                    target = 720;
                                } else {
                                    if (row != noRows) {
                                        if (wArray[col][row + 1] != 0) {
                                            x = rand(2);
                                            target = 710;
                                        } else {
                                            x = rand(3);
                                            target = 690;
                                        }
                                    } else {
                                        if (z == 1) {
                                            x = rand(2);
                                            target = 710;
                                        } else {
                                            q = 1;
                                            x = rand(3);
                                            target = 690;
                                        }
                                    }
                                }
                            }
                        }

                    }
                    continue;
                case 690:
                    if (x == 1) {
                        wArray[col][row - 1] = c;
                        c++;
                        target = 1000;
                    } else if (x == 2) {
                        wArray[col + 1][row] = c;
                        target = 1030;
                    } else {
                        target = 1090;
                    }
                    continue;
                case 710:
                    if (x == 1) {
                        wArray[col][row - 1] = c;
                        c++;
                        target = 1000;
                    } else {
                        wArray[col + 1][row] = c;
                        target = 1030;
                    }
                    continue;
                case 720:
                    if (row != noRows) {
                        if (wArray[col][row + 1] != 0) {
                            wArray[col][row - 1] = c;
                            c++;
                            target = 1000;
                        } else {
                            x = rand(2);
                            target = 770;
                        }
                    } else {
                        if (z == 1) {
                            wArray[col][row - 1] = c;
                            c++;
                            target = 1000;
                        } else {
                            q = 1;
                            x = rand(2);
                            target = 770;
                        }
                    }
                    continue;
                case 770:
                    if (x == 1) {
                        wArray[col][row - 1] = c;
                        c++;
                        target = 1000;
                    } else {
                        target = 1090;
                    }
                    continue;
                case 790:
                    if (col == noCols) {
                        target = 880;
                    } else {
                        if (wArray[col + 1][row] != 0) {
                            target = 880;
                        } else {
                            if (row != noRows) {
                                if (wArray[col][row + 1] != 0) {
                                    wArray[col + 1][row] = c;
                                    target = 1030;
                                } else {
                                    x = rand(2);
                                    if (x == 1) {
                                        wArray[col + 1][row] = c;
                                        target = 1030;
                                    } else {
                                        target = 1090;
                                    }
                                }
                            } else {
                                if (z == 1) {
                                    wArray[col + 1][row] = c;
                                    target = 1030;
                                } else {
                                    q = 1;
                                    c++;
                                    target = 1000;
                                }
                            }
                        }
                    }
                    continue;
                case 880:
                    if (row != noRows) {
                        if (wArray[col][row + 1] != 0) {
                            target = 210;
                        } else {
                            target = 1090;
                        }
                    } else {
                        if (z == 1) {
                            target = 210;
                        } else {
                            q = 1;
                            target = 1090;
                        }
                    }
                    continue;
                case 960:
                    if (c == noCols * noRows + 1) {
                        shouldContinue = false;
                    } else {
                        q = 0;
                        target = 270;
                        continue;
                    }
                    continue;
                case 1000:
                    vArray[col][row - 1] = 1;
                    row--;
                    if (c == noCols * noRows + 1) {
                        shouldContinue = false;
                    } else {
                        q = 0;
                        target = 270;
                    }
                    continue;
                case 1030:
                    c++;
                    if (vArray[col][row] == 0) {
                        vArray[col][row] = 2;
                    } else {
                        vArray[col][row] = 3;
                    }
                    col++;
                    if (c == noCols * noRows + 1) {
                        shouldContinue = false;
                    } else {
                        target = 600;
                    }
                    continue;
                case 1090:
                    if (q == 1) {
                        z = 1;
                        if (vArray[col][row] == 0) {
                            vArray[col][row] = 1;
                            q = 0;
                            col = 1;
                            row = 1;
                            target = 260;
                        } else {
                            vArray[col][row] = 3;
                            q = 0;
                            target = 210;
                        }
                    } else {
                        wArray[col][row + 1] = c;
                        c++;
                        if (vArray[col][row] == 0) {
                            vArray[col][row] = 1;
                        } else {
                            vArray[col][row] = 3;
                        }
                        row++;
                        if (c == noRows * noCols + 1) {
                            shouldContinue = false;
                        } else {
                            target = 270;
                        }
                    }
                    continue;
                default:
                    throw new IllegalStateException("Boom");
            }

        }

        // 1200:
        for (int j = 1; j <= noRows; j++) {
            result.append("I");

            for (int i = 1; i <= noCols; i++) {
                if (vArray[i][j] >= 2) {
                    result.append("   ");
                } else {
                    result.append("  I");
                }
            }

            result.append(" ");
            result.append("\n");

            // 0 = HAS_ROW_AND_COL
            // 1 = HAS_COL
            // 2 = HAS_ROW
            // 3 = EMPTY
            for (int i = 1; i <= noCols; i++) {
                if (vArray[i][j] == 0) {
                    result.append(":--");
                } else if (vArray[i][j] == 2) {
                    result.append(":--");
                } else {
                    result.append(":  ");
                }
            }

            result.append(":");
            result.append("\n");
        }

        return result.toString();
    }

    private int rand(int noCols) {
        return (int) (noCols * random.nextFloat()) + 1;
    }
}
