// #357. Count Numbers with Unique Digits

// cant believe it was a medium tag problem, had 5 hints and related topics where: dp, backtracking and math.


class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n== 0) return 1;
        else if(n== 1) return 10;
        else if(n== 2) return 91;
        else if(n== 3) return 9*9*8+ 91;
        else if(n== 4) return 9*9*8*7 +9*9*8+ 91;
        else if(n== 5) return 9*9*8*7*6 +9*9*8*7 +9*9*8+ 91;
        else if(n== 6) return 9*9*8*7*6*5 +9*9*8*7*6 +9*9*8*7 +9*9*8+ 91;
        else if(n== 7) return 9*9*8*7*6*5*4 +9*9*8*7*6*5 +9*9*8*7*6 +9*9*8*7 +9*9*8+ 91;
        else return 9*9*8*7*6*5*4*3+ 9*9*8*7*6*5*4 +9*9*8*7*6*5 +9*9*8*7*6 +9*9*8*7 +9*9*8+ 91;
    }
}

/*
    We need to count all the numbers which have unique digits.
    1 digit: 10
    2 digit: 9*9
    equals= 91 ans;
*/
