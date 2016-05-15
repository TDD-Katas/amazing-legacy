package ro.bad; /**
 * + The original program is by Jack Hauber, and the source is
 * "Basic Computer Games." Used with permission of David Ahl;
 * see www.SwapMeetDave.com.
 * + This exercise was inspired by Alan Hensel's use of Amazing
 * as a refactoring challenge.
 * + This transliteration to Java was created by Bill Wake, William.Wake@acm.org
 */

import java.util.Random;

public class Amazing {
    private Random random;

    public Amazing(int seed) {
        random = new Random(seed);
    }

    public String doit(int horizontal, int vertical) {
        StringBuilder result = new StringBuilder();
        result.setLength(0);
        result.append("Amazing - Copyright by Creative Computing, Morristown, NJ");
        result.append("\n");

        int h = horizontal;
        int v = vertical;
        if (h == 1 || v == 1) {
            return result.toString();
        }

        int[][] wArray = new int[h + 1][v + 1];
        for (int i = 0; i <= h; i++) {
            wArray[i] = new int[v + 1];
        }

        int[][] vArray = new int[h + 1][v + 1];
        for (int i = 0; i <= h; i++) {
            vArray[i] = new int[v + 1];
        }

        int q = 0;
        int z = 0;
        int x = (int) (h * random.nextFloat()) + 1;

        // 130:170
        for (int i = 1; i <= h; i++) {
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
        int r = x;
        int s = 1;
        int target = 270;

        boolean shouldContinue = true;


        while (shouldContinue) {
            switch (target) {
                case 210:
                    if (r != h) {
                        target = 250;
                    } else {
                        target = 220;
                    }
                    continue;
                case 220:
                    if (s != v) {
                        target = 240;
                    } else {
                        target = 230;
                    }
                    continue;
                case 230:
                    r = 1;
                    s = 1;
                    target = 260;
                    continue;
                case 240:
                    r = 1;
                    s++;
                    target = 260;
                    continue;
                case 250:
                    r++;
                    target = 260;
                    continue;
                case 260:
                    if (wArray[r][s] == 0) {
                        target = 210;
                    } else {
                        target = 270;
                    }
                    continue;
                case 270:
                    if (r - 1 == 0) {
                        target = 600;
                    } else {
                        target = 280;
                    }
                    continue;
                case 280:
                    if (wArray[r - 1][s] != 0) {
                        target = 600;
                    } else {
                        target = 290;
                    }
                    continue;
                case 290:
                    if (s - 1 == 0) {
                        target = 430;
                    } else {
                        target = 300;
                    }
                    continue;
                case 300:
                    if (wArray[r][s - 1] != 0) {
                        target = 430;
                    } else {
                        target = 310;
                    }
                    continue;
                case 310:
                    if (r == h) {
                        target = 350;
                    } else {
                        target = 320;
                    }
                    continue;
                case 320:
                    if (wArray[r + 1][s] != 0) {
                        target = 350;
                    } else {
                        target = 330;
                    }
                    continue;
                case 330:
                    x = (int) (3 * random.nextFloat()) + 1;
                    target = 340;
                    continue;
                case 340:
                    if (x == 1) {
                        wArray[r - 1][s] = c;
                        c++;
                        vArray[r - 1][s] = 2;
                        r--;
                        target = 960;
                    } else if (x == 2) {
                        wArray[r][s - 1] = c;
                        c++;
                        target = 1000;
                    } else {
                        wArray[r + 1][s] = c;
                        target = 1030;
                    }
                    continue;
                case 350:
                    if (s != v) {
                        target = 380;
                    } else {
                        target = 360;
                    }
                    continue;
                case 360:
                    if (z == 1) {
                        x = (int) (2 * random.nextFloat()) + 1;
                        target = 420;
                    } else {
                        q = 1;
                        x = (int) (3 * random.nextFloat()) + 1;
                        target = 400;
                    }
                    continue;
                case 380:
                    if (wArray[r][s + 1] != 0) {
                        x = (int) (2 * random.nextFloat()) + 1;
                        target = 420;
                    } else {
                        x = (int) (3 * random.nextFloat()) + 1;
                        target = 400;
                    }
                    continue;
                case 400:
                    if (x == 1) {
                        wArray[r - 1][s] = c;
                        c++;
                        vArray[r - 1][s] = 2;
                        r--;
                        target = 960;
                    } else if (x == 2) {
                        wArray[r][s - 1] = c;
                        c++;
                        target = 1000;
                    } else {
                        target = 1090;
                    }
                    continue;
                case 420:
                    if (x == 1) {
                        wArray[r - 1][s] = c;
                        c++;
                        vArray[r - 1][s] = 2;
                        r--;
                        target = 960;
                    } else {
                        wArray[r][s - 1] = c;
                        c++;
                        target = 1000;
                    }
                    continue;
                case 430:
                    if (r == h) {
                        target = 530;
                    } else {
                        target = 440;
                    }
                    continue;
                case 440:
                    if (wArray[r + 1][s] != 0) {
                        target = 530;
                    } else {
                        target = 450;
                    }
                    continue;
                case 450:
                    if (s != v) {
                        target = 480;
                    } else {
                        target = 460;
                    }
                    continue;
                case 460:
                    if (z == 1) {
                        x = (int) (2 * random.nextFloat()) + 1;
                        target = 520;
                    } else {
                        target = 470;
                    }
                    continue;
                case 470:
                    q = 1;
                    x = (int) (3 * random.nextFloat()) + 1;
                    target = 500;
                    continue;
                case 480:
                    if (wArray[r][s + 1] != 0) {
                        x = (int) (2 * random.nextFloat()) + 1;
                        target = 520;
                    } else {
                        x = (int) (3 * random.nextFloat()) + 1;
                        target = 500;
                    }
                    continue;
                case 500:
                    if (x == 1) {
                        wArray[r - 1][s] = c;
                        c++;
                        vArray[r - 1][s] = 2;
                        r--;
                        target = 960;
                    } else if (x == 2) {
                        wArray[r + 1][s] = c;
                        target = 1030;
                    } else {
                        target = 1090;
                    }
                    continue;
                case 520:
                    if (x == 1) {
                        wArray[r - 1][s] = c;
                        c++;
                        vArray[r - 1][s] = 2;
                        r--;
                        target = 960;
                    } else {
                        wArray[r + 1][s] = c;
                        target = 1030;
                    }
                    continue;
                case 530:
                    if (s != v) {
                        target = 560;
                    } else {
                        target = 540;
                    }
                    continue;
                case 540:
                    if (z == 1) {
                        wArray[r - 1][s] = c;
                        c++;
                        vArray[r - 1][s] = 2;
                        r--;
                        target = 960;
                    } else {
                        q = 1;
                        x = (int) (2 * random.nextFloat()) + 1;
                        target = 580;
                    }
                    continue;
                case 560:
                    if (wArray[r][s + 1] != 0) {
                        wArray[r - 1][s] = c;
                        c++;
                        vArray[r - 1][s] = 2;
                        r--;
                        target = 960;
                    } else {
                        x = (int) (2 * random.nextFloat()) + 1;
                        target = 580;
                    }
                    continue;
                case 580:
                    if (x == 1) {
                        wArray[r - 1][s] = c;
                        c++;
                        vArray[r - 1][s] = 2;
                        r--;
                        target = 960;
                    } else {
                        target = 1090;
                    }
                    continue;
                case 600:
                    if (s - 1 == 0) {
                        target = 790;
                    } else {
                        target = 610;
                    }
                    continue;
                case 610:
                    if (wArray[r][s - 1] != 0) {
                        target = 790;
                    } else {
                        target = 620;
                    }
                    continue;
                case 620:
                    if (r == h) {
                        target = 720;
                    } else {
                        target = 630;
                    }
                    continue;
                case 630:
                    if (wArray[r + 1][s] != 0) {
                        target = 720;
                    } else {
                        target = 640;
                    }
                    continue;
                case 640:
                    if (s != v) {
                        target = 670;
                    } else {
                        target = 650;
                    }
                    continue;
                case 650:
                    if (z == 1) {
                        x = (int) (2 * random.nextFloat()) + 1;
                        target = 710;
                    } else {
                        q = 1;
                        x = (int) (3 * random.nextFloat()) + 1;
                        target = 690;
                    }
                    continue;
                case 670:
                    if (wArray[r][s + 1] != 0) {
                        x = (int) (2 * random.nextFloat()) + 1;
                        target = 710;
                    } else {
                        x = (int) (3 * random.nextFloat()) + 1;
                        target = 690;
                    }
                    continue;
                case 690:
                    if (x == 1) {
                        wArray[r][s - 1] = c;
                        c++;
                        target = 1000;
                    } else if (x == 2) {
                        wArray[r + 1][s] = c;
                        target = 1030;
                    } else {
                        target = 1090;
                    }
                    continue;
                case 710:
                    if (x == 1) {
                        wArray[r][s - 1] = c;
                        c++;
                        target = 1000;
                    } else {
                        wArray[r + 1][s] = c;
                        target = 1030;
                    }
                    continue;
                case 720:
                    if (s != v) {
                        target = 750;
                    } else {
                        target = 730;
                    }
                    continue;
                case 730:
                    if (z == 1) {
                        wArray[r][s - 1] = c;
                        c++;
                        target = 1000;
                    } else {
                        q = 1;
                        x = (int) (2 * random.nextFloat()) + 1;
                        target = 770;
                    }
                    continue;
                case 750:
                    if (wArray[r][s + 1] != 0) {
                        wArray[r][s - 1] = c;
                        c++;
                        target = 1000;
                    } else {
                        x = (int) (2 * random.nextFloat()) + 1;
                        target = 770;
                    }
                    continue;
                case 770:
                    if (x == 1) {
                        wArray[r][s - 1] = c;
                        c++;
                        target = 1000;
                    } else {
                        target = 1090;
                    }
                    continue;
                case 790:
                    if (r == h) {
                        target = 880;
                    } else {
                        target = 800;
                    }
                    continue;
                case 800:
                    if (wArray[r + 1][s] != 0) {
                        target = 880;
                    } else {
                        target = 810;
                    }
                    continue;
                case 810:
                    if (s != v) {
                        target = 840;
                    } else {
                        target = 820;
                    }
                    continue;
                case 820:
                    if (z == 1) {
                        wArray[r + 1][s] = c;
                        target = 1030;
                    } else {
                        q = 1;
                        c++;
                        target = 1000;
                    }
                    continue;
                case 840:
                    if (wArray[r][s + 1] != 0) {
                        wArray[r + 1][s] = c;
                        target = 1030;
                    } else {
                        x = (int) (2 * random.nextFloat()) + 1;
                        target = 860;
                    }
                    continue;
                case 860:
                    if (x == 1) {
                        wArray[r + 1][s] = c;
                        target = 1030;
                    } else {
                        target = 1090;
                    }
                    continue;
                case 880:
                    if (s != v) {
                        target = 910;
                    } else {
                        target = 890;
                    }
                    continue;
                case 890:
                    if (z == 1) {
                        target = 210;
                    } else {
                        q = 1;
                        target = 1090;
                    }
                    continue;
                case 910:
                    if (wArray[r][s + 1] != 0) {
                        target = 210;
                    } else {
                        target = 1090;
                    }
                    continue;
                case 960:
                    if (c == h * v + 1) {
                        shouldContinue = false;
                    } else {
                        q = 0;
                        target = 270;
                        continue;
                    }
                    continue;
                case 1000:
                    vArray[r][s - 1] = 1;
                    s--;
                    if (c == h * v + 1) {
                        shouldContinue = false;
                    } else {
                        q = 0;
                        target = 270;
                    }
                    continue;
                case 1030:
                    c++;
                    if (vArray[r][s] == 0) {
                        vArray[r][s] = 2;
                    } else {
                        vArray[r][s] = 3;
                    }
                    r++;
                    target = 1070;
                    continue;
                case 1070:
                    if (c == h * v + 1) {
                        shouldContinue = false;
                    } else {
                        target = 600;
                    }
                    continue;
                case 1090:
                    if (q == 1) {
                        z = 1;
                        target = 1160;
                    } else {
                        target = 1100;
                    }
                    continue;
                case 1100:
                    wArray[r][s + 1] = c;
                    c++;
                    if (vArray[r][s] == 0) {
                        vArray[r][s] = 1;
                    } else {
                        vArray[r][s] = 3;
                    }
                    target = 1130;
                    continue;
                case 1130:
                    s++;
                    if (c == v * h + 1) {
                        shouldContinue = false;
                    } else {
                        target = 270;
                    }
                    continue;
                case 1160:
                    if (vArray[r][s] == 0) {
                        vArray[r][s] = 1;
                        q = 0;
                        r = 1;
                        s = 1;
                        target = 260;
                    } else {
                        vArray[r][s] = 3;
                        q = 0;
                        target = 210;
                    }
                    continue;
                default:
                    throw new IllegalStateException("Boom");
            }

        }

        // 1200:
        for (int j = 1; j <= v; j++) {
            result.append("I");

            for (int i = 1; i <= h; i++) {
                if (vArray[i][j] >= 2) {
                    result.append("   ");
                } else {
                    result.append("  I");
                }
            }

            result.append(" ");
            result.append("\n");

            for (int i = 1; i <= h; i++) {
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
}
