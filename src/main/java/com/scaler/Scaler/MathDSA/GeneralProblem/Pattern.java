package com.scaler.Scaler.MathDSA.GeneralProblem;

public class Pattern {
    public static void main(String[] args) {
//        Inverted Numeric Pyramid
        int N = 16;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= N - i; j++) {
                System.out.print(j);
                if (j != N - i)
                    System.out.print(" ");
            }
            System.out.println();
        }

        //Leading spaces pyramid
        //____****
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        //Q4. Skip Even Numbers Half Pyramid
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (j % 2 == 0)
                    System.out.print(" ");
                else
                    System.out.print(j);
            }
            System.out.println();
        }

        //Stair Scaler.DSAPraticeInterviewQuestion.Pattern
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //Photo Frame Scaler.DSAPraticeInterviewQuestion.Pattern
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (j == 1 || j == N || i == 1 || i == N) {
                    System.out.print("*");
                } else
                    System.out.print(" ");

            }
            System.out.println();
        }

        //Leading spaces inverted pyramid
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (j < i) {
                    System.out.print(" ");
                } else System.out.print("*");
            }
            System.out.println();
        }

        // Two Line Star Scaler.DSAPraticeInterviewQuestion.Pattern
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (j == 1 || j == N) {
                    System.out.print("*");
                } else
                    System.out.print(" ");

            }
            System.out.println();
        }

        //Inverted Half Pyramid

        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= N - i; j++) {
                System.out.print("*");
                // if(i!=j){
                //     System.out.print(" ");
                // }
            }
            System.out.println();
        }

        //Numeric Stair Scaler.DSAPraticeInterviewQuestion.Pattern
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
                if (i != j) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        //Q4. Full pyramid
        for (int r = 1; r <= N; r++) {
            int totalstar = r;
            int totalspace = N - r;
            for (int space = 1; space <= totalspace; space++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= totalstar; star++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Full Numeric Pyramid

        for (int r = 1; r <= N; r++) {
            int totalstar = 2 * r - 1;
            int totalspace = N - r;
            for (int space = 1; space <= totalspace; space++) {
                System.out.print("0 ");
            }
            int printNo = r;
            for (int star = 1; star <= totalstar; star++) {
                System.out.print(printNo + " ");
                if (star <= totalstar / 2)
                    printNo++;
                else printNo--;
            }
            for (int space = 1; space <= totalspace; space++) {
                System.out.print("0 ");
            }
            System.out.println();
        }

        //Hollow pyramid pattern
        for (int r = 0; r < N; r++) {
            int totalstar = N - r;
            int totalspace = 2 * r;
            for (int star = 1; star <= totalstar; star++) {
                System.out.print("*");
            }
            for (int space = 1; space <= totalspace; space++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= totalstar; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
// Hollow inverted pyramid pattern

        for (int r = 1; r <= N; r++) {
            int star = 2 * r;
            int space = 2 * N - r;
            for (int i = r; i < star; i++) {
                System.out.print("*");
            }
            for (int j = r; j < space; j++) {
                System.out.print(" ");
            }
            for (int k = r; k < star; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //Inverted Full Pyramid
        for (int row = 0; row < N; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(" ");
            }

            for (int k = N - row; k >= 1; k--) {
                System.out.print("* ");
            }
            System.out.println();
        }

        //Half Diamond
        int row = 2 * N - 1;
        for (int i = 1; i <= row; i++) {
            int starcount = i <= N ? i : 2 * N - i;
            for (int j = 1; j <= starcount; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Different Number Triangle

        int val = N;
        for (int r = 1; r <= N; r++) {
            int spaceCount = N - r;
            int starcount = 2 * r - 1;
            for (int space = 1; space <= spaceCount; space++) {
                System.out.print("0 ");
            }
            for (int star = 1; star <= starcount; star++) {
                System.out.print(val * star + " ");
            }
            val--;
            for (int space = 1; space <= spaceCount; space++) {
                System.out.print("0 ");
            }
            System.out.println();
        }

        //Scaler.DSAPraticeInterviewQuestion.Pattern 20826
        int space = 2;
        N = space + 2;
        for (row = 0; row < space; row++) {
            for (int col = 1; col <= N - row; col++) {
                if (col == 1 || col == N - row) {
                    System.out.print("*");
                } else
                    System.out.print(" ");

            }
            System.out.println();
        }
    }
}
