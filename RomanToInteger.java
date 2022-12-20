/**
Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. 
Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same 
principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.
*/



// Weirdly the biggest difference between performance was when I didnt reduce the for loop by putting i-- in the switch cases.
// I dropped the amount the modified cases would add, and then just let the modifier add its own value as well which achieved the 
// same result. This ended up making the runtime drop from 110~ to 6 ms! I asked why on Reddit.

// Holy fuck. So the issue with the speed... Was an uncommented print to console! Going forward, all comments must be commented
// when comparing speed. Fuck me.

// After commenting out the print to console lines of my original solution, it was actually really quick! Not quite as fast, but
// much better than I originally thought.

class Solution {
    public int romanToInt(String x) {

        int total = 0;

        for (int i = x.length() - 1; i >= 0; i--) {
            
            // System.out.println("iterations left: " + i);
            // char last = x.charAt(i);

            // I had a variable here to hold the second last letter, but it was removed by checking to see if i was greater
            // than zero, then getting the char using index position.

            // I removed the variable here and referenced the String index position directly.
            switch(x.charAt(i)) {  

                case 'I': {
                    total += 1;
                    break;
                } 

                case 'V': {
                    if (i > 0 && x.charAt(i - 1) == 'I') {
                        total += 4;
                        i--;
                    } else {
                        total += 5;
                    }
                    break;
                }

                case 'X': {
                    if (i > 0 && x.charAt(i - 1) == 'I') {
                        total += 9;
                        i--;
                    } else {
                        total += 10;
                    }
                    break;
                }

                case 'L': {
                    if (i > 0 && x.charAt(i - 1) == 'X') {
                        total += 40;
                        i--;
                    } else {
                        total += 50;
                    }
                    break;
                }

                case 'C': {
                    if (i > 0 && x.charAt(i - 1) == 'X') {
                        total += 90;
                        i--;
                    } else {
                        total += 100;
                    }
                    break;
                }

                case 'D': {
                    if (i > 0 && x.charAt(i - 1) == 'C') {
                        total += 400;
                        i--;
                    } else {
                        total += 500;
                    }
                    break;
                }

                case 'M': {
                    if (i > 0 && x.charAt(i - 1) == 'C') {
                        total += 900;
                        i--;
                    } else {
                        total += 1000;
                    }
                    break;
                }

            }
            // System.out.println("total: " + total + "\n");

        }

        return total;



        // // This solution works, but it might be a good idea to try a for loop (the top answer uses one.) This will
        // // stop me from rewriting the storage string s repeatedly.
        // int total = 0;
        // String s = x;

        // while (s.length() > 0) {
        //     int sLen = s.length();
        //     char last = s.charAt(sLen - 1);
        //     char secondLast;
        //     if (s.length() > 1) {
        //         secondLast = s.charAt(sLen - 2);
        //     } else {
        //         secondLast = 'O';
        //     }

        //     // System.out.println("last: " + last + "  2last: " + secondLast);

        //     switch(last) {

        //         case 'I': {
        //             total += 1;
        //             s = s.substring(0, sLen - 1);
        //             break;
        //         } 

        //         case 'V': {
        //             if (secondLast == 'I') {
        //                 total += 4;
        //                 s = s.substring(0, sLen - 2);
        //             } else {
        //                 total += 5;
        //                 s = s.substring(0, sLen - 1);
        //             }
        //             break;
        //         }

        //         case 'X': {
        //             if (secondLast == 'I') {
        //                 total += 9;
        //                 s = s.substring(0, sLen - 2);
        //             } else {
        //                 total += 10;
        //                 s = s.substring(0, sLen - 1);
        //             }
        //             break;
        //         }

        //         case 'L': {
        //             if (secondLast == 'X') {
        //                 total += 40;
        //                 s = s.substring(0, sLen - 2);
        //             } else {
        //                 total += 50;
        //                 s = s.substring(0, sLen - 1);
        //             }
        //             break;
        //         }

        //         case 'C': {
        //             if (secondLast == 'X') {
        //                 total += 90;
        //                 s = s.substring(0, sLen - 2);
        //             } else {
        //                 total += 100;
        //                 s = s.substring(0, sLen - 1);
        //             }
        //             break;
        //         }

        //         case 'D': {
        //             if (secondLast == 'C') {
        //                 total += 400;
        //                 s = s.substring(0, sLen - 2);
        //             } else {
        //                 total += 500;
        //                 s = s.substring(0, sLen - 1);
        //             }
        //             break;
        //         }

        //         case 'M': {
        //             if (secondLast == 'C') {
        //                 total += 900;
        //                 s = s.substring(0, sLen - 2);
        //             } else {
        //                 total += 1000;
        //                 s = s.substring(0, sLen - 1);
        //             }
        //             break;
        //         }

        //     }


        // }
        
        // return total;
    }
}
