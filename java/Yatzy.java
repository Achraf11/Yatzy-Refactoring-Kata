            import java.util.Arrays;

            public class Yatzy {
                protected int[] dice;

                public static int chance(int d1, int d2, int d3, int d4, int d5) {
                    return d1 + d2 + d3 + d4 + d5;
                }

                public static int yatzy(int... dice) {
                    // Pas besoin de parcourir le tableau, On aura le resultat 50 seulement si on a une sequence(dice) de meme entier
                    for (int i = 1; i != 5 ; i++)
                        if (dice[i-1] != dice[i] )
                            return 0;
                        return 50;
                }

                public Yatzy(int d1, int d2, int d3, int d4, int d5) {
                    dice = new int[5];
                    dice = new int[]{d1,d2,d3,d4,d5};
                }

                public static int ones(int d1, int d2, int d3, int d4, int d5) {
                    int sum = sommeIndiceParam(d1, d2, d3, d4, d5, 1);
                    return sum;
                }

                public static int twos(int d1, int d2, int d3, int d4, int d5) {
                    int sum = sommeIndiceParam(d1, d2, d3, d4, d5, 2);
                    return sum;
                }

                public static int threes(int d1, int d2, int d3, int d4, int d5) {
                    int s = sommeIndiceParam(d1, d2, d3, d4, d5, 3);
                    return s;
                }

                public int fours()
                {
                    int sum = sommeIndiceTab(4);
                    return sum;
                }

                public int fives()
                {
                    int sum = sommeIndiceTab(5);
                    return sum;
                }

                public int sixes()
                {
                    int sum = sommeIndiceTab(6);
                    return sum;
                }

                public static int sommeIndiceParam(int d1, int d2, int d3, int d4, int d5, int j) {
                    int s = 0;
                    if (d1 == j) s += j;
                    if (d2 == j) s += j;
                    if (d3 == j) s += j;
                    if (d4 == j) s += j;
                    if (d5 == j) s += j;
                    return s;
                }

                public int sommeIndiceTab(int j)
                {
                    int s = 0;
                    for (int i = 0; i < dice.length; i++)
                        if (dice[i] == j)
                            s = s + j;
                    return s;
                }

                    public static int[] initialiserTab(int d1, int d2, int d3, int d4, int d5) {
                    int[] counts = new int[6];
                    try {
                        counts[d1 - 1]++;
                        counts[d2 - 1]++;
                        counts[d3 - 1]++;
                        counts[d4 - 1]++;
                        counts[d5 - 1]++;
                    } catch(ArrayIndexOutOfBoundsException e) {
                        System.out.println("index tableau non trouve" + e);
                    }
                    return counts;
                }
                public static int score_pair(int d1, int d2, int d3, int d4, int d5)
                {
                    int[] counts = initialiserTab(d1, d2, d3, d4, d5);
                    for (int at = 0; at != 6; at++)
                        if (counts[5-at] >= 2)
                            return (6-at)*2;
                    return 0;
                }

                public static int two_pair(int d1, int d2, int d3, int d4, int d5)
                {
                    int n = 0, score = 0;
                    int[] counts = initialiserTab(d1, d2, d3, d4, d5);
                    for (int i = 0; i < 6; i += 1)
                        if (counts[5-i] >= 2) {
                            n++;
                            score += (6-i);
                        }
                    if (n == 2)
                        return score * 2;
                    else
                        return 0;
                }

                public static int four_of_a_kind(int d1, int d2, int d3, int d4, int d5)
                {
                    int[] tallies = initialiserTab(d1, d2, d3, d4, d5);
                    for (int i = 0; i < 6; i++)
                        if (tallies[i] >= 4)
                            return (i+1) * 4;
                    return 0;
                }

                public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5)
                {
                    int[] t = initialiserTab(d1, d2, d3, d4, d5);
                    for (int i = 0; i < 6; i++)
                        if (t[i] >= 3)
                            return (i+1) * 3;
                    return 0;
                }

                public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
                {
                    int[] tallies = initialiserTab(d1, d2, d3, d4, d5);
                    if (tallies[0] == 1 && tallies[1] == 1 && tallies[2] == 1 && tallies[3] == 1 && tallies[4] == 1)
                        return 15;
                    return 0;
                }

                public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
                {
                    int[] tallies = initialiserTab(d1, d2, d3, d4, d5);
                    if (tallies[1] == 1 && tallies[2] == 1 && tallies[3] == 1 && tallies[4] == 1 && tallies[5] == 1)
                        return 20;
                    return 0;
                }

                public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
                {
                    int[] tallies = initialiserTab(d1, d2, d3, d4, d5);
                    int i, j = 0, k = 0;
                    boolean a= false, b = false;

                    for (i = 0; i != 6; i += 1)
                        if (tallies[i] == 2) {
                            a = true;
                            j = i+1;
                        } else if(tallies[i] == 3) {
                            b = true;
                            k = i+1;
                        }

                    if (a && b)
                        return j * 2 + k * 3;
                    else
                        return 0;
                }
            }



